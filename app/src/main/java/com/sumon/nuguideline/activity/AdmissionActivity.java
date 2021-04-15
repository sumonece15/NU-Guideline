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
                R.drawable.alhaj_mokbul_college,
                R.drawable.new_model_university_college,
                R.drawable.dcomc,
                R.drawable.sbpgc,
                R.drawable.aift,
                R.drawable.nift,
                R.drawable.pisft,
                R.drawable.mkc,
                R.drawable.nist,
                R.drawable.diit,
                R.drawable.cftm,
                R.drawable.sic,
                R.drawable.cat


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

        VarsityList nmuc = new VarsityList(covers[6],"New Model University College (NMUC)");
        varsityLists.add(nmuc);

        VarsityList dcomc = new VarsityList(covers[7],"Dhaka Commerce College (DCC)");
        varsityLists.add(dcomc);

        VarsityList sbpgc = new VarsityList(covers[8],"Shaikh Burhanuddin Post Graduate College (SBPGC)");
        varsityLists.add(sbpgc);

        VarsityList aift = new VarsityList(covers[9],"Apparel Institute of Fashion Technology (AIFT)");
        varsityLists.add(aift);

        VarsityList nift = new VarsityList(covers[10],"National Institute of Fashion Technology (NIFT)");
        varsityLists.add(nift);

        VarsityList pisft = new VarsityList(covers[11],"Professional Institute of Science & Fashion Technology (PISFT)");
        varsityLists.add(pisft);

        VarsityList mkc = new VarsityList(covers[12],"Mohammadpur Kendriya College (MKC)");
        varsityLists.add(mkc);

        VarsityList nist = new VarsityList(covers[13],"National Institute of Science & Technology (nist)");
        varsityLists.add(nist);

        VarsityList diit = new VarsityList(covers[14],"Daffodil Institute of IT (DIIT)");
        varsityLists.add(diit);

        VarsityList cftm = new VarsityList(covers[15],"College of Fashion Technology & Management (CFTM)");
        varsityLists.add(cftm);

        VarsityList sic = new VarsityList(covers[16],"Shyamoli Ideal College (SIC)");
        varsityLists.add(sic);

        VarsityList cat = new VarsityList(covers[17],"College of Aviation Technology (CAT)");
        varsityLists.add(cat);


        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
