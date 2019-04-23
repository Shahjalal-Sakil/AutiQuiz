package com.example.autism.sakil.autism;

public class ASDTestQuestion {
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private Integer choice1Weight;
    private Integer choice2Weight;
    private Integer choice3Weight;
    private Integer choice4Weight;

    public ASDTestQuestion() {

    }

    public ASDTestQuestion(String question, String choice1, String choice2, String choice3, String choice4, Integer choice1Weight, Integer choice2Weight, Integer choice3Weight, Integer choice4Weight) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.choice1Weight = choice1Weight;
        this.choice2Weight = choice2Weight;
        this.choice3Weight = choice3Weight;
        this.choice4Weight = choice4Weight;

    }
    public String getQuestion(){
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
    public Integer getWeight(int i) {
        if(i==1)
            return choice1Weight;
        else if (i==2)
            return choice2Weight;
        else if (i==3)
            return choice3Weight;
        else
            return choice4Weight;
    }
    public void setQuestion(String question) {
        this.question = question;
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
    public void setWeight(int i, Integer weight) {

        if(i==1)
            this.choice1Weight = weight;
        else if (i==2)
            this.choice2Weight = weight;
        else if (i==3)
            this.choice3Weight = weight;
        else
            this.choice4Weight = weight;
    }
}
