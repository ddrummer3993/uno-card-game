package com.sde_uno.unocardgame.model;

import com.sde_uno.unocardgame.controller.GameModerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlay extends GameModerator {

    static Scanner scanner = new Scanner(System.in);
    public static String playedCardString;
    public static String playedColor;
    public static String playedSymbol;
    public static Card playedCard;

    public static void playerMove(Deck deck) {

        System.out.println("Your Cards: " + playerHand);
        System.out.println("Playable Card: " + playableCard);
        System.out.println(playableColorState);
        System.out.println(playableSymbolState);
        if (playableCard.contains("WILD")) {
            System.out.println("The play color is: " + playableColorState);
        }

        System.out.println("Please enter the card you would like to play OR enter DRAW.");
        playedCardString = scanner.nextLine();

        System.out.println(playedCardString);

        //compare the played card with color/symbol state and see if it can be played.
        if (playedCardString.contains(playableColorState) || playedCardString.contains(playableSymbolState)) {
            handleCardInHand();
            playerMove(deck);
        } else if (playedCardString.contains("WILD")) {
            handleCardInHand();
            handleWildCards(deck);
        } else {
            System.out.println("Sorry, you cant play that. if you don't have a playable card, please enter DRAW");
        }


//        List<String> proposedCard = new ArrayList<>();
//        for (String str: playedCardString.split(" ")) {
//            proposedCard.add(str);
//        }
//
//        if (proposedCard.get(0).equals(playableColorState)) {
//            handleCardInHand();
//
//        }





        //test the proposed card against
//        for (Object card: playerHand) {
//            if(dissectCardColor((Card) card).equals(proposedCard.get(0))) {
//                assignPlayedCardState((Card) card);
//            } else if(dissectCardSymbol((Card) card).equals(proposedCard.get(1))) {
//                assignPlayedCardState((Card) card);
//            } else if (String.valueOf(card).equals("WILD") || String.valueOf(card).equals("WILDDRAW4")) {
//                assignPlayedCardState((Card) card);
//            } else if (String.valueOf(card).equals("DRAW")) {
//                drawCard(playerHand, deck);
//
//
//            }else {
//                System.out.println("Sorry, you cant play that. if you don't have a playable card, please enter DRAW");
//            }
//        }
    }

    public static void computerMove() {

    }

    //TODO: card actions for skip and draw two.
    //TODO: figure out "you dont have that card" message.
    public static void handleCardInHand() {
        for (String card: playerHand) {
            if (card.equals(playedCardString)) {
                int index = playerHand.indexOf(card);
                discardPile.add(playerHand.get(index));
                assignPlayableCardState(playerHand.get(index));
                removeSpecificCard(index, playerHand);
                break;
            }
        }
    }

    public static void handleWildCards(Deck deck) {
        if (playedCardString.equals("WILD")) {
            System.out.println("You've played a WILDCARD! please choose a color: ");
            playableColorState = scanner.nextLine();
        } else if (playedCardString.equals("WILDDRAW4")) {
            System.out.println("You've played a WILDDRAW4! please choose a color: ");
            playableColorState = scanner.nextLine();
            for (int i = 1; i < 5; i++) {
                if (playerState.equals(State.PLAYER_ONE_MOVE)) {
                    drawCard(computerHand, deck);
                } else {
                    drawCard(playerHand, deck);
                }
            }
        }
    }

    public static void removeSpecificCard(int index, List list) {
        list.remove(index);
    }

    public static void drawCard(List playerHand, Deck deck) {
        Card drawnCard = deck.draw();
        deck.removeCard();
        playerHand.add(String.valueOf(drawnCard));
    }

//    public static String dissectCardColor(Card card) {
//        List<String> thisCard = new ArrayList<>();
//        for (String str: String.valueOf(card).split(" ")) {
//            thisCard.add(str);
//        }
//        return thisCard.get(0);
//    }
//
//    public static String dissectCardSymbol(Card card) {
//        List<String> thisCard = new ArrayList<>();
//        for (String str: String.valueOf(card).split(" ")) {
//            thisCard.add(str);
//        }
//        return thisCard.get(1);
//    }

//    public static void assignPlayedCardState(List proposedCard) {
//        if (proposedCard.get(1).equals("WILD") || proposedCard.get(1).equals("WILDDRAW4")) {
//            playedColor = (String) proposedCard.get(1);
//            playedSymbol = (String) proposedCard.get(1);
//            playedCard = card;
//        }else {
//            playedColor = thisCard.get(0);
//            playedSymbol = thisCard.get(1);
//            playedCard = card;
//        }
//    }

}
