package com.wonokoyo.docin.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Voadip implements Serializable {
    private Doc doc;
    private String noOp;
    private String supplier;
    private String tglKirim;
    private ArrayList<ItemVoadip> itemVoadips;

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

    public ArrayList<ItemVoadip> getItemVoadips() {
        return itemVoadips;
    }

    public void setItemVoadips(ArrayList<ItemVoadip> itemVoadips) {
        this.itemVoadips = itemVoadips;
    }
}
