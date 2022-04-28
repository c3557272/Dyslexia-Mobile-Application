package com.example.dyslexialearningapplication.Maths;

import java.util.ArrayList;
import java.util.List;

/*
This class is responsible for tracking the subtraction game. Methods are defined here to correctly get the information required for the game to function.
 */

/*
Code adapted from:
Programming with Professor Sluiter (2019) Math Quiz Mobile App in Android Studio [Online]. Available from: https://www.youtube.com/watch?v=ja1Jli7bHNM [Accessed 02 March 2022]
This guide was adapted to create the question loading function as well as
 */

public class gameTrackerMinus {

    private List<questionsMinus> questions;
    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuestions;
    private int score;
    private questionsMinus currentQuestion;

    /*
    This method sets the game to start correctly and initiates the important variable.
     */

    public gameTrackerMinus() {
        numberCorrect = 0;
        numberIncorrect = 0;
        totalQuestions = 0;
        score = 0;
        currentQuestion = new questionsMinus(10);
        questions = new ArrayList<>();
    }

    /*
    This method is responsible for making the new question and addition to the total questions count appropriately.
     */

    public void makeNewQ() {
        currentQuestion = new questionsMinus(totalQuestions * 2 + 5);
        totalQuestions++;
        questions.add(currentQuestion);
    }

    /*
    This is an important method as it is responsible for checking the answer submitted.
     */

    public boolean checkAnswer(int submittedAnswer) {
        boolean isCorrect;
        if (currentQuestion.getAnswer() == submittedAnswer) {
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
    Here is the list of getters and setters for the parameters.
     */

    public List<questionsMinus> getQuestions() {
        return questions;
    }

    public void setQuestions(List<questionsMinus> questions) {
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

    public questionsMinus getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(questionsMinus currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

}
