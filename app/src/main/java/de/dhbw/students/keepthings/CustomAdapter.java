package de.dhbw.students.keepthings;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter<LentOutEntry> implements View.OnClickListener {

    private int lastPosition = -1;

    public CustomAdapter(ArrayList<LentOutEntry> data, Context context) {
        super(context, R.layout.lent_out_entry, data);

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        LentOutEntry dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lent_out_entry, parent, false);
            viewHolder.txtTitle = (TextView) convertView.findViewById(R.id.title);
            viewHolder.txtPerson = (TextView) convertView.findViewById(R.id.person);
            viewHolder.txtDateTo = (TextView) convertView.findViewById(R.id.dateto);
            viewHolder.txtDateFrom = (TextView) convertView.findViewById(R.id.datefrom);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


        viewHolder.txtTitle.setText(dataModel.getTitle());
        viewHolder.txtPerson.setText(dataModel.getPerson());
        viewHolder.txtDateTo.setText(dataModel.getDateTo());
        viewHolder.txtDateFrom.setText(dataModel.getDateFrom());
        // Return the completed view to render on screen
        return convertView;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView txtTitle;
        TextView txtPerson;
        TextView txtDateTo;
        TextView txtDateFrom;
    }
}

