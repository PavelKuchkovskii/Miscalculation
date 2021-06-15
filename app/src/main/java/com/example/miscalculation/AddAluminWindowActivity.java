package com.example.miscalculation;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import android.widget.Button;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class AddAluminWindowActivity extends AppCompatActivity  {

    static boolean addFromList = false;

    static boolean flag = false;
    static boolean getPriceFlag = false;

    static int positionType1;
    static int positionTypeOfType1;
    static int positionHight1;
    static int positionWidth1;
    static int positionLamination1;

    static double price;
    static int itemInterest;

    static double laminationCoefficient;

    static List<String> dataTypeOfType = new ArrayList<>();
    static List<String> dataLamination = new ArrayList<>();
    static List<String> dataHight = new ArrayList<>();
    static List<String> dataWidth = new ArrayList<>();

    //-----------------------АЛЮМИНЬКИ------------------------------------------------------------------
    static int [][] windAl1stNo = { {16, 17, 18, 20, 21, 22, 23},
            {17, 18, 20, 21, 22, 24, 25},
            {18, 20, 21, 22, 25, 26, 27},
            {20, 21, 22, 25, 26, 28, 29},
            {21, 22, 25, 26, 28, 29, 30},
            {22, 24, 26, 28, 29, 32, 34},
            {24, 25, 28, 29, 32, 33, 36},
            {25, 28, 29, 30, 33, 34, 37},
            {26, 29, 30, 33, 34, 36, 38},
            {28, 30, 32, 34, 36, 38, 40},
            {29, 32, 33, 36, 38, 40, 42},
            {30, 33, 36, 37, 40, 41, 43},
            {32, 34, 37, 38, 41, 44, 46} };

    static int [][] windAl2st1Op = { {33, 34, 37, 38, 40, 42, 44, 45, 48, 51},
            {36, 37, 40, 41, 44, 45, 46, 49, 50, 55},
            {38, 41, 42, 44, 46, 48, 50, 52, 54, 59},
            {41, 44, 45, 48, 49, 52, 53, 55, 57, 63},
            {44, 46, 48, 50, 53, 54, 57, 58, 61, 67},
            {46, 49, 52, 53, 55, 57, 59, 62, 63, 71},
            {50, 52, 54, 57, 58, 61, 62, 65, 67, 75},
            {53, 54, 57, 59, 61, 63, 66, 69, 70, 79},
            {55, 58, 59, 62, 65, 67, 69, 71, 74, 83},
            {58, 61, 63, 65, 67, 70, 73, 74, 77, 87},
            {61, 63, 66, 69, 70, 73, 75, 78, 81, 91},
            {63, 66, 69, 71, 74, 77, 79, 81, 83, 95},
            {66, 69, 71, 74, 77, 79, 82, 85, 87, 99} };

    static int [][] windAl3st1Op = { {57, 58, 59, 62, 63, 65, 67, 69, 70, 73, 74, 75, 77},
            {61, 62, 65, 66, 69, 70, 71, 74, 75, 78, 79, 81, 83},
            {65, 67, 69, 71, 73, 75, 77, 78, 81, 82, 85, 86, 89},
            {70, 71, 74, 75, 78, 79, 82, 83, 86, 87, 90, 91, 95},
            {74, 77, 78, 81, 82, 85, 86, 89, 90, 92, 94, 96, 101},
            {78, 81, 82, 85, 87, 89, 91, 92, 95, 98, 99, 102, 107},
            {83, 85, 87, 90, 91, 94, 96, 98, 100, 102, 104, 107, 113},
            {87, 90, 91, 94, 96, 98, 100, 103, 106, 107, 110, 112, 119},
            {91, 94, 96, 99, 100, 103, 106, 108, 110, 112, 115, 116, 125},
            {96, 98, 100, 103, 106, 108, 110, 112, 115, 118, 120, 122, 131},
            {100, 103, 106, 107, 110, 112, 115, 118, 120, 123, 124, 127, 137},
            {104, 107, 110, 112, 115, 118, 120, 123, 124, 127, 129, 132, 143},
            {110, 112, 115, 116, 119, 122, 124, 127, 129, 132, 135, 137, 149} };

    static int [][] windAl4st2Op = { {75, 77, 78, 81, 82, 83, 86, 87, 89, 91, 92, 94, 96, 99, 102},
            {81, 82, 85, 86, 87, 90, 91, 94, 95, 96, 99, 100, 103, 106, 108},
            {86, 87, 90, 91, 94, 95, 98, 99, 102, 103, 104, 107, 108, 112, 115},
            {91, 94, 95, 98, 99, 102, 103, 106, 107, 110, 111, 114, 115, 119, 122},
            {96, 99, 102, 103, 106, 107, 110, 111, 114, 115, 118, 119, 122, 126, 128},
            {103, 104, 107, 108, 111, 114, 115, 118, 119, 122, 124, 126, 128, 132, 135},
            {108, 111, 112, 115, 116, 119, 122, 123, 126, 128, 129, 132, 135, 139, 141},
            {114, 116, 119, 120, 123, 126, 127, 129, 132, 133, 136, 139, 140, 145, 148},
            {119, 122, 124, 127, 128, 131, 133, 136, 137, 140, 143, 145, 147, 152, 155},
            {126, 127, 129, 132, 135, 137, 139, 141, 144, 147, 149, 151, 153, 159, 161},
            {131, 133, 135, 137, 140, 143, 145, 148, 151, 152, 155, 157, 160, 165, 168},
            {136, 139, 141, 144, 147, 148, 151, 153, 156, 159, 161, 164, 166, 172, 174},
            {141, 144, 147, 149, 152, 155, 157, 160, 163, 165, 168, 170, 173, 178, 181} };
//--------------------------------------------------------------------------------------------

    String[] dataType = {"Окно 1 створ.", "Окно 2 створ.", "Окно 3 створ.", "Балконная рама (4 створ)."};

    //--------------------------------------------------------------------------------------------------
    static ArrayAdapter<String> adapterTypeOfType;

    static ArrayAdapter<String> adapterLamination;

    static ArrayAdapter<String> adapterHight;
    static ArrayAdapter<String> adapterWidth;

    //-----------------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaluminwindow);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        final Intent prodListBut = new Intent(AddAluminWindowActivity.this, ProductList.class);

//----------------------------------------
        final ArrayAdapter<String> adapterType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataType);


        adapterTypeOfType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfType);

        adapterHight = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataHight);

        adapterWidth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataWidth);

        adapterLamination = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataLamination);

//----------------------------------------
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterTypeOfType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterHight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterHight.clear();
        adapterHight.addAll(addList(R.array.Hight_AlWind));

        adapterWidth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterLamination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterLamination.clear();
        adapterLamination.addAll(addList(R.array.dtaLaminationAlumin));

//----------------------------------------

        final Spinner spinnerType = findViewById(R.id.spinner_type);

        final Spinner spinnerTypeOfType = findViewById(R.id.spinner_typeOfType);

        final Spinner spinnerHight = findViewById(R.id.spinner_hight);

        final Spinner spinnerWidth = findViewById(R.id.spinner_width);

        final Spinner spinnerLamination = findViewById(R.id.spinner_lamination);

//--------------------------------------------------------------------------------------------------
        final Button setTypeButton = findViewById(R.id.button_addType);
        final Button prodLstBut = findViewById(R.id.button_ProdLst);
//---------------------------------ЗАУПСК ОКНА------------------------------------------------------
        //Если запуск не через лист(Добавить в блок)
        if (!addFromList) {
            prodLstBut.setVisibility(View.VISIBLE);
        }
        //Если выбрали через лист(Добавить в блок)
        else {
            prodLstBut.setVisibility(View.INVISIBLE);
        }
//---------------ТИП ОКНА-------------------------

        spinnerType.setAdapter(adapterType);
        // заголовок
        spinnerType.setPrompt("Тип изделия");
        // выделяем элемент
        spinnerType.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionType, long idType) {

                positionType1 = positionType;

                positionWidth1 = 0;
                positionTypeOfType1 = 0;
                spinnerWidth.setSelection(0);
                spinnerTypeOfType.setSelection(0);

                flag = true;
                setPrice(positionType1, positionTypeOfType1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________________ТИП__________________
        spinnerTypeOfType.setAdapter(adapterTypeOfType);
        // заголовок
        spinnerTypeOfType.setPrompt("Тип");
        // выделяем элемент
        spinnerTypeOfType.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerTypeOfType.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionTypeOfType, long idTypeOfType) {

                positionWidth1 = 0;
                positionTypeOfType1 = positionTypeOfType;
                spinnerWidth.setSelection(0);

                flag = true;
                setPrice(positionType1, positionTypeOfType1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________ВЫСОТА__________________

        spinnerHight.setAdapter(adapterHight);
        // заголовок
        spinnerHight.setPrompt("Высота");
        // выделяем элемент
        spinnerHight.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerHight.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionHight, long idHight) {

                positionHight1 = positionHight;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//__________________ШИРИНА_____________________

        spinnerWidth.setAdapter(adapterWidth);
        // заголовок
        spinnerWidth.setPrompt("Ширина");
        // выделяем элемент
        spinnerWidth.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerWidth.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionWidth, long idWidth) {

                positionWidth1 = positionWidth;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________ЛАМИНАЦИЯ_______________

        spinnerLamination.setAdapter(adapterLamination);
        // заголовок
        spinnerLamination.setPrompt("Ламинация");
        // выделяем элемент
        spinnerLamination.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerLamination.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionLamination, long idLamination) {

                positionLamination1 = positionLamination;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//---------------------------------КНОПКИ---------------------------------------------------
        setTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.startAnimation(animAlpha);

                getPriceFlag = true;
                setPrice(positionType1, positionTypeOfType1);
                setLaminationCoefficient();

                String itemName = dataType[positionType1] + " " + dataTypeOfType.get(positionTypeOfType1) + " Алюминий " + dataLamination.get(positionLamination1) + "\n" +
                        dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1);
                String itemInfo = "";

                //Если добавление в конец списка
                if(!addFromList) {
                    ProductList.addProdLst(itemName, Math.ceil(price * laminationCoefficient), itemInterest, 0, 0);
                    MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, Math.ceil(price * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));

                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(100);
                    try {
                        writeHash(MainActivity.hashMap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //Если добавление в блок
                else {
                    ProductList.addProdLst(itemName, Math.ceil(price * laminationCoefficient), itemInterest, 0, 0);
                    MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, Math.ceil(price * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());

                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vibrator.vibrate(100);
                    try {
                        writeHash(MainActivity.hashMap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    onBackPressed();
                }

            }
        });
//__________________________________________________________________________________-
        prodLstBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(prodListBut);
            }
        });
//-------------------------------------------------------------------------------------
    }

    public void setPrice(int p1, int p2) {


        // 1 створка глухая
        if(p1 == 0 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta0));
                adapterWidth.addAll(addList(R.array.Width_Al1stNo));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1000 ) {
                    itemInterest = DopPrices.INTW2ST;
                }
                else {
                    itemInterest = DopPrices.INTW1ST;
                }
                price = windAl1stNo[positionHight1][positionWidth1];
            }
            return;
        }

        // 2 стоврки 2 глухие
        if(p1 == 1 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta2));
                adapterWidth.addAll(addList(R.array.Width_Al2st1Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1700 ) {
                    itemInterest = DopPrices.INTW3ST;
                }
                else {
                    itemInterest = DopPrices.INTW2ST;
                }
                price = windAl2st1Op[positionHight1][positionWidth1] - 3;
            }
            return;
        }

        // 3 створки 3 глухие
        if(p1 == 2 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterWidth.addAll(addList(R.array.Width_Al3st1Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = DopPrices.INTW4ST;
                }
                else {
                    itemInterest = DopPrices.INTW3ST;
                }
                price = windAl3st1Op[positionHight1][positionWidth1] - 3;
            }
            return;
        }

        // 2 створки 1 открывается
        if(p1 == 1 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta2));
                adapterWidth.addAll(addList(R.array.Width_Al2st1Op));
                flag = false;
            }
            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1700 ) {
                    itemInterest = DopPrices.INTW3ST;
                }
                else {
                    itemInterest = DopPrices.INTW2ST;
                }
                price = windAl2st1Op[positionHight1][positionWidth1];
            }
            return;
        }

        // 2 створки 2 открывается
        if(p1 == 1 && p2 == 2) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta2));
                adapterWidth.addAll(addList(R.array.Width_Al2st1Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1700 ) {
                    itemInterest = DopPrices.INTW3ST;
                }
                else {
                    itemInterest = DopPrices.INTW2ST;
                }
                price = windAl2st1Op[positionHight1][positionWidth1] + 3;
            }
            return;
        }

        // 3 створки 1 открывается
        if(p1 == 2 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterWidth.addAll(addList(R.array.Width_Al3st1Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = DopPrices.INTW4ST;
                }
                else {
                    itemInterest = DopPrices.INTW3ST;
                }
                price = windAl3st1Op[positionHight1][positionWidth1];
            }
            return;
        }

        // 3 створки 2 открывается
        if(p1 == 2 && p2 == 2) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterWidth.addAll(addList(R.array.Width_Al3st1Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = DopPrices.INTW4ST;
                }
                else {
                    itemInterest = DopPrices.INTW3ST;
                }

                price = windAl3st1Op[positionHight1][positionWidth1] + 3;
            }
            return;
        }

        // 3 створки 3 открывается
        if(p1 == 2 && p2 == 3) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterWidth.addAll(addList(R.array.Width_Al3st1Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = DopPrices.INTW4ST;
                }
                else {
                    itemInterest = DopPrices.INTW3ST;
                }
                price = windAl3st1Op[positionHight1][positionWidth1] + 6;
            }
            return;
        }

        // 4 створки глухая
        if(p1 == 3 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterWidth.addAll(addList(R.array.Width_Al4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = DopPrices.INTW4STV2;
                }
                else {
                    itemInterest = DopPrices.INTW4ST;
                }
                price = windAl4st2Op[positionHight1][positionWidth1] - 6;
            }
            return;
        }

        // 4 створки 1 открывается
        if(p1 == 3 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterWidth.addAll(addList(R.array.Width_Al4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = DopPrices.INTW4STV2;
                }
                else {
                    itemInterest = DopPrices.INTW4ST;
                }

                price = windAl4st2Op[positionHight1][positionWidth1] - 3;

            }
            return;
        }

        // 4 створки 2 открывается
        if(p1 == 3 && p2 == 2) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterWidth.addAll(addList(R.array.Width_Al4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = DopPrices.INTW4STV2;
                }
                else {
                    itemInterest = DopPrices.INTW4ST;
                }

                price = windAl4st2Op[positionHight1][positionWidth1];
            }
            return;
        }

        // 4 створки 3 открывается
        if(p1 == 3 && p2 == 3) {
            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterWidth.addAll(addList(R.array.Width_Al4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = DopPrices.INTW4STV2;
                }
                else {
                    itemInterest = DopPrices.INTW4ST;
                }

                price = windAl4st2Op[positionHight1][positionWidth1] + 3;
            }
            return;
        }

        // 4 створки 4 открывается
        if(p1 == 3 && p2 == 4) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterWidth.addAll(addList(R.array.Width_Al4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = DopPrices.INTW4STV2;
                }
                else {
                    itemInterest = DopPrices.INTW4ST;
                }

                price = windAl4st2Op[positionHight1][positionWidth1] + 6;
            }
            return;
        }

    }
    //______________________________________________________
    public void setLaminationCoefficient(){

            if (positionLamination1 == 0) {
                laminationCoefficient = 1;
            }
            //Коричневый алюминий
            if (positionLamination1 == 1) {
                laminationCoefficient = DopPrices.korichAlumin;
            }


    }
    //____________________________________________________________

    public List<String> addList(@ArrayRes int id) {
        return Arrays.asList(getResources().getStringArray(id));
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
//____________________________________________________________________

    //Если false - стандартный запуск
    //Если true - запуск из листа
    public static void setAddFromList(boolean b) {
        addFromList = b;
    }

    //Переопределяем кнопку назад
    @Override
    public void onBackPressed() {

        //Если добавили новое изделие зайдя из списка, или нажали назад
        if (addFromList) {
            setAddFromList(false);
            ProductList.setAddFromList(false);
            getOnBackPressedDispatcher().onBackPressed();
        }
        //Если заходили обычно
        else {
            getOnBackPressedDispatcher().onBackPressed();
        }
    }
}


