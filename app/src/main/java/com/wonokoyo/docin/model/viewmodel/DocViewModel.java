package com.wonokoyo.docin.model.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.model.repository.DocRepository;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DocViewModel extends ViewModel {
    private MutableLiveData<List<Doc>> mutableLiveData;
    private MutableLiveData<Doc> docMutableLiveData;
    private DocRepository docRepository;

    public void init() {
        if (mutableLiveData != null || docMutableLiveData != null)
            return;

        mutableLiveData = new MutableLiveData<>();
        docMutableLiveData = new MutableLiveData<>();
        docRepository = DocRepository.getInstance();
        mutableLiveData.setValue(new ArrayList<Doc>());
    }

    public LiveData<List<Doc>> getListDoc() {
        return mutableLiveData;
    }

    public LiveData<Doc> getLiveDoc() {
        return docMutableLiveData;
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
                System.out.println("failed");
                mutableLiveData.setValue(new ArrayList<Doc>());
            }
        };

        docRepository.getAllDoc("2019-11-10", listener);
    }

    public void getDocByOp(String noOp) {
        Callback<Doc> listener = new Callback<Doc>() {
            @Override
            public void onResponse(Call<Doc> call, Response<Doc> response) {
                if (response.isSuccessful())
                    docMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Doc> call, Throwable t) {
                System.out.println("failed");
                docMutableLiveData.setValue(null);
            }
        };

        docRepository.getDocByNoOp(noOp, listener);
    }

    public void deleteDocByOp() {
        docMutableLiveData.setValue(null);
    }

    public void saveDoc(Doc doc) throws JSONException {
        Callback<ResponseBody> listener = new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        System.out.println(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("success");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("failed");
            }
        };

        docRepository.saveDoc(doc, listener);
    }

    public void uploadAttachment(String path) {
        Callback<ResponseBody> listener = new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        System.out.println(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("success upload");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("failed");
            }
        };

        docRepository.uploadAttachment(path, listener);
    }
}
