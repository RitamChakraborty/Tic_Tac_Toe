package _Play_Ground.Tic_Tac_Toe.com.ritam.src.vs_com;

import java.util.Scanner;

public class VsCom {
    private Scanner scanner;

    { scanner = new Scanner(System.in); }

    public VsCom() {
        System.out.println("Welcome to Vs Computer game mode");

        while (true) {
            String choice;

            System.out.println("Choose your warrior (O/X): ");
            choice = scanner.next();

            switch (choice) {
                case "X":
                case "x":
                    System.out.println("Computer will play with 'O'");
                    break;
                case "O":
                case "o":
                    System.out.println("Computer will play with 'X'");
                    break;
                case "0":
                    System.exit(3);
                default:
                    System.out.println("UNKNOWN INPUT!");
            }
        }
    }
}
