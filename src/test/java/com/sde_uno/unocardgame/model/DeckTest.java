package com.sde_uno.unocardgame.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DeckTest {

    @Test
    void shuffleDeck() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        deck1.shuffle();
        assertNotEquals(deck1, deck2);
    }
    @Test
    void drawCard() {
        Deck deck = new Deck();
        Card card = deck.draw();
        assertNotNull(card, "Card not drawn");
    }

    @Test
    void deckCardHasSymbol() {
        Deck deck = new Deck();
        deck.shuffle();
        Card card = deck.draw();
        assertNotNull(Symbol.valueOf(card.getSymbol().name()), "Card is missing symbol");
    }

    @Test
    void deckCardHasColor() {
        Deck deck = new Deck();
        deck.shuffle();
        Card card = deck.draw();
        assertNotNull(Symbol.valueOf(card.getColor().name()), "Card is missing color");
    }

    @Test
    void getDeckSize() {
        Deck deck = new Deck();
        assertEquals(100,deck.getDeckSize());
    }
}