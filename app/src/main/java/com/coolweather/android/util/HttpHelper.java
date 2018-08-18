package com.coolweather.android.util;

import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpHelper {

    public static <T> T get(String address, Type type) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .header("Content-Type", "application/json; charset=utf-8")
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            if (response != null) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    return JsonHelper.fromJson(responseBody.string(), type);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
