package com.sde_uno.unocardgame;

import com.sde_uno.unocardgame.model.Card;
import com.sde_uno.unocardgame.model.Deck;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class PlayUno {

    public static void main(String[] args) {

        final List<String> discardPile = new ArrayList<>();
        final List<String> playerHand = new ArrayList<>();
        final List<String> computerHand = new ArrayList<>();



        //TEST TEST TEST
        Deck deck = new Deck();
        System.out.println(deck);
        deck.shuffle();
        Card myCard = deck.draw();
        System.out.println(deck.getDeckSize());
        System.out.println(deck);
        System.out.println(myCard);


        //Actual Program - Play Uno

        //TODO create testing file and begin to create test methods.
        //TODO call instance of Deck, ensure our deck has 100 cards, and shuffle Deck.

        Deck unoDeck = new Deck();

        if (unoDeck.getDeckSize() != 100) {
            System.out.println("Incomplete deck of cards");
        } else {
            System.out.println("The deck has complete number of cards");
        }
        unoDeck.shuffle();



        //TODO deal each player 7 cards (alternating).


        //TODO flip top card of draw pile and create discard pile.



    //TODO assign top card in discard to playable game state.
        //TODO assign "dealer" status to one player, other player has first turn.
        //TODO TEST ABOVE CODE. should have 4 lists w/ appropriate numbers of cards.

        //TODO determine first player, begin turn.
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
