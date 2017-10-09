package com.helix.admin.fragmentviewpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.helix.admin.fragmentviewpager.R;
import com.helix.admin.fragmentviewpager.retrofitdemo.model.Video;

import java.util.ArrayList;

/**
 * Created by linh6_000 on 10/08/2017.
 */

public class VideoAdapter extends BaseAdapter {
  private ArrayList<Video> list = new ArrayList<>();
  private LayoutInflater minflater;
  public Context mContext;

  public VideoAdapter(Context mContext, ArrayList<Video> list) {
    this.mContext = mContext;
    this.list = list;
    minflater = LayoutInflater.from(mContext);
  }

  @Override
  public int getCount() {
    return list.size();
  }

  @Override
  public Object getItem(int position) {
    return list.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View view, ViewGroup parent) {
    ViewHolder holder = null;
    if (view == null) {
      view = minflater.inflate(R.layout.item_video, parent, false);
      holder = new ViewHolder();
      holder.tvview = (TextView) view.findViewById(R.id.idVideo);
      view.setTag(holder);

    }
    holder = (ViewHolder) view.getTag();
    holder.tvview.setText(list.get(position).getId());
//    view.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Toast.makeText(mContext, list.get(position).getName(), Toast.LENGTH_SHORT).show();
//      }
//    });
    return view;
  }

  private class ViewHolder {
    TextView tvview;
  }
}
