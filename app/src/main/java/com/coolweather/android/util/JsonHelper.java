package com.coolweather.android.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JsonHelper {

    protected static final Gson gson = new Gson();

    public static <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }
}
