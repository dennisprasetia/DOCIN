package com.wonokoyo.docin.model;

import androidx.lifecycle.MutableLiveData;

import com.wonokoyo.docin.serveraccess.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DocRepository {
    private static DocRepository docRepository;

    public static DocRepository getInstance() {
        if (docRepository == null) {
            docRepository = new DocRepository();
        }
        return docRepository;
    }

    public MutableLiveData<List<Doc>> getAllDoc(String date) {
        final MutableLiveData<List<Doc>> docData = new MutableLiveData<>();

        Call<List<Doc>> docCall = RetrofitInstance.docService().getPlanningDoc(date);
        docCall.enqueue(new Callback<List<Doc>>() {
            @Override
            public void onResponse(Call<List<Doc>> call, Response<List<Doc>> response) {
                docData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Doc>> call, Throwable t) {
                docData.setValue(new ArrayList<Doc>());
            }
        });

        return docData;
    }
}
