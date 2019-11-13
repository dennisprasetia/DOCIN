package com.wonokoyo.docin.model.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.model.DocRepository;

import java.util.List;

public class DocViewModel extends ViewModel {
    private MutableLiveData<List<Doc>> mutableLiveData;
    private DocRepository docRepository;

    public void init() {
        if (mutableLiveData != null)
            return;

        docRepository = DocRepository.getInstance();
        mutableLiveData = docRepository.getAllDoc("2019-11-10");
    }

    public LiveData<List<Doc>> getListDoc() {
        return mutableLiveData;
    }
}
