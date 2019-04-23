package com.example.autism.sakil.autism;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class cognitiveQuestionBank {
    List<cognitiveQuestion> list = new ArrayList<>();
    cognitiveTestDBHelper myCognitiveTest;
    public int getLength(){
        return list.size();
    }


    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }
    public int getQuestionImg(int a){
        return list.get(a).getQuestionImg();
    }


    public int getChoice(int index, int num) {
        return list.get(index).getChoice(num);
    }


    public int getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }
    public void initQuestions(Context context) {
        myCognitiveTest = new cognitiveTestDBHelper(context);
        list = myCognitiveTest.getAllQuestionsList(list);//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Listen to the word I am going to say: TEASE. If you change the beginning sound of the word TEASE to the sound 'P' - Which of of these would be a picture of the new word?",
                    R.mipmap.ques1,R.mipmap.q1choice1,R.mipmap.q1choice2,R.mipmap.q1choice3,R.mipmap.q1choice4,
                    1));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Ben had the pennies you see in the first box. He spent seven pennies on two pieces of bubble gum. Choose the box that shows how many pennies he had left.",
                    R.mipmap.ques2,R.mipmap.q2choice1,R.mipmap.q2choice2,R.mipmap.q2choice3,R.mipmap.q2choice4,
                    3));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Choose the figure on the bottom that you can make using all 3 shapes on top.",
                    R.mipmap.ques3,R.mipmap.q3choice1,R.mipmap.q3choice2,R.mipmap.q3choice3,R.mipmap.q3choice4,
                    2));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Fill the blank of the picture with correct shape",
                    R.mipmap.ques4,R.mipmap.q4choice1,R.mipmap.q4choice2,R.mipmap.q4choice3,R.mipmap.q4choice4,
                    1));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Evan's mom gave him 3 cookies you see in the first box.He ate 1.Choose the box that shows how many box he had left",
                    R.mipmap.ques5,R.mipmap.q5choice1,R.mipmap.q5choice2,R.mipmap.q5choice3,R.mipmap.q5choice4,
                    1));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Look at the cake backed for sam in the first box.Choose the picture that shows how the cake looks like after cut out the first slice",
                    R.mipmap.ques6,R.mipmap.q6choice1,R.mipmap.q6choice2,R.mipmap.q6choice3,R.mipmap.q6choice4,
                    3));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Choose the box that has the shapes that includes neither a circle nor a square",
                    R.mipmap.spaceboy1,R.mipmap.ques7choice1,R.mipmap.q7choice2,R.mipmap.q7choice3,R.mipmap.q7choice4,
                    3));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Do you see the box how they are related to to each other? Can yo find find the answer that goes in the empty box so the shapes of bottom row relate to each other in the same way as the shapes in the top row",
                    R.mipmap.ques8,R.mipmap.q8choice1,R.mipmap.q8choice2,R.mipmap.q8choice3,R.mipmap.q8choice4,
                    4));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Choose the capital b",
                    R.mipmap.spaceboy1,R.mipmap.ques9choice1,R.mipmap.q9choice2,R.mipmap.q9choice3,R.mipmap.q9choice4,
                    1));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Look at the picture below.There is a teepee,an orange,a ball and a cube.Choose the picture that begins with the sound -b-b-b-b as in bat or bird. ",
                    R.mipmap.space2,R.mipmap.q10choice1,R.mipmap.q10choice2,R.mipmap.q10choice3,R.mipmap.q10choice4,
                    4));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Touch the picture of the thing that is the lightest",
                    R.mipmap.space3,R.mipmap.q11choice1,R.mipmap.q11choice2,R.mipmap.q11choice3,R.mipmap.q11choice4,
                    1));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Choose the picture with most egg",
                    R.mipmap.spaceboy1,R.mipmap.q12choice1,R.mipmap.q12choice2,R.mipmap.q12choice3,R.mipmap.q12choice4,
                    3));
            myCognitiveTest.addInitialQuestion(new cognitiveQuestion("Touch the picture of the water that is most Deep ",
                    R.mipmap.spaceboy1,R.mipmap.q13choice1,R.mipmap.q13choice2,R.mipmap.q13choice3,R.mipmap.q13choice4,
                    1));
            list = myCognitiveTest.getAllQuestionsList(list);//get list from database again

        }
    }

}
