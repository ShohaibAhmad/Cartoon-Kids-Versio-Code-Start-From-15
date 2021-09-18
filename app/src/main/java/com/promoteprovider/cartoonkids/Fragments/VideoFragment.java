package com.promoteprovider.cartoonkids.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.promoteprovider.cartoonkids.R;


public class VideoFragment extends Fragment {

String videoUrl;

    public VideoFragment() {
        // Required empty public constructor
    }

    public VideoFragment(String videoUrl) {
      this.videoUrl=videoUrl;
    }

    YouTubePlayerView youTubePlayerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
//        WebView webView = view.findViewById(R.id.webView);
//        webView.loadUrl(videoUrl);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.setWebViewClient(new WebViewClient());
//        //improve webView performance
//        WebSettings webSettings = webView.getSettings();
//        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
//        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        webView.getSettings().setAppCacheEnabled(true);
//        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        webSettings.setUseWideViewPort(true);
//        webSettings.setSavePassword(true);
//        webSettings.setSaveFormData(true);
//        webSettings.setEnableSmoothTransition(true);

        youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                String videoId = "eG-Fre0G8OE";

                youTubePlayer.loadVideo(videoUrl, 0);
            }
        });


        return view;
    }
    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout,new VideoFragment())
                .addToBackStack(null).commit();
    }
}