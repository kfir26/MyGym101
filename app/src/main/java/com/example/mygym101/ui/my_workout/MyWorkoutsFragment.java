package com.example.mygym101.ui.my_workout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygym101.R;
import com.example.mygym101.WorkoutAsyncTask;
import com.example.mygym101.model.ExerciseRoot;

import java.util.ArrayList;

public class MyWorkoutsFragment extends Fragment {

    private MyWorkoutsViewModel myWorkoutsViewModel;
    private RecyclerView recyclerView;




    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        myWorkoutsViewModel =
                ViewModelProviders.of(this).get(MyWorkoutsViewModel.class);

        new WorkoutAsyncTask(myWorkoutsViewModel.getmRoot()).execute();


        View root = inflater.inflate(R.layout.fragment_my_workout, container, false);
        recyclerView = root.findViewById(R.id.my_workout_recycler);





        myWorkoutsViewModel.getmRoot().observe(getActivity(), new Observer<ExerciseRoot>() {
            @Override
            public void onChanged(ExerciseRoot exerciseRoot) {

                WorkoutAdapter adapter = new WorkoutAdapter(exerciseRoot.getExercises(), getChildFragmentManager());

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                recyclerView.setAdapter(adapter);

            }
        });
        return root;
    }
}