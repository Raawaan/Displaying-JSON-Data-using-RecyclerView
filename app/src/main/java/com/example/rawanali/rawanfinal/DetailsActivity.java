package com.example.rawanali.rawanfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

/**
 * Created by Rawan Ali on 9/5/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    ImageView coverImageView;
    ImageView posterImageView;
    TextView nameTextView;
    TextView dateTextView;
    TextView rateTextView;
    TextView descriptionTextView;
    TextView votersTextView;
    private image movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        movie = (image) getIntent().getExtras().getSerializable("Movie");

        coverImageView = (ImageView) findViewById(R.id.cover);
        posterImageView = (ImageView) findViewById(R.id.poster);
        nameTextView = (TextView) findViewById(R.id.name);
        dateTextView = (TextView) findViewById(R.id.date);
        rateTextView = (TextView) findViewById(R.id.rate);
        descriptionTextView = (TextView) findViewById(R.id.description);
        votersTextView = (TextView) findViewById(R.id.voters);

        Picasso.with(coverImageView.getContext()).load(movie.getBackDropUrl()).into(coverImageView);
        Picasso.with(posterImageView.getContext()).load(movie.getImageUrl()).into(posterImageView);
        nameTextView.setText(movie.getName());
        dateTextView.setText("Date: "+movie.getDate());
        rateTextView.setText("Rate: "+String.format(Locale.getDefault(), "%.2f", movie.getRate()));
        descriptionTextView.setText(movie.getDescription());
        votersTextView.setText("Voters :"+String.format(Locale.getDefault(), "%d", movie.getNumOfVoters()));
    }

}
