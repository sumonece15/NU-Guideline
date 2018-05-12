package com.sumon.nuguideline.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sumon.nuguideline.R;
import com.sumon.nuguideline.data.sqlite.CGPADBController;
import com.sumon.nuguideline.listener.ItemClickListener;
import com.sumon.nuguideline.model.ResultHistory;

import java.util.ArrayList;

/**
 * Created by sumon on 5/11/2018.
 */

public class ResultHistoryAdapter extends RecyclerView.Adapter<ResultHistoryAdapter.MyViewHolder>{

    private Context mContext;
    private ArrayList<ResultHistory> dataList = new ArrayList<>();

    private CGPADBController cgpadbController;

    private ItemClickListener mListener;


    public ResultHistoryAdapter(Context mContext, ArrayList<ResultHistory> favouriteChannelList) {
        this.mContext = mContext;
        this.dataList = favouriteChannelList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvStdntName, tvSemester, tvGGPA;
        public ImageView ivDelete;
        public CardView cardView;

        public MyViewHolder(final View itemView) {
            super(itemView);
            tvStdntName = (TextView) itemView.findViewById(R.id.tv_stdnt_name);
            tvGGPA = (TextView) itemView.findViewById(R.id.tv_cgpa);
            tvSemester = (TextView) itemView.findViewById(R.id.tv_stdnt_semester);
            ivDelete = (ImageView) itemView.findViewById(R.id.iv_delete_item);

        }
    }
    @Override
    public ResultHistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.result_history_item, parent, false);

        return new ResultHistoryAdapter.MyViewHolder(itemView);
    }

    public void onBindViewHolder(final ResultHistoryAdapter.MyViewHolder holder, final int position) {
        cgpadbController = new CGPADBController(mContext);
        final ResultHistory resultHistory = dataList.get(position);

        holder.tvStdntName.setText(resultHistory.getStudentName());
        holder.tvSemester.setText(resultHistory.getStudentSemester());

        holder.tvGGPA.setText(resultHistory.getStudentCgpa());

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onDeteleItemClick(holder.ivDelete, position);
            }
        });


    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setItemClickListener(ItemClickListener mListener) {
        if (mListener != null) {
            this.mListener = mListener;
        }
    }

}
