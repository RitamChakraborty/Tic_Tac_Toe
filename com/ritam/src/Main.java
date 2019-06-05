package _Play_Ground.Tic_Tac_Toe.com.ritam.src;

import _Play_Ground.Tic_Tac_Toe.com.ritam.src.data.Table;
import _Play_Ground.Tic_Tac_Toe.com.ritam.src.two_players.TwoPlayers;
import _Play_Ground.Tic_Tac_Toe.com.ritam.src.vs_com.VsCom;

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
            int choice;
            Table.clearTable();

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
