package com.wonokoyo.docin.serveraccess.service;

import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.serveraccess.Url;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DocService {
    @GET(Url.GET_PLANNING_DOC)
    Call<List<Doc>> getPlanningDoc(@Query("date") String today);

    @POST(Url.SAVE_DOC)
    Call<Doc> saveDoc(@Query("doc") Doc doc);
}
