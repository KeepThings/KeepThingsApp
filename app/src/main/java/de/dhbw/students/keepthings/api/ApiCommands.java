package de.dhbw.students.keepthings.api;

import de.dhbw.students.keepthings.new_lent_out_entry.NewLentOutEntryActivity;

public class ApiCommands {

    public static String server = "http://185.244.195.51/keepthings/api/";

    public static void addEntry(String ITEM_NAME, String ITEM_DESC, int USER_ID, String BORROWER, String DATE_FROM, String DATE_TO, NewLentOutEntryActivity activity) {
        String url = server + "addEntry.php?" + "ITEM_NAME=" + ITEM_NAME + "&ITEM_DESC=" + ITEM_DESC + "&USER_ID=" + USER_ID + "&BORROWER=" + BORROWER + "&DATE_FROM=" + DATE_FROM + "&DATE_TO=" + DATE_TO;
        ApiLentOutFragment api = new ApiLentOutFragment(url, UrlCase.success, activity); //für das LendoutFragment
        api.execute(url);
    }

/* Muss man wie bei addEntry anpassen was für eine unterklasse von ApiConnection erstellt wird.
    public static void getUsers(String UID, String ALL, Activity activity) {
        String url = server + "getUsers.php?" + "UID=" + UID + "&ALL=" + ALL;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 0, activity);
        api.execute(url);
    }

    public static void getUserItems(String IID, String UID, Activity activity) {
        String url = server + "getUserItems.php?" + "IID=" + IID + "&UID=" + UID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 1, activity);
        api.execute(url);
    }

    public static void getUserContactAssignments(String UID, Activity activity) {
        String url = server + "getUserContactAssignments.php?" + "UID=" + UID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 2, activity);
        api.execute(url);
    }

    public static void getMessages(String MID, String SID, Activity activity) {
        String url = server + "getMessages.php?" + "MID=" + MID + "SID=" + SID;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 3, activity);
        api.execute(url);
    }

    public static void getMarketplaceItems(String IID, String ALL, Activity activity) {
        String url = server + "getMarketplaceItems.php?" + "IID=" + IID + "&ALL=" + ALL;
        ApiGetUsersConnection api = new ApiGetUsersConnection(url, 4, activity);
        api.execute(url);
    }

    public static void addRequest(String ITEM_NAME, String ITEM_DESC, int USER_ID, String DATE_FROM, String DATE_TO, Activity activity) {
        String url = server + "addRequest.php?" + "ITEM_NAME=" + ITEM_NAME + "&ITEM_DESC=" + ITEM_DESC + "&USER_ID=" + USER_ID + "&DATE_FROM=" + DATE_FROM + "&DATE_TO=" + DATE_TO;
        ApiSetConnection api = new ApiSetConnection(url, activity);
        api.execute(url);
    }

    public static void deleteMessage(int MID, Activity activity) {
        String url = server + "deleteMessage.php?" + "MID=" + MID;
        ApiSetConnection api = new ApiSetConnection(url, activity);
        api.execute(url);
    }

    public static void deleteUser(int UID, Activity activity) {
        String url = server + "deleteUser.php?" + "UID=" + UID;
        ApiSetConnection api = new ApiSetConnection(url, activity);
        api.execute(url);
    }

    public static void deleteUserContacts(int UID, Activity activity) {
        String url = server + "deleteUserContacts.php?" + "UID=" + UID;
        ApiSetConnection api = new ApiSetConnection(url, activity);
        api.execute(url);
    }

    public static void deletedeleteUserItem(int IID, Activity activity) {
        String url = server + "deleteUserItem.php?" + "IID=" + IID;
        ApiSetConnection api = new ApiSetConnection(url, activity);
        api.execute(url);
    }

    public static void updateUserItems(String ITEM_NAME, String ITEM_DESC, int USER_ID, String BORROWER, String DATE_FROM, String DATE_TO, Activity activity) {
        String url = server + "updateUserItems.php?" + "ITEM_NAME=" + ITEM_NAME + "&ITEM_DESC=" + ITEM_DESC + "&USER_ID=" + USER_ID + "&BORROWER=" + BORROWER + "&DATE_FROM=" + DATE_FROM + "&DATE_TO=" + DATE_TO;
        ApiSetConnection api = new ApiSetConnection(url, activity);
        api.execute(url);
    }

    public static void updateMarketplaceItems(String ITEM_NAME, String ITEM_DESC, int USER_ID, String DATE_FROM, String DATE_TO, Activity activity) {
        String url = server + "updateMarketplaceItems.php?" + "ITEM_NAME=" + ITEM_NAME + "&ITEM_DESC=" + ITEM_DESC + "&USER_ID=" + USER_ID + "&DATE_FROM=" + DATE_FROM + "&DATE_TO=" + DATE_TO;
        ApiSetConnection api = new ApiSetConnection(url, activity);
        api.execute(url);
    }

    public static void updateUsers(String NAME, String FIRST_NAME, String EMAIL, String TEL_NR, String USERNAME, String TYPE, Boolean VERIFIED, int UID, Activity activity) {
        String url = server + "updateMarketplaceItems.php?" + "NAME=" + NAME + "&=FIRST_NAME" + FIRST_NAME + "&=E-MAIL" + EMAIL + "&=TEL_NR" + TEL_NR + "&=USRNAME" + USERNAME + "&=TYPE" + TYPE + "&=UID" + UID;
        ApiSetConnection api = new ApiSetConnection(url, activity);
        api.execute(url);
    }*/
}
