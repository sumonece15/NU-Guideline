package com.sumon.nuguideline.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.sumon.nuguideline.R;
import com.sumon.nuguideline.adapter.VarsityListAdapter;
import com.sumon.nuguideline.model.VarsityList;

import java.util.ArrayList;

public class AdmissionActivity extends AppCompatActivity {

    private ArrayList<VarsityList> varsityLists;

    private RecyclerView rvVarsityList;
    VarsityListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariable();
        initView();
        initFunctionality();
    }

    private void initView() {
        setContentView(R.layout.activity_admission);
        rvVarsityList = findViewById(R.id.rv_admission);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        rvVarsityList.setLayoutManager(mLayoutManager);
        rvVarsityList.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new VarsityListAdapter(this, varsityLists);
        rvVarsityList.setAdapter(mAdapter);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Proffesional Institutes");


    }

    private void initVariable() {

        varsityLists = new ArrayList<>();


    }

    private void initFunctionality() {

        int[] covers = new int[]{
                R.drawable.ist,
                R.drawable.bist,
                R.drawable.istt,
                R.drawable.dcc,
                R.drawable.tejgacollege,
                R.drawable.alhaj_mokbul_college

        };

        VarsityList ist = new VarsityList(covers[0],"Institute of Science and Technology(IST)");
        varsityLists.add(ist);

        VarsityList bist = new VarsityList(covers[1],"Bangladesh Institute of Science Technology(BIST)");
        varsityLists.add(bist);

        VarsityList istt = new VarsityList(covers[2],"Institute of Science Trade and Technology(ISTT)");
        varsityLists.add(istt);

        VarsityList dcc = new VarsityList(covers[3],"Dhaka City College (DCC)");
        varsityLists.add(dcc);

        VarsityList tejgao = new VarsityList(covers[4],"Tejgaon College (TC)");
        varsityLists.add(tejgao);

        VarsityList amhuc = new VarsityList(covers[5],"Al Haj Mockbul Hossain University College (AMHUC)");
        varsityLists.add(amhuc);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
