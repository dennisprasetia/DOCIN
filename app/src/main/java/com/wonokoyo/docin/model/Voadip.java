package com.wonokoyo.docin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Voadip implements Serializable {
    private Doc doc;

    @SerializedName("noOp")
    @Expose
    private String noOp;

    @SerializedName("supplier")
    @Expose
    private String supplier;

    @SerializedName("tglKirim")
    @Expose
    private String tglKirim;

    @SerializedName("itemVoadip")
    @Expose
    private List<ItemVoadip> itemVoadips;

    public Voadip() {

    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public String getNoOp() {
        return noOp;
    }

    public void setNoOp(String noOp) {
        this.noOp = noOp;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getTglKirim() {
        return tglKirim;
    }

    public void setTglKirim(String tglKirim) {
        this.tglKirim = tglKirim;
    }

    public List<ItemVoadip> getItemVoadips() {
        return itemVoadips;
    }

    public void setItemVoadips(List<ItemVoadip> itemVoadips) {
        this.itemVoadips = itemVoadips;
    }
}
