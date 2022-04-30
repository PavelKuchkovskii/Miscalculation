package com.example.miscalculation;

public class Pockets {

    private final Measure lite;
    private final Measure standard;
    private final Measure comfort;
    private final Measure premium;

    public Pockets (boolean region) {
        lite = new Measure(region, true);
        standard = new Measure(region,true);
        comfort = new Measure(region,true);
        premium = new Measure(region,true);
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

        double calcPercent = 1.185;

        //Если LITE ПАКЕТ
        if (coff == MainActivity.prices.PROPLEX7032W) {
            //ЕСЛИ ЖЕЛ ЦЕНА
            if (b) {
                return Math.ceil(((lite.getMounting() + lite.getSlopes() + lite.getInterest() + lite.getPrice() + lite.getDelivery() + lite.getOther()) * lite.getCourse()) * calcPercent);
            }
            //ЕСЛИ МИН ЦЕНА
            else {
                return Math.ceil(((lite.getMounting() + lite.getSlopes() + (lite.getInterest()/2.0) + lite.getPrice() + lite.getDelivery() + lite.getOther()) * lite.getCourse()) * calcPercent);
            }
        }
        //Если STANDARD ПАКЕТ
        else if (coff == MainActivity.prices.BB7040W) {
            //ЕСЛИ ЖЕЛ ЦЕНА
            if (b) {
                return Math.ceil(((standard.getMounting() + standard.getSlopes() + standard.getInterest() + standard.getPrice() + standard.getDelivery() + standard.getOther()) * standard.getCourse()) * calcPercent);
            }
            //ЕСЛИ МИН ЦЕНА
            else {
                return Math.ceil(((standard.getMounting() + standard.getSlopes() + (standard.getInterest()/2.0) + standard.getPrice() + standard.getDelivery() + standard.getOther()) * standard.getCourse()) * calcPercent);
            }
        }
        //Если COMFORT ПАКЕТ
        else if (coff == MainActivity.prices.REHAU7040W) {
            //ЕСЛИ ЖЕЛ ЦЕНА
            if (b) {
                return Math.ceil(((comfort.getMounting() + comfort.getSlopes() + comfort.getInterest() + comfort.getPrice() + comfort.getDelivery() + comfort.getOther()) * comfort.getCourse()) * calcPercent);
            }
            //ЕСЛИ МИН ЦЕНА
            else {
                return Math.ceil(((comfort.getMounting() + comfort.getSlopes() + (comfort.getInterest()/2.0) + comfort.getPrice() + comfort.getDelivery() + comfort.getOther()) * comfort.getCourse()) * calcPercent);
            }
        }
        //Если PREMIUM ПАКЕТ
        else {
            //ЕСЛИ ЖЕЛ ЦЕНА
            if (b) {
                return Math.ceil(((premium.getMounting() + premium.getSlopes() + premium.getInterest() + premium.getPrice() + premium.getDelivery() + premium.getOther()) * premium.getCourse()) * calcPercent);
            }
            //ЕСЛИ МИН ЦЕНА
            else {
                return Math.ceil(((premium.getMounting() + premium.getSlopes() + (premium.getInterest()/2.0) + premium.getPrice() + premium.getDelivery() + premium.getOther()) * premium.getCourse()) * calcPercent);
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
