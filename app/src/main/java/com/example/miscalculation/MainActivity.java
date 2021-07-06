package com.example.miscalculation;

import android.Manifest;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.GooglePlayServicesAvailabilityIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;


public class MainActivity extends AppCompatActivity
        implements EasyPermissions.PermissionCallbacks{

//==================================GOOGLE==========================================================
    static boolean isOAuth_OK = false;

    static TextView mOutputText;

    ProgressDialog mProgress;
    GoogleAccountCredential mCredential;

    static final int REQUEST_ACCOUNT_PICKER = 1000;
    static final int REQUEST_AUTHORIZATION = 1001;
    static final int REQUEST_GOOGLE_PLAY_SERVICES = 1002;
    static final int REQUEST_PERMISSION_GET_ACCOUNTS = 1003;

    private static final String PREF_ACCOUNT_NAME = "accountName";
    private static final String[] SCOPES = { SheetsScopes.SPREADSHEETS };

//==================================================================================================

    ImageView addMeasure;

    final Context context = this;
    static boolean startProg = false;
    static boolean prodListActivityFlag = true;
    static boolean difName = false;

    static Gson gson = new Gson();

    static String nameMeasure;
    static final String fileName = "dtaHashMap";

    static int positionRegion1;

    static LinkedHashMap<String, Measure> hashMap = new LinkedHashMap<>();

    static ArrayAdapter<String> adapterMeasureLst;
    static List<String> dataMeasureList = new ArrayList<>();

    public AlertDialog.Builder builder;
    public AlertDialog.Builder builder1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOutputText = findViewById(R.id.textOAuth);
        mOutputText.setVisibility(View.INVISIBLE);

        mCredential = GoogleAccountCredential.usingOAuth2(
                getApplicationContext(), Arrays.asList(SCOPES))
                .setBackOff(new ExponentialBackOff());

        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Подключение ...");


        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        String[] dtaRegionOnMain = {"РЕГИОНЫ", "МИНСК"};

        final ListView measureLst = findViewById(R.id.listProduct);
        addMeasure = findViewById(R.id.imAddNew);
        addMeasure.setVisibility(View.INVISIBLE);

        adapterMeasureLst = new ArrayAdapter<>(this, R.layout.mainlistmeausre, MainActivity.dataMeasureList);
        measureLst.setAdapter(adapterMeasureLst);
        ArrayAdapter<String> adapterRegionOnMain = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dtaRegionOnMain);
        adapterRegionOnMain.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Intent changeActivity = new Intent(MainActivity.this, ChangeActivity.class);
        final Intent prodListBut = new Intent(MainActivity.this, ProductList.class);

        //При запуске программы запускает продЛист
        if (prodListActivityFlag) {
            prodListActivityFlag = false;
            startActivity(prodListBut);
        }

        if (!isOAuth_OK) {
            getResultsFromApi();
        }


//---------------------------------------------ЛИСТ----------------------------------------------------------------
        measureLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Внимание!");
                builder.setMessage("Выбрать?");
                builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Внимание!");
                builder1.setMessage("Выбрать?");

                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        ProductList.clearAll();
                        nameMeasure = String.valueOf(dataMeasureList.get(position));
                        hashMap.get(nameMeasure).getProdList();
                        startActivity(changeActivity);
                    }
                });
                builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

                builder.setNeutralButton("Изменить", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        builder1.setPositiveButton("Копировать", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                LayoutInflater li = LayoutInflater.from(context);
                                View promptsView = li.inflate(R.layout.prompt3, null);

                                //Создаем AlertDialog
                                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);
                                //Настраиваем prompt.xml для нашего AlertDialog:
                                mDialogBuilder.setView(promptsView);
                                //Настраиваем отображение поля для ввода текста в открытом диалоге:
                                final EditText userInput = promptsView.findViewById(R.id.input_text);
                                userInput.setText(dataMeasureList.get(position) + " (" + 1 + ")");
                                //Настраиваем сообщение в диалоговом окне:
                                mDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {

                                        //Если поле пустое
                                        if(String.valueOf(userInput.getText()).equals("")) {
                                            Toast toast = Toast.makeText(getApplicationContext(), "Поле не может быть пустым.", Toast.LENGTH_SHORT);
                                            toast.show();
                                        }
                                        //Если названия совпадают
                                        else if (String.valueOf(userInput.getText()).equals(dataMeasureList.get(position))) {
                                            Toast toast = Toast.makeText(getApplicationContext(), "Название должно отличаться", Toast.LENGTH_SHORT);
                                            toast.show();
                                        }
                                        else {
                                            ProductList.clearAll();
                                            nameMeasure = String.valueOf(userInput.getText());
                                            hashMap.put(nameMeasure, new Measure(hashMap.get(dataMeasureList.get(position))));
                                            hashMap.get(nameMeasure).getProdList();
                                            try {
                                                writeHash(hashMap);
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            for(String s : dataMeasureList) {
                                                if(nameMeasure.equals(s)) {
                                                    difName = true;
                                                    break;
                                                }
                                            }
                                            if(!difName){
                                                adapterMeasureLst.add(nameMeasure);
                                            }else {
                                                difName = false;
                                            }
                                            startActivity(changeActivity);
                                        }
                                    }
                                }).setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                                AlertDialog alertDialog = mDialogBuilder.create();
                                alertDialog.show();
                            }
                        });
                        builder1.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                        builder1.setNeutralButton("Удалить", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                hashMap.remove(dataMeasureList.get(position));
                                //Удаляем файл замера из папки приложения(Даже если его нет)
                                File file = getExternalPathToRemove(dataMeasureList.get(position));
                                file.delete();
                                dataMeasureList.remove(position);
                                adapterMeasureLst.notifyDataSetInvalidated();
                                try {
                                    writeHash(hashMap);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                        AlertDialog alert1 = builder1.create();
                        alert1.show();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

//-------------------------------------КНОПКА ДОБАВИТЬ НОВЫЙ ЗАМЕР----------------------------------------------------------------------------------
        addMeasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.startAnimation(animAlpha);

                LayoutInflater liR = LayoutInflater.from(context);
                View promptsViewR = liR.inflate(R.layout.prompt, null);

                //Настраиваем отображение поля выбора региона
                final Spinner spinnerRegion = promptsViewR.findViewById(R.id.spinner_regionOnMain);
                spinnerRegion.setAdapter(adapterRegionOnMain);
                spinnerRegion.setPrompt("Регион");
                spinnerRegion.setSelection(0);
                spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int positionRegion, long idRegion) {
                        positionRegion1 = positionRegion;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                    }
                });

                //Создаем AlertDialog
                AlertDialog.Builder mDialogBuilderR = new AlertDialog.Builder(context);
                //Настраиваем prompt.xml для нашего AlertDialog:
                mDialogBuilderR.setView(promptsViewR);

                //Настраиваем сообщение в диалоговом окне:
                mDialogBuilderR.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {

                        LayoutInflater li = LayoutInflater.from(context);
                        View promptsView = li.inflate(R.layout.prompt3, null);

                        //Создаем AlertDialog
                        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);
                        //Настраиваем prompt.xml для нашего AlertDialog:
                        mDialogBuilder.setView(promptsView);
                        //Настраиваем отображение поля для ввода текста в открытом диалоге:
                        final EditText userInput = promptsView.findViewById(R.id.input_text);

                        //Настраиваем сообщение в диалоговом окне:
                        mDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                if(String.valueOf(userInput.getText()).equals("")) {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Поле не может быть пустым.", Toast.LENGTH_SHORT);
                                    toast.show();
                                }else {
                                    ProductList.clearAll();
                                    nameMeasure = String.valueOf(userInput.getText());
                                    hashMap.put(nameMeasure, new Measure());
                                    hashMap.get(nameMeasure).setRegion(positionRegion1);
                                    try {
                                        writeHash(hashMap);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    for(String s : dataMeasureList) {
                                        if(nameMeasure.equals(s)) {
                                            difName = true;
                                            break;
                                        }
                                    }
                                    if(!difName){
                                        adapterMeasureLst.add(nameMeasure);
                                    }else {
                                        difName = false;
                                    }
                                    startActivity(changeActivity);
                                }
                            }
                        }).setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

                        AlertDialog alertDialog = mDialogBuilder.create();
                        alertDialog.show();

                    }
                }).setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

                AlertDialog alertDialogR = mDialogBuilderR.create();
                alertDialogR.show();

            }
        });
//---------------------------------------------------------------------------------------------------------------------------------
    }

    private File getExternalPath() {
        return new File(getExternalFilesDir(null), fileName);
    }

    private File getExternalPathToRemove(String s) {
        return new File(getExternalFilesDir(null), s);
    }


    // сохранение файла
    public void writeHash(LinkedHashMap<String, Measure> wHashMap) throws IOException {
        FileOutputStream fos = null;

        String json = gson.toJson(hashMap);
        json = gson.toJson(ContinePrice.compress(json));
        fos = new FileOutputStream(getExternalPath());
        fos.write(json.getBytes());
    }

    // открытие файла
    public void readHash() throws IOException {
        Type type = new TypeToken<LinkedHashMap<String, Measure>>(){}.getType();

        FileInputStream fin = null;
        File file = getExternalPath();
        fin =  new FileInputStream(file);
        byte[] bytes = new byte[fin.available()];
        fin.read(bytes);
        String json = new String (bytes);
        byte[] tmpByte = gson.fromJson(json, byte[].class);
        json = new String(uncompress(tmpByte));
        hashMap = gson.fromJson(json, type);
    }

    // распаковать
    public static byte[] uncompress(byte[] data) throws IOException {
        if (data == null || data.length == 0) {
            return data;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        gunzip.close();
        in.close();
        return out.toByteArray();
    }

//===========================АУНТЕНТИФИКАЦИЯ========================================================
    /**
     * Attempt to call the API, after verifying that all the preconditions are
     * satisfied. The preconditions are: Google Play Services installed, an
     * account was selected and the device currently has online access. If any
     * of the preconditions are not satisfied, the app will prompt the user as
     * appropriate.
     */
    @SuppressLint("SetTextI18n")
    private void getResultsFromApi() {
        if (! isGooglePlayServicesAvailable()) {
            acquireGooglePlayServices();
        } else if (mCredential.getSelectedAccountName() == null) {
            chooseAccount();
        } else if (! isDeviceOnline()) {
            mOutputText.setVisibility(View.VISIBLE);
            mOutputText.setText("No network connection available.");
        } else {
            new MakeRequestTask(mCredential).execute();
        }
    }

    /**
     * Attempts to set the account used with the API credentials. If an account
     * name was previously saved it will use that one; otherwise an account
     * picker dialog will be shown to the user. Note that the setting the
     * account to use with the credentials object requires the app to have the
     * GET_ACCOUNTS permission, which is requested here if it is not already
     * present. The AfterPermissionGranted annotation indicates that this
     * function will be rerun automatically whenever the GET_ACCOUNTS permission
     * is granted.
     */
    @AfterPermissionGranted(REQUEST_PERMISSION_GET_ACCOUNTS)
    private void chooseAccount() {
        if (EasyPermissions.hasPermissions(
                this, Manifest.permission.GET_ACCOUNTS)) {
            String accountName = getPreferences(Context.MODE_PRIVATE)
                    .getString(PREF_ACCOUNT_NAME, null);
            if (accountName != null) {
                mCredential.setSelectedAccountName(accountName);
                getResultsFromApi();
            } else {
                // Start a dialog from which the user can choose an account
                startActivityForResult(
                        mCredential.newChooseAccountIntent(),
                        REQUEST_ACCOUNT_PICKER);
            }
        } else {
            // Request the GET_ACCOUNTS permission via a user dialog
            EasyPermissions.requestPermissions(
                    this,
                    "This app needs to access your Google account (via Contacts).",
                    REQUEST_PERMISSION_GET_ACCOUNTS,
                    Manifest.permission.GET_ACCOUNTS);
        }
    }

    /**
     * Called when an activity launched here (specifically, AccountPicker
     * and authorization) exits, giving you the requestCode you started it with,
     * the resultCode it returned, and any additional data from it.
     * @param requestCode code indicating which activity result is incoming.
     * @param resultCode code indicating the result of the incoming
     *     activity result.
     * @param data Intent (containing result data) returned by incoming
     *     activity result.
     */
    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case REQUEST_GOOGLE_PLAY_SERVICES:
                if (resultCode != RESULT_OK) {
                    mOutputText.setVisibility(View.VISIBLE);
                    mOutputText.setText(
                            "This app requires Google Play Services. Please install " +
                                    "Google Play Services on your device and relaunch this app.");
                } else {
                    getResultsFromApi();
                }
                break;
            case REQUEST_ACCOUNT_PICKER:
                if (resultCode == RESULT_OK && data != null &&
                        data.getExtras() != null) {
                    String accountName =
                            data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                    if (accountName != null) {
                        SharedPreferences settings =
                                getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString(PREF_ACCOUNT_NAME, accountName);
                        editor.apply();
                        mCredential.setSelectedAccountName(accountName);
                        getResultsFromApi();
                    }
                }
                break;
            case REQUEST_AUTHORIZATION:
                if (resultCode == RESULT_OK) {
                    getResultsFromApi();
                }
                break;
        }
    }

    /**
     * Respond to requests for permissions at runtime for API 23 and above.
     * @param requestCode The request code passed in
     *     requestPermissions(android.app.Activity, String, int, String[])
     * @param permissions The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     *     which is either PERMISSION_GRANTED or PERMISSION_DENIED. Never null.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(
                requestCode, permissions, grantResults, this);
    }

    /**
     * Callback for when a permission is granted using the EasyPermissions
     * library.
     * @param requestCode The request code associated with the requested
     *         permission
     * @param list The requested permission list. Never null.
     */
    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        // Do nothing.
    }

    /**
     * Callback for when a permission is denied using the EasyPermissions
     * library.
     * @param requestCode The request code associated with the requested
     *         permission
     * @param list The requested permission list. Never null.
     */
    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
        // Do nothing.
    }

    /**
     * Checks whether the device currently has a network connection.
     * @return true if the device has a network connection, false otherwise.
     */
    private boolean isDeviceOnline() {
        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    /**
     * Check that Google Play services APK is installed and up to date.
     * @return true if Google Play Services is available and up to
     *     date on this device; false otherwise.
     */
    private boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability apiAvailability =
                GoogleApiAvailability.getInstance();
        final int connectionStatusCode =
                apiAvailability.isGooglePlayServicesAvailable(this);
        return connectionStatusCode == ConnectionResult.SUCCESS;
    }

    /**
     * Attempt to resolve a missing, out-of-date, invalid or disabled Google
     * Play Services installation via a user dialog, if possible.
     */
    private void acquireGooglePlayServices() {
        GoogleApiAvailability apiAvailability =
                GoogleApiAvailability.getInstance();
        final int connectionStatusCode =
                apiAvailability.isGooglePlayServicesAvailable(this);
        if (apiAvailability.isUserResolvableError(connectionStatusCode)) {
            showGooglePlayServicesAvailabilityErrorDialog(connectionStatusCode);
        }
    }


    /**
     * Display an error dialog showing that Google Play Services is missing
     * or out of date.
     * @param connectionStatusCode code describing the presence (or lack of)
     *     Google Play Services on this device.
     */
    void showGooglePlayServicesAvailabilityErrorDialog(final int connectionStatusCode) {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        Dialog dialog = apiAvailability.getErrorDialog(
                MainActivity.this,
                connectionStatusCode,
                REQUEST_GOOGLE_PLAY_SERVICES);
        dialog.show();
    }

    //Класс где все выполняется---------------------------------------------------------------------
    /**
     * An asynchronous task that handles the Google Sheets API call.
     * Placing the API calls in their own task ensures the UI stays responsive.
     */
    private class MakeRequestTask extends AsyncTask<Void, Void, List<String>> {
        private com.google.api.services.sheets.v4.Sheets mService = null;
        private Exception mLastError = null;

        MakeRequestTask(GoogleAccountCredential credential) {
            HttpTransport transport = AndroidHttp.newCompatibleTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            mService = new com.google.api.services.sheets.v4.Sheets.Builder(
                    transport, jsonFactory, credential)
                    .setApplicationName("Miscalculation")
                    .build();
        }

        /**
         * Background task to call Google Sheets API.
         * @param params no parameters needed for this task.
         */
        @Override
        protected List<String> doInBackground(Void... params) {
            try {
                return getDataFromApi();
            } catch (Exception e) {
                mLastError = e;
                cancel(true);
                return null;
            }
        }

        /**
         * Fetch a list of names and majors of students in a sample spreadsheet:
         * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
         * @return List of names and majors
         * @throws IOException
         */
        private List<String> getDataFromApi() throws IOException {
            String spreadsheetId = "1oC12uKxGidATofdPAuBKNPHcj0VAW9mJGRKtnrbIvU8";
            String range = "Class Data!A1:A";
            List<String> results = new ArrayList<>();
            ValueRange response = this.mService.spreadsheets().values()
                    .get(spreadsheetId, range)
                    .execute();
            List<List<Object>> values = response.getValues();
            if (values != null) {
                for (List row : values) {
                    results.add((String) row.get(0));
                }
            }
            return results;
        }



        @Override
        protected void onPreExecute() {
            mOutputText.setText("");
            mProgress.show();
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(List<String> output) {
            mProgress.hide();
            if (output == null || output.size() == 0) {
                mOutputText.setVisibility(View.VISIBLE);
                mOutputText.setText("No results returned.");
            } else {

                for(String s : output) {
                    if (s.equals(mCredential.getSelectedAccountName())) {
                        isOAuth_OK = true;
                        if (isOAuth_OK) {
                            addMeasure.setVisibility(View.VISIBLE);
                            mOutputText.setVisibility(View.INVISIBLE);
                            //При запуске программы
                            if (!startProg) {
                                startProg = true;
                                File file = getExternalPath();
                                //Если нет фала с hashmap - создает такой пустой файл
                                if (!file.exists()) {
                                    try {
                                        writeHash(hashMap);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                //Если файл существует, то загружает его
                                else {

                                    try {
                                        readHash();
                                    } catch (IOException ignored) {

                                    }
                                    for (String key : hashMap.keySet()) {
                                        dataMeasureList.add(key);
                                        adapterMeasureLst.notifyDataSetInvalidated();
                                    }
                                }
                            }
                            mOutputText.setText("Доступ открыт");
                            return;
                        }
                    }
                }
                mOutputText.setVisibility(View.VISIBLE);
                mOutputText.setText("В доступе отказано");
            }
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onCancelled() {
            mProgress.hide();
            if (mLastError != null) {
                if (mLastError instanceof GooglePlayServicesAvailabilityIOException) {
                    showGooglePlayServicesAvailabilityErrorDialog(
                            ((GooglePlayServicesAvailabilityIOException) mLastError)
                                    .getConnectionStatusCode());
                } else if (mLastError instanceof UserRecoverableAuthIOException) {
                    startActivityForResult(
                            ((UserRecoverableAuthIOException) mLastError).getIntent(),
                            MainActivity.REQUEST_AUTHORIZATION);
                } else {
                    mOutputText.setVisibility(View.VISIBLE);
                    mOutputText.setText("The following error occurred:\n"
                            + mLastError.getMessage());
                }
            } else {
                mOutputText.setVisibility(View.VISIBLE);
                mOutputText.setText("Request cancelled.");
            }
        }
    }

}