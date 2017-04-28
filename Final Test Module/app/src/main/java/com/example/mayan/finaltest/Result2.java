package com.example.mayan.finaltest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by mayan on 2/28/2016.
 */
public class Result2 extends Activity{


    int ln=0;
    ListView lView ;
    String tname ="",sname,m;
    String email="";
    String v[];
    TextView rank,pres;
    String s = null;
    // TextView content;
    //  EditText fname, email, login, pass;
    String  Email="", Login, Pass,text;
    String[] lv1 =new String[]{"hii","bye"} ;
    /** Called when the activity is first created. */
    String[] l=new String[2];
    ArrayList<String> list = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();

        tname = i.getStringExtra("uname");
        SharedPreferences sessDataGet= getSharedPreferences("SESSION_DATA", MODE_PRIVATE);
        Email = sessDataGet.getString("email", "");
        setContentView(R.layout.r2);
        //Toast.makeText(getApplicationContext(), "You "+tname+"->"+Email,Toast.LENGTH_SHORT).show();

        rank= (TextView) findViewById(R.id.rank1);
        pres= (TextView) findViewById(R.id.per1);

        try {

            // CALL GetText method to make post method call

            new LongOperation().execute("");


        } catch (Exception ex) {
            //content.setText(" url exeption! ");
        }


        //Button savee = (Button) findViewById(R.id.save);
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
                                + URLEncoder.encode(Email, "UTF-8");



                data += "&" + URLEncoder.encode("tname", "UTF-8")
                        + "=" + URLEncoder.encode(tname, "UTF-8");


                BufferedReader reader=null;

                // Send data
                try
                {

                    // Defined URL  where to send data
                    URL url = new URL("http://10.0.2.2/upload/rank.php");

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
                    for(int i=0;i<c;i++)
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
            //Toast.makeText(getApplicationContext(), "Incorrect",
              //      Toast.LENGTH_LONG).show();

            rank.setText(v[2]);
            pres.setText(v[3]);
           // Toast.makeText(getApplicationContext(), "Password OR Email Incorrect",
             //       Toast.LENGTH_LONG).show();
                int len =text.indexOf("t");
                m=v[3];
                String s="a";
                //Level= Integer.parseInt(v[2]);

                //content.setText(text + " " + Uname + " " + Level);
                if(len >= 0 )
                {
//                SharedPreferences tabno = getSharedPreferences("TABNO", MODE_PRIVATE);
//                table = tabno.getInt("tab1", 0);
                    //   Toast.makeText(getApplicationContext(), "Right Password", Toast.LENGTH_LONG).show();
          //          Toast.makeText(getApplicationContext(), "right Password", Toast.LENGTH_LONG).show();


                   // final SharedPreferences.Editor sessionData= (SharedPreferences.Editor) getSharedPreferences("SESSION_DATA", Context.MODE_PRIVATE).edit();
                   // sessionData.putString("email", Email);
                    //sessionData.commit();



                    //Intent next = new Intent(getApplicationContext(), Questions.class);

                    //Sending data to another Activity
                    //next.putExtra("uname", sname);
                    //next.putExtra("Level", v[2]);


                  //  startActivity(next);
                  }
                else {
                    Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();

                   // Intent next = new Intent(getApplicationContext(), MainActivity.class);
                   // startActivity(next) ;
                }// might want to change "executed" for the returned string passed
                // into onPostExecute() but that is upto you}




    }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }



}
