package de.dhbw.students.keepthings;

import android.app.Activity;
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

public class ApiGetUsersConnection extends AsyncTask<String, Integer, JSONArray> {

    private final String LOG_TAG = ApiGetUsersConnection.class.getSimpleName();
    private int urlcase;
    private URL url;
    private HttpURLConnection connection = null;
    private BufferedReader reader = null;
    private Activity activity;

    public ApiGetUsersConnection(String purl, int urlcase, Activity activity) {
        try {
            url = new URL(purl);
            this.urlcase = urlcase;
            this.activity = activity;
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


            switch (urlcase) {
                case 0 | 2:
                    ArrayList<UserEntry> listeUser = new ArrayList<>();
                    for (int i = 0; i < parentArray.length(); i++) {
                        listeUser.add(new UserEntry(
                                parentArray.getJSONObject(i).getString("USER_ID"),
                                parentArray.getJSONObject(i).getString("NAME"),
                                parentArray.getJSONObject(i).getString("FIRST_NAME"),
                                parentArray.getJSONObject(i).getString("PASSWORD"),
                                parentArray.getJSONObject(i).getString("E-MAIL"),
                                parentArray.getJSONObject(i).getString("TEL-NR"),
                                parentArray.getJSONObject(i).getString("USERNAME"),
                                parentArray.getJSONObject(i).getString("TYPE"),
                                parentArray.getJSONObject(i).getBoolean("VERIFIED"),
                                parentArray.getJSONObject(i).getBoolean("success")
                        ));
                    }
                    //this.activity.setListe(listeUser);
                    break;
                case 1 | 4:
                    ArrayList<ItemEntry> listeItem = new ArrayList<>();
                    for (int i = 0; i < parentArray.length(); i++) {
                        listeItem.add(new ItemEntry(
                                parentArray.getJSONObject(i).getInt("ITEM_ID"),
                                parentArray.getJSONObject(i).getString("ITEM_NAME"),
                                parentArray.getJSONObject(i).getString("ITEM_DESC"),
                                parentArray.getJSONObject(i).getString("USERNAME"),
                                parentArray.getJSONObject(i).getString("BORROWER"),
                                parentArray.getJSONObject(i).getString("DATE_FROM"),
                                parentArray.getJSONObject(i).getString("DATE_TO"),
                                parentArray.getJSONObject(i).getBoolean("success")
                        ));
                    }
                    //this.activity.setListe(listeItem);
                    break;
                case 3:
                    ArrayList<MessageEntry> listeMessage = new ArrayList<>();
                    for (int i = 0; i < parentArray.length(); i++) {
                        listeMessage.add(new MessageEntry(
                                parentArray.getJSONObject(i).getInt("MESSAGE_ID"),
                                parentArray.getJSONObject(i).getString("MESSAGE"),
                                parentArray.getJSONObject(i).getString("SENDER"),
                                parentArray.getJSONObject(i).getInt("RECEIVER_ID"),
                                parentArray.getJSONObject(i).getString("SENT_TIMESTAP"),
                                parentArray.getJSONObject(i).getBoolean("success")
                        ));
                    }
                    //this.activity.setListe(listeMessage);
                    break;
            }


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
