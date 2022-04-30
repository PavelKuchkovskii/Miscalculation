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
import java.util.Locale;

public class AddDopActivity extends AppCompatActivity {

    static boolean dopFlag = false;
    static boolean getPrice = false;

    static int positionLamination1;
    static int positionDop1;
    static int positionHightDop1;
    static int positionWidthDop1;
    static int positionProfile1;

    static Spinner spinnerLamination = null;

    static double dopPrice;


    static List<String> dataDop = new ArrayList<>();
    static List<String> dataHightDop = new ArrayList<>();
    static List<String> dataWidthPodOtl = new ArrayList<>();
    static List<String> dataLamination = new ArrayList<>();
    //------------------------------------МАССИВЫ-------------------------------

    static double [] priceOtl1 = { 0.81, 0.9, 0.99, 1.08, 1.17, 1.26, 1.35, 1.44, 1.53, //+ 1
            1.62, 1.71, 1.8, 1.89, 1.98, 2.07, 2.16, 2.25, 2.34, 2.43, 2.52,
            2.61, 2.7, 2.79, 2.88, 2.97, 3.06, 3.15, 3.24, 3.33, 3.42, 3.51,
            3.6, 3.69, 3.78, 3.87, 3.96, 4.05 };

//--------------------------------------------------------------------------------------------
    String [] dataProfile = {"Brusbox, Rehau", "INTELIO", "Алюминий", "Proplex"};
    //--------------------------------------------------------------------------------------------------

    static ArrayAdapter<String> adapterHightDop;
    static ArrayAdapter<String> adapterWidthDop;
    static ArrayAdapter<String> adapterLamination;
    static ArrayAdapter<String> adapterDop;
    static ArrayAdapter<String> adapterProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddop);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Intent prodListBut = new Intent(AddDopActivity.this, ProductList.class);

        dataWidthPodOtl = Arrays.asList(getResources().getStringArray(R.array.Width_pod_Otl));
//----------------------------------------
        adapterLamination = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataLamination);
        adapterDop = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataDop);

        adapterHightDop = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataHightDop);
        adapterWidthDop = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataWidthPodOtl);
        adapterProfile = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataProfile);

//----------------------------------------
        adapterLamination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterLamination.clear();
        adapterLamination.addAll(addList(R.array.dtaLamDop));

        adapterDop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterHightDop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterWidthDop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterProfile.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//----------------------------------------
        spinnerLamination = findViewById(R.id.spinner_lamination);

        final Spinner spinnerDop = findViewById(R.id.spinner_dop);

        final Spinner spinnerHightDop = findViewById(R.id.spinner_hightDop);

        final Spinner spinnerWidthDop = findViewById(R.id.spinner_widthDop);

        final Spinner spinnerProfile = findViewById(R.id.spinner_profile);
//----------------------------------------
        final Button setDopButton = findViewById(R.id.button_addDop);
        final Button prodLstBut = findViewById(R.id.button_ProdLst);
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
//________________________ДОПЫ_______________

        spinnerDop.setAdapter(adapterDop);
        // заголовок
        spinnerDop.setPrompt("Допы");
        // выделяем элемент
        spinnerDop.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerDop.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionDop, long idDop) {

                positionDop1 = positionDop;

                positionHightDop1 = 0;
                spinnerHightDop.setSelection(0);

                dopFlag = true;
                setDopPrice();


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//______________________ВЫСОТА ДОПОВ__________________________

        spinnerHightDop.setAdapter(adapterHightDop);
        // заголовок
        spinnerHightDop.setPrompt("Высота допов");
        // выделяем элемент
        spinnerHightDop.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerHightDop.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionHightDop, long idHightDop) {
                positionHightDop1 = positionHightDop;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_________________________ДЛИНА ДОПОВ_______________________________

        spinnerWidthDop.setAdapter(adapterWidthDop);
        // заголовок
        spinnerWidthDop.setPrompt("Ширина допов");
        // выделяем элемент
        spinnerWidthDop.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerWidthDop.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionWidthDop, long idWidthDop) {
                positionWidthDop1 = positionWidthDop;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//_____________ЛАМИНАЦИЯ____________________________________________________________________________

        spinnerProfile.setAdapter(adapterProfile);
        // заголовок
        spinnerProfile.setPrompt("Профиль");
        // выделяем элемент
        spinnerProfile.setSelection(0);
        // устанавливаем обработчик нажатия
        spinnerProfile.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionProfile, long idProfile) {
                positionProfile1 = positionProfile;

                positionHightDop1 = 0;
                spinnerHightDop.setSelection(0);

                dopFlag = true;
                setDopPrice();

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

                getPrice = true;
                setDopPrice();
                String itemName = dataDop.get(positionDop1) + " " + (dataLamination.size() > 0 ? dataLamination.get(positionLamination1) : "") + " " + dataHightDop.get(positionHightDop1) + " * " + dataWidthPodOtl.get(positionWidthDop1) +
                        (positionDop1 != 0 && positionDop1 != 1 && positionDop1 != 2 && positionDop1 != dataDop.size() - 1 && positionDop1 != dataDop.size() - 2 ?
                                "\nДля: " + dataProfile[positionProfile1] : "");


                String itemInfo = "";

                //Добавление в пакет, только если активный замер сам не является пакетом
                if(!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.PROPLEX7032W, itemName, itemInfo, Double.valueOf(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, Integer.parseInt(dataWidthPodOtl.get(positionWidthDop1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.BB7040W, itemName, itemInfo, Double.valueOf(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, Integer.parseInt(dataWidthPodOtl.get(positionWidthDop1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAU7040W, itemName, itemInfo, Double.valueOf(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, Integer.parseInt(dataWidthPodOtl.get(positionWidthDop1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAUINTELIO, itemName, itemInfo, Double.valueOf(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, Integer.parseInt(dataWidthPodOtl.get(positionWidthDop1)));
                }
                ProductList.addProdLst(itemName, Double.parseDouble(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, 0, 0);
                MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, Double.valueOf(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, Integer.parseInt(dataWidthPodOtl.get(positionWidthDop1)));

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                try {
                    writeHash(MainActivity.hashMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

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

    //____________________________________________________________________
    public void setDopPrice() {

        if(dopFlag) {
            spinnerLamination.setVisibility(View.VISIBLE);
        }

        //Если Brusbox,Rehau
        if(positionProfile1 == 0) {

            adapterDop.clear();
            adapterDop.addAll(addList(R.array.dtaDopBrusbox));

            //Подоконник
            if (positionDop1 == 0) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Hight_pod));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaLamDop));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //Белый
                    if (positionLamination1 == 0) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODSTNDRT) + MainActivity.prices.ZAGLSTNDRT;
                        return;
                    }
                    //Ламинированный / Кристалит
                    if (positionLamination1 == 1) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODLAM) + MainActivity.prices.ZAGLSTNDRTCOLOR;
                        return;
                    }
                    //Подоконник Crystallit
                    if (positionLamination1 == 2) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODCRYSTALLIT) + MainActivity.prices.ZAGLCRYSTALLIT;
                        return;
                    }
                    //Подоконник Danke KOFMORT
                    if (positionLamination1 == 3) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKEKOMFORT) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник Danke STANDART
                    if (positionLamination1 == 4) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKESTANDART) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник Danke PREMIUM
                    if (positionLamination1 == 5) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKEPREMIUM) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник ESTERA
                    if (positionLamination1 == 6) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODESTERA) + MainActivity.prices.ZAGLESTERA;
                        return;
                    }
                }

            }

            //Отливы
            if (positionDop1 == 1) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Hight_Otl));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaColorDop));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //Белые/ Коричневые
                    if (positionLamination1 == 0) {
                        dopPrice = (priceOtl1[positionHightDop1] * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) + 1;
                        return;
                    }
                    //Крашенный
                    if (positionLamination1 == 1) {
                        dopPrice = (((Double.valueOf(dataHightDop.get(positionHightDop1)) + 55) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000) * 20) + (priceOtl1[positionHightDop1] * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) + 4;
                        return;
                    }
                }
            }

            //МС
            if (positionDop1 == 2) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Width_pod_Otl));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaMs));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //м/сетка внутр. белая
                    if (positionLamination1 == 0) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msBelVnut;
                        return;
                    }
                    //м/сетка внутр. корич
                    if (positionLamination1 == 1) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msKorichVnut;
                        return;
                    }
                    //м/сетка наруж. белая
                    if (positionLamination1 == 2) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msBelNar;
                        return;
                    }
                    //м/сетка наруж. корич
                    if (positionLamination1 == 3) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msKorichNar;
                        return;
                    }
                    //м/сетка на алюмин. раму
                    if (positionLamination1 == 4) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msAlumin;
                        return;
                    }
                    //м/сетка на двери бел.
                    if (positionLamination1 == 5) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msBelDver;
                        return;
                    }
                    //м/сетка на двери кор.
                    if (positionLamination1 == 6) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msKorichDver;
                        return;
                    }
                }
            }

            //Балконный соединитель 3мм
            if (positionDop1 == 3) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfileMM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //60 профиль
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.balSoed3mmNa60ProfileBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //70 профиль
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.balSoed3mmNa70ProfileBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Соединитель труба с адаптером
            if (positionDop1 == 4) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaPipeMM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //60 мм
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.soedTruba60mmBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //70 мм
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.soedTruba70mmBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Соединитель угловой 90 градусов
            if (positionDop1 == 5) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfileMM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //60 профиль
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.soed90na60ProfileBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //70 профиль
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.soed90na70ProfileBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Соединитель-молоток 18 мм
            if (positionDop1 == 6) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfileMM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;
                    //60 профиль
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.soedMolotokNA60ProfileBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //70 профиль
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.soedMolotokNA70ProfileBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Профиль расширительный 60 профиль
            if (positionDop1 == 7) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfRash60MM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //100 мм
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.profRashNa60Profile100mmBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //65 мм
                    else if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.profRashNa60Profile65mmBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //40 мм
                    else if (positionHightDop1 == 2) {
                        dopPrice = (MainActivity.prices.profRashNa60Profile40mmBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //20 мм
                    else if (positionHightDop1 == 3) {
                        dopPrice = (MainActivity.prices.profRashNa60Profile20mmBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Профиль расширительный 70 профиль
            if (positionDop1 == 8) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfRash70MM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //100 мм
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.profRashNa70Profile100mmBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //65 мм
                    else if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.profRashNa70Profile65mmBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //40 мм
                    else if (positionHightDop1 == 2) {
                        dopPrice = (MainActivity.prices.profRashNa70Profile40mmBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //20 мм
                    else if (positionHightDop1 == 3) {
                        dopPrice = (MainActivity.prices.profRashNa70Profile20mmBB * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Брус деревянный
            if (positionDop1 == 9) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaBrus));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;
                    //50*50
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.derBrus50 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //100*100
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }

            }

            //Нащельник ПВХ
            if (positionDop1 == 10) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaNash));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;
                    dopPrice = (MainActivity.prices.nashPvh * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                    return;
                }
            }
        }

//------------------------------INTELIO----------------------------------------------------------

        //Если INTELIO
        else if(positionProfile1 == 1) {

            adapterDop.clear();
            adapterDop.addAll(addList(R.array.dtaDopIntelio));

            //Подоконник
            if (positionDop1 == 0) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Hight_pod));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaLamDop));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //Белый
                    if (positionLamination1 == 0) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODSTNDRT) + MainActivity.prices.ZAGLSTNDRT;
                        return;
                    }
                    //Ламинированный / Кристалит
                    if (positionLamination1 == 1) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODLAM) + MainActivity.prices.ZAGLSTNDRTCOLOR;
                        return;
                    }
                    //Подоконник Crystallit
                    if (positionLamination1 == 2) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODCRYSTALLIT) + MainActivity.prices.ZAGLCRYSTALLIT;
                        return;
                    }
                    //Подоконник Danke KOFMORT
                    if (positionLamination1 == 3) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKEKOMFORT) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник Danke STANDART
                    if (positionLamination1 == 4) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKESTANDART) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник Danke PREMIUM
                    if (positionLamination1 == 5) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKEPREMIUM) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник ESTERA
                    if (positionLamination1 == 6) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODESTERA) + MainActivity.prices.ZAGLESTERA;
                        return;
                    }
                }

            }

            //Отливы
            if (positionDop1 == 1) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Hight_Otl));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaColorDop));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //Белые/ Коричневые
                    if (positionLamination1 == 0) {
                        dopPrice = (priceOtl1[positionHightDop1] * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) + 1;
                        return;
                    }
                    //Крашенный
                    if (positionLamination1 == 1) {
                        dopPrice = ((Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000) * 20) + (priceOtl1[positionHightDop1] * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) + 4;
                        return;
                    }
                }
            }

            //МС
            if (positionDop1 == 2) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Width_pod_Otl));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaMsSal));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //м/сетка внутр. белая
                    if (positionLamination1 == 0) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msBelVnut;
                        return;
                    }
                    //м/сетка внутр. корич
                    if (positionLamination1 == 1) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msKorichVnut;
                        return;
                    }
                    //м/сетка наруж. белая
                    if (positionLamination1 == 2) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msBelNar;
                        return;
                    }
                    //м/сетка наруж. корич
                    if (positionLamination1 == 3) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msKorichNar;
                        return;
                    }
                }
            }

            //Балконный соединитель 3мм
            if (positionDop1 == 3) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaSoedIntel));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = (MainActivity.prices.balSoedNaIntel * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                    return;

                }
            }

            //Соединитель труба с адаптером
            if (positionDop1 == 4) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaSoedAdapt));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = (MainActivity.prices.soedTrubaNaIntel * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                    return;

                }
            }

            //Соединитель угловой 90 градусов
            if (positionDop1 == 5) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaSoedAdapt));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = (MainActivity.prices.soed90naIntel * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                    return;
                }
            }

            //Профиль расширительный
            if (positionDop1 == 6) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfRashIntel));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //100 мм
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.profRashNaIntel100mm * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //60 мм
                    else if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.profRashNaIntel60mm * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }

                    //45 мм
                    else if (positionHightDop1 == 2) {
                        dopPrice = (MainActivity.prices.profRashNaIntel45mm * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //20 мм
                    else if (positionHightDop1 == 3) {
                        dopPrice = (MainActivity.prices.profRashNaIntel20mm * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Брус деревянный
            if (positionDop1 == 7) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaBrus));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;
                    //50*50
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.derBrus50 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //100*100
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }

            }

            //Нащельник ПВХ
            if (positionDop1 == 8) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaNash));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;
                    dopPrice = (MainActivity.prices.nashPvh * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                    return;
                }
            }
        }

//--------------------------------АЛЮМИНИЙ----------------------------------------------------------
        //Если Алюминий
        else if(positionProfile1 == 2) {

            adapterDop.clear();
            adapterDop.addAll(addList(R.array.dtaDopAlumin));

            //Подоконник
            if (positionDop1 == 0) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Hight_pod));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaLamDop));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //Белый
                    if (positionLamination1 == 0) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODSTNDRT) + MainActivity.prices.ZAGLSTNDRT;
                        return;
                    }
                    //Ламинированный / Кристалит
                    if (positionLamination1 == 1) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODLAM) + MainActivity.prices.ZAGLSTNDRTCOLOR;
                        return;
                    }
                    //Подоконник Crystallit
                    if (positionLamination1 == 2) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODCRYSTALLIT) + MainActivity.prices.ZAGLCRYSTALLIT;
                        return;
                    }
                    //Подоконник Danke KOFMORT
                    if (positionLamination1 == 3) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKEKOMFORT) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник Danke STANDART
                    if (positionLamination1 == 4) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKESTANDART) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник Danke PREMIUM
                    if (positionLamination1 == 5) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKEPREMIUM) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник ESTERA
                    if (positionLamination1 == 6) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODESTERA) + MainActivity.prices.ZAGLESTERA;
                        return;
                    }
                }

            }

            //Отливы
            if (positionDop1 == 1) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Hight_Otl));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaColorDop));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //Белые/ Коричневые
                    if (positionLamination1 == 0) {
                        dopPrice = (priceOtl1[positionHightDop1] * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) + 1;
                        return;
                    }
                    //Крашенный
                    if (positionLamination1 == 1) {
                        dopPrice = ((Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000) * 20) + (priceOtl1[positionHightDop1] * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) + 4;
                        return;
                    }
                }
            }

            //МС
            if (positionDop1 == 2) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Width_pod_Otl));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msAlumin;
                    return;
                }
            }

            //Двутавр
            if (positionDop1 == 3) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dta1m));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = (MainActivity.prices.dvutavr * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                    return;
                }
            }

            //Соединитель труба с адаптером
            if (positionDop1 == 4) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dta1m));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = (MainActivity.prices.soedTrubaNaAlumin * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                    return;
                }
            }

            //Соединитель угловой 90 градусов
            if (positionDop1 == 5) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dta1m));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = (MainActivity.prices.soed90NaAlumin * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                    return;
                }
            }

            //Профиль расширительный 60 профиль
            if (positionDop1 == 6) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfRashAl));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //60 мм
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.profRashNaAlumin60mm * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //40 мм
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.profRashNaAlumin40mm * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Брус деревянный
            if (positionDop1 == 7) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaBrus));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;
                    //50*50
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.derBrus50 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //100*100
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }

            }

            //Нащельник ПВХ
            if (positionDop1 == 8) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaNash));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;
                    dopPrice = (MainActivity.prices.nashPvh * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                    return;
                }
            }
        }

//--------------------------------PROPLEX----------------------------------------------------------
        //Если PROPLEX
        else if(positionProfile1 == 3) {

            adapterDop.clear();
            adapterDop.addAll(addList(R.array.dtaDopProplex));

            //Подоконник
            if (positionDop1 == 0) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Hight_pod));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaLamDop));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //Белый
                    if (positionLamination1 == 0) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODSTNDRT) + MainActivity.prices.ZAGLSTNDRT;
                        return;
                    }
                    //Ламинированный / Кристалит
                    if (positionLamination1 == 1) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODLAM) + MainActivity.prices.ZAGLSTNDRTCOLOR;
                        return;
                    }
                    //Подоконник Crystallit
                    if (positionLamination1 == 2) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODCRYSTALLIT) + MainActivity.prices.ZAGLCRYSTALLIT;
                        return;
                    }
                    //Подоконник Danke KOFMORT
                    if (positionLamination1 == 3) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKEKOMFORT) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник Danke STANDART
                    if (positionLamination1 == 4) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKESTANDART) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник Danke PREMIUM
                    if (positionLamination1 == 5) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODDANKEPREMIUM) + MainActivity.prices.ZAGLDANKE;
                        return;
                    }
                    //Подоконник ESTERA
                    if (positionLamination1 == 6) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODESTERA) + MainActivity.prices.ZAGLESTERA;
                        return;
                    }
                }

            }

            //Отливы
            if (positionDop1 == 1) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Hight_Otl));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaColorDop));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //Белые/ Коричневые
                    if (positionLamination1 == 0) {
                        dopPrice = (priceOtl1[positionHightDop1] * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) + 1;
                        return;
                    }
                    //Крашенный
                    if (positionLamination1 == 1) {
                        dopPrice = (((Double.valueOf(dataHightDop.get(positionHightDop1)) + 55) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000) * 20) + (priceOtl1[positionHightDop1] * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) + 4;
                        return;
                    }
                }
            }

            //МС
            if (positionDop1 == 2) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.Width_pod_Otl));
                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaMs));
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //м/сетка внутр. белая
                    if (positionLamination1 == 0) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msBelVnut;
                        return;
                    }
                    //м/сетка внутр. корич
                    if (positionLamination1 == 1) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msKorichVnut;
                        return;
                    }
                    //м/сетка наруж. белая
                    if (positionLamination1 == 2) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msBelNar;
                        return;
                    }
                    //м/сетка наруж. корич
                    if (positionLamination1 == 3) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msKorichNar;
                        return;
                    }
                    //м/сетка на алюмин. раму
                    if (positionLamination1 == 4) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msAlumin;
                        return;
                    }
                    //м/сетка на двери бел.
                    if (positionLamination1 == 5) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msBelDver;
                        return;
                    }
                    //м/сетка на двери кор.
                    if (positionLamination1 == 6) {
                        dopPrice = ((Double.valueOf(dataWidthPodOtl.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000)) * MainActivity.prices.msKorichDver;
                        return;
                    }
                }
            }

            //Балконный соединитель 3мм
            if (positionDop1 == 3) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfileProplexMM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //58 профиль
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.balSoed3mmNa58ProfileProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //70 профиль
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.balSoed3mmNa70ProfileProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Соединитель труба с адаптером
            if (positionDop1 == 4) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaPipeProplexMM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //58 мм
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.soedTruba58mmProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //70 мм
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.soedTruba70mmProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Соединитель угловой 90 градусов
            if (positionDop1 == 5) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfileProplexMM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //58 профиль
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.soed90na58ProfileProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //70 профиль
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.soed90na70ProfileProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Соединитель (кость) с армированием
            if (positionDop1 == 6) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfileProplexMM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;
                    //58 профиль
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.soedKostNA58ProfileProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //70 профиль
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.soedKostNA70ProfileProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Профиль расширительный 58 профиль
            if (positionDop1 == 7) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfRash58MM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //60 мм
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.profRashNa58Profile60mmProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //45 мм
                    else if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.profRashNa58Profile45mmProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Профиль расширительный 70 профиль
            if (positionDop1 == 8) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaProfRash70ProplexMM));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //60 мм
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.profRashNa70Profile60mmProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //35 мм
                    else if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.profRashNa70Profile35mmProplex * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }
            }

            //Брус деревянный
            if (positionDop1 == 9) {
                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaBrus));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;
                    //50*50
                    if (positionHightDop1 == 0) {
                        dopPrice = (MainActivity.prices.derBrus50 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //100*100
                    if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }

            }

            //Нащельник ПВХ
            if (positionDop1 == 10) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaNash));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;
                    dopPrice = (MainActivity.prices.nashPvh * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                    return;
                }
            }
        }
    }

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

}