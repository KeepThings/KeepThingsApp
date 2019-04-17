package de.dhbw.students.keepthings.marketplace;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.dhbw.students.keepthings.R;


public class MarketplaceEntryListAdapter extends ArrayAdapter<MarketplaceEntry> implements View.OnClickListener {


    public MarketplaceEntryListAdapter(ArrayList<MarketplaceEntry> data, Context context) {
        super(context, R.layout.marketplace_entry, data);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MarketplaceEntry dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.user_item_entry, parent, false);
            viewHolder.txtTitle = convertView.findViewById(R.id.marketplace_title);
            viewHolder.txtOwner = convertView.findViewById(R.id.marketplace_owner);
            viewHolder.txtDateTo = convertView.findViewById(R.id.marketplace_dateto);
            viewHolder.txtDateFrom = convertView.findViewById(R.id.marketplace_datefrom);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.txtTitle.setText(dataModel.getTitle());
        viewHolder.txtOwner.setText(dataModel.getOwner());
        viewHolder.txtDateTo.setText(dataModel.getDateTo());
        viewHolder.txtDateFrom.setText(dataModel.getDateFrom());
        // Return the completed view to render on screen
        return convertView;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtTitle;
        TextView txtOwner;
        TextView txtDateTo;
        TextView txtDateFrom;
    }
}

