package com.example.mygym101.ui.my_workout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mygym101.WorkoutAsyncTask;
import com.example.mygym101.model.ExerciseRoot;

public class MyWorkoutsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<ExerciseRoot> mRoot;

    public MyWorkoutsViewModel() {
        mText = new MutableLiveData<>();
        mRoot = new MutableLiveData<>();
        mText.setValue("This is My Workout fragment");

        WorkoutAsyncTask workoutAsync = new WorkoutAsyncTask(mRoot);
        workoutAsync.execute();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<ExerciseRoot> getmRoot() {
        return mRoot;
    }
}