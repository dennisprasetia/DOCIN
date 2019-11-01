package com.wonokoyo.docin.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Doc implements Serializable {
    private String noOpDoc;
    private String tanggalDoc;
    private String mitra;
    private String noreg;
    private int kandang;
    private String alamat;
    private int populasi;
    private int jumlahBox;
    private ArrayList<Voadip> voadips;

    public Doc() {

    }

    public String getNoOpDoc() {
        return noOpDoc;
    }

    public void setNoOpDoc(String noOpDoc) {
        this.noOpDoc = noOpDoc;
    }

    public String getTanggalDoc() {
        return tanggalDoc;
    }

    public void setTanggalDoc(String tanggalDoc) {
        this.tanggalDoc = tanggalDoc;
    }

    public String getMitra() {
        return mitra;
    }

    public void setMitra(String mitra) {
        this.mitra = mitra;
    }

    public String getNoreg() {
        return noreg;
    }

    public void setNoreg(String noreg) {
        this.noreg = noreg;
    }

    public int getKandang() {
        return kandang;
    }

    public void setKandang(int kandang) {
        this.kandang = kandang;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getPopulasi() {
        return populasi;
    }

    public void setPopulasi(int populasi) {
        this.populasi = populasi;
    }

    public int getJumlahBox() {
        return jumlahBox;
    }

    public void setJumlahBox(int jumlahBox) {
        this.jumlahBox = jumlahBox;
    }

    public ArrayList<Voadip> getVoadips() {
        return voadips;
    }

    public void setVoadips(ArrayList<Voadip> voadips) {
        this.voadips = voadips;
    }
}
