package com.sde_uno.unocardgame.model;

import com.sde_uno.unocardgame.controller.GameModerator;

import java.util.List;
import java.util.Scanner;

public class GamePlay extends GameModerator {

    static Scanner scanner = new Scanner(System.in);
    public static String cardToPlayPlayer;
    public static String cardToPlayComputer;

    //**********PLAYER MOVES**********

    //Begins operations for a normal player move in Uno.
    public static void playerMove(Deck deck) {

        //Check to see if the game is over.
        if (playerHand.size() == 0 || computerHand.size() ==0) {
            endGame();
        }

        //print needed user data.
        System.out.println("\n");
        System.out.println("Your Cards: " + playerHand);
        System.out.println("Playable Card: " + playableCard);

        //clarify the state of color after a wild card play.
        if (playableCard.contains("WILD")) {
            System.out.println("The play color is: " + playableColorState);
        }

        //asks user to play a card and grabs that card data.
        System.out.println("Please enter the card you would like to play OR enter DRAW.");
        cardToPlayPlayer = scanner.nextLine();
        System.out.println(cardToPlayPlayer);

        //check to see if card is playable via discard pile and hand. if so, analyses card type and acts accordingly.
        if (playerCardPlayable(deck) && playerCardInHand(deck)) {
            playPlayerCard(deck);
            if (cardToPlayPlayer.contains("SKIP")) {
                System.out.println("You played a skip! its your turn again.");
                playerMove(deck);
            } else if (cardToPlayPlayer.contains("DRAWTWO")) {
                drawCard(computerHand, deck);
                drawCard(computerHand, deck);
                System.out.println("You played a DRAWTWO. The computer has drawn and it is your turn again.");
                playerMove(deck);
                //TODO: optional, make an if size = 1 and run a "CALL UNO!" option.
            } else if (cardToPlayPlayer.equals("DRAW")) {
                drawCard(playerHand, deck);
                System.out.println("You have Drawn a card.");
                computerMove(deck);
            } else {
                computerMove(deck);
            }
        }
    }

    //check to see if the proposed player card is playable via the discard pile.
    public static boolean playerCardPlayable(Deck deck) {
        boolean playable = false;
        if (cardToPlayPlayer.contains(playableColorState) || cardToPlayPlayer.contains(playableSymbolState)) {
            playable = true;
        } else if (cardToPlayPlayer.contains("DRAW") || cardToPlayPlayer.contains("WILD")){
            playable = true;
        } else {
            System.out.println("Sorry, you cant play that. if you don't have a playable card, please enter DRAW");
            playerMove(deck);
        }
        return playable;
    }

    //checks to see that the proposed player card exists in the players hand.
    public static boolean playerCardInHand(Deck deck) {
        boolean cardInHand = false;
        if (playerHand.stream().anyMatch(card -> ((card.equals(cardToPlayPlayer))))) {
            cardInHand = true;
        } else {
            System.out.println("You don't have that card in your hand!");
            playerMove(deck);
        }
        return cardInHand;
    }

    //plays the proposed play card
    public static void playPlayerCard(Deck deck) {
        handleCardInHandPlayer();
        if (cardToPlayPlayer.equals("WILD") || cardToPlayPlayer.equals("WILDDRAWFOUR")) {
            handleCardInHandPlayer();
            handlePlayerWildCards(deck);
        } else {
            handleCardInHandPlayer();
        }
    }

    //handles the card by adding it to the discard pile, assigning new play state, and removing card form hand.
    public static void handleCardInHandPlayer() {
        for (String card: playerHand) {
            if (card.equals(cardToPlayPlayer)) {
                int index = playerHand.indexOf(card);
                discardPile.add(playerHand.get(index));
                assignPlayableCardState(playerHand.get(index));
                removeSpecificCard(index, playerHand);
                break;
            }
        }
    }

    //handles WILD cards, asks for new color and updates play color state.
    public static void handlePlayerWildCards(Deck deck) {
        if (cardToPlayPlayer.equals("WILD")) {
            System.out.println("You've played a WILDCARD! please choose a color: ");
            playableColorState = scanner.nextLine();
        } else if (cardToPlayPlayer.equals("WILDDRAWFOUR")) {
            System.out.println("You've played a WILDDRAWFOUR! please choose a color: ");
            playableColorState = scanner.nextLine();
            for (int i = 1; i < 5; i++) {
                drawCard(computerHand, deck);
            }
        }
    }

    //**********COMPUTER MOVES**********

    //Begins operations for a normal computer move in Uno.
    public static void computerMove(Deck deck) {

        //Check to see if the game is over.
        if (playerHand.size() == 0 || computerHand.size() ==0) {
            endGame();
        }

        //print out needed user data
        System.out.println("It is the Computers Move... \n");
        //System.out.println("Comp Cards: " + computerHand);     //used for testing
        System.out.println("\n");
        System.out.println("Playable Card: " + playableCard);

        //clarify the state of color after a wild card play.
        if (playableCard.contains("WILD")) {
            System.out.println("The play color is: " + playableColorState);
        }

        //checks if computer has playable card. If so, play it, if not, draw.
        if (compHandPlayable()) {
            playCompCard(deck);
            if (cardToPlayComputer.contains("SKIP")) {
                System.out.println("The Computer skipped you and gets to go again.");
                computerMove(deck);
            } else if (cardToPlayComputer.contains("DRAWTWO")) {
                drawCard(playerHand, deck);
                drawCard(playerHand, deck);
                System.out.println("The Computer played a DRAWTWO. you Draw 2 and it is the Computers turn again.");
                computerMove(deck);
                //TODO: optional, make an if size = 1 and run a "CALL UNO!" option.
            } else {
                playerMove(deck);
            }
        } else {
            drawCard(computerHand, deck);
            System.out.println("The computer drew a card.");
            playerMove(deck);
        }
    }

    //checks the computer hand to ensure it has any playable card
    public static boolean compHandPlayable() {
        return computerHand.stream()
                .anyMatch(card -> ((card.contains(playableColorState) || card.contains(playableSymbolState))) || card.contains("WILD"));
    }

    //finds the first playable card in the comp hand and plays it
    public static void playCompCard(Deck deck) {
        cardToPlayComputer = computerHand.stream()
                .filter(card -> ((card.contains(playableColorState) || card.contains(playableSymbolState))) || card.contains("WILD"))
                .findFirst().get();
        if (cardToPlayComputer.equals("WILD") || cardToPlayComputer.equals("WILDDRAWFOUR")) {
            handleCardInHandComputer();
            handleCompWildCards(deck);
        } else {
            handleCardInHandComputer();
            System.out.println("The Computer played: " + cardToPlayComputer);
        }
    }

    //handles the card by adding it to the discard pile, assigning new play state, and removing card form hand.
    public static void handleCardInHandComputer() {
        for (String card: computerHand) {
            if (card.equals(cardToPlayComputer)) {
                int index = computerHand.indexOf(card);
                discardPile.add(computerHand.get(index));
                assignPlayableCardState(computerHand.get(index));
                removeSpecificCard(index, computerHand);
                break;
            }
        }
    }

    //handles WILD cards, uses rng to choose new color and updates play color state.
    public static void handleCompWildCards(Deck deck) {
        int randomNum = (int) (Math.random() * 4);

        if (cardToPlayComputer.equals("WILD")) {
            playableColorState = String.valueOf(Color.values()[randomNum]);
            System.out.println("The Computer played: " + cardToPlayComputer);
        } else if (cardToPlayComputer.equals("WILDDRAWFOUR")) {
            playableColorState = String.valueOf(Color.values()[randomNum]);
            for (int i = 1; i < 5; i++) {
                drawCard(playerHand, deck);
            }
            System.out.println("The Computer played: " + cardToPlayComputer);
            System.out.println("The computer played a WILDDRAWFOUR. You drew 4 cards.");
        }
    }

    //ADDITIONAL METHODS

    //removes a specific card form a deck via index number
    public static void removeSpecificCard(int index, List list) {
        list.remove(index);
    }

    //draws a card from a deck.
    public static void drawCard(List playerHand, Deck deck) {
        Card drawnCard = deck.draw();
        deck.removeCard();
        playerHand.add(String.valueOf(drawnCard));
    }

    //end game logic.
    public static void endGame() {
        if(playerHand.size() == 0) {
            System.out.println("CONGRATS! You've won the game!");
        } else {
            System.out.println("The computer has won. Better luck next time!");
        }
        System.out.println("Would you like to Play again? (Y/N)");
        String playAgain = scanner.nextLine();
        if (playAgain.equals("Y")) {
            play();
        } else {
            System.out.println("Thanks for playing!");
            overallGameState = false;
        }
    }







}
