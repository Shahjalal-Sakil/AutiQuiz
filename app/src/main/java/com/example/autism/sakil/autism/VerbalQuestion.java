package com.example.autism.sakil.autism;



public class VerbalQuestion {
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private Integer answer;

    public VerbalQuestion() {

    }

    public VerbalQuestion(String question, String choice1, String choice2, String choice3, String choice4, Integer answer) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;

    }

    public String getQuestion() {
        return question;
    }
    public String getChoice(int i) {
        if(i==1)
            return choice1;
        else if (i==2)
            return choice2;
        else if (i==3)
            return choice3;
        else
            return choice4;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
    public void setChoice(int i, String choice) {

        if(i==1)
            this.choice1 = choice;
        else if (i==2)
            this.choice2 = choice;
        else if (i==3)
            this.choice3 = choice;
        else
            this.choice4 = choice;
    }
}
