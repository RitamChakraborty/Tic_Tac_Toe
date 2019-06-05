package _Play_Ground.Tic_Tac_Toe.com.ritam.src.two_players;

import _Play_Ground.Tic_Tac_Toe.Game;
import _Play_Ground.Tic_Tac_Toe.com.ritam.src.data.Table;

import java.util.Scanner;

public class TwoPlayers extends Game {
    private Scanner scanner;

    {
        scanner = new Scanner(System.in);
    }

    public TwoPlayers() {
        System.out.println("Welcome to 2 players game mode");
        Table.clearTable();

        while (true) {
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
    }

    @Override
    public void startGame(char w1, char w2) {
        System.out.println("\nLet's start the game...\n");
        Table.printTable();

        System.out.println("Rules:");
        System.out.println("\tEnter the row followed by the column " +
                "\n\tnumber seperated by a space(' ') " +
                "\n\tfor you want to place your warrior\n");
    }
}
