package de.dhbw.students.keepthings.api;

import org.json.JSONArray;

import java.net.MalformedURLException;
import java.net.URL;

import de.dhbw.students.keepthings.main.LentOutFragment;

public class ApiLentOutFragment extends ApiConnection {
    protected LentOutFragment fragment;

    public ApiLentOutFragment(String purl, int urlcase, LentOutFragment fragment) {
        try {
            super.url = new URL(purl);
            super.urlcase = urlcase;
            this.fragment = fragment;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(JSONArray strings) {
        //fragment.setListe(listeMessage);

    }
}

