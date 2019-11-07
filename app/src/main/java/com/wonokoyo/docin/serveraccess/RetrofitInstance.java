package com.wonokoyo.docin.serveraccess;

import com.wonokoyo.docin.serveraccess.service.DocService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Url.BASE_PATH)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static DocService docService() {
        return RetrofitInstance.getRetrofit().create(DocService.class);
    }
}
