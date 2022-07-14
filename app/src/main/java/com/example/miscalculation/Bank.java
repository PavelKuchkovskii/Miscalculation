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
    static TextView Ames12Z;
    static TextView Ames18Z;
    static TextView Ames24Z;
    static TextView Ames36Z;
    static TextView Ames48Z;

    static TextView Ames12M;
    static TextView Ames18M;
    static TextView Ames24M;
    static TextView Ames36M;
    static TextView Ames48M;

    //ЕЖЕМЕСЯЧНЫЕ АЛЬФА
    static TextView Ames12EZ;
    static TextView Ames18EZ;
    static TextView Ames24EZ;
    static TextView Ames36EZ;
    static TextView Ames48EZ;

    static TextView Ames12EM;
    static TextView Ames18EM;
    static TextView Ames24EM;
    static TextView Ames36EM;
    static TextView Ames48EM;

    //ДОБРОБЫТ
    static TextView Dmes6Z;
    static TextView Dmes12Z;
    static TextView Dmes18Z;
    static TextView Dmes24Z;
    static TextView Dmes36Z;

    static TextView Dmes6M;
    static TextView Dmes12M;
    static TextView Dmes18M;
    static TextView Dmes24M;
    static TextView Dmes36M;

    //ЕЖЕМЕСЯЧНЫЕ ДОБРОБЫТ
    static TextView Dmes6EZ;
    static TextView Dmes12EZ;
    static TextView Dmes18EZ;
    static TextView Dmes24EZ;
    static TextView Dmes36EZ;

    static TextView Dmes6EM;
    static TextView Dmes12EM;
    static TextView Dmes18EM;
    static TextView Dmes24EM;
    static TextView Dmes36EM;


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
        Ames12Z = findViewById(R.id.Ames12Z);
        Ames18Z = findViewById(R.id.Ames18Z);
        Ames24Z = findViewById(R.id.Ames24Z);
        Ames36Z = findViewById(R.id.Ames36Z);
        Ames48Z = findViewById(R.id.Ames48Z);

        Ames12M = findViewById(R.id.Ames12M);
        Ames18M = findViewById(R.id.Ames18M);
        Ames24M = findViewById(R.id.Ames24M);
        Ames36M = findViewById(R.id.Ames36M);
        Ames48M = findViewById(R.id.Ames48M);

        //ЕЖЕМЕСЯЧНЫЕ АЛЬФАБАНК
        Ames12EZ = findViewById(R.id.Ames12EZ);
        Ames18EZ = findViewById(R.id.Ames18EZ);
        Ames24EZ = findViewById(R.id.Ames24EZ);
        Ames36EZ = findViewById(R.id.Ames36EZ);
        Ames48EZ = findViewById(R.id.Ames48EZ);

        Ames12EM = findViewById(R.id.Ames12EM);
        Ames18EM = findViewById(R.id.Ames18EM);
        Ames24EM = findViewById(R.id.Ames24EM);
        Ames36EM = findViewById(R.id.Ames36EM);
        Ames48EM = findViewById(R.id.Ames48EM);


        //ДОБРОБЫТ
        Dmes6Z = findViewById(R.id.Dmes6Z);
        Dmes12Z = findViewById(R.id.Dmes12Z);
        Dmes18Z = findViewById(R.id.Dmes18Z);
        Dmes24Z = findViewById(R.id.Dmes24Z);
        Dmes36Z = findViewById(R.id.Dmes36Z);

        Dmes6M = findViewById(R.id.Dmes6M);
        Dmes12M = findViewById(R.id.Dmes12M);
        Dmes18M = findViewById(R.id.Dmes18M);
        Dmes24M = findViewById(R.id.Dmes24M);
        Dmes36M = findViewById(R.id.Dmes36M);

        //ЕЖЕМЕСЯЧНЫЕ ДОБРОБЫТ
        Dmes6EZ = findViewById(R.id.Dmes6EZ);
        Dmes12EZ = findViewById(R.id.Dmes12EZ);
        Dmes18EZ = findViewById(R.id.Dmes18EZ);
        Dmes24EZ = findViewById(R.id.Dmes24EZ);
        Dmes36EZ = findViewById(R.id.Dmes36EZ);

        Dmes6EM = findViewById(R.id.Dmes6EM);
        Dmes12EM = findViewById(R.id.Dmes12EM);
        Dmes18EM = findViewById(R.id.Dmes18EM);
        Dmes24EM = findViewById(R.id.Dmes24EM);
        Dmes36EM = findViewById(R.id.Dmes36EM);

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

        Ames12Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES12) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES12) + rub : "-");
        Ames18Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES18) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES18) + rub : "-");
        Ames24Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES24) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES24) + rub : "-");
        Ames36Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES36) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES36) + rub : "-");
        Ames48Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES48) ? (int) Math.ceil(priceZ * MainActivity.prices.AMES48) + rub : "-");

        Ames12M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES12) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES12) + rub : "-");
        Ames18M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES18) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES18) + rub : "-");
        Ames24M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES24) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES24) + rub : "-");
        Ames36M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES36) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES36) + rub : "-");
        Ames48M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES48) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.AMES48) + rub : "-");

        Ames12EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES12) ? getPltAlfa(MainActivity.prices.ALFASTVK, 12, priceZ) + rub : "-");
        Ames18EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES18) ? getPltAlfa(MainActivity.prices.ALFASTVK, 18, priceZ) + rub : "-");
        Ames24EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES24) ? getPltAlfa(MainActivity.prices.ALFASTVK, 24, priceZ) + rub : "-");
        Ames36EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES36) ? getPltAlfa(MainActivity.prices.ALFASTVK, 36, priceZ) + rub : "-");
        Ames48EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.AMES48) ? getPltAlfa(MainActivity.prices.ALFASTVK, 48, priceZ) + rub : "-");

        Ames12EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES12) && !isPocket ? getPltAlfa(MainActivity.prices.ALFASTVK, 12, priceM) + rub : "-");
        Ames18EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES18) && !isPocket ? getPltAlfa(MainActivity.prices.ALFASTVK, 18, priceM) + rub : "-");
        Ames24EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES24) && !isPocket ? getPltAlfa(MainActivity.prices.ALFASTVK, 24, priceM) + rub : "-");
        Ames36EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES36) && !isPocket ? getPltAlfa(MainActivity.prices.ALFASTVK, 36, priceM) + rub : "-");
        Ames48EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.AMES48) && !isPocket ? getPltAlfa(MainActivity.prices.ALFASTVK, 48, priceM) + rub : "-");



        //ДОБРОБЫТ
        Dmes6Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.DMES6) ? (int) Math.ceil(priceZ * MainActivity.prices.DMES6) + rub : "-");
        Dmes12Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.DMES12) ? (int) Math.ceil(priceZ * MainActivity.prices.DMES12) + rub : "-");
        Dmes18Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.DMES18) ? (int) Math.ceil(priceZ * MainActivity.prices.DMES18) + rub : "-");
        Dmes24Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.DMES24) ? (int) Math.ceil(priceZ * MainActivity.prices.DMES24) + rub : "-");
        Dmes36Z.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.DMES36) ? (int) Math.ceil(priceZ * MainActivity.prices.DMES36) + rub : "-");

        Dmes6M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.DMES6) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.DMES6) + rub : "-");
        Dmes12M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.DMES12) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.DMES12) + rub : "-");
        Dmes18M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.DMES18) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.DMES18) + rub : "-");
        Dmes24M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.DMES24) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.DMES24) + rub : "-");
        Dmes36M.setText(minBank <= Math.ceil(priceM * MainActivity.prices.DMES36) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.DMES36) + rub : "-");

        Dmes6EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.DMES6) ? (int) Math.ceil(priceZ * MainActivity.prices.DMES6 * MainActivity.prices.DMES_E6)/6 + rub : "-");
        Dmes12EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.DMES12) ? (int) Math.ceil(priceZ * MainActivity.prices.DMES12 * MainActivity.prices.DMES_E12)/12 + rub : "-");
        Dmes18EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.DMES18) ? (int) Math.ceil(priceZ * MainActivity.prices.DMES18 * MainActivity.prices.DMES_E18)/18 + rub : "-");
        Dmes24EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.DMES24) ? (int) Math.ceil(priceZ * MainActivity.prices.DMES24 * MainActivity.prices.DMES_E24)/24 + rub : "-");
        Dmes36EZ.setText(minBank <= Math.ceil(priceZ * MainActivity.prices.DMES36) ? (int) Math.ceil(priceZ * MainActivity.prices.DMES36 * MainActivity.prices.DMES_E36)/36 + rub : "-");

        Dmes6EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.DMES6) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.DMES6 * MainActivity.prices.DMES_E6)/6 + rub : "-");
        Dmes12EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.DMES12) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.DMES12 * MainActivity.prices.DMES_E12)/12 + rub : "-");
        Dmes18EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.DMES18) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.DMES18 * MainActivity.prices.DMES_E18)/18 + rub : "-");
        Dmes24EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.DMES24) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.DMES24 * MainActivity.prices.DMES_E24)/24 + rub : "-");
        Dmes36EM.setText(minBank <= Math.ceil(priceM * MainActivity.prices.DMES36) && !isPocket ? (int) Math.ceil(priceM * MainActivity.prices.DMES36 * MainActivity.prices.DMES_E36)/36 + rub : "-");


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


        Ames12Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES12) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES12) + rub : "-");
        Ames18Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES18) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES18) + rub : "-");
        Ames24Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES24) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES24) + rub : "-");
        Ames36Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES36) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES36) + rub : "-");
        Ames48Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES48) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.AMES48) + rub : "-");

        Ames12M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES12) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES12) + rub : "-");
        Ames18M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES18) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES18) + rub : "-");
        Ames24M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES24) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES24) + rub : "-");
        Ames36M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES36) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES36) + rub : "-");
        Ames48M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES48) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.AMES48) + rub : "-");

        Ames12EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES12) ? getPltAlfa(MainActivity.prices.ALFASTVK, 12, tmpPriceZ) + rub : "-");
        Ames18EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES18) ? getPltAlfa(MainActivity.prices.ALFASTVK, 18, tmpPriceZ) + rub : "-");
        Ames24EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES24) ? getPltAlfa(MainActivity.prices.ALFASTVK, 24, tmpPriceZ) + rub : "-");
        Ames36EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES36) ? getPltAlfa(MainActivity.prices.ALFASTVK, 36, tmpPriceZ) + rub : "-");
        Ames48EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.AMES48) ? getPltAlfa(MainActivity.prices.ALFASTVK, 48, tmpPriceZ) + rub : "-");

        Ames12EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES12) && !isPocket ? getPltAlfa(MainActivity.prices.ALFASTVK, 12, tmpPriceM) + rub : "-");
        Ames18EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES18) && !isPocket ? getPltAlfa(MainActivity.prices.ALFASTVK, 18, tmpPriceM) + rub : "-");
        Ames24EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES24) && !isPocket ? getPltAlfa(MainActivity.prices.ALFASTVK, 24, tmpPriceM) + rub : "-");
        Ames36EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES36) && !isPocket ? getPltAlfa(MainActivity.prices.ALFASTVK, 36, tmpPriceM) + rub : "-");
        Ames48EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.AMES48) && !isPocket ? getPltAlfa(MainActivity.prices.ALFASTVK, 48, tmpPriceM) + rub : "-");


        //ДОБРОБЫТ
        Dmes6Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.DMES6) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.DMES6) + rub : "-");
        Dmes12Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.DMES12) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.DMES12) + rub : "-");
        Dmes18Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.DMES18) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.DMES18) + rub : "-");
        Dmes24Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.DMES24) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.DMES24) + rub : "-");
        Dmes36Z.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.DMES36) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.DMES36) + rub : "-");

        Dmes6M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.DMES6) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.DMES6) + rub : "-");
        Dmes12M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.DMES12) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.DMES12) + rub : "-");
        Dmes18M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.DMES18) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.DMES18) + rub : "-");
        Dmes24M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.DMES24) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.DMES24) + rub : "-");
        Dmes36M.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.DMES36) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.DMES36) + rub : "-");

        Dmes6EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.DMES6) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.DMES6 * MainActivity.prices.DMES_E6)/6 + rub : "-");
        Dmes12EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.DMES12) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.DMES12 * MainActivity.prices.DMES_E12)/12 + rub : "-");
        Dmes18EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.DMES18) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.DMES18 * MainActivity.prices.DMES_E18)/18 + rub : "-");
        Dmes24EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.DMES24) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.DMES24 * MainActivity.prices.DMES_E24)/24 + rub : "-");
        Dmes36EZ.setText(minBank <= Math.ceil(tmpPriceZ * MainActivity.prices.DMES36) ? (int) Math.ceil(tmpPriceZ * MainActivity.prices.DMES36 * MainActivity.prices.DMES_E36)/36 + rub : "-");

        Dmes6EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.DMES6) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.DMES6 * MainActivity.prices.DMES_E6)/6 + rub : "-");
        Dmes12EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.DMES12) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.DMES12 * MainActivity.prices.DMES_E12)/12 + rub : "-");
        Dmes18EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.DMES18) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.DMES18 * MainActivity.prices.DMES_E18)/18 + rub : "-");
        Dmes24EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.DMES24) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.DMES24 * MainActivity.prices.DMES_E24)/24 + rub : "-");
        Dmes36EM.setText(minBank <= Math.ceil(tmpPriceM * MainActivity.prices.DMES36) && !isPocket ? (int) Math.ceil(tmpPriceM * MainActivity.prices.DMES36 * MainActivity.prices.DMES_E36)/36 + rub : "-");



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
    public static int getPltAlfa(double c, int n, int sum) {
        double i = c/12/100;
        double K = (i * Math.pow(1 + i,n))/(Math.pow(1 + i,n) - 1);
        return (int) Math.ceil(K * sum);
    }

}
