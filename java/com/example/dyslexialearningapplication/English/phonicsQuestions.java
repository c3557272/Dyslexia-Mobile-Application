package com.example.dyslexialearningapplication.English;

/*
This class creates the phonics questions and will be called in the activity class.
 */

public class phonicsQuestions {
    private String question, option1, option2, option3, option4;
    private int correctAnsNo;

    /*
    This method creates the question and indicates the parameters that will be passed through each question that is implemented.
    The method is then followed by multiple getters and setters for the each of the parameters for easy setting and calling capabilities.
     */

    public phonicsQuestions(String question, String option1, String option2, String option3, String option4, int correctAnsNo) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnsNo = correctAnsNo;
    }

    /*
    These are the getters and setters for each of the parameters.
     */

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getCorrectAnsNo() {
        return correctAnsNo;
    }

    public void setCorrectAnsNo(int correctAnsNo) {
        this.correctAnsNo = correctAnsNo;
    }


}
