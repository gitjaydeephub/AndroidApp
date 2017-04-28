package com.example.dhakad.aptitudetest;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Dhakad on 2/28/2016.
 */
public class Help extends Activity {
    TextView content;
    String a = "In this Application you will be given questions based on your level. Initially you will start at level 0. After every 5 questions you attempt you will get a pop up. Pop up will tell if your level is incremented, decremented or did not change at all. Your level will change on the bases of correctness of the answer and time taken to attempt the question. ";
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
