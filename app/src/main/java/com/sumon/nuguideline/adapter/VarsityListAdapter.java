package com.sumon.nuguideline.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sumon.nuguideline.R;
import com.sumon.nuguideline.activity.BrowserActivity;
import com.sumon.nuguideline.model.VarsityList;

import java.util.ArrayList;

/**
 * Created by sumon on 5/10/2018.
 */

public class VarsityListAdapter extends RecyclerView.Adapter<VarsityListAdapter.Myholder> {
    ArrayList<VarsityList> dataModelArrayList;
    Context context;

    public VarsityListAdapter(Context context, ArrayList<VarsityList> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
        this.context = context;
    }

    class Myholder extends RecyclerView.ViewHolder{
        TextView varsityName;
        ImageView varsityLogo;

        public Myholder(View itemView) {
            super(itemView);

            varsityName = (TextView) itemView.findViewById(R.id.tv_varsity_name);
            varsityLogo = itemView.findViewById(R.id.iv_varsity_logo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, BrowserActivity.class);
                    intent.putExtra("itemPosition", getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.varsity_list_item,null);
        return new Myholder(view);

    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        VarsityList dataModel=dataModelArrayList.get(position);
        holder.varsityName.setText(dataModel.getVarsityName());

        // loading album cover using Glide library
        Glide.with(context).load(dataModel.getLogoId()).into(holder.varsityLogo);

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }
}