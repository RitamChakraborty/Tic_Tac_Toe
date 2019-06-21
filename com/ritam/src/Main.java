package com.ritam.src;

import com.ritam.src.data.Table;
import com.ritam.src.two_players.TwoPlayers;
import com.ritam.src.vs_com.VsCom;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    private static void twoPlayers() {
        TwoPlayers twoPlayers = new TwoPlayers();
    }

    private static void vsCom() {
        VsCom vsCom = new VsCom();
    }

    public static void main(String[] args) {
        System.out.println("\t\t***** Tic-Tac-Toe *****");
        System.out.println("(Enter '0' at any input to quit game anytime)");

        while (true) {
            Table.clearTable();

            int choice = 0;
            boolean rightInput = false;

            while (!rightInput) {
                System.out.println("Choose game mode...");
                System.out.println("\t1. 2 Players");
                System.out.println("\t2. Vs Computer");
                System.out.println("Enter your choice: ");
                String input = scanner.next();

                if (input.equals("1") || input.equals("2")) {
                    choice = Integer.parseInt(input);
                    rightInput = true;
                } else {
                    System.out.println("UNKNOWN INPUT!");
                }
            }

            switch (choice) {
                case 1:
                    twoPlayers();
                    break;
                case 2:
                    vsCom();
                    break;
                case (int) 0:
                    System.exit(1);
                default:
                    System.out.println("UNKNOWN INPUT!");

            }
        }
    }
}
