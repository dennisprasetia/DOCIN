package com.wonokoyo.docin.model.repository;

import com.wonokoyo.docin.model.Voadip;
import com.wonokoyo.docin.serveraccess.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class VoadipRepository {
    private static VoadipRepository voadipRepository;

    public static VoadipRepository getInstance() {
        if (voadipRepository == null)
            voadipRepository = new VoadipRepository();

        return voadipRepository;
    }

    public void getListVoadipByNoreg(String noreg, String date, Callback<List<Voadip>> listener) {
        Call<List<Voadip>> voadipCall = RetrofitInstance.voadipService().getVoadipByNoreg(noreg, date);
        voadipCall.enqueue(listener);
    }

    public void getVoadipByNoOp(String noOp, Callback<Voadip> listener) {
        Call<Voadip> voadipCall = RetrofitInstance.voadipService().getVoadipByNoOp(noOp);
        voadipCall.enqueue(listener);
    }
}
