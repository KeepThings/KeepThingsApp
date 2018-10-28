package de.dhbw.students.keepthings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class NewLentOutEntryFragment extends Fragment {

    private static CustomAdapter adapter;
    private ArrayList<LentOutEntry> dataModels;
    private ListView lentOutEntryList;

    public NewLentOutEntryFragment() {
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataModels = new ArrayList<>();

        dataModels.add(new LentOutEntry("Make your new entry here.", "person", "dateTo", "dateFrom"));

        View rootView = inflater.inflate(R.layout.fragment_lend_out, container, false);


        lentOutEntryList = rootView.findViewById(R.id.lent_out_entry_list);

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

        return super.onOptionsItemSelected(item);
    }
}
