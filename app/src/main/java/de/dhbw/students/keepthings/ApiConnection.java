package de.dhbw.students.keepthings;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnection extends AsyncTask<String, Integer, String[]> {

    private final String LOG_TAG = ApiConnection.class.getSimpleName();
    private Activity activity;
    private String url;

    public ApiConnection(Activity activity, String url) {

        this.activity = activity;
        this.url = url;
    }

    @Override
    protected String[] doInBackground(String... strings) {

        if (strings.length == 0) { // Keine Eingangsparameter erhalten, daher Abbruch
            return null;
        }

        // Exakt so muss die Anfrage-URL an unseren Web-Server gesendet werden:
        // http://www.programmierenlernenhq.de/tools/query.php?s=DAI.DE,BMW.DE

        // Wir konstruieren die Anfrage-URL für unseren Web-Server
        final String URL_PARAMETER = "http://www.programmierenlernenhq.de/tools/query.php";

        String symbols = "DAI.DE,BMW.DE";

        String anfrageString = URL_PARAMETER;
        anfrageString += "?s=" + symbols;

        Log.v(LOG_TAG, "Zusammengesetzter Anfrage-String: " + anfrageString);

        // Die URL-Verbindung und der BufferedReader, werden im finally-Block geschlossen
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;

        // In diesen String speichern wir die Aktiendaten im XML-Format
        String aktiendatenXmlString = "";

        try {
            URL url = new URL(anfrageString);

            // Aufbau der Verbindung zur YQL Platform
            httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            if (inputStream == null) { // Keinen Aktiendaten-Stream erhalten, daher Abbruch
                return null;
            }
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                aktiendatenXmlString += line + "\n";
            }
            if (aktiendatenXmlString.length() == 0) { // Keine Aktiendaten ausgelesen, Abbruch
                return null;
            }
            Log.v(LOG_TAG, "Aktiendaten XML-String: " + aktiendatenXmlString);
            publishProgress(1, 1);

        } catch (IOException e) { // Beim Holen der Daten trat ein Fehler auf, daher Abbruch
            Log.e(LOG_TAG, "Error ", e);
            return null;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (final IOException e) {
                    Log.e(LOG_TAG, "Error closing stream", e);
                }
            }
        }

        // Hier parsen wir später die XML Aktiendaten

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        // Auf dem Bildschirm geben wir eine Statusmeldung aus, immer wenn
        // publishProgress(int...) in doInBackground(String...) aufgerufen wird
        Toast.makeText(activity, values[0] + " von " + values[1] + " geladen",
                Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPostExecute(String[] strings) {

        // Wir löschen den Inhalt des ArrayAdapters und fügen den neuen Inhalt ein
        // Der neue Inhalt ist der Rückgabewert von doInBackground(String...) also
        // der StringArray gefüllt mit Beispieldaten

        // Hintergrundberechnungen sind jetzt beendet, darüber informieren wir den Benutzer
        Toast.makeText(activity, "Aktiendaten vollständig geladen!",
                Toast.LENGTH_SHORT).show();
    }
}
