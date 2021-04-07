package com.sumon.nuguideline.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.sumon.nuguideline.R;

public class SyllabusActivity extends AppCompatActivity implements OnLoadCompleteListener, OnPageChangeListener, OnPageErrorListener {


    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pdfView= findViewById(R.id.pdfView);

        String deptName = null;
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            deptName= null;
        } else {
            deptName= extras.getString("deptName");
        }

        if (deptName.equals("CSE")){

            getSupportActionBar().setTitle("CSE Syllabus");

            pdfView.fromAsset("cse_syllabus.pdf")
                    .defaultPage(0)
                    .onPageChange(this)
                    .enableAnnotationRendering(true)
                    .onLoad(this)
                    .scrollHandle(new DefaultScrollHandle(this))
                    .spacing(10) // in dp
                    .onPageError(this)
                    .load();

        }
        else if(deptName.equals("ECE")){
            getSupportActionBar().setTitle("ECE Syllabus");

            pdfView.fromAsset("ece_syllabus.pdf")
                    .defaultPage(0)
                    .onPageChange(this)
                    .enableAnnotationRendering(true)
                    .onLoad(this)
                    .scrollHandle(new DefaultScrollHandle(this))
                    .spacing(10) // in dp
                    .onPageError(this)
                    .load();

        }
        else if(deptName.equals("BBA")){

            getSupportActionBar().setTitle("BBA Syllabus");

            pdfView.fromAsset("bba_syllabus.pdf")
                    .defaultPage(0)
                    .onPageChange(this)
                    .enableAnnotationRendering(true)
                    .onLoad(this)
                    .scrollHandle(new DefaultScrollHandle(this))
                    .spacing(10) // in dp
                    .onPageError(this)
                    .load();
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public void loadComplete(int nbPages) {

    }

    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    @Override
    public void onPageError(int page, Throwable t) {

    }
}
