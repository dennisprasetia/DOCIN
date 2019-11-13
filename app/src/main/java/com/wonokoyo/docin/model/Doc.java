package com.wonokoyo.docin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Doc implements Serializable {
    @SerializedName("noOpDoc")
    @Expose
    private String noOpDoc;

    @SerializedName("tanggalDoc")
    @Expose
    private String tanggalDoc;

    @SerializedName("mitra")
    @Expose
    private String mitra;

    @SerializedName("noreg")
    @Expose
    private String noreg;

    @SerializedName("kandang")
    @Expose
    private int kandang;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("populasi")
    @Expose
    private int populasi;

    @SerializedName("jumlahBox")
    @Expose
    private int jumlahBox;

    @SerializedName("nopol")
    @Expose
    private String nopol;

    @SerializedName("sopir")
    @Expose
    private String sopir;

    @SerializedName("kedatangan")
    @Expose
    private String kedatangan;

    private String noSj;
    private String jenis;
    private int mati;
    private int ekorTerima;
    private double bbRata;
    private String keterangan;
    private String url;
    private String urlSign;
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

    public String getNoSj() {
        return noSj;
    }

    public void setNoSj(String noSj) {
        this.noSj = noSj;
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

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getSopir() {
        return sopir;
    }

    public void setSopir(String sopir) {
        this.sopir = sopir;
    }

    public String getKedatangan() {
        return kedatangan;
    }

    public void setKedatangan(String kedatangan) {
        this.kedatangan = kedatangan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getMati() {
        return mati;
    }

    public void setMati(int mati) {
        this.mati = mati;
    }

    public int getEkorTerima() {
        return ekorTerima;
    }

    public void setEkorTerima(int ekorTerima) {
        this.ekorTerima = ekorTerima;
    }

    public double getBbRata() {
        return bbRata;
    }

    public void setBbRata(double bbRata) {
        this.bbRata = bbRata;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlSign() {
        return urlSign;
    }

    public void setUrlSign(String urlSign) {
        this.urlSign = urlSign;
    }

    public void setVoadips(ArrayList<Voadip> voadips) {
        this.voadips = voadips;
    }

    public ArrayList<Voadip> getVoadips() {
        return voadips;
    }
}
