package com.parthapp.statsforclashofclans.fragments;

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
import com.parthapp.statsforclashofclans.R;
import com.parthapp.statsforclashofclans.models.Player;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        TextView action_username = view.findViewById(R.id.action_username);
        TextView action_level = view.findViewById(R.id.action_level);
        TextView action_clan = view.findViewById(R.id.action_clan);
        ImageView action_clan_badge = view.findViewById(R.id.action_clan_badge);
        ImageView action_player_league = view.findViewById(R.id.action_player_league);
        TextView action_trophies = view.findViewById(R.id.action_trophies);
        TextView action_league_lvl = view.findViewById(R.id.action_league_lvl);
        TextView action_thlevel = view.findViewById(R.id.action_thlevel);
        TextView action_trophies_builder = view.findViewById(R.id.action_trophies_builder);
        TextView action_versus_battles = view.findViewById(R.id.action_versus_battles);
        TextView action_bhlevel = view.findViewById(R.id.action_bhlevel);
        TextView action_user_id = view.findViewById(R.id.action_user_id);
        TextView action_clan_stat = view.findViewById(R.id.action_clan_stat);

        /*
        Converting string to a player class using gson by google.
         */
        Player player = gson.fromJson(userTag, Player.class);
        /*
        Getting data from the player object and using what's needed
         */
        String playerName = player.getName();
        String playerClan = player.getClan().getName();
        String clanIcon = player.getClan().getBadgeUrl().getMedium();
        String leagueIcon = player.getLeague().getIconUrls().getMedium();
        Integer playerLevel = player.getExpLevel();
        Integer playerTrophies = player.getTrophies();
        String playerLeagueLevel = player.getLeague().getName();
        Integer playerTownhallLevel = player.getTownHallLevel();
        Integer playerBuilderHallTrophies = player.getBuilderBaseTrophies();
        Integer playerBuilderHallLevel = player.getBuilderHallLevel();
        Integer playerBuilderBattleWon = player.getBuilderBaseWinCount();
        String playerID = player.getTag();
        String clanStat = player.getRole();

        /*
        Assigning fields
         */
        Picasso.with(getContext()).load(leagueIcon).into(action_player_league);
        action_username.setText(playerName);
        action_level.setText(String.valueOf(playerLevel));
        Picasso.with(getContext()).load(clanIcon).into(action_clan_badge);
        action_clan.setText(playerClan);
        action_trophies.setText(String.format("Trophies: %s", String.valueOf(playerTrophies)));
        action_league_lvl.setText(playerLeagueLevel);
        action_thlevel.setText(String.format("Townhall Level: %s",String.valueOf(playerTownhallLevel)));
        action_trophies_builder.setText(String.format("Trophies: %s",String.valueOf(playerBuilderHallTrophies)));
        action_versus_battles.setText(String.format("Battle Won: %s", String.valueOf(playerBuilderBattleWon)));
        action_bhlevel.setText(String.format("Builder Hall Level: %s", String.valueOf(playerBuilderHallLevel)));
        action_user_id.setText(playerID);
        action_clan_stat.setText(getClanStat(clanStat));

        /*
        Logging to make sure variables print whats intended
         */
        Log.i(TAG, TAG+": " + playerName);
    }

    private String getClanStat(String clanStat) {
        switch (clanStat){
            case "coLeader":
                return "Co-Leader";
            case "admin":
                return "Elder";
            case "member":
                return "Member";
        }
        return "";
    }
}