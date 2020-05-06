package com.example.mygym101.ui.foodInfo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.mygym101.R;

public class FoodInfoFragment extends Fragment {

    private FoodInfoViewModel foodInfoViewModel;

    private EditText etKeyWords;
    private Button btnSearchFood;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        foodInfoViewModel =
                ViewModelProviders.of(this).get(FoodInfoViewModel.class);

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);




        foodInfoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etKeyWords = view.findViewById(R.id.et_enterFood);
        btnSearchFood = view.findViewById(R.id.btn_searchFood);

        btnSearchFood.setOnClickListener(v -> {
            String keyWords = etKeyWords.getText().toString();
            String url = "https://www.calorieking.com/gb/en/foods/search?keywords="  + keyWords;

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            getActivity().startActivity(intent);

        });

    }
}