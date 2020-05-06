package com.example.mygym101.ui.my_workout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygym101.R;
import com.example.mygym101.model.Exercises;

import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>{

    List<Exercises> exercises;
    FragmentManager fragmentManager;

    public WorkoutAdapter(List<Exercises> exercises, FragmentManager fragmentManager) {
        this.exercises = exercises;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WorkoutViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.workouts_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        //2) what to put in the views
        Exercises e = exercises.get(position);
        holder.textView.setText(e.getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ////Intent
                //WebView in a dialog()
                //exoPlayer
                //MediaPlayer
            }
        });


    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        Button videoBtn;
        // 1) add more views

        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_workouts_title);
            videoBtn = itemView.findViewById(R.id.button_video_click);


            videoBtn.setOnClickListener(view -> {

                VideoDialog.newInstance(exercises.get(getAdapterPosition()).getVideo()).show(fragmentManager,"videoDialog");
            });

            itemView.setOnClickListener(v -> {
                Exercises e = exercises.get(getAdapterPosition());



                Toast.makeText(itemView.getContext(), e.getName() , Toast.LENGTH_SHORT).show();

            });
        }
    }

}
