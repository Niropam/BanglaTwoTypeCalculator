package com.example.user.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    EditText n1,n2;
    Button btn1,btn2,btn3,btn4,btn5;
    TextView view1,view2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        n1=(EditText) findViewById(R.id.num1);
        n2=(EditText) findViewById(R.id.num2);
        view1=(TextView) findViewById(R.id.show);
        view2=(TextView) findViewById(R.id.cherecter);
        btn1=(Button) findViewById(R.id.sum);
        btn2=(Button) findViewById(R.id.sub);
        btn3=(Button) findViewById(R.id.mul);
        btn4=(Button) findViewById(R.id.div);
        btn5=(Button) findViewById(R.id.back);

    }


    public void sumation(View view) {
        double number1=Double.parseDouble(n1.getText().toString());
        double number2=Double.parseDouble(n2.getText().toString());
        double results=number1+number2;
        long x= (long) results;
        double test1= results-x;
        double result1=results-test1;

        view1.setText(Double.toString(results));
        if(result1%2==0 && results>=1 && test1==0){
            view2.setText("ফলাফলটি একটি ধনাত্মক জোড় সংখ্যা");
        }
        else if(result1%2!=0 && results>=1 && test1==0){
            view2.setText("ফলাফলটি একটি ধনাত্মক বিজোড় সংখ্যা");
        }
        else if(test1!=0){
            view2.setText("ফলাফলটি একটি ধনাত্মক দশমিক সংখ্যা");
        }
        else {
            view2.setText("ফলাফলটি শূন্য অথবা অসীম সংখ্যা");
        }
    }

    public void subtraction(View view) {
        double number1=Double.parseDouble(n1.getText().toString());
        double number2=Double.parseDouble(n2.getText().toString());
        double results=number1-number2;
        long x= (long) results;
        double test1= results-x;
        double result1=results-test1;

        double test2= results+x;
        double result2=results-test1;

        view1.setText(Double.toString(results));
        if(result1%2==0 && results>=1 && test1==0){
            view2.setText("ফলাফলটি একটি ধনাত্মক জোড় সংখ্যা");
        }
        else if(result1%2!=0 && results>=1 && test1==0){
            view2.setText("ফলাফলটি একটি ধনাত্মক বিজোড় সংখ্যা");
        }
        else if(result2%2==0 && results<=-1 && test2==0){
            view2.setText("ফলাফলটি একটি ঋণাত্মক জোড় সংখ্যা");
        }
        else if(result2%2!=0 && results<=-1 && test2==0){
            view2.setText("ফলাফলটি একটি ঋণাত্মক বিজোড় সংখ্যা");
        }
        else if(test1!=0 && results>0){
            view2.setText("ফলাফলটি একটি ধনাত্মক দশমিক সংখ্যা");
        }
        else if(test2!=0 && results<0){
            view2.setText("ফলাফলটি একটি ঋণাত্মক দশমিক সংখ্যা");
        }
        else {
            view2.setText("ফলাফলটি শূন্য অথবা অসীম সংখ্যা");
        }
    }

    public void multiply(View view) {
        double number1=Double.parseDouble(n1.getText().toString());
        double number2=Double.parseDouble(n2.getText().toString());
        double results=number1*number2;
        long x= (long) results;
        double test1= results-x;
        double result1=results-test1;

        view1.setText(Double.toString(results));
        if(result1%2==0 && results>=1 && test1==0){
            view2.setText("ফলাফলটি একটি ধনাত্মক জোড় সংখ্যা");
        }
        else if(result1%2!=0 && results>=1 && test1==0){
            view2.setText("ফলাফলটি একটি ধনাত্মক বিজোড় সংখ্যা");
        }
        else if(test1!=0){
            view2.setText("ফলাফলটি একটি ধনাত্মক দশমিক সংখ্যা");
        }
        else {
            view2.setText("ফলাফলটি শূন্য অথবা অসীম সংখ্যা");
        }
    }

    public void divition(View view) {
        double number1=Double.parseDouble(n1.getText().toString());
        double number2=Double.parseDouble(n2.getText().toString());
        double results=number1/number2;
        long x= (long) results;
        double test1= results-x;
        double result1=results-test1;

        view1.setText(Double.toString(results));
        if(result1%2==0 && results>=1 && test1==0){
            view2.setText("ফলাফলটি একটি ধনাত্মক জোড় সংখ্যা");
        }
        else if(result1%2!=0 && results>=1 && test1==0){
            view2.setText("ফলাফলটি একটি ধনাত্মক বিজোড় সংখ্যা");
        }

        else if(test1!=0 && test1<1){
            view2.setText("ফলাফলটি একটি ধনাত্মক দশমিক সংখ্যা");
        }
        else {
            view2.setText("ফলাফলটি শূন্য অথবা অসীম সংখ্যা");
        }
    }

    public void returns(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void empty1(View view) {
        n1.setText("");

    }
    public void empty2(View view) {
        n2.setText("");
    }

    public void home(View view) {
        Intent i = new Intent(CalculatorActivity.this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }


    public void agecalcu(View view) {
        Intent i = new Intent(CalculatorActivity.this,CalenderActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
