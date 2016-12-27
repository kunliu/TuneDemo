package com.iphrack.tunedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Kyle on 16-10-19.
 */
public class CharacterAdapter extends ArrayAdapter{


    public CharacterAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.character_row, null);

        ((TextView)convertView.findViewById(R.id.name)).setText("asdfasdf");
        return convertView;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
