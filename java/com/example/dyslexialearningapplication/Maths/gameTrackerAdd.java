package com.example.dyslexialearningapplication.Maths;

import java.util.ArrayList;
import java.util.List;

/*
This class is where the game for the addition activity is tracked. Methods are defined here to correctly get the information required for the game to function.
 */

public class gameTrackerAdd {

    private List<questionsAdd> questions;
    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuestions;
    private int score;
    private questionsAdd currentQ;

    /*
    This method sets the game to start correctly and initiates the important variable.
     */

    public gameTrackerAdd() {
        numberCorrect = 0;
        numberIncorrect = 0;
        totalQuestions = 0;
        score = 0;
        currentQ = new questionsAdd(10);
        questions = new ArrayList<>();
    }

    /*
This is an important method as it is responsible for checking the answer submitted.
 */
    public boolean validateAns(int userAns) {
        boolean isCorrect;
        if (currentQ.getAnswer() == userAns) {
            numberCorrect++;
            isCorrect = true;
        } else {
            numberIncorrect++;
            isCorrect = false;
        }
        score = numberCorrect * 10 - numberIncorrect * 20;
        return isCorrect;
    }

    /*
    This method is responsible for making the new question and addition to the total questions count appropriately.
     */
    public void newQuestion() {
        currentQ = new questionsAdd(totalQuestions * 2 + 5);
        totalQuestions++;
        questions.add(currentQ);
    }

    /*
    Here is the list of getters and setters for the parameters.
     */

    public List<questionsAdd> getQuestions() {
        return questions;
    }

    public void setQuestions(List<questionsAdd> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public questionsAdd getCurrentQ() {
        return currentQ;
    }

    public void setCurrentQ(questionsAdd currentQ) {
        this.currentQ = currentQ;
    }

}
