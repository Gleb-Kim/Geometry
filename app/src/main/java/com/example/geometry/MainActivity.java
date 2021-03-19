package com.example.geometry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.menu);
        navigation.setSelectedItemId(R.id.navigation_theory);
        loadFragment(new Theory());
        setTitle("Theory");
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_settings:
                        loadFragment(new Settings());
                        setTitle("Setting");
                        return true;
                    case R.id.navigation_theory:
                        loadFragment(new Theory());
                        setTitle("Theory");
                        return true;
                    case R.id.navigation_calculate:
                        loadFragment(new Calculator());
                        setTitle("Calculator");
                        return true;
                }
                return false;
            }
        });
    }
    public void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, fragment);
        ft.commit();
    }

}