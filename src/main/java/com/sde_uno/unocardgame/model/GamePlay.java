package com.sde_uno.unocardgame.model;

import com.sde_uno.unocardgame.controller.GameModerator;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;
import java.util.Scanner;

public class GamePlay extends GameModerator {

    public static void playerMove(List playerHand, List discardPile,Deck deck) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your Cards: " + playerHand);
        System.out.println(playableCard);

        System.out.println("Please enter the card you would like to play OR enter DRAW.");
        scanner.nextLine();
    }

    public static void computerMove() {

    }


}
