package edu.miracostacollege.cs134.sandiegomusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {


    private TextView eventTitleTextView;
    private TextView eventDayTextView;
    private TextView eventVenueTextView;
    private TextView eventTimeTextView;
    private TextView eventCityTextView;

    private ImageView eventImageView;
    private TextView eventStateTextView;

    public static final String TAG = EventDetailsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        Intent intent = getIntent();
        String artist = intent.getStringExtra("Artist");
        String date = intent.getStringExtra("Date");
        String day = intent.getStringExtra("Day");
        String time = intent.getStringExtra("Time");
        String venue = intent.getStringExtra("Venue");
        String city = intent.getStringExtra("City");
        String state = intent.getStringExtra("State");
        String imageName = intent.getStringExtra("ImageName");

        String dateDetails = date + " - " + day;


        eventTitleTextView = findViewById(R.id.eventTitleTextView);
        eventStateTextView = findViewById(R.id.eventStateTextView);
        eventCityTextView  = findViewById(R.id.eventCityTextView);
        eventDayTextView = findViewById(R.id.eventDayTextView);
        eventVenueTextView = findViewById(R.id.eventVenueTextView);
        eventImageView = findViewById(R.id.eventImageView);
        eventTimeTextView = findViewById(R.id.eventTimeTextView);

        eventTitleTextView.setText(artist);
        eventDayTextView.setText(dateDetails);
        eventStateTextView.setText(state);
        eventCityTextView.setText(city);
        eventVenueTextView.setText(venue);
        eventTimeTextView.setText(time);

        AssetManager am = getAssets();
        try {
            InputStream stream = am.open(imageName);
            Drawable eventImage = Drawable.createFromStream(stream, artist);
            eventImageView.setImageDrawable(eventImage);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }

    }
}
