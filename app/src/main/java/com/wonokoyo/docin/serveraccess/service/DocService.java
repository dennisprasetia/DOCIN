package com.wonokoyo.docin.serveraccess.service;

import com.wonokoyo.docin.serveraccess.Url;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DocService {
    @GET(Url.GET_PLANNING_DOC)
    Call<ResponseBody> getPlanningDoc(@Query("date") String today);
}
