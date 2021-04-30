package com.parthapp.statsforclashofclans.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.parthapp.statsforclashofclans.R;
import com.parthapp.statsforclashofclans.HeroesAdapter;
import com.parthapp.statsforclashofclans.SpellsAdapter;
import com.parthapp.statsforclashofclans.TroopsAdapter;
import com.parthapp.statsforclashofclans.models.Player;
import com.parthapp.statsforclashofclans.models.Troop;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TroopsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TroopsFragment extends Fragment {

    public class TimelineActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_troops);
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String TAG = "Troops";
    private final Gson gson = new Gson();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /*
    Heroes
    */
    RecyclerView rvHeroes;
    HeroesAdapter heroesAdapter;
    List<Troop> heroes;

    /*
    Spells
     */
    RecyclerView rvSpells;
    SpellsAdapter spellsAdapter;
    List<Troop> spells;

    /*
    Troops
     */
    RecyclerView rvTroops;
    TroopsAdapter troopsAdapter;
    List<Troop> troops;

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_troops, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();

        /*
        Heroes
        */
        rvHeroes = view.findViewById(R.id.rvHeroes);
        heroes  = new ArrayList<>();
        heroesAdapter = new HeroesAdapter(getContext(),heroes);
        LinearLayoutManager heroLM = new LinearLayoutManager(getContext());
        rvHeroes.setLayoutManager(heroLM);
        rvHeroes.setAdapter(heroesAdapter);


        /*
        Spells
        */
        rvSpells = view.findViewById(R.id.rvSpells);
        spells = new ArrayList<>();
        spellsAdapter = new SpellsAdapter(getContext(), spells);
        LinearLayoutManager spellLM = new LinearLayoutManager(getContext());
        rvSpells.setLayoutManager(spellLM);
        rvSpells.setAdapter(spellsAdapter);

        /*
        Troops
         */

        rvTroops = view.findViewById(R.id.rvTroops);
        troops = new ArrayList<>();
        troopsAdapter = new TroopsAdapter(getContext(), troops);
        LinearLayoutManager troopsLM = new LinearLayoutManager(getContext());
        rvTroops.setLayoutManager(troopsLM);
        rvTroops.setAdapter(troopsAdapter);


        populate(bundle);
    }

    private void populate(Bundle bundle) {
        String userTag = bundle.getString("resData");
        Player player = gson.fromJson(userTag, Player.class);
        /*
            @heroes: List of heroes and their levels
            @spells: List of spells and their levels
            @troops: List of troops and their levels
         */
        List<Troop> h = player.getHeroes();
        List<Troop> s = player.getSpells();
        List<Troop> t = player.getTroops();

        /*
        Heroes
        */
        heroesAdapter.clear();
        heroesAdapter.addAll(h);

        /*
        Spells
        */
        spellsAdapter.clear();
        spellsAdapter.addAll(s);

        /*
        Troops
         */
        troopsAdapter.clear();
        troopsAdapter.addAll(t);
    }


}