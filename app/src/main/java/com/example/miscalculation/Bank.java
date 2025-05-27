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
    static int priceZ;
    static int priceM;

    static int minBank = 50;

    static final String rub = " руб";

    //АЛЬФА-БАНК
    static TextView Ames6Z;
    static TextView Ames12Z;
    static TextView Ames24Z;
    static TextView Ames36Z;

    static TextView Ames6M;
    static TextView Ames12M;
    static TextView Ames24M;
    static TextView Ames36M;

    //ЕЖЕМЕСЯЧНЫЕ АЛЬФА
    static TextView Ames6EZ;
    static TextView Ames12EZ;
    static TextView Ames24EZ;
    static TextView Ames36EZ;

    static TextView Ames6EM;
    static TextView Ames12EM;
    static TextView Ames24EM;
    static TextView Ames36EM;

    //АЛЬФА-БАНК РАССРОЧКА
    static TextView ARasrochMes4Z;
    static TextView ARasrochMes5Z;

    static TextView ARasrochMes4M;
    static TextView ARasrochMes5M;

    //ЕЖЕМЕСЯЧНЫЕ АЛЬФА
    static TextView ARasrochMes4EZ;
    static TextView ARasrochMes5EZ;

    static TextView ARasrochMes4EM;
    static TextView ARasrochMes5EM;

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
    static TextView textPrepaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        //АЛЬФАБАНК
        Ames6Z = findViewById(R.id.Ames6Z);
        Ames12Z = findViewById(R.id.Ames12Z);
        Ames24Z = findViewById(R.id.Ames24Z);
        Ames36Z = findViewById(R.id.Ames36Z);

        Ames6M = findViewById(R.id.Ames6M);
        Ames12M = findViewById(R.id.Ames12M);
        Ames24M = findViewById(R.id.Ames24M);
        Ames36M = findViewById(R.id.Ames36M);

        //ЕЖЕМЕСЯЧНЫЕ АЛЬФАБАНК
        Ames6EZ = findViewById(R.id.Ames6EZ);
        Ames12EZ = findViewById(R.id.Ames12EZ);
        Ames24EZ = findViewById(R.id.Ames24EZ);
        Ames36EZ = findViewById(R.id.Ames36EZ);

        Ames6EM = findViewById(R.id.Ames6EM);
        Ames12EM = findViewById(R.id.Ames12EM);
        Ames24EM = findViewById(R.id.Ames24EM);
        Ames36EM = findViewById(R.id.Ames36EM);



        //АЛЬФАБАНК РАССРОЧКА
        ARasrochMes4Z = findViewById(R.id.ARasrMes4Z);
        ARasrochMes5Z = findViewById(R.id.ARasrMes5Z);

        ARasrochMes4M = findViewById(R.id.ARasrMes4M);
        ARasrochMes5M = findViewById(R.id.ARasrMes5M);

        //ЕЖЕМЕСЯЧНЫЕ АЛЬФАБАНК РАССРОЧКА
        ARasrochMes4EZ = findViewById(R.id.ARasrMes4EZ);
        ARasrochMes5EZ = findViewById(R.id.ARasrMes5EZ);

        ARasrochMes4EM = findViewById(R.id.ARasrMes4EM);
        ARasrochMes5EM = findViewById(R.id.ARasrMes5EM);

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

        textPrepaid= findViewById(R.id.txtPrepaid);

        /*//СБЕРБАНК ПРОСТО
        SBPmes13Z.setVisibility(View.INVISIBLE);
        SBPmes15Z.setVisibility(View.INVISIBLE);
        SBPmes18Z.setVisibility(View.INVISIBLE);
        SBPmes24Z.setVisibility(View.INVISIBLE);
        SBPmes36Z.setVisibility(View.INVISIBLE);
        SBPmes48Z.setVisibility(View.INVISIBLE);
        SBPmes60Z.setVisibility(View.INVISIBLE);
        SBPmes13M.setVisibility(View.INVISIBLE);
        SBPmes15M.setVisibility(View.INVISIBLE);
        SBPmes18M.setVisibility(View.INVISIBLE);
        SBPmes24M.setVisibility(View.INVISIBLE);
        SBPmes36M.setVisibility(View.INVISIBLE);
        SBPmes48M.setVisibility(View.INVISIBLE);
        SBPmes60M.setVisibility(View.INVISIBLE);
        //ЕЖЕМЕСЯЧНЫЕ СБЕРБАНК ПРОСТО
        SBPmes13EZ.setVisibility(View.INVISIBLE);
        SBPmes15EZ.setVisibility(View.INVISIBLE);
        SBPmes18EZ.setVisibility(View.INVISIBLE);
        SBPmes24EZ.setVisibility(View.INVISIBLE);
        SBPmes36EZ.setVisibility(View.INVISIBLE);
        SBPmes48EZ.setVisibility(View.INVISIBLE);
        SBPmes60EZ.setVisibility(View.INVISIBLE);
        SBPmes13EM.setVisibility(View.INVISIBLE);
        SBPmes15EM.setVisibility(View.INVISIBLE);
        SBPmes18EM.setVisibility(View.INVISIBLE);
        SBPmes24EM.setVisibility(View.INVISIBLE);
        SBPmes36EM.setVisibility(View.INVISIBLE);
        SBPmes48EM.setVisibility(View.INVISIBLE);
        SBPmes60EM.setVisibility(View.INVISIBLE);
        //СБЕРБАНК ГРЕЙС 6 МЕС
        SBGmes24Z.setVisibility(View.INVISIBLE);
        SBGmes36Z.setVisibility(View.INVISIBLE);
        SBGmes48Z.setVisibility(View.INVISIBLE);
        SBGmes60Z.setVisibility(View.INVISIBLE);
        SBGmes24M.setVisibility(View.INVISIBLE);
        SBGmes36M.setVisibility(View.INVISIBLE);
        SBGmes48M.setVisibility(View.INVISIBLE);
        SBGmes60M.setVisibility(View.INVISIBLE);
        //ЕЖЕМЕСЯЧНЫЕ СБЕРБАНК ГРЕЙС 6 МЕС
        SBGmes24EZ.setVisibility(View.INVISIBLE);
        SBGmes36EZ.setVisibility(View.INVISIBLE);
        SBGmes48EZ.setVisibility(View.INVISIBLE);
        SBGmes60EZ.setVisibility(View.INVISIBLE);
        SBGmes24EM.setVisibility(View.INVISIBLE);
        SBGmes36EM.setVisibility(View.INVISIBLE);
        SBGmes48EM.setVisibility(View.INVISIBLE);
        SBGmes60EM.setVisibility(View.INVISIBLE);
        textPrepaid.setVisibility(View.INVISIBLE);*/

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
                        + "По банкам: 50 руб\n");

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
        Ames6Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");
        Ames12Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");
        Ames24Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");
        Ames36Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");

        Ames6M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");
        Ames12M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");
        Ames24M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");
        Ames36M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");

        Ames6EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 6, priceZ) + rub : "-");
        Ames12EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 12, priceZ) + rub : "-");
        Ames24EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 24, priceZ) + rub : "-");
        Ames36EZ.setText(minBank <= Math.ceil(priceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 36, priceZ) + rub : "-");

        Ames6EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 6, priceM) + rub : "-");
        Ames12EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 12, priceM) + rub : "-");
        Ames24EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 24, priceM) + rub : "-");
        Ames36EM.setText(minBank <= Math.ceil(priceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 36, priceM) + rub : "-");

        //АЛЬФА-РАССРОЧКА
        ARasrochMes4Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES5) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES5)) + rub : "-");
        ARasrochMes5Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES6) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES6)) + rub : "-");

        ARasrochMes4M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES5) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES5)) + rub : "-");
        ARasrochMes5M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES6) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES6)) + rub : "-");

        ARasrochMes4EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES5) ? Math.ceil( (priceZ * MainActivity.prices.A_RASROCH_MES5)/4) + rub : "-");
        ARasrochMes5EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.A_RASROCH_MES6) ? Math.ceil( (priceZ * MainActivity.prices.A_RASROCH_MES6)/5) + rub : "-");

        ARasrochMes4EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES5) && !isPocket ? Math.ceil( (priceM * MainActivity.prices.A_RASROCH_MES5)/4) + rub : "-");
        ARasrochMes5EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.A_RASROCH_MES6) && !isPocket ? Math.ceil( (priceM * MainActivity.prices.A_RASROCH_MES6)/5) + rub : "-");



        //СБЕРБАНК ПРОСТО
        SBPmes13Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");
        SBPmes15Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");
        SBPmes18Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");
        SBPmes24Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");
        SBPmes36Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");
        SBPmes48Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");
        SBPmes60Z.setText(minBank <= Math.ceil(priceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ)) + rub : "-");

        SBPmes13M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");
        SBPmes15M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");
        SBPmes18M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");
        SBPmes24M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");
        SBPmes36M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");
        SBPmes48M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");
        SBPmes60M.setText(minBank <= Math.ceil(priceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM)) + rub : "-");

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
        SBGmes24Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");

        SBGmes24M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");

        SBGmes24EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, (int) (priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, (int) (priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, (int) (priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, (int) (priceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");

        SBGmes24EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, (int) (priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, (int) (priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, (int) (priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, (int) (priceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
    }

    //Вызывается при добовлении предоплаты
    public void setPriceBank(int i) {
        boolean isPocket = MainActivity.nameMeasure.contains("COMFORTPOCKET") || MainActivity.nameMeasure.contains("PREMIUMPOCKET");
        int tmpPriceZ = priceZ - i;
        int tmpPriceM = priceM - i;

        Ames6Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");
        Ames12Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");
        Ames24Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");
        Ames36Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");

        Ames6M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");
        Ames12M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");
        Ames24M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");
        Ames36M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");

        Ames6EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 6, tmpPriceZ) + rub : "-");
        Ames12EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 12, tmpPriceZ) + rub : "-");
        Ames24EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 24, tmpPriceZ) + rub : "-");
        Ames36EZ.setText(minBank <= Math.ceil(tmpPriceZ) ? getPltBank(MainActivity.prices.ALFASTVK, 36, tmpPriceZ) + rub : "-");

        Ames6EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 6, tmpPriceM) + rub : "-");
        Ames12EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 12, tmpPriceM) + rub : "-");
        Ames24EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 24, tmpPriceM) + rub : "-");
        Ames36EM.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? getPltBank(MainActivity.prices.ALFASTVK, 36, tmpPriceM) + rub : "-");


        //АЛЬФА-РАССРОЧКА
        ARasrochMes4Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES5) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES5)) + rub : "-");
        ARasrochMes5Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES6) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES6)) + rub : "-");

        ARasrochMes4M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES5) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES5)) + rub : "-");
        ARasrochMes5M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES6) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES6)) + rub : "-");

        ARasrochMes4EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES5) ? Math.ceil( (tmpPriceZ * MainActivity.prices.A_RASROCH_MES5)/4) + rub : "-");
        ARasrochMes5EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.A_RASROCH_MES6) ? Math.ceil( (tmpPriceZ * MainActivity.prices.A_RASROCH_MES6)/5) + rub : "-");

        ARasrochMes4EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES5) && !isPocket ? Math.ceil( (tmpPriceM * MainActivity.prices.A_RASROCH_MES5)/4) + rub : "-");
        ARasrochMes5EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.A_RASROCH_MES6) && !isPocket ? Math.ceil( (tmpPriceM * MainActivity.prices.A_RASROCH_MES6)/5) + rub : "-");


        //СБЕРБАНК ПРОСТО
        SBPmes13Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");
        SBPmes15Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");
        SBPmes18Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");
        SBPmes24Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");
        SBPmes36Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");
        SBPmes48Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");
        SBPmes60Z.setText(minBank <= Math.ceil(tmpPriceZ) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ)) + rub : "-");

        SBPmes13M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");
        SBPmes15M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");
        SBPmes18M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");
        SBPmes24M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");
        SBPmes36M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");
        SBPmes48M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");
        SBPmes60M.setText(minBank <= Math.ceil(tmpPriceM) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM)) + rub : "-");

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
        SBGmes24Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");

        SBGmes24M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? ContinePrice.roundUpToNearestTen((int) Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");

        SBGmes24EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, (int) (tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, (int) (tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, (int) (tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.SBERBANKMES_G) ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, (int) (tmpPriceZ * MainActivity.prices.SBERBANKMES_G)) + rub : "-");

        SBGmes24EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 24, (int) (tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes36EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 36, (int) (tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes48EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 48, (int) (tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
        SBGmes60EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.SBERBANKMES_G) && !isPocket ? getPltBank(MainActivity.prices.SBERBANKSTVK, 60, (int) (tmpPriceM * MainActivity.prices.SBERBANKMES_G)) + rub : "-");
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
