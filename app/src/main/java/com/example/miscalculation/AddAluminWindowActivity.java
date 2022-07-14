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
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.Button;

import com.example.miscalculation.excelUtill.ExcelCreator;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class AddAluminWindowActivity extends AppCompatActivity  {

    final Context context = this;

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

//--------------------------------------------------------------------------------------------

    String[] dataType = {"Окно 1 створ.", "Окно 2 створ.", "Окно 3 створ.", "Балконная рама (4 створ.)"};

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
//-------------------------------------------------------------------------------------
    }

    //Метод для добавление, вынесен из кнопки что бы при создании спецификации можно было дождаться ввода точных размеров
    public void startAdd(String itemName, String itemInfo) {
        //Если добавление в конец списка
        if(!addFromList) {
            ProductList.addProdLst(itemName, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, 0, 0);
            MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));

            //Добавление в пакет, только если активный замер сам не является пакетом
            if(!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.PROPLEX7032W, itemName, itemInfo, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.BB7040W, itemName, itemInfo, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAU7040W, itemName, itemInfo, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAUINTELIO, itemName, itemInfo, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)));
            }


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
            ProductList.addProdLst(itemName, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, 0, 0);
            MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());

            //Добавление в пакет, только если активный замер сам не является пакетом
            if(!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.PROPLEX7032W, itemName, itemInfo, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.BB7040W, itemName, itemInfo, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAU7040W, itemName, itemInfo, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAUINTELIO, itemName, itemInfo, Math.ceil(price * MainActivity.prices.ALUMIN * laminationCoefficient), itemInterest, Integer.parseInt(dataWidth.get(positionWidth1)), ProductList.getIndexOfAddToBlock());
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
                    itemInterest = MainActivity.prices.INTW2ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW1ST;
                }
                price = MainActivity.prices.windAl1stNo[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL1STNO_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW3ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW2ST;
                }
                price = MainActivity.prices.windAl2st1Op[positionHight1][positionWidth1] - 3;

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL2STNO_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW4ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW3ST;
                }
                price = MainActivity.prices.windAl3st1Op[positionHight1][positionWidth1] - 3;

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL3STNO_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW3ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW2ST;
                }
                price = MainActivity.prices.windAl2st1Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL2ST1OP_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW3ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW2ST;
                }
                price = MainActivity.prices.windAl2st1Op[positionHight1][positionWidth1] + 3;

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL2ST2OP_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW4ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW3ST;
                }
                price = MainActivity.prices.windAl3st1Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL3ST1OP_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW4ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW3ST;
                }

                price = MainActivity.prices.windAl3st1Op[positionHight1][positionWidth1] + 3;

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL3ST2OP_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW4ST;
                }
                else {
                    itemInterest = MainActivity.prices.INTW3ST;
                }
                price = MainActivity.prices.windAl3st1Op[positionHight1][positionWidth1] + 6;

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL3ST3OP_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW4STV2;
                }
                else {
                    itemInterest = MainActivity.prices.INTW4ST;
                }
                price = MainActivity.prices.windAl4st2Op[positionHight1][positionWidth1] - 6;

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL4STNO_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW4STV2;
                }
                else {
                    itemInterest = MainActivity.prices.INTW4ST;
                }

                price = MainActivity.prices.windAl4st2Op[positionHight1][positionWidth1] - 3;

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL4ST1OP_PICTURE);

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
                    itemInterest = MainActivity.prices.INTW4STV2;
                }
                else {
                    itemInterest = MainActivity.prices.INTW4ST;
                }

                price = MainActivity.prices.windAl4st2Op[positionHight1][positionWidth1];

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL4ST2OP_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW4STV2;
                }
                else {
                    itemInterest = MainActivity.prices.INTW4ST;
                }

                price = MainActivity.prices.windAl4st2Op[positionHight1][positionWidth1] + 3;

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL4ST3OP_PICTURE);
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
                    itemInterest = MainActivity.prices.INTW4STV2;
                }
                else {
                    itemInterest = MainActivity.prices.INTW4ST;
                }

                price = MainActivity.prices.windAl4st2Op[positionHight1][positionWidth1] + 6;

                //Добавляем информацию о том какую картинку использовать
                ExcelCreator.setTmpPicturePath(ExcelCreator.AL4ST4OP_PICTURE);
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
                laminationCoefficient = MainActivity.prices.korichAlumin;
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


