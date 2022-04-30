package com.example.miscalculation;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Random;

public class PocketsActivity extends AppCompatActivity {

    //true - жел
    //false - мин
    static boolean liteFlag = true;
    static boolean standardFlag = true;
    static boolean comfortFlag = true;
    static boolean premiumFlag = true;

    static TextView pocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pockets);

        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        liteFlag = true;
        standardFlag = true;
        comfortFlag = true;
        premiumFlag = true;


        pocket = findViewById(R.id.pocket);

        TextView priceLitePocket = findViewById(R.id.priceLitePocket);
        TextView priceStandardPocket = findViewById(R.id.priceStandardPocket);
        TextView priceComfortPocket = findViewById(R.id.priceComfortPocket);
        TextView pricePremiumPocket = findViewById(R.id.pricePremiumPocket);

        TextView litePocket = findViewById(R.id.litePocket);
        TextView standardPocket = findViewById(R.id.standardPocket);
        TextView comfortPocket = findViewById(R.id.comfortPocket);
        TextView premiumPocket = findViewById(R.id.premiumPocket);

        View litePocketView = findViewById(R.id.litePocketView);
        View standardPocketView = findViewById(R.id.standardPocketView);
        View comfortPocketView = findViewById(R.id.comfortPocketView);

        Button addLitePocket = findViewById(R.id.button_addLitePocket);
        Button addStandardPocket = findViewById(R.id.button_addStandardPocket);
        Button addComfortPocket = findViewById(R.id.button_addComfortPocket);
        Button addPremiumPocket = findViewById(R.id.button_addPremiumPocket);

        priceLitePocket.setVisibility(View.INVISIBLE);
        priceStandardPocket.setVisibility(View.INVISIBLE);
        priceComfortPocket.setVisibility(View.INVISIBLE);
        pricePremiumPocket.setVisibility(View.INVISIBLE);
        litePocket.setVisibility(View.INVISIBLE);
        standardPocket.setVisibility(View.INVISIBLE);
        comfortPocket.setVisibility(View.INVISIBLE);
        premiumPocket.setVisibility(View.INVISIBLE);
        litePocketView.setVisibility(View.INVISIBLE);
        standardPocketView.setVisibility(View.INVISIBLE);
        comfortPocketView.setVisibility(View.INVISIBLE);
        addLitePocket.setVisibility(View.INVISIBLE);
        addStandardPocket.setVisibility(View.INVISIBLE);
        addComfortPocket.setVisibility(View.INVISIBLE);
        addPremiumPocket.setVisibility(View.INVISIBLE);
        pocket.setVisibility(View.VISIBLE);
        setPocketText();

        //Показываем только если это не пакет
        if (!MainActivity.hashMap.get(MainActivity.nameMeasure).isPocket()) {
            priceLitePocket.setVisibility(View.VISIBLE);
            priceStandardPocket.setVisibility(View.VISIBLE);
            priceComfortPocket.setVisibility(View.VISIBLE);
            pricePremiumPocket.setVisibility(View.VISIBLE);
            litePocket.setVisibility(View.VISIBLE);
            standardPocket.setVisibility(View.VISIBLE);
            comfortPocket.setVisibility(View.VISIBLE);
            premiumPocket.setVisibility(View.VISIBLE);
            litePocketView.setVisibility(View.VISIBLE);
            standardPocketView.setVisibility(View.VISIBLE);
            comfortPocketView.setVisibility(View.VISIBLE);
            addLitePocket.setVisibility(View.VISIBLE);
            addStandardPocket.setVisibility(View.VISIBLE);
            addComfortPocket.setVisibility(View.VISIBLE);
            addPremiumPocket.setVisibility(View.VISIBLE);
            pocket.setVisibility(View.INVISIBLE);
        }


        priceLitePocket.setText(String.valueOf(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getPrice(MainActivity.prices.PROPLEX7032W, liteFlag)));
        priceStandardPocket.setText(String.valueOf(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getPrice(MainActivity.prices.BB7040W, standardFlag)));
        priceComfortPocket.setText(String.valueOf(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getPrice(MainActivity.prices.REHAU7040W, comfortFlag)));
        pricePremiumPocket.setText(String.valueOf(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getPrice(MainActivity.prices.REHAUINTELIO, premiumFlag)));

//==================================================================================================
        litePocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (liteFlag) {
                    liteFlag = false;
                    litePocket.setTextColor(Color.parseColor("#43c4f7"));
                    priceLitePocket.setTextColor(Color.parseColor("#43c4f7"));
                    litePocketView.setBackgroundColor(Color.parseColor("#43c4f7"));
                } else {
                    liteFlag = true;
                    litePocket.setTextColor(Color.parseColor("#f4f743"));
                    priceLitePocket.setTextColor(Color.parseColor("#f4f743"));
                    litePocketView.setBackgroundColor(Color.parseColor("#f4f743"));
                }

                priceLitePocket.setText(String.valueOf(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getPrice(MainActivity.prices.PROPLEX7032W, liteFlag)));

            }
        });
        standardPocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (standardFlag) {
                    standardFlag = false;
                    standardPocket.setTextColor(Color.parseColor("#43c4f7"));
                    priceStandardPocket.setTextColor(Color.parseColor("#43c4f7"));
                    standardPocketView.setBackgroundColor(Color.parseColor("#43c4f7"));
                } else {
                    standardFlag = true;
                    standardPocket.setTextColor(Color.parseColor("#f4f743"));
                    priceStandardPocket.setTextColor(Color.parseColor("#f4f743"));
                    standardPocketView.setBackgroundColor(Color.parseColor("#f4f743"));
                }

                priceStandardPocket.setText(String.valueOf(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getPrice(MainActivity.prices.BB7040W, standardFlag)));

            }
        });
        comfortPocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (comfortFlag) {
                    comfortFlag = false;
                    comfortPocket.setTextColor(Color.parseColor("#43c4f7"));
                    priceComfortPocket.setTextColor(Color.parseColor("#43c4f7"));
                    comfortPocketView.setBackgroundColor(Color.parseColor("#43c4f7"));
                } else {
                    comfortFlag = true;
                    comfortPocket.setTextColor(Color.parseColor("#f4f743"));
                    priceComfortPocket.setTextColor(Color.parseColor("#f4f743"));
                    comfortPocketView.setBackgroundColor(Color.parseColor("#f4f743"));
                }

                priceComfortPocket.setText(String.valueOf(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getPrice(MainActivity.prices.REHAU7040W, comfortFlag)));

            }
        });
        premiumPocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (premiumFlag) {
                    premiumFlag = false;
                    premiumPocket.setTextColor(Color.parseColor("#43c4f7"));
                    pricePremiumPocket.setTextColor(Color.parseColor("#43c4f7"));
                } else {
                    premiumFlag = true;
                    premiumPocket.setTextColor(Color.parseColor("#f4f743"));
                    pricePremiumPocket.setTextColor(Color.parseColor("#f4f743"));
                }

                pricePremiumPocket.setText(String.valueOf(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getPrice(MainActivity.prices.REHAUINTELIO, premiumFlag)));

            }
        });

        addLitePocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);

                MainActivity.hashMap.put(MainActivity.nameMeasure + " LITEPOCKET", new Measure(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getLite()));
                if (MainActivity.isDiffName(MainActivity.nameMeasure + " LITEPOCKET")) {
                    MainActivity.adapterMeasureLst.add(MainActivity.nameMeasure + " LITEPOCKET");
                    MainActivity.adapterMeasureLst.notifyDataSetInvalidated();
                }

                try {
                    writeHash(MainActivity.hashMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });
        addStandardPocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);

                MainActivity.hashMap.put(MainActivity.nameMeasure + " STANDARTPOCKET", new Measure(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getStandard()));
                if (MainActivity.isDiffName(MainActivity.nameMeasure + " STANDARTPOCKET")) {
                    MainActivity.adapterMeasureLst.add(MainActivity.nameMeasure + " STANDARTPOCKET");
                    MainActivity.adapterMeasureLst.notifyDataSetInvalidated();
                }

                try {
                    writeHash(MainActivity.hashMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });
        addComfortPocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);

                MainActivity.hashMap.put(MainActivity.nameMeasure + " COMFORTPOCKET", new Measure(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getComfort()));
                if (MainActivity.isDiffName(MainActivity.nameMeasure + " COMFORTPOCKET")) {
                    MainActivity.adapterMeasureLst.add(MainActivity.nameMeasure + " COMFORTPOCKET");
                    MainActivity.adapterMeasureLst.notifyDataSetInvalidated();
                }

                try {
                    writeHash(MainActivity.hashMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });
        addPremiumPocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animAlpha);

                MainActivity.hashMap.put(MainActivity.nameMeasure + " PREMIUMPOCKET", new Measure(MainActivity.hashMap.get(MainActivity.nameMeasure).pockets.getPremium()));

                if (MainActivity.isDiffName(MainActivity.nameMeasure + " PREMIUMPOCKET")) {
                    MainActivity.adapterMeasureLst.add(MainActivity.nameMeasure + " PREMIUMPOCKET");
                    MainActivity.adapterMeasureLst.notifyDataSetInvalidated();
                }

                try {
                    writeHash(MainActivity.hashMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });

        pocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pocket.setTextColor(Color.parseColor(getRandomColor()));

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        });
//==================================================================================================
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

    public void setPocketText() {
        String name = MainActivity.nameMeasure;
        String s = "У Вас выбран активным пакет: \n";
        if (name.contains("LITEPOCKET")) {
            pocket.setText(s + "LITEPOCKET");
        } else if (name.contains("STANDARTPOCKET")) {
            pocket.setText(s + "STANDARTPOCKET");
        } else if (name.contains("COMFORTPOCKET")) {
            pocket.setText(s + "COMFORTPOCKET");
        } else if (name.contains("PREMIUMPOCKET")) {
            pocket.setText(s + "PREMIUMPOCKET");
        }
    }

    public String getRandomColor() {
        Random random = new Random();
        // Массив из пяти цветов
        String colors[] = {"#CD5C5C","#F08080","#FA8072","#E9967A","#FFA07A","#DC143C","#FF0000","#B22222","#8B0000","#FFC0CB","#FFB6C1",
                "#FF69B4","#FF1493","#C71585","#DB7093","#FFA07A","#FF7F50","#FF6347","#FF4500","#FF8C00","#FFA500",
                "#FFD700","#FFFF00","#FFFFE0","#FFFACD","#FAFAD2","#FFEFD5","#FFE4B5","#FFDAB9","#EEE8AA","#F0E68C",
                "#BDB76B","#E6E6FA","#D8BFD8","#DDA0DD","#EE82EE","#DA70D6","#FF00FF","#FF00FF","#BA55D3","#9370DB",
                "#8A2BE2","#9400D3","#9932CC","#8B008B","#800080","#4B0082","#6A5ACD","#483D8B","#FFF8DC","#FFEBCD",
                "#FFE4C4","#FFDEAD","#F5DEB3","#DEB887","#D2B48C","#BC8F8F","#F4A460","#DAA520","#B8860B","#CD853F",
                "#D2691E","#8B4513","#A0522D","#A52A2A","#800000","#000000","#808080","#C0C0C0","#FFFFFF","#FF00FF",
                "#800080","#FF0000","#800000","#FFFF00","#808000","#00FF00","#008000","#00FFFF","#008080","#0000FF",
                "#000080","#ADFF2F","#7FFF00","#7CFC00","#00FF00","#32CD32","#98FB98","#90EE90","#00FA9A","#00FF7F",
                "#3CB371","#2E8B57","#228B22","#008000","#006400","#9ACD32","#6B8E23","#808000","#556B2F","#66CDAA",
                "#8FBC8F","#20B2AA","#008B8B","#008080","#00FFFF","#00FFFF","#E0FFFF","#AFEEEE","#7FFFD4","#40E0D0",
                "#48D1CC","#00CED1","#5F9EA0","#4682B4","#B0C4DE","#B0E0E6","#ADD8E6","#87CEEB","#87CEFA","#00BFFF",
                "#1E90FF","#6495ED","#7B68EE","#4169E1","#0000FF","#0000CD","#00008B","#000080","#191970","#FFFFFF",
                "#FFFAFA","#F0FFF0","#F5FFFA","#F0FFFF","#F0F8FF","#F8F8FF","#F5F5F5","#FFF5EE","#F5F5DC","#FDF5E6",
                "#FFFAF0","#FFFFF0","#FAEBD7","#FAF0E6","#FFF0F5","#FFE4E1","#DCDCDC","#D3D3D3","#D3D3D3","#C0C0C0",
                "#A9A9A9","#A9A9A9","#808080","#808080","#696969","#696969","#778899","#778899","#708090","#708090",
                "#2F4F4F","#2F4F4F","#000000"};
        int pos = random.nextInt(colors.length);
        return colors[pos];

    }
}