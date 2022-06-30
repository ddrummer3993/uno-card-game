package com.sde_uno.unocardgame;

import com.sde_uno.unocardgame.controller.GameModerator;
import com.sde_uno.unocardgame.model.Card;
import com.sde_uno.unocardgame.model.Deck;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class PlayUno {

    public static void main(String[] args) {

        //Actual Program - Play Uno

        //TODO create testing file and begin to create test methods.

        //Create test deck
        Deck deckTest = new Deck();
        System.out.println("The New Deck of Uno Cards: " + deckTest);

        //Ensure Deck has 100 cards
        if (deckTest.getDeckSize() != 100) {
            System.out.println("Incomplete deck of cards");
        } else {
            System.out.println("The deck has complete number of cards");
        }

        //Begin game via GameModerator
        GameModerator.play();

        //TODO determine first player, begin turn.
        GameModerator moderator = new GameModerator();
        //TODO prompt player to play card or draw.
        //TODO If playing a card, check to make sure card is playable
        //TODO if playable, check for additional action and implement.
        //TODO if drawing a card, draw card and adjust hand accordingly.
        //TODO end current players turn, begin next players turn.
        //TODO TEST ALL ABOVE CODE.

        //TODO OPTIONAL: implement yell "UNO" option

        //TODO implement player to play last remaining card in hand wins
        //TODO prompt player to play again.

    }
}
