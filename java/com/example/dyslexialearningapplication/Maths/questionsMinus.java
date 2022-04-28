package com.example.dyslexialearningapplication.Maths;

import java.util.Random;

/*
This is the class which determines how the answers are set up on the activity and how the questions are generated
 */

public class questionsMinus {
    private int firstNum;
    private int secondNum;
    private int answer;
    private int[] answerArray;
    private int answerPosition;
    private int upperLimit;
    private String questionPhrase;

    /*
    This is where the question is generated, along with the answer. The upperlimit is used to control what numbers are generated.
     */

    public questionsMinus(int upperLimit) {
        this.upperLimit = upperLimit;
        Random randomNumMaker = new Random();
        this.firstNum = randomNumMaker.nextInt(upperLimit);
        this.secondNum = randomNumMaker.nextInt(upperLimit);
        this.answer = this.firstNum - this.secondNum;
        this.questionPhrase = firstNum + " - " + secondNum + " = ";

        this.answerPosition = randomNumMaker.nextInt(4);
        this.answerArray = new int[]{0, 1, 2, 3};
        this.answerArray[0] = answer + 4;
        this.answerArray[1] = answer + 15;
        this.answerArray[2] = answer - 7;
        this.answerArray[3] = answer - 2;
        this.answerArray = shuffleArray(this.answerArray);

        answerArray[answerPosition] = answer;
    }

    /*
    This shuffles the array that is inserted into it's parameter
     */

    private int[] shuffleArray(int[] array) {
        int index, temp;
        Random randomNumMaker = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            index = randomNumMaker.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /*
    Here is the list of the getters and setters
     */

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}

