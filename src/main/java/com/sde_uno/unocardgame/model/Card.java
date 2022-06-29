package com.sde_uno.unocardgame.model;
import java.util.Objects;
public class Card {
    //Fields
    private Symbol symbol;
    private Color color;



    public Card(Symbol symbol) {
        this.symbol = symbol;
    }

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

    /**
     * IF card is a playable card, or a wildcard.
     */
    public boolean isPlayable() {
        return this.symbol.needsColor();
    }

    @Override
    public String toString() {
        return (color != null ) ? (color + " " + symbol) : symbol.toString() ;
    }
}
