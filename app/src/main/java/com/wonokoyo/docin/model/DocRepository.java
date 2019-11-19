package com.wonokoyo.docin.model;

import com.wonokoyo.docin.serveraccess.RetrofitInstance;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class DocRepository {
    private static DocRepository docRepository;

    public static DocRepository getInstance() {
        if (docRepository == null) {
            docRepository = new DocRepository();
        }
        return docRepository;
    }

    public void getAllDoc(String date, Callback<List<Doc>> listener) {
        Call<List<Doc>> docCall = RetrofitInstance.docService().getPlanningDoc(date);
        docCall.enqueue(listener);
    }

    public void getDocByNoOp(String noOp, Callback<Doc> listener) {
        Call<Doc> docCall = RetrofitInstance.docService().getDocByOp(noOp);
        docCall.enqueue(listener);
    }

    public void saveDoc(Doc doc, Callback<ResponseBody> listener) throws JSONException {
        Call<ResponseBody> docCall = RetrofitInstance.docService().saveDoc(doc.toJson().toString());
        docCall.enqueue(listener);
    }

    public void uploadAttachment(String path, Callback<ResponseBody> listener) {
        File file = new File(path);
        RequestBody body = RequestBody.create(MediaType.parse("photo/*"), file);
        MultipartBody.Part finalFile = MultipartBody.Part.createFormData("photo", file.getName(), body);

        Call<ResponseBody> call = RetrofitInstance.docService().uploadAttachment(finalFile, "DOC");
        call.enqueue(listener);
    }
}
