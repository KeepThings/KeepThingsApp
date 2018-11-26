package de.dhbw.students.keepthings.api;

import android.app.Activity;
import java.util.Date;

public class ApiCommands {

    public String server = "http://10.0.2.2/";

    public void getUsers(String UID, String ALL, Activity activity){
        String url = server+"getUsers.php?"+"UID="+UID+"&ALL="+ALL;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url,0,activity);
        api.execute(url);
    }
    public void getUserItems(String IID, String UID, Activity activity){
        String url = server+"getUserItems.php?"+"IID="+IID+"&UID="+UID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url,1,activity);
        api.execute(url);
    }
    public void getUserContactAssignments(String UID, Activity activity){
        String url = server+"getUserContactAssignments.php?"+"UID="+UID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url,2,activity);
        api.execute(url);
    }
    public void getMessages(String MID,String SID, Activity activity){
        String url = server+"getMessages.php?"+"MID="+MID+"SID="+SID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url,3,activity);
        api.execute(url);
    }
    public void getMarketplaceItems(String IID, String ALL, Activity activity){
        String url = server+"getMarketplaceItems.php?"+"IID="+IID+"&ALL="+ALL;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url,4,activity);
        api.execute(url);
    }
    public void addEntry(String ITEM_NAME, String ITEM_DESC, int USER_ID, String BORROWER, Date DATE_FROM, Date DATE_TO, Activity activity){
        String url = server+"addEntry.php?"+"ITEM_NAME="+ITEM_NAME+"&ITEM_DESC="+ITEM_DESC+"&USER_ID="+USER_ID+"&BORROWER="+BORROWER+"&DATE_FROM="+DATE_FROM+"&DATE_TO="+DATE_TO;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 6,activity);
        api.execute(url);
    }
    public void addRequest(String ITEM_NAME, String ITEM_DESC, int USER_ID, Date DATE_FROM, Date DATE_TO, Activity activity){
        String url = server+"addRequest.php?"+"ITEM_NAME="+ITEM_NAME+"&ITEM_DESC="+ITEM_DESC+"&USER_ID="+USER_ID+"&DATE_FROM="+DATE_FROM+"&DATE_TO="+DATE_TO;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 6,activity);
        api.execute(url);
    }
    public void deleteMessage(int MID, Activity activity){
        String url = server+"deleteMessage.php?"+"MID="+MID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 6,activity);
        api.execute(url);
    }
    public void deleteUser(int UID, Activity activity){
        String url = server+"deleteUser.php?"+"UID="+UID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 6,activity);
        api.execute(url);
    }
    public void deleteUserContacts(int UID, Activity activity){
        String url = server+"deleteUserContacts.php?"+"UID="+UID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 6,activity);
        api.execute(url);
    }
    public void deletedeleteUserItem(int IID, Activity activity){
        String url = server+"deleteUserItem.php?"+"IID="+IID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 6,activity);
        api.execute(url);
    }
    public void updateUserItems(String ITEM_NAME, String ITEM_DESC, int USER_ID, String BORROWER, Date DATE_FROM, Date DATE_TO, Activity activity){
        String url = server+"updateUserItems.php?"+"ITEM_NAME="+ITEM_NAME+"&ITEM_DESC="+ITEM_DESC+"&USER_ID="+USER_ID+"&BORROWER="+BORROWER+"&DATE_FROM="+DATE_FROM+"&DATE_TO="+DATE_TO;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 6,activity);
        api.execute(url);
    }
    public void updateMarketplaceItems(String ITEM_NAME, String ITEM_DESC, int USER_ID, Date DATE_FROM, Date DATE_TO, Activity activity){
        String url = server+"updateMarketplaceItems.php?"+"ITEM_NAME="+ITEM_NAME+"&ITEM_DESC="+ITEM_DESC+"&USER_ID="+USER_ID+"&DATE_FROM="+DATE_FROM+"&DATE_TO="+DATE_TO;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 6,activity);
        api.execute(url);
    }
    public void updateUsers(String NAME, String FIRST_NAME, String EMAIL, String TEL_NR, String USERNAME, String TYPE, Boolean VERIFIED, int UID, Activity activity){
        String url = server+"updateMarketplaceItems.php?"+"NAME="+NAME+"&=FIRST_NAME"+FIRST_NAME+"&=E-MAIL"+EMAIL+"&=TEL_NR"+TEL_NR+"&=USRNAME"+USERNAME+"&=TYPE"+TYPE+"&=UID"+UID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 6,activity);
        api.execute(url);
    }
}
