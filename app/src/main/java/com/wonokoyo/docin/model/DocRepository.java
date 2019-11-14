package com.wonokoyo.docin.model;

import com.wonokoyo.docin.serveraccess.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class DocRepository {
    private static DocRepository docRepository;

    public static DocRepository getInstance() {
        if (docRepository == null) {
            docRepository = new DocRepository();
        }
        return docRepository;
    }

    public void getAllDoc(String date, Callback<List<Doc>> listener) {
        Call<List<Doc>> docCall = RetrofitInstance.docService().getPlanningDoc(date);
        docCall.enqueue(listener);
    }
}
