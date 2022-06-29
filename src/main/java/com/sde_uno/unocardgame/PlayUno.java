package com.sde_uno.unocardgame;

import com.sde_uno.unocardgame.controller.GameModerator;
import com.sde_uno.unocardgame.model.Card;
import com.sde_uno.unocardgame.model.Deck;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class PlayUno {

    final List<String> discardPile = new ArrayList<>();
    final static List<String> playerHand = new ArrayList<>();
    final static List<String> computerHand = new ArrayList<>();

    public static void main(String[] args) {

        //State Variables
        String playableColorState;
        String playableSymbolState;


        //Actual Program - Play Uno

        PlayUno unoGame = new PlayUno();

        //TODO create testing file and begin to create test methods.

        //Create Deck
        Deck deck = new Deck();
        System.out.println("The New Deck of Uno Cards: " + deck);

        //Ensure Deck has 100 cards
        if (deck.getDeckSize() != 100) {
            System.out.println("Incomplete deck of cards");
        } else {
            System.out.println("The deck has complete number of cards");
        }

        //Shuffle the Deck.
        deck.shuffle();
        System.out.println("SHUFFLED: " + deck);



        //Deal 7 cards to each player, alternating as you deal.
        unoGame.deal(deck);


        //TODO flip top card of draw pile and create discard pile.
        //TODO assign top card in discard to playable game state.
        unoGame.startGame(deck);
        //TODO assign "dealer" status to one player, other player has first turn.
        //TODO TEST ABOVE CODE. should have 4 lists w/ appropriate numbers of cards.

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

    public static void deal(Deck deck) {
        int hand = 1;
        for (int i = 1; i < 15; i++) {
            Card drawnCard = deck.draw();
            deck.removeCard();
            if (hand == 1) {
                playerHand.add(String.valueOf(drawnCard));
                hand = 2;
            } else {
                computerHand.add(String.valueOf(drawnCard));
                hand = 1;
            }
        }
        System.out.println("DECK: " + deck);
        System.out.println(deck.getDeckSize());
        System.out.println("PLAYER HAND: " + playerHand);
        System.out.println("COMP HAND: " + computerHand);
    }

    public void startGame(Deck deck) {

    }

}
