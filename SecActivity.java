package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecActivity extends AppCompatActivity {

    TextView q;
    int predict;
    int min, max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        Intent i = getIntent();
        q = findViewById(R.id.question);
        min = i.getIntExtra("min", 0);
        max = i.getIntExtra("max", 0);
        //Toast toast = Toast.makeText(this, "min: " + min + " max: " + max, Toast.LENGTH_LONG);
        //toast.show();
        predict = (max - min) / 2 + min;
        q.setText(">" + predict);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.yes:
                min = predict + 1;
                break;

            case R.id.no:
                max = predict;
                break;
        }

        if (max == min)
        {
            q.setText("Ваше число: " + min);
        }
        else
        {
            predict = (max - min) / 2 + min;
            q.setText(">" + predict);
        }
    }
}
