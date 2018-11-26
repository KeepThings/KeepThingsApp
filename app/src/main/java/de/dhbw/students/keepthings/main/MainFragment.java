package de.dhbw.students.keepthings.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.dhbw.students.keepthings.R;

public class MainFragment extends Fragment {


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        return rootView;
    }
}
