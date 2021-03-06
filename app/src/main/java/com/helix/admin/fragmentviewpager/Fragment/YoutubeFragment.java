package com.helix.admin.fragmentviewpager.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.helix.admin.fragmentviewpager.R;
import com.helix.admin.fragmentviewpager.retrofitdemo.RetrofitHelper;
import com.helix.admin.fragmentviewpager.retrofitdemo.model.GoogleApiModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 09/10/2017.
 */

public class YoutubeFragment extends Fragment {
    public static final String API_KEY = "AIzaSyD4Mb3dc6aVhbmES4WrMNfgtA4VV4ncGi4";
    public static final String VIDEO_ID = "8kqQCc96CZ8";
    public String idVideo;

    public static YoutubeFragment newInstance() {
        YoutubeFragment youtubeFragment = new YoutubeFragment();
        return youtubeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frament_youtube, container, false);
        RetrofitHelper.getVideo().enqueue(new Callback<GoogleApiModel>() {
            @Override
            public void onResponse(Call<GoogleApiModel> call, Response<GoogleApiModel> response) {
                GoogleApiModel googleApiModel = response.body();
                idVideo = googleApiModel.getVideos().get(0).getId();
                Log.d("idVideo", idVideo);
            }
            @Override
            public void onFailure(Call<GoogleApiModel> call, Throwable t) {
            }
        });
        YouTubePlayerSupportFragment youTubePlayer = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayer).commit();
        youTubePlayer.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                if (!wasRestored) {
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    youTubePlayer.loadVideo(idVideo);
                    youTubePlayer.play();
                }
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                String errorMessage = youTubeInitializationResult.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });
        return rootView;
    }
}


