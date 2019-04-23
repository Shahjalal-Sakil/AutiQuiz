package com.example.autism.sakil.autism;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class ASDTestQuestionBank {
    List<ASDTestQuestion> list = new ArrayList<>();
    cognitiveTestDBHelper myASDTest;
    public int getLength(){
        return list.size();
    }


    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }


    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num);
    }


    public Integer getWeight(int index, int num) {
        return list.get(index).getWeight(num);
    }

    public void initQuestions(Context context) {
        myASDTest= new cognitiveTestDBHelper(context);
        list = myASDTest.getAllASDQuestionsList(list);//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myASDTest.addInitialASDQuestion(new ASDTestQuestion("S/he often notices small sounds when others do not?",
                    "Definitely Agree","Slightly Agree","Slightly Disagree","Definitely Disagree",
                    1,1,0,0 ));
            myASDTest.addInitialASDQuestion(new ASDTestQuestion("S/he usually concentrates more on the whole picture, rather than the small details?",
                    "Definitely Agree","Slightly Agree","Slightly Disagree","Definitely Disagree",
                    0,0,1,1 ));
            myASDTest.addInitialASDQuestion(new ASDTestQuestion("In a social group, s/he can easily keep track of several different people's conversations?",
                    "Definitely Agree","Slightly Agree","Slightly Disagree","Definitely Disagree",
                    0,0,1,1 ));
            myASDTest.addInitialASDQuestion(new ASDTestQuestion("S/he finds it easy to go back and forth between different activities?",
                    "Definitely Agree","Slightly Agree","Slightly Disagree","Definitely Disagree",
                    0,0,1,1 ));
            myASDTest.addInitialASDQuestion(new ASDTestQuestion("S/he doesn't know how to keep conversation going with his/her peers?",
                    "Definitely Agree","Slightly Agree","Slightly Disagree","Definitely Disagree",
                    1,1,0,0 ));
            myASDTest.addInitialASDQuestion(new ASDTestQuestion("S/he is good at social chit-chat?",
                    "Definitely Agree","Slightly Agree","Slightly Disagree","Definitely Disagree",
                    0,0,1,1 ));
            myASDTest.addInitialASDQuestion(new ASDTestQuestion("When s/he is read a story, s/he finds it difficult to work out the character's intentions or feelings?",
                    "Definitely Agree","Slightly Agree","Slightly Disagree","Definitely Disagree",
                    1,1,0,0 ));
            myASDTest.addInitialASDQuestion(new ASDTestQuestion("When s/he was in preschool, s/he used to enjoy playing games involving pretending with other children?",
                    "Definitely Agree","Slightly Agree","Slightly Disagree","Definitely Disagree",
                    0,0,1,1 ));
            myASDTest.addInitialASDQuestion(new ASDTestQuestion("S/he finds it easy to work out what someone is thinking or feeling just by looking at their face?",
                    "Definitely Agree","Slightly Agree","Slightly Disagree","Definitely Disagree",
                    0,0,1,1 ));
            myASDTest.addInitialASDQuestion(new ASDTestQuestion("S/he finds it hard to make new friends?",
                    "Definitely Agree","Slightly Agree","Slightly Disagree","Definitely Disagree",
                    1,1,0,0 ));
            list = myASDTest.getAllASDQuestionsList(list);//get list from database again

        }
    }
}
