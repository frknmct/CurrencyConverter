package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getRates(View view){
        DownloadData downloadData = new DownloadData();

        try{

            String url = "http://data.fixer.io/api/latest?access_key=9836dcc280ab815ab7547e916990c4f4&format=1";
            downloadData.execute(url);

        }catch(Exception e){

        }


    }
    private class DownloadData extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String result = " ";
            URL url;
            HttpURLConnection httpURLConnection;
            try{

                url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);


                int data = inputStreamReader.read();

                while (data > 0){

                 char character = (char) data;

                 result += character;
                    data = inputStreamReader.read();


                }

                return  result;
            }catch(Exception e){
                return null;
            }


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            System.out.println("alınan data: "+s);
        }

    }
}
