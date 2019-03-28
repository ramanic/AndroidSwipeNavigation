/**
 * Ramanic Code !!!
 */
package com.ramanic.swipenavfrag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        final BottomNavigationView navigation = findViewById(R.id.navigation);


        navigation.setOnNavigationItemSelectedListener(this);
        findViewById(R.id.fragment_container).setOnTouchListener(new OnSwipeTouchListener(this) {

            public void onSwipeRight() {
                switch (getCheckedItem(navigation))
                {
                    case 0 :
                        loadFragment(new HelpFragment());
                        navigation.getMenu().getItem(3).setChecked(true);
                        break;

                    case 1:
                        loadFragment(new HomeFragment());
                        navigation.getMenu().getItem(0).setChecked(true);
                        break;

                    case 2:
                        loadFragment(new MiscFragment());
                        navigation.getMenu().getItem(1).setChecked(true);
                        break;

                    case 3:
                        loadFragment(new SettingFragment());
                        navigation.getMenu().getItem(2).setChecked(true);
                        break;

                };

            }
            public void onSwipeLeft() {
                switch (getCheckedItem(navigation))
                {
                    case 0 :
                        loadFragment(new MiscFragment());
                        navigation.getMenu().getItem(1).setChecked(true);
                        break;

                    case 1:
                        loadFragment(new SettingFragment());
                        navigation.getMenu().getItem(2).setChecked(true);
                        break;

                    case 2:
                        loadFragment(new HelpFragment());
                        navigation.getMenu().getItem(3).setChecked(true);
                        break;
                    case 3:
                        loadFragment(new HomeFragment());
                        navigation.getMenu().getItem(0).setChecked(true);
                        break;

                };

            }


        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_dashboard:
                fragment = new MiscFragment();
                break;

            case R.id.navigation_notifications:
                fragment = new SettingFragment();
                break;

            case R.id.navigation_profile:
                fragment = new HelpFragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    private int getCheckedItem(BottomNavigationView navigationView) {
        Menu menu = navigationView.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.isChecked()) {
                return i;
            }
        }

        return -1;
    }
}
