package com.example.autism.sakil.autism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CognitiveQuizActivity extends AppCompatActivity implements View.OnClickListener{
   private cognitiveQuestionBank cogQuestionSet;
    private TextView cognitiveQuestion;
    private ImageView cogQuesImg;
    private ImageView choice1;
    private ImageView choice2;
    private ImageView choice3;
    private ImageView choice4;
    private int answer;
    private double score = 0;
    private int quesNum = 0;
    private double numOfQues;
    private double res;

    private ArrayList<Integer> imageId = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cognitive_quiz);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        cogQuestionSet.initQuestions(getApplicationContext());
        numOfQues = cogQuestionSet.getLength();
        updateQuestion();

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
        cognitiveQuestion = findViewById(R.id.questionTextView);
        cogQuesImg = findViewById(R.id.questionImageView);
        choice1 = findViewById(R.id.choice1View);
        choice2 = findViewById(R.id.choice2View);
        choice3 = findViewById(R.id.choice3View);
        choice4 = findViewById(R.id.choice4View);

        imageId.add(R.id.choice1View);
        imageId.add(R.id.choice2View);
        imageId.add(R.id.choice3View);
        imageId.add(R.id.choice4View);

        choice1.setOnClickListener(this);
        choice2.setOnClickListener(this);
        choice3.setOnClickListener(this);
        choice4.setOnClickListener(this);

        cogQuestionSet = new cognitiveQuestionBank();


    }
    private void updateQuestion(){

        if(quesNum<cogQuestionSet.getLength() ){

            cognitiveQuestion.setText(cogQuestionSet.getQuestion(quesNum));
            cogQuesImg.setImageResource(cogQuestionSet.getQuestionImg(quesNum));
            choice1.setImageResource(cogQuestionSet.getChoice(quesNum, 1));
            choice2.setImageResource(cogQuestionSet.getChoice(quesNum, 2));
            choice3.setImageResource(cogQuestionSet.getChoice(quesNum, 3));
            choice4.setImageResource(cogQuestionSet.getChoice(quesNum, 4));
            answer = cogQuestionSet.getCorrectAnswer(quesNum);
            quesNum++;
        }
        else{
            res = (score / numOfQues) * 100.0;
            res = Math.round(res*100.0)/100.0;
            Intent intent = new Intent(getApplicationContext(),CognitiveTestScoreActivity.class);
            intent.putExtra("cogScore",res);
            this.finish();
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == imageId.get(answer-1)) {
           score = score + 1;
        }
       // Toast.makeText(CognitiveQuizActivity.this, "Score : '"+score+"'", Toast.LENGTH_SHORT).show();
        updateQuestion();

    }
}
