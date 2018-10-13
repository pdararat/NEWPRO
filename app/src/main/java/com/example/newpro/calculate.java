package com.example.newpro;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class calculate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        final Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditText = findViewById(R.id.height);
                EditText weightEditText = findViewById(R.id.weight);

                int h = Integer.parseInt(heightEditText.getText().toString());
                int w = Integer.parseInt(weightEditText.getText().toString());
                float bmi = calBMI(h, w);
                String printtext = "";
                if (bmi < 18.5) {
                    printtext = "ผอมมากอีดอก";
                } else if (bmi < 25) {
                    printtext = "หุ่นดีขนาดนี้ไปประกวดนางแบบสิ";
                } else if (bmi < 30) {
                    printtext = "อีอ้วน รู้ตัวก็ลดน้ำหนักซะ";
                } else {
                    printtext = "อ้วนขนาดนี้ใกล้แล้วละ ใกล้ตายอ่ะ";
                }

                AlertDialog.Builder dialog = new AlertDialog.Builder(calculate.this);
                dialog.setTitle("Result");
                dialog.setMessage(printtext);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("NO",null);
                dialog.setCancelable(false);
                dialog.show();
            }
        });

        Button eq = findViewById(R.id.EQ);
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name1 = findViewById(R.id.name1);
                EditText name2 = findViewById(R.id.name2);
                String n1 = name1.getText().toString();
                String n2 = name2.getText().toString();
                String print1 = " " ;
                String print2 = " " ;
                if (n1.equals(n2)){
                    print1 = "true" ;
            }
                else {
                    print1 = "false" ;
                }

            AlertDialog.Builder dialog = new AlertDialog.Builder(calculate.this);
            dialog.setTitle("เหมือนไม่เหมือน") ;
            dialog.setMessage(print1);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
            }

        });
    }
    private float calBMI (int h,int w){
        float height = h/100f ;
        float bmi = w/(height*height);
        return bmi;
    }
}

