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

public abstract class ApiConnection extends AsyncTask<String, Integer, JSONArray> {

    protected int urlcase;
    protected URL url;
    protected HttpURLConnection connection = null;
    protected BufferedReader reader = null;


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

            if (finalJson.contains("[")) {
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
                        break;
                    case 1 | 4:
                        ArrayList<ItemEntry> listeItem = new ArrayList<>();
                        for (int i = 0; i < parentArray.length(); i++) {
                            listeItem.add(new ItemEntry(
                                    parentArray.getJSONObject(i).getInt("ITEM_ID"),
                                    parentArray.getJSONObject(i).getString("ITEM_NAME"),
                                    parentArray.getJSONObject(i).getString("ITEM_DESC"),
                                    parentArray.getJSONObject(i).getInt("USERNAME"),
                                    parentArray.getJSONObject(i).getString("BORROWER"),
                                    parentArray.getJSONObject(i).getString("DATE_FROM"),
                                    parentArray.getJSONObject(i).getString("DATE_TO"),
                                    parentArray.getJSONObject(i).getBoolean("success")
                            ));
                        }
                        break;
                    case 3:
                        ArrayList<MessageEntry> listeMessage = new ArrayList<>();
                        for (int i = 0; i < parentArray.length(); i++) {
                            listeMessage.add(new MessageEntry(
                                    parentArray.getJSONObject(i).getInt("MESSAGE_ID"),
                                    parentArray.getJSONObject(i).getString("MESSAGE"),
                                    parentArray.getJSONObject(i).getInt("SENDER"),
                                    parentArray.getJSONObject(i).getInt("RECEIVER_ID"),
                                    parentArray.getJSONObject(i).getString("SENT_TIMESTAP"),
                                    parentArray.getJSONObject(i).getBoolean("success")
                            ));
                        }
                        //
                        break;
                    case 6:
                        ArrayList<Boolean> listeSet = new ArrayList<>();
                        for (int i = 0; i < parentArray.length(); i++) {
                            listeSet.add(
                                    parentArray.getJSONObject(i).getBoolean("success")
                            );
                        }
                        break;
                }
            } else {
                JSONObject parentObjekt = new JSONObject(finalJson);
                JSONObject parentArray = parentObjekt.getJSONObject("result");
                switch (urlcase) {
                    case 0 | 2:
                        ArrayList<UserEntry> listeUser = new ArrayList<>();
                        for (int i = 0; i < parentArray.length(); i++) {
                            listeUser.add(new UserEntry(
                                    parentArray.getString("USER_ID"),
                                    parentArray.getString("NAME"),
                                    parentArray.getString("FIRST_NAME"),
                                    parentArray.getString("PASSWORD"),
                                    parentArray.getString("E-MAIL"),
                                    parentArray.getString("TEL-NR"),
                                    parentArray.getString("USERNAME"),
                                    parentArray.getString("TYPE"),
                                    parentArray.getBoolean("VERIFIED"),
                                    parentArray.getBoolean("success")
                            ));
                        }
                        break;
                    case 1 | 4:
                        ArrayList<ItemEntry> listeItem = new ArrayList<>();
                        for (int i = 0; i < parentArray.length(); i++) {
                            listeItem.add(new ItemEntry(
                                    parentArray.getInt("ITEM_ID"),
                                    parentArray.getString("ITEM_NAME"),
                                    parentArray.getString("ITEM_DESC"),
                                    parentArray.getInt("USERNAME"),
                                    parentArray.getString("BORROWER"),
                                    parentArray.getString("DATE_FROM"),
                                    parentArray.getString("DATE_TO"),
                                    parentArray.getBoolean("success")
                            ));
                        }
                        break;
                    case 3:
                        ArrayList<MessageEntry> listeMessage = new ArrayList<>();
                        for (int i = 0; i < parentArray.length(); i++) {
                            listeMessage.add(new MessageEntry(
                                    parentArray.getInt("MESSAGE_ID"),
                                    parentArray.getString("MESSAGE"),
                                    parentArray.getInt("SENDER"),
                                    parentArray.getInt("RECEIVER_ID"),
                                    parentArray.getString("SENT_TIMESTAP"),
                                    parentArray.getBoolean("success")
                            ));
                        }
                        //
                        break;
                    case 6:
                        ArrayList<Boolean> listeSet = new ArrayList<>();
                        for (int i = 0; i < parentArray.length(); i++) {
                            listeSet.add(
                                    parentArray.getBoolean("success")
                            );
                        }
                        break;
                }
            }

            return null;
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
    protected abstract void onPostExecute(JSONArray strings);
}
