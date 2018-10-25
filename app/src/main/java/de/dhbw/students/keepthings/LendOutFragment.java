package de.dhbw.students.keepthings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class LendOutFragment extends Fragment {


    private static CustomAdapter adapter;
    private ArrayList<LentOutEntry> dataModels;
    private ListView lentOutEntryList;

    public LendOutFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        dataModels = new ArrayList<>();

        dataModels.add(new LentOutEntry("title", "person", "dateTo", "dateFrom"));
        dataModels.add(new LentOutEntry("Lautsprecher", "Max Mustermann", "30 Oct 18", "9 Oct 18"));
        dataModels.add(new LentOutEntry("Pfanne", "Max Mustermann", "30 Oct 18", "27 Oct 18"));
        dataModels.add(new LentOutEntry("30 Euro", "Max Mustermann", "30 Oct 18", "15 Oct 18"));
        dataModels.add(new LentOutEntry("Fahrradpumpe", "Max Mustermann", "30 Oct 18", "26 Oct 18"));
        dataModels.add(new LentOutEntry("Fußball", "Max Mustermann", "30 Oct 18", "20 Oct 18"));
        dataModels.add(new LentOutEntry("Taschenlampe", "Max Mustermann", "30 Oct 18", "6 Oct 18"));
        dataModels.add(new LentOutEntry("Zelt", "Max Mustermann", "30 Oct 18", "22 Oct 18"));
        dataModels.add(new LentOutEntry("Kopfhörer", "Max Mustermann", "30 Oct 18", "18 Oct 18"));
        dataModels.add(new LentOutEntry("Kettensäge", "Max Mustermann", "30 Oct 18", "9 Oct 18"));
        dataModels.add(new LentOutEntry("Schraubenzieher", "Max Mustermann", "30 Oct 18", "15 Oct 18"));
        dataModels.add(new LentOutEntry("Biertischgarnitur", "Max Mustermann", "30 Oct 18", "12 Oct 18"));
        dataModels.add(new LentOutEntry("Anhänger", "Max Mustermann", "30 Oct 18", "5 Oct 18"));

        View rootView = inflater.inflate(R.layout.fragment_lend_out, container, false);


        lentOutEntryList = (ListView) rootView.findViewById(R.id.lent_out_entry_list);

        adapter = new CustomAdapter(dataModels, rootView.getContext());

        lentOutEntryList.setAdapter(adapter);

        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
