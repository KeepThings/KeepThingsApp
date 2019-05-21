package de.dhbw.students.keepthings;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.dhbw.students.keepthings.marketplace.MarketplaceEntry;
import de.dhbw.students.keepthings.marketplace.MarketplaceEntryListAdapter;

public abstract class ItemEntryListAdapter extends ArrayAdapter implements View.OnClickListener {

    protected ViewHolder viewHolder;
    public  ItemEntryListAdapter(Context context, @LayoutRes int resource, ArrayList data){
        super(context, resource, data);
        viewHolder = new ViewHolder();
    }

    @Override
    public void onClick(View v) {

    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Object dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
         // view lookup cache stored in tag
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            showdata(convertView, inflater, parent);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        showdata2(dataModel);
        // Return the completed view to render on screen
        return convertView;
    }
    protected abstract void showdata(View convertView, LayoutInflater inflater, ViewGroup parent);
    protected abstract void showdata2(Object dataModel);
    protected static class ViewHolder {
        public TextView txtTitle;
        public TextView txtPerson;
        public TextView txtDateTo;
        public  TextView txtDateFrom;
    }
}
