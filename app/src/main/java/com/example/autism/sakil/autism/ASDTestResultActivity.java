package com.example.autism.sakil.autism;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ASDTestResultActivity extends AppCompatActivity {
    private TextView resultText,progressText;
    private ImageView img;
    private Button treatment;
    private ProgressBar progressBar;
    private FileRead file;
    private Double prob;
    private Handler handler;
    private ArrayList<Integer> data;
    private Integer A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,age,gender,juan,fasd,uab,score,user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asdtest_result);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        progressBar.setVisibility(View.VISIBLE);
        resultText.setVisibility(View.GONE);
        treatment.setVisibility(View.GONE);
        img.setVisibility(View.GONE);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                List<DatasetInstance> instances = file.readLine("autism.txt");
                Logistic logistic = new Logistic(18);
                logistic.train(instances);
                int[] x = {1,A1,A2,A3,A4,A5,A6,A7,A8,A9,A10,age,gender,juan,fasd,uab,score,user};
                prob = logistic.classify(x);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        progressText.setVisibility(View.GONE);
                        resultText.setVisibility(View.VISIBLE);

                        img.setVisibility(View.VISIBLE);
                        if(prob>=0.5) {

                            resultText.setText("Your Children have possibility of Autism.\n So, consult with doctors quickly");
                            resultText.setTextColor(Color.RED);
                            treatment.setVisibility(View.VISIBLE);


                        }
                        else {
                            resultText.setText("Your children is risk free!!!");
                        }

                    }
                });

            }
        };
        new Thread(runnable).start();

        treatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CareCenterActivity.class);
                finish();
                startActivity(intent);
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

    private void init()
    {
        resultText = findViewById(R.id.resultStatus);
        progressText = findViewById(R.id.ASDTestScore);
        progressBar = findViewById(R.id.progressBar);
        treatment = findViewById(R.id.treatmentBtn);
        img = findViewById(R.id.aImageView);
        file = new FileRead(this);
        handler = new Handler();
        data = (ArrayList<Integer>) getIntent().getSerializableExtra("dataList");
        A1= data.get(0); A2 = data.get(1); A3 = data.get(2);
        A4= data.get(3); A5 = data.get(4); A6 = data.get(5);
        A7= data.get(6); A8 = data.get(7); A9 = data.get(8);
        A10 = data.get(9); score = data.get(10); age = data.get(11);
        gender = data.get(12); juan = data.get(13); fasd = data.get(14);
        uab = data.get(15); user = data.get(16);

    }
}
