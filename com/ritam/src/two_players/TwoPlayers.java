package _Play_Ground.Tic_Tac_Toe.com.ritam.src.two_players;

import java.util.Scanner;

public class TwoPlayers {
    private Scanner scanner;

    { scanner = new Scanner(System.in); }

    public TwoPlayers() {
        System.out.println("Welcome to 2 players game mode");

        while (true) {
            String choice;

            System.out.println("Choose warrior for Player 1 (O/X): ");
            choice = scanner.next();

            switch (choice) {
                case "X":
                case "x":
                    System.out.println("Player 2 will play with 'O'");
                    break;
                case "O":
                case "o":
                    System.out.println("Player 2 will play with X");
                    break;
                case "0":
                    System.exit(2);
                default:
                    System.out.println("UNKNOWN INPUT!");
            }
        }
    }
}
