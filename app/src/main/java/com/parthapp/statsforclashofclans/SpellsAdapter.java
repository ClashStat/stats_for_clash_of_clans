package com.parthapp.statsforclashofclans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parthapp.statsforclashofclans.models.Troop;

import java.util.List;

public class SpellsAdapter extends RecyclerView.Adapter<SpellsAdapter.ViewHolder>{
    Context context;
    List<Troop> spells;
    public static final String TAG = "achievements_adapter";

    public SpellsAdapter(Context context, List<Troop> spells) {
        this.context = context;
        this.spells = spells;
    }

    //for each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_spells, parent, false);
        return new ViewHolder(view);
    }

    //Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the data at position
        Troop h = spells.get(position);
        //bind the tweet with the view holder
        holder.bind(h);
    }
    public void clear(){
        spells.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Troop> h){
        spells.addAll(h);
        notifyDataSetChanged();
    }
    //pass in the context and list of achievements
    @Override
    public int getItemCount() {
        return spells.size();
    }

    //Define a viewholder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView action_spells_name;
        TextView action_spells_level;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            action_spells_name = itemView.findViewById(R.id.action_spells_name);
            action_spells_level = itemView.findViewById(R.id.action_spells_level);
        }

        public void bind(Troop h) {
            action_spells_name.setText(h.getName());
            action_spells_level.setText(String.valueOf(h.getLevel()));
        }
    }
}
