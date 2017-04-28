package com.example.dhakad.aptitudetest;

/**
 * Created by Dhakad on 1/3/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Aptitude extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();


        final String name = i.getStringExtra("uname");
        final String Level = i.getStringExtra("Level");
        Log.e("Second Screen", name + "." + Level);

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.aptitude);
//        Button btn_q1 = (Button) findViewById(R.id.btn_q1);
//        btn_q1.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "q1";
//
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//
//                startActivity(i);
//            }
//        });



        // q2 is the Square Root and Cube Root Category
        Button btn_q2 = (Button) findViewById(R.id.btn_q2);
        btn_q2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "q2";

                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

        // q3 is the Square Root and Cube Root Category
        Button btn_q3 = (Button) findViewById(R.id.btn_q3);
        btn_q3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "q3";

                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

        // q4 is the Problem on Numbers and Ages Category
        Button btn_q4 = (Button) findViewById(R.id.btn_q4);
        btn_q4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "q4";
                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

        // q5 is the Percentage Category
//        Button btn_q5 = (Button) findViewById(R.id.btn_q5);
//        btn_q5.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                // Launching News Feed Screen
//                String cat = "q5";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });

        // q6 is the Profit and Loss Category
        Button btn_q6 = (Button) findViewById(R.id.btn_q6);
        btn_q6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "q6";
                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

        // q7 is the Ratio and Proportion Category
//        Button btn_q7 = (Button) findViewById(R.id.btn_q7);
//        btn_q7.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "q7";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });

        // q8 is the Partnership Category
        Button btn_q8 = (Button) findViewById(R.id.btn_q8);
        btn_q8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "q8";
                Intent i = new Intent(getApplicationContext(), TestPage.class);

                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });


        // q10 is the Time and Work and Distance
        Button btn_q10 = (Button) findViewById(R.id.btn_q10);
        btn_q10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "q10";
                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

        // q11 is the Problem on Trains,Boats and Streams Category
//        Button btn_q11 = (Button) findViewById(R.id.btn_q11);
//        btn_q11.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "q11";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });

        // q12 is the Simple Interest and Compound Interest Category
//        Button btn_q12 = (Button) findViewById(R.id.btn_q12);
//        btn_q12.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "q12";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });

        // q13 is the Area and Volume Category
        Button btn_q13 = (Button) findViewById(R.id.btn_q13);
        btn_q13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "q13";
                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

        // q15 is the Stocks and Shares Category
//        Button btn_q15 = (Button) findViewById(R.id.btn_q15);
//        btn_q15.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "q15";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });

        // q16 is the Permutation and Combination Category
//        Button btn_q16 = (Button) findViewById(R.id.btn_q16);
//        btn_q16.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "q16";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });

        // q17 is the Probability Category
        Button btn_q17 = (Button) findViewById(R.id.btn_q17);
        btn_q17.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "q17";
                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

    }
}

