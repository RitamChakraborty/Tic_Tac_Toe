package _Play_Ground.Tic_Tac_Toe.com.ritam.src;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    private static void twoPlayers() {
        System.out.println("Welcome to 'Two Players' game mode");
    }

    private static void vsCom() {
        System.out.println("Welcome to 'Vs Computer' game mode");
    }

    public static void main(String[] args) {
        System.out.println("\t\t***** Tic-Tac-Toe *****");
        System.out.println("(Enter '0' at any input to quit game anytime)");
        while (true) {
            int choice;

            System.out.println("Choose game mode...");
            System.out.println("\t1. 2 Players");
            System.out.println("\t2. Vs Computer");
            System.out.println("Enter your choice");
            choice = scanner.nextInt();

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
