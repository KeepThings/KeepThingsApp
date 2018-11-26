package de.dhbw.students.keepthings.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.dhbw.students.keepthings.R;

public class RvAdapterKlasse extends RecyclerView.Adapter<RvAdapterKlasse.ViewHolderClass> {

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lent_out_entry, null);

        return new ViewHolderClass(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass viewHolderClass, final int i) {

        viewHolderClass.itemTitle.setText(MainActivity.itemTitle.get(i));
        viewHolderClass.itemPerson.setText(MainActivity.itemPerson.get(i));
        viewHolderClass.itemDateTo.setText(MainActivity.itemDateTo.get(i));
        viewHolderClass.itemDateFrom.setText(MainActivity.itemDateFrom.get(i));

        viewHolderClass.itemView.setOnClickListener(view -> MainActivity.textView.setText(MainActivity.itemTitle.get(i)));

    }

    @Override
    public int getItemCount() {
        return MainActivity.itemTitle.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {


        TextView itemTitle;
        TextView itemPerson;
        TextView itemDateTo;
        TextView itemDateFrom;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);


            itemTitle = itemView.findViewById(R.id.item_title);
            itemPerson = itemView.findViewById(R.id.item_person);
            itemDateTo = itemView.findViewById(R.id.item_dateto);
            itemDateFrom = itemView.findViewById(R.id.item_datefrom);

        }
    }
}
