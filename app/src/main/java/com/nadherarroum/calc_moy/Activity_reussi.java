package com.nadherarroum.calc_moy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_reussi extends AppCompatActivity {

    private TextView textView,statictext;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reussi);

        button = findViewById(R.id.send_sms_btn);
        statictext = findViewById(R.id.static_txt_view);
        textView = findViewById(R.id.result_moy_view);

        String moy = getIntent().getStringExtra("keymoy");
        textView.setText(moy);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSMSapp();
            }
        });
    }

    private void openSMSapp() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","55840111",null));
        intent.putExtra("sms_body",statictext.getText().toString()+textView.getText().toString());
        startActivity(intent);
    }
}