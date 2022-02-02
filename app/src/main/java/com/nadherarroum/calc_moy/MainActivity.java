package com.nadherarroum.calc_moy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText note1, note2, note3;
    private TextView result_view;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1 = findViewById(R.id.note1);
        note2 = findViewById(R.id.note2);
        note3 = findViewById(R.id.note3);
        result_view = findViewById(R.id.result_view);
        button = findViewById(R.id.calc_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcMoy();
            }
        });
    }

    private void calcMoy() {
        String n1 = note1.getText().toString();
        String n2 = note2.getText().toString();
        String n3 = note3.getText().toString();

        if (n1.isEmpty() || n2.isEmpty() || n3.isEmpty()){
            showMessageDialog();
        }
    }

    private void showMessageDialog() {
        Activity_echec activity_echec = new Activity_echec();
        activity_echec.show(getSupportFragmentManager(),"Error message");
    }
}