package de.dhbw.students.keepthings.api;


import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import de.dhbw.students.keepthings.login.LoginActivity;
import de.dhbw.students.keepthings.MainActivity;
import de.dhbw.students.keepthings.R;

public class ApiConnectionPost extends AsyncTask<String, Integer, JSONArray> {

    private UrlCase urlcase;
    private URL url;
    private String urlString;
    private LoginActivity activity;
    private ArrayList<LoginEntry> loginList = new ArrayList<LoginEntry>();
    private String data;

    public ApiConnectionPost(String url, String data, UrlCase urlcase,LoginActivity activity) {
        this.urlcase = urlcase;
        try {
            this.url = new URL(url);
            urlString=url;
            this.data=data;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.activity=activity;
    }

    @Override
    protected JSONArray doInBackground(String... strings) {

        OutputStream out = null;
        String result = "";
        Log.e("URL",urlString+data);

        try {

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            out = new BufferedOutputStream(conn.getOutputStream());

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();

            conn.connect();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    result+=line;
                }
            }
            else {
                result="HTTP NOT OK";

            }
            result="{"+result+"}";

        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject parentObjekt = null;
        try {
            parentObjekt = new JSONObject(result);
            JSONObject parentResultObjekt = parentObjekt.getJSONObject("result");
            if (parentResultObjekt.getBoolean("success")){
                loginList.add(new LoginEntry(
                        parentResultObjekt.getBoolean("success"),
                        parentResultObjekt.getInt("uid")
                ));
            }else{
                loginList.add(new LoginEntry(
                        parentResultObjekt.getBoolean("success"),
                        -1
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }




        return null;
    }

    @Override
    protected void onPostExecute(JSONArray strings) {
        activity.showProgress(false);

        if (loginList.get(0).isSuccess()) {
            //set the Loged in User to the UserID
            activity.startActivity(new Intent(activity, MainActivity.class));
        } else {
            activity.getmPasswordView().setError(activity.getString(R.string.error_incorrect_password));
            activity.getmPasswordView().requestFocus();
        }
    }
}


