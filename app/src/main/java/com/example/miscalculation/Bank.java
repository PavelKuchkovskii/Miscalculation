package com.example.miscalculation;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Bank extends AppCompatActivity {


    static double priceLizZh;
    static double priceLizM;
    static double priceLizZhWPrepaid;
    static double priceLizMWPrepaid;
    static int prepaidLizZh;
    static int prepaidLizM;

    static int priceZ;
    static int priceM;

    static int minBank = 50;
    static int minLiz = 600;



    static final String rub = " руб";

    //АЛЬФА-БАНК
    static TextView Ames6Z;
    static TextView Ames12Z;
    static TextView Ames18Z;
    static TextView Ames24Z;
    static TextView Ames36Z;
    static TextView Ames48Z;

    static TextView Ames6M;
    static TextView Ames12M;
    static TextView Ames18M;
    static TextView Ames24M;
    static TextView Ames36M;
    static TextView Ames48M;

    //ЕЖЕМЕСЯЧНЫЕ АЛЬФА
    static TextView Ames6EZ;
    static TextView Ames12EZ;
    static TextView Ames18EZ;
    static TextView Ames24EZ;
    static TextView Ames36EZ;
    static TextView Ames48EZ;

    static TextView Ames6EM;
    static TextView Ames12EM;
    static TextView Ames18EM;
    static TextView Ames24EM;
    static TextView Ames36EM;
    static TextView Ames48EM;

    //АЛЬФА-БАНК ПЛЮС
    static TextView APlusmes3Z;
    static TextView APlusmes6Z;
    static TextView APlusmes10Z;
    static TextView APlusmes12Z;
    static TextView APlusmes15Z;
    static TextView APlusmes18Z;
    static TextView APlusmes24Z;
    static TextView APlusmes36Z;
    static TextView APlusmes48Z;

    static TextView APlusmes3M;
    static TextView APlusmes6M;
    static TextView APlusmes10M;
    static TextView APlusmes12M;
    static TextView APlusmes15M;
    static TextView APlusmes18M;
    static TextView APlusmes24M;
    static TextView APlusmes36M;
    static TextView APlusmes48M;

    //ЕЖЕМЕСЯЧНЫЕ АЛЬФА
    static TextView APlusmes3EZ;
    static TextView APlusmes6EZ;
    static TextView APlusmes10EZ;
    static TextView APlusmes12EZ;
    static TextView APlusmes15EZ;
    static TextView APlusmes18EZ;
    static TextView APlusmes24EZ;
    static TextView APlusmes36EZ;
    static TextView APlusmes48EZ;

    static TextView APlusmes3EM;
    static TextView APlusmes6EM;
    static TextView APlusmes10EM;
    static TextView APlusmes12EM;
    static TextView APlusmes15EM;
    static TextView APlusmes18EM;
    static TextView APlusmes24EM;
    static TextView APlusmes36EM;
    static TextView APlusmes48EM;


    //АЛЬФА-БАНК РАССРОЧКА
    static TextView ARasrochMes5Z;
    static TextView ARasrochMes6Z;

    static TextView ARasrochMes5M;
    static TextView ARasrochMes6M;

    //ЕЖЕМЕСЯЧНЫЕ АЛЬФА
    static TextView ARasrochMes5EZ;
    static TextView ARasrochMes6EZ;

    static TextView ARasrochMes5EM;
    static TextView ARasrochMes6EM;

    //СКРЕПКА-ДОБРОБЫТ
    static TextView SCDmes6Z;
    static TextView SCDmes12Z;
    static TextView SCDmes18Z;
    static TextView SCDmes24Z;
    static TextView SCDmes36Z;

    static TextView SCDmes6M;
    static TextView SCDmes12M;
    static TextView SCDmes18M;
    static TextView SCDmes24M;
    static TextView SCDmes36M;

    //ЕЖЕМЕСЯЧНЫЕ СКРЕПКА-ДОБРОБЫТ
    static TextView SCDmes6EZ;
    static TextView SCDmes12EZ;
    static TextView SCDmes18EZ;
    static TextView SCDmes24EZ;
    static TextView SCDmes36EZ;

    static TextView SCDmes6EM;
    static TextView SCDmes12EM;
    static TextView SCDmes18EM;
    static TextView SCDmes24EM;
    static TextView SCDmes36EM;

    //СКРЕПКА-ПАРИТЕТ
    static TextView SCPmes6Z;
    static TextView SCPmes12Z;
    static TextView SCPmes18Z;
    static TextView SCPmes24Z;
    static TextView SCPmes36Z;
    static TextView SCPmes60Z;

    static TextView SCPmes6M;
    static TextView SCPmes12M;
    static TextView SCPmes18M;
    static TextView SCPmes24M;
    static TextView SCPmes36M;
    static TextView SCPmes60M;

    //ЕЖЕМЕСЯЧНЫЕ СКРЕПКА-ПАРИТЕТ
    static TextView SCPmes6EZ;
    static TextView SCPmes12EZ;
    static TextView SCPmes18EZ;
    static TextView SCPmes24EZ;
    static TextView SCPmes36EZ;
    static TextView SCPmes60EZ;

    static TextView SCPmes6EM;
    static TextView SCPmes12EM;
    static TextView SCPmes18EM;
    static TextView SCPmes24EM;
    static TextView SCPmes36EM;
    static TextView SCPmes60EM;


    //СБЕРБАНК ПРОСТО
    static TextView SBPmes13Z;
    static TextView SBPmes15Z;
    static TextView SBPmes18Z;
    static TextView SBPmes24Z;
    static TextView SBPmes36Z;
    static TextView SBPmes48Z;
    static TextView SBPmes60Z;

    static TextView SBPmes13M;
    static TextView SBPmes15M;
    static TextView SBPmes18M;
    static TextView SBPmes24M;
    static TextView SBPmes36M;
    static TextView SBPmes48M;
    static TextView SBPmes60M;

    //ЕЖЕМЕСЯЧНЫЕ СБЕРБАНК ПРОСТО
    static TextView SBPmes13EZ;
    static TextView SBPmes15EZ;
    static TextView SBPmes18EZ;
    static TextView SBPmes24EZ;
    static TextView SBPmes36EZ;
    static TextView SBPmes48EZ;
    static TextView SBPmes60EZ;

    static TextView SBPmes13EM;
    static TextView SBPmes15EM;
    static TextView SBPmes18EM;
    static TextView SBPmes24EM;
    static TextView SBPmes36EM;
    static TextView SBPmes48EM;
    static TextView SBPmes60EM;


    //СБЕРБАНК ГРЕЙС 6 МЕС
    static TextView SBGmes24Z;
    static TextView SBGmes36Z;
    static TextView SBGmes48Z;
    static TextView SBGmes60Z;

    static TextView SBGmes24M;
    static TextView SBGmes36M;
    static TextView SBGmes48M;
    static TextView SBGmes60M;

    //ЕЖЕМЕСЯЧНЫЕ СБЕРБАНК ГРЕЙС 6 МЕС
    static TextView SBGmes24EZ;
    static TextView SBGmes36EZ;
    static TextView SBGmes48EZ;
    static TextView SBGmes60EZ;

    static TextView SBGmes24EM;
    static TextView SBGmes36EM;
    static TextView SBGmes48EM;
    static TextView SBGmes60EM;


    //ЛИЗИНГ
    static TextView Lmes4Z;
    static TextView Lmes6Z;
    static TextView Lmes12Z;
    static TextView Lmes20Z;
    static TextView Lmes24Z;

    static TextView Lmes4M;
    static TextView Lmes6M;
    static TextView Lmes12M;
    static TextView Lmes20M;
    static TextView Lmes24M;

    //ЕЖЕМЕСЯЧНЫЕ ЛИЗИНГ
    static TextView Lmes4EZ;
    static TextView Lmes6EZ;
    static TextView Lmes12EZ;
    static TextView Lmes20EZ;
    static TextView Lmes24EZ;

    static TextView Lmes4EM;
    static TextView Lmes6EM;
    static TextView Lmes12EM;
    static TextView Lmes20EM;
    static TextView Lmes24EM;

    static TextView textPrepaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        //АЛЬФАБАНК
        Ames6Z = findViewById(R.id.Ames6Z);
        Ames12Z = findViewById(R.id.Ames12Z);
        Ames18Z = findViewById(R.id.Ames18Z);
        Ames24Z = findViewById(R.id.Ames24Z);
        Ames36Z = findViewById(R.id.Ames36Z);
        Ames48Z = findViewById(R.id.Ames48Z);

        Ames6M = findViewById(R.id.Ames6M);
        Ames12M = findViewById(R.id.Ames12M);
        Ames18M = findViewById(R.id.Ames18M);
        Ames24M = findViewById(R.id.Ames24M);
        Ames36M = findViewById(R.id.Ames36M);
        Ames48M = findViewById(R.id.Ames48M);

        //ЕЖЕМЕСЯЧНЫЕ АЛЬФАБАНК
        Ames6EZ = findViewById(R.id.Ames6EZ);
        Ames12EZ = findViewById(R.id.Ames12EZ);
        Ames18EZ = findViewById(R.id.Ames18EZ);
        Ames24EZ = findViewById(R.id.Ames24EZ);
        Ames36EZ = findViewById(R.id.Ames36EZ);
        Ames48EZ = findViewById(R.id.Ames48EZ);

        Ames6EM = findViewById(R.id.Ames6EM);
        Ames12EM = findViewById(R.id.Ames12EM);
        Ames18EM = findViewById(R.id.Ames18EM);
        Ames24EM = findViewById(R.id.Ames24EM);
        Ames36EM = findViewById(R.id.Ames36EM);
        Ames48EM = findViewById(R.id.Ames48EM);


        //АЛЬФАБАНК ПЛЮС
        APlusmes3Z = findViewById(R.id.APlusmes3Z);
        APlusmes6Z = findViewById(R.id.APlusmes6Z);
        APlusmes10Z = findViewById(R.id.APlusmes10Z);
        APlusmes12Z = findViewById(R.id.APlusmes12Z);
        APlusmes15Z = findViewById(R.id.APlusmes15Z);
        APlusmes18Z = findViewById(R.id.APlusmes18Z);
        APlusmes24Z = findViewById(R.id.APlusmes24Z);
        APlusmes36Z = findViewById(R.id.APlusmes36Z);
        APlusmes48Z = findViewById(R.id.APlusmes48Z);

        APlusmes3M = findViewById(R.id.APlusmes3M);
        APlusmes6M = findViewById(R.id.APlusmes6M);
        APlusmes10M = findViewById(R.id.APlusmes10M);
        APlusmes12M = findViewById(R.id.APlusmes12M);
        APlusmes15M = findViewById(R.id.APlusmes15M);
        APlusmes18M = findViewById(R.id.APlusmes18M);
        APlusmes24M = findViewById(R.id.APlusmes24M);
        APlusmes36M = findViewById(R.id.APlusmes36M);
        APlusmes48M = findViewById(R.id.APlusmes48M);

        //ЕЖЕМЕСЯЧНЫЕ АЛЬФАБАНК
        APlusmes3EZ = findViewById(R.id.APlusmes3EZ);
        APlusmes6EZ = findViewById(R.id.APlusmes6EZ);
        APlusmes10EZ = findViewById(R.id.APlusmes10EZ);
        APlusmes12EZ = findViewById(R.id.APlusmes12EZ);
        APlusmes15EZ = findViewById(R.id.APlusmes15EZ);
        APlusmes18EZ = findViewById(R.id.APlusmes18EZ);
        APlusmes24EZ = findViewById(R.id.APlusmes24EZ);
        APlusmes36EZ = findViewById(R.id.APlusmes36EZ);
        APlusmes48EZ = findViewById(R.id.APlusmes48EZ);

        APlusmes3EM = findViewById(R.id.APlusmes3EM);
        APlusmes6EM = findViewById(R.id.APlusmes6EM);
        APlusmes10EM = findViewById(R.id.APlusmes10EM);
        APlusmes12EM = findViewById(R.id.APlusmes12EM);
        APlusmes15EM = findViewById(R.id.APlusmes15EM);
        APlusmes18EM = findViewById(R.id.APlusmes18EM);
        APlusmes24EM = findViewById(R.id.APlusmes24EM);
        APlusmes36EM = findViewById(R.id.APlusmes36EM);
        APlusmes48EM = findViewById(R.id.APlusmes48EM);



        //АЛЬФАБАНК РАССРОЧКА
        ARasrochMes5Z = findViewById(R.id.ARasrMes5Z);
        ARasrochMes6Z = findViewById(R.id.ARasrMes6Z);

        ARasrochMes5M = findViewById(R.id.ARasrMes5M);
        ARasrochMes6M = findViewById(R.id.ARasrMes6M);

        //ЕЖЕМЕСЯЧНЫЕ АЛЬФАБАНК РАССРОЧКА
        ARasrochMes5EZ = findViewById(R.id.ARasrMes5EZ);
        ARasrochMes6EZ = findViewById(R.id.ARasrMes6EZ);

        ARasrochMes5EM = findViewById(R.id.ARasrMes5EM);
        ARasrochMes6EM = findViewById(R.id.ARasrMes6EM);



        //СКРЕПКА-ДАБРАБЫТ
        SCDmes6Z = findViewById(R.id.SCDmes6Z);
        SCDmes12Z = findViewById(R.id.SCDmes12Z);
        SCDmes18Z = findViewById(R.id.SCDmes18Z);
        SCDmes24Z = findViewById(R.id.SCDmes24Z);
        SCDmes36Z = findViewById(R.id.SCDmes36Z);

        SCDmes6M = findViewById(R.id.SCDmes6M);
        SCDmes12M = findViewById(R.id.SCDmes12M);
        SCDmes18M = findViewById(R.id.SCDmes18M);
        SCDmes24M = findViewById(R.id.SCDmes24M);
        SCDmes36M = findViewById(R.id.SCDmes36M);

        //ЕЖЕМЕСЯЧНЫЕ ДОБРОБЫТ
        SCDmes6EZ = findViewById(R.id.SCDmes6EZ);
        SCDmes12EZ = findViewById(R.id.SCDmes12EZ);
        SCDmes18EZ = findViewById(R.id.SCDmes18EZ);
        SCDmes24EZ = findViewById(R.id.SCDmes24EZ);
        SCDmes36EZ = findViewById(R.id.SCDmes36EZ);

        SCDmes6EM = findViewById(R.id.SCDmes6EM);
        SCDmes12EM = findViewById(R.id.SCDmes12EM);
        SCDmes18EM = findViewById(R.id.SCDmes18EM);
        SCDmes24EM = findViewById(R.id.SCDmes24EM);
        SCDmes36EM = findViewById(R.id.SCDmes36EM);




        //СКРЕПКА-ПАРИТЕТ
        SCPmes6Z = findViewById(R.id.SCPmes6Z);
        SCPmes12Z = findViewById(R.id.SCPmes12Z);
        SCPmes18Z = findViewById(R.id.SCPmes18Z);
        SCPmes24Z = findViewById(R.id.SCPmes24Z);
        SCPmes36Z = findViewById(R.id.SCPmes36Z);
        SCPmes60Z = findViewById(R.id.SCPmes60Z);

        SCPmes6M = findViewById(R.id.SCPmes6M);
        SCPmes12M = findViewById(R.id.SCPmes12M);
        SCPmes18M = findViewById(R.id.SCPmes18M);
        SCPmes24M = findViewById(R.id.SCPmes24M);
        SCPmes36M = findViewById(R.id.SCPmes36M);
        SCPmes60M = findViewById(R.id.SCPmes60M);

        //ЕЖЕМЕСЯЧНЫЕ ПАРИТЕТ
        SCPmes6EZ = findViewById(R.id.SCPmes6EZ);
        SCPmes12EZ = findViewById(R.id.SCPmes12EZ);
        SCPmes18EZ = findViewById(R.id.SCPmes18EZ);
        SCPmes24EZ = findViewById(R.id.SCPmes24EZ);
        SCPmes36EZ = findViewById(R.id.SCPmes36EZ);
        SCPmes60EZ = findViewById(R.id.SCPmes60EZ);

        SCPmes6EM = findViewById(R.id.SCPmes6EM);
        SCPmes12EM = findViewById(R.id.SCPmes12EM);
        SCPmes18EM = findViewById(R.id.SCPmes18EM);
        SCPmes24EM = findViewById(R.id.SCPmes24EM);
        SCPmes36EM = findViewById(R.id.SCPmes36EM);
        SCPmes60EM = findViewById(R.id.SCPmes60EM);




        //СБЕРБАНК ПРОСТО
        SBPmes13Z = findViewById(R.id.SBPmes13Z);
        SBPmes15Z = findViewById(R.id.SBPmes15Z);
        SBPmes18Z = findViewById(R.id.SBPmes18Z);
        SBPmes24Z = findViewById(R.id.SBPmes24Z);
        SBPmes36Z = findViewById(R.id.SBPmes36Z);
        SBPmes48Z = findViewById(R.id.SBPmes48Z);
        SBPmes60Z = findViewById(R.id.SBPmes60Z);

        SBPmes13M = findViewById(R.id.SBPmes13M);
        SBPmes15M = findViewById(R.id.SBPmes15M);
        SBPmes18M = findViewById(R.id.SBPmes18M);
        SBPmes24M = findViewById(R.id.SBPmes24M);
        SBPmes36M = findViewById(R.id.SBPmes36M);
        SBPmes48M = findViewById(R.id.SBPmes48M);
        SBPmes60M = findViewById(R.id.SBPmes60M);

        //ЕЖЕМЕСЯЧНЫЕ СБЕРБАНК ПРОСТО
        SBPmes13EZ = findViewById(R.id.SBPmes13EZ);
        SBPmes15EZ = findViewById(R.id.SBPmes15EZ);
        SBPmes18EZ = findViewById(R.id.SBPmes18EZ);
        SBPmes24EZ = findViewById(R.id.SBPmes24EZ);
        SBPmes36EZ = findViewById(R.id.SBPmes36EZ);
        SBPmes48EZ = findViewById(R.id.SBPmes48EZ);
        SBPmes60EZ = findViewById(R.id.SBPmes60EZ);

        SBPmes13EM = findViewById(R.id.SBPmes13EM);
        SBPmes15EM = findViewById(R.id.SBPmes15EM);
        SBPmes18EM = findViewById(R.id.SBPmes18EM);
        SBPmes24EM = findViewById(R.id.SBPmes24EM);
        SBPmes36EM = findViewById(R.id.SBPmes36EM);
        SBPmes48EM = findViewById(R.id.SBPmes48EM);
        SBPmes60EM = findViewById(R.id.SBPmes60EM);




        //СБЕРБАНК ГРЕЙС 6 МЕС
        SBGmes24Z = findViewById(R.id.SBGmes24Z);
        SBGmes36Z = findViewById(R.id.SBGmes36Z);
        SBGmes48Z = findViewById(R.id.SBGmes48Z);
        SBGmes60Z = findViewById(R.id.SBGmes60Z);

        SBGmes24M = findViewById(R.id.SBGmes24M);
        SBGmes36M = findViewById(R.id.SBGmes36M);
        SBGmes48M = findViewById(R.id.SBGmes48M);
        SBGmes60M = findViewById(R.id.SBGmes60M);

        //ЕЖЕМЕСЯЧНЫЕ СБЕРБАНК ГРЕЙС 6 МЕС
        SBGmes24EZ = findViewById(R.id.SBGmes24EZ);
        SBGmes36EZ = findViewById(R.id.SBGmes36EZ);
        SBGmes48EZ = findViewById(R.id.SBGmes48EZ);
        SBGmes60EZ = findViewById(R.id.SBGmes60EZ);

        SBGmes24EM = findViewById(R.id.SBGmes24EM);
        SBGmes36EM = findViewById(R.id.SBGmes36EM);
        SBGmes48EM = findViewById(R.id.SBGmes48EM);
        SBGmes60EM = findViewById(R.id.SBGmes60EM);



        //ЛИЗИНГ
        Lmes4Z = findViewById(R.id.Lmes4Z);
        Lmes6Z = findViewById(R.id.Lmes6Z);
        Lmes12Z = findViewById(R.id.Lmes12Z);
        Lmes20Z = findViewById(R.id.Lmes20Z);
        Lmes24Z = findViewById(R.id.Lmes24Z);

        Lmes4M = findViewById(R.id.Lmes4M);
        Lmes6M = findViewById(R.id.Lmes6M);
        Lmes12M = findViewById(R.id.Lmes12M);
        Lmes20M = findViewById(R.id.Lmes20M);
        Lmes24M = findViewById(R.id.Lmes24M);

        //ЕЖЕМЕСЯЧНЫЕ ДОБРОБЫТ
        Lmes4EZ = findViewById(R.id.Lmes4EZ);
        Lmes6EZ = findViewById(R.id.Lmes6EZ);
        Lmes12EZ = findViewById(R.id.Lmes12EZ);
        Lmes20EZ = findViewById(R.id.Lmes20EZ);
        Lmes24EZ = findViewById(R.id.Lmes24EZ);

        Lmes4EM = findViewById(R.id.Lmes4EM);
        Lmes6EM = findViewById(R.id.Lmes6EM);
        Lmes12EM = findViewById(R.id.Lmes12EM);
        Lmes20EM = findViewById(R.id.Lmes20EM);
        Lmes24EM = findViewById(R.id.Lmes24EM);

        textPrepaid= findViewById(R.id.txtPrepaid);

        final EditText editTextPrepaid = findViewById(R.id.editTextPrepaid);
        ImageView imInfoBank = findViewById(R.id.imInfoBank);

        setPriceBank();

        //Если нажали на поле предоплаты
        imInfoBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(Bank.this);
                builder.setTitle("Внимание!");
                builder.setMessage(
                        "МИНИМАЛЬНАЯ сумма для ПОДАЧИ заявки: \n"
                        + "По банкам: 50 руб\n"
                        + "По лизингу: 600 руб\n" +
                        "МАКСИМАЛЬНАЯ сумма ПРЕДОПЛАТЫ по ЛИЗИНГУ: \n"
                        + "ЖЕЛ: " + prepaidLizZh + "\n"
                        + "МИН: " + prepaidLizM + "\n");

                builder.setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        //Если нажали выбрать
        editTextPrepaid.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    if (editTextPrepaid.getText().toString().equals("")) {

                    }
                    // сохраняем текст, введённый до нажатия Enter в переменную
                    else {
                        String prepaid = editTextPrepaid.getText().toString();
                        textPrepaid.setText(prepaid);
                        editTextPrepaid.getText().clear();
                        setPriceBank(Integer.parseInt(prepaid));
                    }
                    return true;
                }
                return false;
            }
        }
        );

    }
    static public void setPriceZM(double z, double m) {
        priceZ = (int) z;
        priceM = (int) m;
    }

    public void setPriceBank() {

        boolean isPocket = MainActivity.nameMeasure.contains("COMFORTPOCKET") || MainActivity.nameMeasure.contains("PREMIUMPOCKET");

        //АЛЬФА-ПРОСТО
        Ames6Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        Ames12Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        Ames18Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        Ames24Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        Ames36Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        Ames48Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");

        Ames6M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        Ames12M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        Ames18M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        Ames24M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        Ames36M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        Ames48M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");

        Ames6EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 6, priceZ) + rub : "-");
        Ames12EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 12, priceZ) + rub : "-");
        Ames18EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 18, priceZ) + rub : "-");
        Ames24EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 24, priceZ) + rub : "-");
        Ames36EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 36, priceZ) + rub : "-");
        Ames48EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 48, priceZ) + rub : "-");

        Ames6EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 6, priceM) + rub : "-");
        Ames12EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 12, priceM) + rub : "-");
        Ames18EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 18, priceM) + rub : "-");
        Ames24EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 24, priceM) + rub : "-");
        Ames36EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 36, priceM) + rub : "-");
        Ames48EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 48, priceM) + rub : "-");


        //АЛЬФА-ПЛЮС
        APlusmes3Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES3) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES3) + rub : "-");
        APlusmes6Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES6) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES6) + rub : "-");
        APlusmes10Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES10) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES10) + rub : "-");
        APlusmes12Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES12) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES12) + rub : "-");
        APlusmes15Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES15) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES15) + rub : "-");
        APlusmes18Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES18) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES18) + rub : "-");
        APlusmes24Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES24) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES24) + rub : "-");
        APlusmes36Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES36) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES36) + rub : "-");
        APlusmes48Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES48) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES48) + rub : "-");

        APlusmes3M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES3) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES3) + rub : "-");
        APlusmes6M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES6) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES6) + rub : "-");
        APlusmes10M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES10) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES10) + rub : "-");
        APlusmes12M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES12) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES12) + rub : "-");
        APlusmes15M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES15) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES15) + rub : "-");
        APlusmes18M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES18) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES18) + rub : "-");
        APlusmes24M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES24) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES24) + rub : "-");
        APlusmes36M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES36) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES36) + rub : "-");
        APlusmes48M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES48) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES48) + rub : "-");

        APlusmes3EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES3) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 3, (int) (priceZ * MainActivity.prices.AMES3)) + rub : "-");
        APlusmes6EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES6) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 6, (int) (priceZ * MainActivity.prices.AMES6)) + rub : "-");
        APlusmes10EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES10) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 10, (int) (priceZ * MainActivity.prices.AMES10)) + rub : "-");
        APlusmes12EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES12) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 12, (int) (priceZ * MainActivity.prices.AMES12)) + rub : "-");
        APlusmes15EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES15) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 15, (int) (priceZ * MainActivity.prices.AMES15)) + rub : "-");
        APlusmes18EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES18) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 18, (int) (priceZ * MainActivity.prices.AMES18)) + rub : "-");
        APlusmes24EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES24) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 24, (int) (priceZ * MainActivity.prices.AMES24)) + rub : "-");
        APlusmes36EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES36) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 36, (int) (priceZ * MainActivity.prices.AMES36)) + rub : "-");
        APlusmes48EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES48) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 48, (int) (priceZ * MainActivity.prices.AMES48)) + rub : "-");

        APlusmes3EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES3) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 3, (int) (priceM * MainActivity.prices.AMES3)) + rub : "-");
        APlusmes6EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES6) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 6, (int) (priceM * MainActivity.prices.AMES6)) + rub : "-");
        APlusmes10EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES10) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 10, (int) (priceM * MainActivity.prices.AMES10)) + rub : "-");
        APlusmes12EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES12) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 12, (int) (priceM * MainActivity.prices.AMES12)) + rub : "-");
        APlusmes15EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES15) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 15, (int) (priceM * MainActivity.prices.AMES15)) + rub : "-");
        APlusmes18EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES18) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 18, (int) (priceM * MainActivity.prices.AMES18)) + rub : "-");
        APlusmes24EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES24) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 24, (int) (priceM * MainActivity.prices.AMES24)) + rub : "-");
        APlusmes36EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES36) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 36, (int) (priceM * MainActivity.prices.AMES36)) + rub : "-");
        APlusmes48EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES48) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 48, (int) (priceM * MainActivity.prices.AMES48)) + rub : "-");


        //АЛЬФА-РАССРОЧКА
        ARasrochMes5Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES5) ? (int) Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES5) + rub : "-");
        ARasrochMes6Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES6) ? (int) Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES6) + rub : "-");

        ARasrochMes5M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES5) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES5) + rub : "-");
        ARasrochMes6M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES6) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES6) + rub : "-");

        ARasrochMes5EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES5) ? Math.ceil( (priceZ * MainActivity.prices.A_RASROCH_MES5)/5) + rub : "-");
        ARasrochMes6EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES6) ? Math.ceil( (priceZ * MainActivity.prices.A_RASROCH_MES6)/6) + rub : "-");

        ARasrochMes5EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES5) && !isPocket ? Math.ceil( (priceM * MainActivity.prices.A_RASROCH_MES5)/5) + rub : "-");
        ARasrochMes6EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES6) && !isPocket ? Math.ceil( (priceM * MainActivity.prices.A_RASROCH_MES6)/6) + rub : "-");



        //СКРЕПКА-ДАБРАБЫТ
        SCDmes6Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCDMES6) ? (int) Math.ceil(priceZ * MainActivity.prices.SCDMES6) + rub : "-");
        SCDmes12Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCDMES12) ? (int) Math.ceil(priceZ * MainActivity.prices.SCDMES12) + rub : "-");
        SCDmes18Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCDMES18) ? (int) Math.ceil(priceZ * MainActivity.prices.SCDMES18) + rub : "-");
        SCDmes24Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCDMES24) ? (int) Math.ceil(priceZ * MainActivity.prices.SCDMES24) + rub : "-");
        SCDmes36Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCDMES36) ? (int) Math.ceil(priceZ * MainActivity.prices.SCDMES36) + rub : "-");

        SCDmes6M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCDMES6) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCDMES6) + rub : "-");
        SCDmes12M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCDMES12) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCDMES12) + rub : "-");
        SCDmes18M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCDMES18) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCDMES18) + rub : "-");
        SCDmes24M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCDMES24) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCDMES24) + rub : "-");
        SCDmes36M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCDMES36) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCDMES36) + rub : "-");

        SCDmes6EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCDMES6) ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 6, (int) (priceZ * MainActivity.prices.SCDMES6)) + rub : "-");
        SCDmes12EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCDMES12) ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 12, (int) (priceZ * MainActivity.prices.SCDMES12)) + rub : "-");
        SCDmes18EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCDMES18) ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 18, (int) (priceZ * MainActivity.prices.SCDMES18)) + rub : "-");
        SCDmes24EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCDMES24) ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 24, (int) (priceZ * MainActivity.prices.SCDMES24)) + rub : "-");
        SCDmes36EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCDMES36) ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 36, (int) (priceZ * MainActivity.prices.SCDMES36)) + rub : "-");

        SCDmes6EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCDMES6) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 6, (int) (priceM * MainActivity.prices.SCDMES6)) + rub : "-");
        SCDmes12EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCDMES12) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 12, (int) (priceM * MainActivity.prices.SCDMES12)) + rub : "-");
        SCDmes18EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCDMES18) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 18, (int) (priceM * MainActivity.prices.SCDMES18)) + rub : "-");
        SCDmes24EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCDMES24) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 24, (int) (priceM * MainActivity.prices.SCDMES24)) + rub : "-");
        SCDmes36EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCDMES36) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 36, (int) (priceM * MainActivity.prices.SCDMES36)) + rub : "-");



        //СКРЕПКА-ПАРИТЕТ
        SCPmes6Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES6) ? (int) Math.ceil(priceZ * MainActivity.prices.SCPMES6) + rub : "-");
        SCPmes12Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES12) ? (int) Math.ceil(priceZ * MainActivity.prices.SCPMES12) + rub : "-");
        SCPmes18Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES18) ? (int) Math.ceil(priceZ * MainActivity.prices.SCPMES18) + rub : "-");
        SCPmes24Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES24) ? (int) Math.ceil(priceZ * MainActivity.prices.SCPMES24) + rub : "-");
        SCPmes36Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES36) ? (int) Math.ceil(priceZ * MainActivity.prices.SCPMES36) + rub : "-");
        SCPmes60Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES60) ? (int) Math.ceil(priceZ * MainActivity.prices.SCPMES60) + rub : "-");

        SCPmes6M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES6) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCPMES6) + rub : "-");
        SCPmes12M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES12) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCPMES12) + rub : "-");
        SCPmes18M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES18) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCPMES18) + rub : "-");
        SCPmes24M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES24) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCPMES24) + rub : "-");
        SCPmes36M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES36) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCPMES36) + rub : "-");
        SCPmes60M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES60) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SCPMES60) + rub : "-");

        SCPmes6EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES6) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 6, (int) (priceZ * MainActivity.prices.SCPMES6)) + rub : "-");
        SCPmes12EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES12) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 12, (int) (priceZ * MainActivity.prices.SCPMES12)) + rub : "-");
        SCPmes18EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES18) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 18, (int) (priceZ * MainActivity.prices.SCPMES18)) + rub : "-");
        SCPmes24EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES24) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 24, (int) (priceZ * MainActivity.prices.SCPMES24)) + rub : "-");
        SCPmes36EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES36) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 36, (int) (priceZ * MainActivity.prices.SCPMES36)) + rub : "-");
        SCPmes60EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SCPMES60) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 60, (int) (priceZ * MainActivity.prices.SCPMES60)) + rub : "-");

        SCPmes6EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES6) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 6, (int) (priceM * MainActivity.prices.SCPMES6)) + rub : "-");
        SCPmes12EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES12) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 12, (int) (priceM * MainActivity.prices.SCPMES12)) + rub : "-");
        SCPmes18EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES18) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 18, (int) (priceM * MainActivity.prices.SCPMES18)) + rub : "-");
        SCPmes24EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES24) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 24, (int) (priceM * MainActivity.prices.SCPMES24)) + rub : "-");
        SCPmes36EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES36) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 36, (int) (priceM * MainActivity.prices.SCPMES36)) + rub : "-");
        SCPmes60EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SCPMES60) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 60, (int) (priceM * MainActivity.prices.SCPMES60)) + rub : "-");



        //СБЕРБАНК ПРОСТО
        SBPmes13Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        SBPmes15Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        SBPmes18Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        SBPmes24Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        SBPmes36Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        SBPmes48Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");
        SBPmes60Z.setText(minBank <= Math.ceil(priceZ) ? (int) Math.ceil(priceZ) + rub : "-");

        SBPmes13M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        SBPmes15M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        SBPmes18M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        SBPmes24M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        SBPmes36M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        SBPmes48M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");
        SBPmes60M.setText(minBank <= Math.ceil(priceM) && !isPocket ? (int) Math.ceil(priceM) + rub : "-");

        SBPmes13EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 13, priceZ) + rub : "-");
        SBPmes15EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 15, priceZ) + rub : "-");
        SBPmes18EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 18, priceZ) + rub : "-");
        SBPmes24EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, priceZ) + rub : "-");
        SBPmes36EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, priceZ) + rub : "-");
        SBPmes48EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, priceZ) + rub : "-");
        SBPmes60EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, priceZ) + rub : "-");

        SBPmes13EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 13, priceM) + rub : "-");
        SBPmes15EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 15, priceM) + rub : "-");
        SBPmes18EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 18, priceM) + rub : "-");
        SBPmes24EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, priceM) + rub : "-");
        SBPmes36EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, priceM) + rub : "-");
        SBPmes48EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, priceM) + rub : "-");
        SBPmes60EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, priceM) + rub : "-");


        //СБЕРБАНК ГРЕЙС 6 МЕС
        SBGmes24Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? (int) Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes36Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? (int) Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes48Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? (int) Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes60Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? (int) Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) + rub : "-");

        SBGmes24M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes36M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes48M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes60M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) + rub : "-");

        SBGmes24EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, (int) (priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, (int) (priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, (int) (priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, (int) (priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");

        SBGmes24EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, (int) (priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, (int) (priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, (int) (priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, (int) (priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");


        //ЛИЗИНГ
        Lmes4Z.setText(minLiz <= Math.ceil(priceLizZh * MainActivity.prices.LIZING4M) ? (int) Math.ceil(priceLizZh * MainActivity.prices.LIZING4M) + rub : "-");
        Lmes6Z.setText(minLiz <= Math.ceil(priceLizZh * MainActivity.prices.LIZING6M) ? (int) Math.ceil(priceLizZh * MainActivity.prices.LIZING6M) + rub : "-");
        Lmes12Z.setText(minLiz <= Math.ceil(priceLizZh * MainActivity.prices.LIZING12M) ? (int) Math.ceil(priceLizZh * MainActivity.prices.LIZING12M) + rub : "-");
        Lmes20Z.setText(minLiz <= Math.ceil(priceLizZh * MainActivity.prices.LIZING20M) ? (int) Math.ceil(priceLizZh * MainActivity.prices.LIZING20M) + rub : "-");
        Lmes24Z.setText(minLiz <= Math.ceil(priceLizZh * MainActivity.prices.LIZING24M) ? (int) Math.ceil(priceLizZh * MainActivity.prices.LIZING24M) + rub : "-");

        Lmes4M.setText(minLiz <= Math.ceil(priceLizM * MainActivity.prices.LIZING4M) && !isPocket ? (int) Math.ceil(priceLizM * MainActivity.prices.LIZING4M) + rub : "-");
        Lmes6M.setText(minLiz <= Math.ceil(priceLizM * MainActivity.prices.LIZING6M) && !isPocket ? (int) Math.ceil(priceLizM * MainActivity.prices.LIZING6M) + rub : "-");
        Lmes12M.setText(minLiz <= Math.ceil(priceLizM * MainActivity.prices.LIZING12M) && !isPocket ? (int) Math.ceil(priceLizM * MainActivity.prices.LIZING12M) + rub : "-");
        Lmes20M.setText(minLiz <= Math.ceil(priceLizM * MainActivity.prices.LIZING20M) && !isPocket ? (int) Math.ceil(priceLizM * MainActivity.prices.LIZING20M) + rub : "-");
        Lmes24M.setText(minLiz <= Math.ceil(priceLizM * MainActivity.prices.LIZING24M) && !isPocket ? (int) Math.ceil(priceLizM * MainActivity.prices.LIZING24M) + rub : "-");


        Lmes4EZ.setText(minLiz <= Math.ceil(priceLizZh * MainActivity.prices.LIZING4M) ? (int) Math.ceil(priceLizZh * MainActivity.prices.LIZING4M)/4 + rub : "-");
        Lmes6EZ.setText(minLiz <= Math.ceil(priceLizZh * MainActivity.prices.LIZING6M) ? (int) Math.ceil(priceLizZh * MainActivity.prices.LIZING6M)/6 + rub : "-");
        Lmes12EZ.setText(minLiz <= Math.ceil(priceLizZh * MainActivity.prices.LIZING12M) ? (int) Math.ceil(priceLizZh * MainActivity.prices.LIZING12M)/12 + rub : "-");
        Lmes20EZ.setText(minLiz <= Math.ceil(priceLizZh * MainActivity.prices.LIZING20M) ? (int) Math.ceil(priceLizZh * MainActivity.prices.LIZING20M)/20 + rub : "-");
        Lmes24EZ.setText(minLiz <= Math.ceil(priceLizZh * MainActivity.prices.LIZING24M) ? (int) Math.ceil(priceLizZh * MainActivity.prices.LIZING24M)/24 + rub : "-");

        Lmes4EM.setText(minLiz <= Math.ceil(priceLizM * MainActivity.prices.LIZING4M) && !isPocket ? (int) Math.ceil(priceLizM * MainActivity.prices.LIZING4M)/4 + rub : "-");
        Lmes6EM.setText(minLiz <= Math.ceil(priceLizM * MainActivity.prices.LIZING6M) && !isPocket ? (int) Math.ceil(priceLizM * MainActivity.prices.LIZING6M)/6 + rub : "-");
        Lmes12EM.setText(minLiz <= Math.ceil(priceLizM * MainActivity.prices.LIZING12M) && !isPocket ? (int) Math.ceil(priceLizM * MainActivity.prices.LIZING12M)/12 + rub : "-");
        Lmes20EM.setText(minLiz <= Math.ceil(priceLizM * MainActivity.prices.LIZING20M) && !isPocket ? (int) Math.ceil(priceLizM * MainActivity.prices.LIZING20M)/20 + rub : "-");
        Lmes24EM.setText(minLiz <= Math.ceil(priceLizM * MainActivity.prices.LIZING24M) && !isPocket ? (int) Math.ceil(priceLizM * MainActivity.prices.LIZING24M)/24 + rub : "-");
    }

    //Вызывается при добовлении предоплаты
    public void setPriceBank(int i) {
        boolean isPocket = MainActivity.nameMeasure.contains("COMFORTPOCKET") || MainActivity.nameMeasure.contains("PREMIUMPOCKET");
        int tmpPriceZ = priceZ - i;
        int tmpPriceM = priceM - i;
        ContinePrice.forLizingFromBank(i);

        Ames6Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        Ames12Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        Ames18Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        Ames24Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        Ames36Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        Ames48Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");

        Ames6M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        Ames12M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        Ames18M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        Ames24M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        Ames36M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        Ames48M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");

        Ames6EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 6, tmpPriceZ) + rub : "-");
        Ames12EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 12, tmpPriceZ) + rub : "-");
        Ames18EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 18, tmpPriceZ) + rub : "-");
        Ames24EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 24, tmpPriceZ) + rub : "-");
        Ames36EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 36, tmpPriceZ) + rub : "-");
        Ames48EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 48, tmpPriceZ) + rub : "-");

        Ames6EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 6, tmpPriceM) + rub : "-");
        Ames12EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 12, tmpPriceM) + rub : "-");
        Ames18EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 18, tmpPriceM) + rub : "-");
        Ames24EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 24, tmpPriceM) + rub : "-");
        Ames36EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 36, tmpPriceM) + rub : "-");
        Ames48EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 48, tmpPriceM) + rub : "-");



        APlusmes3Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES3) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES3) + rub : "-");
        APlusmes6Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES6) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES6) + rub : "-");
        APlusmes10Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES10) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES10) + rub : "-");
        APlusmes12Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES12) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES12) + rub : "-");
        APlusmes15Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES15) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES15) + rub : "-");
        APlusmes18Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES18) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES18) + rub : "-");
        APlusmes24Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES24) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES24) + rub : "-");
        APlusmes36Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES36) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES36) + rub : "-");
        APlusmes48Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES48) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES48) + rub : "-");

        APlusmes3M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES3) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES3) + rub : "-");
        APlusmes6M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES6) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES6) + rub : "-");
        APlusmes10M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES10) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES10) + rub : "-");
        APlusmes12M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES12) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES12) + rub : "-");
        APlusmes15M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES15) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES15) + rub : "-");
        APlusmes18M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES18) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES18) + rub : "-");
        APlusmes24M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES24) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES24) + rub : "-");
        APlusmes36M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES36) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES36) + rub : "-");
        APlusmes48M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES48) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES48) + rub : "-");

        APlusmes3EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES3) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 3, (int) (tmpPriceZ * MainActivity.prices.AMES3)) + rub : "-");
        APlusmes6EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES6) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 6, (int) (tmpPriceZ * MainActivity.prices.AMES6)) + rub : "-");
        APlusmes10EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES10) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 10, (int) (tmpPriceZ * MainActivity.prices.AMES10)) + rub : "-");
        APlusmes12EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES12) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 12, (int) (tmpPriceZ * MainActivity.prices.AMES12)) + rub : "-");
        APlusmes15EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES15) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 15, (int) (tmpPriceZ * MainActivity.prices.AMES15)) + rub : "-");
        APlusmes18EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES18) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 18, (int) (tmpPriceZ * MainActivity.prices.AMES18)) + rub : "-");
        APlusmes24EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES24) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 24, (int) (tmpPriceZ * MainActivity.prices.AMES24)) + rub : "-");
        APlusmes36EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES36) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 36, (int) (tmpPriceZ * MainActivity.prices.AMES36)) + rub : "-");
        APlusmes48EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES48) ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 48, (int) (tmpPriceZ * MainActivity.prices.AMES48)) + rub : "-");

        APlusmes3EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES3) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 3, (int) (tmpPriceM * MainActivity.prices.AMES3)) + rub : "-");
        APlusmes6EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES6) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 6, (int) (tmpPriceM * MainActivity.prices.AMES6)) + rub : "-");
        APlusmes10EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES10) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 10, (int) (tmpPriceM * MainActivity.prices.AMES10)) + rub : "-");
        APlusmes12EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES12) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 12, (int) (tmpPriceM * MainActivity.prices.AMES12)) + rub : "-");
        APlusmes15EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES15) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 15, (int) (tmpPriceM * MainActivity.prices.AMES15)) + rub : "-");
        APlusmes18EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES18) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 18, (int) (tmpPriceM * MainActivity.prices.AMES18)) + rub : "-");
        APlusmes24EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES24) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 24, (int) (tmpPriceM * MainActivity.prices.AMES24)) + rub : "-");
        APlusmes36EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES36) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 36, (int) (tmpPriceM * MainActivity.prices.AMES36)) + rub : "-");
        APlusmes48EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES48) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK_PLUS, 48, (int) (tmpPriceM * MainActivity.prices.AMES48)) + rub : "-");



        //АЛЬФА-РАССРОЧКА
        ARasrochMes5Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES5) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES5) + rub : "-");
        ARasrochMes6Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES6) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES6) + rub : "-");

        ARasrochMes5M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES5) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES5) + rub : "-");
        ARasrochMes6M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES6) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES6) + rub : "-");

        ARasrochMes5EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES5) ? Math.ceil( (tmpPriceZ * MainActivity.prices.A_RASROCH_MES5)/5) + rub : "-");
        ARasrochMes6EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES6) ? Math.ceil( (tmpPriceZ * MainActivity.prices.A_RASROCH_MES6)/6) + rub : "-");

        ARasrochMes5EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES5) && !isPocket ? Math.ceil( (tmpPriceM * MainActivity.prices.A_RASROCH_MES5)/5) + rub : "-");
        ARasrochMes6EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES6) && !isPocket ? Math.ceil( (tmpPriceM * MainActivity.prices.A_RASROCH_MES6)/6) + rub : "-");


        //СКРЕПКА-ДАБРАБЫТ
        SCDmes6Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES6) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES6) + rub : "-");
        SCDmes12Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES12) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES12) + rub : "-");
        SCDmes18Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES18) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES18) + rub : "-");
        SCDmes24Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES24) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES24) + rub : "-");
        SCDmes36Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES36) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES36) + rub : "-");

        SCDmes6M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCDMES6) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCDMES6) + rub : "-");
        SCDmes12M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCDMES12) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCDMES12) + rub : "-");
        SCDmes18M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCDMES18) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCDMES18) + rub : "-");
        SCDmes24M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCDMES24) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCDMES24) + rub : "-");
        SCDmes36M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCDMES36) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCDMES36) + rub : "-");

        SCDmes6EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES6) ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 6, (int) (tmpPriceZ * MainActivity.prices.SCDMES6)) + rub : "-");
        SCDmes12EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES12) ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 12, (int) (tmpPriceZ * MainActivity.prices.SCDMES12)) + rub : "-");
        SCDmes18EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES18) ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 18, (int) (tmpPriceZ * MainActivity.prices.SCDMES18)) + rub : "-");
        SCDmes24EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES24) ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 24, (int) (tmpPriceZ * MainActivity.prices.SCDMES24)) + rub : "-");
        SCDmes36EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCDMES36) ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 36, (int) (tmpPriceZ * MainActivity.prices.SCDMES36)) + rub : "-");

        SCDmes6EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCDMES6) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 6, (int) (tmpPriceM * MainActivity.prices.SCDMES6)) + rub : "-");
        SCDmes12EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCDMES12) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 12, (int) (tmpPriceM * MainActivity.prices.SCDMES12)) + rub : "-");
        SCDmes18EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCDMES18) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 18, (int) (tmpPriceM * MainActivity.prices.SCDMES18)) + rub : "-");
        SCDmes24EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCDMES24) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 24, (int) (tmpPriceM * MainActivity.prices.SCDMES24)) + rub : "-");
        SCDmes36EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCDMES36) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_DB, 36, (int) (tmpPriceM * MainActivity.prices.SCDMES36)) + rub : "-");


        //СКРЕПКА-ПАРИТЕТ
        SCPmes6Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES6) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES6) + rub : "-");
        SCPmes12Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES12) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES12) + rub : "-");
        SCPmes18Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES18) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES18) + rub : "-");
        SCPmes24Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES24) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES24) + rub : "-");
        SCPmes36Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES36) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES36) + rub : "-");
        SCPmes60Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES60) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES60) + rub : "-");

        SCPmes6M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES6) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCPMES6) + rub : "-");
        SCPmes12M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES12) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCPMES12) + rub : "-");
        SCPmes18M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES18) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCPMES18) + rub : "-");
        SCPmes24M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES24) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCPMES24) + rub : "-");
        SCPmes36M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES36) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCPMES36) + rub : "-");
        SCPmes60M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES60) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SCPMES60) + rub : "-");

        SCPmes6EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES6) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 6, (int) (tmpPriceZ * MainActivity.prices.SCPMES6)) + rub : "-");
        SCPmes12EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES12) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 12, (int) (tmpPriceZ * MainActivity.prices.SCPMES12)) + rub : "-");
        SCPmes18EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES18) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 18, (int) (tmpPriceZ * MainActivity.prices.SCPMES18)) + rub : "-");
        SCPmes24EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES24) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 24, (int) (tmpPriceZ * MainActivity.prices.SCPMES24)) + rub : "-");
        SCPmes36EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES36) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 36, (int) (tmpPriceZ * MainActivity.prices.SCPMES36)) + rub : "-");
        SCPmes60EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SCPMES60) ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 60, (int) (tmpPriceZ * MainActivity.prices.SCPMES60)) + rub : "-");

        SCPmes6EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES6) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 6, (int) (tmpPriceM * MainActivity.prices.SCPMES6)) + rub : "-");
        SCPmes12EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES12) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 12, (int) (tmpPriceM * MainActivity.prices.SCPMES12)) + rub : "-");
        SCPmes18EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES18) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 18, (int) (tmpPriceM * MainActivity.prices.SCPMES18)) + rub : "-");
        SCPmes24EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES24) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 24, (int) (tmpPriceM * MainActivity.prices.SCPMES24)) + rub : "-");
        SCPmes36EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES36) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 36, (int) (tmpPriceM * MainActivity.prices.SCPMES36)) + rub : "-");
        SCPmes60EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SCPMES60) && !isPocket ? getPltBank(MainActivity.prices.SCREPSTVK_PR, 60, (int) (tmpPriceM * MainActivity.prices.SCPMES60)) + rub : "-");

        //СБЕРБАНК ПРОСТО
        SBPmes13Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        SBPmes15Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        SBPmes18Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        SBPmes24Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        SBPmes36Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        SBPmes48Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");
        SBPmes60Z.setText(minBank <= Math.ceil(tmpPriceZ) ? (int) Math.ceil(tmpPriceZ) + rub : "-");

        SBPmes13M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        SBPmes15M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        SBPmes18M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        SBPmes24M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        SBPmes36M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        SBPmes48M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");
        SBPmes60M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? (int) Math.ceil(tmpPriceM) + rub : "-");

        SBPmes13EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 13, tmpPriceZ) + rub : "-");
        SBPmes15EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 15, tmpPriceZ) + rub : "-");
        SBPmes18EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 18, tmpPriceZ) + rub : "-");
        SBPmes24EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, tmpPriceZ) + rub : "-");
        SBPmes36EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, tmpPriceZ) + rub : "-");
        SBPmes48EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, tmpPriceZ) + rub : "-");
        SBPmes60EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, tmpPriceZ) + rub : "-");

        SBPmes13EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 13, tmpPriceM) + rub : "-");
        SBPmes15EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 15, tmpPriceM) + rub : "-");
        SBPmes18EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 18, tmpPriceM) + rub : "-");
        SBPmes24EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, tmpPriceM) + rub : "-");
        SBPmes36EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, tmpPriceM) + rub : "-");
        SBPmes48EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, tmpPriceM) + rub : "-");
        SBPmes60EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, tmpPriceM) + rub : "-");


        //СБЕРБАНК ГРЕЙС 6 МЕС
        SBGmes24Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes36Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes48Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes60Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) + rub : "-");

        SBGmes24M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes36M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes48M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) + rub : "-");
        SBGmes60M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) + rub : "-");

        SBGmes24EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, (int) (tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, (int) (tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, (int) (tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, (int) (tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");

        SBGmes24EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, (int) (tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, (int) (tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, (int) (tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, (int) (tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");



        //ЛИЗИНГ
        Lmes4Z.setText(minLiz <= Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING4M) && i <= prepaidLizZh ? (int) Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING4M) + rub : "-");
        Lmes6Z.setText(minLiz <= Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING6M) && i <= prepaidLizZh ? (int) Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING6M) + rub : "-");
        Lmes12Z.setText(minLiz <= Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING12M) && i <= prepaidLizZh ? (int) Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING12M) + rub : "-");
        Lmes20Z.setText(minLiz <= Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING20M) && i <= prepaidLizZh ? (int) Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING20M) + rub : "-");
        Lmes24Z.setText(minLiz <= Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING24M) && i <= prepaidLizZh ? (int) Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING24M) + rub : "-");

        Lmes4M.setText(minLiz  <= Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING4M) && i <= prepaidLizM && !isPocket ? (int) Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING4M) + rub : "-");
        Lmes6M.setText(minLiz  <= Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING6M) && i <= prepaidLizM && !isPocket ? (int) Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING6M) + rub : "-");
        Lmes12M.setText(minLiz  <= Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING12M) && i <= prepaidLizM && !isPocket ? (int) Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING12M) + rub : "-");
        Lmes20M.setText(minLiz  <= Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING20M) && i <= prepaidLizM && !isPocket ? (int) Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING20M) + rub : "-");
        Lmes24M.setText(minLiz  <= Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING24M) && i <= prepaidLizM && !isPocket ? (int) Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING24M) + rub : "-");


        Lmes4EZ.setText(minLiz <= Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING4M) && i <= prepaidLizZh ? (int) Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING4M)/4 + rub : "-");
        Lmes6EZ.setText(minLiz <= Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING6M) && i <= prepaidLizZh ? (int) Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING6M)/6 + rub : "-");
        Lmes12EZ.setText(minLiz <= Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING12M) && i <= prepaidLizZh ? (int) Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING12M)/12 + rub : "-");
        Lmes20EZ.setText(minLiz <= Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING20M) && i <= prepaidLizZh ? (int) Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING20M)/20 + rub : "-");
        Lmes24EZ.setText(minLiz <= Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING24M) && i <= prepaidLizZh ? (int) Math.ceil(priceLizZhWPrepaid * MainActivity.prices.LIZING24M)/24 + rub : "-");

        Lmes4EM.setText(minLiz <= Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING4M) && i <= prepaidLizM && !isPocket ? (int) Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING4M)/4 + rub : "-");
        Lmes6EM.setText(minLiz  <= Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING6M) && i <= prepaidLizM && !isPocket ? (int) Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING6M)/6 + rub : "-");
        Lmes12EM.setText(minLiz  <= Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING12M) && i <= prepaidLizM && !isPocket ? (int) Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING12M)/12 + rub : "-");
        Lmes20EM.setText(minLiz  <= Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING20M) && i <= prepaidLizM && !isPocket ? (int) Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING20M)/20 + rub : "-");
        Lmes24EM.setText(minLiz  <= Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING24M)  && i <= prepaidLizM && !isPocket ? (int) Math.ceil(priceLizMWPrepaid  * MainActivity.prices.LIZING24M)/24 + rub : "-");
    }

    public static void setPriceDopAndItem(double pLizZh, double pLizMin, double zhMaxPrepaid, double minMaxPrepaid) {
        priceLizZh = pLizZh;
        priceLizM = pLizMin;
        prepaidLizZh = (int) zhMaxPrepaid;
        prepaidLizM = (int) minMaxPrepaid;
    }


    //Вызывается при добовлении предоплаты
    public static void setPriceLizWithPrepaid(double pLizZh, double pLizMin) {
        priceLizZhWPrepaid = pLizZh;
        priceLizMWPrepaid = pLizMin;
    }

    // с - процентная ставка
    // n - срок кредитования
    // sum - сумма кредита
    public static int getPltBank(double c, int n, int sum) {
        double i = c/12/100;
        double K = (i * Math.pow(1 + i,n))/(Math.pow(1 + i,n) - 1);
        return (int) Math.ceil(K * sum);
    }

}
