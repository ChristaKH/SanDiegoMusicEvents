package edu.miracostacollege.cs134.sandiegomusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.miracostacollege.cs134.sandiegomusicevents.model.MusicEvent;

public class MainActivity extends ListActivity {
    private ListView eventListView;

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //Extract info we need
        String artist = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        // Let's make the Intent
        // Navigate from this class to event details class
        Intent detailsIntent = new Intent( this, EventDetailsActivity.class);

        //Fill an intent with data
        detailsIntent.putExtra("Artist", artist);
        detailsIntent.putExtra("Details", details);

        // Starts the activity
        startActivity(detailsIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // Since layout is being inflated by ListView, don't setContentView
        eventListView = findViewById(R.id.eventsListView);

        ArrayAdapter<String> eventsAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, MusicEvent.titles);
        setListAdapter(eventsAdapter);
    }
}
