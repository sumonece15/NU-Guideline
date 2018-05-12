package com.sumon.nuguideline.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.sumon.nuguideline.R;
import com.sumon.nuguideline.data.sqlite.CGPADBController;

import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity {

    Button btnAddMore, btnCalculate, btnReset;
    Spinner creditSpinner, gradeSpinner;
    ArrayList<Spinner> creditSpinnerArrayList = new ArrayList<>();
    ArrayList<Spinner> gradeSpinnerArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btnAddMore = findViewById(R.id.btn_add_more);
        btnCalculate = findViewById(R.id.btn_calculate);
        btnReset = findViewById(R.id.btn_reset);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String calType = null;
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            calType= null;
        } else {
            calType= extras.getString("calType");
        }

        if (calType.equals("calDetails")){

        }
        else if(calType.equals("calculator")){

        }
        else if(calType.equals("calHistory")){

        }

        btnAddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                creditSpinner = new Spinner(CalculatorActivity.this);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                        CalculatorActivity.this, R.array.array_credit, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource
                        (android.R.layout.simple_spinner_dropdown_item);
                creditSpinner.setAdapter(adapter);

                creditSpinnerArrayList.add(creditSpinner);


                gradeSpinner = new Spinner(CalculatorActivity.this);
                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                        CalculatorActivity.this, R.array.array_grade, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource
                        (android.R.layout.simple_spinner_dropdown_item);
                gradeSpinner.setAdapter(adapter2);
                gradeSpinnerArrayList.add(gradeSpinner);


                // Initialize a new CardView
                CardView creditRow = new CardView(CalculatorActivity.this);
                CardView gradeRow = new CardView(CalculatorActivity.this);
                // Set the CardView layoutParams
                TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT
                );
                creditRow.setLayoutParams(params);
                // Set CardView corner radius
                creditRow.setRadius(9);
                // Set cardView content padding
                //card.setContentPadding(15, 15, 15, 15);

                // Set a background color for CardView
                creditRow.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
                // Set the CardView maximum elevation
                creditRow.setMaxCardElevation(15);
                // Set CardView elevation
                creditRow.setCardElevation(9);
                // Put the TextView in CardView
                creditRow.addView(creditSpinner);


                gradeRow.setLayoutParams(params);
                // Set CardView corner radius
                gradeRow.setRadius(9);
                // Set cardView content padding
                //card.setContentPadding(15, 15, 15, 15);
                // Set a background color for CardView
                gradeRow.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
                // Set the CardView maximum elevation
                gradeRow.setMaxCardElevation(15);
                // Set CardView elevation
                gradeRow.setCardElevation(9);
                // Put the TextView in CardView
                gradeRow.addView(gradeSpinner);


                TableRow row = new TableRow(CalculatorActivity.this);

                //add Layouts to your new row
                int leftMargin=0;
                int topMargin=2;
                int rightMargin=0;
                int bottomMargin=2;

                params.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);


                row.setLayoutParams(params);
                row.addView(creditRow, new TableRow.LayoutParams(1, 100));
                row.addView(gradeRow, new TableRow.LayoutParams(1, 100));

                //add your new row to the TableLayout:
                TableLayout table = (TableLayout) findViewById(R.id.tableLayout1);
                table.addView(row);
            }
        });


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                float gradeSum = 0;
                float creditSum = 0;
                ArrayList<Float> gradeArray = new ArrayList<>();

                if (!creditSpinnerArrayList.isEmpty() && !gradeSpinnerArrayList.isEmpty()) {

                    while (i < creditSpinnerArrayList.size() && i < gradeSpinnerArrayList.size()) {
                        Log.i("SpinnerTest",creditSpinnerArrayList.get(i).getSelectedItem().toString());
                        if (!creditSpinnerArrayList.get(i).getSelectedItem().equals("Select Credit") && !gradeSpinnerArrayList.get(i).getSelectedItem().equals("Select Grade")){
                            creditSum = creditSum+ Integer.parseInt(String.valueOf(creditSpinnerArrayList.get(i).getSelectedItem()));

                            if (gradeSpinnerArrayList.get(i).getSelectedItem().equals("A+")){
                                gradeArray.add((float) 4.00);
                            }
                            else if (gradeSpinnerArrayList.get(i).getSelectedItem().equals("A")){
                                gradeArray.add((float) 3.75);
                            }
                            else if (gradeSpinnerArrayList.get(i).getSelectedItem().equals("A-")){
                                gradeArray.add((float) 3.5);
                            }
                            else if (gradeSpinnerArrayList.get(i).getSelectedItem().equals("B+")){
                                gradeArray.add((float) 3.25);
                            }
                            else if (gradeSpinnerArrayList.get(i).getSelectedItem().equals("B")){
                                gradeArray.add((float) 3.00);
                            }
                            else if (gradeSpinnerArrayList.get(i).getSelectedItem().equals("B-")){
                                gradeArray.add((float) 2.75);
                            }
                            else if (gradeSpinnerArrayList.get(i).getSelectedItem().equals("C+")){
                                gradeArray.add((float) 2.50);
                            }
                            else if (gradeSpinnerArrayList.get(i).getSelectedItem().equals("C")){
                                gradeArray.add((float) 2.25);
                            }
                            else if (gradeSpinnerArrayList.get(i).getSelectedItem().equals("D")){
                                gradeArray.add((float) 2.00);
                            }

                            gradeSum = gradeSum + Integer.parseInt((String) creditSpinnerArrayList.get(i).getSelectedItem())* gradeArray.get(i);

                            i++;

                        }

                    }

                    final float cgpa = gradeSum / creditSum;

                    // get prompts.xml view
                    LayoutInflater li = LayoutInflater.from(CalculatorActivity.this);
                    View dialogView = li.inflate(R.layout.result_dialog, null);

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            CalculatorActivity.this);

                    // set prompts.xml to alertdialog builder
                    alertDialogBuilder.setView(dialogView);

                    //final EditText userInput = (EditText) promptsView.findViewById(R.id.editTextDialogUserInput);

                    TextView tvTotalCgpa = dialogView.findViewById(R.id.tv_total_cgpa);
                    final EditText etStudentName = dialogView.findViewById(R.id.et_student_name);
                    final Spinner spSemester = dialogView.findViewById(R.id.sp_semester);
                    tvTotalCgpa.setText("YOUR TOTAL CGPA IS "+ cgpa);


                    String stdnName, stdntCGPA, stdntSemester;

                    // set dialog message
                    alertDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("Save",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            String stdnName = etStudentName.getText().toString();
                                            String stdntSemester = spSemester.getSelectedItem().toString();
                                            CGPADBController cgpadbController = new CGPADBController(CalculatorActivity.this);
                                            cgpadbController.open();
                                            cgpadbController.insertResultHistoryItem(stdnName, String.valueOf(cgpa), stdntSemester);
                                            cgpadbController.close();

                                            Toast.makeText(getApplicationContext(),"Calculated Result Saved!",Toast.LENGTH_LONG);

                                        }
                                    })
                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog,int id) {
                                            dialog.cancel();
                                        }
                                    });
                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    // show it
                    alertDialog.show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please Add and Choose Grade & Credit before Calculate!", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //creditSpinner.setSelection(0);
                //gradeSpinner.setSelection(0);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
