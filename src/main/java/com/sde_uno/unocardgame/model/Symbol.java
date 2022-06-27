package com.sde_uno.unocardgame.model;

import java.awt.*;

public enum Symbol {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    DRAWTWO("D2"),
    SKIP("S"),
    WILD("W"),
    WILDDRAW("WD");



    private final String abbreviation;

    Symbol(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }







    }






