package de.dhbw.students.keepthings.api;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public abstract class ApiConnectionPost extends AsyncTask<String, Integer, JSONArray> {

    protected UrlCase urlcase;
    protected URL url;
    protected String urlString;
    protected HttpURLConnection connection = null;
    protected BufferedReader reader = null;
    ArrayList<LoginEntry> loginList;


    @Override
    protected JSONArray doInBackground(String... strings) {
        OutputStream out = null;
        /*try {

            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("dd", "dd");
            connection.setDoOutput(true);
            OutputStream outputPost = new BufferedOutputStream(connection.getOutputStream());
            writeStream(outputPost);
            outputPost.flush();
            outputPost.close();

            connection.connect();
            OutputStream out = null;

            try {
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                out = new BufferedOutputStream(urlConnection.getOutputStream());

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
                writer.write(data);
                writer.flush();
                writer.close();
                out.close();

                urlConnection.connect();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }*/
            return null;

      //  }
        //@Override
        //protected abstract void onPostExecute (JSONArray strings);
    }
}

