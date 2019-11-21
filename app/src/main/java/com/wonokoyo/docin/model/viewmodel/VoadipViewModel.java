package com.wonokoyo.docin.model.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wonokoyo.docin.model.Voadip;
import com.wonokoyo.docin.model.repository.VoadipRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoadipViewModel extends ViewModel {
    private MutableLiveData<List<Voadip>> mutableLiveData;
    private MutableLiveData<Voadip> voadipMutableLiveData;
    private VoadipRepository voadipRepository;

    public void init() {
        if (mutableLiveData != null && voadipMutableLiveData != null)
            return;

        mutableLiveData = new MutableLiveData<>();
        voadipMutableLiveData = new MutableLiveData<>();
        voadipRepository = VoadipRepository.getInstance();
    }

    public LiveData<Voadip> getLiveVoadip() {
        return voadipMutableLiveData;
    }

    public LiveData<List<Voadip>> getLiveListVoadip() {
        return mutableLiveData;
    }

    public void getListVoadipByNoreg(String noreg, String date) {
        Callback<List<Voadip>> listener = new Callback<List<Voadip>>() {
            @Override
            public void onResponse(Call<List<Voadip>> call, Response<List<Voadip>> response) {
                if (response.isSuccessful())
                    mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Voadip>> call, Throwable t) {
                System.out.println("failed");
                mutableLiveData.setValue(new ArrayList<Voadip>());
            }
        };

        voadipRepository.getListVoadipByNoreg(noreg, date, listener);
    }

    public void getVoadipByOp(String noOp) {
        Callback<Voadip> listener = new Callback<Voadip>() {
            @Override
            public void onResponse(Call<Voadip> call, Response<Voadip> response) {
                if (response.isSuccessful())
                    voadipMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Voadip> call, Throwable t) {
                System.out.println("failed");
                voadipMutableLiveData.setValue(null);
            }
        };

        voadipRepository.getVoadipByNoOp(noOp, listener);
    }
}
