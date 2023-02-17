package com.isetR.devinette;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList  title1,score,player_id;

    CustomAdapter(Context context, ArrayList player_id, ArrayList title1, ArrayList score ){

        this.context = context;
        this.title1 = title1;
        this.score = score;

    }


        @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.myrow, parent, false);
            return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title1.setText(String.valueOf(title1.get(position)));
        holder.score.setText(String.valueOf(score.get(position)));

    }

    @Override
    public int getItemCount() {
        return title1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title1,score,player_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title1=itemView.findViewById(R.id.title1);
            score=itemView.findViewById(R.id.score);
        }
    }
}


