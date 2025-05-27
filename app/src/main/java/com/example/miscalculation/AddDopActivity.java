package com.example.miscalculation;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import android.widget.TextView;

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
    static Spinner spinnerHightDop = null;
    static Spinner spinnerWidthDop = null;

    static TextView textHight;
    static TextView textWidth;
    static TextView textXWork;

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


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddop);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Intent prodListBut = new Intent(AddDopActivity.this, ProductList.class);

        dataWidthPodOtl = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.Width_pod_Otl)));
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

        spinnerHightDop = findViewById(R.id.spinner_hightDop);

        spinnerWidthDop = findViewById(R.id.spinner_widthDop);

        final Spinner spinnerProfile = findViewById(R.id.spinner_profile);

        textHight = findViewById(R.id.textHigh);
        textWidth = findViewById(R.id.textWidth);
        textXWork = findViewById(R.id.XDown);
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
                String itemName = dataDop.get(positionDop1) + " " + (dataLamination.size() > 0 ? dataLamination.get(positionLamination1) : "") + (!dataDop.get(positionDop1).equals("Клипсы для наличников на 1 изделие") ? " " + dataHightDop.get(positionHightDop1) + " * " + dataWidthPodOtl.get(positionWidthDop1) +
                        (positionDop1 != 0 && positionDop1 != 1 && positionDop1 != 2 && positionDop1 != dataDop.size() - 1 && positionDop1 != dataDop.size() - 2 ?
                                "\nДля: " + dataProfile[positionProfile1] : "") : "");


                String itemInfo = "";

                //Добавление в пакет, только если активный замер сам не является пакетом
                if(!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.PROPLEX7032W, itemName, itemInfo, Double.valueOf(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, Integer.parseInt(dataWidthPodOtl.get(positionWidthDop1) instanceof String ? "0" : dataWidthPodOtl.get(positionWidthDop1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.BB7040W, itemName, itemInfo, Double.valueOf(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, Integer.parseInt(dataWidthPodOtl.get(positionWidthDop1) instanceof String ? "0" : dataWidthPodOtl.get(positionWidthDop1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAU7040W, itemName, itemInfo, Double.valueOf(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, Integer.parseInt(dataWidthPodOtl.get(positionWidthDop1) instanceof String ? "0" : dataWidthPodOtl.get(positionWidthDop1)));
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAUINTELIO, itemName, itemInfo, Double.valueOf(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, Integer.parseInt(dataWidthPodOtl.get(positionWidthDop1) instanceof String ? "0" : dataWidthPodOtl.get(positionWidthDop1)));
                }
                ProductList.addProdLst(itemName, Double.parseDouble(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, 0, 0);
                MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(itemName, itemInfo, Double.valueOf(String.format(Locale.ROOT, "%.2f", dopPrice)), 0, Integer.parseInt(dataWidthPodOtl.get(positionWidthDop1) instanceof String ? "0" : dataWidthPodOtl.get(positionWidthDop1)));

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
            adapterLamination.clear();
            spinnerLamination.setVisibility(View.VISIBLE);
            spinnerHightDop.setVisibility(View.VISIBLE);
            spinnerWidthDop.setVisibility(View.VISIBLE);
            textHight.setVisibility(View.VISIBLE);
            textWidth.setVisibility(View.VISIBLE);
            textXWork.setVisibility(View.VISIBLE);
            adapterWidthDop.clear();
            adapterWidthDop.addAll(addList(R.array.Width_pod_Otl));
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
                    //Клинтач (Минск)
                    if (positionLamination1 == 7) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODCLEANTOUCH) + MainActivity.prices.ZAGCLEANTOUCH;
                        return;
                    }
                }

            }

            //Отливы
            else if (positionDop1 == 1) {
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
            else if (positionDop1 == 2) {
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
            else if (positionDop1 == 3) {

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
            else if (positionDop1 == 4) {
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
            else if (positionDop1 == 5) {
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
            else if (positionDop1 == 6) {
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
            else if (positionDop1 == 7) {
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
            else if (positionDop1 == 8) {
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
            else if (positionDop1 == 9) {
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
                    else if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }

                    //100*50
                    else if (positionHightDop1 == 2) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }

            }

            //Нащельник ПВХ
            else if (positionDop1 == 10) {

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

            //Наличник дверной дверной
            else if (positionDop1 == 11) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaNalich));
                    adapterWidthDop.clear();
                    adapterWidthDop.addAll(addList(R.array.dtaNalichLam));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //55 мм
                    if(positionHightDop1 == 0) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich55;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich55lam;
                        }
                    }
                    //75 мм
                    else if(positionHightDop1 == 1) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich75;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich75lam;
                        }
                    }
                    //95 мм
                    else if(positionHightDop1 == 2) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich95;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich95lam;
                        }
                    }
                }
            }

            //Клипсы для наличника
            else if (positionDop1 == 12) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.nalichClips;
                }
            }

            //Срезать перила, решётку
            else if (positionDop1 == 13) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice1 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Корректировка проёма без сложности (дерево, блок)
            else if (positionDop1 == 14) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice2 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Сбить порог б\б (крипич)
            else if (positionDop1 == 15) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice3;
                }
            } //NOT

            //Каркас из бруса
            else if (positionDop1 == 16) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaBrus));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    if(positionLamination1 == 0) {
                        dopPrice = MainActivity.prices.dopPrice4_1;
                    }
                    else if(positionLamination1 == 1) {
                        dopPrice = MainActivity.prices.dopPrice4_2;
                    }
                    else if(positionLamination1 == 2) {
                        dopPrice = MainActivity.prices.dopPrice4_3;
                    }

                    //dopPrice = MainActivity.prices.nalichClips;
                }
            } //КОЛИЧЕСТВО

            //Пропил и укрепление проема в деревянном доме
            else if (positionDop1 == 17) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaKind1));
                    spinnerHightDop.setVisibility(View.VISIBLE);

                    adapterWidthDop.clear();
                    adapterWidthDop.addAll(addList(R.array.dtaCount));
                    spinnerWidthDop.setVisibility(View.VISIBLE);


                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    if(positionHightDop1 == 0) {
                        dopPrice = MainActivity.prices.dopPrice5_1 * (positionLamination1 + 1);
                    }
                    else if(positionHightDop1 == 1) {
                        dopPrice = MainActivity.prices.dopPrice5_2 * (positionLamination1 + 1);
                    }
                }
            } //ВИД МП

            //Демонтаж с сохранением
            else if (positionDop1 == 18) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice6 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка добора на раму
            else if (positionDop1 == 19) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice7 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка статики, соединителя
            else if (positionDop1 == 20) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice8 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Укрепление подоконника уголками на балконных рамах (под. не более 200мм)
            else if (positionDop1 == 21) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice9 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Подъем на веревках
            else if (positionDop1 == 22) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaFloor));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice10 * (positionLamination1 + 1);
                }
            } //ЭТАЖ

            //Подъем без лифта (начиная с 3-го этажа)
            else if (positionDop1 == 23) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaFloor));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice11 * (positionLamination1 + 1);
                }
            } //ЭТАЖ

            //Сбить откосы
            else if (positionDop1 == 24) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice12 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Срезать шип
            else if (positionDop1 == 25) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice13 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Эркерные окна, рамы, которые состоят из нескольких частей и соед. через трубы
            else if (positionDop1 == 26) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice14 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Ленты
            else if (positionDop1 == 27) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice15 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка обналички на клипсы
            else if (positionDop1 == 28) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice16 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Регулировка створки
            else if (positionDop1 == 29) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice17 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Дополнительное запенивание
            else if (positionDop1 == 30) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice18 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка отливов
            else if (positionDop1 == 31) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice19 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка подоконников
            else if (positionDop1 == 32) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice20 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Замена стеклопакетов
            else if (positionDop1 == 33) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice21 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка дополнительной м\с
            else if (positionDop1 == 34) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice22 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка детского замкаКОЛИЧЕСТВО
            else if (positionDop1 == 35) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice23 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

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
                    //Клинтач (Минск)
                    if (positionLamination1 == 7) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODCLEANTOUCH) + MainActivity.prices.ZAGCLEANTOUCH;
                        return;
                    }
                }

            }

            //Отливы
            else if (positionDop1 == 1) {
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
            else if (positionDop1 == 2) {
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
            else if (positionDop1 == 3) {

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
            else if (positionDop1 == 4) {
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
            else if (positionDop1 == 5) {
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
            else if (positionDop1 == 6) {
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
            else if (positionDop1 == 7) {
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
                    else if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //100*50
                    else if (positionHightDop1 == 2) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }

            }

            //Нащельник ПВХ
            else if (positionDop1 == 8) {

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

            //Наличник дверной дверной
            else if (positionDop1 == 9) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaNalich));
                    adapterWidthDop.clear();
                    adapterWidthDop.addAll(addList(R.array.dtaNalichLam));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //55 мм
                    if(positionHightDop1 == 0) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich55;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich55lam;
                        }
                    }
                    //75 мм
                    else if(positionHightDop1 == 1) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich75;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich75lam;
                        }
                    }
                    //95 мм
                    else if(positionHightDop1 == 2) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich95;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich95lam;
                        }
                    }
                }
            }

            //Клипсы для наличника
            else if (positionDop1 == 10) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.nalichClips;
                }
            }

            //Срезать перила, решётку
            else if (positionDop1 == 11) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice1 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Корректировка проёма без сложности (дерево, блок)
            else if (positionDop1 == 12) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice2 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Сбить порог б\б (крипич)
            else if (positionDop1 == 13) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice3;
                }
            } //NOT

            //Каркас из бруса
            else if (positionDop1 == 14) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaBrus));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    if(positionLamination1 == 0) {
                        dopPrice = MainActivity.prices.dopPrice4_1;
                    }
                    else if(positionLamination1 == 1) {
                        dopPrice = MainActivity.prices.dopPrice4_2;
                    }
                    else if(positionLamination1 == 2) {
                        dopPrice = MainActivity.prices.dopPrice4_3;
                    }

                    //dopPrice = MainActivity.prices.nalichClips;
                }
            } //КОЛИЧЕСТВО

            //Пропил и укрепление проема в деревянном доме
            else if (positionDop1 == 15) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaKind1));
                    spinnerHightDop.setVisibility(View.VISIBLE);

                    adapterWidthDop.clear();
                    adapterWidthDop.addAll(addList(R.array.dtaCount));
                    spinnerWidthDop.setVisibility(View.VISIBLE);


                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    if(positionHightDop1 == 0) {
                        dopPrice = MainActivity.prices.dopPrice5_1 * (positionLamination1 + 1);
                    }
                    else if(positionHightDop1 == 1) {
                        dopPrice = MainActivity.prices.dopPrice5_2 * (positionLamination1 + 1);
                    }
                }
            } //ВИД МП

            //Демонтаж с сохранением
            else if (positionDop1 == 16) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice6 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка добора на раму
            else if (positionDop1 == 17) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice7 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка статики, соединителя
            else if (positionDop1 == 18) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice8 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Укрепление подоконника уголками на балконных рамах (под. не более 200мм)
            else if (positionDop1 == 19) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice9 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Подъем на веревках
            else if (positionDop1 == 20) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaFloor));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice10 * (positionLamination1 + 1);
                }
            } //ЭТАЖ

            //Подъем без лифта (начиная с 3-го этажа)
            else if (positionDop1 == 21) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaFloor));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice11 * (positionLamination1 + 1);
                }
            } //ЭТАЖ

            //Сбить откосы
            else if (positionDop1 == 22) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice12 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Срезать шип
            else if (positionDop1 == 23) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice13 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Эркерные окна, рамы, которые состоят из нескольких частей и соед. через трубы
            else if (positionDop1 == 24) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice14 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Ленты
            else if (positionDop1 == 25) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice15 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка обналички на клипсы
            else if (positionDop1 == 26) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice16 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Регулировка створки
            else if (positionDop1 == 27) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice17 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Дополнительное запенивание
            else if (positionDop1 == 28) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice18 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка отливов
            else if (positionDop1 == 29) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice19 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка подоконников
            else if (positionDop1 == 30) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice20 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Замена стеклопакетов
            else if (positionDop1 == 31) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice21 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка дополнительной м\с
            else if (positionDop1 == 32) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice22 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка детского замкаКОЛИЧЕСТВО
            else if (positionDop1 == 33) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice23 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО
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
                    //Клинтач (Минск)
                    if (positionLamination1 == 7) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODCLEANTOUCH) + MainActivity.prices.ZAGCLEANTOUCH;
                        return;
                    }
                }

            }

            //Отливы
            else if (positionDop1 == 1) {
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
            else if (positionDop1 == 2) {
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
            else if (positionDop1 == 3) {

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
            else if (positionDop1 == 4) {
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
            else if (positionDop1 == 5) {
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
            else if (positionDop1 == 6) {
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
            else if (positionDop1 == 7) {
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
                    else if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //100*50
                    else if (positionHightDop1 == 2) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }

            }

            //Нащельник ПВХ
            else if (positionDop1 == 8) {

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
            //Наличник дверной дверной
            else if (positionDop1 == 9) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaNalich));
                    adapterWidthDop.clear();
                    adapterWidthDop.addAll(addList(R.array.dtaNalichLam));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //55 мм
                    if(positionHightDop1 == 0) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich55;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich55lam;
                        }
                    }
                    //75 мм
                    else if(positionHightDop1 == 1) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich75;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich75lam;
                        }
                    }
                    //95 мм
                    else if(positionHightDop1 == 2) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich95;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich95lam;
                        }
                    }
                }
            }

            //Клипсы для наличника
            else if (positionDop1 == 10) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.nalichClips;
                }
            }

            //Срезать перила, решётку
            else if (positionDop1 == 11) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice1 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Корректировка проёма без сложности (дерево, блок)
            else if (positionDop1 == 12) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice2 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Сбить порог б\б (крипич)
            else if (positionDop1 == 13) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice3;
                }
            } //NOT

            //Каркас из бруса
            else if (positionDop1 == 14) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaBrus));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    if(positionLamination1 == 0) {
                        dopPrice = MainActivity.prices.dopPrice4_1;
                    }
                    else if(positionLamination1 == 1) {
                        dopPrice = MainActivity.prices.dopPrice4_2;
                    }
                    else if(positionLamination1 == 2) {
                        dopPrice = MainActivity.prices.dopPrice4_3;
                    }

                    //dopPrice = MainActivity.prices.nalichClips;
                }
            } //КОЛИЧЕСТВО

            //Пропил и укрепление проема в деревянном доме
            else if (positionDop1 == 15) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaKind1));
                    spinnerHightDop.setVisibility(View.VISIBLE);

                    adapterWidthDop.clear();
                    adapterWidthDop.addAll(addList(R.array.dtaCount));
                    spinnerWidthDop.setVisibility(View.VISIBLE);


                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    if(positionHightDop1 == 0) {
                        dopPrice = MainActivity.prices.dopPrice5_1 * (positionLamination1 + 1);
                    }
                    else if(positionHightDop1 == 1) {
                        dopPrice = MainActivity.prices.dopPrice5_2 * (positionLamination1 + 1);
                    }
                }
            } //ВИД МП

            //Демонтаж с сохранением
            else if (positionDop1 == 16) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice6 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка добора на раму
            else if (positionDop1 == 17) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice7 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка статики, соединителя
            else if (positionDop1 == 18) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice8 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Укрепление подоконника уголками на балконных рамах (под. не более 200мм)
            else if (positionDop1 == 19) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice9 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Подъем на веревках
            else if (positionDop1 == 20) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaFloor));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice10 * (positionLamination1 + 1);
                }
            } //ЭТАЖ

            //Подъем без лифта (начиная с 3-го этажа)
            else if (positionDop1 == 21) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaFloor));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice11 * (positionLamination1 + 1);
                }
            } //ЭТАЖ

            //Сбить откосы
            else if (positionDop1 == 22) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice12 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Срезать шип
            else if (positionDop1 == 23) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice13 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Эркерные окна, рамы, которые состоят из нескольких частей и соед. через трубы
            else if (positionDop1 == 24) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice14 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Ленты
            else if (positionDop1 == 25) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice15 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка обналички на клипсы
            else if (positionDop1 == 26) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice16 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Регулировка створки
            else if (positionDop1 == 27) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice17 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Дополнительное запенивание
            else if (positionDop1 == 28) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice18 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка отливов
            else if (positionDop1 == 29) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice19 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка подоконников
            else if (positionDop1 == 30) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice20 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Замена стеклопакетов
            else if (positionDop1 == 31) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice21 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка дополнительной м\с
            else if (positionDop1 == 32) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice22 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка детского замкаКОЛИЧЕСТВО
            else if (positionDop1 == 33) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice23 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО
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
                    //Клинтач (Минск)
                    if (positionLamination1 == 7) {
                        dopPrice = ( (Double.valueOf(dataHightDop.get(positionHightDop1)) / 1000) * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1) ) / 1000) * MainActivity.prices.PODCLEANTOUCH) + MainActivity.prices.ZAGCLEANTOUCH;
                        return;
                    }
                }

            }

            //Отливы
            else if (positionDop1 == 1) {
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
            else if (positionDop1 == 2) {
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
            else if (positionDop1 == 3) {

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
            else if (positionDop1 == 4) {
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
            else if (positionDop1 == 5) {
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
            else if (positionDop1 == 6) {
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
            else if (positionDop1 == 7) {
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
            else if (positionDop1 == 8) {
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
            else if (positionDop1 == 9) {
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
                    else if (positionHightDop1 == 1) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                    //100*50
                    else if (positionHightDop1 == 2) {
                        dopPrice = (MainActivity.prices.derBrus100 * (Double.valueOf(dataWidthPodOtl.get(positionWidthDop1)) / 1000));
                        return;
                    }
                }

            }

            //Нащельник ПВХ
            else if (positionDop1 == 10) {

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
            //Наличник дверной дверной
            else if (positionDop1 == 11) {

                if (dopFlag == true) {
                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaNalich));
                    adapterWidthDop.clear();
                    adapterWidthDop.addAll(addList(R.array.dtaNalichLam));
                    adapterLamination.clear();
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    //55 мм
                    if(positionHightDop1 == 0) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich55;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich55lam;
                        }
                    }
                    //75 мм
                    else if(positionHightDop1 == 1) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich75;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich75lam;
                        }
                    }
                    //95 мм
                    else if(positionHightDop1 == 2) {
                        //Без ламинации
                        if(positionWidthDop1 == 0) {
                            dopPrice = MainActivity.prices.nalich95;
                        }
                        //Ламинированный
                        else {
                            dopPrice = MainActivity.prices.nalich95lam;
                        }
                    }
                }
            }
            //Клипсы для наличника
            else if (positionDop1 == 12) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.nalichClips;
                }
            }

            //Срезать перила, решётку
            else if (positionDop1 == 13) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice1 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Корректировка проёма без сложности (дерево, блок)
            else if (positionDop1 == 14) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice2 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Сбить порог б\б (крипич)
            else if (positionDop1 == 15) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);
                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice3;
                }
            } //NOT

            //Каркас из бруса
            else if (positionDop1 == 16) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaBrus));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    if(positionLamination1 == 0) {
                        dopPrice = MainActivity.prices.dopPrice4_1;
                    }
                    else if(positionLamination1 == 1) {
                        dopPrice = MainActivity.prices.dopPrice4_2;
                    }
                    else if(positionLamination1 == 2) {
                        dopPrice = MainActivity.prices.dopPrice4_3;
                    }

                    //dopPrice = MainActivity.prices.nalichClips;
                }
            } //КОЛИЧЕСТВО

            //Пропил и укрепление проема в деревянном доме
            else if (positionDop1 == 17) {

                if (dopFlag == true) {
                    spinnerLamination.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterHightDop.clear();
                    adapterHightDop.addAll(addList(R.array.dtaKind1));
                    spinnerHightDop.setVisibility(View.VISIBLE);

                    adapterWidthDop.clear();
                    adapterWidthDop.addAll(addList(R.array.dtaCount));
                    spinnerWidthDop.setVisibility(View.VISIBLE);


                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    if(positionHightDop1 == 0) {
                        dopPrice = MainActivity.prices.dopPrice5_1 * (positionLamination1 + 1);
                    }
                    else if(positionHightDop1 == 1) {
                        dopPrice = MainActivity.prices.dopPrice5_2 * (positionLamination1 + 1);
                    }
                }
            } //ВИД МП

            //Демонтаж с сохранением
            else if (positionDop1 == 18) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice6 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка добора на раму
            else if (positionDop1 == 19) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice7 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка статики, соединителя
            else if (positionDop1 == 20) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice8 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Укрепление подоконника уголками на балконных рамах (под. не более 200мм)
            else if (positionDop1 == 21) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice9 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Подъем на веревках
            else if (positionDop1 == 22) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaFloor));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice10 * (positionLamination1 + 1);
                }
            } //ЭТАЖ

            //Подъем без лифта (начиная с 3-го этажа)
            else if (positionDop1 == 23) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaFloor));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice11 * (positionLamination1 + 1);
                }
            } //ЭТАЖ

            //Сбить откосы
            else if (positionDop1 == 24) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice12 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Срезать шип
            else if (positionDop1 == 25) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice13 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Эркерные окна, рамы, которые состоят из нескольких частей и соед. через трубы
            else if (positionDop1 == 26) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice14 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Ленты
            else if (positionDop1 == 27) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice15 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка обналички на клипсы
            else if (positionDop1 == 28) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice16 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Регулировка створки
            else if (positionDop1 == 29) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice17 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Дополнительное запенивание
            else if (positionDop1 == 30) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice18 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка отливов
            else if (positionDop1 == 31) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice19 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка подоконников
            else if (positionDop1 == 32) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice20 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Замена стеклопакетов
            else if (positionDop1 == 33) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice21 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка дополнительной м\с
            else if (positionDop1 == 34) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice22 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО

            //Установка детского замкаКОЛИЧЕСТВО
            else if (positionDop1 == 35) {

                if (dopFlag == true) {
                    spinnerHightDop.setVisibility(View.INVISIBLE);
                    spinnerWidthDop.setVisibility(View.INVISIBLE);
                    textHight.setVisibility(View.INVISIBLE);
                    textWidth.setVisibility(View.INVISIBLE);
                    textXWork.setVisibility(View.INVISIBLE);

                    adapterLamination.clear();
                    adapterLamination.addAll(addList(R.array.dtaCount));
                    spinnerLamination.setVisibility(View.VISIBLE);

                    dopFlag = false;
                    return;
                }
                if (getPrice == true) {
                    getPrice = false;

                    dopPrice = MainActivity.prices.dopPrice23 * (positionLamination1 + 1);
                }
            } //КОЛИЧЕСТВО
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