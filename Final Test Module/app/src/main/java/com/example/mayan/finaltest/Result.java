package com.example.mayan.finaltest;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 */
public class Result extends Activity {
String text;
TextView per,acc;
    int a;
    int r;
String nemail;
    String name;
    String right;
    String cat;
    String time;
    String atempted;
    int accuracy;
    Button finish;

    public void onCreate(Bundle savedInstanceState) {
        //Toast.makeText(getApplicationContext(), "  dddDfdkfkdjfkdjf " , Toast.LENGTH_LONG).show();

        Intent i = getIntent();
        nemail=i.getStringExtra("nemail");
        name = i.getStringExtra("uname");
        right = i.getStringExtra("r");
       // cat = i.getStringExtra("cat");
        time = i.getStringExtra("time");
        atempted = i.getStringExtra("a");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.result);
        acc = (TextView) findViewById(R.id.acc);
        acc.setText(atempted);
        ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
        //per = (TextView) findViewById(R.id.rank);
        //per.setText(name);
        TextView ri;
        ri= (TextView) findViewById(R.id.r);
        ri.setText(" "+ right);
        Boolean isInternetPresent = cd.isConnectingToInternet();
        finish= (Button) findViewById(R.id.fin1);

        //if (!isInternetPresent) {
          //  android.os.Process.killProcess(android.os.Process.myPid());
            //System.exit(1);
        //}
//        try
//        {
//           new LongOperation().execute("");
//
//        }
//        catch (Exception e)
//        {
//
//        }
        try
        {
//            new LongOperation().execute("");

        }
        catch (Exception e)
        {

        }
//        Toast.makeText(getApplicationContext(), "  dddDfdkfkdjfkdjf " , Toast.LENGTH_LONG).show();

        finish.setOnClickListener(new Button.OnClickListener() {


            @Override
            public void onClick(View v) {


                Intent nextScreen = new Intent(getApplicationContext(), TR.class);
               // Toast.makeText(getApplicationContext(),nemail,Toast.LENGTH_LONG).show();
                nextScreen.putExtra("uname",nemail);
                startActivity(nextScreen);

            }
        });



    }


/*
    public class LongOperation extends AsyncTask<String, Void, String> {
        String []v;

        @Override
        protected String doInBackground(String... params) {
            try {
                // Get user defined values


                // Create data variable for sent values to server
                String data =

                        "&" + URLEncoder.encode("score", "UTF-8") + "="
                                + URLEncoder.encode(right, "UTF-8");



                data += "&" + URLEncoder.encode("name", "UTF-8")
                        + "=" + URLEncoder.encode(name, "UTF-8");


                data += "&" + URLEncoder.encode("cat", "UTF-8")
                        + "=" + URLEncoder.encode(cat, "UTF-8");

                BufferedReader reader=null;

                // Send data
                try
                {

                    // Defined URL  where to send data
                    URL url = new URL("http://192.168.43.148/upload/result.php");

                    // Send POST data request

                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write( data );
                    wr.flush();

                    // Get the server response

                    reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while((line = reader.readLine()) != null)
                    {
                        // Append server response in string
                        sb.append(line + "\n");
                    }


                    text = sb.toString();
                }
                catch(Exception ex)
                {

                }
                finally
                {
                    try
                    {

                        reader.close();
                    }

                    catch(Exception ex) {}
                }

                // Show response on activity

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {


per.setText(text.substring(0,4));
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
    */
}
