package com.nadherarroum.calc_moy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class Activity_reussi extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussi);

        textView = findViewById(R.id.result_moy_view);

        String moy = getIntent().getStringExtra("keymoy");

        textView.setText(moy);
    }
}