package com.sde_uno.unocardgame.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

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
    void drawCard() {
       Deck deck = new Deck();


    }


    @Test
    void getRemaining() {
        Deck deck = new Deck();
    }

    @Test
    void getDeckSize() {
        Deck deck = new Deck();
        assertEquals(100,deck.getDeckSize());
    }
}