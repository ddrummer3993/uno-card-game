package com.sde_uno.unocardgame;

import com.sde_uno.unocardgame.controller.GameModerator;
import com.sde_uno.unocardgame.model.Deck;

public class PlayUno {

    public static boolean overallGameState = true;

    //Main method will start the game of Uno in the console.
    public static void main(String[] args) {

        //Create test deck.
        System.out.println("****TEST DECK****");
        Deck deckTest = new Deck();
        System.out.println("Test Deck of Uno Cards: " + deckTest);
        deckTest.shuffle();
        System.out.println("SHUFFLED: " + deckTest);

        //Ensure Deck has 100 cards.
        if (deckTest.getDeckSize() != 100) {
            System.out.println("Incomplete deck of cards");
        } else {
            System.out.println("The deck has complete number of cards");
        }

        System.out.println("\n");

        //Begin game via GameModerator
        do {
            GameModerator.play();
        } while (overallGameState);

    }
}
