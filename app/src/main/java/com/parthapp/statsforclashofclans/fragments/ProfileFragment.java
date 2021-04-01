package com.parthapp.statsforclashofclans.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.parthapp.statsforclashofclans.BuildConfig;
import com.parthapp.statsforclashofclans.ClashAdapter;
import com.parthapp.statsforclashofclans.R;
import com.parthapp.statsforclashofclans.models.BadgeUrl;
import com.parthapp.statsforclashofclans.models.Clan;
import com.parthapp.statsforclashofclans.models.Player;
import com.parthapp.statsforclashofclans.models.Troop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private TextView username;
    private TextView level;
    private TextView clan;
    private TextView clan_rank;
    private ImageView clan_badge_url;
    private TextView trophies;
    private TextView league_lvl;
    private TextView trophies_builder;
    private TextView versus_battles;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String  TAG = "Profile";
    private final Gson gson = new Gson();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();
        String userTag = "";
        if (bundle != null) {
            userTag = bundle.getString("resData");
        }

        /*
        Finding view by ID
         */
        username = view.findViewById(R.id.username);
        level = view.findViewById(R.id.level);
        clan = view.findViewById(R.id.clan);

        /*
        Converting string to a player class using gson by google.
         */
        Player player = gson.fromJson(userTag, Player.class);
        /*
        Getting data from the player object and using what's needed
         */
        String playerName = player.getName();
        String playerClan = player.getClan().getName();
        String clanURL = player.getClan().getBadgeUrl().getMedium();
        String leagueURL =  player.getLeague().getIconUrls().getMedium();
        Integer playerLevel = player.getExpLevel();

        /*
        Assigning fields
         */
        username.setText(playerName);
        level.setText(String.valueOf(playerLevel));
        clan.setText(playerClan);
        /*
        Logging to make sure variables print whats intended
         */
        Log.i(TAG,TAG + playerName);
        Log.i(TAG, TAG + ": " + leagueURL);
        Log.i(TAG, TAG+": "+ clanURL);
    }
}