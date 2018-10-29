package de.dhbw.students.keepthings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class NewLentOutEntryFragment extends Fragment {


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_new_lent_out_entry, container, false);

        EditText titleEdit = rootView.findViewById(R.id.title_edit);
        EditText descEdit = rootView.findViewById(R.id.desc_edit);
        EditText personEdit = rootView.findViewById(R.id.person_edit);
        EditText dateFromEdit = rootView.findViewById(R.id.date_from_edit);
        EditText dateToEdit = rootView.findViewById(R.id.date_to_edit);


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
