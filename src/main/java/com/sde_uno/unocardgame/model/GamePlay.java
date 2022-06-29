package com.sde_uno.unocardgame.model;

import com.sde_uno.unocardgame.controller.GameModerator;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;
import java.util.Scanner;

public class GamePlay extends GameModerator {

    public static void playerMove(List playerHand, List discardPile, Deck deck) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your Cards: " + playerHand);
        System.out.println(playableCard);

        System.out.println("Please enter the card you would like to play OR enter DRAW.");
        scanner.nextLine();
    }


    public static void computerMove() {
        System.out.println("Computer cards: " + computerHand);
        System.out.println(playableCard);

        if (isWilCard()) {
            //TODO Wild stuff!
        }

        if (handHasPlayableCard()) {
            playHand();
        } else {
            System.out.println("Computer hand to cards to play in hand. So Drawing a new card from deck....");
            //TODO I need access to Deck here. Design doesn't allow that

        }

    }

    public static boolean handHasPlayableCard() {
        return computerHand.stream()
                .anyMatch(card -> (card.contains(playableCard.getColor().name()) || card.contains(playableCard.getSymbol().name())));
    }

    public static void playHand() {
        String cardToPlay = computerHand.stream()
                .filter(card -> (card.contains(playableCard.getColor().name()) || card.contains(playableCard.getSymbol().name())))
                .findFirst().get();
        System.out.println("Computer Card played: " + cardToPlay);
        computerHand.remove(cardToPlay);
        discardPile.add(cardToPlay);
    }

    public static boolean isWilCard() {
        return !playableCard.isPlayable();
    }

}
