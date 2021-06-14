package com.example.project21.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project21.R;

import java.util.ArrayList;

public class IconAdapter extends ArrayAdapter<SearchObject> implements Filterable {

    private static ArrayList<SearchObject> objectlist;
    private ArrayList<SearchObject> resultlist;

    public IconAdapter(@NonNull Context context, @NonNull ArrayList<SearchObject> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);

        if(objectlist == null) {
            objectlist = (ArrayList<SearchObject>) objects.clone();
        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.search_list_item_layout, parent, false);

        }

        SearchObject currentItem = getItem(position);


        ImageView imageView = listItemView.findViewById(R.id.img_list);
        imageView.setImageResource(currentItem.getIconID());
        TextView name = listItemView.findViewById(R.id.student_name_text);
        name.setText(currentItem.getName());

        if(currentItem instanceof UserObject){

            TextView email = listItemView.findViewById(R.id.student_email_text);
            email.setText((((UserObject) currentItem).getEmail()));

        }



        return listItemView;
    }

    @NonNull
    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults results = new FilterResults();

                resultlist = new ArrayList<SearchObject>();

                if(constraint != null) {

                    for (int i = 0; i < objectlist.size(); i++) {

                        if (objectlist.get(i).getName().toLowerCase().contains(constraint.toString().toLowerCase())) {

                            results.count++;
                            resultlist.add(objectlist.get(i));
                        }

                    }
                    results.values = resultlist;

                } else {
                    results.values = objectlist;
                    results.count = objectlist.size();
                }


                return results;



            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                clear();

                    for (int i = 0; i < ((ArrayList<SearchObject>) results.values).size(); i++)
                        add(((ArrayList<SearchObject>) results.values).get(i));

                notifyDataSetChanged();


            }
        };

    }
}
