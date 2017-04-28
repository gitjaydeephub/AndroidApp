package com.example.dhakad.aptitudetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by Dhakad on 2/6/2016.
 */
public class logical1 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();


        final String name = i.getStringExtra("uname");
        final String Level = i.getStringExtra("Level");
        Log.e("Second Screen", name + "." + Level);

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.logical);
        Button btn_l1 = (Button) findViewById(R.id.btn_l1);
        btn_l1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "l1";

                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);

                startActivity(i);
            }
        });

        // q2 is the Square Root and Cube Root Category
        Button btn_l2 = (Button) findViewById(R.id.btn_l2);
        btn_l2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "l2";

                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

        // q2 is the Square Root and Cube Root Category
//        Button btn_l3 = (Button) findViewById(R.id.btn_l3);
//        btn_l3.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "l3";
//
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });

        // q4 is the Problem on Numbers and Ages Category
//        Button btn_l4 = (Button) findViewById(R.id.btn_l4);
//        btn_l4.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "l4";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });
//
//        // q5 is the Percentage Category
//        Button btn_l5 = (Button) findViewById(R.id.btn_l5);
//        btn_l5.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                // Launching News Feed Screen
//                String cat = "l5";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });

        // q6 is the Profit and Loss Category
        Button btn_l6 = (Button) findViewById(R.id.btn_l6);
        btn_l6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "l6";
                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

        // q7 is the Ratio and Proportion Category
//        Button btn_l7 = (Button) findViewById(R.id.btn_l7);
//        btn_l7.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "l7";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });

        // q8 is the Partnership Category
        Button btn_l8 = (Button) findViewById(R.id.btn_l8);
        btn_l8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "l8";
                Intent i = new Intent(getApplicationContext(), TestPage.class);

                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

        // q15 is the Stocks and Shares Category
        Button btn_l9 = (Button) findViewById(R.id.btn_l9);
        btn_l9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String cat = "l9";
                Intent i = new Intent(getApplicationContext(), TestPage.class);
                i.putExtra("cat", cat);
                i.putExtra("uname", name);
                i.putExtra("Level", Level);
                startActivity(i);
            }
        });

        // q10 is the Time and Work and Distance
//        Button btn_l10 = (Button) findViewById(R.id.btn_l10);
//        btn_l10.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "l10";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });
//
//        // q11 is the Problem on Trains,Boats and Streams Category
//        Button btn_l11 = (Button) findViewById(R.id.btn_l11);
//        btn_l11.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "l11";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });
//
//        // q12 is the Simple Interest and Compound Interest Category
//        Button btn_l12 = (Button) findViewById(R.id.btn_l12);
//        btn_l12.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "l12";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });
//
//        // q13 is the Area and Volume Category
//        Button btn_l13 = (Button) findViewById(R.id.btn_l13);
//        btn_l13.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "l13";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });
//
//        // q15 is the Stocks and Shares Category
//        Button btn_l14 = (Button) findViewById(R.id.btn_l14);
//        btn_l14.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                String cat = "l14";
//                Intent i = new Intent(getApplicationContext(), TestPage.class);
//                i.putExtra("cat", cat);
//                i.putExtra("uname", name);
//                i.putExtra("Level", Level);
//                startActivity(i);
//            }
//        });
//


    }
}
