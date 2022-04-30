package com.example.miscalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class ChangeActivity extends AppCompatActivity {

    static boolean addFromList = false;

    static TextView version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        version = findViewById(R.id.version);
        version.setText("Версия от " + MainActivity.prices.version);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        final Intent prodListBut = new Intent(ChangeActivity.this, ProductList.class);
        final Intent addWindowAct = new Intent(ChangeActivity.this, AddWindowActivity.class);
        final Intent addAluminWindowAct = new Intent(ChangeActivity.this, AddAluminWindowActivity.class);
        final Intent addDopAct = new Intent(ChangeActivity.this, AddDopActivity.class);
        final Intent addDoorAct = new Intent(ChangeActivity.this, AddDoorActivity.class);
        final Intent addWork = new Intent(ChangeActivity.this, AddWorkActivity.class);

        final Button setTypeButton = findViewById(R.id.button_addType);
        final Button setAluminButton = findViewById(R.id.button_addAluminWindow);
        final Button setDopButton = findViewById(R.id.button_addDop);
        final Button setDoorButton = findViewById(R.id.button_addDoor);
        final Button setWork = findViewById(R.id.button_addWork);
        final Button prodLstBut = findViewById(R.id.button_ProdLst);

        //Добавляем пакеты, в активные замеры
        if (MainActivity.hashMap.get(MainActivity.nameMeasure).pockets == null) {
            MainActivity.hashMap.get(MainActivity.nameMeasure).pockets = new Pockets(MainActivity.hashMap.get(MainActivity.nameMeasure).getRegion());
        }


//---------------------------------КНОПКИ------------------------

        setTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(addWindowAct);

            }
        });
//__________________________________________________________________________________________________
        setAluminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(addAluminWindowAct);

            }
        });

//__________________________________________________________________________________________________
        setDopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(addDopAct);

            }
        });

//__________________________________________________________________________________________________

        setDoorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(addDoorAct);

            }
        });

//__________________________________________________________________________________________________
        prodLstBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Если все обычно
                if(!addFromList) {
                    v.startAnimation(animAlpha);
                    startActivity(prodListBut);
                }
                //если было выбрано добавить в блок
                else {
                    onBackPressed();
                }

            }
        });

//__________________________________________________________________________________________________
        setWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);
                startActivity(addWork);

            }
        });
//-------------------------------------------------------------------------------------
    }
}
