package de.dhbw.students.keepthings.api;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public abstract class ApiConnection extends AsyncTask<String, Integer, JSONArray> {

    protected UrlCase urlcase;
    protected URL url;
    protected HttpURLConnection connection;
    protected BufferedReader reader;
    protected ArrayList<UserEntry> userList;
    protected ArrayList<ItemEntry> itemList;
    protected ArrayList<MessageEntry> messageList;
    protected ArrayList<Boolean> successList;

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
            if (!finalJson.startsWith("{")) {
                finalJson = "{" + finalJson + "}";
            }
            if (finalJson.contains("[")) { // checks if the JSON contains an array of objects or just one
                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("result");
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
                JSONObject parentObject = new JSONObject(finalJson);
                JSONObject parentResultObject = parentObject.getJSONObject("result");
                switch (urlcase) {
                    case User:
                        this.addUserObj(parentResultObject);
                        break;
                    case Item:
                        this.addItemObj(parentResultObject);
                        break;
                    case Message:
                        this.addMessageObj(parentResultObject);
                        break;
                    case success:
                        this.addSuccessObj(parentResultObject);
                        break;
                }
            }

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

    protected void addUserObj(JSONObject parentResultObject) {
        try {
            userList = new ArrayList<>();
            for (int i = 0; i < parentResultObject.length(); i++) {
                userList.add(new UserEntry(
                        parentResultObject.getString("USER_ID"),
                        parentResultObject.getString("NAME"),
                        parentResultObject.getString("FIRST_NAME"),
                        parentResultObject.getString("PASSWORD"),
                        parentResultObject.getString("EMAIL"),
                        parentResultObject.getString("TEL_NR"),
                        parentResultObject.getString("USERNAME"),
                        parentResultObject.getString("TYPE"),
                        parentResultObject.getInt("VERIFIED"),
                        parentResultObject.getBoolean("success")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void addItemObj(JSONObject parentResultObject) {
        try {
            itemList = new ArrayList<>();
            for (int i = 0; i < parentResultObject.length(); i++) {
                itemList.add(new ItemEntry(
                        parentResultObject.getInt("ITEM_ID"),
                        parentResultObject.getString("ITEM_NAME"),
                        parentResultObject.getString("ITEM_DESC"),
                        parentResultObject.getString("OWNER"),
                        parentResultObject.getString("BORROWER"),
                        parentResultObject.getString("DATE_FROM"),
                        parentResultObject.getString("DATE_TO"),
                        parentResultObject.getBoolean("success")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void addMessageObj(JSONObject parentResultObject) {
        try {
            messageList = new ArrayList<>();
            for (int i = 0; i < parentResultObject.length(); i++) {
                messageList.add(new MessageEntry(
                        parentResultObject.getInt("MESSAGE_ID"),
                        parentResultObject.getString("MESSAGE"),
                        parentResultObject.getInt("SENDER"),
                        parentResultObject.getInt("RECEIVER_ID"),
                        parentResultObject.getString("SENT_TIMESTAP"),
                        parentResultObject.getBoolean("success")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void addSuccessObj(JSONObject parentResultObject) {
        try {
            successList = new ArrayList<>();
            for (int i = 0; i < parentResultObject.length(); i++) {
                successList.add(
                        parentResultObject.getBoolean("success")
                );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected abstract void onPostExecute(JSONArray strings);
}
