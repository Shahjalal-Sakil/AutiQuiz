package com.example.autism.sakil.autism;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class VerbalQuestionBank {
    List<VerbalQuestion> list = new ArrayList<>();
    cognitiveTestDBHelper myVerbalTest;
    public int getLength(){
        return list.size();
    }


    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }


    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num);
    }


    public int getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }

    public void initQuestions(Context context) {
        myVerbalTest = new cognitiveTestDBHelper(context);
        list = myVerbalTest.getAllVerbalQuestionsList(list);//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("What is the color of blood?",
                    "Blue","Yellow","Black","Red",
                    4));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("What are clothes made off?",
                    "Cloth","Paper","Wood","Glass",
                    1));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which has the sweetest test?",
                    "Spaghetti","Hot Dogs","Honey","Peanut Butter",
                    3));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which tastes the most sour?",
                    "Apple","Banana","Orange","Lemon",
                    4));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which is the hottest?",
                    "Light Bulb","Pancake","Flame","Gun",
                    3));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which is the coldest?",
                    "Ice","Water","Rain","Glass",
                    1));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which is used for making holes in wood?",
                    "Pliers","Hammer","Plane","Drill",
                    4));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which is used when playing cricket?",
                    "Basket","Racket","Mitt","Bat",
                    4));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which is used when making clothes?",
                    "String ","Plastic","Pattern","Nails",
                    1));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which is used to make concrete?",
                    "Mud","Sand","Plaster","Asphalt",
                    1));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which can cause disease?",
                    "Bacteria","Baldness","Bones","Blood",
                    1));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which grows on a tree?",
                    "Coconut","Pineapple","Blueberry","Coffee Bean",
                    1));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which is not a fruit?",
                    "Mango","Grape","Tomato","Potato",
                    4));
            myVerbalTest.addInitialVerbalQuestion(new VerbalQuestion("Which is cooked in an oven?",
                    "Doughnut","Waffle","Cake","Pancake",
                    2));
            list = myVerbalTest.getAllVerbalQuestionsList(list);//get list from database again

        }
    }

}
