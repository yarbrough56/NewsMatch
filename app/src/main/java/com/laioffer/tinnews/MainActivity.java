package com.laioffer.tinnews;
//package com.laioffer.tinnews;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//import com.laioffer.tinnews.common.TinBasicActivity;
//
//public class MainActivity extends TinBasicActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//
//    @Override
//    protected int getLayout() {
//        return R.layout.activity_main;
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
//
//    @Override
//    public void showSnackBar(String message) {
//
//    }
//}

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.laioffer.tinnews.common.ContainerFragment;
import com.laioffer.tinnews.common.TinBasicActivity;
import com.laioffer.tinnews.common.TinBasicFragment;

public class MainActivity extends TinBasicActivity {
    private ViewPager viewPager;
    private BottomNavigationView bottomBar;
    private TinFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager = findViewById(R.id.viewpager);
        adapter = new TinFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // maintian three on resume at the same time
        viewPager.setOffscreenPageLimit(TinFragmentPagerAdapter.FRAGMENT_NUMBER);

//        viewPager.setOffscreenPageLimit(adapter.getLimit());

        //add bottombar code from here
        bottomBar = findViewById(R.id.bottom_navigation);
        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                viewPager.setCurrentItem(ContainerFragment.getPositionById(item.getItemId()));
                return true;
            }
        });

    }

    //add to the mainActivity
    private FragmentManager getCurrentChildFragmentManager() {
        return adapter.getItem(viewPager.getCurrentItem()).getChildFragmentManager();
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void doFragmentTransaction(TinBasicFragment basicFragment) {
        FragmentTransaction fragmentTransaction = getCurrentChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(
                R.id.child_fragment_container,
                basicFragment,
                basicFragment.getFragmentTag()).addToBackStack(null).commit();
    }


    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getCurrentChildFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void showSnackBar(String message) {

    }
}