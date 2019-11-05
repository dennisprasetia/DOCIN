package com.wonokoyo.docin.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    public static final String SM_CREATE_DB = "create_db";

    SharedPreferences sp;
    SharedPreferences.Editor spEdit;

    public SessionManager(Context context) {
        sp = context.getSharedPreferences("DOCIN", Context.MODE_PRIVATE);
        spEdit = sp.edit();
    }

    public void saveSPString(String key, String value) {
        spEdit.putString(key, value);
        spEdit.commit();
    }

    public void saveSPBoolean(String key, Boolean value) {
        spEdit.putBoolean(key, value);
        spEdit.commit();
    }

    public Boolean createDb() {
        return sp.getBoolean(SM_CREATE_DB, false);
    }
}
