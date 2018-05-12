package com.sumon.nuguideline.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sumon.nuguideline.R;

public class SyllabusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String deptName = null;
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            deptName= null;
        } else {
            deptName= extras.getString("deptName");
        }

        if (deptName.equals("CSE")){

        }
        else if(deptName.equals("ECE")){

        }
        else if(deptName.equals("BBA")){

        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
