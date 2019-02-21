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
    private TextView eventDetailsTextView;
    private ImageView eventImageView;

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

        String details = "";
        details += date;
        details += "\n" + day;
        details += "\n"  + time;
        details += "\n" + venue;
        details += "\n" + city;
        details += "\n" + state;
        details += "\n" + imageName;

        eventTitleTextView = findViewById(R.id.eventTitleTextView);
        eventDetailsTextView = findViewById(R.id.eventDetailsTextView);
        eventImageView = findViewById(R.id.eventImageView);

        eventTitleTextView.setText(artist);
        eventDetailsTextView.setText(details);

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
