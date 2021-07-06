package com.example.miscalculation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Measure implements Serializable {

    private final String version = "1.2P";

    private boolean region = false;

    private double course = 2.65;
    private int delivery = 35;
    private int other;

    private List<String> prodList = new ArrayList<>();
    private List<String> itemInfo = new ArrayList<>();
    private List<Double> prodItemPrice = new ArrayList<>();
    private List<Integer> prodInterest = new ArrayList<>();
    private List<Integer> prodMounting = new ArrayList<>();
    private List<Integer> prodSlopes = new ArrayList<>();

    private List<Integer> prodWidth = new ArrayList<>();

    public Measure(Measure measure) {
        this.region = measure.region;
        this.delivery = measure.delivery;
        this.other = measure.other;

        this.prodList = new ArrayList<>(measure.prodList);
        this.itemInfo = new ArrayList<>(measure.itemInfo);
        this.prodItemPrice = new ArrayList<>(measure.prodItemPrice);
        this.prodInterest = new ArrayList<>(measure.prodInterest);
        this.prodMounting = new ArrayList<>(measure.prodMounting);
        this.prodSlopes = new ArrayList<>(measure.prodSlopes);

        this.prodWidth = new ArrayList<>(measure.prodWidth);
    }

    public Measure() {
    }

    public void setCourse(double d) {
        this.course = d;
    }

    //Вызывается добовляя новое изделие
    public void setProdList (String s, String s1, Double d, Integer i, Integer w) {
        prodList.add(s);
        itemInfo.add(s1);
        prodItemPrice.add(d);
        prodInterest.add(i);
        prodMounting.add(0);
        prodSlopes.add(0);

        prodWidth.add(w);
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
    public void setProdList (String s, String s1, Double d, Integer i, Integer w, int indexOfAddToBlock) {
        prodList.add(indexOfAddToBlock, s);
        itemInfo.add(indexOfAddToBlock, s1);
        prodItemPrice.add(indexOfAddToBlock, d);
        prodInterest.add(indexOfAddToBlock, i);
        prodMounting.add(indexOfAddToBlock, 0);
        prodSlopes.add(indexOfAddToBlock, 0);

        prodWidth.add(indexOfAddToBlock, w);
    }

    //Вызывется при открытии сохраненного замера
    public void getProdList() {
        ProductList.addProdLst(delivery, other);

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

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public void setOther(int other) {
        this.other = other;
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
        delivery = 35;
        other = 0;
    }

    //Вызывается при создании новго замера
    //Регион - true
    //Минск - false
    public void setRegion(int i) {
        if (i == 0) {
            region = true;
        }else{
            region = false;
        }
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

}
