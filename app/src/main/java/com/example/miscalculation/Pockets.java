package com.example.miscalculation;

import android.content.res.AssetManager;

public class Pockets {

    private final Measure lite;
    private final Measure standard;
    private final Measure comfort;
    private final Measure premium;

    //Конструктор пакетов
    public Pockets (boolean region, boolean ids, AssetManager am) {
        lite = new Measure(region, true, ids,am);
        standard = new Measure(region,true, ids,am);
        comfort = new Measure(region,true, ids,am);
        premium = new Measure(region,true, ids,am);
    }

    //Копирователь замеров с пакетами
    public Pockets (Pockets pockets) {
        lite = new Measure(pockets.lite);
        standard = new Measure(pockets.standard);
        comfort = new Measure(pockets.comfort);
        premium = new Measure(pockets.premium);
    }

    public void addToPocket(double coff, String itemName, String itemInfo, Double price, Integer itemInterest, Integer width) {
        if (coff == MainActivity.prices.PROPLEX7032W) {
            lite.setProdList(itemName, itemInfo, price, itemInterest, width);
        }
        else if (coff == MainActivity.prices.BB7040W) {
            standard.setProdList(itemName, itemInfo, price, itemInterest, width);
        }
        else if (coff == MainActivity.prices.REHAU7040W) {
            comfort.setProdList(itemName, itemInfo, price, itemInterest, width);
        }
        else {
            premium.setProdList(itemName, itemInfo, price, itemInterest, width);
        }

    }

    //Если добавляют в блок
    public void addToPocket(double coff, String itemName, String itemInfo, double price, int itemInterest, int width, int position) {
        if (coff == MainActivity.prices.PROPLEX7032W) {
            lite.setProdList(itemName, itemInfo, price, itemInterest, width, position);
        }
        else if (coff == MainActivity.prices.BB7040W) {
            standard.setProdList(itemName, itemInfo, price, itemInterest, width, position);
        }
        else if (coff == MainActivity.prices.REHAU7040W) {
            comfort.setProdList(itemName, itemInfo, price, itemInterest, width, position);
        }
        else {
            premium.setProdList(itemName, itemInfo, price, itemInterest, width, position);
        }

    }

    //Если добавляют работы
    public void addToPocket(String s, String s1, Integer m, Integer sl) {
        lite.setProdList(s, s1, m, sl);
        standard.setProdList(s, s1, m, sl);
        comfort.setProdList(s, s1, m, sl);
        premium.setProdList(s, s1, m, sl);
    }

    public void removeItem(int position) {
        lite.removeItem(position);
        standard.removeItem(position);
        comfort.removeItem(position);
        premium.removeItem(position);
    }

    public void clearAll() {
        lite.clearAll();
        standard.clearAll();
        comfort.clearAll();
        premium.clearAll();
    }

    //Вызывается при изменении интереса в балконном блоке или полукруглой раме
    public void setInterest(int index, int interest) {
        lite.setInterest(index, interest);
        standard.setInterest(index, interest);
        comfort.setInterest(index, interest);
        premium.setInterest(index, interest);
    }

    public double getPrice(double coff, boolean b) {
        //true - жел
        //false - мин

        double calcPercent = MainActivity.prices.CALCPERC;

        //Если LITE ПАКЕТ
        if (coff == MainActivity.prices.PROPLEX7032W) {
            //ЕСЛИ ЖЕЛ ЦЕНА
            if (b) {
                return Math.ceil(((lite.getMounting() + lite.getSlopes() + lite.getInterest() + Math.ceil(lite.getPrice()) + lite.getDelivery() + lite.getOther() + lite.getPlus()) * lite.getCourse()) * calcPercent);
            }
            //ЕСЛИ МИН ЦЕНА
            else {
                return Math.ceil(((lite.getMounting() + lite.getSlopes() + (lite.getInterest()/2.0) + Math.ceil(lite.getPrice()) + lite.getDelivery() + lite.getOther()) * lite.getCourse()) * calcPercent);
            }
        }
        //Если STANDARD ПАКЕТ
        else if (coff == MainActivity.prices.BB7040W) {
            //ЕСЛИ ЖЕЛ ЦЕНА
            if (b) {
                return Math.ceil(((standard.getMounting() + standard.getSlopes() + standard.getInterest() + Math.ceil(standard.getPrice()) + standard.getDelivery() + standard.getOther() + standard.getPlus()) * standard.getCourse()) * calcPercent);
            }
            //ЕСЛИ МИН ЦЕНА
            else {
                return Math.ceil(((standard.getMounting() + standard.getSlopes() + (standard.getInterest()/2.0) + Math.ceil(standard.getPrice()) + standard.getDelivery() + standard.getOther()) * standard.getCourse()) * calcPercent);
            }
        }
        //Если COMFORT ПАКЕТ
        else if (coff == MainActivity.prices.REHAU7040W) {
            //ЕСЛИ ЖЕЛ ЦЕНА
            if (b) {
                return Math.ceil(((comfort.getMounting() + comfort.getSlopes() + comfort.getInterest() + Math.ceil(comfort.getPrice()) + comfort.getDelivery() + comfort.getOther() + comfort.getPlus()) * comfort.getCourse()) * calcPercent);
            }
            //ЕСЛИ МИН ЦЕНА
            else {
                return Math.ceil(((comfort.getMounting() + comfort.getSlopes() + (comfort.getInterest()/2.0) + Math.ceil(comfort.getPrice()) + comfort.getDelivery() + comfort.getOther()) * comfort.getCourse()) * calcPercent);
            }
        }
        //Если PREMIUM ПАКЕТ
        else {
            //ЕСЛИ ЖЕЛ ЦЕНА
            if (b) {
                return Math.ceil(((premium.getMounting() + premium.getSlopes() + premium.getInterest() + Math.ceil(premium.getPrice()) + premium.getDelivery() + premium.getOther() + premium.getPlus()) * premium.getCourse()) * calcPercent);
            }
            //ЕСЛИ МИН ЦЕНА
            else {
                return Math.ceil(((premium.getMounting() + premium.getSlopes() + (premium.getInterest()/2.0) + Math.ceil(premium.getPrice()) + premium.getDelivery() + premium.getOther()) * premium.getCourse()) * calcPercent);
            }
        }

    }

    public Measure getLite() {
        return lite;
    }

    public Measure getStandard() {
        return standard;
    }

    public Measure getComfort() {
        return comfort;
    }

    public Measure getPremium() {
        return premium;
    }

}
