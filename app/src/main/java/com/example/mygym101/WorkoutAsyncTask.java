package com.example.mygym101;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.example.mygym101.model.ExerciseData;
import com.example.mygym101.model.ExerciseDays;
import com.example.mygym101.model.ExercisePlan;
import com.example.mygym101.model.ExerciseRoot;
import com.example.mygym101.model.Exercises;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class WorkoutAsyncTask extends AsyncTask<Void,Void,ExerciseRoot> {

    private MutableLiveData<ExerciseRoot> mutableLiveData;

    public WorkoutAsyncTask(MutableLiveData<ExerciseRoot> mutableLiveData) {
        this.mutableLiveData = mutableLiveData;
    }

    @Override
    protected ExerciseRoot doInBackground(Void... voids) {


        try {
            URL feedURL = new URL("https://raw.githubusercontent.com/julianshapiro/julian.com/master/muscle/workout.json");
            HttpsURLConnection con = (HttpsURLConnection) feedURL.openConnection();
            //binary input stream:
            InputStream in = con.getInputStream();
            StringBuilder sb = new StringBuilder();

            //wrap the binary inputStream with a reader:
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            //the stringBuilder is full:
            String json = sb.toString();



            ArrayList<Exercises> exercisesArrayList = new ArrayList<>();

            JSONObject obj = new JSONObject(json);

            JSONArray resultsArray = obj.getJSONArray("exercises");

            ArrayList<ExercisePlan> planArrayList = new ArrayList<>();

            //fill the list:
            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject exerxiseObject = resultsArray.getJSONObject(i);
                int id = exerxiseObject.getInt("id");
                String name = exerxiseObject.getString("name");
                String video = exerxiseObject.getString("video");

                Exercises ex = new Exercises(id,name,video);

                exercisesArrayList.add(ex);
            }


            JSONArray plans = obj.getJSONArray("plans");

            for (int i = 0; i < plans.length(); i++) {

                JSONObject planeAObj = (JSONObject) plans.get(i);
                int id = planeAObj.getInt("id");
                String name = planeAObj.getString("name");


                JSONArray days = planeAObj.getJSONArray("days");

                ArrayList<ExerciseDays> daysArrayList = new ArrayList<>();

                for (int j = 0; j < days.length(); j++) {
                    JSONObject daysObject = (JSONObject) days.get(j);
                    int dayId = daysObject.getInt("id");
                    String dayName = daysObject.getString("name");
                    JSONArray exercise  = daysObject.getJSONArray("exercises");

                    ArrayList<ExerciseData> exerciseDataArrayList = new ArrayList<>();


                    for (int k = 0; k < exercise.length(); k++) {
                        JSONObject exercisesObj = (JSONObject) exercise.get(k);
                        int exercisesId = exercisesObj.getInt("id");
                        int exercisesWeight = exercisesObj.getInt("weight");
                        int exercisesSets = exercisesObj.getInt("sets");
                        String exercisesUnit = exercisesObj.getString("unit");

                        ExerciseData exerciseData = new ExerciseData(exercisesId, exercisesWeight, exercisesSets, exercisesUnit);
                        exerciseDataArrayList.add(exerciseData);
                    }

                    ExerciseDays exerciseDays = new ExerciseDays(dayId,dayName,exerciseDataArrayList);
                    daysArrayList.add(exerciseDays);

                }

                ExercisePlan exercisePlan = new ExercisePlan(id,name,daysArrayList);
                planArrayList.add(exercisePlan);


            }


            ExerciseRoot exerciseRoot = new ExerciseRoot(exercisesArrayList,planArrayList);

            return exerciseRoot;
        } catch (IOException e) { System.out.println("e1 " + e);
        } catch (JSONException e) {
           e.printStackTrace();
        }
        //code that runs in the background:
        return null;
    }
    //doInBackground: fetch JSon{Threads}
    //onPostExecute (update UI)

    @Override
    protected void onPostExecute(ExerciseRoot exerciseRoot) {
        super.onPostExecute(exerciseRoot);
        mutableLiveData.setValue(exerciseRoot);

    }
}
