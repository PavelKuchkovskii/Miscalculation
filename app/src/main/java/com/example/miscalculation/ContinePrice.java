package com.example.miscalculation;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miscalculation.excelUtill.ExcelCreator;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class ContinePrice extends AppCompatActivity {

    static TextView textPriceOutcome;
    static TextView textPriceR;
    static TextView textDiscont;
    static TextView textPriceOutcomePR;
    static TextView textPriceRPR;
    static TextView textDiscontPR;
    static TextView salary;
    static TextView salaryText;
    static Spinner spinnerPrice;
    static ImageView imSendQr;
    static ImageView imBank;
    static ImageView getSpecificationImage;
    static Button pockets;
    static ListView productList;
    static CheckBox isCheckSalary;
    static CheckBox isCheckStand;
    static boolean isCheckStand1 = true;


    static ArrayAdapter<String> adapterPrice;
    static ArrayAdapter<String> adapterProdLst;

    static List<String> list = new ArrayList<>();


    static int interest;
    static int mounting;
    static int delivery;
    static int other;
    static int plus;
    static int slopes;
    static int discont;
    static double course;
    static double price;

    static int continePriceZh;
    static int continePriceM;

    static int positionPrice1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contineprice);
        String[] dataPrice = {"Ж", "М"};

        final Intent bankActivity = new Intent(ContinePrice.this, Bank.class);
        final Intent pocketActivity = new Intent(ContinePrice.this, PocketsActivity.class);
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        textPriceOutcome = findViewById(R.id.priceAmountContinePrice);
        textPriceR = findViewById(R.id.priceR);
        textDiscont = findViewById(R.id.priceDiscont);
        textPriceOutcomePR = findViewById(R.id.priceAmountContinePricePR);
        textPriceRPR = findViewById(R.id.priceRPR);
        textDiscontPR = findViewById(R.id.priceDiscontPR);
        salary = findViewById(R.id.salaryAmount);
        salaryText = findViewById(R.id.salaryText);

        adapterPrice = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataPrice);
        adapterPrice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterProdLst = new ArrayAdapter<>(this, R.layout.list_item, list);

        spinnerPrice = findViewById(R.id.spinner_price);

        imSendQr = findViewById(R.id.imSendQR);
        imBank = findViewById(R.id.imBank);
        getSpecificationImage = findViewById(R.id.getSpecificationImage);
        getSpecificationImage.setVisibility(View.INVISIBLE);
        if (MainActivity.hashMap.get(MainActivity.nameMeasure).getIsDoSpecification()) {
            getSpecificationImage.setVisibility(View.VISIBLE);
        }

        pockets = findViewById(R.id.button_pockets);

        productList = findViewById(R.id.listProductContinePrice);
        productList.setAdapter(adapterProdLst);

        isCheckSalary = findViewById(R.id.isCheckSalary);
        isCheckStand = findViewById(R.id.isCheckStand);
        isCheckStand.setChecked(MainActivity.hashMap.get(MainActivity.nameMeasure).isStand());
        isCheckStand1 = isCheckStand.isChecked();


//----------------------------------СПИННЕР------------------------------------------------------------------------
        spinnerPrice.setAdapter(adapterPrice);
        // заголовок
        spinnerPrice.setPrompt("Цена");
        // выделяем элемент
        spinnerPrice.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerPrice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionPrice, long idPrice) {
                positionPrice1 = positionPrice;
                setPriceOutcome(positionPrice);
                if(MainActivity.nameMeasure.contains("COMFORTPOCKET") || MainActivity.nameMeasure.contains("PREMIUMPOCKET")) {
                    spinnerPrice.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
//----------------------------------------------------------------------------------------------------------------------------------------------------------------

        imSendQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);

                try {
                    sendMeasure();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
        imBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);

                Bank.setPriceZM( continePriceZh, continePriceM );
                startActivity(bankActivity);

                foLizing();
            }
        });
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
        getSpecificationImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                ExcelCreator ec = MainActivity.hashMap.get(MainActivity.nameMeasure).getExcelCreator();
                int price = positionPrice1 == 0 ? continePriceZh : continePriceM;
                try {
                    sendSpecification(ec, price);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

//----------------------------------------------------------------------------------------------------------------------------------------------------------
        // Создание слушателя для CheckBox
        isCheckSalary.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // Обработка события изменения состояния CheckBox
                if (isChecked) {
                    // Если CheckBox отмечен
                    salaryText.setVisibility(View.VISIBLE);
                    salary.setVisibility(View.VISIBLE);
                } else {
                    // Если CheckBox не отмечен
                    salaryText.setVisibility(View.INVISIBLE);
                    salary.setVisibility(View.INVISIBLE);
                }
            }
        });
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Создание слушателя для CheckBox
        isCheckStand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                isCheckStand1 = isChecked;

                MainActivity.hashMap.get(MainActivity.nameMeasure).setStand(isCheckStand1);
                setPriceOutcome(positionPrice1);
                if(MainActivity.nameMeasure.contains("COMFORTPOCKET") || MainActivity.nameMeasure.contains("PREMIUMPOCKET")) {
                    spinnerPrice.setVisibility(View.INVISIBLE);
                }
            }
        });
//----------------------------------------------------------------------------------------------------------------------------------------------------------------
        pockets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);

                startActivity(pocketActivity);
            }
        });
//----------------------------------------------------------------------------------------------------------------------------------------------------------------

    }


    public static void setContinePrice(List<String> lst, int interest1, int mounting1, int delivery1, int other1, int plus1, int slopes1, double course1, double price1, int discont1) {
        list = lst;
        interest = interest1;
        mounting = mounting1;
        delivery = delivery1;
        other = other1;
        plus = plus1;
        course = course1;
        slopes = slopes1;
        price = price1;
        discont = 100 - discont1;
    }

    public void setPriceOutcome(int i) {

        double standPrice = 0;

        for (int i1 = 0; i1 < MainActivity.hashMap.get(MainActivity.nameMeasure).getItemInfoSize(); i1++) {
            String[] str = MainActivity.hashMap.get(MainActivity.nameMeasure).getItemInfo(i1).split("\n");
            standPrice += getStandPrice(str[0]);
        }

        continePriceZh = roundUpToNearestTen((int) Math.ceil(((mounting + slopes + interest + price + delivery + other + plus - (isCheckStand1 ? 0 : standPrice)) * course) * MainActivity.prices.CALCPERC));

        continePriceM = roundUpToNearestTen((int) Math.ceil(((mounting + slopes + (interest * MainActivity.prices.MINPRICE) + price + delivery + other - (isCheckStand1 ? 0 : standPrice)) * course) * MainActivity.prices.CALCPERC));


        //Это ЗАВЫШЕННАЯ стоимость для скидок
        int b = (int) Math.ceil( (100.00 / discont) * continePriceZh);
        textPriceR.setText(b + " руб");

        if (i == 0) {
            textPriceOutcome.setText( continePriceZh + " руб");

            //Сумма скидки
            textDiscont.setText((b - continePriceZh) + " руб");

            salary.setText(Math.round(((int) Math.ceil(((mounting + slopes + interest + price + delivery + other - (isCheckStand1 ? 0 : standPrice)) * course) * MainActivity.prices.CALCPERC)) * (isCheckStand1 ? 0.04 : 0.03) * 100.0) / 100.0 + " руб");

        } else {
            textPriceOutcome.setText( continePriceM + " руб");

            //Сумма скидки
            textDiscont.setText((b - continePriceM) + " руб");

            salary.setText((Math.round((int) Math.ceil(((mounting + slopes + (interest * MainActivity.prices.MINPRICE) + price + delivery + other - (isCheckStand1 ? 0 : standPrice)) * course) * MainActivity.prices.CALCPERC)) * 0.03 * 100.0) / 100.0 + " руб");
        }
    }

    public static double getStandPrice(String e) {
        String result  = "";

        if(e.contains("УНЗ_№_") && !e.contains("G")) {
            result = e.replace("УНЗ_№_", "");
            result = result.replace('V', '.');
        }
        else {
            return 0;
        }

        return Double.parseDouble(result);
    }


    //отправляем файл
    public void sendMeasure() throws IOException {
        Gson gson= new Gson();
        //Создаем временный hasmap
        LinkedHashMap<String, Measure> tmpHashMap = new LinkedHashMap<>();
        //Помещаяем в него активный замер
        tmpHashMap.put(MainActivity.nameMeasure, MainActivity.hashMap.get(MainActivity.nameMeasure));
        //Записываем его в строку
        String json = gson.toJson(tmpHashMap);
        //Перезаписывем строку сжимая ее
        json = gson.toJson(compress(json));

        //Для андроид 10+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, MainActivity.nameMeasure + ".msr");
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "application/octet-stream");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + File.separator + "Miscalculation");
            ContentResolver resolver = getContentResolver();
            Uri uri = null;


            final Uri contentUri = MediaStore.Files.getContentUri("external");
            //Перед созданием нового элемента, полностью удаляем всю таблицу файлов "external"
            resolver.delete(contentUri, null, null);

            uri = resolver.insert(contentUri, contentValues);

            OutputStream fos = resolver.openOutputStream(uri);
            fos.write(json.getBytes());

            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.setType("application/octet-stream");
            startActivity(Intent.createChooser(shareIntent, null));

        }
        //Для более старых версий
        else {
             //Сохраняем замер в папку приложения
             FileOutputStream fos;
             fos = new FileOutputStream(getExternalPath());
             fos.write(json.getBytes());

            final Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("application/octet-stream");
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(getExternalPath()));
            startActivity(Intent.createChooser(shareIntent, "Share image using"));
        }
    }

    //отправляем спецификацию
    public void sendSpecification(ExcelCreator ec, int price) throws IOException {
        Uri uri = ec.getSpecification(price,this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.setType("application/octet-stream");
            startActivity(Intent.createChooser(shareIntent, null));
        }
        else {
            final Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("application/octet-stream");
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(getExternalPathSpec()));
            startActivity(Intent.createChooser(shareIntent, "Share image using"));
        }
    }

    //Для старых андроид
    private File getExternalPath() {
        return new File(getExternalFilesDir(null), MainActivity.nameMeasure + ".msr");
    }

    //Это для старых андроид
    public File getExternalPathSpec() {
        return new File(getExternalFilesDir(null), MainActivity.nameMeasure + " спец.xls");
    }

    //Вызывается из метода с сжатием строки
    public static byte[] compress(byte[] data) throws IOException {
        if (data == null || data.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(data);
        gzip.close();
        return  out.toByteArray();
    }
    //Передаем строку которую нужно сжать, на выходе получим ее сжатый массив Byte
    public static byte[] compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return null;
        }
        return compress(str.getBytes(StandardCharsets.UTF_8));
    }


    public void foLizing(){
        //Цена изделий тех что покупаем на космоторге
        double priceItems1 = 0;
        //Цена изделий которые сами покупаем
        double priceItems2 = 0;

        double percentN = (8.0/92 *1.2);

        double all;
        double percent;
        double NDS;

        double all2;
        double percent2;
        double NDS2;


        double pLizZh;
        double pLizM;

        for(int i = 0;i < list.size();i++) {
            if(list.get(i).contains("Брус деревянный") || list.get(i).contains("Нащельник ПВХ")) {
                priceItems2 += ProductList.prodItemPrice.get(i);
            }else {
                priceItems1 +=ProductList.prodItemPrice.get(i);
            }
        }
        priceItems1 = Math.ceil(priceItems1);
        priceItems2 = Math.ceil(priceItems2);

        double pLizZhMaxPrepaid = (priceItems2 + other + plus + mounting + slopes + interest + delivery) * MainActivity.prices.CALCPERC * course;
        double pLizMinMaxPrepaid = (priceItems2 + other + plus + mounting + slopes + interest * MainActivity.prices.MINPRICE + delivery) * MainActivity.prices.CALCPERC * course;

        all = priceItems1 + priceItems2 + other + plus + mounting + slopes + interest + delivery;
        percent = all * percentN;
        NDS = (priceItems2 + other + plus + mounting + slopes + interest + delivery) * 0.2;

        all2 = priceItems1 + priceItems2 + other + mounting + slopes + interest * MainActivity.prices.MINPRICE + delivery;
        percent2 = all2 * percentN;
        NDS2 = (priceItems2 + other + mounting + slopes + interest * MainActivity.prices.MINPRICE + delivery) * 0.2;

        pLizZh = roundUpToNearestTen((int) Math.ceil((NDS + all + percent) * course));
        pLizM = roundUpToNearestTen((int) Math.ceil((NDS2 + all2 + percent2) * course));


        Bank.setPriceDopAndItem(pLizZh,pLizM, pLizZhMaxPrepaid, pLizMinMaxPrepaid);
    }


    //Вызывается при добовлении предоплаты
    public static void forLizingFromBank(int prepaid){
        //Цена изделий тех что покупаем на космоторге
        double priceItems1 = 0;
        //Цена изделий которые сами покупаем
        double priceItems2 = 0;

        double percentN = (8.0/92 *1.2);

        double all;
        double percent;
        double NDS;

        double all2;
        double percent2;
        double NDS2;

        int sumP = (int) (prepaid/course/MainActivity.prices.CALCPERC);


        double pLizZh;
        double pLizM;

        for(int i = 0;i < list.size();i++) {
            if(list.get(i).contains("Брус деревянный") || list.get(i).contains("Нащельник ПВХ")) {
                priceItems2 += ProductList.prodItemPrice.get(i);
            }else {
                priceItems1 +=ProductList.prodItemPrice.get(i);
            }
        }
        priceItems1 = Math.ceil(priceItems1);
        priceItems2 = Math.ceil(priceItems2);

        all = (priceItems1 + priceItems2 + other + plus + mounting + slopes + interest + delivery) - sumP;
        percent = all * percentN;
        NDS = ((priceItems2 + other + plus + mounting + slopes + interest + delivery)-sumP) * 0.2;

        all2 = (priceItems1 + priceItems2 + other + mounting + slopes + interest * MainActivity.prices.MINPRICE + delivery)-sumP;
        percent2 = all2 * percentN;
        NDS2 = ((priceItems2 + other + mounting + slopes + interest * MainActivity.prices.MINPRICE + delivery)-sumP) * 0.2;

        pLizZh = roundUpToNearestTen((int) Math.ceil((NDS + all + percent) * course));
        pLizM = roundUpToNearestTen((int) Math.ceil((NDS2 + all2 + percent2) * course));

        Bank.setPriceLizWithPrepaid(pLizZh,pLizM);
    }

    public static int roundUpToNearestTen(int number) {
        return ((number + 9) / 10) * 10;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        setPriceOutcome(positionPrice1);
    }
}