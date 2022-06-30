package com.sde_uno.unocardgame.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    public void testHashCode() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        // equal objects must have equal hashcode
        assertNotEquals(deck1.hashCode(), deck2.hashCode());
    }

    @Test
    void resetDeck() {

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
    void draw_cardsRemaining() {
       Deck deck = new Deck();
    }


    @Test
    void draw_noCardsRemaining() throws NoSuchElementException {
        Deck deck = new Deck();
        try {
            deck.draw();
            fail("Should throw NoSuchElementException");
        }
        catch (NoSuchElementException e) {
            assertEquals("Deck is empty!", );
        }

    }

    @Test
    public void getDeckSize() {
        Deck deck = new Deck();
        assertEquals(100,deck.getDeckSize());
    }
}