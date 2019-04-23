package com.example.autism.sakil.autism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ASDTestDetailsActivity extends AppCompatActivity {

    private EditText getAge;
    private RadioButton radioSexButton;
    private RadioButton radioJaundiceButton;
    private RadioButton radioDiagnosedButton;
    private RadioButton radioReviewButton;
    private RadioGroup radioSexGroup,radioJaundiceGroup,radioDiagnosedGroup,radioReviewGroup;
    private Button generateResult;
    private Spinner spinner;
    private ArrayList<Integer> dataList;
    private Integer age ,success;
    private String gender , isJaundice, isDiagnosed,isReviewed , user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asdtest_details);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       init();


        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.list_array,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Your code

               // Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                user = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        generateResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getResult();

                 age = Integer.parseInt(getAge.getText().toString());
                 gender = radioSexButton.getText().toString();
                 isJaundice = radioJaundiceButton.getText().toString();
                 isDiagnosed = radioDiagnosedButton.getText().toString();
                 isReviewed = radioReviewButton.getText().toString();
                 setDataList();
                 if(success == 1) {
                     Intent intent = new Intent(getApplicationContext(), ASDTestResultActivity.class);
                     intent.putExtra("dataList", dataList);
                     finish();
                     startActivity(intent);
                 }
                 else {
                     Toast.makeText(ASDTestDetailsActivity.this, "Age must be between 4-11", Toast.LENGTH_SHORT).show();
                 }


            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void init(){
        generateResult = findViewById(R.id.generateResult);
        getAge = findViewById(R.id.ageEditText);
        radioSexGroup =  findViewById(R.id.radioSex);
        radioJaundiceGroup =  findViewById(R.id.radioJaundice);
        radioDiagnosedGroup =  findViewById(R.id.radioDiagnosed);
        radioReviewGroup =  findViewById(R.id.radioReview);

        spinner =  findViewById(R.id.Spinner);
        dataList = (ArrayList<Integer>) getIntent().getSerializableExtra("ASDWeights");

    }


    public void getResult(){

        int getId = radioSexGroup.getCheckedRadioButtonId();
        radioSexButton = findViewById(getId);

        getId = radioJaundiceGroup.getCheckedRadioButtonId();
        radioJaundiceButton = findViewById(getId);

        getId = radioDiagnosedGroup.getCheckedRadioButtonId();
        radioDiagnosedButton = findViewById(getId);

        getId = radioReviewGroup.getCheckedRadioButtonId();
        radioReviewButton = findViewById(getId);


    }
    private void setDataList(){
        if(age >=4 && age <=11) {
            dataList.add(age);
            success = 1;
        }
        else {
            success = 0;
            return;
        }

        //gender
        if(gender == "Male")
           dataList.add(1);
        else
            dataList.add(0);

        //Jaundice
        if (isJaundice=="Yes")
            dataList.add(1);
        else
            dataList.add(0);

        //Family ASD
        if (isDiagnosed=="Yes")
            dataList.add(1);
        else
            dataList.add(0);

        //Used App Before
        if (isReviewed=="Yes")
            dataList.add(1);
        else
            dataList.add(0);

        //User
        if(user == "Self")
            dataList.add(5);
        else if(user=="Parent")
            dataList.add(1);
        else if(user=="Relative")
            dataList.add(2);
        else if(user=="Health care professionals")
            dataList.add(3);
        else if(user=="others")
            dataList.add(4);
        else
            dataList.add(5);

    }
}
