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

    private ListView eventsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        eventsListView = findViewById(R.id.eventsListView);
        setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles));
        //setContentView(R.layout.activity_main);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("Title", MusicEvent.titles[position]);
        detailsIntent.putExtra("Details", MusicEvent.details[position]);
        startActivity(detailsIntent);

    }
}
