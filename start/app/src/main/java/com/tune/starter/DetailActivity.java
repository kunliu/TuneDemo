package com.tune.starter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Kyle on 2017-01-09.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = (ImageView)findViewById(R.id.image);
        TextView nameView = (TextView)findViewById(R.id.name);
        TextView bioView = (TextView) findViewById(R.id.biography);

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("name");
        String image = bundle.getString("image");
        String bio = bundle.getString("bio");

        bioView.setText(bio);
        nameView.setText(name);

        Picasso.with(this).load(image).into(imageView);
    }
}
