package com.example.ppkwu3;

public class ResponseApi {
    private String textToProcess;
    private int upperCaseCounter;
    private int lowerCaseCounter;
    private int digitCounter;
    private int whiteSpaceCounter;
    private int specialCharacterCounter;

    public ResponseApi() {
    }

    public ResponseApi(String textToProcess, int upperCaseLettersCounter, int lowerCaseLettersCounter, int digitCounter, int whiteSpaceCounter, int specialCharacterCounter) {
        this.textToProcess = textToProcess;
        this.upperCaseCounter = upperCaseLettersCounter;
        this.lowerCaseCounter = lowerCaseLettersCounter;
        this.digitCounter = digitCounter;
        this.whiteSpaceCounter = whiteSpaceCounter;
        this.specialCharacterCounter = specialCharacterCounter;
    }

    public String getTextToProcess() {
        return textToProcess;
    }

    public void setTextToProcess(String textToProcess) {
        this.textToProcess = textToProcess;
    }

    public int getUpperCaseCounter() {
        return upperCaseCounter;
    }

    public void setUpperCaseCounter(int upperCaseCounter) {
        this.upperCaseCounter = upperCaseCounter;
    }

    public int getLowerCaseCounter() {
        return lowerCaseCounter;
    }

    public void setLowerCaseCounter(int lowerCaseCounter) {
        this.lowerCaseCounter = lowerCaseCounter;
    }

    public int getDigitCounter() {
        return digitCounter;
    }

    public void setDigitCounter(int digitCounter) {
        this.digitCounter = digitCounter;
    }

    public int getWhiteSpaceCounter() {
        return whiteSpaceCounter;
    }

    public void setWhiteSpaceCounter(int whiteSpaceCounter) {
        this.whiteSpaceCounter = whiteSpaceCounter;
    }

    public int getSpecialCharacterCounter() {
        return specialCharacterCounter;
    }

    public void setSpecialCharacterCounter(int specialCharacterCounter) {
        this.specialCharacterCounter = specialCharacterCounter;
    }

    @Override
    public String toString() {
        return "Response{" +
                "textToProcess='" + textToProcess + '\'' +
                ", upperCaseLettersCounter=" + upperCaseCounter +
                ", lowerCaseLettersCounter=" + lowerCaseCounter +
                ", digitCounter=" + digitCounter +
                ", whiteSpaceCounter=" + whiteSpaceCounter +
                ", specialCharacterCounter=" + specialCharacterCounter +
                '}';
    }
}
