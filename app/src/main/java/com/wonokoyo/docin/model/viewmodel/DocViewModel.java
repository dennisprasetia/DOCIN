package com.wonokoyo.docin.model.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.model.DocRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DocViewModel extends ViewModel {
    private MutableLiveData<List<Doc>> mutableLiveData;
    private DocRepository docRepository;

    public void init() {
        if (mutableLiveData != null)
            return;

        mutableLiveData = new MutableLiveData<>();
        docRepository = DocRepository.getInstance();
        mutableLiveData.setValue(new ArrayList<Doc>());
    }

    public LiveData<List<Doc>> getListDoc() {
        return mutableLiveData;
    }

    public void populateListDoc() {
        Callback<List<Doc>> listener = new Callback<List<Doc>>() {
            @Override
            public void onResponse(Call<List<Doc>> call, Response<List<Doc>> response) {
                if (response.isSuccessful())
                    mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Doc>> call, Throwable t) {
                System.out.println("dodo");
                mutableLiveData.setValue(new ArrayList<Doc>());
            }
        };

        docRepository.getAllDoc("2019-11-10", listener);
    }

    public void saveDoc() {

    }
}
