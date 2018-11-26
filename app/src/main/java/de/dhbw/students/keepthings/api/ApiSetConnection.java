package de.dhbw.students.keepthings.api;

import android.os.AsyncTask;

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

public class ApiSetConnection extends AsyncTask<String, Integer, JSONArray> {

    private final String LOG_TAG = ApiGetUsersConnection.class.getSimpleName();

    private URL url;
    private HttpURLConnection connection = null;
    private BufferedReader reader = null;

    public ApiSetConnection(String purl) {
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
            String finalJson = buffer.toString();

            JSONObject parentObjekt = new JSONObject(finalJson);
            JSONArray parentArray = parentObjekt.getJSONArray("result");

            List<Boolean> result = new ArrayList<>();
            result.add(parentArray.getJSONObject(0).getBoolean("success"));

            //einfügen der setmethode aus der aufrufenden klasse!!!!!!

            return parentArray;
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

        // Wir löschen den Inhalt des ArrayAdapters und fügen den neuen Inhalt ein
        // Der neue Inhalt ist der Rückgabewert von doInBackground(String...) also
        // der StringArray gefüllt mit Beispieldaten

        // Hintergrundberechnungen sind jetzt beendet, darüber informieren wir den Benutzer
        /*Toast.makeText(activity, "Aktiendaten vollständig geladen!",
                Toast.LENGTH_SHORT).show();*/
    }
}
