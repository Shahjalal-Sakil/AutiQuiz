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

public class ASDQuizActivity extends AppCompatActivity implements View.OnClickListener{
    private ASDTestQuestionBank ASDQuestionSet = new ASDTestQuestionBank();
    private TextView ASDQuestion;
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;
    private int weight1;
    private int weight2;
    private int weight3;
    private int weight4;
    private int score = 0;
    private int quesNum = 0;

    private ArrayList<Integer> btnId = new ArrayList<>();
    private ArrayList<Integer> weightList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asdquiz);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        ASDQuestionSet.initQuestions(getApplicationContext());
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

    private void init() {
        ASDQuestion= findViewById(R.id.questionView);
        choice1 = findViewById(R.id.choice1View);
        choice2 = findViewById(R.id.choice2View);
        choice3 = findViewById(R.id.choice3View);
        choice4 = findViewById(R.id.choice4View);

        btnId.add(R.id.choice1View);
        btnId.add(R.id.choice2View);
        btnId.add(R.id.choice3View);
        btnId.add(R.id.choice4View);

        choice1.setOnClickListener(this);
        choice2.setOnClickListener(this);
        choice3.setOnClickListener(this);
        choice4.setOnClickListener(this);

        weightList = (ArrayList<Integer>)getIntent().getSerializableExtra("weights");
        if(weightList.get(0)==1)
            score = score +1;
        if(weightList.get(1)==1)
            score = score +1;


    }

    private void updateQuestion(){

        if(quesNum<ASDQuestionSet.getLength() ){

            ASDQuestion.setText(ASDQuestionSet.getQuestion(quesNum));
            choice1.setText(ASDQuestionSet.getChoice(quesNum, 1));
            choice2.setText(ASDQuestionSet.getChoice(quesNum, 2));
            choice3.setText(ASDQuestionSet.getChoice(quesNum, 3));
            choice4.setText(ASDQuestionSet.getChoice(quesNum, 4));

            weight1 = ASDQuestionSet.getWeight(quesNum,1);
            weight2 = ASDQuestionSet.getWeight(quesNum,2);
            weight3 = ASDQuestionSet.getWeight(quesNum,3);
            weight4 = ASDQuestionSet.getWeight(quesNum,4);
            quesNum++;
        }
        else{
            weightList.add(score);
            Intent intent = new Intent(getApplicationContext(),ASDTestDetailsActivity.class);
            intent.putExtra("ASDWeights",weightList);
            this.finish();
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnId.get(0)){
            if(weight1 == 1)
            {
                score = score + 1;
            }
            weightList.add(weight1);
        }
        else if(v.getId()==btnId.get(1)){
            if(weight2 == 1)
            {
                score = score + 1;
            }
            weightList.add(weight2);
        }
        else if(v.getId()==btnId.get(2)){
            if(weight3 == 1)
            {
                score = score + 1;
            }
            weightList.add(weight3);

        }
        else if(v.getId()==btnId.get(3)){
            if(weight4 == 1)
            {
                score = score + 1;
            }
            weightList.add(weight4);
        }
       // Toast.makeText(ASDQuizActivity.this, "Score : '"+score+"'", Toast.LENGTH_SHORT).show();
        updateQuestion();
    }
}
