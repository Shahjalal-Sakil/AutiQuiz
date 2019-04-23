package com.example.autism.sakil.autism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button cogTestBtn ,trtmntBtn ,instrBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        init();
        cogTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CognitiveQuizActivity.class);
                startActivity(intent);
            }
        });
        trtmntBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CareCenterActivity.class);
                startActivity(intent);
            }
        });

        instrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InstructionActivity.class);
                startActivity(intent);
            }
        });




    }
    private void init(){
        cogTestBtn = findViewById(R.id.cognitiveTestBtn);
        trtmntBtn = findViewById(R.id.trtmntBtn);
        instrBtn = findViewById(R.id.instructionBtn);

    }
}
