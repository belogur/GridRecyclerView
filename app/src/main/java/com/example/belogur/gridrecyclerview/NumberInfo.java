package com.example.belogur.gridrecyclerview;

import java.text.SimpleDateFormat;

public class NumberInfo {
    private int _number;

    public NumberInfo(int number) {
        _number = number;
    }

    public int getNumber() {
        return _number;
    }

    @Override
    public String toString() {
        String result = "" + _number;
/*
        if (isUsed())
            result += " - guessed on " + new SimpleDateFormat("MMM d 'at' ha").format(_guessInfo.getGuessDate());
*/
        return result;
    }
}
