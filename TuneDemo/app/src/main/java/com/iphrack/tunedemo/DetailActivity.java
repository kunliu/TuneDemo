package com.iphrack.tunedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Kyle on 2017-01-08.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Bundle bundle = getIntent().getExtras();

        String image = bundle.getString("image");
        String name = bundle.getString("name");
        String bio = bundle.getString("biography");

        ImageView imageView = (ImageView)findViewById(R.id.image);
        TextView nameTextView = (TextView) findViewById(R.id.name);
        TextView bioTextView = (TextView) findViewById(R.id.biography);

        Picasso.with(DetailActivity.this).load(image).into(imageView);
        nameTextView.setText(name);
        bioTextView.setText(bio);
    }
}
