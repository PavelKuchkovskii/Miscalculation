package handles;

import java.io.Serializable;

public class HandleFurnit implements Serializable {

    private String name;
    private double price;
    private boolean visible = true;

    private boolean HANDLE = false;
    private boolean NAKLADKA = false;
    private boolean HVATALKA = false;

    final boolean rotoFlag;


    //i - идентификатор
    //0 - ручка
    //1 - накладка
    //2 - хваталка
    public HandleFurnit(String s, double d, int i, boolean rotoFlag) {
        this.name = s;
        this.price = d;
        this.rotoFlag = rotoFlag;

        if(i == 0) {
            this.HANDLE = true;
        }
        else if (i == 1) {
            this.NAKLADKA = true;
        }
        else {
            this.HVATALKA = true;
        }
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public boolean getHANDLE() {
        return this.HANDLE;
    }

    public boolean getHVATALKA() {
        return this.HVATALKA;
    }

    public boolean getNAKLADKA() {
        return this.NAKLADKA;
    }

    public boolean getROTO() {
        return this.rotoFlag;
    }
}
