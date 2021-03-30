package com.parthapp.statsforclashofclans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parthapp.statsforclashofclans.fragments.AchievementFragment;
import com.parthapp.statsforclashofclans.fragments.ProfileFragment;
import com.parthapp.statsforclashofclans.fragments.TroopsFragment;

public class FragmentActivity extends AppCompatActivity {
    private static final String TAG = "FragmentActivity";

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Bundle extras = getIntent().getExtras();
        String userTag = extras.getString("userTag");
        Log.i(TAG, "HERE IN FRAG ACT: " + userTag);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_troops:
//                        Toast.makeText(FragmentActivity.this, "Troops", Toast.LENGTH_SHORT).show();
                        fragment = new TroopsFragment();
                        break;
                    case R.id.action_achieve:
//                        Toast.makeText(FragmentActivity.this, "Achievements", Toast.LENGTH_SHORT).show();
                        fragment = new AchievementFragment();
                        break;
                    case R.id.action_profile:
                    default:
//                        Toast.makeText(FragmentActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        fragment = new ProfileFragment();
                        break;
                }
                Bundle bundle = new Bundle();
                bundle.putString("userTag", userTag);
                fragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
    }
}