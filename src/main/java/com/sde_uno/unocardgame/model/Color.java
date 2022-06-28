package com.sde_uno.unocardgame.model;

public enum Color {

    RED("R"),
    GREEN("G"),
    BLUE("B"),
    YELLOW("Y");


    private final String colorSymbol;

    Color(String colorSymbol) {
        this.colorSymbol = colorSymbol;
    }

    public String getColorSymbol() {
        return colorSymbol;
    }
}
