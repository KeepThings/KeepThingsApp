package de.dhbw.students.keepthings.marketplace;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import de.dhbw.students.keepthings.R;
import de.dhbw.students.keepthings.main.LentOutEntry;
import de.dhbw.students.keepthings.main.LentOutEntryListAdapter;

public class MarketplaceFragment extends Fragment {

    private static LentOutEntryListAdapter adapter;
    private ArrayList<LentOutEntry> dataModels;
    private ListView merketplaceEntryList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataModels = new ArrayList<>();

        dataModels.add(new LentOutEntry("title", "person who need smthng", "dateFrom", "dateTo"));
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
        dataModels.add(new LentOutEntry("Lautsprecher", "Max Mustermann", "30 Oct 18", "9 Oct 18"));

        View rootView = inflater.inflate(R.layout.fragment_marketplace, container, false);


        merketplaceEntryList = rootView.findViewById(R.id.marketplace_entry_list);

        adapter = new LentOutEntryListAdapter(dataModels, rootView.getContext());

        merketplaceEntryList.setAdapter(adapter);

        return rootView;
    }
}
