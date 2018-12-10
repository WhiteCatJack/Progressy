package com.white.cat.jack.progressy.demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.white.cat.jack.progressy.wheel.FlowerStyle;
import com.white.cat.jack.progressy.wheel.ProgressWheel;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressWheel progressWheel = findViewById(R.id.progress1);
        progressWheel.setShape(new FlowerStyle());
        progressWheel.setStrokeColor(Color.BLACK);
        progressWheel.setFillColor(Color.WHITE);
        progressWheel = findViewById(R.id.progress2);
        progressWheel.setShape(new FlowerStyle());
        progressWheel.setStrokeColor(Color.GREEN);
        progressWheel.setFillColor(Color.WHITE);
        progressWheel = findViewById(R.id.progress3);
        progressWheel.setShape(new FlowerStyle());
        progressWheel.setStrokeColor(Color.RED);
        progressWheel.setFillColor(Color.WHITE);
        progressWheel = findViewById(R.id.progress4);
        progressWheel.setShape(new FlowerStyle());
        progressWheel.setStrokeColor(Color.GRAY);
        progressWheel.setFillColor(Color.WHITE);
        progressWheel = findViewById(R.id.progress5);
        progressWheel.setShape(new FlowerStyle());
        progressWheel.setStrokeColor(0xFF3296FA);
        progressWheel.setFillColor(Color.WHITE);
    }
}
