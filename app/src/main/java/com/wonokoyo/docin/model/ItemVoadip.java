package com.wonokoyo.docin.model;

public class ItemVoadip {
    private Voadip voadip;
    private String name;
    private String packing;
    private int ammount;

    public ItemVoadip() {

    }

    public Voadip getVoadip() {
        return voadip;
    }

    public void setVoadip(Voadip voadip) {
        this.voadip = voadip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
}
