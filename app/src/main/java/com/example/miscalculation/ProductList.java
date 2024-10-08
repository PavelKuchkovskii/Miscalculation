package com.example.miscalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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
    static double Course = 0.0;

    static ArrayAdapter<String> adapterProdLst;
    static ArrayAdapter<String> adapterCourse;
    static ArrayAdapter<String> adapterPlus;
    static ArrayAdapter<String> adapterDiscont;
    static ArrayAdapter<String> adapterBlock;

    static List<String> prodList = new ArrayList<>();
    static List<Double> prodItemPrice = new ArrayList<>();
    static List<Integer> prodInterest = new ArrayList<>();
    static List<String> CourseAmount = new ArrayList<>();
    static List<String> plusDif = new ArrayList<>();
    static List<Integer> prodMounting = new ArrayList<>();
    static List<Integer> prodSlopes = new ArrayList<>();

    static String[] block = {"***********БАЛКОННЫЙ БЛОК***********",
            "***********БАЛК.РАМА(ИЗ НЕСК. ЧАСТЕЙ)***********", "***********ПОЛУКРУГЛАЯ РАМА***********", "***********КОНЕЦ***********"};

    static TextView textMounting;
    static TextView textSlopes;
    static TextView textInterest;
    static TextView textDelivery;
    static TextView textOther;
    static TextView textPlus;
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
    static int delivery = 0;
    static int other = 0;
    static int plus = 0;
    static double priceOutcome = 0;
    static double delivKM = 0;
    static int discontAm = 0;

    static int positionPlus = 0;

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
        textDelivery.setVisibility(View.VISIBLE);
        textOther = findViewById(R.id.txtOther);
        textPlus = findViewById(R.id.txtPlus);
        textDelivKM = findViewById(R.id.txtDelivKM);
        itemSum = findViewById(R.id.SumItem);

        textRegion = findViewById(R.id.txtRegion);
        textRegion.setVisibility(View.INVISIBLE);

        textMounting.setText(mounting + ".00");
        textMounting.setVisibility(View.INVISIBLE);
        textSlopes.setText(slopes + ".00");
        textSlopes.setVisibility(View.INVISIBLE);
        textInterest.setText(interest + ".00");
        textInterest.setVisibility(View.INVISIBLE);
        textDelivery.setText(delivery + ".00");
        textOther.setText(other + ".00");
        textPlus.setText(plus + ".00");
        textDelivKM.setText(String.format("%.2f", delivKM));
        itemSum.setText("∑ = " + String.format("%.2f", priceOutcome));
        itemSum.setVisibility(View.INVISIBLE);

        CourseAmount = Arrays.asList(getResources().getStringArray(R.array.CourseAm));
        plusDif = Arrays.asList(getResources().getStringArray(R.array.plusDif));

        productList = findViewById(R.id.listProduct);

        final EditText editTextDelivery = findViewById(R.id.editTextDelivery);
        editTextDelivery.setVisibility(View.VISIBLE);
        final EditText editTextOther = findViewById(R.id.editTextOther);
        final EditText editTextPlus = findViewById(R.id.editTextPlus);
        final EditText editTextDelivKM = findViewById(R.id.editTextDelivKM);
        
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

        adapterPlus = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, plusDif);
        adapterPlus.setDropDownViewResource(R.layout.listspinner_item);

        adapterDiscont = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, discont);
        adapterDiscont.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterBlock = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, block);
        adapterBlock.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinnerCourse = findViewById(R.id.spinner_course);
        spinnerCourse.setVisibility(View.INVISIBLE);
        final Spinner spinnerDiscont = findViewById(R.id.spinner_discont);
        final Spinner spinnerPlus = findViewById(R.id.spinner_plus);

        productList.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                builder = new AlertDialog.Builder(ProductList.this);
                builder.setTitle("Удалить?");
                builder.setMessage(MainActivity.hashMap.get(MainActivity.nameMeasure).getItemInfo(position));
                builder.setIcon(R.drawable.trash);

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

                            //Удаление из пакетов
                            //Делаем проверку является ли текущий замер пакетом
                            if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.removeItem(position);
                            }


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
        //заголовок
        spinnerCourse.setPrompt("Курс");
        //выделяем элемент
        //Если замер не выбран, то позиция ставится на 0(2.55)
        spinnerCourse.setSelection(MainActivity.nameMeasure != null ? getCourse(MainActivity.hashMap.get(MainActivity.nameMeasure).getCourse(), adapterCourse) : 0);
        //устанавливаем обработчик нажатия
        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionCourse, long idCourse) {

                Course = Double.parseDouble(CourseAmount.get(positionCourse));
                //Если замер выбран
                if (MainActivity.nameMeasure != null) {
                    MainActivity.hashMap.get(MainActivity.nameMeasure).setCourse(Course);
                }
                setProdLstPriceOutcome ();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;

//---------------------------------------------------------------------------------------
        spinnerPlus.setAdapter(adapterPlus);
        //заголовок
        spinnerPlus.setPrompt("Плюс");
        //выделяем элемент
        spinnerPlus.setSelection(0);
        //устанавливаем обработчик нажатия
        spinnerPlus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int positionPlus1, long idCourse) {
                positionPlus = positionPlus1;

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
                if(MainActivity.isManager) {
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

                    spinnerCourse.setVisibility(View.VISIBLE);

                    editTextDelivery.setVisibility(View.VISIBLE);
                    textDelivery.setVisibility(View.VISIBLE);

                    textRegion.setVisibility(View.VISIBLE);
                }
                if(MainActivity.hashMap.get(MainActivity.nameMeasure) != null) {
                    setTextRegion();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        }) ;
//---------------------------------------------------------------------------------------------
        editTextDelivery.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {
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
                    return true;
                }
                return false;
            }
        }
        );
//---------------------------------------------------------------------------------------------
        editTextOther.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {

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
                    return true;
                }
                return false;
            }
        }
        );
//---------------------------------------------------------------------------------------------
        editTextPlus.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    if(editTextPlus.getText().toString().equals("")) {
                        hideKeyboard(ProductList.this);
                    }
                    else {
                        plus = Integer.parseInt(editTextPlus.getText().toString());

                        //Если это НАЛИЧКА
                        if(positionPlus == 0) {

                            int continePriceZh = (int) Math.ceil(((mounting + slopes + interest + Math.ceil(priceOutcome) + delivery + other) * Course) * MainActivity.prices.CALCPERC);

                            int max = (int) ((continePriceZh * 1.10) - continePriceZh);

                            max = (int) Math.ceil(max/Course);

                            if(plus > max) {
                                plus = max;
                            }

                            Toast.makeText(getApplicationContext(), "Максимальный размер плюса: " + max, Toast.LENGTH_SHORT).show();

                        }

                        //Если это БАНК
                        else {

                            if(plus > 200) {
                                plus = 200;
                            }

                            Toast.makeText(getApplicationContext(), "Максимальный размер плюса: " + 200, Toast.LENGTH_SHORT).show();
                        }


                        textPlus.setText(plus + ".00");
                        editTextPlus.getText().clear();

                        MainActivity.hashMap.get(MainActivity.nameMeasure).setPlus(plus);
                        try {
                            writeHash(MainActivity.hashMap);
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                        setProdLstPriceOutcome();
                        hideKeyboard(ProductList.this);
                    }
                    return true;
                }
                return false;
            }
        }
        );
        editTextDelivKM.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    if (editTextDelivKM.getText().toString().equals("")) {

                    }
                    // сохраняем текст, введённый до нажатия Enter в переменную
                    else {
                        delivKM = Math.ceil(((((Double.valueOf(editTextDelivKM.getText().toString()) * 0.1) * MainActivity.prices.fuel) * 4) /
                                MainActivity.hashMap.get(MainActivity.nameMeasure).getCourse())  + 20);
                        textDelivKM.setText( String.valueOf(delivKM));
                        editTextDelivKM.getText().clear();
                    }
                    hideKeyboard(ProductList.this);
                    return true;
                }
                return false;
            }
        }
        );
//---------------------------------------------------------------------------------------------

        butClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Очищаем в hashmap
                //Делаем проверку является ли текущий замер пакетом
                if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.clearAll();
                }

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
                    ContinePrice.setContinePrice(prodList,interest,mounting,delivery,other,plus,slopes, Course, Math.ceil(priceOutcome), discontAm);
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

                            //Добавление в пакет, только если активный замер сам не является пакетом
                            if(!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.PROPLEX7032W, String.valueOf(positionBlock1), "", 0.0, 0, 0);
                                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.BB7040W, String.valueOf(positionBlock1), "", 0.0, 0, 0);
                                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAU7040W, String.valueOf(positionBlock1), "", 0.0, 0, 0);
                                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAUINTELIO, String.valueOf(positionBlock1), "", 0.0, 0, 0);
                            }
                            MainActivity.hashMap.get(MainActivity.nameMeasure).setProdList(String.valueOf(positionBlock1), "", 0.0, 0, 0);
                            addProdLst(String.valueOf(positionBlock1), 0.0, 0, 0, 0);


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
                    //Добавление в пакет, только если активный замер сам не является пакетом
                    if(!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                        MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.PROPLEX7032W, String.valueOf(3), "", 0.0, 0, 0);
                        MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.BB7040W, String.valueOf(3), "", 0.0, 0, 0);
                        MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAU7040W, String.valueOf(3), "", 0.0, 0, 0);
                        MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.addToPocket(MainActivity.prices.REHAUINTELIO, String.valueOf(3), "", 0.0, 0, 0);
                    }
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

        //Если добавление в конец
        if (!addFromList) {
            prodItemPrice.add(priceItem);
            prodInterest.add(interest1);

            if (prodLst.equals("0")) {

                adapterProdLst.add(block[0]);

            } else if (prodLst.equals("1")) {

                adapterProdLst.add(block[1]);

            } else if (prodLst.equals("2")) {

                adapterProdLst.add(block[2]);

            } else if (prodLst.equals("3")) {

                adapterProdLst.add(block[3]);

            }
            else {

             //Если менеджер и не работа
             if (MainActivity.isManager && mounting1 == 0 && slopes1 == 0) {
                 adapterProdLst.add(prodLst + ": " + priceItem);
             }
             //Если не менеджер или работа
             else {
                 adapterProdLst.add(prodLst);
             }

            }
        }

        //Если добавление в блок
        else {
            addFromList = false;
            prodItemPrice.add(indexOfAddToBlock, priceItem);
            prodInterest.add(indexOfAddToBlock, interest1);

            //Если менеджер
            if (MainActivity.isManager) {
                prodList.add(indexOfAddToBlock, prodLst + ": " + priceItem);
                adapterProdLst.notifyDataSetInvalidated();
            }
            //Если не менеджер
            else {
                prodList.add(indexOfAddToBlock, prodLst);
                adapterProdLst.notifyDataSetInvalidated();
            }
        }

        //Если не монтаж и не откосы
        if (mounting1 == 0 && slopes1 == 0) {
            priceOutcome = priceOutcome + priceItem;
            interest = interest + interest1;
        }
        //Если сонтаж или откосы
        else {
            //Если монтаж
            if (mounting1 != 0) {
                mounting = mounting + mounting1;
            }
            //Если откосы
            else {
                slopes = slopes + slopes1;
            }
        }

        prodMounting.add(mounting1);
        prodSlopes.add(slopes1);
        textInterest.setText(interest + ".00");
        textMounting.setText(mounting + ".00");
        textSlopes.setText(slopes + ".00");
        setProdLstPriceOutcome ();
    }


    //Вызывается из Класса замера при открытии сохраненного замера
    public static void addProdLst(int delivery1, int other1, int plus1) {
        delivery = delivery1;
        other = other1;
        plus = plus1;
        textDelivery.setText(delivery + ".00");
        textOther.setText(other + ".00");
        textPlus.setText(plus + ".00");
    }

    public static void setProdLstPriceOutcome (){
        itemSum.setText("∑ = " + String.format("%.2f", Math.ceil(priceOutcome)) );
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
        delivery = MainActivity.prices.delivery;
        other = 0;
        plus = 0;
        textDelivery.setText(delivery + ".00");
        textOther.setText(other + ".00");
        textPlus.setText(plus + ".00");
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
            if (s.equals("***********БАЛКОННЫЙ БЛОК***********")) {
                //Индекс конца балконного блока
                int b = 0;

                //Если нашли Балконный блок ищем его конец
                for (String s1 : prodList) {

                    //Если нашли Конец балконного блока
                    if (s1.equals("***********КОНЕЦ***********")) {



                        if(i < b) {
                            int countWindows = 0;

                            //Заменяем интерес во всех элементах на 0
                            for (int y = i + 1; y < b; y++) {
                                if(prodList.get(y).contains("створ.")) {
                                    countWindows++;
                                }
                                prodInterest.set(y, 0);
                                MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(y, 0);

                                //Добавление в пакеты
                                //Делаем проверку является ли текущий замер пакетом
                                if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.setInterest(y, 0);
                                }
                            }
                            //Только если между началом блока и концом есть элементы
                            if(b - i > 1) {
                                //Присваиваем интерес 65 элементу предшествующему концу блока, если больше 1 окна(Чебурашка)
                                if(countWindows > 1) {
                                    prodInterest.set(b - 1, MainActivity.prices.INTBALBLOCK2);
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, MainActivity.prices.INTBALBLOCK2);

                                    //Добавление в пакеты
                                    //Делаем проверку является ли текущий замер пакетом
                                    if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                        MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.setInterest(b - 1, MainActivity.prices.INTBALBLOCK2);
                                    }
                                }
                                //Присваиваем интерес 55 элементу предшествующему концу блока, если 1 окно
                                else {
                                    prodInterest.set(b - 1, MainActivity.prices.INTBALBLOCK);
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, MainActivity.prices.INTBALBLOCK);

                                    //Добавление в пакеты
                                    //Делаем проверку является ли текущий замер пакетом
                                    if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                        MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.setInterest(b - 1, MainActivity.prices.INTBALBLOCK);
                                    }
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
            if(s.equals("***********ПОЛУКРУГЛАЯ РАМА***********")) {
                int b = 0;

                //Если нашли Балконный блок ищем его конец
                for (String s1 : prodList) {

                    //Если нашли Конец балконного блока
                    if (s1.equals("***********КОНЕЦ***********")) {

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

                                //Добавление в пакеты
                                //Делаем проверку является ли текущий замер пакетом
                                if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.setInterest(y, 0);
                                }
                            }
                            //Присваиваем интерес 20 * на количество створок элементу предшествующему концу блока
                            prodInterest.set(b - 1, countWindows * MainActivity.prices.INTPOLRAM);
                            MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, countWindows * MainActivity.prices.INTPOLRAM);

                            //Добавление в пакеты
                            //Делаем проверку является ли текущий замер пакетом
                            if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.setInterest(b - 1, countWindows * MainActivity.prices.INTPOLRAM);
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

    public void filterInterestSostRam() {

        //Общая ширина
        int width = 0;

        //Перебираем Лист изделий
        for(int i = 0;i < prodList.size();i++) {

            //Если найдена составная рама
            if(prodList.get(i).equals("***********БАЛК.РАМА(ИЗ НЕСК. ЧАСТЕЙ)***********")) {

                //Переибираем лист в поиске конца
                for(int b = i;b < prodList.size();b++) {

                    if(prodList.get(b).contains("створ.")) {
                        width = width + MainActivity.hashMap.get(MainActivity.nameMeasure).getProdWidth(b);
                    }

                    //Когда нашли конец
                    else if(prodList.get(b).equals("***********КОНЕЦ***********")) {

                        //Заменяем интерес всех элементов составной рамы на 0
                        for (int b2 = i + 1;b2 < b - 1;b2++) {
                            prodInterest.set(b2, 0);
                            MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b2, 0);

                            //Добавление в пакеты
                            //Делаем проверку является ли текущий замер пакетом
                            if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.setInterest(b2, 0);
                            }
                        }
                        //Если ширин меньше 5000
                        if (width < 5000) {
                            //Если ширина меньше 4000
                            if (width < 4000) {
                                //Если ширина меньше 3300
                                if (width < 3300) {
                                    prodInterest.set(b - 1, MainActivity.prices.INTW4ST);
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, MainActivity.prices.INTW4ST);

                                    //Добавление в пакеты
                                    //Делаем проверку является ли текущий замер пакетом
                                    if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                        MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.setInterest(b - 1, MainActivity.prices.INTW4ST);
                                    }
                                }
                                //Если ширина 3300-4000
                                else {
                                    prodInterest.set(b - 1, MainActivity.prices.INTW4STV3);
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, MainActivity.prices.INTW4STV3);

                                    //Добавление в пакеты
                                    //Делаем проверку является ли текущий замер пакетом
                                    if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                        MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.setInterest(b - 1, MainActivity.prices.INTW4STV3);
                                    }
                                }
                            }
                            //если ширина 4000-5000
                            else {
                                prodInterest.set(b - 1, MainActivity.prices.INTW4STV4);
                                MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, MainActivity.prices.INTW4STV4);

                                //Добавление в пакеты
                                //Делаем проверку является ли текущий замер пакетом
                                if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                    MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.setInterest(b - 1, MainActivity.prices.INTW4STV4);
                                }
                            }
                        }
                        //Если ширина больше 5000
                        else {
                            prodInterest.set(b - 1, MainActivity.prices.INTW4STV5);
                            MainActivity.hashMap.get(MainActivity.nameMeasure).setInterest(b - 1, MainActivity.prices.INTW4STV5);

                            //Добавление в пакеты
                            //Делаем проверку является ли текущий замер пакетом
                            if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.setInterest(b - 1, MainActivity.prices.INTW4STV5);
                            }
                        }
                        break;
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
            //Ищем закрытие блока
            else if(s.equals("***********КОНЕЦ***********")) {
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

        //Если это не последний элемент спсика
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
            //Удаление из пакетов
            //Делаем проверку является ли текущий замер пакетом
            if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
                MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.removeItem(start);
            }

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
    //Показывает выбранный регион
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

    //Устанавливает курс
    public int getCourse(double d, ArrayAdapter<String> courseAmount) {
        return courseAmount.getPosition(String.valueOf(d));
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