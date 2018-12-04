package de.dhbw.students.keepthings.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import de.dhbw.students.keepthings.MainActivity;
import de.dhbw.students.keepthings.R;
import de.dhbw.students.keepthings.RvAdapterKlasse;
import de.dhbw.students.keepthings.api.ApiCommands;
import de.dhbw.students.keepthings.new_lent_out_entry.NewLentOutEntryActivity;

public class LentOutFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<LentOutEntry> dataModels;
    private FloatingActionButton fab;
    private View rootView;

    public LentOutFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = inflater.inflate(R.layout.fragment_lend_out, container, false);

        mSwipeRefreshLayout = rootView.findViewById(R.id.pullToRefresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        recyclerView = rootView.findViewById(R.id.recycler_view_test);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        adapter = new RvAdapterKlasse();
        recyclerView.setAdapter(adapter);

        MainActivity.textView = rootView.findViewById(R.id.item_text_view);


        fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent i = new Intent(rootView.getContext(), NewLentOutEntryActivity.class);
            startActivity(i);
        });

        return rootView;
    }

    @Override
    public void onRefresh() {
        ApiCommands.getUserItems("1", (MainActivity) getActivity());
        Log.e("Refresh", "Refresh");
        recyclerView.setAdapter(adapter);
    }
}