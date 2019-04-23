package com.example.autism.sakil.autism;

import android.content.Context;

public class cognitiveQuestion {
    private String question;
    private Integer questionImg;
    private Integer choice1;
    private Integer choice2;
    private Integer choice3;
    private Integer choice4;
    private Integer answer;

    public cognitiveQuestion() {

    }
    public cognitiveQuestion(String question,int questionImg,int choice1,int choice2,int choice3,int choice4, int answer) {
        this.question = question;
        this.questionImg = questionImg;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }
    public int getQuestionImg(){
        return questionImg;
    }

    public int getChoice(int i) {
        if(i==1)
            return choice1;
        else if (i==2)
            return choice2;
        else if (i==3)
            return choice3;
        else
            return choice4;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setChoice(int i, int choice) {

        if(i==1)
            this.choice1 = choice;
        else if (i==2)
            this.choice2 = choice;
        else if (i==3)
            this.choice3 = choice;
        else
            this.choice4 = choice;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public void setQuestionImg(int questionImg){
        this.questionImg = questionImg;
    }
}
