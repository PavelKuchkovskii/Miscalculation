package com.example.miscalculation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class AddWorkActivity extends AppCompatActivity {

    static boolean workFlag = false;
    static boolean region = false;

    static List<String> dataWork = new ArrayList<>();
    static List<String> dataType = new ArrayList<>();
    static List<String> dataTypeOfType = new ArrayList<>();
    static List<String> dataTypeOfType2 = new ArrayList<>();
    static List<String> dataRegion = new ArrayList<>();

    static List<String> dataHightWork = new ArrayList<>();
    static List<String> dataWidthWork = new ArrayList<>();

    static ArrayAdapter<String> adapterWork;
    static ArrayAdapter<String> adapterType;
    static ArrayAdapter<String> adapterTypeOfType;
    static ArrayAdapter<String> adapterTypeOfType2;
    static ArrayAdapter<String> adapterRegion;

    static ArrayAdapter<String> adapterHightWork;
    static ArrayAdapter<String> adapterWidthWork;

    static int positionWork1;
    static int positionType1;
    static int positionTypeOfType1;
    static int positionTypeOfType1_2;

    static int positionHight1;
    static int positionWidth1;

    static int priceWork = 0;

    static Spinner spinnerTypeOfType = null;
    static Spinner spinnerTypeOfType2 = null;
    static Spinner spinnerHight = null;
    static Spinner spinnerWidth = null;
    static TextView textHight;
    static TextView textWidth;
    static TextView textXWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addwork);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Intent prodListBut = new Intent(AddWorkActivity.this, ProductList.class);

        final Spinner spinnerWork = findViewById(R.id.spinner_work);
        final Spinner spinnerType = findViewById(R.id.spinner_type);
        spinnerTypeOfType = findViewById(R.id.spinner_typeOfType);
        spinnerTypeOfType2 = findViewById(R.id.spinner_typeOfType2);
        spinnerTypeOfType2.setVisibility(View.INVISIBLE);
        final Spinner spinnerRegion = findViewById(R.id.spinner_region);
        spinnerRegion.setVisibility(View.INVISIBLE);

        spinnerHight = findViewById(R.id.spinner_hightWork);
        spinnerHight.setVisibility(View.INVISIBLE);
        spinnerWidth = findViewById(R.id.spinner_widthWork);
        spinnerWidth.setVisibility(View.INVISIBLE);
        //----------------------------------------
        textHight = findViewById(R.id.textHighWork);
        textHight.setVisibility(View.INVISIBLE);
        textWidth = findViewById(R.id.textWidthWork);
        textWidth.setVisibility(View.INVISIBLE);
        textXWork = findViewById(R.id.XWork);
        textXWork.setVisibility(View.INVISIBLE);
        //----------------------------------------
        final Button setDopButton = findViewById(R.id.button_addDop);
        final Button prodLstBut = findViewById(R.id.button_ProdLst);
        //----------------------------------------

        adapterWork = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataWork);
        adapterWork.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterWork.clear();
        adapterWork.addAll(addList(R.array.dtaWork));

        adapterType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataType);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterTypeOfType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfType);
        adapterTypeOfType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterTypeOfType2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfType2);
        adapterTypeOfType2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTypeOfType2.clear();
        adapterTypeOfType2.addAll(addList(R.array.dtaTypeWorkBalRam2));

        adapterRegion = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataRegion);
        adapterRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterRegion.clear();
        adapterRegion.addAll(addList(R.array.dtaRegion));

        adapterHightWork = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataHightWork);
        adapterHightWork.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterHightWork.clear();
        adapterHightWork.addAll(addList(R.array.dtaHightWork));

        adapterWidthWork = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataWidthWork);
        adapterWidthWork.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterWidthWork.clear();
        adapterWidthWork.addAll(addList(R.array.dtaWidthWork));

//_____________________________ВИД РАБОТЫ___________________________________________________________

        spinnerWork.setAdapter(adapterWork);
        // заголовок
        spinnerWork.setPrompt("Вид работ");
        // выделяем элемент
        spinnerWork.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerWork.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionWork, long idWork) {

                positionWork1 = positionWork;
                workFlag = true;
                setWorkPrice();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//________________________ТИП ОКНА__________________________________________________________________

        spinnerType.setAdapter(adapterType);
        // заголовок
        spinnerType.setPrompt("Тип окна");
        // выделяем элемент
        spinnerType.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionType, long idType) {

                positionType1 = positionType;
                workFlag = true;
                setWorkPrice();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//________________________ДОПОЛНИТЕЛЬНЫЙ ТИП________________________________________________________

        spinnerTypeOfType.setAdapter(adapterTypeOfType);
        // заголовок
        spinnerTypeOfType.setPrompt("Тип");
        // выделяем элемент
        spinnerTypeOfType.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerTypeOfType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionTypeOfType, long idTypeOfType) {

                positionTypeOfType1 = positionTypeOfType;
                workFlag = true;
                setWorkPrice();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;

//________________________ДОПОЛНИТЕЛЬНЫЙ ТИП 2________________________________________________________

        spinnerTypeOfType2.setAdapter(adapterTypeOfType2);
        // заголовок
        spinnerTypeOfType2.setPrompt("Тип");
        // выделяем элемент
        spinnerTypeOfType2.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerTypeOfType2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionTypeOfType2, long idTypeOfType2) {

                positionTypeOfType1_2 = positionTypeOfType2;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//________________________Регион_______________________________________________________
        spinnerRegion.setAdapter(adapterRegion);
        // заголовок
        spinnerRegion.setPrompt("Тип");
        // выделяем элемент
        spinnerRegion.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerRegion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionRegion, long idRegion) {

                if(MainActivity.hashMap.get(MainActivity.nameMeasure).getRegion()) {
                    spinnerRegion.setSelection(0);
                    region = true;
                }else {
                    spinnerRegion.setSelection(1);
                    region = false;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________________________________ВЫСОТА_______________________________________________________
        spinnerHight.setAdapter(adapterHightWork);
        // заголовок
        spinnerHight.setPrompt("Высота");
        // выделяем элемент
        spinnerHight.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerHight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionHight, long idRHight) {

               positionHight1 = positionHight;

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________________________________ШИРИНА_______________________________________________________
        spinnerWidth.setAdapter(adapterWidthWork);
        // заголовок
        spinnerWidth.setPrompt("Ширина");
        // выделяем элемент
        spinnerWidth.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerWidth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionWidth, long idWidth) {

                positionWidth1 = positionWidth;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//---------------------------------КНОПКИ------------------------
        setDopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.startAnimation(animAlpha);
                setWorkPrice();
                String itemName = dataWork.get(positionWork1) + " " + dataType.get(positionType1) + " " +
                        (positionWork1 == 0 ? positionType1 == 3 ? dataTypeOfType.get(positionTypeOfType1) : positionType1 == 4 ? dataTypeOfType.get(positionTypeOfType1) + " " + dataHightWork.get(positionHight1) + " " + dataWidthWork.get(positionWidth1) : "" :
                                positionWork1 == 1 ? positionType1 == 3 ? dataTypeOfType.get(positionTypeOfType1) + " " + dataTypeOfType2.get(positionTypeOfType1_2): dataTypeOfType.get(positionTypeOfType1) :
                                "");
                String itemInfo = "";

                //Если монтаж
                if (positionWork1 == 0 || positionWork1 == 1) {
                    ProductList.addProdLst(itemName, 0.0, 0, priceWork,0);
                    MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, priceWork, 0);
                }
                //Если монтаж откосов или нащельников
                else {
                    ProductList.addProdLst(itemName, 0.0, 0,0,priceWork);
                    MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, 0, priceWork);
                }

                try {
                    writeHash(MainActivity.hashMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

            }
        });
//________________________________________
        prodLstBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(prodListBut);

            }
        });

    }
//________________________________________

    public void setWorkPrice() {

        //Монтаж окон
        if(dataWork.get(positionWork1).equals("Монтаж окон")) {
            if (workFlag) {
                workFlag = false;

                //Очищает список Типов и устанавливает список для монтажей
                adapterType.clear();
                adapterType.addAll(addList(R.array.dtaTypeWork));
                spinnerTypeOfType2.setVisibility(View.INVISIBLE);

                adapterHightWork.clear();
                adapterHightWork.addAll(addList(R.array.dtaHightWork));
                spinnerHight.setVisibility(View.INVISIBLE);
                spinnerWidth.setVisibility(View.INVISIBLE);
                textHight.setVisibility(View.INVISIBLE);
                textWidth.setVisibility(View.INVISIBLE);
                textXWork.setVisibility(View.INVISIBLE);
            //--------------------------------------------------------------------------------------

                //Если выбран балконный блок
                if(positionType1 == 3) {
                    //Список тип2 устанавливает для балконного блока и показывается
                    spinnerTypeOfType.setVisibility(View.VISIBLE);
                    adapterTypeOfType.clear();
                    adapterTypeOfType.addAll(addList(R.array.dtaTypeWorkBalBlock));
                }

                //Если выбрали балконную раму
                else if (positionType1 == 4) {
                    //Список тип2 устанавливает для Балконной рамы и показывается
                    spinnerTypeOfType.setVisibility(View.VISIBLE);
                    adapterTypeOfType.clear();
                    adapterTypeOfType.addAll(addList(R.array.dtaTypeWorkBalRam1));

                    //Если полукруглая рама
                    if (positionTypeOfType1 == 3) {
                        adapterTypeOfType2.clear();
                        adapterTypeOfType2.addAll(addList(R.array.dtaTypeWorkBalRam3));
                    }
                    //Если прямая П, Г образная рама
                    else {
                        //Показываем ширину и длину
                        adapterWidthWork.clear();
                        adapterWidthWork.addAll(addList(R.array.dtaTypeWorkBalRam2));
                        spinnerHight.setVisibility(View.VISIBLE);
                        spinnerWidth.setVisibility(View.VISIBLE);
                        textHight.setVisibility(View.VISIBLE);
                        textWidth.setVisibility(View.VISIBLE);
                        textXWork.setVisibility(View.VISIBLE);
                    }
                }

                //Если окно 3 створки
                else if (positionType1 == 2) {
                    //Список тип2 очищается и скрывается
                    spinnerTypeOfType.setVisibility(View.INVISIBLE);
                    adapterTypeOfType.clear();

                    //Показываем Высоиу и Ширину
                    adapterWidthWork.clear();
                    adapterWidthWork.addAll(addList(R.array.dtaWidthWork));
                    spinnerHight.setVisibility(View.VISIBLE);
                    spinnerWidth.setVisibility(View.VISIBLE);
                    textHight.setVisibility(View.VISIBLE);
                    textWidth.setVisibility(View.VISIBLE);
                    textXWork.setVisibility(View.VISIBLE);
                }

                //Если все осталоное
                else {
                    //Список тип2 очищается и скрывается
                    spinnerTypeOfType.setVisibility(View.INVISIBLE);
                    adapterTypeOfType.clear();
                    //Показывем Высоту
                    spinnerHight.setVisibility(View.VISIBLE);
                    textHight.setVisibility(View.VISIBLE);
                }
            }

            //После нажатия на кнопку добавить
            else{
                //Если регион
                if (region) {

                    //1 створчатое окно
                    if (positionType1 == 0) {
                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {
                            priceWork = MainActivity.prices.WORK1ST_R;
                        }
                        //Если высота свыше 1610 мм
                        else {
                            priceWork = MainActivity.prices.WORK1ST_R + MainActivity.prices.WORKMORE_R;
                        }

                    }

                    //2 створчатое окно
                    else if (positionType1 == 1) {
                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {
                            priceWork = MainActivity.prices.WORK2ST_R;
                        }
                        //Если высота свыше 1610 мм
                        else {
                            priceWork = MainActivity.prices.WORK2ST_R + MainActivity.prices.WORKMORE_R;
                        }
                    }

                    //3 створчатое окно
                    else if (positionType1 == 2) {

                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {

                            //Если ширина до 2510 мм
                            if (positionWidth1 == 0) {
                                priceWork = MainActivity.prices.WORK3ST_R;
                            }

                            //Если ширина свыше 2510 мм
                            else {
                                priceWork = MainActivity.prices.WORK3ST_R + MainActivity.prices.WORKMORE_R;
                            }
                        }
                        //Если высота свыше 1610 мм
                        else {

                            //Если ширина до 2510 мм
                            if(positionWidth1 == 0) {
                                priceWork = MainActivity.prices.WORK3ST_R + MainActivity.prices.WORKMORE_R;
                            }

                            //Если ширина свыше 2510 мм
                            else {
                                priceWork = MainActivity.prices.WORK3ST_R + MainActivity.prices.WORKMORE_R + MainActivity.prices.WORKMORE_R;
                            }

                        }
                    }

                    //Балконный блок
                    else if (positionType1 == 3) {
                        //Если балконный блок с 1 окном
                        if (positionTypeOfType1 == 0) {
                            priceWork = MainActivity.prices.WORKBALBLOCK1_R;
                        }
                        //Если чебурашка
                        else{
                            priceWork = MainActivity.prices.WORKBALBLOCK2_R;
                        }
                    }

                    //Балконная рама
                    else {
                        //Если прямая рама
                        if (positionTypeOfType1 == 0) {

                            //Если ширина до 3300
                            if (positionWidth1 == 0) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST1_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST1_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                            //Если ширина 3300 - 4300
                            if (positionWidth1 == 1) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST2_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST2_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                            //Если ширина свыше 4300
                            if (positionWidth1 == 2) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST3_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST3_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                            //Если ширина свыше 5000
                            if (positionWidth1 == 3) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST4_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST4_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                        }

                        //Если Г - образная рама
                        else if (positionTypeOfType1 == 1){

                            //Если ширина до 3300
                            if (positionWidth1 == 0) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST1_R + MainActivity.prices.WORK4ST5_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST1_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если ширина 3300 - 4300
                            if (positionWidth1 == 1) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST2_R + MainActivity.prices.WORK4ST5_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST2_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если ширина свыше 4300
                            if (positionWidth1 == 2) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST3_R + MainActivity.prices.WORK4ST5_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST3_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если ширина свыше 5000
                            if (positionWidth1 == 3) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST4_R + MainActivity.prices.WORK4ST5_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST4_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                        }

                        //Если П - образная рама
                        else if (positionTypeOfType1 == 2){

                            //Если ширина до 3300
                            if (positionWidth1 == 0) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST1_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORK4ST5_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST1_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если ширина 3300 - 4300
                            if (positionWidth1 == 1) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST2_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORK4ST5_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST2_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если ширина свыше 4300
                            if (positionWidth1 == 2) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST3_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORK4ST5_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST3_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если ширина свыше 5000
                            if (positionWidth1 == 3) {
                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST4_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORK4ST5_R;
                                }
                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST4_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORK4ST5_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                        }

                        //Если полукруглая рама
                        else {
                            //Если из 4 частей
                            if (positionTypeOfType1_2 == 0) {
                                priceWork = MainActivity.prices.WORKPOLRAM1_R;
                            }
                            //Если из 5 частей
                            if (positionTypeOfType1_2 == 1) {
                                priceWork = MainActivity.prices.WORKPOLRAM2_R;
                            }
                        }

                    }
                }

                //Если Минск
                else {

                    //1 створчатое окно
                    if (positionType1 == 0) {
                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {
                            priceWork = MainActivity.prices.WORK1ST_M;
                        }
                        //Если высота свыше 1610 мм
                        else {
                            priceWork = MainActivity.prices.WORK1ST_M + MainActivity.prices.WORKMORE_M;
                        }

                    }

                    //2 створчатое окно
                    else if (positionType1 == 1) {
                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {
                            priceWork = MainActivity.prices.WORK2ST_M;
                        }
                        //Если высота свыше 1610 мм
                        else {
                            priceWork = MainActivity.prices.WORK2ST_M + MainActivity.prices.WORKMORE_M;
                        }
                    }

                    //3 створчатое окно
                    else if (positionType1 == 2) {
                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {
                            //Если ширина до 2510 мм
                            if (positionWidth1 == 0) {
                                priceWork = MainActivity.prices.WORK3ST_M;
                            }
                            //Если ширина свыше 2510 мм
                            else {
                                priceWork = MainActivity.prices.WORK3ST_M + MainActivity.prices.WORKMORE_M;
                            }
                        }
                        //Если высота свыше 1610 мм
                        else {
                            //Если ширина до 2510 мм
                            if(positionWidth1 == 0) {
                                priceWork = MainActivity.prices.WORK3ST_M + MainActivity.prices.WORKMORE_M;
                            }
                            //Если ширина свыше 2510 мм
                            else {
                                priceWork = MainActivity.prices.WORK3ST_M + MainActivity.prices.WORKMORE_M + MainActivity.prices.WORKMORE_M;
                            }

                        }
                    }

                    //Балконный блок
                    else if (positionType1 == 3) {
                        //Если балконный блок с 1 окном
                        if (positionTypeOfType1 == 0) {
                            priceWork = MainActivity.prices.WORKBALBLOCK1_M;
                        }
                        //Если чебурашка
                        else{
                            priceWork = MainActivity.prices.WORKBALBLOCK2_M;
                        }
                    }

                    //Балконная рама
                    else {

                        //Если прямая рама
                        if (positionTypeOfType1 == 0) {

                            //Если ширина до 3300
                            if (positionWidth1 == 0) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST1_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST1_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если ширина 3300 - 4300
                            if (positionWidth1 == 1) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST2_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST2_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если ширина свыше 4300
                            if (positionWidth1 == 2) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST3_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST3_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если ширина свыше 5000
                            if (positionWidth1 == 3) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST4_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST4_M + MainActivity.prices.WORKMORE_M;
                                }
                            }
                        }

                        //Если Г - образная рама
                        else if (positionTypeOfType1 == 1){

                            //Если ширина до 3300
                            if (positionWidth1 == 0) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST1_M + MainActivity.prices.WORK4ST5_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST1_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если ширина 3300 - 4300
                            if (positionWidth1 == 1) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST2_M + MainActivity.prices.WORK4ST5_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST2_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если ширина свыше 4300
                            if (positionWidth1 == 2) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST3_M + MainActivity.prices.WORK4ST5_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST3_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если ширина свыше 5000
                            if (positionWidth1 == 3) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST4_M + MainActivity.prices.WORK4ST5_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST4_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                        }

                        //Если П - образная рама
                        else if (positionTypeOfType1 == 2){

                            //Если ширина до 3300
                            if (positionWidth1 == 0) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST1_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORK4ST5_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST1_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если ширина 3300 - 4300
                            if (positionWidth1 == 1) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST2_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORK4ST5_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST2_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если ширина свыше 4300
                            if (positionWidth1 == 2) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST3_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORK4ST5_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST3_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если ширина свыше 5000
                            if (positionWidth1 == 3) {

                                //Если высота до 1610 мм
                                if (positionHight1 == 0) {
                                    priceWork = MainActivity.prices.WORK4ST4_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORK4ST5_M;
                                }

                                //Если высота свыше 1610 мм
                                else {
                                    priceWork = MainActivity.prices.WORK4ST4_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORK4ST5_M + MainActivity.prices.WORKMORE_M;
                                }
                            }
                        }

                        //Если полукруглая рама
                        else {
                            //Если из 4 частей
                            if (positionTypeOfType1_2 == 0) {
                                priceWork = MainActivity.prices.WORKPOLRAM1_M;
                            }
                            //Если из 5 частей
                            if (positionTypeOfType1_2 == 1) {
                                priceWork = MainActivity.prices.WORKPOLRAM2_M;
                            }
                        }

                    }
                }

            }
        }

        //Монтаж дверей
        if(dataWork.get(positionWork1).equals("Монтаж дверей")) {
            if (workFlag) {
                workFlag = false;

                //Очищает список Типов и устанавливает список для монтажей дверей
                adapterType.clear();
                adapterType.addAll(addList(R.array.dtaWorkDoor));
                spinnerTypeOfType2.setVisibility(View.INVISIBLE);

                //Тип 1 устанавливаем для дверей(с фрамугой и без)
                adapterTypeOfType.clear();
                adapterTypeOfType.addAll(addList(R.array.dtaWorkDoorType1));

                //Устанавливаем выбор высоты для дверей
                adapterHightWork.clear();
                adapterHightWork.addAll(addList(R.array.dtaWorkDoorHight));

                spinnerTypeOfType.setVisibility(View.VISIBLE);
                spinnerHight.setVisibility(View.VISIBLE);
                spinnerWidth.setVisibility(View.VISIBLE);
                textHight.setVisibility(View.VISIBLE);
                textWidth.setVisibility(View.VISIBLE);
                textXWork.setVisibility(View.VISIBLE);
                //--------------------------------------------------------------------------------------

                //Если выбрана одностворчатая дверь
                if(positionType1 == 0) {
                    adapterWidthWork.clear();
                    adapterWidthWork.addAll(addList(R.array.dtaWorkDoorWidth1));
                }
                //Если выбрана штульповая дверь
                else {
                    adapterWidthWork.clear();
                    adapterWidthWork.addAll(addList(R.array.dtaWorkDoorWidth2));
                }
            }

            //После нажатия на кнопку добавить
            else{
                //Если регион
                if (region) {

                    //Если одностворчатая дверь
                    if(positionType1 == 0) {

                        //Если без фрамуги
                        if (positionTypeOfType1 == 0) {

                            //Если высота до 2100 мм
                            if (positionHight1 == 0) {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR1ST_R;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR1ST_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если высота свыше 2100 мм
                            else {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR1ST_R + MainActivity.prices.WORKMORE_R;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR1ST_R + MainActivity.prices.WORKMORE_R + MainActivity.prices.WORKMORE_R;
                                }

                            }
                        }

                        //Если с фрамугой
                        else {

                            //Если высота до 2100 мм
                            if (positionHight1 == 0) {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR1STF_R;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR1STF_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если высота свыше 2100 мм
                            else {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR1STF_R + MainActivity.prices.WORKMORE_R;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR1STF_R + MainActivity.prices.WORKMORE_R + MainActivity.prices.WORKMORE_R;
                                }

                            }
                        }
                    }

                    //Если штульповая дверь
                    else {

                        //Если без фрамуги
                        if (positionTypeOfType1 == 0) {

                            //Если высота до 2100 мм
                            if (positionHight1 == 0) {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR2ST_R;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR2ST_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если высота свыше 2100 мм
                            else {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR2ST_R + MainActivity.prices.WORKMORE_R;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR2ST_R + MainActivity.prices.WORKMORE_R + MainActivity.prices.WORKMORE_R;
                                }

                            }
                        }

                        //Если с фрамугой
                        else {

                            //Если высота до 2100 мм
                            if (positionHight1 == 0) {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR2STF_R;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR2STF_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если высота свыше 2100 мм
                            else {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR2STF_R + MainActivity.prices.WORKMORE_R;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR2STF_R + MainActivity.prices.WORKMORE_R + MainActivity.prices.WORKMORE_R;
                                }

                            }
                        }
                    }
                }

                //Если Минск
                else {

                    //Если одностворчатая дверь
                    if(positionType1 == 0) {

                        //Если без фрамуги
                        if (positionTypeOfType1 == 0) {

                            //Если высота до 2100 мм
                            if (positionHight1 == 0) {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR1ST_M;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR1ST_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если высота свыше 2100 мм
                            else {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR1ST_M + MainActivity.prices.WORKMORE_M;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR1ST_M + MainActivity.prices.WORKMORE_M + MainActivity.prices.WORKMORE_M;
                                }

                            }
                        }

                        //Если с фрамугой
                        else {

                            //Если высота до 2100 мм
                            if (positionHight1 == 0) {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR1STF_M;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR1STF_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если высота свыше 2100 мм
                            else {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR1STF_M + MainActivity.prices.WORKMORE_M;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR1STF_M + MainActivity.prices.WORKMORE_M + MainActivity.prices.WORKMORE_M;
                                }

                            }
                        }
                    }

                    //Если штульповая дверь
                    else {

                        //Если без фрамуги
                        if (positionTypeOfType1 == 0) {

                            //Если высота до 2100 мм
                            if (positionHight1 == 0) {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR2ST_M;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR2ST_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если высота свыше 2100 мм
                            else {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR2ST_M + MainActivity.prices.WORKMORE_M;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR2ST_M + MainActivity.prices.WORKMORE_M + MainActivity.prices.WORKMORE_M;
                                }

                            }
                        }

                        //Если с фрамугой
                        else {

                            //Если высота до 2100 мм
                            if (positionHight1 == 0) {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR2STF_M;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR2STF_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если высота свыше 2100 мм
                            else {

                                //Если ширина до 1000 мм
                                if (positionWidth1 == 0) {
                                    priceWork = MainActivity.prices.WORKDOOR2STF_M + MainActivity.prices.WORKMORE_M;
                                }

                                //Если ширина свыше 1000 мм
                                else {
                                    priceWork = MainActivity.prices.WORKDOOR2STF_M + MainActivity.prices.WORKMORE_M + MainActivity.prices.WORKMORE_M;
                                }

                            }
                        }
                    }
                }

            }
        }

        //Монтаж откосов
        if(dataWork.get(positionWork1).equals("Монтаж откосов")) {
            if (workFlag) {
                workFlag = false;
                //Список ТИП очищается и устанавливается для откосов
                adapterType.clear();
                adapterType.addAll(addList(R.array.dtaTypeWork2));
                spinnerTypeOfType2.setVisibility(View.INVISIBLE);

                spinnerHight.setVisibility(View.INVISIBLE);
                spinnerWidth.setVisibility(View.INVISIBLE);
                textHight.setVisibility(View.INVISIBLE);
                textWidth.setVisibility(View.INVISIBLE);
                textXWork.setVisibility(View.INVISIBLE);

                //Если выбрана Дверь ПВХ
                if(positionType1 == 4) {
                    //Список тип2_2 устанавливает для балконного блока и показывается
                    adapterTypeOfType2.clear();
                    adapterTypeOfType2.addAll(addList(R.array.dtaWorkDoor2));
                    spinnerTypeOfType2.setVisibility(View.VISIBLE);

                    adapterHightWork.clear();
                    adapterHightWork.addAll(addList(R.array.dtaWorkDoorHight));
                    spinnerHight.setVisibility(View.VISIBLE);
                    textHight.setVisibility(View.VISIBLE);
                }
                //Если выбран балконный блок
                else if(positionType1 == 3) {
                    //Список тип2_2 устанавливает для балконного блока и показывается
                    adapterTypeOfType2.clear();
                    adapterTypeOfType2.addAll(addList(R.array.dtaTypeWorkBalBlock));
                    spinnerTypeOfType2.setVisibility(View.VISIBLE);
                }
                //Если окно 3 створки
                else if (positionType1 == 2) {
                    adapterHightWork.clear();
                    adapterHightWork.addAll(addList(R.array.dtaHightWork));
                    spinnerHight.setVisibility(View.VISIBLE);
                    spinnerWidth.setVisibility(View.VISIBLE);
                    textHight.setVisibility(View.VISIBLE);
                    textWidth.setVisibility(View.VISIBLE);
                    textXWork.setVisibility(View.VISIBLE);
                    adapterWidthWork.clear();
                    adapterWidthWork.addAll(addList(R.array.dtaWidthWork));
                }

                else {
                    adapterHightWork.clear();
                    adapterHightWork.addAll(addList(R.array.dtaHightWork));
                    spinnerHight.setVisibility(View.VISIBLE);
                    textHight.setVisibility(View.VISIBLE);
                }

                //Если регион
                if (region) {
                    spinnerTypeOfType.setVisibility(View.VISIBLE);
                    adapterTypeOfType.clear();
                    adapterTypeOfType.addAll(addList(R.array.dtaTypeWorkSlopes));
                }
                //Минск
                else {
                    spinnerTypeOfType.setVisibility(View.VISIBLE);
                    adapterTypeOfType.clear();
                    adapterTypeOfType.addAll(addList(R.array.dtaTypeWorkSlopes));
                }
            }

            //После нажатия на кнопку добавить
            else{
                //Если регион
                if(region) {
                    //1 створчатое
                    if (positionType1 == 0) {

                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLP1ST1_R;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLP1ST2_R;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLP1ST3_R;
                            }
                        }

                        //Если высота свыше 1610 мм
                        else {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLP1ST1_R + MainActivity.prices.WORKMORE_R;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLP1ST2_R + MainActivity.prices.WORKMORE_R;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLP1ST3_R + MainActivity.prices.WORKMORE_R;
                            }
                        }

                    }

                    //2 створчатое
                    else if (positionType1 == 1) {

                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLP2ST1_R;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLP2ST2_R;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLP2ST3_R;
                            }
                        }

                        //Если высота свыше 1610 мм
                        else {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLP2ST1_R + MainActivity.prices.WORKMORE_R;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLP2ST2_R + MainActivity.prices.WORKMORE_R;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLP2ST3_R + MainActivity.prices.WORKMORE_R;
                            }
                        }

                    }

                    //3 створчатое
                    else if (positionType1 == 2) {

                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {

                            //Если ширина до 2510 мм
                            if (positionWidth1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLP3ST1_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLP3ST2_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLP3ST3_R;
                                }
                            }

                            //Если ширина свыше 2510 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLP3ST1_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLP3ST2_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLP3ST3_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                        }

                        //Если высота свыше 1610 мм
                        else {

                            //Если ширина до 2510 мм
                            if (positionWidth1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLP3ST1_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLP3ST2_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLP3ST3_R + MainActivity.prices.WORKMORE_R;
                                }
                            }

                            //Если ширина свыше 2510 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLP3ST1_R + MainActivity.prices.WORKMORE_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLP3ST2_R + MainActivity.prices.WORKMORE_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLP3ST3_R + MainActivity.prices.WORKMORE_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                        }

                    }

                    //Балконный блок
                    else if (positionType1 == 3) {
                        //Если не чебурашка
                        if(positionTypeOfType1_2 == 0) {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLPBALBLOCK1_1_R;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLPBALBLOCK1_2_R;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLPBALBLOCK1_3_R;
                            }
                        }

                        //Если ЧЕБУРАШКА
                        else {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLPBALBLOCK2_1_R;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLPBALBLOCK2_2_R;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLPBALBLOCK2_3_R;
                            }
                        }

                    }

                    //Дверь ПВХ
                    else {

                        //Если одностворчатая дверь без фрамуги
                        if (positionTypeOfType1_2 == 0) {

                            //Если Высота до 2100 мм
                            if (positionHight1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR1ST1_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR1ST2_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR1ST3_R;
                                }
                            }

                            //Если Высота свыше 2100 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR1ST1_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR1ST2_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR1ST3_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                        }

                        //Если Штульповая дверь без фрамуги
                        else if (positionTypeOfType1_2 == 1) {

                            //Если Высота до 2100 мм
                            if (positionHight1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR2ST1_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR2ST2_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR2ST3_R;
                                }
                            }

                            //Если Высота свыше 2100 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR2ST1_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR2ST2_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR2ST3_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                        }

                        //Если одностворчатая дверь c фрамугой
                        else if (positionTypeOfType1_2 == 2) {

                            //Если Высота до 2100 мм
                            if (positionHight1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR1STF1_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR1STF2_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR1STF3_R;
                                }
                            }

                            //Если Высота свыше 2100 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR1STF1_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR1STF2_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR1STF3_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                        }

                        //Если Штульповая дверь с фрамугой
                        else {

                            //Если Высота до 2100 мм
                            if (positionHight1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR2STF1_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR2STF2_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR2STF3_R;
                                }
                            }

                            //Если Высота свыше 2100 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR2STF1_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR2STF2_R + MainActivity.prices.WORKMORE_R;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR2STF3_R + MainActivity.prices.WORKMORE_R;
                                }
                            }
                        }
                    }
                }

                //если Минск
                else {
                    //1 створчатое
                    if (positionType1 == 0) {

                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLP1ST1_M;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLP1ST2_M;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLP1ST3_M;
                            }
                        }

                        //Если высота свыше 1610 мм
                        else {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLP1ST1_M + MainActivity.prices.WORKMORE_M;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLP1ST2_M + MainActivity.prices.WORKMORE_M;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLP1ST3_M + MainActivity.prices.WORKMORE_M;
                            }
                        }

                    }

                    //2 створчатое
                    else if (positionType1 == 1) {

                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLP2ST1_M;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLP2ST2_M;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLP2ST3_M;
                            }
                        }

                        //Если высота свыше 1610 мм
                        else {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLP2ST1_M + MainActivity.prices.WORKMORE_M;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLP2ST2_M + MainActivity.prices.WORKMORE_M;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLP2ST3_M + MainActivity.prices.WORKMORE_M;
                            }
                        }

                    }

                    //3 створчатое
                    else if (positionType1 == 2) {

                        //Если высота до 1610 мм
                        if (positionHight1 == 0) {

                            //Если ширина до 2510 мм
                            if (positionWidth1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLP3ST1_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLP3ST2_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLP3ST3_M;
                                }
                            }

                            //Если ширина свыше 2510 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLP3ST1_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLP3ST2_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLP3ST3_M + MainActivity.prices.WORKMORE_M;
                                }
                            }
                        }

                        //Если высота свыше 1610 мм
                        else {

                            //Если ширина до 2510 мм
                            if (positionWidth1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLP3ST1_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLP3ST2_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLP3ST3_M + MainActivity.prices.WORKMORE_M;
                                }
                            }

                            //Если ширина свыше 2510 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLP3ST1_M + MainActivity.prices.WORKMORE_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLP3ST2_M + MainActivity.prices.WORKMORE_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLP3ST3_M + MainActivity.prices.WORKMORE_M + MainActivity.prices.WORKMORE_M;
                                }
                            }
                        }

                    }

                    //Балконный блок
                    else if (positionType1 == 3) {
                        //Если не чебурашка
                        if(positionTypeOfType1_2 == 0) {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLPBALBLOCK1_1_M;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLPBALBLOCK1_2_M;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLPBALBLOCK1_3_M;
                            }
                        }

                        //Если ЧЕБУРАШКА
                        else {
                            //До 250 мм
                            if (positionTypeOfType1 == 0) {
                                priceWork = MainActivity.prices.SLPBALBLOCK2_1_M;
                            }
                            //Свыше 250 мм
                            else if (positionTypeOfType1 == 1) {
                                priceWork = MainActivity.prices.SLPBALBLOCK2_2_M;
                            }
                            //Свыше 450 мм
                            else {
                                priceWork = MainActivity.prices.SLPBALBLOCK2_3_M;
                            }
                        }

                    }

                    //Дверь ПВХ
                    else {

                        //Если одностворчатая дверь без фрамуги
                        if (positionTypeOfType1_2 == 0) {

                            //Если Высота до 2100 мм
                            if (positionHight1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR1ST1_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR1ST2_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR1ST3_M;
                                }
                            }

                            //Если Высота свыше 2100 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR1ST1_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR1ST2_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR1ST3_M + MainActivity.prices.WORKMORE_M;
                                }
                            }
                        }

                        //Если Штульповая дверь без фрамуги
                        else if (positionTypeOfType1_2 == 1) {

                            //Если Высота до 2100 мм
                            if (positionHight1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR2ST1_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR2ST2_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR2ST3_M;
                                }
                            }

                            //Если Высота свыше 2100 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR2ST1_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR2ST2_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR2ST3_M + MainActivity.prices.WORKMORE_M;
                                }
                            }
                        }

                        //Если одностворчатая дверь c фрамугой
                        else if (positionTypeOfType1_2 == 2) {

                            //Если Высота до 2100 мм
                            if (positionHight1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR1STF1_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR1STF2_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR1STF3_M;
                                }
                            }

                            //Если Высота свыше 2100 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR1STF1_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR1STF2_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR1STF3_M + MainActivity.prices.WORKMORE_M;
                                }
                            }
                        }

                        //Если Штульповая дверь с фрамугой
                        else {

                            //Если Высота до 2100 мм
                            if (positionHight1 == 0) {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR2STF1_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR2STF2_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR2STF3_M;
                                }
                            }

                            //Если Высота свыше 2100 мм
                            else {
                                //До 250 мм
                                if (positionTypeOfType1 == 0) {
                                    priceWork = MainActivity.prices.SLPDOOR2STF1_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 250 мм
                                else if (positionTypeOfType1 == 1) {
                                    priceWork = MainActivity.prices.SLPDOOR2STF2_M + MainActivity.prices.WORKMORE_M;
                                }
                                //Свыше 450 мм
                                else {
                                    priceWork = MainActivity.prices.SLPDOOR2STF3_M + MainActivity.prices.WORKMORE_M;
                                }
                            }
                        }
                    }
                }

            }
        }

        //Монтаж нащельников
        if(dataWork.get(positionWork1).equals("Монтаж нащельников")) {
            if (workFlag) {
                workFlag = false;
                //Очищает список Типов и устанавливает список для монтажей
                adapterType.clear();
                adapterType.addAll(addList(R.array.dtaTypeWorkNash));
                spinnerTypeOfType.setVisibility(View.INVISIBLE);
                spinnerTypeOfType2.setVisibility(View.INVISIBLE);
                spinnerHight.setVisibility(View.INVISIBLE);
                spinnerWidth.setVisibility(View.INVISIBLE);
                textHight.setVisibility(View.INVISIBLE);
                textWidth.setVisibility(View.INVISIBLE);
                textXWork.setVisibility(View.INVISIBLE);

            }

            //Вызывается при нажатии на кнопку добавить
            else {
                //С 1 стороны
                if(positionType1 == 0) {
                    priceWork = MainActivity.prices.WORKNASH;
                }
                //С 2 сторон
                else  {
                    priceWork = MainActivity.prices.WORKNASH + MainActivity.prices.WORKNASH;
                }
            }
        }
    }


    public List<String> addList(@ArrayRes int id) {
        return Arrays.asList(getResources().getStringArray(id));
    }

    public void writeHash(LinkedHashMap<String, Measure> wHashMap) throws IOException {
        Gson gson = new Gson();
        FileOutputStream fos;

        String json = gson.toJson(wHashMap);
        json = gson.toJson(ContinePrice.compress(json));
        fos = new FileOutputStream(getExternalPath());
        fos.write(json.getBytes());
    }
    private File getExternalPath() {
        return new File(getExternalFilesDir(null), MainActivity.fileName);
    }

}
