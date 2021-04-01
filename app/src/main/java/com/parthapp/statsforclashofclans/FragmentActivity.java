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
import com.google.gson.Gson;
import com.parthapp.statsforclashofclans.fragments.AchievementFragment;
import com.parthapp.statsforclashofclans.fragments.ProfileFragment;
import com.parthapp.statsforclashofclans.fragments.TroopsFragment;
import com.parthapp.statsforclashofclans.models.Player;
import com.parthapp.statsforclashofclans.models.Troop;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import okhttp3.Response;

public class FragmentActivity extends AppCompatActivity {
    private static final String TAG = "FragmentActivity";
    private static Response resData;
    private final Bundle bundle = new Bundle();

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        /*
        Fetch the userTag from the Main Activity
        */
        Bundle extras = getIntent().getExtras();
        String userTag = extras.getString("userTag");
        Log.i(TAG, "HERE IN FRAG ACT: " + userTag);

        /*
        Make an API Call from the fragment Activity
        */
        ClashAdapter clash = new ClashAdapter(BuildConfig.CLASH_API);
        try {
            resData = clash.makeThreadAPICall(getGamerTag(userTag), "players/");
            try {
                bundle.putString("resData", Objects.requireNonNull(resData.body()).string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_troops:
                        fragment = new TroopsFragment();
                        break;
                    case R.id.action_achieve:
                        fragment = new AchievementFragment();
                        break;
                    case R.id.action_profile:
                    default:
                        fragment = new ProfileFragment();
                        break;
                }
                fragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
    }

    private String getGamerTag(String userTag) {
        if(userTag.equals("")) {
            Log.i(TAG, "Choosing Randomly");
            List<String> profileTag = new ArrayList<>();
            profileTag.add("#LP8C008UJ");
            profileTag.add("#PQJQYC9CQ");
            profileTag.add("#2JQ299028");
            Random getRand = new Random();
            return profileTag.get(getRand.nextInt(profileTag.size()));
        }
        else{
            return userTag;
        }
    }
}