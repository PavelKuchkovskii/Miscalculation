package com.example.miscalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.AdapterView.OnItemClickListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import com.google.gson.Gson;

public class ProductList extends AppCompatActivity {

    final Context context = this;

    static boolean addFromList = false;
    static int indexOfAddToBlock = 0;

    static boolean mainActivityFlag = true;
    private static final boolean isManager = true;

    static double Course = 0.0;

    static ArrayAdapter<String> adapterProdLst;
    static ArrayAdapter<String> adapterCourse;
    static ArrayAdapter<String> adapterDiscont;
    static ArrayAdapter<String> adapterBlock;

    static List<String> prodList = new ArrayList<>();
    static List<Double> prodItemPrice = new ArrayList<>();
    static List<Integer> prodInterest = new ArrayList<>();
    static List<String> CourseAmount = new ArrayList<>();
    static List<Integer> prodMounting = new ArrayList<>();
    static List<Integer> prodSlopes = new ArrayList<>();

    static String[] block = {"***********БАЛКОННЫЙ БЛОК***********",
            "***********БАЛК.РАМА(ИЗ НЕСК. ЧАСТЕЙ)***********", "***********ПОЛУКРУГЛАЯ РАМА***********", "***********КОНЕЦ***********"};

    static TextView textMounting;
    static TextView textSlopes;
    static TextView textInterest;
    static TextView textDelivery;
    static TextView textOther;
    static TextView textDelivKM;
    static TextView itemSum;

    static TextView textMountingNP;
    static TextView textSlopesNP;
    static TextView textInterestNP;

    static TextView textRegion;

    static View v1;
    static View v2;
    static View v3;

    static int interest = 0;
    static int slopes = 0;
    static int mounting = 0;
    static int delivery = 35;
    static int other = 0;
    static double priceOutcome = 0;
    static double delivKM = 0;
    static int discontAm = 0;

    static int positionBlock1;

    public AlertDialog.Builder builder;
    public AlertDialog.Builder builder2;

    public static ListView productList = null;

    public static Button butAddBlock;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (mainActivityFlag == true){
            mainActivityFlag=false;
            onBackPressed();
        }
        setContentView(R.layout.activity_productlist);


        String[] discont = {"5%", "10%", "15%", "20%", "35%"};

        v1 = findViewById(R.id.v1);
        v1.setVisibility(View.INVISIBLE);
        v2 = findViewById(R.id.v2);
        v2.setVisibility(View.INVISIBLE);
        v3 = findViewById(R.id.v3);
        v3.setVisibility(View.INVISIBLE);


        textMounting = findViewById(R.id.txtMountingPrice);
        textSlopes = findViewById(R.id.txtSlopesPrice);
        textInterest = findViewById(R.id.txtInterestPrice);

        textMountingNP = findViewById(R.id.txtMounting);
        textMountingNP.setVisibility(View.INVISIBLE);
        textSlopesNP = findViewById(R.id.txtSlopes);
        textSlopesNP.setVisibility(View.INVISIBLE);
        textInterestNP = findViewById(R.id.txtInterest);
        textInterestNP.setVisibility(View.INVISIBLE);

        textDelivery = findViewById(R.id.txtDelivery);
        textOther = findViewById(R.id.txtOther);
        textDelivKM = findViewById(R.id.txtDelivKM);
        itemSum = findViewById(R.id.SumItem);

        textRegion = findViewById(R.id.txtRegion);

        textMounting.setText(mounting + ".00");
        textMounting.setVisibility(View.INVISIBLE);
        textSlopes.setText(slopes + ".00");
        textSlopes.setVisibility(View.INVISIBLE);
        textInterest.setText(interest + ".00");
        textInterest.setVisibility(View.INVISIBLE);
        textDelivery.setText(delivery + ".00");
        textOther.setText(other + ".00");
        textDelivKM.setText(String.format("%.2f", delivKM));
        itemSum.setText("∑ = " + String.format("%.2f", priceOutcome));
        itemSum.setVisibility(View.INVISIBLE);

        CourseAmount = Arrays.asList(getResources().getStringArray(R.array.CourseAm));

        productList = findViewById(R.id.listProduct);

        final EditText editTextDelivery = findViewById(R.id.editTextDelivery);
        final EditText editTextOther = findViewById(R.id.editTextOther);
        final EditText editTextDelivKM = findViewById(R.id.editTextDelivKM);

        final Button addDelivery = findViewById(R.id.button_addDelivery);
        final Button addOther = findViewById(R.id.button_addOther);
        final Button addDelivKM = findViewById(R.id.button_addDelivKM);
        final Button butClearAll = findViewById(R.id.button_clearAll);
        final Button butPrice = findViewById(R.id.button_price);
        butAddBlock = findViewById(R.id.button_addBlock);

        final Intent continePrice = new Intent(ProductList.this, ContinePrice.class);
        final Intent addWindow = new Intent(ProductList.this, AddWindowActivity.class);
        final Intent addAluminWindow = new Intent(ProductList.this, AddAluminWindowActivity.class);

        adapterProdLst = new ArrayAdapter<>(this, R.layout.list_item, prodList);
        productList.setAdapter(adapterProdLst);

        adapterCourse = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CourseAmount);
        adapterCourse.setDropDownViewResource(R.layout.listspinner_item);

        adapterDiscont = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, discont);
        adapterDiscont.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterBlock = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, block);
        adapterBlock.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinnerCourse = findViewById(R.id.spinner_course);
        final Spinner spinnerDiscont = findViewById(R.id.spinner_discont);

        productList.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                builder = new AlertDialog.Builder(ProductList.this);
                builder.setTitle("Удалить?");
                builder.setMessage(MainActivity.hashMap.get(MainActivity.nameMeasure).getItemInfo(position));

                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //Если удаляется начало блока
                        if (prodList.get(position).equals(block[0]) || prodList.get(position).equals(block[1]) || prodList.get(position).equals(block[2])) {
                            checkBlock(position);
                        }
                        //Если удаляется конец блока
                        else if (prodList.get(position).equals(block[3])) {
                            deleteBlock(position, position);
                        }
                        //Если удаляется элемент списка
                        else {
                            MainActivity.hashMap.get(MainActivity.nameMeasure).removeItem(position);

                            priceOutcome = priceOutcome - prodItemPrice.get(position);
                            interest = interest - prodInterest.get(position);
                            mounting = mounting - prodMounting.get(position);
                            slopes = slopes - prodSlopes.get(position);

                            prodItemPrice.remove(position);
                            prodInterest.remove(position);
                            prodMounting.remove(position);
                            prodSlopes.remove(position);

                            prodList.remove(position);
                            adapterProdLst.notifyDataSetInvalidated();

                            textInterest.setText(interest + ".00");
                            textMounting.setText(mounting + ".00");
                            textSlopes.setText(slopes + ".00");

                            setProdLstPriceOutcome();
                            try {
                                writeHash(MainActivity.hashMap);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

                builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                });

                //Если создан блок
                if (prodList.get(position).equals(block[0]) || prodList.get(position).equals(block[1]) || prodList.get(position).equals(block[2])) {
                    builder.setNeutralButton("Добавить", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            indexOfAddToBlock = position + 1;

                            builder2 = new AlertDialog.Builder(ProductList.this);
                            builder2.setTitle("Внимание!");
                            builder2.setMessage("Что добавить?");

                            builder2.setPositiveButton("ОКНО ПВХ", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    AddWindowActivity.setAddFromList(true);
                                    setAddFromList(true);
                                    startActivity(addWindow);
                                }
                            });

                            builder2.setNegativeButton("ОКНО AL", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    AddAluminWindowActivity.setAddFromList(true);
                                    setAddFromList(true);
                                    startActivity(addAluminWindow);
                                }
                            });

                            builder2.setNeutralButton("ОТМЕНА", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });


                            AlertDialog alert2 = builder2.create();
                            alert2.show();
                        }
                    });
                }

                AlertDialog alert = builder.create();
                alert.show();

            }
        });
//---------------------------------------------------------------------------------------
        spinnerCourse.setAdapter(adapterCourse);
        // заголовок
        spinnerCourse.setPrompt("Курс");
        // выделяем элемент
        spinnerCourse.setSelection(4);
        // устанавливаем обработчик нажатия
        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionCourse, long idCourse) {

                Course = Double.parseDouble(CourseAmount.get(positionCourse));
                setProdLstPriceOutcome ();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//---------------------------------------------------------------------------------------
        spinnerDiscont.setAdapter(adapterDiscont);
        // заголовок
        spinnerDiscont.setPrompt("Скидка");
        // выделяем элемент
        spinnerDiscont.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerDiscont.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionDiscont, long idDiscont) {

                if(positionDiscont == 0) {
                   discontAm = 5;
                }
                else if(positionDiscont == 1) {
                    discontAm = 10;
                }
                else if(positionDiscont == 2) {
                    discontAm = 15;
                }
                else if(positionDiscont == 3) {
                    discontAm = 20;
                }
                else {
                    discontAm = 35;
                }

//************************************ИНИЦИАЛИЗАЦИЯ*************************************************
                findBlock(prodList);
//**************************************************************************************************
                if(isManager) {
                    v1.setVisibility(View.VISIBLE);
                    v2.setVisibility(View.VISIBLE);
                    v3.setVisibility(View.VISIBLE);

                    itemSum.setVisibility(View.VISIBLE);
                    textInterest.setVisibility(View.VISIBLE);
                    textMounting.setVisibility(View.VISIBLE);
                    textSlopes.setVisibility(View.VISIBLE);

                    textInterestNP.setVisibility(View.VISIBLE);
                    textMountingNP.setVisibility(View.VISIBLE);
                    textSlopesNP.setVisibility(View.VISIBLE);
                }
                setTextRegion();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//---------------------------------------------------------------------------------------------

        addDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextDelivery.getText().toString().equals("")){
                    hideKeyboard(ProductList.this);
                }
                else {
                    delivery = Integer.parseInt(editTextDelivery.getText().toString());
                    textDelivery.setText(delivery + ".00");
                    editTextDelivery.getText().clear();

                    MainActivity.hashMap.get(MainActivity.nameMeasure).setDelivery(delivery);
                    try {
                        writeHash(MainActivity.hashMap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    setProdLstPriceOutcome();
                    hideKeyboard(ProductList.this);
                }
            }
        });
//---------------------------------------------------------------------------------------------

        addOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextOther.getText().toString().equals("")){
                    hideKeyboard(ProductList.this);
                }
                else {
                    other = Integer.parseInt(editTextOther.getText().toString());
                    textOther.setText(other + ".00");
                    editTextOther.getText().clear();

                    MainActivity.hashMap.get(MainActivity.nameMeasure).setOther(other);
                    try {
                        writeHash(MainActivity.hashMap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    setProdLstPriceOutcome();
                    hideKeyboard(ProductList.this);
                }
            }
        });
//---------------------------------------------------------------------------------------------

        addDelivKM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextDelivKM.getText().toString().equals("")){
                    hideKeyboard(ProductList.this);
                }
                else {

                    delivKM = (Double.valueOf(editTextDelivKM.getText().toString())*0.4) + 10;
                    textDelivKM.setText(  String.format("%.2f", ((Double.valueOf(editTextDelivKM.getText().toString())*0.4) + 10)) );
                    hideKeyboard(ProductList.this);
                }
            }
        });
//---------------------------------------------------------------------------------------------

        butClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Очищаем в hashmap
                MainActivity.hashMap.get(MainActivity.nameMeasure).clearAll();
                clearAll();
                try {
                    writeHash(MainActivity.hashMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
//---------------------------------------------------------------------------------------------
        butPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Если все блоки закрыты
                if(findBlock(prodList)) {
                    filterInterestBalBlock();
                    filterInterestPolRam();
                    filterInterestSostRam();
                    updateInterest(prodInterest);
                    try {
                        writeHash(MainActivity.hashMap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ContinePrice.setContinePrice(prodList,interest,mounting,delivery,other,slopes, Course, Math.ceil(priceOutcome * 1.2), discontAm);
                    startActivity(continePrice);
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "БЛОК НЕ ЗАКРЫТ!", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
//---------------------------------------------------------------------------------------------
        butAddBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Если все блоки закрыты или отсутсвуют
                if (findBlock(prodList)) {

                    LayoutInflater li = LayoutInflater.from(context);
                    View promptsView = li.inflate(R.layout.prompt2, null);

                    //Создаем AlertDialog
                    AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);
                    //Настраиваем prompt.xml для нашего AlertDialog:
                    mDialogBuilder.setView(promptsView);
                    //Настраиваем отображение поля выбора региона
                    final Spinner spinnerBlock = promptsView.findViewById(R.id.spinner_block);
                    spinnerBlock.setAdapter(adapterBlock);
                    spinnerBlock.setPrompt("БЛОК");
                    spinnerBlock.setSelection(0);
                    spinnerBlock.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view,
                                                   int positionBlock, long idBlock) {
                            positionBlock1 = positionBlock;
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> arg0) {
                        }
                    });
                    //Настраиваем сообщение в диалоговом окне:
                    mDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            if (positionBlock1 == 0 || positionBlock1 == 1 || positionBlock1 == 2) {
                                MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(String.valueOf(positionBlock1), "", 0.0, 0, 0);
                                addProdLst(String.valueOf(positionBlock1), 0.0, 0, 0, 0);
                            }
                            else {
                                MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(String.valueOf(positionBlock1), "", 0.0, 0, 0);
                                addProdLst(String.valueOf(positionBlock1), 0.0, 0, 0, 0);
                            }

                            findBlock(prodList);

                            try {
                                writeHash(MainActivity.hashMap);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }).setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

                    //Создаем AlertDialog:
                    AlertDialog alertDialog = mDialogBuilder.create();
                    //и отображаем его:
                    alertDialog.show();

                }
                //Если Блок открыт
                else {
                    MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(String.valueOf(3), "", 0.0, 0, 0);
                    addProdLst(String.valueOf(3), 0.0, 0, 0, 0);
                    findBlock(prodList);

                    try {
                        writeHash(MainActivity.hashMap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//---------------------------------------------------------------------------------------------
    }

    //Вызыввется при добовлении нового изделия и из сохраненого замера
    public static void addProdLst (String prodLst, double priceItem, int interest1, int mounting1, int slopes1) {

        if (prodLst.equals("0")) {
            adapterProdLst.add(block[0]);
        }
        else if (prodLst.equals("1")) {
            adapterProdLst.add(block[1]);
        }
        else if (prodLst.equals("2")) {
            adapterProdLst.add(block[2]);
        }
        else if (prodLst.equals("3")) {
            adapterProdLst.add(block[3]);
        }
        else {
            //Если добавление в конец списка
            if (!addFromList) {

                //Если менеджер и не работа
                if(isManager && mounting1 == 0 && slopes1 == 0) {
                    adapterProdLst.add(prodLst + ": " + priceItem);
                }
                //Если не менеджер или работа
                else{
                    adapterProdLst.add(prodLst);
                }
            }
            //Если добавление в блок
            else {
                addFromList = false;
                //Если менеджер и не работа
                if(isManager && mounting1 == 0 && slopes1 == 0) {
                    prodList.add(indexOfAddToBlock, prodLst + ": " + priceItem);
                    adapterProdLst.notifyDataSetInvalidated();
                }
                //Если не менеджер или работа
                else{
                    prodList.add(indexOfAddToBlock, prodLst);
                    adapterProdLst.notifyDataSetInvalidated();
                }
            }

        }

        if (mounting1 == 0 && slopes1 == 0) {
            priceOutcome = priceOutcome + priceItem;
            interest = interest + interest1;
        }
        else {
            if (mounting1 != 0) {
                mounting = mounting + mounting1;
            }
            else {
                slopes = slopes + slopes1;
            }
        }
        prodItemPrice.add(priceItem);
        prodInterest.add(interest1);
        prodMounting.add(mounting1);
        prodSlopes.add(slopes1);
        textInterest.setText(interest + ".00");
        textMounting.setText(mounting + ".00");
        textSlopes.setText(slopes + ".00");
        setProdLstPriceOutcome ();
    }

    //Вызывается из Класса замера при открытии сохраненного замера
    public static void addProdLst(int delivery1, int other1) {
        delivery = delivery1;
        other = other1;
        textDelivery.setText(delivery + ".00");
        textOther.setText(other + ".00");
    }

    public static void setProdLstPriceOutcome (){
        itemSum.setText("∑ = " + String.format("%.2f", Math.ceil(priceOutcome * 1.2)) );
    }

    public static void clearAll() {

        adapterProdLst.clear();
        prodItemPrice.clear();
        prodInterest.clear();
        prodMounting.clear();
        prodSlopes.clear();
        priceOutcome = 0;
        interest = 0;
        mounting = 0;
        slopes = 0;
        delivery = 35;
        other = 0;
        textDelivery.setText(delivery + ".00");
        textOther.setText(other + ".00");
        textMounting.setText(mounting + ".00");
        textSlopes.setText(slopes + ".00");
        textInterest.setText(interest + ".00");
        setProdLstPriceOutcome();
    }

//=====================================РАБОТА С БЛОКАМИ=============================================

    //i - начало блока
    //b - конец блока
    public void filterInterestBalBlock() {

        //Индекс балконного блока
        int i = 0;

        for(String s : prodList) {
            //Ищем Балконный блок
            if (s.contains("***********БАЛКОННЫЙ БЛОК***********")) {
                //Индекс конца балконного блока
                int b = 0;

                //Если нашли Балконный блок ищем его конец
                for (String s1 : prodList) {

                    //Если нашли Конец балконного блока
                    if (s1.contains("***********КОНЕЦ***********")) {



                        if(i < b) {
                            int countWindows = 0;

                            //Заменяем интерес во всех элементах на 0
                            for (int y = i + 1; y < b; y++) {
                                if(prodList.get(y).contains("створ.")) {
                                    countWindows++;
                                }
                                prodInterest.set(y, 0);
                                MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(y, 0);
                            }
                            //Только если между началом блока и концом есть элементы
                            if(b - i > 1) {
                                //Присваиваем интерес 55 элементу предшествующему концу блока, если меньше 1 окна
                                if(countWindows > 1) {
                                    prodInterest.set(b - 1, DopPrices.INTBALBLOCK + 5);
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, DopPrices.INTBALBLOCK + 5);
                                }else {
                                    prodInterest.set(b - 1, DopPrices.INTBALBLOCK);
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, DopPrices.INTBALBLOCK);
                                }

                            }
                            break;
                        }
                    }
                    b++;
                }

            }
            i++;
        }
    }

    public void filterInterestPolRam() {

        int i = 0;

        for(String s : prodList) {
            //Ищем полукруглую раму
            if(s.contains("***********ПОЛУКРУГЛАЯ РАМА***********")) {
                int b = 0;

                //Если нашли Балконный блок ищем его конец
                for (String s1 : prodList) {

                    //Если нашли Конец балконного блока
                    if (s1.contains("***********КОНЕЦ***********")) {

                        //Проверка на наличие элементов между началом и концом блока
                        if(i < b) {
                            //Количество окон в раме
                            int countWindows = 0;


                            //Заменяем интерес во всех элементах на 0
                            for (int y = i + 1; y < b; y++) {

                                if (prodList.get(y).contains("створ.")) {
                                    countWindows++;
                                }
                                prodInterest.set(y, 0);
                                MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(y, 0);
                            }
                            //Присваиваем интерес 20 * на количество створок элементу предшествующему концу блока
                            prodInterest.set(b - 1, countWindows * DopPrices.INTPOLRAM);
                            MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, countWindows * DopPrices.INTPOLRAM);
                            break;
                        }
                    }
                    b++;
                }
            }
            i++;
        }
    }

    public void filterInterestSostRam() {

        //Общая ширина
        int width = 0;

        //Перебираем Лист изделий
        for(int i = 0;i < prodList.size();i++) {

            //Если найдена составная рама
            if(prodList.get(i).contains("***********БАЛК.РАМА(ИЗ НЕСК. ЧАСТЕЙ)***********")) {

                //Переибираем лист в поиске конца
                for(int b = i;b < prodList.size();b++) {

                    if(prodList.get(b).contains("створ.")) {
                        width = width + MainActivity.hashMap.get(MainActivity.nameMeasure).getProdWidth(b);
                    }

                    //Когда нашли конец
                    if(prodList.get(b).contains("***********КОНЕЦ***********")) {
                        for (int b2 = i + 1;b2 < b - 1;b2++) {
                            prodInterest.set(b2, 0);
                            MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b2, 0);
                        }
                        //Если ширин меньше 5000
                        if (width < 5000) {
                            //Если ширина меньше 4000
                            if (width < 4000) {
                                //Если ширина меньше 3000
                                if (width < 3300) {
                                    prodInterest.set(b - 1, 65);
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, 65);
                                }
                                //Если ширина 3300-4000
                                else {
                                    prodInterest.set(b - 1, 80);
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, 80);
                                }
                            }
                            //если ширина 4000-5000
                            else {
                                prodInterest.set(b - 1, 100);
                                MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, 100);
                            }
                        }
                        //Если ширина больше 5000
                        else {
                            prodInterest.set(b - 1, 120);
                            MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, 120);
                        }
                    }
                }
            }
        }
    }

    //Вызывается для проверки открытых и закрытых блоков
    public boolean findBlock(List<String> list) {
        //Количество открытых блоков
        int i = 0;

        //Количество закрытых блоков
        int i2 = 0;

        for(String s : list) {
            //Ищем открытые блоки
            if(s.equals("***********БАЛКОННЫЙ БЛОК***********") || s.equals("***********ПОЛУКРУГЛАЯ РАМА***********") || s.equals("***********БАЛК.РАМА(ИЗ НЕСК. ЧАСТЕЙ)***********")) {
                //Записываем количество открытых блоков
                i++;
            }
        }
        for(String s : prodList) {
            //Ищем закрытие блока
            if(s.equals("***********КОНЕЦ***********")) {
                //Записываем закрытые блоки
                i2++;
            }
        }
        //Если количество открытых блоков равно количесву закрытых веренет true иначе false

        return updateBlock(i - i2 == 0);
    }

    public void updateInterest(List<Integer> prodInterest) {
        interest = 0;
        for(int i : prodInterest) {
            interest += i;
        }
        textInterest.setText(interest + ".00");
    }

    //Вызывается при удалении начала блока
    public void checkBlock(int position) {

        //Если это не последний элемент спсика(начало или конец блока)
        if (position + 1 < prodList.size()) {

            for (int i = position + 1; i < prodList.size(); i++) {
                //Если находим еще одно начало блока, перед концом
                if (prodList.get(i).equals(block[0]) || prodList.get(i).equals(block[1]) || prodList.get(i).equals(block[2])) {
                    deleteBlock(i, i);
                    return;
                }
                //Если находим конец блока
                else if (prodList.get(i).equals(block[3])) {
                    deleteBlock(position, i);
                    return;
                }
            }

            deleteBlock(position, position);
        }
        //Если удаляется последний элемент списка
        else {
            deleteBlock(position, position);
        }
    }

    //Вызывается если при удалении начала блок, он закрыт
    public void deleteBlock(int start, int end) {

        for(int i = start;i <= end;i++) {
            MainActivity.hashMap.get(MainActivity.nameMeasure).removeItem(start);

            priceOutcome = priceOutcome - prodItemPrice.get(start);
            interest = interest - prodInterest.get(start);
            mounting = mounting - prodMounting.get(start);
            slopes = slopes - prodSlopes.get(start);

            prodItemPrice.remove(start);
            prodInterest.remove(start);
            prodMounting.remove(start);
            prodSlopes.remove(start);

            prodList.remove(start);
        }

        adapterProdLst.notifyDataSetInvalidated();
        textInterest.setText(interest + ".00");
        textMounting.setText(mounting + ".00");
        textSlopes.setText(slopes + ".00");
        setProdLstPriceOutcome();

        try {
            writeHash(MainActivity.hashMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        findBlock(prodList);
    }

    public boolean updateBlock(boolean b) {
        //Если блок закрыт
        if(b) {
            butAddBlock.setText("БЛОК +");
        }
        //Если блок не закрыт
        else {
            butAddBlock.setText("КОНЕЦ");
        }
        return b;
    }

//==================================================================================================
    public void setTextRegion() {
        //Если true то регион
        if(MainActivity.hashMap.get(MainActivity.nameMeasure).getRegion()) {
            textRegion.setText("Р");
        }
        //Иначе Минск
        else {
            textRegion.setText("М");
        }
    }

    public void writeHash(LinkedHashMap<String, Measure> wHashMap) throws IOException {
        Gson gson = new Gson();
        FileOutputStream fos = null;

        String json = gson.toJson(wHashMap);
        json = gson.toJson(ContinePrice.compress(json));
        fos = new FileOutputStream(getExternalPath());
        fos.write(json.getBytes());
    }

    private File getExternalPath() {
        return new File(getExternalFilesDir(null), MainActivity.fileName);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);

        View view = activity.getCurrentFocus();

        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void setAddFromList (boolean b) {
        addFromList = b;
    }

    public static int getIndexOfAddToBlock() {
        return indexOfAddToBlock;
    }


    //ЯВНО МЕНЕЕ ЗАТРАТНЫЙ ВАРИАНТ
    /**public void balram() {
        for(int i = 0;i < prodList.size();i++) {
            if(prodList.get(i).contains("Балконный блоок")) {
                for(int b = i;i < prodList.size();b++) {
                    if(prodList.get(b).contains("Конец")) {

                    }
                }
            }
        }
    }*/


}