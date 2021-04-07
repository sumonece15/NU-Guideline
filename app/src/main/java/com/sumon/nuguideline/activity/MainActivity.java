package com.sumon.nuguideline.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.sumon.nuguideline.R;
import com.sumon.nuguideline.adapter.SliderAdapter;
import com.sumon.nuguideline.fragment.NavigationDrawerFragment;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class MainActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private DrawerLayout mDrawerLayout;
    private static final int TIMER_DURATION = 3000;
    private ViewPager vpSlider;

    int images[] = {R.drawable.slide_4, R.drawable.slide_2, R.drawable.slide_3, R.drawable.slide_4, R.drawable.slide_5, R.drawable.slide_6, R.drawable.slider_7};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Main Menu");

        // Set up the drawer.

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.main_layout));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_layout);


        loadSlider();
    }

    private void loadSlider() {
        vpSlider = findViewById(R.id.vp_slider);
        final SliderAdapter swipeAdapter = new SliderAdapter(getApplicationContext(), images);
        vpSlider.setAdapter(swipeAdapter);
        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(vpSlider);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                int setPosition = vpSlider.getCurrentItem() + 1;
                if (setPosition == images.length) {
                    setPosition = 0;
                }
                vpSlider.setCurrentItem(setPosition, true);
                swipeAdapter.notifyDataSetChanged();
            }
        };

        //  Auto animated timer
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, TIMER_DURATION, TIMER_DURATION);

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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

    }



}
