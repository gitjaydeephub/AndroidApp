package com.example.mayan.finaltest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class TR extends ActionBarActivity {

String name="";
    @Override

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Cannot Exit",
                Toast.LENGTH_SHORT).show();
    }

    protected void onCreate(Bundle savedInstanceState) {
        Intent i=getIntent();
        name = i.getStringExtra("uname");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tr);

    Button test,result;
        test= (Button) findViewById(R.id.te);
        Button lg=(Button)findViewById(R.id.out);

        lg.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
                nextScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //Sending data to another Activity


                startActivity(nextScreen);

            }
        });


        result= (Button) findViewById(R.id.re);
//    SharedPreferences na=getSharedPreferences("TT", MODE_PRIVATE);
//        String  nam=  na.getString("xyz", "");
      //Toast.makeText(getApplicationContext(), "  ddd " + name, Toast.LENGTH_SHORT).show();
//test.setText(name);
        test.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                Intent next = new Intent(getApplicationContext(), Questions.class);

                //Sending data to another Activity
                next.putExtra("uname", name);


                startActivity(next);
            }
        });

        result.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
          try {
              Intent next = new Intent(getApplicationContext(), PreResult2.class);

             // Sending data to another Activity
               next.putExtra("uname",name);

              startActivity(next);

          }catch (Exception e){Toast.makeText(getApplicationContext(),""+e,Toast.LENGTH_SHORT).show();}
          }
        });




    }





}
