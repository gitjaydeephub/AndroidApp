package com.example.dhakad.aptitudetest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
 * Created by Dhakad on 1/3/2016.
 */
public class MainActivity extends Activity {
    String Uname="";
    int Level=0;
    void toa()
    {
        Toast.makeText(getApplicationContext(), "Password OR Email Incorrect",
                Toast.LENGTH_LONG).show();

    }


    TextView content;
    EditText email,  pass;
    String Name, Email, Login, Pass,text="55858";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        content= (TextView) findViewById(R.id.textView);
        email      =   (EditText)findViewById(R.id.email);

        pass       =   (EditText)findViewById(R.id.password);

        Button help=(Button)findViewById(R.id.help);

        Button saveme=(Button)findViewById(R.id.apti);
        Button s=(Button)findViewById(R.id.s);
        Button e=(Button)findViewById(R.id.exit);

        e.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                //  android.os.Process.killProcess(android.os.Process.myPid());
                // System.exit(1);
                finish();


            }
        });

        help.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {


                Intent nextScreen = new Intent(getApplicationContext(), Help.class);

                //Sending data to another Activity


                startActivity(nextScreen);

            }
        });

        s.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {


                Intent nextScreen = new Intent(getApplicationContext(), SignUp.class);

                //Sending data to another Activity


                startActivity(nextScreen);
            }
        });

        saveme.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                try {

                    // CALL GetText method to make post method call
                    Email   = email.getText().toString();

                    Pass   = pass.getText().toString();
                    if(!Email.matches("")&&!Pass.matches(""))
                        new LongOperation().execute("");
                    else
                        toa();
                } catch (Exception ex) {
                    content.setText(" url exeption! ");
                }


            }
        });


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



                data += "&" + URLEncoder.encode("pass", "UTF-8")
                        + "=" + URLEncoder.encode(Pass, "UTF-8");


                BufferedReader reader=null;

                // Send data
                try
                {

                    // Defined URL  where to send data
                    URL url = new URL("http://192.168.43.148/project1/fp.php");

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

            int len =text.indexOf("t");
            Uname=v[3];
            String s="a";
            Level= Integer.parseInt(v[2]);
            //  content.setText(text + " " + Uname + " " + Level);
            if(len >= 0 && !Uname.equals(s))
            {
//                SharedPreferences tabno = getSharedPreferences("TABNO", MODE_PRIVATE);
//                table = tabno.getInt("tab1", 0);
                //   Toast.makeText(getApplicationContext(), "Right Password", Toast.LENGTH_LONG).show();


                final SharedPreferences.Editor sessionData= (SharedPreferences.Editor) getSharedPreferences("SESSION_DATA", Context.MODE_PRIVATE).edit();
                sessionData.putString("email", Email);
                sessionData.commit();



                Intent next = new Intent(getApplicationContext(), Questions.class);

                //Sending data to another Activity
                next.putExtra("uname", Uname);
                next.putExtra("Level", v[2]);


                startActivity(next);}
            else {
                Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();

                // Intent next = new Intent(getApplicationContext(), MainActivity.class);
                //startActivity(next) ;
            }// might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}