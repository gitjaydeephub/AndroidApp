package com.example.mayan.finaltest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.util.Collections;
import java.util.Random;

/**
 * Created by mayan on 02-02-2016.
 */
public class TestPage extends Activity {
    String name = "";
    TextView content, T;
    EditText email, pass;
    Long tim;
    int ti = 180;//time in seconds
    String Ques[][] = new String[100][6];

    String Name, nemail = "haha", Login, Pass, text = "55858", text1;
    Button next;
    int rnew = 0, wnew = 0, r = 0, w = 0, at = 0, r1 = 0, i1 = 0;
    String atm, rn, wn;
    int level = 0;
    int start = 1;
    int qid = 0;
    int b[] = new int[100];
    int ans[] = new int[100];
    final ArrayList<Integer> number = new ArrayList<Integer>();

    String o1, o2, o3, o4, d;
    TextView questionTextView, questionTrack, time;
    RadioButton a1, a2, a3, a4;
    RadioGroup radiogroup;
    Button finish;

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Cannot Exit",
                Toast.LENGTH_SHORT).show();
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();

        SharedPreferences sessDataGet = getSharedPreferences("SESSION_DATA", MODE_PRIVATE);
        nemail = sessDataGet.getString("email", "");

        name = i.getStringExtra("uname");


        try {

            // Toast.makeText(getApplicationContext(), "First Execution ", Toast.LENGTH_LONG).show();

            new LongOperation5().execute("");
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Error in First Execution ", Toast.LENGTH_LONG).show();
        }


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(TestPage.this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);

        // Setting Dialog Title
        alertDialog.setTitle("Start Test");

        // Setting Dialog Message
        alertDialog.setMessage("Are you sure you want to start Test");

        // Setting Icon to Dialog


        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        new CountDownTimer(ti * 1000, 1000) {

                            public void onTick(long millisUntilFinished) {
                                tim = ti - millisUntilFinished / 1000;

                                time.setText("Time remaining: " + (millisUntilFinished) / 1000 / 60 + ":" + (millisUntilFinished) / 1000 % 60);


                            }

                            public void onFinish() {
                           finish.post(new Runnable() {
                               @Override
                               public void run() {
                                   finish.performClick();
                               }

                           });

                            }
                        }.start();


                        try {


                            new LongOperation4().execute("");
                        } catch (Exception ex) {
                            Toast.makeText(getApplicationContext(), "Error in First Execution ", Toast.LENGTH_LONG).show();
                        }            // Write your code here to execute after dialog
                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        TestPage.this.finish();
                        Intent pre = new Intent(getApplicationContext(), Questions.class);

                        //Sending data to another Activity
                        pre.putExtra("uname", name);
                        // Write your code here to execute after dialog
                        Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });


        // Showing Alert Message
        alertDialog.show();

//        Toast.makeText(getApplicationContext(), "Welcome" + nemail + "Category" + name,
        //              Toast.LENGTH_LONG).show();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.tp);
        radiogroup = (RadioGroup) findViewById(R.id.options);
        TextView ss = (TextView) findViewById(R.id.ss);
        ss.setText(name);
        time = (TextView) findViewById(R.id.time);
        try {


            new LongOperation().execute("");
        } catch (Exception ex) {
            content.setText("question  ");
        }

        a1 = (RadioButton) findViewById(R.id.option1);
        a2 = (RadioButton) findViewById(R.id.option2);
        a3 = (RadioButton) findViewById(R.id.option3);
        a4 = (RadioButton) findViewById(R.id.option4);
        content = (TextView) findViewById(R.id.question);
        next = (Button) findViewById(R.id.nxt);
        finish = (Button) findViewById(R.id.fin);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if (a1.isChecked()) {
                        b[number.get(qid)] = 1;


                    } else if (a2.isChecked()) {
                        b[number.get(qid)] = 2;

                    } else if (a3.isChecked()) {
                        b[number.get(qid)] = 3;

                    } else if (a4.isChecked()) {
                        b[number.get(qid)] = 4;
                    }

                }


        });

        next.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                try {
                    radiogroup.clearCheck();
                    Random r = new Random();
                    i1 = r.nextInt(4);
                    qid++;
                    content.setText(Ques[number.get(qid)][0]);
                    a1.setText(Ques[number.get(qid)][((i1)%4)+1]);
                    a2.setText(Ques[number.get(qid)][((i1+1)%4)+1]);
                    a3.setText(Ques[number.get(qid)][((i1+2)%4)+1]);
                    a4.setText(Ques[number.get(qid)][((i1+3)%4)+1]);

                    int t = 0;
                    t = Integer.parseInt(Ques[number.get(qid)][5].trim());
                    int temp=4-i1;
                    if((t+temp)!=4) {
                        ans[number.get(qid)] = (t + temp) % 4;
                    }
                    else
                        ans[number.get(qid)]=4;
                } catch (Exception ex) {

                    //Exception is generated when no more Question is available so we forward it to another activity
                        finish.post(new Runnable() {
                            @Override
                            public void run() {
                                finish.performClick();
                            }

                        });
                }


            }
        });

        finish.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                try {
                    at = 0;
                    r1 = 0;


                    for (int i = 0; i < 40; i++) {
                        if (b[i] != 0) {
                            at++;
                            if (b[i] == ans[i]) {
                                r1++;


                            } else
                                w++;
                        }

                    }
                    r = r1;
                    atm = String.valueOf(at);



                } catch (Exception ex) {
                    content.setText(" check ");
                }


                rn = "" + r;
                wn = "" + w;
                try {


                    new LongOperation1().execute("");
                } catch (Exception ex) {

                }

                Intent nextScreen = new Intent(getApplicationContext(), Result.class);

                String ri;
                ri = String.valueOf(r);
                //Sending data to another Activity
                nextScreen.putExtra("uname", name);
                nextScreen.putExtra("nemail", nemail);
                nextScreen.putExtra("time", tim);
                nextScreen.putExtra("r", ri);
                nextScreen.putExtra("a", atm);

                startActivity(nextScreen);

            }
        });


    }


    public class LongOperation extends AsyncTask<String, Void, String> {
        String[] v;

        @Override
        protected String doInBackground(String... params) {
            try {
                // Get user defined values


                // Create data variable for sent values to server
                String data =

                        "&" + URLEncoder.encode("email", "UTF-8") + "="
                                + URLEncoder.encode(name, "UTF-8");

                data += "&" + URLEncoder.encode("tname", "UTF-8")
                        + "=" + URLEncoder.encode(name, "UTF-8");


                BufferedReader reader = null;

                // Send data
                try {

                    // Defined URL  where to send data
                    URL url = new URL("http://10.0.2.2/upload/tques.php");

                    // Send POST data request

                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();

                    // Get the server response

                    reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        // Append server response in string
                        sb.append(line + "\n");
                    }


                    text = sb.toString();
                } catch (Exception ex) {

                } finally {
                    char[] chars = text.toCharArray();

                    int c = 0, j = 0;
                    int len = chars.length;
                    for (int i = 0; i < len; i++) {
                        if (chars[i] == '~') {
                            c++;
                        }
                    }
                    String[] lis = new String[c + 1];
                    for (int i = 0; i < c + 1; i++) {
                        lis[i] = "";
                    }

                    for (int i = 0; i < len; i++) {
                        if (chars[i] == '~') {
                            j++;
                        } else {

                            lis[j] += chars[i];

                        }

                    }
                    v = lis;
                    try {

                        reader.close();
                    } catch (Exception ex) {
                    }
                }

                // Show response on activity

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            for (int i = 0; i < (v.length / 6); i++) {
                for (int j = 0; j < 6; j++) {
                    Ques[i][j] = "";
                    Ques[i][j] = v[i * 6 + j + 1];
                }


            }
            for (int ii = 0; ii < v.length / 6; ++ii) number.add(ii);
            Collections.shuffle(number);

            content.setText(" " + v.length);


            radiogroup.clearCheck();

            content.setText(Ques[number.get(0)][0]);
            a1.setText(Ques[number.get(0)][1]);
            a2.setText(Ques[number.get(0)][2]);
            a3.setText(Ques[number.get(0)][3]);
            a4.setText(Ques[number.get(0)][4]);
            int t = 0;
            t = Integer.parseInt(Ques[number.get(0)][5].trim());
            ans[number.get(0)] = t;

            // content.setText(""+Ques[1][5]);
        }


        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }


    public class LongOperation1 extends AsyncTask<String, Void, String> {
    String v[];
        @Override
        protected String doInBackground(String... params) {
            try {
                // Get user defined values


                // Create data variable for sent values to server
                String data =

                        "&" + URLEncoder.encode("email", "UTF-8") + "="
                                + URLEncoder.encode(nemail, "UTF-8");


                data += "&" + URLEncoder.encode("tname", "UTF-8")
                        + "=" + URLEncoder.encode(name, "UTF-8");
                data += "&" + URLEncoder.encode("right", "UTF-8")
                        + "=" + URLEncoder.encode(rn, "UTF-8");
                data += "&" + URLEncoder.encode("wrong", "UTF-8")
                        + "=" + URLEncoder.encode(wn, "UTF-8");


                BufferedReader reader = null;

                // Send data
                try {

                    // Defined URL  where to send data
                    URL url = new URL("http://10.0.2.2/upload/tr.php");

                    // Send POST data request

                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();

                    // Get the server response

                    reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        // Append server response in string
                        sb.append(line + "\n");
                    }


                    text1 = sb.toString();
                } catch (Exception ex) {

                } finally {
                    char[] chars = text.toCharArray();

                    int c = 0, j = 0;
                    int len = chars.length;
                    for (int i = 0; i < len; i++) {
                        if (chars[i] == '~') {
                            c++;
                        }
                    }
                    String[] lis = new String[c + 1];
                    for (int i = 0; i < c; i++) {
                        lis[i] = "";
                    }

                    for (int i = 0; i < len; i++) {
                        if (chars[i] == '~') {
                            j++;
                        } else {

                            lis[j] += chars[i];

                        }

                    }
                    v = lis;

                    try {

                        reader.close();
                    } catch (Exception ex) {
                    }
                }

                // Show response on activity

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
           // Toast.makeText(getApplicationContext(),v[2],Toast.LENGTH_LONG).show();
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }


    public class LongOperation5 extends AsyncTask<String, Void, String> {
        String[] v;
//    String cat1=v[2];
        //  String nemail1=v[1];

        @Override
        protected String doInBackground(String... params) {
            try {
                // Get user defined values

//                Toast.makeText(getApplicationContext(), "Welcome" + nemail+"cat="+ name  ,
                //                      Toast.LENGTH_LONG).show();

                // Create data variable for sent values to server

                String data =

                        "&" + URLEncoder.encode("email", "UTF-8") + "="
                                + URLEncoder.encode(nemail, "UTF-8");


                data += "&" + URLEncoder.encode("tname", "UTF-8")
                        + "=" + URLEncoder.encode(name, "UTF-8");


                BufferedReader reader = null;

                // Send data
                try {

                    // Defined URL  where to send data
                    URL url = new URL("http://10.0.2.2/upload/precheck.php");

                    // Send POST data request

                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();

                    // Get the server response

                    reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        // Append server response in string
                        sb.append(line + "\n");
                    }


                    text = sb.toString();
                } catch (Exception ex) {

                } finally {
                    char[] chars = text.toCharArray();

                    int c = 0, j = 0;
                    int len = chars.length;
                    for (int i = 0; i < len; i++) {
                        if (chars[i] == '~') {
                            c++;
                        }
                    }
                    String[] lis = new String[c + 1];
                    for (int i = 0; i < c; i++) {
                        lis[i] = "";
                    }

                    for (int i = 0; i < len; i++) {
                        if (chars[i] == '~') {
                            j++;
                        } else {

                            lis[j] += chars[i];

                        }

                    }
                    v = lis;
                    try {

                        reader.close();
                    } catch (Exception ex) {
                    }
                }

                // Show response on activity

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

            if (v.length >= 0 && v[1].equals("true")) {
                //               next = new Intent(getApplicationContext(), TR.class);
                Toast.makeText(getApplicationContext(), "Test attempted", Toast.LENGTH_LONG).show();
                Intent next = new Intent(getApplicationContext(), TR.class);

                //Sending data to another Activity
                next.putExtra("uname", nemail);


                startActivity(next);

                //Sending data to another Activity
                //next.putExtra("uname", Email);
                //  next.putExtra("Level", v[2]);
                //  final SharedPreferences.Editor name =(SharedPreferences.Editor)getSharedPreferences("TT", Context.MODE_PRIVATE).edit();
//name.putString("xyz","sachin");
                //             startActivity(next);
            } else
            {

                // Integer.parseInt(v[2].trim());
                v[2] = v[2].trim();
               // qid = Integer.parseInt(v[7]);
               int t=Integer.parseInt(v[2]);
                //Toast.makeText(getApplicationContext(),""+t,Toast.LENGTH_LONG).show();
                ti=t;
            }         //   Toast.makeText(getApplicationContext(),"Test Not attempted",Toast.LENGTH_LONG).show();

            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }

    public class LongOperation4 extends AsyncTask<String, Void, String> {
        String[] v;
//    String cat1=v[2];
        //  String nemail1=v[1];

        @Override
        protected String doInBackground(String... params) {
            try {
                // Get user defined values

//                Toast.makeText(getApplicationContext(), "Welcome" + nemail+"cat="+ name  ,
                //                      Toast.LENGTH_LONG).show();

                //Toast.makeText(getApplicationContext(), "Email->"+nemail+"name->"+name, Toast.LENGTH_LONG).show();
                // Create data variable for sent values to server

                String data =

                        "&" + URLEncoder.encode("email", "UTF-8") + "="
                                + URLEncoder.encode(nemail, "UTF-8");


                data += "&" + URLEncoder.encode("tname", "UTF-8")
                        + "=" + URLEncoder.encode(name, "UTF-8");


                BufferedReader reader = null;

                // Send data
                try {

                    // Defined URL  where to send data
                    URL url = new URL("http://10.0.2.2/upload/onteststart.php");

                    // Send POST data request

                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();

                    // Get the server response

                    reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        // Append server response in string
                        sb.append(line + "\n");
                    }


                    text = sb.toString();
                } catch (Exception ex) {

                } finally {
                    char[] chars = text.toCharArray();

                    int c = 0, j = 0;
                    int len = chars.length;
                    for (int i = 0; i < len; i++) {
                        if (chars[i] == '~') {
                            c++;
                        }
                    }
                    String[] lis = new String[c + 1];
                    for (int i = 0; i < c; i++) {
                        lis[i] = "";
                    }

                    for (int i = 0; i < len; i++) {
                        if (chars[i] == '~') {
                            j++;
                        } else {

                            lis[j] += chars[i];

                        }

                    }
                    v = lis;
                    try {

                        reader.close();
                    } catch (Exception ex) {
                    }
                }

                // Show response on activity

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

            if (v.length >= 0 && v[1].equals("true")) {
                //               next = new Intent(getApplicationContext(), TR.class);
                Toast.makeText(getApplicationContext(), "Test started....", Toast.LENGTH_LONG).show();
                           } else
                Toast.makeText(getApplicationContext(),"Problem occured at server side",Toast.LENGTH_LONG).show();

            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}