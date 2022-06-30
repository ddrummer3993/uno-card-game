package com.sde_uno.unocardgame.model;
import java.util.Objects;
public class Card {
    //Fields
    private Symbol symbol;
    private Color color;
    private int hash;
    private String stringSymbol;


    public Card(Symbol symbol) {
        this.symbol = symbol;
    }

    public Card(Symbol symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
        hash = Objects.hash(symbol, color);
        stringSymbol = symbol.getAbbreviation() + " " + color.getAbbreviation();
    }


    public Symbol getSymbol() {
        return symbol;
    }
    public Color getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    public boolean equals(Object obj) {
        boolean comparison;
        if (this == obj) {
            comparison = true;
        } else if (obj instanceof Card) {
            Card other = (Card) obj;
            comparison = (symbol == other.symbol && color == other.color);
        } else {
            comparison = false;
        }
        return comparison;
    }

    @Override
    public String toString() {
        return (color != null ) ? (stringSymbol) : symbol.getAbbreviation() ;
    }


    public int compareTo(Card other) {
        int comparison = symbol.compareTo(other.symbol);
        return (comparison != 0) ? comparison : color.compareTo(other.color);
    }
}
