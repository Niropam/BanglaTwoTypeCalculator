package com.example.user.calculator;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


public class CalenderActivity extends AppCompatActivity {

    Button bdate, sdate;
    TextView birthDate, sysDate, views, views2;
    DatePickerDialog datePickerDialog;
    public int sDay, sMonth, sYear, bDay, bMonth, bYear;
    Calendar c1, c2, current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        bdate = (Button) findViewById(R.id.birthbtn);
        sdate = (Button) findViewById(R.id.sysbtn);
        birthDate = (TextView) findViewById(R.id.birthday);
        sysDate = (TextView) findViewById(R.id.systemday);
        views = (TextView) findViewById(R.id.textView1);
        views2 = (TextView) findViewById(R.id.textView2);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        views2.setText(currentDateTimeString);
//        present();


        bdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1 = Calendar.getInstance();
                bYear = c1.get(Calendar.YEAR);
                bMonth = c1.get(Calendar.MONTH);
                bDay = c1.get(Calendar.DAY_OF_MONTH);
                // date picker dialog
                datePickerDialog = new DatePickerDialog(CalenderActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        birthDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        c1.set(year, monthOfYear, dayOfMonth);
                    }
                }, bYear, bMonth, bDay);
                datePickerDialog.show();


            }
        });
        sdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c2 = Calendar.getInstance();
                sYear = c2.get(Calendar.YEAR);
                sMonth = c2.get(Calendar.MONTH);
                sDay = c2.get(Calendar.DAY_OF_MONTH);
                // date picker dialog
                datePickerDialog = new DatePickerDialog(CalenderActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        c2.set(year, monthOfYear, dayOfMonth);
                        sysDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, sYear, sMonth, sDay);
                datePickerDialog.show();


            }
        });

    }


    public void calculation(View view) {
        Intent intent = getIntent();
        int monthset, dateset, yearset;
        Date time= c1.getTime();

        // Calculate difference in days
        long milib = c1.getTimeInMillis();
        long milis = c2.getTimeInMillis();
        long diff = milis - milib;
        long days = diff / (24 * 60 * 60 * 1000);
        int years = (int) (days / 365.25);
        int lep = years / 6;
        int months = (int) (((days % 365.25) / 30));
        int date = (int) (((days % 365.25) % 30) - lep);

        if (date < 0 && months < 0) {
            dateset = date + 30;
            monthset = months + 11;
            years--;

            views.setText(years + " বছর  " + monthset + " মাস এবং " + dateset+" দিন");

        } else if (date < 0 && months >=1) {
            dateset = date + 30;
            monthset = months - 1;

            views.setText(years + " বছর  " + monthset + " মাস এবং " + dateset+" দিন");

        }
        else if (date < 0 && months ==12) {
            dateset = date + 30;
            monthset = 12 - 1;
            years--;

            views.setText(years + " বছর  " + monthset + " মাস এবং " + dateset+" দিন");

        }

        else if(date<30 && months==12) {
                dateset=date;
                monthset = months - 12;
                yearset = years + 1;
                views.setText(yearset + " বছর  " + monthset + " মাস এবং " + dateset + " দিন");

            //views.setText(yearset + " বছর  " + monthset + " মাস এবং " + dateset + " দিন");
        }
        else if(date==30 && months==12) {
            dateset=date-30;
            monthset = months - 11;
            yearset = years + 1;
            views.setText(yearset + " বছর  " + monthset + " মাস এবং " + dateset + " দিন");

            //views.setText(yearset + " বছর  " + monthset + " মাস এবং " + dateset + " দিন");
        }
        else if (milib > milis && date<0) {
            views.setText("দুঃখিত আপনার নির্বাচিত তারিখ ভুল");

        } else

            views.setText(years + " বছর  " + months + " মাস এবং " + date + " দিন");



    }

    public void home(View view) {
        Intent i = new Intent(CalenderActivity.this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void calculator(View view) {
        Intent i = new Intent(CalenderActivity.this,CalculatorActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }


//    public void present() {
//
//        int sYear,sMonth,sDay;
//        int monthset, dateset, yearset;
//
//        // Calculate difference in days
//        current = Calendar.getInstance();
//        sYear = current.get(Calendar.YEAR);
//        sMonth = current.get(Calendar.MONTH);
//        sDay = current.get(Calendar.DAY_OF_MONTH);
//        current.set(sYear, sMonth, sDay);
//
//        long milib = c1.getTimeInMillis();
//        long milis = current.getTimeInMillis();
//
//        long diff = milis - milib;
//        long days = diff / (24 * 60 * 60 * 1000);
//        int years = (int) (days / 365.25);
//        int lep = years / 8;
//        int months = (int) (((days % 365.25) / 30));
//        int date = (int) (((days % 365.25) % 30) - lep);
//
//        if (date < 0 && months < 0) {
//            dateset = date + 30;
//            monthset = months + 11;
//            years--;
//            views.setText(years + "   " + monthset + " " + dateset);
//        } else if (date < 0 && months > 0) {
//            dateset = date + 30;
//            monthset = months - 1;
//            views.setText(years + "   " + monthset + " " + dateset);
//        } else if (date > 0 && months > 0) {
//            dateset = date;
//            monthset = months;
//            yearset = years;
//            views.setText(yearset + "   " + monthset + " " + dateset);
//
//        } else if (milib > milis) {
//            views.setText("দুঃখিত আপনার নির্বাচিত তারিখ ভুল");
//        } else
//            views.setText(years + "   " + months + " " + date);
//      }
}