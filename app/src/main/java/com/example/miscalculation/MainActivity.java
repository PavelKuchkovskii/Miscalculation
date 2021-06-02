package com.example.miscalculation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;


public class MainActivity extends AppCompatActivity {

//**************************************************************************************************
    public static final String version = "1.05_1";
//**************************************************************************************************

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

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        String[] dtaRegionOnMain = {"РЕГИОНЫ", "МИНСК"};

        final ListView measureLst = findViewById(R.id.listProduct);
        ImageView addMeasure = findViewById(R.id.imAddNew);

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

        //При запуске программы
        if(!startProg) {
            startProg = true;
            File file = getExternalPath();
            //Если нет фала с hashmap - создает такой пустой файл
            if(!file.exists()) {
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

}