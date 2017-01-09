package com.iphrack.tunedemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kyle on 16-10-19.
 */
public class CharacterAdapter extends ArrayAdapter{
    ArrayList list;

    public CharacterAdapter(Context context, int resource,ArrayList arrayList) {
        super(context, resource);
        list = arrayList;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Character character = (Character)list.get(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.character_row, null);

        ((TextView)convertView.findViewById(R.id.name)).setText(character.name);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Character character = (Character) list.get(position);

                Intent intent = new Intent(getContext(),DetailActivity.class);
                intent.putExtra("name",character.name);
                intent.putExtra("image",character.image);
                intent.putExtra("house",character.house);
                intent.putExtra("biography",character.biography);
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
