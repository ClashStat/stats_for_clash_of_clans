package com.parthapp.statsforclashofclans.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.parthapp.statsforclashofclans.Achievements_Adapter;
import com.parthapp.statsforclashofclans.R;
import com.parthapp.statsforclashofclans.models.Achievement;
import com.parthapp.statsforclashofclans.models.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AchievementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AchievementFragment extends Fragment {

    public class TimelineActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_timeline);
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "Achievement";
    private final Gson gson = new Gson();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView rvAchievements;
    Achievements_Adapter adapter;
    List <Achievement> ach;

    public AchievementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AchievementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AchievementFragment newInstance(String param1, String param2) {
        AchievementFragment fragment = new AchievementFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_timeline, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();

        // find the recycler view
        rvAchievements = view.findViewById(R.id.rvAchievements);
        // init the list of achievements and adapter
        ach = new ArrayList<>();
        adapter = new Achievements_Adapter(getContext(),ach);
        // recycler view setup: layout manager and adapter
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        rvAchievements.setLayoutManager(lm);
        rvAchievements.setAdapter(adapter);
        populate(bundle);
    }
    public void populate(Bundle bundle){
        String userTag = bundle.getString("resData");
        Player player = gson.fromJson(userTag, Player.class);
        String playerName = player.getName();

        Log.i(TAG, "Achievement!!!!!!!!!!!!!" + playerName);
        List<Achievement> achievements = player.getAchievements();
        for(Achievement a: achievements){
            Log.i(TAG, a.getName());
        }
        // make the methods below
        adapter.clear();
        adapter.addAll(achievements);
    }
}

