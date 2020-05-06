package com.example.mygym101.ui.my_workout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.mygym101.R;

public class VideoDialog extends AppCompatDialogFragment {


    public static VideoDialog newInstance(String videoUrl) {

        Bundle args = new Bundle();

        args.putString("videoUrl", videoUrl);

        VideoDialog fragment = new VideoDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.workout_webview_video_items,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WebView webView = view.findViewById(R.id.webView);

        //set javaScript and display the video by clicking it:
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());



        Bundle arguments = getArguments();

        webView.loadUrl(arguments.getString("videoUrl"));




    }
}
