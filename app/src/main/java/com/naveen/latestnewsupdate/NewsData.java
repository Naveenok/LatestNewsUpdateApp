package com.naveen.latestnewsupdate;

import android.os.AsyncTask;

import com.naveen.latestnewsupdate.CategoryActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NewsData extends AsyncTask<Void,Void,Void> {
//whole json file
    public String data;
    String dataParsed="";
    String singleParsed="";


//backgroud thread
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //CategoryActivity categoryActivity=new CategoryActivity();

            URL url = new URL(CategoryActivity.url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            //read data from the input stream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null){
                line=bufferedReader.readLine();
                data=data+line;
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
//UI thread
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        NewsListActivity.data.setText(this.data);
    }


}
