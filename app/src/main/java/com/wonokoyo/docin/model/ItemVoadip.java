package com.wonokoyo.docin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemVoadip {
    private Voadip voadip;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("packing")
    @Expose
    private String packing;

    @SerializedName("ammount")
    @Expose
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
