package me.app.sportigov4;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventFeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventFeedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Uuse this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventFeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventFeedFragment newInstance(String param1, String param2) {
        EventFeedFragment fragment = new EventFeedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public EventFeedFragment() {
        // Required empty public constructor
    }

    //added
    private static Intent getIntent(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int layoutId = getArguments().getInt("layoutId", R.layout.event_template);

        /*FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 180, 0, 0);*/

        FrameLayout v;
        switch (layoutId) {
            case 3://going
                FrameLayout frame = new FrameLayout(getActivity());
                ScrollView scroll = new ScrollView(getActivity());
                scroll.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
                LinearLayout linear = new LinearLayout(getActivity());
                linear.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                linear.setOrientation(LinearLayout.VERTICAL);//needed to explicitly say this for it to work
                for (int i = 0; i < 10; i++) {
                    Event evt = new Event(getActivity());
                    evt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    linear.addView(evt);
                }
                scroll.addView(linear);
                frame.addView(scroll);
                v = frame;
                break;
            case 2://feed
                FrameLayout bframe = new FrameLayout(getActivity());
                ScrollView bscroll = new ScrollView(getActivity());
                LinearLayout blinear = new LinearLayout(getActivity());
                blinear.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                blinear.setOrientation(LinearLayout.VERTICAL);//needed to explicitly say this for it to work
                    final Event bevt = new Event(getActivity());
                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
                    Query all_events = dbRef.child("event_data").orderByChild("eventId");
                    all_events.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                                Log.e("TAG",postSnapshot.child("eventName").toString());
                                bevt.eventName = "YO";

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    bevt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    blinear.addView(bevt);
                bscroll.addView(blinear);
                bframe.addView(bscroll);
                v = bframe;
                break;
            default://map or glitch
                v = new FrameLayout(getActivity());
        }


       // Intent intent = getIntent(getActivity(), MainActivity.class);//added


        return v;
        //return inflater.inflate(layoutId, container, false);
    }


}
