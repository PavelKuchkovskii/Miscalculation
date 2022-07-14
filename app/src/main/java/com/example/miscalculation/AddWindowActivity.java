package com.example.miscalculation;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import android.widget.Button;
import android.widget.Toast;

import com.example.miscalculation.excelUtill.ExcelCreator;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import handles.AdapterHandleFurnit;
import handles.HandleFurnit;


public class AddWindowActivity extends AppCompatActivity {

    static boolean addFromList = false;

    static boolean flag = false;
    static boolean balDorFlag = false;
    static boolean gluhFlag = false;
    static boolean getPriceFlag = false;
    static boolean BB6024 = false;
    static boolean BB6032 = false;
    static boolean rehauIntelio = false;

    //Группа ламинации
    static int GROUP;


    static Spinner spinnerType = null;
    static Spinner spinnerProfile = null;
    static Spinner spinnerTypeOfGlass = null;
    static Spinner spinnerFurnit = null;
    static Spinner spinnerTypeOfType = null;
    static Spinner spinnerHight = null;
    static Spinner spinnerWidth = null;
    static Spinner spinnerLamination = null;
    static Spinner spinnerLaminationVar = null;
    static Spinner spinnerRegion = null;
    static Spinner spinnerShpros = null;
    static Spinner spinnerShprosWidth = null;
    static Spinner spinnerGlassDif = null;
    static Spinner spinnerFigure = null;
    static Spinner spinnerFilling = null;
    static Spinner spinnerHandle = null;
    static Spinner spinnerShtulp = null;

    static int positionType1;
    static int positionTypeOfType1;
    static int positionHight1;
    static int positionWidth1;
    static int positionFurnit1;
    static int positionProfile1;
    static int positionTypeOfGlass1;
    static int positionLamination1;
    static int positionLaminationVar1;
    static int positionRegion1;
    static int positionShpros1;
    static int positionShprosWidth1;
    static int positionGlassDif1;
    static int positionFigure1;
    static int positionFilling1;
    static int positionHandle1;
    static int positionShtulp1;

    private CheckBox addToPocketFlag;


    static int price;

    static int pocketPrice;

    static double furnitPrice;
    static int itemInterest;
    static double priceFigure;
    static double priceHandle;
    static int priceShtulp;

    static double profileCoefficient;
    static double laminationCoefficient;
    static double priceGlass;
    static double lam;
    static double shpros;

    static List<String> dataTypeOfType = new ArrayList<>();
    static List<String> dataTypeOfGlass = new ArrayList<>();
    static List<String> dataFurnit = new ArrayList<>();
    static List<String> dataLamination = new ArrayList<>();
    static List<String> dataLaminationVar = new ArrayList<>();
    static List<String> dataRegion = new ArrayList<>();
    static List<String> dataProfile = new ArrayList<>();
    static List<String> dataHight = new ArrayList<>();
    static List<String> dataWidth = new ArrayList<>();
    static List<String> dataShpros = new ArrayList<>();
    static List<String> dataShprosWidth = new ArrayList<>();
    static List<String> dataGlassDif = new ArrayList<>();
    static List<String> dataGlassList = new ArrayList<>();
    static List<String> dataFigure = new ArrayList<>();
    static List<String> dataFilling = new ArrayList<>();
    static List<HandleFurnit> dataHandle = MainActivity.prices.handles;
    static List<HandleFurnit> dataHandleList = new ArrayList<>();
    static List<String> dataShtulp = new ArrayList<>();

//--------------------------------------------------------------------------------------------

    String[] dataType = {"Окно 1 створ.", "Окно 2 створ.", "Окно 3 створ.", "Балконная рама (4 створ.)", "Дверь балконная"};
    Double [] glassPriceItems = {0.0, 0.0, 0.0, 0.0};
    double [] handlePriceItems = {0, 0, 0};

    //--------------------------------------------------------------------------------------------------
    static ArrayAdapter<String> adapterTypeOfType;
    static ArrayAdapter<String> adapterTypeOfGlass;

    static ArrayAdapter<String> adapterFurnit;
    static ArrayAdapter<String> adapterLamination;
    static ArrayAdapter<String> adapterLaminationVar;
    static ArrayAdapter<String> adapterRegion;
    static ArrayAdapter<String> adapterProfile;

    static ArrayAdapter<String> adapterHight;
    static ArrayAdapter<String> adapterWidth;

    static ArrayAdapter<String> adapterShpros;
    static ArrayAdapter<String> adapterShprosWidth;

    static ArrayAdapter<String> adapterGlassDif;
    static ArrayAdapter<String> adapterGlassDifLst;

    static ArrayAdapter<String> adapterFigure;

    static ArrayAdapter<String> adapterFilling;

    static AdapterHandleFurnit<HandleFurnit> adapterHandle;
    static ArrayAdapter<HandleFurnit> adapterHandleLst;

    static ArrayAdapter<String> adapterShtulp;

//-----------------------------------------------------------------------------------------------------
    public AlertDialog.Builder builder;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addwindow);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        final Intent prodListBut = new Intent(AddWindowActivity.this, ProductList.class);

        final ListView listGlassDif = findViewById(R.id.listGlass);
        final ListView listHandle =  findViewById(R.id.listHandle);
//----------------------------------------
        final ArrayAdapter<String> adapterType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataType);

        adapterProfile = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataProfile);

        adapterTypeOfGlass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfGlass);

        adapterFurnit = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataFurnit);

        adapterTypeOfType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfType);

        adapterHight = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataHight);

        adapterWidth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataWidth);

        adapterLamination = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataLamination);
        adapterLaminationVar = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataLaminationVar);

        adapterRegion = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataRegion);

        adapterShpros = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataShpros);

        adapterShprosWidth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataShprosWidth);

        adapterGlassDif = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataGlassDif);
        adapterGlassDifLst = new ArrayAdapter<>(this, R.layout.listglassitem, dataGlassList);
        listGlassDif.setAdapter(adapterGlassDifLst);

        adapterFigure = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataFigure);

        adapterFilling = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataFilling);

        adapterHandle = new AdapterHandleFurnit<>(this, android.R.layout.simple_spinner_item, dataHandle);
        adapterHandleLst = new ArrayAdapter<>(this, R.layout.listglassitem, dataHandleList);
        listHandle.setAdapter(adapterHandleLst);

        adapterShtulp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataShtulp);
//----------------------------------------
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterProfile.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterProfile.clear();
        adapterProfile.addAll(addList(R.array.dtaProfile));

        adapterFurnit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterFurnit.clear();
        adapterFurnit.addAll(addList(R.array.dtaFurnit));

        adapterTypeOfGlass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterTypeOfType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterHight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterWidth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterLamination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterLamination.clear();
        adapterLamination.addAll(addList(R.array.dtaLamination));

        adapterLaminationVar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterLaminationVar.clear();
        adapterLaminationVar.addAll(addList(R.array.laminationVar));

        adapterRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterRegion.clear();
        adapterRegion.addAll(addList(R.array.dtaRegion));

        adapterShpros.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterShpros.clear();
        adapterShpros.addAll(addList(R.array.dtaShpros));

        adapterShprosWidth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterShprosWidth.clear();
        adapterShprosWidth.addAll(addList(R.array.Width_shpros));

        adapterGlassDif.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterGlassDif.clear();
        adapterGlassDif.addAll(addList(R.array.dtaGlassDif));

        adapterFigure.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterFigure.clear();
        adapterFigure.addAll(addList(R.array.dtaFigure));

        adapterFilling.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterFilling.clear();
        adapterFilling.addAll(addList(R.array.Type_Door));

        adapterHandle.setDropDownViewResource(R.layout.layout_spinner_handle);

        adapterShtulp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterShtulp.clear();
        adapterShtulp.addAll(addList(R.array.dtaShtulp));
//----------------------------------------

        spinnerType = findViewById(R.id.spinner_type);

        spinnerProfile = findViewById(R.id.spinner_profile);

        spinnerTypeOfGlass = findViewById(R.id.spinner_typeOfGlass);

        spinnerFurnit = findViewById(R.id.spinner_furnit);
        spinnerFurnit.setVisibility(View.INVISIBLE);

        spinnerTypeOfType = findViewById(R.id.spinner_typeOfType);

        spinnerHight = findViewById(R.id.spinner_hight);

        spinnerWidth = findViewById(R.id.spinner_width);

        spinnerLamination = findViewById(R.id.spinner_lamination);
        spinnerLaminationVar = findViewById(R.id.spinner_laminationVar);
        spinnerLaminationVar.setVisibility(View.INVISIBLE);

        spinnerRegion = findViewById(R.id.spinner_region);
        spinnerRegion.setVisibility(View.INVISIBLE);

        spinnerShpros = findViewById(R.id.spinner_typeOfShpros);

        spinnerShprosWidth = findViewById(R.id.spinner_widthShpros);
        spinnerShprosWidth.setVisibility(View.INVISIBLE);

        spinnerGlassDif = findViewById(R.id.spinner_glassDif);

        spinnerFigure = findViewById(R.id.spinner_figure);

        spinnerFilling = findViewById(R.id.spinner_filling);
        spinnerFilling.setVisibility(View.INVISIBLE);

        spinnerHandle = findViewById(R.id.spinner_handle);
        spinnerHandle.setVisibility(View.INVISIBLE);

        spinnerShtulp = findViewById(R.id.spinner_shtulp);
        spinnerShtulp.setVisibility(View.INVISIBLE);

        addToPocketFlag = findViewById(R.id.addToPocketFlag);

//----------------------------------------
        final Button setTypeButton = findViewById(R.id.button_addType);
        final Button prodLstBut = findViewById(R.id.button_ProdLst);
        final Button addHandleBut = findViewById(R.id.button_addHandle);
        addHandleBut.setVisibility(View.INVISIBLE);
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

                positionHight1 = 0;
                positionWidth1 = 0;
                positionTypeOfType1 = 0;
                positionFilling1 = 0;
                spinnerHight.setSelection(0);
                spinnerWidth.setSelection(0);
                spinnerTypeOfType.setSelection(0);
                spinnerFilling.setSelection(0);


                //Если балконная дверь на что то меняется, окно выбирается глухое
                //Скрывается заполнение, ручки и фурнитура(Так как окно будет сразу глухое)
                //Возвращается фигура и тип окна
                if (balDorFlag == true) {
                    spinnerFilling.setVisibility(View.INVISIBLE);
                    spinnerHandle.setVisibility(View.INVISIBLE);
                    addHandleBut.setVisibility(View.INVISIBLE);
                    spinnerFurnit.setVisibility(View.INVISIBLE);

                    spinnerTypeOfType.setVisibility(View.VISIBLE);
                    spinnerFigure.setVisibility(View.VISIBLE);
                    balDorFlag = false;
                }

                //Когда выбирается балконная дверь
                if (positionType1 == 4) {
                    //Так как тип ставится на глухое нужно показать ручки, фурнитуру и заполнение
                    spinnerHandle.setVisibility(View.VISIBLE);
                    addHandleBut.setVisibility(View.VISIBLE);
                    spinnerFurnit.setVisibility(View.VISIBLE);
                    spinnerFilling.setVisibility(View.VISIBLE);
                    //Скрывается тип окон, фигуры
                    //Фигуры обнуляются
                    spinnerTypeOfType.setVisibility(View.INVISIBLE);

                    spinnerFigure.setVisibility(View.INVISIBLE);
                    priceFigure = 0;
                    positionFigure1 = 0;
                    spinnerFigure.setSelection(0);
                }

                flag = true;
                setPrice(positionType1, positionTypeOfType1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________ТИП ПРОФИЛЯ___________________

        spinnerProfile.setAdapter(adapterProfile);
        // заголовок
        spinnerProfile.setPrompt("Тип профиля");
        // выделяем элемент
        spinnerProfile.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerProfile.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionProfile, long idProfile) {

                positionProfile1 = positionProfile;
                positionTypeOfGlass1 = 0;
                spinnerTypeOfGlass.setSelection(0);

                //Если выбрана балконная дверь и меняется профиль
                if(balDorFlag) {
                    //Если выбрано заполнение сендвичем на 100% или 50%
                    if ( (positionFilling1 == 1 || positionFilling1 == 2) && positionProfile1 != 5) {
                        setProfile(positionProfile1, positionTypeOfGlass1);
                        positionTypeOfGlass1 = 1;
                        spinnerTypeOfGlass.setSelection(1);
                    }
                }

                setProfile(positionProfile1, positionTypeOfGlass1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________________ТИП СТЕКЛОПАКЕТА__________________

        spinnerTypeOfGlass.setAdapter(adapterTypeOfGlass);
        // заголовок
        spinnerTypeOfGlass.setPrompt("Тип стеклопакета");
        // выделяем элемент
        spinnerTypeOfGlass.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerTypeOfGlass.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionTypeOfGlass, long idTypeOfGlass) {

                positionTypeOfGlass1 = positionTypeOfGlass;

                //Если выбрана балконная дверь
                if(balDorFlag) {

                    //Если выбрано заполнение сендвичем на 100 или 50 % и профиль не rehauIntelio
                    if ((positionFilling1 == 1 || positionFilling1 == 2) && !rehauIntelio) {

                        //Если выбран профиль 60мм и пытаются выбрать 24 стеклопакет
                        if( (positionProfile1 == 0 || positionProfile1 == 3) && positionTypeOfGlass1 == 0 ) {
                            positionTypeOfGlass1 = 1;
                            spinnerTypeOfGlass.setSelection(1);
                        }

                        //Если выбран профиль 70мм, но не Rehau intelio
                        else {
                            //Если пытаюстся выбрать стекло 24мм, то автоматически ставится на 32мм
                            if(positionTypeOfGlass1 == 0) {
                                positionTypeOfGlass1 = 1;
                                spinnerTypeOfGlass.setSelection(1);
                            }
                        }
                    }
                }

                setProfile(positionProfile1, positionTypeOfGlass1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________________ФУРНИТУРА__________________
        spinnerFurnit.setAdapter(adapterFurnit);
        // заголовок
        spinnerFurnit.setPrompt("Тип профиля");
        // выделяем элемент
        spinnerFurnit.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerFurnit.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionFurnit, long idFurnit) {
                positionFurnit1 = positionFurnit;
                furnitPrice = 0;

                //Если с выбранной ручкой обязательно ставится рото
                if (!dataHandleList.isEmpty() && dataHandleList.get(0).getROTO()) {
                    positionFurnit1 = 1;
                    spinnerFurnit.setSelection(1);
                }

                //Если выбран штульп и меняют фурнитуру
                if(positionShtulp1 == 1) {
                    //Если пытаются выбрать фурнитуру kale с выбранным штульпом
                    if(positionFurnit1 == 0) {
                        positionFurnit1 = 1;
                        spinnerFurnit.setSelection(1);
                    }
                }

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

                flag = true;
                positionHight1 = 0;
                positionWidth1 = 0;
                positionTypeOfType1 = positionTypeOfType;
                spinnerHight.setSelection(0);
                spinnerWidth.setSelection(0);
                setPrice(positionType1, positionTypeOfType1);

                //Если выбрано гулхое окно (Не балконная дверь) показываем тип фигуры окна и скрываем ручки
                if (positionTypeOfType1 == 0 && !balDorFlag) {
                    priceFigure = 0;
                    positionFigure1 = 0;
                    spinnerFigure.setSelection(0);
                    spinnerFigure.setVisibility(View.VISIBLE);
                    spinnerHandle.setVisibility(View.INVISIBLE);
                    addHandleBut.setVisibility(View.INVISIBLE);
                    spinnerFurnit.setVisibility(View.INVISIBLE);
                }
                //Если выбраны открывающиеся окна и не балконная дверь - возвращаем ручки
                else if (!balDorFlag) {
                    spinnerHandle.setVisibility(View.VISIBLE);
                    addHandleBut.setVisibility(View.VISIBLE);
                    spinnerFurnit.setVisibility(View.VISIBLE);
                }
                //Если балконная дверь, показываем ручки и скрываем фигуры
                else {
                    priceFigure = 0;
                    positionFigure1 = 0;
                    spinnerFigure.setSelection(0);
                    spinnerFigure.setVisibility(View.INVISIBLE);
                    spinnerHandle.setVisibility(View.VISIBLE);
                    addHandleBut.setVisibility(View.VISIBLE);
                    spinnerFurnit.setVisibility(View.VISIBLE);

                }
                //Если выбрано глухое окно или открывающаяся 1 створка
                //Скрывается штульп
                if (positionTypeOfType1 == 0 || positionTypeOfType1 == 1) {
                    positionShtulp1 = 0;
                    spinnerShtulp.setSelection(0);
                    spinnerShtulp.setVisibility(View.INVISIBLE);
                }
                else {
                    spinnerShtulp.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________ФИГУРА__________________

        spinnerFigure.setAdapter(adapterFigure);
        // заголовок
        spinnerFigure.setPrompt("Высота");
        // выделяем элемент
        spinnerFigure.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerFigure.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionFigure, long idFigure) {

                positionFigure1 = positionFigure;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________ЗАПОЛНЕНИЕ__________________

        spinnerFilling.setAdapter(adapterFilling);
        // заголовок
        spinnerFilling.setPrompt("Заполнение");
        // выделяем элемент
        spinnerFilling.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerFilling.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionFilling, long idFilling) {

                positionFilling1 = positionFilling;

                //Если заполнение сендвичем 100 или 50 процентов и не саламандер
                //Стеклопакет ставится на 32 мм
                if ( (positionFilling1 == 1 || positionFilling1 == 2) && !rehauIntelio) {
                    positionTypeOfGlass1 = 1;
                    spinnerTypeOfGlass.setSelection(1);
                }
                //Если заполнение сендвичем стекло 100 или 50 процентов
                //Показывается возможность выбора стекла
                if (positionFilling == 0 || positionFilling == 2) {
                    spinnerGlassDif.setVisibility(View.VISIBLE);
                    listGlassDif.setVisibility(View.VISIBLE);
                }
                //Если заполение сендвичем 100, скрывается возможность выбора стекла и все обновляется
                if (positionFilling == 1) {
                    glassPriceItems[0] = 0.0;
                    glassPriceItems[1] = 0.0;
                    glassPriceItems[2] = 0.0;
                    glassPriceItems[3] = 0.0;
                    adapterGlassDifLst.clear();
                    adapterGlassDifLst.add("Обычное стекло");
                    adapterGlassDifLst.add("Обычное стекло");
                    adapterGlassDifLst.add("Обычное стекло");
                    spinnerGlassDif.setVisibility(View.INVISIBLE);
                    listGlassDif.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________ШТУЛЬП__________________

        spinnerShtulp.setAdapter(adapterShtulp);
        // заголовок
        spinnerShtulp.setPrompt("Заполнение");
        // выделяем элемент
        spinnerShtulp.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerShtulp.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionShtulp, long idShtulp) {

                positionShtulp1 = positionShtulp;

                //Если выбирается штульп, фурнитура ставится ROTO
                if (positionShtulp1 == 1) {
                    positionFurnit1 = 1;
                    spinnerFurnit.setSelection(1);
                }

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
                if (positionLamination1 == 0) {
                    spinnerLaminationVar.setVisibility(View.INVISIBLE);
                }
                else {
                    spinnerLaminationVar.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________ЦВЕТ ЛАМИНАЦИИ_______________

        spinnerLaminationVar.setAdapter(adapterLaminationVar);
        // заголовок
        spinnerLaminationVar.setPrompt("Цвет ламинации");
        // выделяем элемент
        spinnerLaminationVar.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerLaminationVar.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionLaminationVar, long idLaminationVar) {

                positionLaminationVar1 = positionLaminationVar;

                if (positionLaminationVar1 <= 13) {
                    GROUP = 1;
                }
                else if (positionLaminationVar1 <= 36) {
                    GROUP = 2;
                }
                else {
                    GROUP = 3;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//________________РЕГИОН_________________________________________

        spinnerRegion.setAdapter(adapterRegion);
        // заголовок
        spinnerRegion.setPrompt("Регион");
        // выделяем элемент
        spinnerRegion.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerRegion.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionRegion, long idRegion) {

                positionRegion1 = positionRegion;
                if(MainActivity.hashMap.get(MainActivity.nameMeasure).getRegion()) {
                    spinnerRegion.setSelection(0);
                }else {
                    spinnerRegion.setSelection(1);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//________________________ШПРОСЫ_________________________________________

        spinnerShpros.setAdapter(adapterShpros);
        // заголовок
        spinnerShpros.setPrompt("Шпросы");
        // выделяем элемент
        spinnerShpros.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerShpros.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionShpros, long idShpros) {

                positionShpros1 = positionShpros;
                //Если шпросы не выбраны, скрывается их длина
                if (positionShpros1 == 0) {
                    positionShprosWidth1 = 0;
                    spinnerShprosWidth.setSelection(0);
                    spinnerShprosWidth.setVisibility(View.INVISIBLE);
                }
                //Если выбраны, длина показывается
                else {
                    spinnerShprosWidth.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________________ДЛИНА ШПРОС_________________________________________

        spinnerShprosWidth.setAdapter(adapterShprosWidth);
        // заголовок
        spinnerShprosWidth.setPrompt("Шпросы");
        // выделяем элемент
        spinnerShprosWidth.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerShprosWidth.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionShprosWidth, long idShprosWidth) {

                positionShprosWidth1 = positionShprosWidth;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________________ТИП СТЕКЛА_________________________________________

        spinnerGlassDif.setAdapter(adapterGlassDif);
        // заголовок
        spinnerGlassDif.setPrompt("Шпросы");
        // выделяем элемент
        spinnerGlassDif.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerGlassDif.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionGlassDif, long idGlassDif) {

                positionGlassDif1 = positionGlassDif;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//____________________________ТИП РУЧКИ_________________________________________

        spinnerHandle.setAdapter(adapterHandle);
        // заголовок
        spinnerHandle.setPrompt("Ручки");
        // выделяем элемент
        spinnerHandle.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerHandle.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionHandle, long idHandle) {

                positionHandle1 = positionHandle;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//---------------------------------ЛИСТЫ------------------------
        builder = new AlertDialog.Builder(AddWindowActivity.this);

        listGlassDif.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {

                builder.setTitle("Внимание!");
                builder.setMessage("Заменить " + dataGlassList.get(position) + " на " + dataGlassDif.get(positionGlassDif1) +"?");

                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dataGlassList.set(position, dataGlassDif.get(positionGlassDif1));
                        adapterGlassDifLst.notifyDataSetInvalidated();
                        setGlassPriceItems(positionGlassDif1, position);
                    }
                });

                builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });

//---------------------------------КНОПКИ---------------------------------------------------
        setTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.startAnimation(animAlpha);

                getPriceFlag = true;
                setPrice(positionType1, positionTypeOfType1);
                setFurntitPrice();
                setLaminationCoefficient();
                setGlassPrice();
                setPriceFigure();
                setPriceHandle();
                setLam();
                setPriceShtulp();
                setPriceShpros();

                String itemName = dataType[positionType1] + dataTypeOfType.get(positionTypeOfType1) + "   " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + "\n" + dataProfile.get(positionProfile1) + "/" + dataTypeOfGlass.get(positionTypeOfGlass1) + (positionTypeOfType1 > 0 ? dataFurnit.get(positionFurnit1) + "   " : "   ") + dataRegion.get(positionRegion1).substring(0, 1);
                String itemInfo = "Фигура окна: " + (positionFigure1 == 0 ? "обычная\n\n" : dataFigure.get(positionFigure1) + "\n\n") +
                        "Профиль: " + dataProfile.get(positionProfile1) + "/" + dataTypeOfGlass.get(positionTypeOfGlass1) + (positionTypeOfType1 > 0 || balDorFlag ? " " + dataFurnit.get(positionFurnit1) + "\n" : "\n") +
                                  dataType[positionType1] + " " + (positionType1 != 4 ? dataTypeOfType.get(positionTypeOfType1) + "\n" : dataFilling.get(positionFilling1) + "\n") +
                                  "В " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + " Ш" + "\n" +
                        (positionLamination1 == 0 ? dataLamination.get(positionLamination1) : "Ламинация: " + dataLamination.get(positionLamination1) + " " + dataLaminationVar.get(positionLaminationVar1)) + "\n" +
                                  (dataGlassList.size() > 0 ? (dataGlassList.size() > 2 ?
                                          (dataGlassList.get(0).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(0) + ";") +
                                          (dataGlassList.get(1).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(1) + ";") +
                                          (dataGlassList.get(2).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(2) + ";") + "\n" :
                                                (dataGlassList.get(0).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(0) + ";") +
                                                (dataGlassList.get(1).equals("Обычное стекло") ? "Обычное стекло;" : dataGlassList.get(1) + ";") + "\n") : "\n") +
                                  (positionTypeOfType1 > 0 || balDorFlag ? (dataHandleList.size() > 2 ? dataHandleList.get(0) + "\n" + dataHandleList.get(1) + "\n" + dataHandleList.get(2) + "\n" :
                                          dataHandleList.get(0) + "\n" + dataHandleList.get(1) + "\n"): "") +
                                  (positionTypeOfType1 > 1 ? dataShtulp.get(positionShtulp1) + "\n" : "") +
                        (positionShpros1 > 0 ? dataShpros.get(positionShpros1) + " " + dataShprosWidth.get(positionShprosWidth1) : dataShpros.get(positionShpros1));


                //Пришлось разделить просто добавление и добавление если это со спецификацией
                //Для того что бы была возможность дождаться ввода точных размеров
                //По другому не ждет ввода, а сразу вписывает что есть
                if(MainActivity.hashMap.get(MainActivity.nameMeasure).getIsDoSpecification()) {
                    //Добавляем высоту и ширину для коммерческого предложения
                    LayoutInflater layoutInflater = LayoutInflater.from(context);
                    View view = layoutInflater.inflate(R.layout.prompt5_height_width_specification, null);
                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setView(view);
                    EditText realHeight = view.findViewById(R.id.input_text_height);
                    EditText realWidth = view.findViewById(R.id.input_text_width);
                    realHeight.setText(dataHight.get(positionHight1));
                    realWidth.setText(dataWidth.get(positionWidth1));
                    alert.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            int height = Integer.parseInt(realHeight.getText().toString());
                            int width = Integer.parseInt(realWidth.getText().toString());
                            ExcelCreator.setTmpHeight(height);
                            ExcelCreator.setTmpWidth(width);

                            startAdd(itemName,itemInfo);
                        }
                    });
                    AlertDialog alertDialogcb = alert.create();
                    alertDialogcb.show();
                }
                else {
                    startAdd(itemName, itemInfo);
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
//__________________________________________________________________________________-
        addHandleBut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            v.startAnimation(animAlpha);
            setHandlePriceItems(positionHandle1);

            //Если на ручку обязательно ставится рото, то меняем фурнитуру на рото
            if(dataHandleList.get(0).getROTO()) {
                positionFurnit1 = 1;
                spinnerFurnit.setSelection(1);
            }
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);

            adapterHandle.notifyDataSetChanged();
        }
    });
    }
//-------------------------------------------------------------------------------------

    //Метод для добавление, вынесен из кнопки что бы при создании спецификации можно было дождаться ввода точных размеров
    public void startAdd(String itemName, String itemInfo) {
        //Если добавление не в блок
        if(!addFromList) {

            //Добавление в пакет, только если активный замер сам не является пакетом
            if(!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                //Если не выбрали добавление произвольного окна
                if (addToPocketFlag.isChecked()) {
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.PROPLEX7032W, getPocketNameItem(MainActivity.prices.PROPLEX7032W), getPocketInfoItem(MainActivity.prices.PROPLEX7032W), setPriceToPockets(MainActivity.prices.PROPLEX7032W), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.BB7040W, getPocketNameItem(MainActivity.prices.BB7040W), getPocketInfoItem(MainActivity.prices.BB7040W), setPriceToPockets(MainActivity.prices.BB7040W), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAU7040W, getPocketNameItem(MainActivity.prices.REHAU7040W), getPocketInfoItem(MainActivity.prices.REHAU7040W), setPriceToPockets(MainActivity.prices.REHAU7040W), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAUINTELIO, getPocketNameItem(MainActivity.prices.REHAUINTELIO), getPocketInfoItem(MainActivity.prices.REHAUINTELIO), setPriceToPockets(MainActivity.prices.REHAUINTELIO), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                } else {
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.PROPLEX7032W, itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.BB7040W, itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAU7040W, itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAUINTELIO, itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));

                }
            }

            if (positionRegion1 == 0) {
                ProductList.addProdLst(itemName, setRegionPrice(), itemInterest, 0, 0);
                MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
            }
            else {
                ProductList.addProdLst(itemName, setMinskPrice(), itemInterest, 0, 0);
                MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, setMinskPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
            }

            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);
            try {
                writeHash(MainActivity.hashMap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Если добавление в блок из списка
        else {

            //Добавление в пакет, только если активный замер сам не является пакетом
            if(!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                //Если не выбрали добавление произвольного окна
                if (addToPocketFlag.isChecked()) {
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.PROPLEX7032W, getPocketNameItem(MainActivity.prices.PROPLEX7032W), getPocketInfoItem(MainActivity.prices.PROPLEX7032W), setPriceToPockets(MainActivity.prices.PROPLEX7032W), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.BB7040W, getPocketNameItem(MainActivity.prices.BB7040W), getPocketInfoItem(MainActivity.prices.BB7040W), setPriceToPockets(MainActivity.prices.BB7040W), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAU7040W, getPocketNameItem(MainActivity.prices.REHAU7040W), getPocketInfoItem(MainActivity.prices.REHAU7040W), setPriceToPockets(MainActivity.prices.REHAU7040W), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAUINTELIO, getPocketNameItem(MainActivity.prices.REHAUINTELIO), getPocketInfoItem(MainActivity.prices.REHAUINTELIO), setPriceToPockets(MainActivity.prices.REHAUINTELIO), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                } else {
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.PROPLEX7032W, itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.BB7040W, itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAU7040W, itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAUINTELIO, itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                }
            }

            if (positionRegion1 == 0) {
                ProductList.addProdLst(itemName, setRegionPrice(), itemInterest, 0, 0);
                MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
            } else {
                ProductList.addProdLst(itemName, setMinskPrice(), itemInterest, 0, 0);
                MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, setMinskPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
            }

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

    public void setPrice(int p1, int p2) {

        //Глухая
        if(p2 == 0 && flag == true) {
            gluhFlag = true;
            adapterFigure.clear();
            adapterFigure.addAll(addList(R.array.dtaFigure));

            handlePriceItems[0] = 0;
            handlePriceItems[1] = 0;
            handlePriceItems[2] = 0;
            adapterHandleLst.clear();
        }
        //Открываются
        if( (p2 == 1 || p2 == 2 || p2 == 3 || p2 == 4) && flag == true) {
            gluhFlag = false;
            adapterFigure.clear();
            adapterFigure.addAll(addList(R.array.dtaFigure2));

            //Устанавливаем видимые и невидимые элементы(В случае с балконной дверью показываем\скрываем хваталки)
            setHandleVisibility(balDorFlag);
            handlePriceItems[0] = 0;
            handlePriceItems[1] = 0;
            handlePriceItems[2] = 0;
            adapterHandleLst.clear();
            adapterHandleLst.add(dataHandle.get(0));//Ручка стандарт
            adapterHandleLst.add(dataHandle.get(1));//Накладка стандарт
        }

        // 1 створка глухая
        if(p1 == 0 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta1));
                adapterHight.addAll(addList(R.array.Hight_1stNo));
                adapterWidth.addAll(addList(R.array.Width_1stNo));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) <= 800 && Integer.parseInt(dataWidth.get(positionWidth1)) <= 600 ) {
                    itemInterest = MainActivity.prices.INTW1STV2;
                }

                else if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1000 ) {
                    itemInterest = MainActivity.prices.INTW2ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW1ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind1stNo[positionHight1][positionWidth1];
                }
                else if (BB6032 == true){
                    price = MainActivity.prices.BB6032wind1stNo[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind1stNo[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND1STNO_PICTURE);
            }
            return;
        }

        // 2 стоврки 2 глухие
        if(p1 == 1 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta2));
                adapterHight.addAll(addList(R.array.Hight_2stNo));
                adapterWidth.addAll(addList(R.array.Width_2stNo));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1700 ) {
                    itemInterest = MainActivity.prices.INTW3ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW2ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind2stNo[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032wind2stNo[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind2stNo[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND2STNO_PICTURE);
            }
            return;
        }

        // 3 створки 3 глухие
        if(p1 == 2 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterHight.addAll(addList(R.array.Hight_3stNo));
                adapterWidth.addAll(addList(R.array.Width_3stNo));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = MainActivity.prices.INTW4ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW3ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind3stNo[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032wind3stNo[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind3stNo[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND3STNO_PICTURE);
            }
            return;
        }
        // 1 створка 1 открывается
        if(p1 == 0 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta1));
                adapterHight.addAll(addList(R.array.Hight_1stOp));
                adapterWidth.addAll(addList(R.array.Width_1stOp));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) <= 800 && Integer.parseInt(dataWidth.get(positionWidth1)) <= 600 ) {
                    itemInterest = MainActivity.prices.INTW1STV2;
                }

                else if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1000 ) {
                    itemInterest = MainActivity.prices.INTW2ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW1ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind1stOp[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032wind1stOp[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind1stOp[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND1STOP_PICTURE);
            }
            return;
        }
        // 2 створки 1 открывается
        if(p1 == 1 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta2));
                adapterHight.addAll(addList(R.array.Hight_2st1Op));
                adapterWidth.addAll(addList(R.array.Width_2st1Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1700 ) {
                    itemInterest = MainActivity.prices.INTW3ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW2ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind2st1Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032wind2st1Op[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind2st1Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND2ST1OP_PICTURE);
            }
            return;
        }

        // 2 створки 2 открывается
        if(p1 == 1 && p2 == 2) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta2));
                adapterHight.addAll(addList(R.array.Hight_2st2Op));
                adapterWidth.addAll(addList(R.array.Width_2st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 1700 ) {
                    itemInterest = MainActivity.prices.INTW3ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW2ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind2st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032wind2st2Op[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind2st2Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND2ST2OP_PICTURE);
            }
            return;
        }

        // 3 створки 1 открывается
        if(p1 == 2 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterHight.addAll(addList(R.array.Hight_3st1Op));
                adapterWidth.addAll(addList(R.array.Width_3st1Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = MainActivity.prices.INTW4ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW3ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind3st1Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032wind3st1Op[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind3st1Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND3ST1OP_PICTURE);
            }
            return;
        }

        // 3 створки 2 открывается
        if(p1 == 2 && p2 == 2) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterHight.addAll(addList(R.array.Hight_3st2Op));
                adapterWidth.addAll(addList(R.array.Width_3st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = MainActivity.prices.INTW4ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW3ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind3st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032wind3st2Op[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind3st2Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND3ST2OP_PICTURE);
            }
            return;
        }

        // 3 створки 3 открывается
        if(p1 == 2 && p2 == 3) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta3));
                adapterHight.addAll(addList(R.array.Hight_3st2Op));
                adapterWidth.addAll(addList(R.array.Width_3st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600 || Integer.parseInt(dataWidth.get(positionWidth1)) > 2500 ) {
                    itemInterest = MainActivity.prices.INTW4ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW3ST;
                }

                if (BB6024 == true) {
                    price = 25 + MainActivity.prices.BB6024wind3st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = 25 + MainActivity.prices.BB6032wind3st2Op[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = 25 + MainActivity.prices.BB6032wind3st2Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND3ST3OP_PICTURE);
            }
            return;
        }

        // 4 створки глухая
        if(p1 == 3 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterHight.addAll(addList(R.array.Hight_4st2Op));
                adapterWidth.addAll(addList(R.array.Width_4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = MainActivity.prices.INTW4STV2;
                }
                else {
                    itemInterest = MainActivity.prices.INTW4ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind4st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032wind4st2Op[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind4st2Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND4STNO_PICTURE);
            }
            return;
        }

        // 4 створки 1 открывается
        if(p1 == 3 && p2 == 1) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterHight.addAll(addList(R.array.Hight_4st2Op));
                adapterWidth.addAll(addList(R.array.Width_4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = MainActivity.prices.INTW4STV2;
                }
                else {
                    itemInterest = MainActivity.prices.INTW4ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind4st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032wind4st2Op[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind4st2Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND4ST1OP_PICTURE);
            }
            return;
        }

        // 4 створки 2 открывается
        if(p1 == 3 && p2 == 2) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterHight.addAll(addList(R.array.Hight_4st2Op));
                adapterWidth.addAll(addList(R.array.Width_4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = MainActivity.prices.INTW4STV2;
                }
                else {
                    itemInterest = MainActivity.prices.INTW4ST;
                }

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024wind4st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032wind4st2Op[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032wind4st2Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND4ST2OP_PICTURE);
            }
            return;
        }

        // 4 створки 3 открывается
        if(p1 == 3 && p2 == 3) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterHight.addAll(addList(R.array.Hight_4st2Op));
                adapterWidth.addAll(addList(R.array.Width_4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = MainActivity.prices.INTW4STV2;
                }
                else {
                    itemInterest = MainActivity.prices.INTW4ST;
                }

                if (BB6024 == true) {
                    price = 25 + MainActivity.prices.BB6024wind4st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = 25 + MainActivity.prices.BB6032wind4st2Op[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = 25 + MainActivity.prices.BB6032wind4st2Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND4ST3OP_PICTURE);
            }
            return;
        }

        // 4 створки 4 открывается
        if(p1 == 3 && p2 == 4) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta4));
                adapterHight.addAll(addList(R.array.Hight_4st2Op));
                adapterWidth.addAll(addList(R.array.Width_4st2Op));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                if (Integer.parseInt(dataHight.get(positionHight1)) > 1600) {
                    itemInterest = MainActivity.prices.INTW4STV2;
                }
                else {
                    itemInterest = MainActivity.prices.INTW4ST;
                }

                if (BB6024 == true) {
                    price = 50 + MainActivity.prices.BB6024wind4st2Op[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = 50 + MainActivity.prices.BB6032wind4st2Op[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = 50 + MainActivity.prices.BB6032wind4st2Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.WIND4ST4OP_PICTURE);
            }
            return;
        }

        //Балконная дверь
        if(p1 == 4 && p2 == 0) {

            if (flag == true) {
                adapterTypeOfType.clear();
                adapterHight.clear();
                adapterWidth.clear();
                adapterTypeOfType.addAll(addList(R.array.dta5));
                adapterHight.addAll(addList(R.array.Hight_balDor));
                adapterWidth.addAll(addList(R.array.Width_balDor));
                flag = false;
                balDorFlag = true;

                //Устанавливаем видимые и невидимые элементы(В случае с балконной дверью показываем\скрываем хваталки)
                setHandleVisibility(balDorFlag);
                handlePriceItems[0] = 0;
                handlePriceItems[1] = 0;
                handlePriceItems[2] = 0;
                adapterHandleLst.clear();
                adapterHandleLst.add(dataHandle.get(0));//Ручка стандарт
                adapterHandleLst.add(dataHandle.get(1));//накладка стандарт
                adapterHandleLst.add(dataHandle.get(2));//хвталака стандарт
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTBALDOR;

                if (BB6024 == true) {
                    price = MainActivity.prices.BB6024balDor[positionHight1][positionWidth1];
                }
                else if (BB6032 == true) {
                    price = MainActivity.prices.BB6032balDor[positionHight1][positionWidth1];
                }

                //Добавляем цену для просчета пакетов(Считается все от ББ60\32)
                pocketPrice = MainActivity.prices.BB6032balDor[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.BALDOR_PICTURE);
            }
            return;
        }

    }

    //_____________________________________________________________________________________
    public void setProfile(int p1, int p2) {

        rehauIntelio = false;

        //Если 24мм стекло
        if (p2 == 0) {
            glassPriceItems[0] = 0.0;
            glassPriceItems[1] = 0.0;
            glassPriceItems[2] = 0.0;
            glassPriceItems[3] = 0.0;
            adapterGlassDifLst.clear();
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            //adapterGlassDifLst.add("Кислород");
        }
        //Если 32мм или 40мм стекло
        if (p2 == 1 || p2 == 2) {
            glassPriceItems[0] = 0.0;
            glassPriceItems[1] = 0.0;
            glassPriceItems[2] = 0.0;
            glassPriceItems[3] = 0.0;
            adapterGlassDifLst.clear();
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            //adapterGlassDifLst.add("Кислород");
        }
        // BB 60/24
        if(p1 == 0 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = MainActivity.prices.BB6024W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass60));
            return;
        }

        // BB 60/32
        if(p1 == 0 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.BB6032W;
            return;
        }

        // BB 70/24
        if(p1 == 1 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = MainActivity.prices.BB7024W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass70));
            return;
        }

        // BB 70/32
        if(p1 == 1 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.BB7032W;
            return;
        }


        // BB 70/40
        if(p1 == 1 && p2 == 2) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.BB7040W;
            return;
        }

        // BB 70/24 (A-Класс)
        if(p1 == 2 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = MainActivity.prices.BBA7024W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass70));
            return;
        }

        // BB 70/32 (A-Класс)
        if(p1 == 2 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.BBA7032W;
            return;
        }

        // BB 70/40 (A-Класс)
        if(p1 == 2 && p2 == 2) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.BBA7040W;
            return;
        }

        // Rehau 60/24
        if(p1 == 3 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = MainActivity.prices.REHAU6024W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass60));
            return;
        }


        // Rehau 60/32
        if(p1 == 3 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.REHAU6032W;
            return;
        }


        // Rehau 70/24
        if(p1 == 4 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = MainActivity.prices.REHAU7024W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass70));
            return;
        }


        // Rehau 70/32
        if(p1 == 4 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.REHAU7032W;
            return;
        }


        // Rehau 70/40
        if(p1 == 4 && p2 == 2) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.REHAU7040W;
            return;
        }

        // rehauIntelio 80/50
        if(p1 == 5 && p2 == 0) {
            profileCoefficient = MainActivity.prices.REHAUINTELIO;
            BB6024 = false;
            BB6032 = true;
            rehauIntelio = true;
            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass80));

            glassPriceItems[0] = 0.0;
            glassPriceItems[1] = 0.0;
            glassPriceItems[2] = 0.0;
            glassPriceItems[3] = 0.0;
            adapterGlassDifLst.clear();
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            return;
        }

        // PROPLEX 58/24
        if(p1 == 6 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = MainActivity.prices.PROPLEX5824W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass60));
            return;
        }

        // PROPLEX 58/32
        if(p1 == 6 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.PROPLEX5832W;
            return;
        }

        // PROPLEX 70/24
        if(p1 == 7 && p2 == 0) {
            BB6024 = true;
            BB6032 = false;
            profileCoefficient = MainActivity.prices.PROPLEX7024W;

            adapterTypeOfGlass.clear();
            adapterTypeOfGlass.addAll(addList(R.array.TypeOfGlass70));
            return;
        }

        // PROPLEX 70/32
        if(p1 == 7 && p2 == 1) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.PROPLEX7032W;
            return;
        }

        // PROPLEX 70/40
        if(p1 == 7 && p2 == 2) {
            BB6024 = false;
            BB6032 = true;
            profileCoefficient = MainActivity.prices.PROPLEX7040W;
            return;
        }

    }
    //----------------------------------------------------------------------------
    public void setFurntitPrice() {

        furnitPrice = 0;

        if (positionFurnit1 == 1 && balDorFlag != true) {
            furnitPrice = MainActivity.prices.rotoW * positionTypeOfType1;
        }
        if (positionFurnit1 == 1 && balDorFlag == true) {
            furnitPrice = MainActivity.prices.rotoBD;
        }
    }
//==================================================================================================
    //Устанавливает стоимость фурнитуры для Пакета
    public double setPocketFurnitPrice(double pocketCoff){

        //Если балконная дверь
        if(balDorFlag){

            //ПОКЕТ LITE PROPLEX7032
            if (pocketCoff == MainActivity.prices.PROPLEX7032W) {
                return 0;
            }
            //ПОКЕТ STANDARD BB7040
            else if (pocketCoff == MainActivity.prices.BB7040W) {
                return 0;
            }
            //ПОКЕТ KOMFORT REHAU7040
            else if (pocketCoff == MainActivity.prices.REHAU7040W) {
                return MainActivity.prices.rotoBD;
            }
            //ПОКЕТ PREMIUM INTELIO
            else {
                return MainActivity.prices.rotoBD;
            }
        }
        //Если окно
        else if (positionTypeOfType1 > 0) {
            //ПОКЕТ LITE PROPLEX7032
            if (pocketCoff == MainActivity.prices.PROPLEX7032W) {
                return 0;
            }
            //ПОКЕТ STANDARD BB7040
            else if (pocketCoff == MainActivity.prices.BB7040W) {
                return 0;
            }
            //ПОКЕТ KOMFORT REHAU7040
            else if (pocketCoff == MainActivity.prices.REHAU7040W) {
                return MainActivity.prices.rotoW * positionTypeOfType1;
            }
            //ПОКЕТ PREMIUM INTELIO
            else {
                return MainActivity.prices.rotoW * positionTypeOfType1;
            }
        }
        return 0;
    }

    //Устанавливает стоимость ручек для Пакета
    public double setPocketHandlePrice(double pocketCoff){

        double handleKomfort = 0;
        double handlePremium = 0;

        for (HandleFurnit s : dataHandle) {
            if(s.getName().contains("KOMFORTPOCKET")) {
                handleKomfort = s.getPrice() - dataHandle.get(0).getPrice();
            }
            else if (s.getName().contains("PREMIUMPOCKET")) {
                handlePremium = s.getPrice() - dataHandle.get(0).getPrice();
            }

        }

        //Если балконная дверь
        if(balDorFlag){

            //ПОКЕТ LITE PROPLEX7032
            if (pocketCoff == MainActivity.prices.PROPLEX7032W) {
                return 0;
            }
            //ПОКЕТ STANDARD BB7040
            else if (pocketCoff == MainActivity.prices.BB7040W) {
                return 0;
            }
            //ПОКЕТ KOMFORT REHAU7040
            else if (pocketCoff == MainActivity.prices.REHAU7040W) {
                return handleKomfort;
            }
            //ПОКЕТ PREMIUM INTELIO
            else {
                return handlePremium;
            }
        }
        //Если окно
        else if (positionTypeOfType1 > 0) {
            //ПОКЕТ LITE PROPLEX7032
            if (pocketCoff == MainActivity.prices.PROPLEX7032W) {
                return 0;
            }
            //ПОКЕТ STANDARD BB7040
            else if (pocketCoff == MainActivity.prices.BB7040W) {
                return 0;
            }
            //ПОКЕТ KOMFORT REHAU7040
            else if (pocketCoff == MainActivity.prices.REHAU7040W) {
                return handleKomfort * positionTypeOfType1;
            }
            //ПОКЕТ PREMIUM INTELIO
            else {
                return handlePremium* positionTypeOfType1;

            }
        }
        return 0;
    }

    //Устанавливает стоимость стеклопакета для Пакета
    public double setPocketGlassPrice(double pocketCoff){

        //Если балконная дверь
        if (balDorFlag) {

            //Если пакет лайт или стандарт, там без мультика так что 0
            if (pocketCoff == MainActivity.prices.PROPLEX7032W || pocketCoff == MainActivity.prices.BB7040W) {
                return 0;
            }
            //Если другой пакет, то считаем стоимость СП
            else {
                //Если заполнение стеклом
                if (positionFilling1 == 0) {
                    return ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * MainActivity.prices.multik;
                }
                //Если заполнение 50\50 - делим на 2
                else if (positionFilling1 == 1) {
                    return ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * MainActivity.prices.multik/2;

                }
                //Если заполнение сендвичем, то 0
                else {
                    return 0;
                }
            }
        }
        //Если окна
        else {
            //Если пакет лайт или стандарт, там без мультика так что 0
            if (pocketCoff == MainActivity.prices.PROPLEX7032W || pocketCoff == MainActivity.prices.BB7040W) {
                return 0;
            }
            //Если пакет комфорт и премиум, то считаем мультик
            else {
                return ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * MainActivity.prices.multik;
            }
        }

    }

    public String getPocketNameItem(double pocketCoff) {
        //ПОКЕТ LITE PROPLEX7032
        if (pocketCoff == MainActivity.prices.PROPLEX7032W) {
            return dataType[positionType1] + dataTypeOfType.get(positionTypeOfType1) + "   " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + "\n" +
                    dataProfile.get(7) + "/32" + (positionTypeOfType1 > 0 ? "Kale   " : "   ") + dataRegion.get(positionRegion1).substring(0, 1);
        }
        //ПОКЕТ STANDARD BB7040
        else if (pocketCoff == MainActivity.prices.BB7040W) {
            return dataType[positionType1] + dataTypeOfType.get(positionTypeOfType1) + "   " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + "\n" +
                    dataProfile.get(1) + "/40" + (positionTypeOfType1 > 0 ? "Kale   " : "   ") + dataRegion.get(positionRegion1).substring(0, 1);
        }
        //ПОКЕТ KOMFORT REHAU7040
        else if (pocketCoff == MainActivity.prices.REHAU7040W) {
            return dataType[positionType1] + dataTypeOfType.get(positionTypeOfType1) + "   " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + "\n" +
                    dataProfile.get(4) + "/40" + (positionTypeOfType1 > 0 ? "Roto   " : "   ") + dataRegion.get(positionRegion1).substring(0, 1);
        }
        //ПОКЕТ PREMIUM INTELIO
        else {
            return dataType[positionType1] + dataTypeOfType.get(positionTypeOfType1) + "   " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + "\n" +
                    dataProfile.get(5) + "/50" + (positionTypeOfType1 > 0 ? "Roto   " : "   ") + dataRegion.get(positionRegion1).substring(0, 1);
        }
    }

    public String getPocketInfoItem(double pocketCoff) {

        String rotoLine = "";
        String rotoSwing = "";

        for (HandleFurnit s : dataHandle) {
            if(s.getName().contains("KOMFORTPOCKET")) {
                rotoLine = s.getName();
            }
            else if (s.getName().contains("PREMIUMPOCKET")) {
                rotoSwing = s.getName();
            }
        }

        String profile = pocketCoff == MainActivity.prices.PROPLEX7032W ? dataProfile.get(7) + "/32" :
                         pocketCoff == MainActivity.prices.BB7040W ? dataProfile.get(1) + "/40" :
                         pocketCoff == MainActivity.prices.REHAU7040W ? dataProfile.get(4) + "/40" :
                                 dataProfile.get(5) + "/50";

        String furnit = pocketCoff == MainActivity.prices.PROPLEX7032W || pocketCoff == MainActivity.prices.BB7040W  ? "Kale" : "Roto";

        String glass = pocketCoff == MainActivity.prices.PROPLEX7032W || pocketCoff == MainActivity.prices.BB7040W  ? "Обычное стекло;Обычное стекло;Обычное стекло" : "Мультик;Обычное стекло;Обычное стекло";

        String handleBD = pocketCoff == MainActivity.prices.PROPLEX7032W || pocketCoff == MainActivity.prices.BB7040W ?
                dataHandle.get(0) + "\n" + dataHandle.get(1) + "\n" + dataHandle.get(2) + "\n" :
                pocketCoff == MainActivity.prices.REHAU7040W ?
                rotoLine + "\n" + dataHandle.get(1) + "\n" + dataHandle.get(2) + "\n" :
                rotoSwing + "\n" + dataHandle.get(1) + "\n" + dataHandle.get(2) + "\n";

        String handleW = pocketCoff == MainActivity.prices.PROPLEX7032W || pocketCoff == MainActivity.prices.BB7040W ?
                dataHandle.get(0) + "\n" + dataHandle.get(1) + "\n" :
                pocketCoff == MainActivity.prices.REHAU7040W ?
                rotoLine + "\n" + dataHandle.get(1) + "\n" :
                rotoSwing + "\n" + dataHandle.get(1) + "\n";


        String itemInfo = "Фигура окна: " + (positionFigure1 == 0 ? "обычная\n\n" : dataFigure.get(positionFigure1) + "\n\n") +
                "Профиль: " + profile + (positionTypeOfType1 > 0 || balDorFlag ? " " + furnit + "\n" : "\n") +
                dataType[positionType1] + " " + (positionType1 != 4 ? dataTypeOfType.get(positionTypeOfType1) + "\n" : dataFilling.get(positionFilling1) + "\n") +
                "В " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + " Ш" + "\n" +
                (positionLamination1 == 0 ? dataLamination.get(positionLamination1) : "Ламинация: " + dataLamination.get(positionLamination1) + " " + dataLaminationVar.get(positionLaminationVar1)) + "\n" +
                (glass + "\n") +
                (positionTypeOfType1 > 0 || balDorFlag ? (dataHandleList.size() > 2 ? handleBD :
                        handleW): "") +
                (positionTypeOfType1 > 1 ? dataShtulp.get(positionShtulp1) + "\n" : "") +
                (positionShpros1 > 0 ? dataShpros.get(positionShpros1) + " " + dataShprosWidth.get(positionShprosWidth1) : dataShpros.get(positionShpros1));

        return itemInfo;
    }
//==================================================================================================


    //______________________________________________________
    public void setLaminationCoefficient(){

            //Если без ламинации
            if (positionLamination1 == 0) {
                laminationCoefficient = 1;
            }

            //Если ламинация с одной стороны
            else if (positionLamination1 == 1) {

                //Если цвет из группы 1
                if (GROUP == 1) {
                    laminationCoefficient = MainActivity.prices.lamG1St1;
                }
                //Если цвет из группы 2
                else if (GROUP == 2) {
                    laminationCoefficient = MainActivity.prices.lamG2St1;
                }
                //Если цвет из группы 3
                else {
                    laminationCoefficient = MainActivity.prices.lamG3St1;
                }
            }

            //Если ламинация с 2 сторон
            else {
                //Если цвет из группы 1
                if (GROUP == 1) {
                    laminationCoefficient = MainActivity.prices.lamG1St2;
                }
                //Если цвет из группы 2
                else if (GROUP == 2) {
                    laminationCoefficient = MainActivity.prices.lamG2St2;
                }
                //Если цвет из группы 3
                else {
                    laminationCoefficient = MainActivity.prices.lamG3St2;
                }
            }

    }
    //____________________________________________________________
    public double setRegionPrice() {
        return Math.ceil(((((price + furnitPrice + priceFigure + priceShtulp) * profileCoefficient) * laminationCoefficient) + lam + shpros + priceHandle + priceGlass));
    }

    public double setMinskPrice() {
        return Math.ceil(((((price + furnitPrice + priceFigure + priceShtulp) * profileCoefficient) * laminationCoefficient) + lam + shpros + priceHandle + priceGlass));
    }

    public double setPriceToPockets(double pocketCoff) {
        return Math.ceil(((((pocketPrice + setPocketFurnitPrice(pocketCoff) + priceFigure + priceShtulp) * pocketCoff) * laminationCoefficient) + lam + shpros + setPocketHandlePrice(pocketCoff) + setPocketGlassPrice(pocketCoff)));
    }


    public List<String> addList(@ArrayRes int id) {
        return Arrays.asList(getResources().getStringArray(id));
    }

    public void setGlassPriceItems(int p1, int p2) {
        //Вызывается при нажатии на эелемент листа
        //p1 - тип стекла
        //p2 - Позиция стекла в лиcте

        //Обычное стекло
        if (p1 == 0) {
            glassPriceItems[p2] = 0.0;
            return;
        }
        //Мультик простой
        if (p1 == 1) {
            glassPriceItems[p2] = MainActivity.prices.multik;
            return;
        }
        //Бронза в массе
        if (p1 == 2) {
            glassPriceItems[p2] = MainActivity.prices.bronza;
            return;
        }
        //Матовое заводское
        if (p1 == 3) {
            glassPriceItems[p2] = MainActivity.prices.mat;
            return;
        }
        //Тонировка пленка
        if (p1 == 4) {
            glassPriceItems[p2] = MainActivity.prices.tonirovka;
            return;
        }
    }

    public void setGlassPrice() {
        //Вызывается после нажатия на кнопку добавить изделие
        double glass1;
        double glass2;
        double glass3;
        glass1 = ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * glassPriceItems[0];
        glass2 = ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * glassPriceItems[1];
        glass3 = ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * glassPriceItems[2];

        //Если 100% стекло
        if (positionFilling1 == 0) {
            priceGlass = glass1 + glass2 + glass3;
        }
        //Если 50\50, есть еще вариант сендвич 100%, но там цена СП автоматом 0
        else {
            priceGlass = glass1 + glass2 + glass3;
            priceGlass /= 2;
        }
    }

    public void setPriceFigure() {
        //Вызывается после нажатия на кнопку добавить изделие

        //Если окно глухое
        if (gluhFlag) {
            //Обычное окно
            if (positionFigure1 == 0) {
                priceFigure = 0;
            }
            //Арка
            else if (positionFigure1 == 1) {
                priceFigure = MainActivity.prices.arka;
            }
            //Трапеция 2 угла
            else if (positionFigure1 == 2) {
                priceFigure = MainActivity.prices.trapecija * 2;
            }
            //Трапеция 3 угла
            else if (positionFigure1 == 3) {
                priceFigure = MainActivity.prices.trapecija * 3;
            }
            //Трапеция 4 угла
            else {
                priceFigure = MainActivity.prices.trapecija * 4;
            }
        }
        else {
            //Обычное окно
            if (positionFigure1 == 0) {
                priceFigure = 0;
            }
            //Арка ----- Тут не добавлен ИМПОСТ из класса c ценами, цена стоит 10$
            else{
                priceFigure = MainActivity.prices.arka + (Integer.parseInt(dataWidth.get(positionWidth1))/1000.0 * 10);
            }
        }
    }

    public void setHandlePriceItems(int p1) {
        //Вызывется после нажатия на кнопку +
        //p1 - Тип ручки

        //Ручка [0]
        //Комплект накладок [1]
        //Хваталка балконная [2]


        //Если открываются окна
        if(!gluhFlag) {

            //Если выбраны ручки
            if(dataHandle.get(p1).getHANDLE()) {
                dataHandleList.set(0, dataHandle.get(positionHandle1));
                handlePriceItems[0] = dataHandle.get(p1).getPrice() - dataHandle.get(0).getPrice();
            }
            //Если выбраны накладки
            else if(dataHandle.get(p1).getNAKLADKA()){
                dataHandleList.set(1, dataHandle.get(positionHandle1));
                handlePriceItems[1] = dataHandle.get(p1).getPrice() - dataHandle.get(1).getPrice();
            }

            adapterHandleLst.notifyDataSetInvalidated();

        }

        //Если балконная дверь
        else if(balDorFlag) {
            //Если выбраны ручки
            if(dataHandle.get(p1).getHANDLE()) {
                dataHandleList.set(0, dataHandle.get(positionHandle1));
                handlePriceItems[0] = dataHandle.get(p1).getPrice() - dataHandle.get(0).getPrice();
            }
            //Если выбраны накладки
            else if (dataHandle.get(p1).getNAKLADKA()){
                dataHandleList.set(1, dataHandle.get(positionHandle1));
                handlePriceItems[1] = dataHandle.get(p1).getPrice() - dataHandle.get(1).getPrice();
            }
            //Если выбраны хваталки
            else {
                dataHandleList.set(2, dataHandle.get(positionHandle1));
                handlePriceItems[2] = dataHandle.get(p1).getPrice() - dataHandle.get(2).getPrice();
            }
            adapterHandleLst.notifyDataSetInvalidated();
        }
    }

    public void setPriceHandle() {
        //Вызывается после нажатия на кнопку добавить изделие

        //Окна
        if (!balDorFlag) {
            priceHandle = (handlePriceItems[0] * positionTypeOfType1) + handlePriceItems[1];
        }
        //Балконная дверь
        else {
            priceHandle = handlePriceItems[0] + handlePriceItems[1] + handlePriceItems[2];
        }

    }

    public void setLam() {
        //Вызывается после нажатия на кнопку добавить изделие
        lam = 0;

        //Только если выбрана балконная дверь
        if (balDorFlag) {
            //Только если выбрана ламинация
            if (positionLamination1 == 1 || positionLamination1 == 2) {
                //Если заполнение стеклом 100%
                if (positionFilling1 == 0) {
                    lam = 0;
                    return;
                }
                //Если заполнение сендвичем 100% или 50/50
                if (positionFilling1 != 0) {
                    //Если ламинация с одной стороны и заполнение сендвичем 100% или ламинация с двух сторон и заполнение 50/50
                    if( (positionLamination1 == 1 && positionFilling1 == 1) || (positionLamination1 == 2 && positionFilling1 == 2) ) {
                        lam = ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * MainActivity.prices.lamSend;
                        return;
                    }
                    //Если ламинация с 2 сторон и заполнение сендвичем 100%
                    if (positionLamination1 == 2 && positionFilling1 == 1) {
                        lam = ( ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * MainActivity.prices.lamSend ) * 2;
                        return;
                    }
                    //Если ламинация с 1 тороны и заполнение сендвичем 50/50
                    if (positionLamination1 == 1 && positionFilling1 == 2) {
                        lam = ( ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * MainActivity.prices.lamSend ) / 2;
                        return;
                    }
                }


            }
        }
    }

    public void setPriceShtulp() {
        //Вызывается после нажатия на кнопку добавить изделие

        if (positionShtulp1 == 0) {
            priceShtulp = 0;
        } else {
            priceShtulp = MainActivity.prices.shtulp;
        }

    }
    public void setPriceShpros() {
        //Вызывается после нажатия на кнопку добавить изделие

        //Без шпрос
        if (positionShpros1 == 0) {
            shpros = 0;
        }
        //Шпросы белые/коричневые 26мм
        else if (positionShpros1 == 1) {
            shpros = (Double.parseDouble(dataShprosWidth.get(positionShprosWidth1)) / 1000) * MainActivity.prices.shprosBelKor26mm;
        }
        //Шпросы белые/коричневые 18мм
        else if (positionShpros1 == 2) {
            shpros = (Double.parseDouble(dataShprosWidth.get(positionShprosWidth1)) / 1000) * MainActivity.prices.shprosBelKor18mm;
        }
        //Шпросы белые/золотые 8мм
        else {
            shpros = (Double.parseDouble(dataShprosWidth.get(positionShprosWidth1)) / 1000) * MainActivity.prices.shprosBelZol8mm;
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
//__________________________________________________________________________________________________

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

    public void setHandleVisibility(boolean b) {
        //Если не балконная дверь
        if(!b) {
            for(HandleFurnit handleFurnit : dataHandle) {
                if(handleFurnit.getHVATALKA()) {
                    handleFurnit.setVisible(false);
                }
            }
        }
        //Если балконная дверь
        else {
            for(HandleFurnit handleFurnit : dataHandle) {
                if(handleFurnit.getHVATALKA()) {
                    handleFurnit.setVisible(true);
                }
            }
        }
    }
}
