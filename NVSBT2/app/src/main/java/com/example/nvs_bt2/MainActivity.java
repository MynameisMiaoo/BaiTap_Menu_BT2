package com.example.nvs_bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    SeekBar seekBar;
    TextView textView, textView2,textView4;
    EditText textViewName,textViewSdt;
    Button button;
    Integer poss;
    CheckBox checkBox ;
    RadioButton radioButton1,radioButton2,radioButton3;
    String string,string2="",strtrinhdo;

    Switch aSwitch;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewName = findViewById(R.id.editTextName);
        textViewSdt = findViewById(R.id.editTextPhone);
        radioButton1=findViewById(R.id.radioButton2);
        radioButton2=findViewById(R.id.radioButton3);
        radioButton3=findViewById(R.id.radioButton4);
        textView2=findViewById(R.id.textView2);
        textView4=findViewById(R.id.textView4);
        checkBox = findViewById(R.id.checkBox);
        aSwitch=findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textView2.setText("Nam");
                }else {
                    textView2.setText("Nu");
                }
            }
        });
        spinner = findViewById(R.id.spinner);
        seekBar= findViewById(R.id.seekBar3);
        textView = findViewById(R.id.textView4);
        button=findViewById(R.id.button2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planets_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                nextAc();
                if(checkBox.isChecked()){
                    string="yes";
                }else {
                    string="no";
                }
                if (radioButton1.isChecked()){
                    string2=string2+" "+radioButton1.getText();
                }
                if (radioButton2.isChecked()){
                    string2=string2+" "+radioButton2.getText();
                }
                if (radioButton3.isChecked()){
                    string2=string2+" "+radioButton3.getText();
                }
                nextAc();
            }

            private void nextAc() {
                String nameac2 = textViewName.getText().toString();
                String sdtac2 = textViewSdt.getText().toString();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("tuoi",textView4.getText());
                intent.putExtra("gioitinh",textView2.getText());
                intent.putExtra("thethao",string);
                intent.putExtra("strname1",nameac2);
                intent.putExtra("strsdt1",sdtac2);
                intent.putExtra("amnhac",string2);
                intent.putExtra("trinhdo",strtrinhdo);
                startActivity(intent);
            }
        });
    }


    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            poss=pos;
            parent.getItemAtPosition(pos);
            spinner.setOnItemClickListener((AdapterView.OnItemClickListener)this);
            strtrinhdo= parent.getItemAtPosition(pos).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}