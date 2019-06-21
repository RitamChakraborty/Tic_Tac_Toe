package com.ritam.src.two_players;

import com.ritam.src.Game;
import com.ritam.src.data.Table;

import java.util.Scanner;

public class TwoPlayers extends Game {
    private Scanner scanner;

    {
        scanner = new Scanner(System.in);
    }

    public TwoPlayers() {
        System.out.println("Welcome to 2 players game mode");
        String choice;

        System.out.println("Choose warrior for Player 1 (O/X): ");
        choice = scanner.next();

        switch (choice) {
            case "X":
            case "x":
                System.out.println("Player 2 will play with 'O'");
                startGame('X', 'O');
                break;
            case "O":
            case "o":
                System.out.println("Player 2 will play with X");
                startGame('O', 'X');
                break;
            case "0":
                System.exit(2);
            default:
                System.out.println("UNKNOWN INPUT!");
        }
    }

    private void takeInput(char w) {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Enter position: ");
            String rowInput = scanner.next();
            String colInput = scanner.next();

            if ((rowInput.equals("1") || rowInput.equals("2") || rowInput.equals("3"))
                    && (colInput.equals("1") || colInput.equals("2") || colInput.equals("3"))) {
                int r = Integer.parseInt(rowInput);
                int c = Integer.parseInt(colInput);
                validInput = Table.setWarrior(r - 1, c - 1, w);
            } else {
                System.out.println("UNKNOWN INPUT!");
            }

        }
    }

    @Override
    public void startGame(char w1, char w2) {
        System.out.println("\nLet's start the game...\n");
        Table.printTable();

        System.out.println("Rules:");
        System.out.println("\tEnter the row followed by the column " +
                "\n\tnumber seperated by a space(' ') " +
                "\n\tfor you want to place your warrior\n");

        int i = 0;
        int r = 0;
        int c = 0;

        while (true) {
            if (i % 2 == 0) {
                boolean validInput = false;
                System.out.println("Player 1...");

                takeInput(w1);

                Table.printTable();

                if (Table.foundWinner(w1)) {
                    gameOver("Player 1");
                    break;
                }

                if (!Table.gameIsAlive()) {
                    System.out.println("Match is tied\n");
                    break;
                }
            } else {
                boolean validInput = false;
                System.out.println("Player 2...");

                takeInput(w2);

                Table.printTable();

                if (Table.foundWinner(w2)) {
                    gameOver("Player 2");
                    break;
                }

                if (!Table.gameIsAlive()) {
                    System.out.println("Match is tied\n");
                    break;
                }
            }

            i++;
        }

    }

    private void gameOver(String player) {
        System.out.println(player + " has own the match\n");
    }
}
