package com.sumon.nuguideline.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

import com.sumon.nuguideline.R;
import com.sumon.nuguideline.adapter.ResultHistoryAdapter;
import com.sumon.nuguideline.data.sqlite.CGPADBController;
import com.sumon.nuguideline.listener.ItemClickListener;
import com.sumon.nuguideline.model.ResultHistory;

import java.util.ArrayList;

public class ResultHistoryActivity extends AppCompatActivity {


    // init variables
    private Context mContext;
    private Activity mActivity;

    private RecyclerView rvREsultHistory;
    private ResultHistoryAdapter resultHistoryAdapter;
    private ArrayList<ResultHistory> resultHistoryArrayList;
    private CGPADBController cgpadbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_history);

        initVariable();

        initView();
        initListener();
        initFunctionality();
    }

    private void initVariable() {
        resultHistoryArrayList = new ArrayList<>();
        mActivity = ResultHistoryActivity.this;
        mContext = mActivity.getApplicationContext();
        cgpadbController = new CGPADBController(mContext);
        cgpadbController.open();

    }

    private void initView(){
        rvREsultHistory = (RecyclerView) findViewById(R.id.rv_result_history);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        rvREsultHistory.setLayoutManager(mLayoutManager);
        rvREsultHistory.setItemAnimator(new DefaultItemAnimator());
        resultHistoryAdapter = new ResultHistoryAdapter(this, resultHistoryArrayList);
        rvREsultHistory.setAdapter(resultHistoryAdapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void initFunctionality() {
        loadFavouriteData();
    }


    //Initialize Listener
    private void initListener() {
        resultHistoryAdapter.setItemClickListener(new ItemClickListener() {

            @Override
            public void onDeteleItemClick(ImageView view, int position) {




                final CGPADBController cgpadbController = new CGPADBController(mContext);
                cgpadbController.open();

                int keyID = position+1;
                try {
                    cgpadbController.open();
                    cgpadbController.deleteHistoryItemById(position);
                    Log.d("TEstDelete","--> "+keyID);
                    cgpadbController.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                loadFavouriteData();
            }

        });

    }



    private void loadFavouriteData() {

        if (!resultHistoryArrayList.isEmpty()) {
            resultHistoryArrayList.clear();
        }
        try {
            CGPADBController favouriteController = new CGPADBController(mContext);
            favouriteController.open();
            resultHistoryArrayList.addAll(favouriteController.getAllHistoryResultData());
            favouriteController.close();

            resultHistoryAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
