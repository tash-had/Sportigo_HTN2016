package me.app.sportigov4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by George on 18/09/2016.
 */
public class EventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        Bundle extras = getIntent().getExtras();
        long eventId = extras.getLong("id");

        //request data..

        String eventName = "";
        double longi = 0;
        double lat = 0;
        boolean signedUp = false;
        int totalNeeded = 0;
        String desc = "";
        String poster = "";
        String participants = "";
        String eventTime = "";


        ((TextView)(findViewById(R.id.ename))).setText(eventName);
        ((TextView)(findViewById(R.id.edate))).setText(""+eventTime);
        ((TextView)(findViewById(R.id.edesc))).setText(desc);
        ((TextView)(findViewById(R.id.eloc))).setText(longi+", "+lat);
        ((TextView)(findViewById(R.id.ecount))).setText((participants.split(",").length+"/"+totalNeeded));
        ((TextView)(findViewById(R.id.eteam))).setText(poster+"(Creator)"+"\n"+participants);

        Button reg = (Button)findViewById(R.id.eregister);
        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //update????-----------------------------
                ((Button)findViewById(R.id.eregister)).setText("Signed Up!");
                String h = ((TextView)(findViewById(R.id.ecount))).getText().toString();
                int part = Integer.parseInt(h.substring(0, h.indexOf("/")));
                ((TextView)(findViewById(R.id.ecount))).setText(part+"/"+h.substring(h.indexOf("/")+1));
            }
        });


    }
}
