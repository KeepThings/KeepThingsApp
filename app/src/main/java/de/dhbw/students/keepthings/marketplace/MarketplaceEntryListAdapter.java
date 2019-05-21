package de.dhbw.students.keepthings.marketplace;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.dhbw.students.keepthings.ItemEntryListAdapter;
import de.dhbw.students.keepthings.R;
import de.dhbw.students.keepthings.api.ItemEntry;
import de.dhbw.students.keepthings.user_item.UserItemEntryListAdapter;


public class MarketplaceEntryListAdapter extends ItemEntryListAdapter implements View.OnClickListener {


    public MarketplaceEntryListAdapter(ArrayList data, Context context) {
        super(context, R.layout.marketplace_entry, data);

    }

    @Override
    protected void showdata(View convertView, LayoutInflater inflater, ViewGroup parent){
        convertView = inflater.inflate(R.layout.marketplace_entry, parent, false);
        super.viewHolder.txtTitle = convertView.findViewById(R.id.marketplace_title);
        super.viewHolder.txtPerson = convertView.findViewById(R.id.marketplace_owner);
        super.viewHolder.txtDateTo = convertView.findViewById(R.id.marketplace_dateto);
        super.viewHolder.txtDateFrom = convertView.findViewById(R.id.marketplace_datefrom);
    }
    @Override
    protected void showdata2(Object dataModel){
        MarketplaceEntry marketPlaceEntryModel = (MarketplaceEntry)dataModel;
        viewHolder.txtTitle.setText(marketPlaceEntryModel.getTitle());
        viewHolder.txtPerson.setText(marketPlaceEntryModel.getOwner());
        viewHolder.txtDateTo.setText(marketPlaceEntryModel.getDateTo());
        viewHolder.txtDateFrom.setText(marketPlaceEntryModel.getDateFrom());
    }
}

