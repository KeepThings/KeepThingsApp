package de.dhbw.students.keepthings.marketplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.dhbw.students.keepthings.MainActivity;
import de.dhbw.students.keepthings.R;
import de.dhbw.students.keepthings.RvAdapterKlasse;
import de.dhbw.students.keepthings.user_item.new_user_item_entry.NewUserItemEntryActivity;

public class MarketplaceFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fab;
    private View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = inflater.inflate(R.layout.fragment_marketplace, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view_marketplace);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RvAdapterKlasse();
        recyclerView.setAdapter(adapter);

        MainActivity.textView = rootView.findViewById(R.id.marketplace_text_view);

        fab = rootView.findViewById(R.id.fab_marketplace);
        fab.setOnClickListener(view -> startActivity(new Intent(rootView.getContext(), NewUserItemEntryActivity.class)));

        return rootView;
    }
}
