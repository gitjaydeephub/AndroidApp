package com.example.dhakad.aptitudetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Dhakad on 1/10/2016.
 */
public class Questions extends Activity {
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Cannot Exit",
                Toast.LENGTH_SHORT).show();
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.question);
        Button Verbal ,Aptitude,logical,result,logout;
        Intent i = getIntent();


        final String name = i.getStringExtra("uname");
        final String Level = i.getStringExtra("Level");
        Log.e("Second Screen", name + "." + Level);
        Toast.makeText(getApplicationContext(), "Welcome",
                Toast.LENGTH_LONG).show();



        result= (Button) findViewById(R.id.result);
        Verbal= (Button) findViewById(R.id.ver);
        Aptitude= (Button) findViewById(R.id.apti);
        logout= (Button) findViewById(R.id.lg);
        logout.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
                nextScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //Sending data to another Activity


                startActivity(nextScreen);

            }
        });
        Verbal.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {


                Intent nextScreen = new Intent(getApplicationContext(), Verbal.class);

                //Sending data to another Activity
                nextScreen.putExtra("uname", name);
                nextScreen.putExtra("Level", Level);


                startActivity(nextScreen);
            }
        });
        logical= (Button) findViewById(R.id.reaso);
        logical.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {


                Intent nextScreen = new Intent(getApplicationContext(), logical1.class);

                //Sending data to another Activity
                nextScreen.putExtra("uname", name);
                nextScreen.putExtra("Level", Level);


                startActivity(nextScreen);
            }
        });
        Aptitude.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {


                Intent nextScreen = new Intent(getApplicationContext(), Aptitude.class);

                //Sending data to another Activity
                nextScreen.putExtra("uname", name);
                nextScreen.putExtra("Level", Level);


                startActivity(nextScreen);
            }
        });
        result.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {


                Intent nextScreen = new Intent(getApplicationContext(), Result.class);

                //Sending data to another Activity
                nextScreen.putExtra("uname", name);
                nextScreen.putExtra("Level", Level);


                startActivity(nextScreen);
            }
        });

    }
}




