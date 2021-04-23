package com.parthapp.statsforclashofclans.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.parthapp.statsforclashofclans.R;
import com.parthapp.statsforclashofclans.models.Player;
import com.parthapp.statsforclashofclans.models.Troop;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TroopsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TroopsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "Troops";
    private final Gson gson = new Gson();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TroopsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TroopsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TroopsFragment newInstance(String param1, String param2) {
        TroopsFragment fragment = new TroopsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();
        String resData = "";
        if(bundle != null) {
             resData = bundle.getString("resData");
        }
        /*
            Getting the data from the json object and converting it to a Player Object
         */
        Player player = gson.fromJson(resData, Player.class);

        /*
            @heroes: List of heroes and their levels
            @spells: List of spells and their levels
            @troops: List of troops and their levels
         */
        List<Troop> heroes = player.getHeroes();
        List<Troop> spells = player.getSpells();
        List<Troop> troops = player.getTroops();

        /*
            START OF DEBUG
         */

        for(Troop hero: heroes){
            if(hero.getVillage().equals("builderBase")){
                continue;
            }
            Log.i(TAG, hero.getName() + " " + hero.getLevel());
        }
        for(Troop spell: spells){
            if(spell.getVillage().equals("builderBase")){
                continue;
            }
            Log.i(TAG, spell.getName() + " " + spell.getLevel());
        }
        for(Troop troop: troops){
            if(troop.getVillage().equals("builderBase")){
                continue;
            }
            Log.i(TAG, troop.getName() + " " + troop.getLevel());
        }

        /*
            END OF DEBUG
         */


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_troops, container, false);
    }
}