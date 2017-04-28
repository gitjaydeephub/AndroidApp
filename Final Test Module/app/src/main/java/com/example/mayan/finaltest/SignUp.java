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

import com.example.mayan.finaltest.MainActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mayan on 02-02-2016.
 */
public class SignUp extends Activity {
    Button s;
    TextView tv;
    EditText email,  pass,uname,cno;
    String Email,  Pass,Uname,Cno,text;
    Intent i = getIntent();
    void toa()
    {
        Toast.makeText(getApplicationContext(), "Enter All Details",
                Toast.LENGTH_LONG).show();

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.signup);

        email      =   (EditText)findViewById(R.id.email);
        tv= (TextView) findViewById(R.id.ul);
        pass       =   (EditText)findViewById(R.id.password);

        uname       =   (EditText)findViewById(R.id.Uname);
        cno       =   (EditText)findViewById(R.id.cno);


        s=(Button)findViewById(R.id.s);


        s.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                try {

                    // CALL GetText method to make post method call
                    Email   = email.getText().toString();
                    if(!validateEmail(email.getText().toString())) {
                        email.setError("Invalid Email");
                        email.requestFocus();
                    } else if (!validatePassword(pass.getText().toString())) {
                        pass.setError("Invalid Password");
                        pass.requestFocus();
                    } else {
                        //Toast.makeText(SignUp.this, "Input Validation Success", Toast.LENGTH_LONG).show();
                        try {
                            new LongOperation().execute("");
                        }
                        catch (Exception e)
                        {}
                    }

                    Pass   = pass.getText().toString();
                    Uname   = uname.getText().toString();

                    Cno   = cno.getText().toString();
                } catch (Exception ex) {
                }

            }
        });


    }
    protected boolean validatePassword(String password) {
        if(password!=null && password.length()>9) {
            return true;
        } else {
            return false;
        }
    }

    //Return true if email is valid and false if email is invalid
    protected boolean validateEmail(String email) {
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public class LongOperation extends AsyncTask<String, Void, String> {

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
                data += "&" + URLEncoder.encode("uname", "UTF-8")
                        + "=" + URLEncoder.encode(Uname, "UTF-8");
                data += "&" + URLEncoder.encode("no", "UTF-8")
                        + "=" + URLEncoder.encode(Cno, "UTF-8");


                BufferedReader reader=null;

                // Send data
                try
                {

                    // Defined URL  where to send data
                    URL url = new URL("http://10.0.2.2/upload/nu.php");

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
            tv.setText(text);
            Toast.makeText(getApplicationContext(), "Signup Successfully",
                    Toast.LENGTH_LONG).show();
            Intent next = new Intent(getApplicationContext(), MainActivity.class);
            next.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(next);




            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
}


