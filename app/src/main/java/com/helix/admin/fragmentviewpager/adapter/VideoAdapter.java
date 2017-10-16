package com.helix.admin.fragmentviewpager.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.helix.admin.fragmentviewpager.R;
import com.helix.admin.fragmentviewpager.retrofitdemo.model.Video;

import java.util.ArrayList;

/**
 * Created by linh6_000 on 10/08/2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
  private ArrayList<Video> list = new ArrayList<>();

  public VideoAdapter(ArrayList<Video> list) {
    this.list = list;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.mTextView.setText(list.get(position).getId());
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView;

    public MyViewHolder(View itemView) {
      super(itemView);
      mTextView = itemView.findViewById(R.id.idVideo);
    }
  }
}
