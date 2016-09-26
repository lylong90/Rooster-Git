package com.blikoon.rooster.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by User on 24/9/2016.
 */
public class AppPreferences
{
    private SharedPreferences _sharedPrefs;
    private SharedPreferences.Editor _prefsEditor;

    public AppPreferences(Context context, String prefName) {
        this._sharedPrefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        this._prefsEditor = _sharedPrefs.edit();
    }

    public String getString(String prefKey) {
        return _sharedPrefs.getString(prefKey, ""); // return empty string if got null
    }

    public void putString(String prefKey, String value) {
        _prefsEditor.putString(prefKey, value);
        _prefsEditor.apply();
    }

    public void removeString(String prefKey)
    {
        _prefsEditor.remove(prefKey);
        _prefsEditor.apply();
    }

    public boolean isPreferenceEmpty(String prefKey) // TODO: gson empty list is not empty, please revise
    {
        return getString(prefKey).isEmpty();
    }

//    public <T> List<T> parsePreferenceToList(Type type, String prefKey)
//    {
//        final Gson gson = new Gson();
//        String prefValues = this.getString(prefKey);
//        return gson.fromJson(prefValues, type);
//    }
}
