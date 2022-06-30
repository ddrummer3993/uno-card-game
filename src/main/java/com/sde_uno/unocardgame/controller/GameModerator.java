package com.sde_uno.unocardgame.controller;

import com.sde_uno.unocardgame.PlayUno;
import com.sde_uno.unocardgame.model.*;

import java.util.ArrayList;
import java.util.List;

//GameModerator sets up the Uno game, decides who goes first, and controls State for the game.
public class GameModerator extends PlayUno {

    public static final List<String> discardPile = new ArrayList<>();
    public static final List<String> playerHand = new ArrayList<>();
    public static final List<String> computerHand = new ArrayList<>();
    static int randNum = (Math.random() <= 0.5) ? 1 : 2;

    //State Variables
    public static String playableColorState;
    public static String playableSymbolState;
    public static String playableCard;
    public static State playerState;

    //play method begins play functions for game
    public static void play() {

        //create game deck
        Deck deck = new Deck();

        //Shuffle the Deck.
        deck.shuffle();

        //reset hands and discard pile
        playerHand.clear();
        computerHand.clear();
        discardPile.clear();

        //Deal 7 cards to each player, alternating as you deal.
        deal(deck);

        //flips top card and assigns it to playable color and symbol state.
        flipFirstCard(deck);

        System.out.println("LET THE UNO GAME BEGIN!");

        //Game Moderator randomly decides who goes first
        if (randNum == 1) {
            playerState = State.PLAYER_ONE_MOVE;
        } else if (randNum == 2) {
            playerState = State.COMPUTER_MOVE;
        }
        System.out.println("TURN: " + playerState + "\n");

        if(playerState == State.PLAYER_ONE_MOVE) {
            GamePlay.playerMove(deck);
        } else {
            GamePlay.computerMove(deck);
        }
    }

    //Deals 7 cards to player, 7 cards to computer, alternating cards as it deals
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
    }

    //Flips first card over FROM draw pile TO discard pile. assigns and removes card accordingly.
    public static void flipFirstCard(Deck deck) {
        playableCard = String.valueOf(deck.draw());
        deck.removeCard();
        discardPile.add(String.valueOf(playableCard));

        assignPlayableCardState(String.valueOf(playableCard));
        if (playableCard.contains("WILD")) {
            int randomNum = (int) (Math.random() * 4);
            playableColorState = String.valueOf(Color.values()[randomNum]);
        }
    }

    //given any card, assigns the playable state to that cards color and symbol
    public static void assignPlayableCardState(String card) {
        List<String> thisCard = new ArrayList<>();
        for (String str: String.valueOf(card).split(" ")) {
            thisCard.add(str);
        }
        if (thisCard.get(0).equals("WILD") || thisCard.get(0).equals("WILDDRAWFOUR")) {
            playableSymbolState = thisCard.get(0);
       }else {
            playableSymbolState = thisCard.get(1);
        }
        playableColorState = thisCard.get(0);
        playableCard = card;
    }


}
