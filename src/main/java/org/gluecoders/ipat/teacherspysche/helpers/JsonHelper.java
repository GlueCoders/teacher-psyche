package org.gluecoders.ipat.teacherspysche.helpers;

import com.google.gson.Gson;

public class JsonHelper {

    private final static Gson gson = new Gson();

    public static <T> T toPojo(String json, Class<T> pojoClass){
        return gson.fromJson(json, pojoClass);
    }

    public static String toJson(Object pojo){
        return gson.toJson(pojo);
    }

}
