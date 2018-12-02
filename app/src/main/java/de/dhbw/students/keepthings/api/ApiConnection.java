package de.dhbw.students.keepthings.api;

import android.os.AsyncTask;
import android.util.Log;

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

    protected UrlCase urlcase;
    protected URL url;
    protected HttpURLConnection connection = null;
    protected BufferedReader reader = null;
    ArrayList<UserEntry> userList;
    ArrayList<ItemEntry> itemList;
    ArrayList<MessageEntry> messageList;
    ArrayList<Boolean> successList;


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
            if (!finalJson.startsWith("{")){
                finalJson="{"+finalJson+"}";
            }
            if (finalJson.contains("[")) { // checks if the JSON contains an array of objects or just one
                JSONObject parentObjekt = new JSONObject(finalJson);
                JSONArray parentArray = parentObjekt.getJSONArray("result");
                switch (urlcase) {
                    case User: //User means the JSON contains a list with User entrys
                        this.addUserArray(parentArray);
                        break;
                    case Item: //Item means the JSON contains a list with Item entrys
                        this.addItemArray(parentArray);
                        break;
                    case Message: //Message means the JSON contains a list with Message entrys
                        this.addMessageArray(parentArray);
                        break;
                    case success: //success means the JSON contains a list with success entrys
                        this.addSuccessArray(parentArray);
                        break;
                }
            } else {
                JSONObject parentObjekt = new JSONObject(finalJson);
                JSONObject parentResultObjekt = parentObjekt.getJSONObject("result");
                switch (urlcase) {
                    case User:
                        this.addUserObj(parentResultObjekt);
                        break;
                    case Item:
                        this.addItemObj(parentResultObjekt);
                        break;
                    case Message:
                        this.addMessageObj(parentResultObjekt);
                        break;
                    case success:
                        this.addSuccessObj(parentResultObjekt);
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

    protected void addUserArray(JSONArray parentArray) {
        try {
            userList = new ArrayList<>();
            for (int i = 0; i < parentArray.length(); i++) {
                userList.add(new UserEntry(
                        parentArray.getJSONObject(i).getString("USER_ID"),
                        parentArray.getJSONObject(i).getString("NAME"),
                        parentArray.getJSONObject(i).getString("FIRST_NAME"),
                        parentArray.getJSONObject(i).getString("PASSWORD"),
                        parentArray.getJSONObject(i).getString("EMAIL"),
                        parentArray.getJSONObject(i).getString("TEL_NR"),
                        parentArray.getJSONObject(i).getString("USERNAME"),
                        parentArray.getJSONObject(i).getString("TYPE"),
                        parentArray.getJSONObject(i).getInt("VERIFIED"),
                        parentArray.getJSONObject(i).getBoolean("success")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    protected void addItemArray(JSONArray parentArray) {
        try {
            itemList = new ArrayList<>();
            for (int i = 0; i < parentArray.length(); i++) {
                itemList.add(new ItemEntry(
                        parentArray.getJSONObject(i).getInt("ITEM_ID"),
                        parentArray.getJSONObject(i).getString("ITEM_NAME"),
                        parentArray.getJSONObject(i).getString("ITEM_DESC"),
                        parentArray.getJSONObject(i).getString("OWNER"),
                        parentArray.getJSONObject(i).getString("BORROWER"),
                        parentArray.getJSONObject(i).getString("DATE_FROM"),
                        parentArray.getJSONObject(i).getString("DATE_TO"),
                        parentArray.getJSONObject(i).getBoolean("success")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    protected void addMessageArray(JSONArray parentArray) {
        try {
            messageList = new ArrayList<>();
            for (int i = 0; i < parentArray.length(); i++) {
                messageList.add(new MessageEntry(
                        parentArray.getJSONObject(i).getInt("MESSAGE_ID"),
                        parentArray.getJSONObject(i).getString("MESSAGE"),
                        parentArray.getJSONObject(i).getInt("SENDER"),
                        parentArray.getJSONObject(i).getInt("RECEIVER_ID"),
                        parentArray.getJSONObject(i).getString("SENT_TIMESTAP"),
                        parentArray.getJSONObject(i).getBoolean("success")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    protected void addSuccessArray(JSONArray parentArray) {
        try {
            successList = new ArrayList<>();
            for (int i = 0; i < parentArray.length(); i++) {
                successList.add(
                        parentArray.getJSONObject(i).getBoolean("success")
                );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    protected void addUserObj(JSONObject parentResultObjekt) {
        try {
            userList = new ArrayList<>();
            for (int i = 0; i < parentResultObjekt.length(); i++) {
                userList.add(new UserEntry(
                        parentResultObjekt.getString("USER_ID"),
                        parentResultObjekt.getString("NAME"),
                        parentResultObjekt.getString("FIRST_NAME"),
                        parentResultObjekt.getString("PASSWORD"),
                        parentResultObjekt.getString("EMAIL"),
                        parentResultObjekt.getString("TEL_NR"),
                        parentResultObjekt.getString("USERNAME"),
                        parentResultObjekt.getString("TYPE"),
                        parentResultObjekt.getInt("VERIFIED"),
                        parentResultObjekt.getBoolean("success")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    protected void addItemObj(JSONObject parentResultObjekt) {
        try {
            itemList = new ArrayList<>();
            for (int i = 0; i < parentResultObjekt.length(); i++) {
                itemList.add(new ItemEntry(
                        parentResultObjekt.getInt("ITEM_ID"),
                        parentResultObjekt.getString("ITEM_NAME"),
                        parentResultObjekt.getString("ITEM_DESC"),
                        parentResultObjekt.getString("OWNER"),
                        parentResultObjekt.getString("BORROWER"),
                        parentResultObjekt.getString("DATE_FROM"),
                        parentResultObjekt.getString("DATE_TO"),
                        parentResultObjekt.getBoolean("success")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    protected void addMessageObj(JSONObject parentResultObjekt) {
        try {
            messageList = new ArrayList<>();
            for (int i = 0; i < parentResultObjekt.length(); i++) {
                messageList.add(new MessageEntry(
                        parentResultObjekt.getInt("MESSAGE_ID"),
                        parentResultObjekt.getString("MESSAGE"),
                        parentResultObjekt.getInt("SENDER"),
                        parentResultObjekt.getInt("RECEIVER_ID"),
                        parentResultObjekt.getString("SENT_TIMESTAP"),
                        parentResultObjekt.getBoolean("success")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    protected void addSuccessObj(JSONObject parentResultObjekt) {
        try {
            successList = new ArrayList<>();
            for (int i = 0; i < parentResultObjekt.length(); i++) {
                successList.add(
                        parentResultObjekt.getBoolean("success")
                );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected abstract void onPostExecute(JSONArray strings);
}
