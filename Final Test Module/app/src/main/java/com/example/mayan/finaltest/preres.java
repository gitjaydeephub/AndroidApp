package com.example.mayan.finaltest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Collections;


public class preres extends ActionBarActivity {
    String testid="",nam="",text="";
    TextView rank,pres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i=getIntent();
        testid
                = i.getStringExtra("uname");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preres);
        SharedPreferences name=getSharedPreferences("name", MODE_PRIVATE);
        nam=  name.getString("Uname", "");

        rank= (TextView) findViewById(R.id.rank);
pres= (TextView) findViewById(R.id.per);

        try {


            new LongOperation().execute("");
        } catch (Exception ex) {
           }

    }

    public class LongOperation extends AsyncTask<String, Void, String> {
        String []v;
        @Override
        protected String doInBackground(String... params) {
            try {
                // Get user defined values


                // Create data variable for sent values to server
                String data =

                        "&" + URLEncoder.encode("email", "UTF-8") + "="
                                + URLEncoder.encode("m", "UTF-8");

                data += "&" + URLEncoder.encode("testid", "UTF-8")
                        + "=" + URLEncoder.encode(testid, "UTF-8");



                BufferedReader reader=null;

                // Send data
                try
                {

                    // Defined URL  where to send data
                    URL url = new URL("http://192.168.43.148/upload/rank.php");

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
                    char [] chars=text.toCharArray();

                    int c=0,j=0;
                    int len = chars.length;
                    for(int i=0;i<len;i++)
                    {
                        if(chars[i]=='~')
                        {
                            c++;
                        }}
                    String[] lis=new String[c+1];
                    for(int i=0;i<c+1;i++)
                    {
                        lis[i]="";
                    }

                    for(int i=0;i<len;i++)
                    {
                        if(chars[i]=='~')
                        { j++;
                        }
                        else {

                            lis[j] += chars[i];

                        }

                    }
                    v=lis;
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

rank.setText(v[2]);
            pres.setText(v[1]);

                       // content.setText(""+Ques[1][5]);
        }


        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }






}
