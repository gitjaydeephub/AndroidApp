package com.example.dhakad.aptitudetest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

/**
 * Created by Dhakad on 2/6/2016.
 */
public class TestPage extends Activity {
    String cat = "";
    TextView content;
    EditText email;
    Long tim,diff;
    Long totime=Long.parseLong("1200000");
    private CountDownTimer count;
    String  Email,name, Login, Pass,text="55858",tex=null;
    Button saveme;
    int level=0,l;
    int lqid[]=new int[6];
    int rr=0,aa=0;
    int aj;
    int start = 1;
    int qid=1;
    int b=0;
    int Level=0;
    int ans=0;

    String o1,o2,o3,o4,te;
    TextView questionTextView, questionTrack,time;
    int  r=0,w = 0, a = 0, r1 = 0,d=0,d2=0;

    RadioButton a1, a2, a3, a4;
    RadioGroup radiogroup;
    Button finish;
    String Name;
//    public void onBackPressed() {
//        Toast.makeText(getApplicationContext(), "You Cannot Exit",
//                Toast.LENGTH_SHORT).show();
//    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();

        final String name = i.getStringExtra("uname");
        // final String Le = i.getStringExtra("Level");
        final String cat = i.getStringExtra("cat");
        Log.e("Second Screen", name + "." + Level);
        Email=name;
        Name=cat;

//        Toast.makeText(getApplicationContext(), "Welcome"+name+"You are on Level"+Level+"cat="+cat,
//                Toast.LENGTH_LONG).show();
        try {

            // Toast.makeText(getApplicationContext(), "Enter qid", Toast.LENGTH_SHORT).show();

            new First().execute("");
        } catch (Exception ex) {
            content.setText(" url exeption! ");
        }





        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.tp);
        radiogroup = (RadioGroup) findViewById(R.id.options);

        time= (TextView) findViewById(R.id.time);

        count= new CountDownTimer(1200000, 1000) {

            public void onTick(long millisUntilFinished) {
                tim=1200-millisUntilFinished/1000;

                time.setText("Time remaining: " +( millisUntilFinished) / 1000/60+":"+(millisUntilFinished)/1000%60);
            }

            public void onFinish() {

                Intent i=new  Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        }.start();
//        try {
//
//
//            new LevelUpdate().execute("");
//        } catch (Exception ex) {
//            content.setText(" url exeption! ");
//        }
//

        a1= (RadioButton) findViewById(R.id.option1);
        a2= (RadioButton) findViewById(R.id.option2);
        a3= (RadioButton) findViewById(R.id.option3);
        a4= (RadioButton) findViewById(R.id.option4);
        content= (TextView) findViewById(R.id.question);
        //  T= (TextView) findViewById(R.id.tt);

        saveme= (Button) findViewById(R.id.nxt);
        finish= (Button) findViewById(R.id.fin);

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (a1.isChecked()) {
                    b = 1;


                } else if (a2.isChecked()) {
                    b = 2;

                } else if (a3.isChecked()) {
                    b = 3;

                } else if (a4.isChecked()) {
                    b = 4;


                }
            }
        });
        saveme.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                try {
                    if(b!=0)
                    {a++;d++;
                        if(b==ans)
                        {
                            r1++;


                        }else
                            w++;
                    }

                    r=r1;


                    if (a % 5 == 0&&a!=0) {
                        r=r1;
                        //r1=0;

                        int x=0;
                        //diff=totime-tim;
                        //Toast.makeText(getApplicationContext(),"Time "+tim+" diff-> "+diff,Toast.LENGTH_LONG).show();
                        if(tim<=150)
                        {x=1;
                            if(r==0||r==1)
                                level=-1;
                            if(r==3||r==2)
                                level=0;
                            if(r==4)
                                level=1;
                            if(r>=5)
                                level=2;

                        }
                        if(tim>150&&tim<=240)
                        {x=2;
                            if(r==0||r==2||r==1)
                                level=-1;
                            if(r==3)
                                level=0;
                            if(r==4)
                                level=1;
                            if(r>=5)
                                level=2;

                        }
                        if(tim>240&&tim<=360)
                        {x=3;
                            if(r==0||r==1||r==2)
                                level=-1;
                            if(r==3||r==4)
                                level=0;
                            if(r>=5)
                                level=1;

                        }
                        if(tim>360&&tim<=450)
                        {x=4;
                            if(r==0||r==1||r==2||r==3)
                                level=-1;
                            if(r==4||r==5)
                                level=0;

                        }
                        if(tim>450)
                        {x=5;
                            if(r==0||r==1||r==2||r==3||r==4)
                                level=-1;
                            if(r>=5)
                                level=0;


                        }
//                        Toast.makeText(getApplicationContext(), "Atempted =" + (a-aa)+"Right="+(r1-rr)+"Level="+level,
//                                Toast.LENGTH_LONG).show();
                        Level+=level;
                        if(Level<0)
                            Level=0;
                        if (Level>4)
                            Level=4;
                        lqid[0]=Level;
                        try{
                            new LevelUpdate().execute("");
                        } catch (Exception ex) {
                            content.setText(" url exeption! ");
                        }
                        Toast.makeText(getApplicationContext(), "Atempted =" + (a - aa) + "Right=" + (r1 - rr) + "LevelChange=" + level,
                                Toast.LENGTH_LONG).show();

                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(TestPage.this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);


                        // Setting Dialog Title
                        alertDialog.setTitle("Your Level = " + Level);

                        // Setting Dialog Message
                        alertDialog.setMessage("No of Question Attempted="+(a-aa)+"\nNo of Right Answer="+(r1-rr));
                        a=0;
                        r1=0;
                        // Setting Icon to Dialog


                        // Setting Positive "Yes" Button
                        alertDialog.setPositiveButton("Continue",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        d=0;
                                        new LongOperation().execute("");

                                        count.cancel();
                                        count= new CountDownTimer(1200000, 1000) {

                                            public void onTick(long millisUntilFinished) {
                                                tim=12000-millisUntilFinished/1000;

                                                time.setText("Time remaining: " +( millisUntilFinished) / 1000/60+":"+(millisUntilFinished)/1000%60);
                                            }

                                            public void onFinish() {

                                                Intent i=new  Intent(getApplicationContext(),MainActivity.class);
                                                startActivity(i);
                                            }
                                        }.start();
                                        // Write your code here to execute after dialog
                                        //Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                                    }
                                });
                        // Setting Negative "NO" Button
                        alertDialog.setNegativeButton("Back",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        TestPage.this.finish();
                                        Intent pre = new Intent(getApplicationContext(), Questions.class);

                                        //Sending data to another Activity
                                        pre.putExtra("uname", Email);
                                        pre.putExtra("Level", Level);
                                        // Write your code here to execute after dialog
                                        //   Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                                        dialog.cancel();
                                    }
                                });




                        // Showing Alert Message
                        alertDialog.show();
                        // rr=r1;

                        //aa=a;


                    }
                    if(d%5!=0) {
                        new LongOperation().execute("");
                    }
                } catch (Exception ex) {
                    content.setText(" url exeption! ");
                }
                b=0;

            }
        });

        finish.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                new LevelUpdate().execute("");
                d2=0;
                if(b!=0)
                {a++;
                    if(b==ans)
                    {
                        r1++;


                    }else
                        w++;
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(TestPage.this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);


                // Setting Dialog Title
                alertDialog.setTitle("Exit??");

                // Setting Dialog Message
                alertDialog.setMessage("Your Level=" + Level + "\nNo of Question Attempted=" + (a) + "\nNo of Right Answer=" + (r1));

                // Setting Icon to Dialog


                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // new LongOperation().execute("");
                                new LongOperation().execute("");
                                // Write your code here to execute after dialog
                                //Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                            }
                        });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                TestPage.this.finish();
                                Intent i = new Intent(getApplicationContext(), Questions.class);
                                String lev = String.valueOf(Level);
                                i.putExtra("uname", Email);
                                i.putExtra("Level", lev);
                                //Toast.makeText(getApplicationContext(), "send to question"+Level, Toast.LENGTH_LONG).show();

                                startActivity(i);// Write your code here to execute after dialog
                                //Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });




                // Showing Alert Message
                alertDialog.show();



            }
        });


    }







    public class LongOperation extends AsyncTask<String, Void, String> {
        String []v;
        @Override
        protected String doInBackground(String... params) {
            try {
                // Get user defined values

                // Toast.makeText(getApplicationContext(), "Getting qid", Toast.LENGTH_SHORT).show();

                // Create data variable for sent values to server
                String data =

                        "&" + URLEncoder.encode("qid", "UTF-8") + "="
                                + URLEncoder.encode(String.valueOf(qid), "UTF-8");
                data += "&" + URLEncoder.encode("level", "UTF-8")
                        + "=" + URLEncoder.encode(String.valueOf(Level), "UTF-8");
                data += "&" + URLEncoder.encode("sname", "UTF-8")
                        + "=" + URLEncoder.encode(Name, "UTF-8");



                BufferedReader reader=null;

                // Send data
                try
                {

                    // Defined URL  where to send data
                    URL url = new URL("http://192.168.43.148/project1/que.php");

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

                    //Toast.makeText(getApplicationContext(),""+len, Toast.LENGTH_LONG).show();
                    for(int i=0;i<len;i++)
                    {
                        if(chars[i]=='~')
                        {
                            c++;
                            aj=c;
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
            if(v[2].equals("b")) {
                new LevelUpdate().execute("");
                if(b!=0)
                {a++;
                    if(b==ans)
                    {
                        r1++;


                    }else
                        w++;
                }

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(TestPage.this,android.R.style.Theme_Black_NoTitleBar_Fullscreen);


                // Setting Dialog Title
                alertDialog.setTitle("No More Question!");

                // Setting Dialog Message
                alertDialog.setMessage("Your Level=" + Level + "\nNo of Question Attempted=" + (a) + "\nNo of Right Answer=" + (r1));

                // Setting Icon to Dialog


                // Setting Positive "Yes" Button
                //    alertDialog.setPositiveButton("No",
                //          new DialogInterface.OnClickListener() {
                //public void onClick(DialogInterface dialog, int which) {
                // new LongOperation().execute("");
                //                new LongOperation().execute("");
                // Write your code here to execute after dialog
                //Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                //          }
                //    });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Okay",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                TestPage.this.finish();
                                Intent i = new Intent(getApplicationContext(), Questions.class);
                                //Toast.makeText(getApplicationContext(), "send to question"+Level, Toast.LENGTH_LONG).show();
                                //i.putExtra("uname", Email);
                                //i.putExtra("Level", Level);
                                String lev = String.valueOf(Level);
                                i.putExtra("uname", Email);
                                i.putExtra("Level", lev);
                                Toast.makeText(getApplicationContext(), "No more Question", Toast.LENGTH_LONG).show();
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(i);
                                //Toast.makeText(getApplicationContext(), "send to question"+Level, Toast.LENGTH_LONG).show();

                                startActivity(i);// Write your code here to execute after dialog
                                //Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });




                // Showing Alert Message
                alertDialog.show();



            }
            else {
                content.setText(v[1]);

                a1.setText(v[2]);
                a2.setText(v[3]);
                a3.setText(v[4]);
                a4.setText(v[5]);

                ans = Integer.parseInt(v[6]);
//
                v[7] = v[7].trim();
                qid = Integer.parseInt(v[7]);
//T.setText(""+v[7].length());
                radiogroup.clearCheck();
            }

        }


        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
    public class LevelUpdate extends AsyncTask<String, Void, String> {
        String []v;
        @Override
        protected String doInBackground(String... params) {
            try {
                // Get user defined values
                //if((Level+level)<=0)
                // {
                // Toast.makeText(getApplicationContext(), "if", Toast.LENGTH_SHORT).show();

                //   l=0;
                //}
                //else {
                //  l = Level + level;
                //Toast.makeText(getApplicationContext(), "else", Toast.LENGTH_SHORT).show();

                //}// Create data variable for sent values to server
                String data =

                        "&" + URLEncoder.encode("level", "UTF-8") + "="
                                + URLEncoder.encode(String.valueOf(Level), "UTF-8");


                data += "&" + URLEncoder.encode("sname", "UTF-8")
                        + "=" + URLEncoder.encode(Name, "UTF-8");

                data += "&" + URLEncoder.encode("semail", "UTF-8")
                        + "=" + URLEncoder.encode(Email, "UTF-8");

                data += "&" + URLEncoder.encode("qid", "UTF-8")
                        + "=" + URLEncoder.encode(String.valueOf(qid), "UTF-8");

                BufferedReader reader=null;

                // Send data
                try
                {

                    // Defined URL  where to send data
                    URL url = new URL("http://192.168.43.148/project1/LevelUpdate.php");

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


                    tex= sb.toString();
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
            // Toast.makeText(getApplicationContext(), "Level="+tex,
            //       Toast.LENGTH_LONG).show();

        }


        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
    public class First extends AsyncTask<String, Void, String> {
        String []v;


        @Override
        protected String doInBackground(String... params) {
            try {
                // Get user defined values
                //Toast.makeText(getApplicationContext(), "Getting qid", Toast.LENGTH_SHORT).show();

                // Create data variable for sent values to server
                String data =

                        "&" + URLEncoder.encode("level", "UTF-8") + "="
                                + URLEncoder.encode("-1", "UTF-8");


                data += "&" + URLEncoder.encode("sname", "UTF-8")
                        + "=" + URLEncoder.encode(Name, "UTF-8");
                data += "&" + URLEncoder.encode("semail", "UTF-8")
                        + "=" + URLEncoder.encode(Email, "UTF-8");
                data += "&" + URLEncoder.encode("qid", "UTF-8")
                        + "=" + URLEncoder.encode("511", "UTF-8");

                BufferedReader reader=null;

                // Send data
                try
                {

                    // Defined URL  where to send data
                    URL url = new URL("http://192.168.43.148/project1/qlvid.php");

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


                    te= sb.toString();
                }
                catch(Exception ex)
                {

                }
                finally
                {char [] chars=te.toCharArray();

                    int c=0,j=0;
                    int len = chars.length;
                    for(int i=0;i<len;i++)
                    {
                        if(chars[i]=='~')
                        {
                            c++;
                        }}
                    String[] lis=new String[c+1];
                    for(int i=0;i<=c;i++)
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
            //Toast.makeText(getApplicationContext(), "Getting qid", Toast.LENGTH_SHORT).show();
            return "Executed";

        }
        @Override
        protected void onPostExecute(String result) {

            String attt = "";

            lqid[0]=Integer.parseInt(v[1].trim());
            lqid[1]=Integer.parseInt(v[2].trim());
            lqid[2]=Integer.parseInt(v[3].trim());
            lqid[3]=Integer.parseInt(v[4].trim());
            lqid[4]=Integer.parseInt(v[5].trim());
            lqid[5]=Integer.parseInt(v[6].trim());
//            T.setText(""+lqid[0]);
            try {
                level=lqid[0];
                qid=lqid[level+1];
                new LongOperation().execute("");
            } catch (Exception ex) {
                content.setText(" url exeption! ");
            }

            //    might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

}

