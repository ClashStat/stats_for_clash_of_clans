package com.parthapp.statsforclashofclans;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parthapp.statsforclashofclans.models.Troop;

import java.util.List;

public class TroopsAdapter extends RecyclerView.Adapter<TroopsAdapter.ViewHolder>{
    Context context;
    List<Troop> troops;
    public static final String TAG = "TroopsAdapter";

    public TroopsAdapter(Context context, List<Troop> troops) {
        this.context = context;
        this.troops = troops;
        for(Troop troop: troops){
            Log.i(TAG, troop.getName());
        }
    }

    //for each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_troops, parent, false);
        return new ViewHolder(view);
    }

    //Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the data at position
        Troop h = troops.get(position);
        //bind the tweet with the view holder
        holder.bind(h);
    }
    public void clear(){
        troops.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Troop> h){
        troops.addAll(h);
        notifyDataSetChanged();
    }
    //pass in the context and list of achievements
    @Override
    public int getItemCount() {
        return troops.size();
    }

    //Define a viewholder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView action_troop_name;
        TextView action_troop_level;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            action_troop_name = itemView.findViewById(R.id.action_troop_name);
            action_troop_level = itemView.findViewById(R.id.action_troop_level);
        }

        public void bind(Troop h) {
            action_troop_name.setText(h.getName());
            action_troop_level.setText(String.valueOf(h.getLevel()));
        }
    }
}