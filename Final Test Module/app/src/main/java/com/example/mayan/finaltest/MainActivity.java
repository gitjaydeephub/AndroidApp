package com.example.mayan.finaltest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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


public class MainActivity extends Activity {
    String Uname="";
    int Level=0;
    Intent next;
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
        ConnectionDetector cd = new ConnectionDetector(getApplicationContext());

            Boolean isInternetPresent = cd.isConnectingToInternet();
            if (!isInternetPresent)
            {AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

                // Setting Dialog Title
                alertDialog.setTitle("NO INTERNET ");

                // Setting Dialog Message
                alertDialog.setMessage("No Internet Availabe Do You Want Open Settings");
                // Setting Icon to Dialog


                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);

                                // Write your code here to execute after dialog
                                //Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                            }
                        });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                MainActivity.this.finish();


                            }
                        });




                // Showing Alert Message
            alertDialog.show();




        }

        content= (TextView) findViewById(R.id.textView);
        email      =   (EditText)findViewById(R.id.email);

        pass       =   (EditText)findViewById(R.id.password);


        Button saveme=(Button)findViewById(R.id.apti);
        Button s=(Button)findViewById(R.id.s);
        Button exit=(Button)findViewById(R.id.ex);

        exit.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {


                finish();
            }
        });

        s.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {


                Intent nextScreen = new Intent(getApplicationContext(), SignUp.class);

                //Sending data to another Activity


                startActivity(nextScreen);
            }
        });
        Button help=(Button)findViewById(R.id.help);

        help.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {


                Intent nextScreen = new Intent(getApplicationContext(), Help.class);

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
                    if(!Email.matches("")&&!Pass.matches("")) {

                        final SharedPreferences.Editor sessionData= (SharedPreferences.Editor) getSharedPreferences("SESSION_DATA", Context.MODE_PRIVATE).edit();
                        sessionData.putString("email", Email);
                        sessionData.commit();

                        new LongOperation().execute("");
                    }
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
                    URL url = new URL("http://10.0.2.2/upload/fp.php");

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

            if(v.length>=3&&v[1].equals("true") )
            {next = new Intent(getApplicationContext(), TR.class);

                //Sending data to another Activity
                next.putExtra("uname", Email);
              //  next.putExtra("Level", v[2]);
              //  final SharedPreferences.Editor name =(SharedPreferences.Editor)getSharedPreferences("TT", Context.MODE_PRIVATE).edit();
//name.putString("xyz","sachin");
                startActivity(next);}
            else toa();

            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}