package com.example.dhakad.aptitudetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dhakad on 1/6/2016.
 */
public class ListAdapter extends ArrayAdapter<RowItem> {

    private Context context;

    public ListAdapter(Context context, List<RowItem> dataItem) {
        super(context, R.layout.chiled_list, dataItem);

        this.context = context;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.chiled_list, null);
            viewHolder = new ViewHolder();


            viewHolder.level = (TextView) convertView
                    .findViewById(R.id.level);
            viewHolder.cat = (TextView) convertView
                    .findViewById(R.id.catg);

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        final RowItem temp = getItem(position);


        viewHolder.level.setText(temp.getLevel());
        viewHolder.cat.setText(temp.getCatg());
        return convertView;
    }

    public class ViewHolder {

        TextView level,cat;

    }
}
