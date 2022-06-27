package com.sde_uno.unocardgame.model;
import java.util.Objects;
public class Card {
    //Fields
    private final Symbol symbol;
    private final Color color;


    public Card(Symbol symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }


    public Symbol getSymbol() {
        return symbol;
    }
    public Color getColor() {
        return color;
    }


    @Override
    public String toString() {
        return color + " " + symbol ;
    }
}
