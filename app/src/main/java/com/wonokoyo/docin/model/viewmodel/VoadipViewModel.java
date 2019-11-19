package com.wonokoyo.docin.model.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.wonokoyo.docin.model.Voadip;
import com.wonokoyo.docin.model.repository.VoadipRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VoadipViewModel extends ViewModel {
    private MutableLiveData<Voadip> mutableLiveData;
    private VoadipRepository voadipRepository;

    public void init() {
        if (mutableLiveData != null)
            return;

        mutableLiveData = new MutableLiveData<>();
        voadipRepository = VoadipRepository.getInstance();
    }

    public LiveData<Voadip> getLiveVoadip() {
        return mutableLiveData;
    }

    public void getVoadipByOp(String noOp) {
        Callback<Voadip> listener = new Callback<Voadip>() {
            @Override
            public void onResponse(Call<Voadip> call, Response<Voadip> response) {
                if (response.isSuccessful())
                    mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Voadip> call, Throwable t) {
                System.out.println("failed");
                mutableLiveData.setValue(null);
            }
        };

        voadipRepository.getVoadipByNoOp(noOp, listener);
    }
}
