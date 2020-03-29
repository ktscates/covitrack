package rw.awesomity.covi_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import rw.awesomity.covi_tracker.Fragment.HomeFragment;
import rw.awesomity.covi_tracker.Fragment.NewCaseFragment;
import rw.awesomity.covi_tracker.Fragment.SearchFragment;
import rw.awesomity.covi_tracker.Fragment.StatFragment;
import rw.awesomity.covi_tracker.Fragment.TipFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;

                    case R.id.nav_new_cases:
                        selectedFragment = new NewCaseFragment();
                        break;

                    case R.id.nav_search:
                        selectedFragment = new SearchFragment();
                        break;

                    case R.id.nav_tips:
                        selectedFragment = new TipFragment();
                        break;

                    case R.id.nav_stats:
                        selectedFragment = new StatFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();

                return true;
            }
        };
}
