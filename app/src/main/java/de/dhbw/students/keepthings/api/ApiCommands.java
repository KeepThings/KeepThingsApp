package de.dhbw.students.keepthings;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;

public class ApiCommands {

    public String server = "http://10.0.2.2/";

    public void addEntry(String ITEM_NAME, String ITEM_DESC, int USER_ID, String BORROWER, Date DATE_FROM, Date DATE_TO){
        String url = server+"addEntry.php?"+"ITEM_NAME="+ITEM_NAME+"&ITEM_DESC="+ITEM_DESC+"&USER_ID="+USER_ID+"&BORROWER="+BORROWER+"&DATE_FROM="+DATE_FROM+"&DATE_TO="+DATE_TO;
        ApiConnection api = new ApiConnection(url);
        api.execute(url);
    }
    public void addRequest(String ITEM_NAME, String ITEM_DESC, int USER_ID, Date DATE_FROM, Date DATE_TO){
        String url = server+"addRequest.php?"+"ITEM_NAME="+ITEM_NAME+"&ITEM_DESC="+ITEM_DESC+"&USER_ID="+USER_ID+"&DATE_FROM="+DATE_FROM+"&DATE_TO="+DATE_TO;
        ApiConnection api = new ApiConnection(url);
        api.execute(url);
    }
    public void deleteMessage(int MID){
        String url = server+"deleteMessage.php?"+"MID="+MID;
        ApiConnection api = new ApiConnection(url);
        api.execute(url);
    }
    public void deleteUser(int UID){
        String url = server+"deleteUser.php?"+"UID="+UID;
        ApiConnection api = new ApiConnection(url);
        api.execute(url);
    }
    public void deleteUserContacts(int UID){
        String url = server+"deleteUserContacts.php?"+"UID="+UID;
        ApiConnection api = new ApiConnection(url);
        api.execute(url);
    }
    public void deletedeleteUserItem(int IID){
        String url = server+"deleteUserItem.php?"+"IID="+IID;
        ApiConnection api = new ApiConnection(url);
        api.execute(url);
    }
    public void updateUserItems(String ITEM_NAME, String ITEM_DESC, int USER_ID, String BORROWER, Date DATE_FROM, Date DATE_TO){
        String url = server+"updateUserItems.php?"+"ITEM_NAME="+ITEM_NAME+"&ITEM_DESC="+ITEM_DESC+"&USER_ID="+USER_ID+"&BORROWER="+BORROWER+"&DATE_FROM="+DATE_FROM+"&DATE_TO="+DATE_TO;
        ApiConnection api = new ApiConnection(url);
        api.execute(url);
    }
    public void updateMarketplaceItems(String ITEM_NAME, String ITEM_DESC, int USER_ID, Date DATE_FROM, Date DATE_TO){
        String url = server+"updateMarketplaceItems.php?"+"ITEM_NAME="+ITEM_NAME+"&ITEM_DESC="+ITEM_DESC+"&USER_ID="+USER_ID+"&DATE_FROM="+DATE_FROM+"&DATE_TO="+DATE_TO;
        ApiConnection api = new ApiConnection(url);
        api.execute(url);
    }
    public void updateUsers(String NAME, String FIRST_NAME, String EMAIL, String TEL_NR, String USERNAME, String TYPE, Boolean VERIFIED, int UID){
        String url = server+"updateMarketplaceItems.php?"+"NAME="+NAME+"&=FIRST_NAME"+FIRST_NAME+"&=E-MAIL"+EMAIL+"&=TEL_NR"+TEL_NR+"&=USRNAME"+USERNAME+"&=TYPE"+TYPE+"&=UID"+UID;
        ApiConnection api = new ApiConnection(url);
        api.execute(url);
    }
}
