package com.example.nvs_bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView textView1,textView2,textView3,textView4,textView6,textView5,textView7;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1= findViewById(R.id.txt1);
        textView2= findViewById(R.id.txt2);
        textView3= findViewById(R.id.txt3);
        textView4= findViewById(R.id.txt4);
        textView6= findViewById(R.id.txt6);
        textView5=findViewById(R.id.txt5);
        textView7=findViewById(R.id.txt7);
        textView1.setText(getIntent().getStringExtra("strname1"));
        textView2.setText(getIntent().getStringExtra("strsdt1"));
        textView3.setText(getIntent().getStringExtra("tuoi"));
        textView4.setText(getIntent().getStringExtra("gioitinh"));
        textView6.setText(getIntent().getStringExtra("thethao"));
        textView5.setText(getIntent().getStringExtra("amnhac"));
        textView7.setText(getIntent().getStringExtra("trinhdo"));
    }
}