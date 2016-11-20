package me.app.sportigov4;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public static MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar = (Toolbar)findViewById(R.id.toolBar);
        //setSupportActionBar(toolbar);

        activity = this;//
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        EventFeedFragment frag1 = new EventFeedFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("layoutId", 1);
        frag1.setArguments(bundle1);

        EventFeedFragment frag2 = new EventFeedFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("layoutId", 2);
        frag2.setArguments(bundle2);

        EventFeedFragment frag3 = new EventFeedFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("layoutId", 3);
        frag3.setArguments(bundle3);

        viewPagerAdapter.addFragments(frag1, "LIVE VIEW");
        viewPagerAdapter.addFragments(frag2, "LIST VIEW");
        viewPagerAdapter.addFragments(frag3, "MY VIEW");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


       FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PostEvent.class));//change
            }
        });

        ImageButton prof = (ImageButton)findViewById(R.id.profPicBtn);
        prof.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, viewProfileActivity.class));
            }
        });

    }

    public static void goToEventPage(long eventID) {
        Intent intent = new Intent(MainActivity.activity, EventActivity.class);
        intent.putExtra("id", eventID);
        MainActivity.activity.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
