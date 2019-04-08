package de.dhbw.students.keepthings.api;

import org.json.JSONArray;

import java.net.MalformedURLException;
import java.net.URL;

import de.dhbw.students.keepthings.R;
import de.dhbw.students.keepthings.new_user_item_entry.NewUserItemEntryActivity;

public class ApiAddLentOutItem extends ApiConnection {
    protected NewUserItemEntryActivity activity;

    public ApiAddLentOutItem(String purl, UrlCase urlcase, NewUserItemEntryActivity activity) {
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
        if (successList.get(0)) {
            activity.showToast(R.string.success);
        } else {
            activity.showToast(R.string.unsuccess);
        }
    }
}

