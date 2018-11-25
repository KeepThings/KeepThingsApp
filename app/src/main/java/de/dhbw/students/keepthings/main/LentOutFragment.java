package de.dhbw.students.keepthings.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import de.dhbw.students.keepthings.NewEntryActivity;
import de.dhbw.students.keepthings.R;

public class LendOutFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    private ArrayList<LentOutEntry> dataModels;
    private FloatingActionButton fab;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = inflater.inflate(R.layout.fragment_lend_out, container, false);


        recyclerView = rootView.findViewById(R.id.recycler_view_test);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        adapter = new RvAdapterKlasse();
        recyclerView.setAdapter(adapter);

        MainActivity.textView = rootView.findViewById(R.id.item_text_view);


        fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent i = new Intent(rootView.getContext(), NewEntryActivity.class);
            startActivity(i);
        });

        return rootView;
    }
}