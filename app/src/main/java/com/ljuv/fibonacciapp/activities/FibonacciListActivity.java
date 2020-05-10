package com.ljuv.fibonacciapp.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.os.Bundle;
import android.widget.TextView;

import com.ljuv.fibonacciapp.utils.FibonacciNumbersCalculator;
import com.ljuv.fibonacciapp.utils.ArrayConverter;
import com.ljuv.fibonacciapp.R;
import com.ljuv.fibonacciapp.lists.RecyclerViewFibonacciAdapter;

import java.util.ArrayList;

public class FibonacciListActivity extends AppCompatActivity {
    TextView loadingView;
    RecyclerView recyclerView;
    public ArrayList<Long> fibList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadData();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci_list);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //int nums = getIntent().getIntExtra("nums", 1);
        //int iterations = 100;
        //ArrayList<Long> fibList = FibonacciNumbersCalculator.getNums(nums);
        RecyclerViewFibonacciAdapter adapter = new RecyclerViewFibonacciAdapter(fibList);
        recyclerView.setAdapter(adapter);
    }


    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("fibonacc", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("fibList", null);
        ArrayList<String> list;
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        if (gson.fromJson(json, type) == null) {
            fibList = new ArrayList<>();
        } else {
            list = gson.fromJson(json, type);
            fibList = ArrayConverter.stringToLong(list);
        }
    }

}
