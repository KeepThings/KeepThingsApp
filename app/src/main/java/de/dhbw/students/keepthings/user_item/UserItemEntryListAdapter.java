package de.dhbw.students.keepthings.user_item;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.dhbw.students.keepthings.ItemEntryListAdapter;
import de.dhbw.students.keepthings.R;
import de.dhbw.students.keepthings.marketplace.MarketplaceEntry;


public class UserItemEntryListAdapter extends ItemEntryListAdapter implements View.OnClickListener {


    public UserItemEntryListAdapter(ArrayList<UserItemEntry> data, Context context) {
        super(context, R.layout.user_item_entry, data);

    }
    @Override
    protected void showdata(View convertView, LayoutInflater inflater, ViewGroup parent){
        convertView = inflater.inflate(R.layout.user_item_entry, parent, false);
        viewHolder.txtTitle = convertView.findViewById(R.id.item_title);
        viewHolder.txtPerson = convertView.findViewById(R.id.item_person);
        viewHolder.txtDateTo = convertView.findViewById(R.id.item_dateto);
        viewHolder.txtDateFrom = convertView.findViewById(R.id.item_datefrom);
    }
    @Override
    protected void showdata2(Object dataModel){
        UserItemEntry userItemEntryModel = (UserItemEntry)dataModel;
        viewHolder.txtTitle.setText(userItemEntryModel.getTitle());
        viewHolder.txtPerson.setText(userItemEntryModel.getPerson());
        viewHolder.txtDateTo.setText(userItemEntryModel.getDateTo());
        viewHolder.txtDateFrom.setText(userItemEntryModel.getDateFrom());
    }
    // View lookup cache

}

