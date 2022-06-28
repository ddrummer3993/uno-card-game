package com.sde_uno.unocardgame.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void resetDeck() {
    }

    @Test
    void shuffleDeck() {
        //shuffle deck and compare to see if equal;
        //deck1 != deck2
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        deck1.shuffle();
        assertFalse(Arrays.equals(deck1,deck2));
    }

    @Test
    void drawCard() {

    }

    @Test
    void getRemainingCards() {
    }

    @Test
    void getDeckSize() {
        Deck deck = new Deck();
        assertEquals(100,deck.getDeckSize());
    }

    @Test
    void iterator() {
    }
}