package com.example.mygym101.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.mygym101.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FloatingActionButton fab_facebook;
    private FloatingActionButton fab_instagram;
    private FloatingActionButton fab_call_us;
    private FloatingActionButton fab_waze;
    private FloatingActionButton fabBmi;
    private FloatingActionButton fabBmr;
    private FloatingActionButton fabProtein;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab_facebook = view.findViewById(R.id.fab_facebook);
        fab_waze = view.findViewById(R.id.fab_waze);
        fab_call_us = view.findViewById(R.id.fab_call_us);
        fab_instagram = view.findViewById(R.id.fab_instagram);
        fabBmi = view.findViewById(R.id.fab_BMI);
        fabBmr = view.findViewById(R.id.fab_BMR);
        fabProtein = view.findViewById(R.id.fab_pritein_calculator);


        /*
        pageNum of MyGym101 on facebook is: --> 110029480693913
         */
        fab_facebook.setOnClickListener(v -> {
            String url = "https://www.facebook.com/110029480693913";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //
            getActivity().startActivity(intent);
        });


        fabProtein.setOnClickListener(v -> {
            String url = "https://www.calculator.net/protein-calculator.html";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //
            getActivity().startActivity(intent);

        });


        fab_waze.setOnClickListener(v -> {
            String url = "https://waze.com/ul?q=MyGym";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //
            getActivity().startActivity(intent);

        });

        fab_call_us.setOnClickListener(v -> {
            Uri telUri = Uri.parse("tel:0500000000");
            Intent dialIntent = new Intent(Intent.ACTION_DIAL, telUri);

            startActivity(dialIntent);
        });



        fab_instagram.setOnClickListener(v->{
            String url = "https://www.instagram.com";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            //
            getActivity().startActivity(intent);
        });


        fabBmi.setOnClickListener(v->{
            String url = "https://www.calculator.net/bmi-calculator.html?ctype=metric&cage=28&csex=m&cheightfeet=5&cheightinch=10&cpound=160&cheightmeter=189&ckg=100&printit=0&x=86&y=13";
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));

            getActivity().startActivity(intent);

        });


        fabBmr.setOnClickListener(v->{
            String url = "https://www.calculator.net/bmr-calculator.html?ctype=metric&cage=29&csex=m&cheightfeet=5&cheightinch=10&cpound=160&cheightmeter=189&ckg=97&cmop=0&coutunit=c&cformula=m&cfatpct=20&x=75&y=17";
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));

            getActivity().startActivity(intent);

        });


    }

}

