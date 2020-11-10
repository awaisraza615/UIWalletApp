package com.example.uidesignapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.android.material.tabs.TabLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int progress = 0;
    private ProgressBar progressBar;
    private Handler handler = new Handler();
    private SlidingUpPanelLayout slidingUpPanelLayout;
    private ImageView imageicon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageicon = (ImageView) findViewById(R.id.imgiconupdown);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText("Demo"));
        tabLayout.addTab(tabLayout.newTab().setText("Demo2"));

// Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
// Use PagerAdapter to manage page views in fragments.
// Each page is represented by its own fragment.
        final ViewPager viewPager = findViewById(R.id.viewPager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_refresh){

            /*progressBar = (ProgressBar)findViewById(R.id.spin_kit);
            Sprite doubleBounce = new DoubleBounce();
            progressBar.setIndeterminateDrawable(doubleBounce);
            progressBar.setVisibility(View.VISIBLE);
            setProgressValue(progress);*/

            Intent i = new Intent(MainActivity.this, MainActivity.class);
            finish();
            overridePendingTransition(0, 0);
            startActivity(i);
            overridePendingTransition(0, 0);

        }

        return super.onOptionsItemSelected(item);
    }



    /*private void setProgressValue(final int progress) {

        // set the progress
        progressBar.setProgress(progress);
        // thread is used to change the progress value
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 10);
            }
        });
        thread.start();
    }*/
}
