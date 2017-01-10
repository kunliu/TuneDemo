package com.tune.starter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kyle on 2017-01-08.
 */

public class CharacterAdapter extends ArrayAdapter {
    ArrayList list;

    public CharacterAdapter(Context context, int resource, ArrayList arrayList) {
        super(context, resource);
        list = arrayList;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.character_row,null);

        final Character character = (Character) list.get(position);

        TextView textView = (TextView) convertView.findViewById(R.id.character_name);
        textView.setText(character.name);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityForCharacter(character);
            }
        });

        return convertView;
    }

    private void launchActivityForCharacter(Character character){

        Intent intent = new Intent(getContext(),DetailActivity.class);

        intent.putExtra("name",character.name);
        intent.putExtra("image",character.image);
        intent.putExtra("bio",character.biography);

        getContext().startActivity(intent);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
