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
 * Created by Dhakad on 1/6/2016.
 */
public class Verbal extends Activity {public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
    Intent i = getIntent();


    final String name = i.getStringExtra("uname");
    final String Level = i.getStringExtra("Level");
    Log.e("Second Screen", name + "." + Level);

    setContentView(R.layout.verbal);
    Button btn_v1 = (Button) findViewById(R.id.btn_v1);
    btn_v1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String cat = "v1";

            Intent i = new Intent(getApplicationContext(), TestPage.class);
            i.putExtra("cat", cat);
            i.putExtra("uname", name);
            i.putExtra("Level", Level);
            startActivity(i);
        }
    });

    // v2 is the Classification Category
    Button btn_v2 = (Button) findViewById(R.id.btn_v2);
    btn_v2.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String cat = "v2";

            Intent i = new Intent(getApplicationContext(), TestPage.class);
            i.putExtra("cat", cat);
            i.putExtra("uname", name);
            i.putExtra("Level", Level);
            startActivity(i);
        }
    });

    // v3 is the Series Completion Category
    Button btn_v3 = (Button) findViewById(R.id.btn_v3);
    btn_v3.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String cat = "v3";

            Intent i = new Intent(getApplicationContext(), TestPage.class);
            i.putExtra("cat", cat);
            i.putExtra("uname", name);
            i.putExtra("Level", Level);
            startActivity(i);
        }
    });

    // v4 is the Coding And Decoding Category
    Button btn_v4 = (Button) findViewById(R.id.btn_v4);
    btn_v4.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String cat = "v4";

            Intent i = new Intent(getApplicationContext(), TestPage.class);
            i.putExtra("cat", cat);
            i.putExtra("uname", name);
            i.putExtra("Level", Level);
            startActivity(i);
        }
    });

    // v5 is the Blood Relations Category
//    Button btn_v5 = (Button) findViewById(R.id.btn_v5);
//    btn_v5.setOnClickListener(new View.OnClickListener() {
//
//        @Override
//        public void onClick(View view) {
//            String cat = "v5";
//
//            Intent i = new Intent(getApplicationContext(), TestPage.class);
//            i.putExtra("cat", cat);
//            i.putExtra("uname", name);
//            i.putExtra("Level", Level);
//            startActivity(i);
//        }
//    });

    // v6 is the Logical Sequence And Words Category
    Button btn_v6 = (Button) findViewById(R.id.btn_v6);
    btn_v6.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String cat = "v6";

            Intent i = new Intent(getApplicationContext(), TestPage.class);
            i.putExtra("cat", cat);
            i.putExtra("uname", name);
            i.putExtra("Level", Level);
            startActivity(i);
        }
    });

    // v7 is the Decision Making Category
//    Button btn_v7 = (Button) findViewById(R.id.btn_v7);
//    btn_v7.setOnClickListener(new View.OnClickListener() {
//
//        @Override
//        public void onClick(View view) {
//            String cat = "v7";
//            Intent i = new Intent(getApplicationContext(), TestPage.class);
//            i.putExtra("cat", cat);
//            i.putExtra("uname", name);
//            i.putExtra("Level", Level);
//
//            startActivity(i);
//        }
//    });

    Button btn_v8 = (Button) findViewById(R.id.btn_v8);
    btn_v8.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String cat = "v8";
            Intent i = new Intent(getApplicationContext(), TestPage.class);
            i.putExtra("cat", cat);
            i.putExtra("uname", name);
            i.putExtra("Level", Level);

            startActivity(i);
        }
    });
    Button btn_v9 = (Button) findViewById(R.id.btn_v9);
    btn_v9.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String cat = "v9";
            Intent i = new Intent(getApplicationContext(), TestPage.class);
            i.putExtra("cat", cat);
            i.putExtra("uname", name);
            i.putExtra("Level", Level);

            startActivity(i);
        }
    });

}
}
