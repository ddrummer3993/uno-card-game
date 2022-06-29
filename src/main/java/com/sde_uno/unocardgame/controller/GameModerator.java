package com.sde_uno.unocardgame.controller;

import com.sde_uno.unocardgame.model.Card;
import com.sde_uno.unocardgame.model.Deck;
import com.sde_uno.unocardgame.model.GamePlay;
import com.sde_uno.unocardgame.model.State;

import java.util.ArrayList;
import java.util.List;

public class GameModerator {

    static final List<String> discardPile = new ArrayList<>();
    static final List<String> playerHand = new ArrayList<>();
    static final List<String> computerHand = new ArrayList<>();

    static int randNum = (Math.random() <= 0.5) ? 1 : 2;

    //State Variables
    public static String playableColorState;
    public static String playableSymbolState;
    public static Card playableCard;

    public static State playerState;
    public static boolean overallGameState;


    public static void play(Deck deck) {

        overallGameState = true;
        //Deal 7 cards to each player, alternating as you deal.
        deal(deck);

        //flips top card and assigns it to playable color and symbol state.
        flipFirstCard(deck);

        //Game Moderator randomly decides who goes first

        if (randNum == 1) {
            playerState = State.PLAYER_ONE_MOVE;
        } else if (randNum == 2) {
            playerState = State.COMPUTER_MOVE;
        }
        System.out.println("THIS PLAYERS TURN: " + playerState);

        while (overallGameState != false) {
            if(playerState == State.PLAYER_ONE_MOVE) {
                GamePlay.playerMove(playerHand, discardPile, deck);
            } else {
                GamePlay.computerMove();
            }
        }


        //TODO determine if need new method for determining player state, and then call play method, or determine player state inside class and then use in method.

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

    public static void flipFirstCard(Deck deck) {
        playableCard = deck.draw();
        deck.removeCard();
        discardPile.add(String.valueOf(playableCard));

        System.out.println("First flipped card : " + playableCard);
        System.out.println("Discard pile: " + discardPile);
        System.out.println("Draw Pile: " + deck);

        assignPlayableCardState(playableCard);
        System.out.println("PLAY COLOR: " + playableColorState);
        System.out.println("PLAY SYMBOL: " + playableSymbolState);
    }

    public static void assignPlayableCardState(Card card) {
        List<String> thisCard = new ArrayList<>();
        for (String str: String.valueOf(card).split(" ")) {
            thisCard.add(str);
        }
        playableColorState = thisCard.get(0);
        playableSymbolState = thisCard.get(1);
    }

}
