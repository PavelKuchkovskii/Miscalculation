package com.example.miscalculation;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

public class AddDoorActivity extends AppCompatActivity {

    static boolean flag = false;
    static boolean getPriceFlag = false;

    static boolean dDoor = false;
    static boolean wDoor = false;

    static boolean bb70 = false;

    static int positionType1;
    static int positionTypeOfType1;
    static int positionTypeOfLoop1;
    static int positionColorLoop1;
    static int positionHight1;
    static int positionWidth1;
    static int positionFurnit1;
    static int positionProfile1;
    static int positionTypeOfGlass1;
    static int positionLamination1;
    static int positionRegion1;
    static int positionTypeOfGarnit1;
    static int positionColorGarnit1;
    static int positionPorog1;
    static int positionKey1;
    static int positionGlassDif1;

    static int price;
    static int itemInterest;
    static double loopPrice = 0;
    static int loopValue = 0;
    static int loopValueStnd = 0;
    static double garnitPrice = 0;
    static double lockPrice = 0;
    static double porogPrice = 0;
    static double keyPrice = 0;

    static double profileCoefficient;
    static double laminationCoefficient;
    static double lam = 0.0;
    static double priceGlass;

    static List<String> dataTypeOfType = new ArrayList<>();
    static List<String> dataTypeOfLoop = new ArrayList<>();
    static List<String> dataColorLoop = new ArrayList<>();
    static List<String> dataTypeOfGlass = new ArrayList<>();
    static List<String> dataFurnit = new ArrayList<>();
    static List<String> dataLamination = new ArrayList<>();
    static List<String> dataRegion = new ArrayList<>();
    static List<String> dataProfile = new ArrayList<>();
    static List<String> dataHight = new ArrayList<>();
    static List<String> dataWidth = new ArrayList<>();
    static List<String> dataTypeOfGarnit = new ArrayList<>();
    static List<String> dataColorGarnit = new ArrayList<>();
    static List<String> dataPorog = new ArrayList<>();
    static List<String> dataKey = new ArrayList<>();
    static List<String> dataGlassDif = new ArrayList<>();
    static List<String> dataGlassList = new ArrayList<>();
//--------------------------------------------------------------------------------------------

    String[] dataType = {"1 створ. дверь", "Штульповая дверь"};
    Double [] glassPriceItems = {0.0, 0.0, 0.0, 0.0};

    //--------------------------------------------------------------------------------------------------
    static ArrayAdapter<String> adapterTypeOfType;
    static ArrayAdapter<String> adapterTypeOfLoop;
    static ArrayAdapter<String> adapterColorLoop;
    static ArrayAdapter<String> adapterTypeOfGlass;

    static ArrayAdapter<String> adapterFurnit;
    static ArrayAdapter<String> adapterLamination;
    static ArrayAdapter<String> adapterRegion;
    static ArrayAdapter<String> adapterProfile;

    static ArrayAdapter<String> adapterHight;
    static ArrayAdapter<String> adapterWidth;
    static ArrayAdapter<String> adapterTypeOfGarnit;
    static ArrayAdapter<String> adapterColorGarnit;
    static ArrayAdapter<String> adapterPorog;
    static ArrayAdapter<String> adapterKey;

    static ArrayAdapter<String> adapterGlassDif;
    static ArrayAdapter<String> adapterGlassDifLst;

    public AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddoor);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        final Intent prodListBut = new Intent(AddDoorActivity.this, ProductList.class);

        final ListView listGlassDif = (ListView) findViewById(R.id.listGlass);
//----------------------------------------
        final ArrayAdapter<String> adapterType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataType);

        adapterProfile = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataProfile);

        adapterTypeOfGlass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfGlass);

        adapterFurnit = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataFurnit);

        adapterTypeOfType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfType);

        adapterTypeOfLoop = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfLoop);

        adapterColorLoop = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataColorLoop);

        adapterHight = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataHight);

        adapterWidth = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataWidth);

        adapterLamination = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataLamination);

        adapterRegion = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataRegion);

        adapterTypeOfGarnit = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataTypeOfGarnit);

        adapterColorGarnit = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataColorGarnit);

        adapterPorog = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataPorog);

        adapterKey = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataKey);

        adapterGlassDif = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataGlassDif);
        adapterGlassDifLst = new ArrayAdapter<String>(this, R.layout.listglassitem, dataGlassList);
        listGlassDif.setAdapter(adapterGlassDifLst);

//----------------------------------------
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterProfile.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterProfile.clear();
        adapterProfile.addAll(addList(R.array.Prof_Door));

        adapterFurnit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterFurnit.clear();
        adapterFurnit.addAll(addList(R.array.dtaLoop1));

        adapterTypeOfGlass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTypeOfGlass.clear();
        adapterTypeOfGlass.addAll(addList(R.array.dtaGlassDoor2));

        adapterTypeOfType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTypeOfType.clear();
        adapterTypeOfType.addAll(addList(R.array.Type_Door));

        adapterTypeOfLoop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTypeOfLoop.clear();
        adapterTypeOfLoop.addAll(addList(R.array.dtaTypeOfLoop));

        adapterColorLoop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterColorLoop.clear();
        adapterColorLoop.addAll(addList(R.array.dtaColorLoop1));

        adapterHight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterHight.clear();
        adapterHight.addAll(addList(R.array.Hight_Door));

        adapterWidth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterWidth.clear();
        adapterWidth.addAll(addList(R.array.Width_Door1));

        adapterLamination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterLamination.clear();
        adapterLamination.addAll(addList(R.array.dtaLamination));

        adapterRegion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterRegion.clear();
        adapterRegion.addAll(addList(R.array.dtaRegion));

        adapterTypeOfGarnit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTypeOfGarnit.clear();
        adapterTypeOfGarnit.addAll(addList(R.array.dtaTypeOfGarnitDoorProf));

        adapterColorGarnit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterColorGarnit.clear();
        adapterColorGarnit.addAll(addList(R.array.dtaColorGarnit1));

        adapterPorog.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterPorog.clear();
        adapterPorog.addAll(addList(R.array.dtaPorog));

        adapterKey.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterKey.clear();
        adapterKey.addAll(addList(R.array.dtaKey));

        adapterGlassDif.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterGlassDif.clear();
        adapterGlassDif.addAll(addList(R.array.dtaGlassDif));

//----------------------------------------

        final Spinner spinnerType = findViewById(R.id.spinner_type);

        final Spinner spinnerProfile = findViewById(R.id.spinner_profile);

        final Spinner spinnerTypeOfGlass = findViewById(R.id.spinner_typeOfGlass);

        final Spinner spinnerFurnit = findViewById(R.id.spinner_furnit);

        final Spinner spinnerTypeOfType = findViewById(R.id.spinner_typeOfType);

        final Spinner spinnerTypeOfLoop = findViewById(R.id.spinner_typeOfLoop);

        final Spinner spinnerColorLoop = findViewById(R.id.spinner_loopColor);

        final Spinner spinnerHight = findViewById(R.id.spinner_hight);

        final Spinner spinnerWidth = findViewById(R.id.spinner_width);

        final Spinner spinnerLamination = findViewById(R.id.spinner_lamination);

        final Spinner spinnerRegion = findViewById(R.id.spinner_region);
        spinnerRegion.setVisibility(View.INVISIBLE);

        final Spinner spinnerTypeOfGarnit = findViewById(R.id.spinner_typeOfGarnit);

        final Spinner spinnerColorGarnit = findViewById(R.id.spinner_colorGarnit);

        final Spinner spinnerPorog = findViewById(R.id.spinner_porog);

        final Spinner spinnerKey = findViewById(R.id.spinner_typeOfKey);

        final Spinner spinnerGlassDif = findViewById(R.id.spinner_glassDif);
//----------------------------------------
        final Button setTypeButton = findViewById(R.id.button_addType);
        final Button prodLstBut = findViewById(R.id.button_ProdLst);

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
                spinnerWidth.setSelection(0);
                flag = true;
                setPrice(positionType1, positionProfile1);
                setLoopValue();
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
                positionWidth1 = 0;
                spinnerWidth.setSelection(0);
                setPrice(positionType1, positionProfile1);
                positionColorLoop1 = 0;
                spinnerColorLoop.setSelection(0);
                setColorLoop();
                positionTypeOfGlass1 = 0;
                spinnerTypeOfGlass.setSelection(0);
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

                if(positionTypeOfType1 == 1 || positionTypeOfType1 == 2) {
                    if( (bb70 && positionTypeOfGlass == 2) || (!bb70 && positionTypeOfGlass == 1) ) {
                        spinnerTypeOfGlass.setSelection(positionTypeOfGlass1);
                    }
                }
                positionTypeOfGlass1 = positionTypeOfGlass;
                setProfile(positionProfile1, positionTypeOfGlass1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________________Количество петель__________________
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
                setLoopValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________________ТИП ЗАПОЛНЕНИЯ (СТЕКЛО\СЕНДВИЧ\50*50)__________________
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
                positionTypeOfType1 = positionTypeOfType;

                if(positionTypeOfType1 == 0) {
                    spinnerGlassDif.setVisibility(View.VISIBLE);
                    listGlassDif.setVisibility(View.VISIBLE);
                }
                if(positionTypeOfType1 == 1) {
                    positionTypeOfGlass1 = 0;
                    spinnerTypeOfGlass.setSelection(0);
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
                if(positionTypeOfType1 == 2) {
                    positionTypeOfGlass1 = 0;
                    spinnerTypeOfGlass.setSelection(0);
                    spinnerGlassDif.setVisibility(View.VISIBLE);
                    listGlassDif.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;

//____________________ТИП ПЕТЕЛЬ____________________________________________________________________
        spinnerTypeOfLoop.setAdapter(adapterTypeOfLoop);
        // заголовок
        spinnerTypeOfLoop.setPrompt("Тип петель");
        // выделяем элемент
        spinnerTypeOfLoop.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerTypeOfLoop.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionTypeOfLoop, long idTypeOfLoop) {

                positionTypeOfLoop1 = positionTypeOfLoop;
                positionColorLoop1 = 0;
                spinnerColorLoop.setSelection(0);
                setColorLoop();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
        //____________________ЦВЕТ ПЕТЕЛЬ__________________

        spinnerColorLoop.setAdapter(adapterColorLoop);
        // заголовок
        spinnerColorLoop.setPrompt("Цвет петель");
        // выделяем элемент
        spinnerColorLoop.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerColorLoop.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionColorLoop, long idColorLoop) {

                positionColorLoop1 = positionColorLoop;

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

        //_____________ТИП ГАРНИТУРЫ_______________

        spinnerTypeOfGarnit.setAdapter(adapterTypeOfGarnit);
        // заголовок
        spinnerTypeOfGarnit.setPrompt("Тип гарнитуры");
        // выделяем элемент
        spinnerTypeOfGarnit.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerTypeOfGarnit.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionTypeOfGarnit, long idTypeOfGarnit) {

                positionTypeOfGarnit1 = positionTypeOfGarnit;
                positionColorGarnit1 = 0;
                spinnerColorGarnit.setSelection(0);
                setColorGarnit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
        //_____________ЦВЕТ ГАРНИТУРЫ_______________

        spinnerColorGarnit.setAdapter(adapterColorGarnit);
        // заголовок
        spinnerColorGarnit.setPrompt("Цвет гарнитуры");
        // выделяем элемент
        spinnerColorGarnit.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerColorGarnit.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionColorGarnit, long idColorGarnit) {

                positionColorGarnit1 = positionColorGarnit;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________ПОРОГ______________________________

        spinnerPorog.setAdapter(adapterPorog);
        // заголовок
        spinnerPorog.setPrompt("Порог");
        // выделяем элемент
        spinnerPorog.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerPorog.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionPorog, long idPorog) {

                positionPorog1 = positionPorog;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;

        //__________________КЛЮЧ______________________________

        spinnerKey.setAdapter(adapterKey);
        // заголовок
        spinnerKey.setPrompt("Ключ");
        // выделяем элемент
        spinnerKey.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerKey.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionKey, long idKey) {

                positionKey1 = positionKey;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//__________________________ТИП СТЕКЛА_________________________________________

        spinnerGlassDif.setAdapter(adapterGlassDif);
        // заголовок
        spinnerGlassDif.setPrompt("Тип стекла");
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
//---------------------------------------------ЛИСТЫ------------------------
        builder = new AlertDialog.Builder(AddDoorActivity.this);

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
//---------------------------------КНОПКИ------------------------

        setTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.startAnimation(animAlpha);

                getPriceFlag = true;
                setPrice(positionType1, positionProfile1);
                setLaminationCoefficient();
                setLamination();
                setLoopPrice();
                setGarnitPrice();
                setPorogPrice();
                setKeyPrice();
                setGlassPrice();

                String itemName = dataType[positionType1] + " " + dataProfile.get(positionProfile1) + "/" + dataTypeOfGlass.get(positionTypeOfGlass1);
                String itemInfo = "Профиль: " + dataProfile.get(positionProfile1) + "/" + dataTypeOfGlass.get(positionTypeOfGlass1) + "\n" +
                        dataType[positionType1] + " " + dataTypeOfType.get(positionTypeOfType1) + "\n" +
                        "В " + dataHight.get(positionHight1) + "*" + dataWidth.get(positionWidth1) + " Ш" + "\n" +
                        (positionLamination1 == 0 ? dataLamination.get(positionLamination1) : "Ламинация: " + dataLamination.get(positionLamination1)) + "\n" +
                        dataFurnit.get(positionFurnit1) + " " + dataTypeOfLoop.get(positionTypeOfLoop1) + " " + dataColorLoop.get(positionColorLoop1) + "\n" +
                        dataTypeOfGarnit.get(positionTypeOfGarnit1) + " " + dataColorGarnit.get(positionColorGarnit1) + "\n" +
                        (positionTypeOfGarnit1 != 4 ? "Многозапорный замок": "Монозапорный замок(ролик) ROTO") + " " + dataKey.get(positionKey1) + "\n" +
                        dataPorog.get(positionPorog1) + "\n" +
                        (positionTypeOfType1 != 1 ? (!dataTypeOfGlass.get(positionTypeOfGlass1).equals("24") ?
                                dataGlassList.get(0) + ";" + dataGlassList.get(1) + ";" + dataGlassList.get(2) + ";" + "\n" :
                                dataGlassList.get(0) + ";" + dataGlassList.get(1) + ";" + "\n") : "");

                if (positionRegion1 == 0) {
                    ProductList.addProdLst(itemName, setRegionPrice(), itemInterest,0,0);
                    MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, setRegionPrice(), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                }
                else {
                    ProductList.addProdLst(itemName, setMinskPrice(), itemInterest,0,0);
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
        });
//__________________________________________________________________________________-
        prodLstBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(prodListBut);
            }
        });
    }
//-------------------------------------------------------------------------------------


    public void setPrice(int p1, int p2) {

        //Если деврной профиль, то скоба ставится
        if (p2 == 0 || p2 == 1 || p2 == 4 || p2 == 5) {
            adapterTypeOfGarnit.clear();
            adapterTypeOfGarnit.addAll(addList(R.array.dtaTypeOfGarnitDoorProf));
        }
        //Если оконный профиль, то скоба НЕ ставится
        else if (p2 == 2 || p2 == 3) {
            adapterTypeOfGarnit.clear();
            adapterTypeOfGarnit.addAll(addList(R.array.dtaTypeOfGarnitWindowProf));
        }

        // Одностворчатаяя дверь - Дверной профиль 70
        if(p1 == 0 && p2 == 0) {
            dDoor = true;
            wDoor = false;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door1));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop1));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR1ST;

                price = MainActivity.prices.doorBB7032D1[positionHight1][positionWidth1];
            }
            return;
        }

        // Одностворчатаяя дверь - Дверной профиль 60
        else if(p1 == 0 && p2 == 1) {
            dDoor = true;
            wDoor = false;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door1));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop1));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR1ST;

                price = MainActivity.prices.doorBB6032D1[positionHight1][positionWidth1];
            }
            return;
        }

        // Одностворчатаяя дверь - Оконный профиль 70
        else if(p1 == 0 && p2 == 2) {
            dDoor = false;
            wDoor = true;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door1));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop1));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR1ST;

                price = MainActivity.prices.doorBB7032W1[positionHight1][positionWidth1];
            }
            return;
        }

        // Одностворчатаяя дверь - Оконный профиль 60
        else if(p1 == 0 && p2 == 3) {
            dDoor = false;
            wDoor = true;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door1));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop1));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR1ST;

                price = MainActivity.prices.doorBB6032W1[positionHight1][positionWidth1];
            }
            return;
        }

        // Одностворчатаяя дверь - Дверной профиль REHAU 70
        else if(p1 == 0 && p2 == 4) {
            dDoor = true;
            wDoor = false;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door1));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop1));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR1ST;

                price = MainActivity.prices.doorREHAU7032D1[positionHight1][positionWidth1];
            }
            return;
        }

        // Одностворчатаяя дверь - Дверной профиль REHAU 60
        else if(p1 == 0 && p2 == 5) {
            dDoor = true;
            wDoor = false;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door1));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop1));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR1ST;

                price = MainActivity.prices.doorREHAU6032D1[positionHight1][positionWidth1];
            }
            return;
        }

        // Штульповая дверь - Дверной профиль 70
        else if(p1 == 1 && p2 == 0) {
            dDoor = true;
            wDoor = false;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door2));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop2));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR2ST;

                price = MainActivity.prices.doorBB7032D2[positionHight1][positionWidth1];
            }
            return;
        }

        // Штульповая дверь - Дверной профиль 60
        else if(p1 == 1 && p2 == 1) {
            dDoor = true;
            wDoor = false;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door2));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop2));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR2ST;

                price = MainActivity.prices.doorBB6032D2[positionHight1][positionWidth1];
            }
            return;
        }

        // Штульповая дверь - Оконный профиль 70
        else if(p1 == 1 && p2 == 2) {
            dDoor = false;
            wDoor = true;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door2));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop2));
                flag = false;
            }


            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR2ST;

                price = MainActivity.prices.doorBB7032W2[positionHight1][positionWidth1];
            }
            return;
        }

        // Штульповая дверь - Оконный профиль 60
        else if(p1 == 1 && p2 == 3) {
            dDoor = false;
            wDoor = true;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door2));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop2));
                flag = false;
            }


            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR2ST;

                price = MainActivity.prices.doorBB6032W2[positionHight1][positionWidth1];
            }
            return;
        }

        // Штульповая дверь - Дверной профиль REHAU 70
        else if(p1 == 1 && p2 == 4) {
            dDoor = true;
            wDoor = false;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door2));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop2));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR2ST;

                price = MainActivity.prices.doorREHAU7032D2[positionHight1][positionWidth1];
            }
            return;
        }

        // Штульповая дверь - Дверной профиль REHAU 60
        else if(p1 == 1 && p2 == 5) {
            dDoor = true;
            wDoor = false;

            if (flag == true) {
                adapterWidth.clear();
                adapterWidth.addAll(addList(R.array.Width_Door2));
                adapterFurnit.clear();
                adapterFurnit.addAll(addList(R.array.dtaLoop2));
                flag = false;
            }

            if (getPriceFlag == true) {
                getPriceFlag = false;

                itemInterest = MainActivity.prices.INTDOOR2ST;

                price = MainActivity.prices.doorREHAU6032D2[positionHight1][positionWidth1];
            }
            return;
        }

    }

    //_____________________________________________________________________________________
    public void setProfile(int p1, int p2) {

        if (p2 == 0 || (p2 == 1 && bb70)) {
            glassPriceItems[0] = 0.0;
            glassPriceItems[1] = 0.0;
            glassPriceItems[2] = 0.0;
            glassPriceItems[3] = 0.0;
            adapterGlassDifLst.clear();
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
        }else {
            glassPriceItems[0] = 0.0;
            glassPriceItems[1] = 0.0;
            glassPriceItems[2] = 0.0;
            glassPriceItems[3] = 0.0;
            adapterGlassDifLst.clear();
            adapterGlassDifLst.add("Обычное стекло");
            adapterGlassDifLst.add("Обычное стекло");
        }

        // 70/40 Дверной/Оконный
        if ((p1 == 0 || p1 == 2 || p2 == 4) && p2 == 0) {
            profileCoefficient = MainActivity.prices.BB7040D;
            if(!bb70) {
                adapterTypeOfGlass.clear();
                adapterTypeOfGlass.addAll(addList(R.array.dtaGlassDoor2));
            }
            bb70 = true;
            return;
        }

        // 70/32 Дверной/Оконный
        if ((p1 == 0 || p1 == 2 || p2 == 4) && p2 == 1) {
            profileCoefficient = MainActivity.prices.BB7032D;
            if(!bb70) {
                adapterTypeOfGlass.clear();
                adapterTypeOfGlass.addAll(addList(R.array.dtaGlassDoor2));
            }
            bb70 = true;
            return;
        }

        // 70/24 Дверной/Оконный
        if ((p1 == 0 || p1 == 2 || p2 == 4) && p2 == 2) {
            profileCoefficient = MainActivity.prices.BB7024D;
            if(!bb70) {
                adapterTypeOfGlass.clear();
                adapterTypeOfGlass.addAll(addList(R.array.dtaGlassDoor2));
            }
            bb70 = true;
            return;
        }

        // 60/32 Дверной/Оконный
        if ((p1 == 1 || p1 == 3 || p2 == 5) && p2 == 0) {
            profileCoefficient = MainActivity.prices.BB6032D;
            if(bb70) {
                adapterTypeOfGlass.clear();
                adapterTypeOfGlass.addAll(addList(R.array.dtaGlassDoor));
            }
            bb70 = false;
            return;
        }

        // 60/24 Дверной/Оконный
        if ((p1 == 1 || p1 == 3 || p2 == 5) && p2 == 1) {
            profileCoefficient = MainActivity.prices.BB6024D;
            if(bb70) {
                adapterTypeOfGlass.clear();
                adapterTypeOfGlass.addAll(addList(R.array.dtaGlassDoor));
            }
            bb70 = false;
            return;
        }


    }
    //______________________________________________________
    public void setLaminationCoefficient(){

        if(positionLamination1 == 0) {
            laminationCoefficient = 1;
            return;
        }
        //Односторонняя ламинация
        if(positionLamination1 == 1) {
            //Оконный профиль
            if (wDoor) {
                laminationCoefficient = MainActivity.prices.lamD1stW;
            }
            //Дверной профиль
            else {
                laminationCoefficient = MainActivity.prices.lamD1stD;
            }
            return;
        }
        //Двухсторонняя ламинация
        if(positionLamination1 == 2) {
            //Оконный профиль
            if (wDoor) {
                laminationCoefficient = MainActivity.prices.lamD2stW;
            }
            //Дверной профиль
            else {
                laminationCoefficient = MainActivity.prices.lamD2stD;
            }
            return;
        }
    }
    //____________________________________________________________

    public void setLamination(){

        lam = 0;

        //Если стекло 100%
        if(positionTypeOfType1 == 0) {
            lam = 0;
        }

        //Если Сендвич 100%
        else if(positionTypeOfType1 == 1) {
            //Если ламинация с 1 стороны
            if (positionLamination1 == 1) {
                lam = ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * MainActivity.prices.lamSend;
            }
            //Если ламинация с 2 сторон
            else if (positionLamination1 == 2) {
                lam = (((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) * MainActivity.prices.lamSend) * 2;
            }
        }
        else if(positionTypeOfType1 == 2) {
            if (positionLamination1 == 1) {
                lam = ( ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) / 2) * MainActivity.prices.lamSend;
            }
            else if (positionLamination1 == 2) {
                lam = ( ( ((Double.parseDouble(dataHight.get(positionHight1)) / 1000) * (Double.parseDouble(dataWidth.get(positionWidth1)) / 1000)) / 2) * MainActivity.prices.lamSend) * 2;
            }
        }
    }
    //__________________________________________________________________________

    public void setLoopPrice() {

        //Дверной профиль
        if(dDoor) {
            //Стандартные петли
            if(positionTypeOfLoop1 == 0) {
               loopPrice = loopValue * MainActivity.prices.petliDverStndtr - loopValueStnd * MainActivity.prices.petliDverStndtr;
            }
            //Петли Jocker
            else if(positionTypeOfLoop1 == 1) {
                //Белые или Коричневые
                if (positionColorLoop1 == 0 || positionColorLoop1 == 1) {
                    loopPrice = loopValue * MainActivity.prices.petliJoker120BelKorich - loopValueStnd * MainActivity.prices.petliDverStndtr;
                }
                //Другие цвета
                else {
                    loopPrice = loopValue * MainActivity.prices.petliJoker120Cvet - loopValueStnd * MainActivity.prices.petliDverStndtr;
                }
            }
            //Петли Roto
            else if(positionTypeOfLoop1 == 2) {
                //Белые или Коричневые
                if (positionColorLoop1 == 0 || positionColorLoop1 == 1) {
                    loopPrice = loopValue * MainActivity.prices.petliRoto120BelKorich - loopValueStnd * MainActivity.prices.petliDverStndtr;
                }
                //Антрацит
                else if(positionColorLoop1 == 2) {
                    loopPrice = loopValue * MainActivity.prices.petliRoto120Antracit - loopValueStnd * MainActivity.prices.petliDverStndtr;
                }
                //Серебро
                else if(positionColorLoop1 == 3) {
                    loopPrice = loopValue * MainActivity.prices.petliRoto120Serebro - loopValueStnd * MainActivity.prices.petliDverStndtr;
                }
                //Бронза
                else if(positionColorLoop1 == 4) {
                    loopPrice = loopValue * MainActivity.prices.petliRoto120Bronza - loopValueStnd * MainActivity.prices.petliDverStndtr;
                }
            }
        }
        else if(wDoor) {
            //Стандартные петли
            if(positionTypeOfLoop1 == 0) {
                loopPrice = loopValue * MainActivity.prices.petliDverStndtr - loopValueStnd * MainActivity.prices.petliDverStndtr;
                return;
            }
            //Петли Jocker
            if(positionTypeOfLoop1 == 1) {
                //Белые или Коричневые
                if (positionColorLoop1 == 0 || positionColorLoop1 == 1) {
                    loopPrice = loopValue * MainActivity.prices.petliJoker80BelKorich - loopValueStnd * MainActivity.prices.petliDverStndtr;
                }
                //Другие цвета
                else {
                    loopPrice = loopValue * MainActivity.prices.petliJoker80Cvet - loopValueStnd * MainActivity.prices.petliDverStndtr;
                }
            }
            //Петли Roto
            else if(positionTypeOfLoop1 == 2) {
                //Белые или Коричневые
                    loopPrice = loopValue * MainActivity.prices.petliRoto80BelKorich - loopValueStnd * MainActivity.prices.petliDverStndtr;
            }
        }

    }

    //__________________________________________________________________________

    public void setLoopValue() {

        //Одноствор дверь
        if (positionType1 == 0) {
            loopValueStnd = 3;
            // 3 Петли
            if (positionFurnit1 == 0) {
                loopValue = 3;
                return;
            }
            // 4 Петли
            else {
                loopValue = 4;
                return;
            }
        }
        else {
            loopValueStnd = 6;
            // 6 Петель
            if (positionFurnit1 == 0) {
                loopValue = 6;
                return;
            }
            // 8 Петель
            else {
                loopValue = 8;
                return;
            }
        }

    }

    //__________________________________________________________________________

    public void setColorLoop() {
        if (dDoor) {
            if (positionTypeOfLoop1 == 0) {
                adapterColorLoop.clear();
                adapterColorLoop.addAll(addList(R.array.dtaColorLoop1));
                return;
            }
            if (positionTypeOfLoop1 == 1) {
                adapterColorLoop.clear();
                adapterColorLoop.addAll(addList(R.array.dtaColorLoop2));
                return;
            }
            if (positionTypeOfLoop1 == 2) {
                adapterColorLoop.clear();
                adapterColorLoop.addAll(addList(R.array.dtaColorLoop3));
                return;
            }
        }
        if (wDoor) {
            if (positionTypeOfLoop1 == 0 || positionTypeOfLoop1 == 2) {
                adapterColorLoop.clear();
                adapterColorLoop.addAll(addList(R.array.dtaColorLoop1));
                return;
            }
            if (positionTypeOfLoop1 == 1) {
                adapterColorLoop.clear();
                adapterColorLoop.addAll(addList(R.array.dtaColorLoop2));
                return;
            }
        }

    }
    //__________________________________________________________________________
    public void setColorGarnit() {

        if (positionTypeOfGarnit1 == 0) {
            adapterColorGarnit.clear();
            adapterColorGarnit.addAll(addList(R.array.dtaColorGarnit1));
            return;
        }
        if (positionTypeOfGarnit1 == 1) {
            adapterColorGarnit.clear();
            adapterColorGarnit.addAll(addList(R.array.dtaColorGarnit1_2));
            return;
        }
        if (positionTypeOfGarnit1 == 2) {
            adapterColorGarnit.clear();
            adapterColorGarnit.addAll(addList(R.array.dtaColorGarnit2));
            return;
        }
        if (positionTypeOfGarnit1 == 3) {
            adapterColorGarnit.clear();
            adapterColorGarnit.addAll(addList(R.array.dtaColorGarnit3));
            return;
        }
        if (positionTypeOfGarnit1 == 4) {
            adapterColorGarnit.clear();
            adapterColorGarnit.addAll(addList(R.array.dtaColorGarnit4));
            return;
        }
    }
    //____________________________________________________________________

    public void setGarnitPrice() {
        lockPrice = MainActivity.prices.mnogozapornik;

        //Стандартный гарнитур (Белый или коричневый)
        if (positionTypeOfGarnit1 == 0) {
            garnitPrice = 0;
            return;
        }
        //Стандартный из двух (Белый/Коричневый)
        if (positionTypeOfGarnit1 == 1) {
            garnitPrice = MainActivity.prices.garnitStndr2;
            return;
        }
        //MEDOS VICTORY
        if (positionTypeOfGarnit1 == 2) {
            //Белый или Коричневый
            if (positionColorGarnit1 == 0 || positionColorGarnit1 == 1) {
                garnitPrice = MainActivity.prices.garnitMedosVictory;
                return;
            }
            //Остальные цвета
            else {
                garnitPrice = MainActivity.prices.garnitMedosVictoryCvet;
                return;
            }
        }
        //MEDOS VICTORY из 2-ух
        if (positionTypeOfGarnit1 == 3) {
            // Белый/Коричневый
            if (positionColorGarnit1 == 0) {
                garnitPrice = MainActivity.prices.garnitMedosVictory2;
                return;
            }
            else {
                garnitPrice = MainActivity.prices.garnitMedosVictoryCvet2;
                return;
            }
        }
        //РУЧКА СКОБА
        if (positionTypeOfGarnit1 == 4) {
            lockPrice = MainActivity.prices.mnogozapornikRolik;
            //Белая или Коричневая
            if (positionColorGarnit1 == 0 || positionColorGarnit1 == 1) {
                garnitPrice = MainActivity.prices.ruchkaSkobaBelKorich;
                return;
            }
            //Антрацит - Серебро - Черный
            if (positionColorGarnit1 == 2 || positionColorGarnit1 == 3 || positionColorGarnit1 == 4) {
                garnitPrice = MainActivity.prices.ruchkaSkobaCvet;
                return;
            }
            //Нержавейка
            if (positionColorGarnit1 == 5) {
                garnitPrice = MainActivity.prices.ruchkaSkobaNerzh;
                return;
            }
        }
    }
    //____________________________________________________________________
    public void setPorogPrice() {
        if (positionPorog1 == 0) {
            porogPrice = 0;
            return;
        }
        else {
            porogPrice = (Double.parseDouble(dataWidth.get(positionWidth1))/1000) * MainActivity.prices.porogPvh;
        }
    }

    //____________________________________________________________________
    public void setKeyPrice() {
        //Если ключ - ключ
        if (positionKey1 == 0) {
            keyPrice = 0;
            return;
        }
        //Если барашка
        else {
            keyPrice = MainActivity.prices.barashka;
        }
    }
    //____________________________________________________________________
    public double setRegionPrice(){
        return Math.ceil(((((price + lockPrice + porogPrice + keyPrice) * profileCoefficient) * laminationCoefficient) + lam + loopPrice + garnitPrice + priceGlass));
    }

    public double setMinskPrice() {
        return Math.ceil(((((price + lockPrice + porogPrice + keyPrice) * profileCoefficient) * laminationCoefficient) + lam + loopPrice + garnitPrice + priceGlass));
    }

    public List<String> addList(@ArrayRes int id) {
        return Arrays.asList(getResources().getStringArray(id));
    }

    public void  setGlassPriceItems(int p1, int p2) {
        //Вызывается при нажатии на эелемент листа
        //p1 - тип стекла
        //p2 - Позиция стекла в лсите

        //Обычное стекло
        if (p1 == 0) {
            glassPriceItems[p2] = 0.0;
        }
        //Мультик простой
        else if (p1 == 1) {
            glassPriceItems[p2] = MainActivity.prices.multik;
        }
        //Бронза в массе
        else if (p1 == 2) {
            glassPriceItems[p2] = MainActivity.prices.bronza;
        }
        //Матовое заводское
        else if (p1 == 3) {
            glassPriceItems[p2] = MainActivity.prices.mat;
        }
        //Тонировка пленка
        else if (p1 == 4) {
            glassPriceItems[p2] = MainActivity.prices.tonirovka;
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
        if (positionTypeOfType1 == 0) {
            priceGlass = glass1 + glass2 + glass3;
        }else {
            priceGlass = glass1 + glass2 + glass3;
            priceGlass /= 2;
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
//____________________________________________________________________

}