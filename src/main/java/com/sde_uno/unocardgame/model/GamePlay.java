package com.sde_uno.unocardgame.model;

import com.sde_uno.unocardgame.controller.GameModerator;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GamePlay extends GameModerator {

    static Scanner scanner = new Scanner(System.in);
    public static String cardToPlayPlayer;
    public static String cardToPlayComputer;
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
        cardToPlayPlayer = scanner.nextLine();

        System.out.println(cardToPlayPlayer);

        //compare the played card with color/symbol state and see if it can be played.
        if (cardToPlayPlayer.contains(playableColorState) || cardToPlayPlayer.contains(playableSymbolState)) {
            handleCardInHandPlayer();
            computerMove(deck);
        } else if (cardToPlayPlayer.contains("WILD")) {
            handleCardInHandPlayer();
            handleWildCards(deck);
            computerMove(deck);
        } else if (cardToPlayPlayer.equals("DRAW")) {
            drawCard(playerHand, deck);
            computerMove(deck);
        } else {
            System.out.println("Sorry, you cant play that. if you don't have a playable card, please enter DRAW");
        }
    }

    public static void computerMove(Deck deck) {

        System.out.println("It is the Computers Move...");

        System.out.println("Comp Cards: " + computerHand);
        System.out.println("Playable Card: " + playableCard);
        System.out.println(playableColorState);
        System.out.println(playableSymbolState);
        if (playableCard.contains("WILD")) {
            System.out.println("The play color is: " + playableColorState);
        }

        //see if computer has playable card, if so play it, if not, draw.
        if (compHandPlayable()) {
            playCompHand(deck);
            playerMove(deck);
        } else {
            drawCard(computerHand, deck);
            System.out.println("The computer drew a card.");
            playerMove(deck);
        }

    }

    //TODO: card actions for skip and draw two.
    //TODO: figure out "you dont have that card" message.
    public static void handleCardInHandPlayer() {
        for (String card: playerHand) {
            if (card.equals(cardToPlayPlayer)) {
                int index = playerHand.indexOf(card);
                discardPile.add(playerHand.get(index));
                assignPlayableCardState(playerHand.get(index));
                removeSpecificCard(index, playerHand);
                //TODO if player hand is zero after removal, end game!
                break;
            }
        }
    }

    public static void handleWildCards(Deck deck) {
        if (cardToPlayPlayer.equals("WILD")) {
            System.out.println("You've played a WILDCARD! please choose a color: ");
            playableColorState = scanner.nextLine();
        } else if (cardToPlayPlayer.equals("WILDDRAW4")) {
            System.out.println("You've played a WILDDRAW4! please choose a color: ");
            playableColorState = scanner.nextLine();
            for (int i = 1; i < 5; i++) {
                drawCard(computerHand, deck);
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

    public static boolean compHandPlayable() {
        return computerHand.stream()
                .anyMatch(card -> ((card.contains(playableColorState) || card.contains(playableSymbolState))) || card.contains("WILD"));
    }

    public static void playCompHand(Deck deck) {
        cardToPlayComputer = computerHand.stream()
                .filter(card -> ((card.contains(playableColorState) || card.contains(playableSymbolState))) || card.contains("WILD"))
                        .findFirst().get();
        if (cardToPlayComputer.equals("WILD") || cardToPlayComputer.equals("WILDDRAW4")) {
            handleCardInHandComputer();
            handleCompWildCards(deck);
            System.out.println("The Computer played: " + cardToPlayComputer);
        } else {
            handleCardInHandComputer();
            System.out.println("The Computer played: " + cardToPlayComputer);
        }
    }

    public static void handleCompWildCards(Deck deck) {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5);
        System.out.println(randomNum);

        if (cardToPlayComputer.equals("WILD")) {
            playableColorState = String.valueOf(Color.values()[randomNum]);
        } else if (cardToPlayComputer.equals("WILDDRAW4")) {
            playableColorState = String.valueOf(Color.values()[randomNum]);
            for (int i = 1; i < 5; i++) {
                drawCard(playerHand, deck);
            }
        }
    }

    public static void handleCardInHandComputer() {
        for (String card: computerHand) {
            if (card.equals(cardToPlayComputer)) {
                int index = computerHand.indexOf(card);
                discardPile.add(computerHand.get(index));
                assignPlayableCardState(computerHand.get(index));
                removeSpecificCard(index, computerHand);
                //TODO if player hand is zero after removal, end game!
                break;
            }
        }
    }

}
