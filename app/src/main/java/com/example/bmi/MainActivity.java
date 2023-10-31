package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight, editHeightFt, editHeightIn;
        TextView txtResult;
        Button btnCalculate;
        LinearLayout linMain;

        editWeight = findViewById(R.id.editWeight);
        editHeightIn = findViewById(R.id.editHeightIn);
        editHeightFt = findViewById(R.id.editHeightFt);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        linMain = findViewById(R.id.linMain);


        btnCalculate.setOnClickListener(new View.OnClickListener(){

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                int wt = Integer.parseInt(editWeight.getText().toString());
                int ft = Integer.parseInt(editHeightFt.getText().toString());
                int in = Integer.parseInt(editHeightIn.getText().toString());

                int totalIn = ft*12 + in;

                double totalCm = totalIn*2.53;

                double totalMt = totalCm/100;

                double bmi = wt/(totalMt*totalMt);

                if (bmi > 25) {
                    txtResult.setText("You are over weight");
                    linMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (bmi < 18) {
                    txtResult.setText("You are under weight");
                    linMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                } else {
                    txtResult.setText("You are Healthy");
                    linMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }


            }
        });


    }
}