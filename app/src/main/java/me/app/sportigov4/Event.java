package me.app.sportigov4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Event extends FrameLayout implements View.OnClickListener {

    public String eventName;
    public double longi = 0;
    public double lat = 0;
    public boolean signedUp = false;
    public int totalNeeded = 0;
    public String desc = "";
    public String poster = "";
    public String participants = "";
    public String eventTime = "";
    public long eventId = 0;

    public Event(Context context) {
        super(context);
        init();
    }

    public Event(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Event(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.event_template, this);

        //request server data

        setOnClickListener(this);

        ((TextView)(this.findViewById(R.id.nameEvent))).setText(eventName);
        ((TextView)(findViewById(R.id.time))).setText(""+eventTime);
        ((TextView)(findViewById(R.id.desc))).setText(desc);
        ((TextView)(findViewById(R.id.loc))).setText(longi+", "+lat);
        ((TextView)(findViewById(R.id.peeps))).setText((participants.split(",").length+"/"+totalNeeded));
        ((TextView)(findViewById(R.id.poster))).setText(poster);
        //ProgressBar p = (ProgressBar)(findViewById(R.id.progressBar));
       // p.setProgress((int) (100*( (participants.split(",").length)) / (float)(totalNeeded)));
    }

    @Override
    public void onClick(View view) {
       MainActivity.goToEventPage(eventId);
    }
}