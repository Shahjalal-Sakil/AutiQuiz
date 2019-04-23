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

public class VerbalQuizActivity extends AppCompatActivity implements View.OnClickListener {
    private VerbalQuestionBank verbalQuestionSet;
    private TextView verbalQuestion;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;
    private int answer;
    private double score = 0;
    private int quesNum = 0;
    private double numOfQues;
    private double res;
    private ArrayList<Integer> weightList = new ArrayList<>();

    private ArrayList<Integer> btnId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal_quiz);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        verbalQuestionSet.initQuestions(getApplicationContext());
        numOfQues = verbalQuestionSet.getLength();
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
        verbalQuestion = findViewById(R.id.verbalQuestionView);
        choice1 = findViewById(R.id.verbalChoice1View);
        choice2 = findViewById(R.id.verbalChoice2View);
        choice3 = findViewById(R.id.verbalChoice3View);
        choice4 = findViewById(R.id.verbalChoice4View);

        btnId.add(R.id.verbalChoice1View);
        btnId.add(R.id.verbalChoice2View);
        btnId.add(R.id.verbalChoice3View);
        btnId.add(R.id.verbalChoice4View);

        choice1.setOnClickListener(this);
        choice2.setOnClickListener(this);
        choice3.setOnClickListener(this);
        choice4.setOnClickListener(this);

        verbalQuestionSet = new VerbalQuestionBank();

        weightList = (ArrayList<Integer>) getIntent().getSerializableExtra("cogTestWeight");

    }
    private void updateQuestion(){

        if(quesNum<verbalQuestionSet.getLength() ){

            verbalQuestion.setText(verbalQuestionSet.getQuestion(quesNum));
            choice1.setText(verbalQuestionSet.getChoice(quesNum, 1));
            choice2.setText(verbalQuestionSet.getChoice(quesNum, 2));
            choice3.setText(verbalQuestionSet.getChoice(quesNum, 3));
            choice4.setText(verbalQuestionSet.getChoice(quesNum, 4));
            answer = verbalQuestionSet.getCorrectAnswer(quesNum);
            quesNum++;
        }
        else{
            res = (score/numOfQues)*100.0;
            res = Math.round(res*100.0)/100.0;
            if(res<70.0)
            {
                weightList.add(1);
            }
            else
            {
                weightList.add(0);
            }
            Intent intent = new Intent(getApplicationContext(),VerbalTestScoreActivity.class);
            intent.putExtra("testWeights",weightList);
            intent.putExtra("verbalScore",res);
            this.finish();
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnId.get(answer-1)){
            score = score + 1;
        }
       // Toast.makeText(VerbalQuizActivity.this, "Score : '"+score+"'", Toast.LENGTH_SHORT).show();
        updateQuestion();


    }
}
