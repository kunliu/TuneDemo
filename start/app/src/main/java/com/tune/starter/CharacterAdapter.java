package com.tune.starter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Kyle on 2017-01-08.
 */

public class CharacterAdapter extends ArrayAdapter {
    public CharacterAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.character_row,null);

        TextView textView = (TextView) convertView.findViewById(R.id.character_name);
        textView.setText("Hello World:"+position);

        return convertView;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
