package com.vishalag53.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        EditText weight,heightF,heightI;
        Button calculate_btn;
        TextView result_view;
        LinearLayout llMain;

        weight = findViewById(R.id.weight);
        heightF = findViewById(R.id.heightF);
        heightI = findViewById(R.id.heightI);
        calculate_btn = findViewById(R.id.calculate_btn);
        result_view = findViewById(R.id.result_view);
        llMain = findViewById(R.id.llMain);

        calculate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double w = Double.parseDouble(weight.getText().toString());
                int hf = Integer.parseInt(heightF.getText().toString());
                int hi = Integer.parseInt(heightI.getText().toString());
                int totalInch = hf*12+hi;
                double totalCm = totalInch*2.53;
                double totalM = totalCm/100;
                double bmi = w/(totalM*totalM);
                if(bmi>25){
                    result_view.setText("You are OverWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.OverW));
                }
                else if(bmi<18){
                    result_view.setText("You are UnderWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.UnderW));
                }
                else{
                    result_view.setText("You are Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.Healthy));
                }
            }
        });
    }
}