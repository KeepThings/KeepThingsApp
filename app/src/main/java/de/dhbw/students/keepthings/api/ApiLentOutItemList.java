package de.dhbw.students.keepthings.api;

import org.json.JSONArray;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import de.dhbw.students.keepthings.MainActivity;
import de.dhbw.students.keepthings.main.UserItemEntry;

public class ApiLentOutItemList extends ApiConnection {
    protected MainActivity activity;

    public ApiLentOutItemList(String purl, UrlCase urlcase, MainActivity activity) {
        try {
            super.url = new URL(purl);
            super.urlcase = urlcase;
            this.activity = activity;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(JSONArray strings) {
        ArrayList<UserItemEntry> lentOutEntries = new ArrayList<>();

        for (int i = 0; i < itemList.size(); i++) {
            String title = itemList.get(i).getITEM_NAME();
            String person = itemList.get(i).getBORROWER();
            String dateTo = itemList.get(i).getDATE_TO();
            String dateFrom = itemList.get(i).getDATE_FROM();
            lentOutEntries.add(new UserItemEntry(title, person, dateTo, dateFrom));
        }

        activity.setItems(lentOutEntries);
        if (!activity.isListInit()) {
            activity.setFragment();
        }
    }
}

