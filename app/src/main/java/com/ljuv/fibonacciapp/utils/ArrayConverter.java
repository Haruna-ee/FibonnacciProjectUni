package com.ljuv.fibonacciapp.utils;
import java.util.ArrayList;

public class ArrayConverter {
    public static ArrayList<Long> stringToLong(ArrayList<String> listString) {
        ArrayList<Long> list = new ArrayList<>();

        for (String string : listString) {
            list.add(Long.valueOf(string));
        }

        return list;

    }

    public static ArrayList<String> longToString(ArrayList<Long> listLong) {
        ArrayList<String> list = new ArrayList<>();
        for (Long v : listLong) {
            list.add(String.valueOf(v));
        }
        return list;
    }
}
