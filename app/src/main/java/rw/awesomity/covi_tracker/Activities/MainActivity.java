package rw.awesomity.covi_tracker.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import rw.awesomity.covi_tracker.Fragments.HomeFragment;
import rw.awesomity.covi_tracker.Fragments.NewCaseFragment;
import rw.awesomity.covi_tracker.Fragments.SearchFragment;
import rw.awesomity.covi_tracker.Fragments.StatFragment;
import rw.awesomity.covi_tracker.Fragments.TipFragment;
import rw.awesomity.covi_tracker.R;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        loadFragment(new HomeFragment());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        loadFragment(selectedFragment);
                        break;

                    case R.id.nav_new_cases:
                        selectedFragment = new NewCaseFragment();
                        loadFragment(selectedFragment);
                        break;

                    case R.id.nav_search:
                        selectedFragment = new SearchFragment();
                        loadFragment(selectedFragment);
                        break;

                    case R.id.nav_tips:
                        selectedFragment = new TipFragment();
                        loadFragment(selectedFragment);
                        break;

                    case R.id.nav_stats:
                        selectedFragment = new StatFragment();
                        loadFragment(selectedFragment);
                        break;
                }

                return true;
            }
        };
        private void loadFragment(Fragment selectedFragment){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, selectedFragment);
            fragmentTransaction.commit();
    }

}
