package de.dhbw.students.keepthings.api;

import android.app.Activity;
import android.content.Intent;

import org.json.JSONArray;

import java.net.MalformedURLException;
import java.net.URL;

import de.dhbw.students.keepthings.Login.LoginActivity;
import de.dhbw.students.keepthings.MainActivity;
import de.dhbw.students.keepthings.R;

public class ApiLogin extends ApiConnection {
    protected LoginActivity activity;
    public ApiLogin(String purl, UrlCase urlcase, LoginActivity activity) {
        try {
            super.url = new URL(purl);
            super.urlString = purl;
            super.urlcase = urlcase;
            this.activity = activity;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onPostExecute(JSONArray strings) {
        //activity.setmAuthTask(null);
        activity.showProgress(false);

        if (super.loginList.get(0).isSuccess()) {
            //set the Loged in User to the UserID
            activity.startActivity(new Intent(activity, MainActivity.class));
        } else {
            activity.getmPasswordView().setError(activity.getString(R.string.error_incorrect_password));
            activity.getmPasswordView().requestFocus();
        }
    }

    @Override
    protected void onCancelled() {
       //afas activity.setmAuthTask(null);
        activity.showProgress(false);
    }
}
