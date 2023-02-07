package com.example.wh_bmi;

import androidx.appcompat.app.AppCompatActivity;

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
        EditText weight,heightft,heightin;
        TextView textView;
        Button button;
        LinearLayout llmain;

        weight = findViewById(R.id.weight);
        heightft = findViewById(R.id.heightft);
        heightin = findViewById(R.id.heightin);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textview);
        llmain = findViewById(R.id.llmain);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt( weight.getText().toString());
                int ft = Integer.parseInt(heightft.getText().toString());
                int inc = Integer.parseInt(heightin.getText().toString());

                int totalinc = ft*12 + inc;
                double totalcm = totalinc*2.53;
                double totalm = totalcm/100;
                double bmi = wt/(totalm*totalm);
                if(bmi>25) {
                    textView.setText("You are over weight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.Oweight));
                }
                else if (bmi<18) {
                    textView.setText("You are under weight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.Uweight));
                } else  {
                    textView.setText("You are a healthy person");
                    llmain.setBackgroundColor(getResources().getColor(R.color.fit));
                }
            }
        });
    }
}