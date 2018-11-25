package de.dhbw.students.keepthings;

import org.json.JSONArray;

import java.net.MalformedURLException;
import java.net.URL;

public class ApiLentOutFragment extends ApiConnection {
    protected LendOutFragment fragment;

    public ApiLentOutFragment(String purl, int urlcase, LendOutFragment fragment) {
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

