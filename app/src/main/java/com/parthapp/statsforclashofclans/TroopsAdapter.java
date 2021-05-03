package com.parthapp.statsforclashofclans;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parthapp.statsforclashofclans.models.Achievement;
import com.parthapp.statsforclashofclans.models.Troop;

import java.util.List;

public class TroopsAdapter extends RecyclerView.Adapter<TroopsAdapter.ViewHolder>{
    Context context;
    List<Troop> troop;
    public static final String TAG = "troops_adapter";


    public TroopsAdapter(Context context, List<Troop> troops) {
        this.context = context;
        this.troop = troops;
        for(Troop t: troops){
            Log.i(TAG, t.getName());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_heroes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the data at position
        Troop troops = troop.get(position);
        //bind the tweet with the view holder
        holder.bind(troops);
    }

    public void clear(){
        troop.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Troop> a){
        troop.addAll(a);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return troop.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView action_heroicon;
        TextView action_heroname;
        TextView action_hero_level;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            action_heroicon = itemView.findViewById(R.id.action_heroicon);
            action_heroname = itemView.findViewById(R.id.action_heroname);
            action_hero_level = itemView.findViewById(R.id.action_hero_level);
        }
        public void bind(Troop troops) {
            //action_heroicon.setText(troops.);
            action_heroname.setText(troops.getName());
            action_hero_level.setText(troops.getLevel());
        }
    }
}
