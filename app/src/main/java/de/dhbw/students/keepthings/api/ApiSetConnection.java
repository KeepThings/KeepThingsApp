package de.dhbw.students.keepthings.api;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

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
import java.util.ArrayList;
import java.util.List;

import de.dhbw.students.keepthings.R;

public class ApiSetConnection extends AsyncTask<String, Integer, JSONArray> {

    private final String LOG_TAG = ApiGetUsersConnection.class.getSimpleName();

    private URL url;
    private HttpURLConnection connection = null;
    private BufferedReader reader = null;
    private Activity activity;
    List<Boolean> result;

    public ApiSetConnection(String purl, Activity activity) {
        this.activity = activity;

        try {
            url = new URL(purl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected JSONArray doInBackground(String... strings) {


        try {

            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            String finalJson = "{"+buffer.toString()+"}";
            JSONObject parentObjekt = new JSONObject(finalJson);
            JSONObject parentArray = parentObjekt.getJSONObject("result");

            result = new ArrayList<>();
            result.add(parentArray.getBoolean("success"));

            return null;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        // Auf dem Bildschirm geben wir eine Statusmeldung aus, immer wenn
        // publishProgress(int...) in doInBackground(String...) aufgerufen wird
        /*Toast.makeText(activity, values[0] + " von " + values[1] + " geladen",
                Toast.LENGTH_SHORT).show();
*/
    }

    @Override
    protected void onPostExecute(JSONArray strings) {

//        if (strings != null) {
//            int length = strings.length();
//            Toast.makeText(activity, "Lenght: " + length,
//                    Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(activity, "Null",
//                    Toast.LENGTH_SHORT).show();
//
//        }
        Toast.makeText(activity, R.string.success,
                Toast.LENGTH_SHORT).show();

    }
}
