package com.nadherarroum.calc_moy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText note1, note2, note3;
    private TextView result_view;
    private Button button;
    private Double resultMoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.home_navbar_color));
        getSupportActionBar().hide();
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

        if (n1.isEmpty() || n2.isEmpty() || n3.isEmpty()) {
            showMessageDialog();
        }else{
            resultMoy = doCalc(n1, n2, n3);
            if (resultMoy>=10){
                //goToReussiActivity(String.valueOf(resultMoy));
                goToReussiActivity(String.format("%.2f",resultMoy));
            }else{
                showTost(String.format("%.2f",resultMoy));
            }
        }
    }

    private void showTost(String moy) {
        Toast.makeText(this, "Tu n'as pas réussi avec un moyenne de"+moy+" !", Toast.LENGTH_SHORT).show();
    }

    private void goToReussiActivity(String moy) {
        Intent intent = new Intent(MainActivity.this, Activity_reussi.class);
        intent.putExtra("keymoy",moy);
        startActivity(intent);
    }

    private double doCalc(String n1, String n2, String n3) {
        double not1 = Double.parseDouble(n1);
        double not2 = Double.parseDouble(n2);
        double not3 = Double.parseDouble(n3);

        return (not1+not2+not3)/3;
    }

    private void showMessageDialog() {
        Activity_echec activity_echec = new Activity_echec();
        activity_echec.show(getSupportFragmentManager(),"Error message");
    }
}