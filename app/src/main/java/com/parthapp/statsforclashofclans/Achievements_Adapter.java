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

import java.util.List;

public class Achievements_Adapter extends RecyclerView.Adapter<Achievements_Adapter.ViewHolder>{
    Context context;
        List <Achievement> achievements;
    public static final String TAG = "achievements_adapter";

    public Achievements_Adapter(Context context, List<Achievement> achievements) {
        this.context = context;
        this.achievements = achievements;
        for(Achievement a: achievements){
            Log.i(TAG, a.getName());
        }
    }

    //for each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_achievement, parent, false);
        return new ViewHolder(view);
    }

    //Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the data at position
        Achievement ach = achievements.get(position);
        //bind the tweet with the view holder
        holder.bind(ach);
    }
    public void clear(){
        achievements.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Achievement> a){
        achievements.addAll(a);
        notifyDataSetChanged();
    }
    //pass in the context and list of achievements
    @Override
    public int getItemCount() {
        return achievements.size();
    }

    //Define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView achievement_body;
        TextView tvScore;
        RatingBar ratingBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            achievement_body = itemView.findViewById(R.id.achievement_body);
            tvScore = itemView.findViewById(R.id.tvScore);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        public void bind(Achievement ach) {
            achievement_body.setText(ach.getName());
            tvScore.setText(ach.getValue()+"/"+ach.getTarget());
            ratingBar.setRating(ach.getStars());
        }
    }
}
