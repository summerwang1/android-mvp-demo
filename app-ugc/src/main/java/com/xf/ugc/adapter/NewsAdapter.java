package com.xf.ugc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xf.ugc.R;
import com.xf.ugc.business.mode.bean.UserVo;

import java.util.List;

/**
 * @author Mr.Wang
 * @version 1.0
 * @time 2016/8/30-10:54
 * @describe
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private Context context;
    private List<UserVo.ResultEntity> mResultEntity;
    public NewsAdapter(Context context,List<UserVo.ResultEntity> mResultEntity)
    {
        this.context = context;
        this.mResultEntity = mResultEntity;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        NewsViewHolder newsViewHolder = new NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false));
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.tv_id.setText("" + mResultEntity.get(position).Id);
        holder.tv_name.setText(mResultEntity.get(position).KeyWord);


    }

    @Override
    public int getItemCount() {
        return mResultEntity == null ? 0:mResultEntity.size();
    }
}

class NewsViewHolder extends RecyclerView.ViewHolder{

    public TextView tv_id;
    public TextView tv_name;
    public NewsViewHolder(View itemView) {
        super(itemView);

        tv_id = (TextView) itemView.findViewById(R.id.news_id);
        tv_name = (TextView) itemView.findViewById(R.id.news_text);

    }
}

