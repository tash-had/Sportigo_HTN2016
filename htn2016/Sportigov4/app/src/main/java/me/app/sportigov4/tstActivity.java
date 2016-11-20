package me.app.sportigov4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tst);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("event_data").addChildEventListener(childEventListener);

    }
    ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
            Log.d("DATASNAPSHOT", "onChildAdded:" + dataSnapshot.getKey());

            // A new comment has been added, add it to the displayed list
            EventsData ed = dataSnapshot.getValue(EventsData.class);
            Toast.makeText(tstActivity.this, ed.getEventTime(), Toast.LENGTH_SHORT).show();

    }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
};}
