package com.sde_uno.unocardgame.model;

import java.util.*;

public class Deck implements Iterable<Card>{

    private final int redNumSize = 19;
    private final int blueNumSize = 19;
    private final int greenNumSize = 19;
    private final int yellowNumSize = 19;
    private final int skipSize = 8;
    private final int drawTwoSize = 8;
    private final int wildSize = 4;
    private final int wildDrawFourSize = 4;
    private final int size = (redNumSize + blueNumSize + greenNumSize + yellowNumSize + skipSize + drawTwoSize + wildSize + wildDrawFourSize);
    private final List<Card> cards;

    public Deck() {
        Color[] colors = Color.values();
        Symbol[] symbols = Symbol.values();

        cards = new ArrayList<>(size);
        for (Color color: colors) {
            for (Symbol symbol: symbols) {
                if (symbol.needsColor()) {
                    if (symbol.equals(Symbol.ZERO)) {
                        Card card = new Card(symbol, color);
                        cards.add(card);
                    } else {
                        Card card = new Card(symbol, color);
                        cards.add(card);
                        cards.add(card);
                    }
                } else {
                    Card card = new Card(symbol);
                    cards.add(card);
                }
            }
        }
        reset();
    }

    public void reset() {
        Iterator<Card> iterator = cards.iterator();
        int remaining = size;
    }

    public void shuffle() {
        Collections.shuffle(cards);
        reset();
    }

    public Card draw() {
        try {
            Card card = cards.get(0);
            return card;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Deck is empty!");
        }
    }

    public Card removeCard() {
        return cards.remove(0);
    }

    public int getDeckSize() {
        return cards.size();
    }

    @Override
    public Iterator<Card> iterator() {
        return Collections.unmodifiableCollection(cards).iterator();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return cards.toString();
    }

}
