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

public class CognitiveTestScoreActivity extends AppCompatActivity {
    private Button playButton;
    private TextView testScore;
    private Double score;
    private ArrayList<Integer> weightList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cognative_test_score);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),VerbalQuizActivity.class);
                intent.putExtra("cogTestWeight",weightList);
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
        testScore = findViewById(R.id.cognitiveTestScore);
        score =  getIntent().getDoubleExtra("cogScore",0);
        if(score <70.0)
        {
            weightList.add(1);
            testScore.setText("Your result is not upto mark\nNow Time for Verbal Test");

        }
        else {
            weightList.add(0);
            testScore.setText("You have done well\nNow Time for Verbal Test");
        }
       // Toast.makeText(CognitiveTestScoreActivity.this, "Score : '"+weightList.get(0)+"'", Toast.LENGTH_SHORT).show();
    }
}

