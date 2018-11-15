package de.dhbw.students.keepthings;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class LendOutFragment extends Fragment {


    private static CustomAdapter adapter;
    private ArrayList<LentOutEntry> dataModels;
    private ListView lentOutEntryList;
    private FloatingActionButton fab;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
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
        dataModels.add(new LentOutEntry("Wanderstiefel", "Max Mustermann", "30 Oct 18", "17 Oct 18"));

        rootView = inflater.inflate(R.layout.fragment_lend_out, container, false);

        lentOutEntryList = rootView.findViewById(R.id.lent_out_entry_list);

        adapter = new CustomAdapter(dataModels, rootView.getContext());

        lentOutEntryList.setAdapter(adapter);

        fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(rootView.getContext(), NewEntryActivity.class);
                startActivity(i);
            }
        });

        return rootView;
    }
}
