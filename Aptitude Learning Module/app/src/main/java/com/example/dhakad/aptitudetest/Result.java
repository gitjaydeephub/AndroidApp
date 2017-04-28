package com.example.dhakad.aptitudetest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhakad on 1/26/2016.
 */
public class Result extends Activity {
    String email;
    String cat;
    int qtyTT=0;
    int f1=0,f2=0,f3=0,f4=0;
    ListView listView;
    TextView tv;
    ListAdapter adapter;
    List<RowItem> dataItems ;
    int total=0;
    int table;

    Button order;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_result);
        Button Verbal ,Aptitude,logical;
        SharedPreferences sessDataGet= getSharedPreferences("SESSION_DATA", MODE_PRIVATE);
        email = sessDataGet.getString("email", "");
//Toast.makeText(getApplicationContext(),""+email,5000).show();
        logical= (Button) findViewById(R.id.reaso);
        listView= (ListView) findViewById(R.id.listView);

        Verbal= (Button) findViewById(R.id.ver);
        Aptitude= (Button) findViewById(R.id.apti);
        Verbal.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                cat="v";
                new ResultLoadActivity().execute(email,"v");
            }
        });
        logical.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                cat="l";
                new ResultLoadActivity().execute(email,"l");
            }
        });
        Aptitude.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                cat="q";
                new ResultLoadActivity().execute(email,"q");
            }
        });

    }


    class ResultLoadActivity extends AsyncTask<String, Void, String> {
        public ProgressDialog pdlg;
        public ResultLoadActivity() {
        }

        protected void onPreExecute() {
            super.onPreExecute();
            pdlg = new ProgressDialog(Result.this);
            pdlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pdlg.setMessage("Please wait Loging ...");
            pdlg.setCancelable(false);
            pdlg.show();
        }

        @Override
        protected String doInBackground(String... arg0) {
            //String em=arg0[0];
            //String cat=arg0[1];
            String link;
            String data="";
            BufferedReader bufferedReader;
            String result;
            try {
                data="?em="+ URLEncoder.encode(email, "UTF-8");
                data+="&cat="+URLEncoder.encode(cat, "UTF-8");
                link = "http://192.168.43.148/project1/lresult.php"+data;
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            pdlg.dismiss();
            String jsonStr = result;
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    dataItems= new ArrayList<RowItem>();
                    RowItem objModel = null;
                    JSONArray jsonMainNode = jsonObj.optJSONArray("result");

                    for (int i = 0; i < jsonMainNode.length(); i++) {
                        JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                        String cat = jsonChildNode.optString("cat");
                        String level = jsonChildNode.optString("level");

                        objModel=new RowItem();
                        //objModel.setLevel(level);
                        objModel.setCatg(cat);
                        objModel.setLevel(level);
                        dataItems.add(objModel);
                    }
                    listView = (ListView) findViewById(R.id.listView);
                    adapter = new ListAdapter(Result.this,dataItems);
                    listView.setAdapter(adapter);
                }//try
                catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "TECHNICAL PROBLEM (please connect Internate " + e, Toast.LENGTH_SHORT).show();
                }//catch
            }//if
        }
    }



}




