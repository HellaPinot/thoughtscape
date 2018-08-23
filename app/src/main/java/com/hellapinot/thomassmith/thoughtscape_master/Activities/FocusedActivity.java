package com.hellapinot.thomassmith.thoughtscape_master.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import com.hellapinot.thomassmith.thoughtscape_master.Adapters.SectionsPagerAdapter;
import com.hellapinot.thomassmith.thoughtscape_master.CurrentStatus;
import com.hellapinot.thomassmith.thoughtscape_master.DataStructs.IdeaStruct;
import com.hellapinot.thomassmith.thoughtscape_master.R;

import java.util.ArrayList;


public class FocusedActivity extends BaseActivity{

    private static final String TAG = "FocusedActivity";
    private FloatingActionButton fab;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        fab.hide();

        mFocusedIdeas = createFocusedList();


        mSectionsPagerAdapter = new SectionsPagerAdapter( getSupportFragmentManager(), CurrentStatus.FOCUSED);
        mViewPager = findViewById(R.id.daily_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(mSectionsPagerAdapter.getCount());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        appStillOpen = false;

    }

    public ArrayList<IdeaStruct> createFocusedList(){
        ArrayList<IdeaStruct> temp = new ArrayList<>();
        for( int key = 0; key < mIdeas.size(); key++){
            for( int list = 0; list < mIdeas.get(key).size(); list++){
                if(mIdeas.get(key).get(list).isFocused()){
                    temp.add(mIdeas.get(key).get(list));
                }
            }
        }
        return temp;
    }

}

