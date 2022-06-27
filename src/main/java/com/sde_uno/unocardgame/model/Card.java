package com.sde_uno.unocardgame.model;
import java.util.Objects;
public class Card {
    //Fields
    private Symbol symbol;
    private Color color;

    //Constructor
    public Card(Symbol symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    //Getters
    public Symbol getSymbol() {
        return symbol;
    }
    public Color getColor() {
        return color;
    }

}
