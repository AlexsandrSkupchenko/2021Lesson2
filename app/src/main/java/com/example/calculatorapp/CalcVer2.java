package com.example.calculatorapp;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import java.util.Locale;


public class CalcVer2 extends AppCompatActivity implements View.OnClickListener {
    private EditText textEdit;
    private DataKey dataKey = new DataKey();
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_0;
    private Button button_11;
    private Button button_12;
    private Button button_13;
    private Button button_point;
    private Button button_multiplication;
    private Button button_division;
    private Button button_summ;
    private Button button_subtraction;
    private Button button_total;
    private Button button_clear;
    private double input1 = 0;
    private double input2 = 0;
    boolean Addition, Subtract, Multiplication, Division, decimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_ver2);
        initEdit();
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.button_1):
                setTextCounter(textEdit, dataKey.getDataKey1());
                break;
            case (R.id.button_2):
                setTextCounter(textEdit, dataKey.getDataKey2());
                break;
            case (R.id.button_3):
                setTextCounter(textEdit, dataKey.getDataKey3());
                break;
            case (R.id.button_6):
                setTextCounter(textEdit, dataKey.getDataKey4());
                break;
            case (R.id.button_7):
                setTextCounter(textEdit, dataKey.getDataKey5());
                break;
            case (R.id.button_8):
                setTextCounter(textEdit, dataKey.getDataKey6());
                break;
            case (R.id.button_0):
                setTextCounter(textEdit, dataKey.getDataKey0());
                break;
            case (R.id.button_11):
                setTextCounter(textEdit, dataKey.getDataKey7());
                break;
            case (R.id.button_12):
                setTextCounter(textEdit, dataKey.getDataKey8());
                break;
            case (R.id.button_13):
                setTextCounter(textEdit, dataKey.getDataKey9());
                break;
            case (R.id.button_summ):
                if (textEdit.getText().length() != 0) {
                    input1 = Float.parseFloat(textEdit.getText() + "");
                    Addition = true;
                    decimal = false;
                    textEdit.setText(null);
                }
                break;
            case (R.id.button_multiplication):
                if (textEdit.getText().length() != 0) {
                    input1 = Float.parseFloat(textEdit.getText() + "");
                    Multiplication = true;
                    decimal = false;
                    textEdit.setText(null);
                }
                break;
            case (R.id.button_subtraction):
                if (textEdit.getText().length() != 0) {
                    input1 = Float.parseFloat(textEdit.getText() + "");
                    Subtract = true;
                    decimal = false;
                    textEdit.setText(null);
                }
                break;

            case (R.id.button_division):
                if (textEdit.getText().length() != 0) {
                    input1 = Float.parseFloat(textEdit.getText() + "");
                    Division = true;
                    decimal = false;
                    textEdit.setText(null);
                }
                break;

            case (R.id.button_clear):
                textEdit.setText("");
                input1 = 0.0;
                input2 = 0.0;
                break;

            case (R.id.button_point):
                if (decimal) {
                    //do nothing or you can show the error
                } else {
                    textEdit.setText(textEdit.getText() + ".");
                    decimal = true;
                }
                break;

            case (R.id.button_total):
                if (Addition || Subtract || Multiplication || Division) {
                    input2 = Float.parseFloat(textEdit.getText() + "");
                }

                if (Addition) {

                    textEdit.setText(input1 + input2 + "");
                    Addition = false;
                }

                if (Subtract) {

                    textEdit.setText(input1 - input2 + "");
                    Subtract = false;
                }

                if (Multiplication) {
                    textEdit.setText(input1 * input2 + "");
                    Multiplication = false;
                }

                if (Division) {
                    textEdit.setText(input1 / input2 + "");
                    Division = false;
                }
                break;
        }

    }

    private void initEdit() {
        findView();
        setClickListener();
    }

    private void setClickListener() {
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_0.setOnClickListener(this);
        button_11.setOnClickListener(this);
        button_12.setOnClickListener(this);
        button_13.setOnClickListener(this);
        button_summ.setOnClickListener(this);
        button_total.setOnClickListener(this);
        button_division.setOnClickListener(this);
        button_multiplication.setOnClickListener(this);
        button_subtraction.setOnClickListener(this);
        button_point.setOnClickListener(this);
        button_clear.setOnClickListener(this);
    }

    private void findView() {
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_0 = findViewById(R.id.button_0);
        button_11 = findViewById(R.id.button_11);
        button_12 = findViewById(R.id.button_12);
        button_13 = findViewById(R.id.button_13);
        textEdit = findViewById(R.id.editText);
        button_point = findViewById(R.id.button_point);
        button_summ = findViewById(R.id.button_summ);
        button_subtraction = findViewById(R.id.button_subtraction);
        button_multiplication = findViewById(R.id.button_multiplication);
        button_division = findViewById(R.id.button_division);
        button_clear = findViewById(R.id.button_clear);
        button_total = findViewById(R.id.button_total);
    }

    private void setTextCounter(TextView textCounter, int counter) {
        textCounter.append(String.format(Locale.getDefault(), "%d", counter));
    }
}

