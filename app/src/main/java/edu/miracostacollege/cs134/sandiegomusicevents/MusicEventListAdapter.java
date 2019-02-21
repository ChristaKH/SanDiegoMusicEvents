package edu.miracostacollege.cs134.sandiegomusicevents;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import edu.miracostacollege.cs134.sandiegomusicevents.model.MusicEvent;


public class MusicEventListAdapter extends ArrayAdapter<MusicEvent> {

    // Declare member variables to store the parameters (context, resource id, List of <MusicEvent>
    private Context mContext;
    private int mResourceID;
    private List<MusicEvent> mAllEvents;

    // MainActivity will call this ListAdapter
    // This constructor is being called by MainActivity
    public MusicEventListAdapter(@NonNull Context context, int resource, @NonNull List<MusicEvent> objects) {
        super(context, resource, objects);
        mContext = context;
        mResourceID = resource;
        mAllEvents = objects;
    }

    // In order to bridge the View (music_event_list_item) with the Model (MusicEvent), we override:
    // Ctrl + o => Override

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Inflate our custom layout with data from List<MusicEvent>
        MusicEvent focusedEvent = mAllEvents.get(position);

        // Manually inflate custom layout
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Tell the inflater to inflate music_event_list_item
        // The root is for the parent or container, in this case null
        View customView = inflater.inflate(mResourceID, null);

        // Fill the parts of the custom View
        ImageView listItemImageView = customView.findViewById(R.id.listItemImageView);
        TextView  listItemTitleTextView = customView.findViewById(R.id.listItemTitleTextView);
        TextView listItemDateTextView = customView.findViewById(R.id.listItemDateTextView);

        // Put info into text views and image view
        listItemTitleTextView.setText(focusedEvent.getArtist());
        listItemDateTextView.setText(focusedEvent.getDate());

        //Load the image dynamically
        AssetManager am = mContext.getAssets();
        try{
            InputStream stream = am.open(focusedEvent.getImageName());
            Drawable image = Drawable.createFromStream(stream, focusedEvent.getArtist());

            // Put image into ImageView
            listItemImageView.setImageDrawable(image);
        }
        catch( IOException e)
        {
            Log.e( "SD Music Eventts", e.getMessage());
        }

        // Return custom view with all information
        return customView;
    }
}
