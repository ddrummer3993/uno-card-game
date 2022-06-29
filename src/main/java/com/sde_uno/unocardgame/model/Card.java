package com.sde_uno.unocardgame.model;
import java.util.Objects;
public class Card {
    //Fields
    private Symbol symbol;
    private Color color;
    private String stringSymbol;



    public Card(Symbol symbol) {
        this.symbol = symbol;
    }

    public Card(Symbol symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
        stringSymbol = color.getAbbreviation() + " " + symbol.getAbbreviation();
    }


    public Symbol getSymbol() {
        return symbol;
    }
    public Color getColor() {
        return color;
    }

    //TODO implement override for equals - refer to playing cards.

    @Override
    public String toString() {
        return (color != null ) ? (stringSymbol) : symbol.getAbbreviation() ;
    }
}
