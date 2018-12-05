package de.dhbw.students.keepthings.api;

import org.json.JSONArray;

import java.net.MalformedURLException;
import java.net.URL;

import de.dhbw.students.keepthings.R;
import de.dhbw.students.keepthings.new_lent_out_entry.NewLentOutEntryActivity;

public class ApiAddLentOutItem extends ApiConnection {
    protected NewLentOutEntryActivity activity;

    public ApiAddLentOutItem(String purl, UrlCase urlcase, NewLentOutEntryActivity activity) {
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

