package com.wonokoyo.docin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @SerializedName("penerimaan")
    @Expose
    private String penerimaan;

    @SerializedName("noSj")
    @Expose
    private String noSj;

    @SerializedName("jenis")
    @Expose
    private String jenis;

    @SerializedName("mati")
    @Expose
    private int mati;

    @SerializedName("ekorTerima")
    @Expose
    private int ekorTerima;

    @SerializedName("bbRata")
    @Expose
    private double bbRata;

    @SerializedName("keterangan")
    @Expose
    private String keterangan;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("urlSign")
    @Expose
    private String urlSign;

    @SerializedName("voadips")
    @Expose
    private List<Voadip> voadips;

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

    public String getPenerimaan() {
        return penerimaan;
    }

    public void setPenerimaan(String penerimaan) {
        this.penerimaan = penerimaan;
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

    public List<Voadip> getVoadips() {
        return voadips;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("noOpDoc", this.noOpDoc);
        jsonObject.put("tanggalDoc", this.tanggalDoc);
        jsonObject.put("mitra", this.mitra);
        jsonObject.put("noreg", this.noreg);
        jsonObject.put("kandang", this.kandang);
        jsonObject.put("alamat", this.alamat);
        jsonObject.put("populasi", this.populasi);
        jsonObject.put("jumlahBox", this.jumlahBox);
        jsonObject.put("nopol", this.nopol);
        jsonObject.put("sopir", this.sopir);
        jsonObject.put("kedatangan", this.kedatangan);
        jsonObject.put("noSj", this.noSj);
        jsonObject.put("jenis", this.jenis);
        jsonObject.put("mati", this.mati);
        jsonObject.put("ekorTerima", this.ekorTerima);
        jsonObject.put("bbRata", this.bbRata);
        jsonObject.put("keterangan", this.keterangan);

        return jsonObject;
    }
}
