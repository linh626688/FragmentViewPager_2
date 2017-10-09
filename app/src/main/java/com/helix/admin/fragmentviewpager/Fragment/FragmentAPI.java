package com.helix.admin.fragmentviewpager.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import com.helix.admin.fragmentviewpager.R;
import com.helix.admin.fragmentviewpager.adapter.VideoAdapter;
import com.helix.admin.fragmentviewpager.retrofitdemo.RetrofitHelper;
import com.helix.admin.fragmentviewpager.retrofitdemo.model.GoogleApiModel;
import com.helix.admin.fragmentviewpager.retrofitdemo.model.Video;

/**
 * Created by admin on 09/10/2017.
 */

public class FragmentAPI extends Fragment {
  private VideoAdapter videoAdapter;
  private ListView lv;
  private List<Video> lstVideo;

  public static FragmentAPI newInstance() {
    FragmentAPI fragmentAPI = new FragmentAPI();
    return fragmentAPI;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    final View view = inflater.inflate(R.layout.fragment_api, container, false);
    lv = view.findViewById(R.id.id_listVideo);
    videoAdapter = new VideoAdapter(getContext(), loadDataFromYoutube());
    lv.setAdapter(videoAdapter);
    return view;
  }

  public ArrayList<Video> loadDataFromYoutube() {
    RetrofitHelper.getVideo().enqueue(new Callback<GoogleApiModel>() {
      @Override
      public void onResponse(Call<GoogleApiModel> call, Response<GoogleApiModel> response) {
        GoogleApiModel googleApiModel = response.body();
        lstVideo = new ArrayList<Video>();
        lstVideo = googleApiModel != null ? googleApiModel.getVideos() : null;
//        String idVideo = googleApiModel.getVideos().get(0).getId();
        Log.d("@@GoogleApiModel", googleApiModel.toString());
      }

      @Override
      public void onFailure(Call<GoogleApiModel> call, Throwable t) {

      }
    });
    return (ArrayList<Video>) lstVideo;
  }
}
