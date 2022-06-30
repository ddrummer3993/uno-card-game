package com.sde_uno.unocardgame.controller;

import com.sde_uno.unocardgame.model.*;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameModerator {

    public static final List<String> discardPile = new ArrayList<>();
    public static final List<String> playerHand = new ArrayList<>();
    public static final List<String> computerHand = new ArrayList<>();

    static int randNum = (Math.random() <= 0.5) ? 1 : 2;

    //State Variables
    public static String playableColorState;
    public static String playableSymbolState;
    public static String playableCard;

    public static State playerState;
    public static boolean overallGameState;


    public static void play() {

        Scanner scanner = new Scanner(System.in);

        overallGameState = true;
        String playAgain;

        //create game deck
        Deck deck = new Deck();

        //Shuffle the Deck.
        deck.shuffle();
        System.out.println("SHUFFLED: " + deck);

        //Deal 7 cards to each player, alternating as you deal.
        deal(deck);

        //flips top card and assigns it to playable color and symbol state.
        flipFirstCard(deck);

        System.out.println("LET THE GAME BEGIN!");

        //Game Moderator randomly decides who goes first

        if (randNum == 1) {
            playerState = State.PLAYER_ONE_MOVE;
        } else if (randNum == 2) {
            playerState = State.COMPUTER_MOVE;
        }
        System.out.println("THIS PLAYERS TURN: " + playerState);

        while (overallGameState) {
            if(playerState == State.PLAYER_ONE_MOVE) {
                GamePlay.playerMove(deck);
            } else {
                GamePlay.computerMove(deck);
            }
        }
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
        playableCard = String.valueOf(deck.draw());
        deck.removeCard();
        discardPile.add(String.valueOf(playableCard));

        System.out.println("First flipped card : " + playableCard);
        System.out.println("Discard pile: " + discardPile);
        System.out.println("Draw Pile: " + deck);

        assignPlayableCardState(String.valueOf(playableCard));
        if (playableCard.contains("WILD")) {
            int randomNum = (int) ((Math.random() * 4) + 1);
            playableColorState = String.valueOf(Color.values()[randomNum]);
        }
        System.out.println("PLAY COLOR: " + playableColorState);
        System.out.println("PLAY SYMBOL: " + playableSymbolState);
    }

    public static void assignPlayableCardState(String card) {
        List<String> thisCard = new ArrayList<>();
        for (String str: String.valueOf(card).split(" ")) {
            thisCard.add(str);
        }
        if (thisCard.get(0).equals("WILD") || thisCard.get(0).equals("WILDDRAW4")) {
            playableSymbolState = thisCard.get(0);
       }else {
            playableSymbolState = thisCard.get(1);
        }
        playableColorState = thisCard.get(0);
        playableCard = card;
    }


}
