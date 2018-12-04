package de.dhbw.students.keepthings.api;

import org.json.JSONArray;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import de.dhbw.students.keepthings.MainActivity;
import de.dhbw.students.keepthings.main.LentOutEntry;

public class ApiLentOutItemList extends ApiConnection {
    protected MainActivity activity;

    public ApiLentOutItemList(String purl, UrlCase urlcase, MainActivity activity) {
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
        ArrayList<LentOutEntry> lentOutEntries = new ArrayList<>();

        for (int i = 0; i < itemList.size(); i++) {
            String title = itemList.get(i).getITEM_NAME();
            String person = itemList.get(i).getBORROWER();
            String dateTo = itemList.get(i).getDATE_TO();
            String dateFrom = itemList.get(i).getDATE_FROM();
            lentOutEntries.add(new LentOutEntry(title, person, dateTo, dateFrom));
        }

//        lentOutEntries.add(new LentOutEntry("title", "person", "dateTo", "dateFrom"));
//        lentOutEntries.add(new LentOutEntry("Pfanne", "Max Mustermann", "30 Oct 18", "27 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("30 Euro", "Max Mustermann", "30 Oct 18", "15 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Fahrradpumpe", "Max Mustermann", "30 Oct 18", "26 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Fußball", "Max Mustermann", "30 Oct 18", "20 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Taschenlampe", "Max Mustermann", "30 Oct 18", "6 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Zelt", "Max Mustermann", "30 Oct 18", "22 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Kopfhörer", "Max Mustermann", "30 Oct 18", "18 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Kettensäge", "Max Mustermann", "30 Oct 18", "9 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Schraubenzieher", "Max Mustermann", "30 Oct 18", "15 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Biertischgarnitur", "Max Mustermann", "30 Oct 18", "12 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Anhänger", "Max Mustermann", "30 Oct 18", "5 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Wanderstiefel", "Max Mustermann", "30 Oct 18", "17 Oct 18"));
//        lentOutEntries.add(new LentOutEntry("Lautsprecher", "Max Mustermann", "30 Oct 18", "9 Oct 18"));
        activity.setItems(lentOutEntries);

        if (!activity.isListInit()) {
            activity.setFragment();
        }


    }
}

