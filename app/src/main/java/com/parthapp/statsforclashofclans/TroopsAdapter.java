package com.parthapp.statsforclashofclans;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parthapp.statsforclashofclans.models.Achievement;
import com.parthapp.statsforclashofclans.models.Troop;

import java.util.List;

public class TroopsAdapter extends RecyclerView.Adapter<TroopsAdapter.ViewHolder>{
    Context context;
    List<Troop> heroes;
    public static final String TAG = "achievements_adapter";

    public TroopsAdapter(Context context, List<Troop> heroes) {
        this.context = context;
        this.heroes = heroes;
    }

    //for each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_heroes, parent, false);
        return new ViewHolder(view);
    }

    //Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the data at position
        Troop h = heroes.get(position);
        //bind the tweet with the view holder
        holder.bind(h);
    }
    public void clear(){
        heroes.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Troop> h){
        heroes.addAll(h);
        notifyDataSetChanged();
    }
    //pass in the context and list of achievements
    @Override
    public int getItemCount() {
        return heroes.size();
    }

    //Define a viewholder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView action_hero_name;
        TextView action_hero_level;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            action_hero_name = itemView.findViewById(R.id.action_hero_name);
            action_hero_level = itemView.findViewById(R.id.action_hero_level);
        }

        public void bind(Troop h) {
            action_hero_name.setText(h.getName());
            action_hero_level.setText(String.valueOf(h.getLevel()));
        }
    }
}
