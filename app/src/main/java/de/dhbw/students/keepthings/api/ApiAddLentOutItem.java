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
        //activity.showToast(super.successList.get(0)+"");
        //fragment.setListe(messageList);
        //activity.showToast(super.successList.get(0)+"");
        //Log.e("User 0",super.userList.get(0).getFIRST_NAME()+" "+super.userList.get(0).getNAME());
        //activity.showToast(super.userList.get(0).getFIRST_NAME());
        //activity.showToast(super.userList.get(1).getFIRST_NAME());
        //activity.showToast(super.itemList.get(0).getITEM_NAME());
        //activity.showToast(super.itemList.get(1).getITEM_NAME());
        if (successList.get(0)) {
            activity.showToast(R.string.success);
        } else {
            activity.showToast(R.string.unsuccess);
        }
    }
}

