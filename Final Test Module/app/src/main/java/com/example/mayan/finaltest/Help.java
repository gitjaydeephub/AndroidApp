package com.example.mayan.finaltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TooManyListenersException;

import static android.system.Os.close;

/**
 * Created by mayan on 3/2/2016.
 */
public class Help extends Activity {
    TextView content;
    String a = "In this Application you will be able to give a test. You will have multiple categories in which you can take a test. A test can be attempted once. One your test is finished you will be able to see your result in which you will get your marks and percentege. ";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        content= (TextView)findViewById(R.id.tv);
        content.setText(a);
        content.setMovementMethod(new ScrollingMovementMethod());




        Button s=(Button)findViewById(R.id.back);

        s.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
                //  Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);

                //Sending data to another Activity


                //  startActivity(nextScreen);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

            }
        });
    }

}
