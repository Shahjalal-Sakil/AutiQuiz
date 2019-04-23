package com.example.autism.sakil.autism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerbalTestScoreActivity extends AppCompatActivity {
   private Button playButton;
   private TextView testScore;
   private Double score;
    private ArrayList<Integer> weightList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal_test_score);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ASDQuizActivity.class);
                intent.putExtra("weights",weightList);
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
    public void init(){
        playButton = findViewById(R.id.playBtn);
        testScore = findViewById(R.id.verbalTestScore);
        weightList = (ArrayList<Integer>) getIntent().getSerializableExtra("testWeights");
        score = getIntent().getDoubleExtra("verbalScore",0);
        if(weightList.get(1)==1)
        {
            testScore.setText("Your result is not upto mark\nNow Give the phone to your parents");
        }
        else
            testScore.setText("You have done well\nNow Give the phone to your parents");


    }
}
