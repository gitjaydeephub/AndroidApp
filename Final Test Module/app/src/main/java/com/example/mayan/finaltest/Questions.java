package com.example.mayan.finaltest;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
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
 * Created by mayan on 01-02-2016.
 */
public class Questions extends Activity {
    int ln=0;
    MyCustomAdapter adapter;
    ListView lView ;
    String name ="";

    String s = null;
    // TextView content;
    //  EditText fname, email, login, pass;
    String  Email, Login, Pass,text;
    String[] lv1 =new String[]{"hii","bye"} ;
    /** Called when the activity is first created. */
    String[] l=new String[2];
    ArrayList<String> list = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Intent i=getIntent();

        name = i.getStringExtra("uname");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        lView = (ListView) findViewById(R.id.li);


        try {

            // CALL GetText method to make post method call

            LongOperation dem = new LongOperation();
            dem.execute("");


        } catch (Exception ex) {
            //content.setText(" url exeption! ");
        }


        //Button savee = (Button) findViewById(R.id.save);
    }
    void add()
    {
        adapter = new MyCustomAdapter(list, this);

        //handle listview and assign adapter
        // ListView lView = (ListView)findViewById(R.id.li);
        lView.setAdapter(adapter);

    }


    public class LongOperation extends AsyncTask<String, Void, String> {

        String[] v;
        @Override
        protected String doInBackground(String... params) {
            try {
                // Get user defined values

                //   Email   = email.getText().toString();


                // Create data variable for sent values to server
                String data    =    "&" + URLEncoder.encode("Email", "UTF-8") + "="
                        + URLEncoder.encode("1", "UTF-8");




                BufferedReader reader=null;

                // Send data
                try
                {


                    URL url = new URL("http://10.0.2.2/upload/testinfo.php");


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
                    text="errros = "+ex;
                }

                finally
                {
                    char [] chars=text.toCharArray();
//String[] strings;
                    int len = chars.length;
                    int c = 0,j=-1;
                    s="";

                    for(int i=0;i<len;i++)
                    {
                        if(chars[i]=='~')
                        {
                            c++;
                        }}
                    String[] lis=new String[c];
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
                    ln=c;
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
            //       TextView txt = (TextView) findViewById(R.id.output);
            //     txt.setText("Executed");
            for(int i=0;i<ln;i++)
                list.add(v[i]);
            add();

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }




}
