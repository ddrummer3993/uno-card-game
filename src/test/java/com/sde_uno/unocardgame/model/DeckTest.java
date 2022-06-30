package com.sde_uno.unocardgame.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DeckTest {
    @Test
    void resetDeck() {
        // This doesn't seem like it would work
    }
    @Test
    void shuffleDeck() {
        //shuffle deck and compare to see if decks are the same
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
    void getRemaining() {
        Deck deck = new Deck();
        int remainingBeforeDrawing = deck.getRemaining();
        deck.draw();
        int remainingAfterDrawing = deck.getRemaining();
        assertNotEquals(remainingAfterDrawing, remainingAfterDrawing, "Remaining card count in deck are invalid");
    }
    @Test
    void getDeckSize() {
        Deck deck = new Deck();
        assertEquals(100,deck.getDeckSize());
        deck.draw();
        assertEquals(99, deck.getDeckSize(), "Deck size is not updated after drawing!");
    }
}