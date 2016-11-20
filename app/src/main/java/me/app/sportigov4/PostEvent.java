package me.app.sportigov4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostEvent extends AppCompatActivity implements LocationListener {
    private EditText eventNameEt;
    private EditText eventDescEt;
    private TextView posterTv;
    private TimePicker eventTimePicker;
    private double longitude;
    private double latitude;
    private DatabaseReference mDatabase;
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_event_screen);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){
            Intent i = new Intent(PostEvent.this, MainActivity.class);
            startActivity(i);
        }

        eventNameEt = (EditText) findViewById(R.id.eventNameEt);
        eventDescEt = (EditText) findViewById(R.id.eventDescEt);
        posterTv = (TextView) findViewById(R.id.posterTv);
        eventTimePicker = (TimePicker) findViewById(R.id.eventTimePicker);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }


    private void getlatLong(){
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        try{
            longitude = location.getLongitude();
            latitude = location.getLatitude();
        }catch (Exception e){
        }
    }
    public void submitEvent(View v) {
        getlatLong();
        String name = eventNameEt.getText().toString().trim();
        String desc = eventDescEt.getText().toString().trim();
        String poster = "Poster: "+ "Tash-had";
        int hour = eventTimePicker.getCurrentHour();
        int minute = eventTimePicker.getCurrentMinute();
        String totalTime = Integer.toString(hour) + ":" + Integer.toString(minute);
        Long tsLong = System.currentTimeMillis()/1000;

        EventsData eventData = new EventsData(tsLong,name, longitude,latitude,true,10,desc,poster,"etcetc",totalTime);
        mDatabase.child("event_data").push().setValue(eventData);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "eventSubmitBtn");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Submit Event Button");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "button");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

}
