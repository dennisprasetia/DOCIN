package com.wonokoyo.docin.serveraccess.service;

import com.wonokoyo.docin.model.Doc;
import com.wonokoyo.docin.serveraccess.Url;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface DocService {
    @GET(Url.GET_PLANNING_DOC)
    Call<List<Doc>> getPlanningDoc(@Query("date") String today);

    @GET(Url.GET_DOC_BY_NO_OP)
    Call<Doc> getDocByOp(@Query("noOp") String noOp);

    @GET(Url.SAVE_DOC)
    Call<ResponseBody> saveDoc(@Query("doc") String stringDoc);

    @Multipart
    @POST(Url.UPLOAD_DOC_ATTACHMENT)
    Call<ResponseBody> uploadAttachment(@Part MultipartBody.Part photo, @Query("type") String type);
}
