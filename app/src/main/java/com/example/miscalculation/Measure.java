package com.example.miscalculation;

import android.content.res.AssetManager;

import com.example.miscalculation.excelUtill.ExcelCreator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Measure implements Serializable {

    private transient ExcelCreator excelCreator;
    private transient boolean isDoSpecification;
    private transient AssetManager am;

    public Pockets pockets;

    private String versionData;
    private final String versionMiscalculation = " \njuly_17_24";

    private final boolean region;
    private boolean isStand = true;
    private double course;
    private int delivery;
    private int other;
    private int plus;

    private final boolean isPocket;

    private List<String> prodList = new ArrayList<>();
    private List<String> itemInfo = new ArrayList<>();
    private List<Double> prodItemPrice = new ArrayList<>();
    private List<Integer> prodInterest = new ArrayList<>();
    private List<Integer> prodMounting = new ArrayList<>();
    private List<Integer> prodSlopes = new ArrayList<>();
    private List<Integer> prodWidth = new ArrayList<>();

    //Конструктор копирования замера c пакетами (Вызывается из MainActivity)
    public Measure(Measure measure, boolean isPocket) {
        this.versionData = measure.versionData;
        this.region = measure.region;
        this.delivery = measure.delivery;
        this.other = measure.other;
        this.plus = measure.plus;
        this.course = measure.course;

        this.prodList = new ArrayList<>(measure.prodList);
        this.itemInfo = new ArrayList<>(measure.itemInfo);
        this.prodItemPrice = new ArrayList<>(measure.prodItemPrice);
        this.prodInterest = new ArrayList<>(measure.prodInterest);
        this.prodMounting = new ArrayList<>(measure.prodMounting);
        this.prodSlopes = new ArrayList<>(measure.prodSlopes);
        this.pockets = new Pockets(measure.pockets);

        this.prodWidth = new ArrayList<>(measure.prodWidth);
        this.isPocket = measure.isPocket();
    }

    //Конструктор копирования замера без пакетов (Вызывается из класса пакетов)
    public Measure(Measure measure) {
        this.versionData = measure.versionData;
        this.region = measure.region;
        this.delivery = measure.delivery;
        this.other = measure.other;
        this.plus = measure.plus;
        this.course = measure.course;

        this.prodList = new ArrayList<>(measure.prodList);
        this.itemInfo = new ArrayList<>(measure.itemInfo);
        this.prodItemPrice = new ArrayList<>(measure.prodItemPrice);
        this.prodInterest = new ArrayList<>(measure.prodInterest);
        this.prodMounting = new ArrayList<>(measure.prodMounting);
        this.prodSlopes = new ArrayList<>(measure.prodSlopes);
        this.pockets = null;

        this.prodWidth = new ArrayList<>(measure.prodWidth);
        this.isPocket = measure.isPocket();
    }

    //Регион - true
    //Минск - false
    //Конструктор нового пустого замера
    public Measure(boolean region, boolean isPocket, boolean ids, AssetManager am) {
        this.versionData = MainActivity.prices.version + versionMiscalculation;
        this.course = MainActivity.prices.course;
        this.delivery = MainActivity.prices.delivery;
        ProductList.delivery = this.delivery;
        this.region = region;
        this.isPocket = isPocket;

        this.isDoSpecification = ids;
        this.am = am;

        if (isDoSpecification) {
            this.excelCreator = new ExcelCreator(am);
        }
        else {
            this.excelCreator = null;
        }
    }

    public void setCourse(double d) {
        this.course = d;
    }

    //Вызывается добовляя новое изделие
    public void setProdList (String itemName, String itemInfo, Double d, Integer i, Integer w) {
        prodList.add(itemName);
        this.itemInfo.add(itemInfo);
        prodItemPrice.add(d);
        prodInterest.add(i);
        prodMounting.add(0);
        prodSlopes.add(0);

        prodWidth.add(w);

        //Если делаем спецификацию и не добавляем начало\конец блока
        if (isDoSpecification && !itemName.contains("*****") && !itemName.matches("\\d")) {
            if(itemName.contains("Подоконник")) {
                excelCreator.incrementCountPod();
            }
            else if(itemName.contains("Отлив")) {
                excelCreator.incrementCountOtl();
            }
            else if(itemName.contains("М/С")) {
                excelCreator.incrementCountMS();
            }
            else if(itemName.contains("оединит")) {
                excelCreator.incrementCountSoed();
            }
            else if(itemName.contains("асширит")) {
                excelCreator.incrementCountRash();
            }
            else {
                try {
                    excelCreator.addWindow(excelCreator.getTmpPicturePath(), excelCreator.getTmpHeight(), excelCreator.getTmpWidth(), itemInfo);
                } catch (Throwable e) {
                    //Do something...
                }
            }
        }
    }
    //Вызывается при добовлении работ
    public void setProdList (String s, String s1, Integer m, Integer sl) {
        prodList.add(s);
        itemInfo.add(s1);
        prodItemPrice.add(0.0);
        prodInterest.add(0);
        prodMounting.add(m);
        prodSlopes.add(sl);

        prodWidth.add(0);

    }

    //Вызывается добовляя новое изделие в блок из списка
    public void setProdList (String itemName, String itemInfo, Double d, Integer i, Integer w, int indexOfAddToBlock) {
        prodList.add(indexOfAddToBlock, itemName);
        this.itemInfo.add(indexOfAddToBlock, itemInfo);
        prodItemPrice.add(indexOfAddToBlock, d);
        prodInterest.add(indexOfAddToBlock, i);
        prodMounting.add(indexOfAddToBlock, 0);
        prodSlopes.add(indexOfAddToBlock, 0);

        prodWidth.add(indexOfAddToBlock, w);

        if (isDoSpecification && !itemName.contains("*****") && !itemName.matches("\\d")) {
            if(itemName.contains("Подоконник")) {
                excelCreator.incrementCountPod();
            }
            else if(itemName.contains("Отлив")) {
                excelCreator.incrementCountOtl();
            }
            else if(itemName.contains("М/С")) {
                excelCreator.incrementCountMS();
            }
            else if(itemName.contains("оединит")) {
                excelCreator.incrementCountSoed();
            }
            else if(itemName.contains("асширит")) {
                excelCreator.incrementCountRash();
            }
            else {
                try {
                    excelCreator.addWindow(excelCreator.getTmpPicturePath(), excelCreator.getTmpHeight(), excelCreator.getTmpWidth(), itemInfo);
                } catch (Throwable e) {
                    //Do something...
                }
            }
        }
    }

    //Вызывется при открытии сохраненного замера
    public void getProdList() {
        ProductList.addProdLst(delivery, other, plus);

        for (int i = 0; i < prodList.size();i++) {
            ProductList.addProdLst(prodList.get(i), prodItemPrice.get(i), prodInterest.get(i), prodMounting.get(i), prodSlopes.get(i));
        }
    }

    public int getProdWidth(int i) {
        return prodWidth.get(i);
    }

    //Вызывается из листа при нажатии на изделие в списке
    public String getItemInfo(int i) {
        return itemInfo.get(i);
    }

    public int getItemInfoSize() {
        return itemInfo.size();
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }

    public void removeItem(int p) {
        prodList.remove(p);
        itemInfo.remove(p);
        prodItemPrice.remove(p);
        prodInterest.remove(p);
        prodMounting.remove(p);
        prodSlopes.remove(p);
        prodWidth.remove(p);
    }

    public void clearAll() {
        prodList.clear();
        itemInfo.clear();
        prodItemPrice.clear();
        prodInterest.clear();
        prodMounting.clear();
        prodSlopes.clear();
        prodWidth.clear();
        delivery = MainActivity.prices.delivery;
        other = 0;
        plus = 0;
    }

    //Вызывается при инициализации региона
    public boolean getRegion() {
        return region;
    }

    public double getCourse() {
        return course;
    }

    //Вызывается при изменении интереса в балконном блоке или полукруглой раме
    public void setInterest(int index, int interest) {
        prodInterest.set(index, interest);
    }

    //Вызывает при просчете стоимости (На данный момент только в пакете)
    public double getPrice() {
        double sum = 0;
        for(Double d : prodItemPrice) {
            sum+=d;
        }
        return sum;
    }

    //Вызывает при просчете стоимости (На данный момент только в пакете)
    public int getInterest() {
        int sum = 0;
        for(int d : prodInterest) {
            sum+=d;
        }
        return sum;
    }

    //Вызывает при просчете стоимости (На данный момент только в пакете)
    public int getSlopes() {
        int sum = 0;
        for(int d : prodSlopes) {
            sum+=d;
        }
        return sum;
    }

    //Вызывает при просчете стоимости (На данный момент только в пакете)
    public int getMounting() {
        int sum = 0;
        for(int d : prodMounting) {
            sum+=d;
        }
        return sum;
    }

    public int getDelivery() {
        return delivery;
    }

    public int getOther() {
        return other;
    }

    public int getPlus() {
        return plus;
    }

    public boolean isPocket() {
        return this.isPocket;
    }

    public AssetManager getAm() {
        return am;
    }

    public ExcelCreator getExcelCreator() {
        return excelCreator;
    }

    public boolean getIsDoSpecification() {
        return this.isDoSpecification;
    }

    public boolean isStand() {
        return isStand;
    }

    public void setStand(boolean stand) {
        isStand = stand;
    }
}
