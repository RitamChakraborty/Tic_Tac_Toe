package _Play_Ground.Tic_Tac_Toe.com.ritam.src.vs_com;

import _Play_Ground.Tic_Tac_Toe.com.ritam.src.Game;
import _Play_Ground.Tic_Tac_Toe.com.ritam.src.data.Table;
import _Play_Ground.Tic_Tac_Toe.com.ritam.src.logic.Logic;

import java.util.Random;
import java.util.Scanner;

public class VsCom extends Game {
    private Scanner scanner;
    private boolean comFirst;

    {
        scanner = new Scanner(System.in);
        comFirst = false;
    }

    public VsCom() {
        System.out.println("Welcome to Vs Computer game mode");
        Table.clearTable();

        String choice;
        System.out.println("Choose who will take the first turn...");
        System.out.println("\t1. Player");
        System.out.println("\t2. Computer");
        System.out.println("Enter you choice: ");
        choice = scanner.next();

        if (choice.equals("2")) {
            comFirst = true;
        } else if (!choice.equals("1")) {
            System.out.println("UNKNOWN INPUT!");
        }

        System.out.println("Choose your warrior (O/X): ");
        choice = scanner.next();

        switch (choice) {
            case "X":
            case "x":
                System.out.println("Computer will play with 'O'");
                startGame('X', 'O');
                break;
            case "O":
            case "o":
                System.out.println("Computer will play with 'X'");
                startGame('O', 'X');
                break;
            case "0":
                System.exit(3);
            default:
                System.out.println("UNKNOWN INPUT!");
        }
    }

    @Override
    public void startGame(char w1, char w2) {
        System.out.println("\nLet's start the game...\n");
        Table.printTable();

        System.out.println("Rules:");
        System.out.println("\tEnter the row followed by the column " +
                "\n\tnumber separated by a space(' ') " +
                "\n\tfor you want to place your warrior\n");

        int choice;

        System.out.println("This mode have 3 levels...");
        System.out.println("\t1. Easy");
        System.out.println("\t2. Medium");
        System.out.println("\t3. Hard");
        System.out.println("Enter your choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                easy(w1, w2);
                break;
            case 2:
                medium(w1, w2);
                break;
            case 3:
                hard(w1, w2);
                break;
            default:
                System.out.println("UNKNOWN INPUT!");

        }
    }

    private int[] setWarrior() {
        int[] arr = new int[3];

        while (true) {
            int r = new Random().nextInt(3);
            int c = new Random().nextInt(3);

            if (Table.emptyPosition(r, c)) {
                arr[0] = r;
                arr[1] = c;

                return arr;
            }
        }
    }

    private void easy(char w1, char w2) {
        if (comFirst) {     // Computer will take the first turn
            int i = 0;
            int r = 0;
            int c = 0;

            while (true) {
                if (i % 2 == 0) {
                    System.out.println("Computer...");

                    int[] pos = setWarrior();
                    Table.setWarrior(pos[0], pos[1], w2);       // w2: computer
                    Table.printTable();

                    if (Table.foundWinner(w2)) {
                        gameOver("Computer");
                        break;
                    }

                    if (!Table.gameIsAlive()) {
                        System.out.println("Match is tied\n");
                        break;
                    }
                } else {
                    boolean validInput = false;
                    System.out.println("Player...");

                    while (!validInput) {
                        System.out.println("Enter position: ");
                        r = scanner.nextInt();
                        c = scanner.nextInt();

                        validInput = Table.setWarrior(r - 1, c - 1, w1);       // w1: Player
                    }

                    Table.printTable();

                    if (Table.foundWinner(w1)) {
                        gameOver("Player");
                        break;
                    }

                    if (!Table.gameIsAlive()) {
                        System.out.println("Match is tied\n");
                        break;
                    }
                }

                i++;
            }

        } else {        // Player will take the first turn
            int i = 0;
            int r = 0;
            int c = 0;

            while (true) {
                if (i % 2 == 0) {
                    boolean validInput = false;
                    System.out.println("Player...");

                    while (!validInput) {
                        System.out.println("Enter position: ");
                        r = scanner.nextInt();
                        c = scanner.nextInt();

                        validInput = Table.setWarrior(r - 1, c - 1, w1);       // w1: Player
                    }

                    Table.printTable();

                    if (Table.foundWinner(w1)) {
                        gameOver("Player");
                        break;
                    }

                    if (!Table.gameIsAlive()) {
                        System.out.println("Match is tied\n");
                        break;
                    }
                } else {
                    System.out.println("Computer...");

                    int[] pos = setWarrior();
                    Table.setWarrior(pos[0], pos[1], w2);       // w2: computer
                    Table.printTable();

                    if (Table.foundWinner(w2)) {
                        gameOver("Computer");
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
    }

    private void medium(char w1, char w2) {
        if (comFirst) {     // Computer will take the first turn
            int i = 0;
            int r = 0;
            int c = 0;

            while (true) {
                if (i % 2 == 0) {
                    System.out.println("Computer...");

                    if (Table.isEmpty()) {
                        int[] pos = setWarrior();
                        Table.setWarrior(pos[0], pos[1], w2);       // w2: computer
                    } else {
                        boolean defaultCase = Logic.winningLogic(w2);

                        // Else
                        if (defaultCase) {
                            System.out.println("Else");
                            int[] pos = setWarrior();
                            Table.setWarrior(pos[0], pos[1], w2);
                        }
                    }

                    Table.printTable();

                    if (Table.foundWinner(w2)) {
                        gameOver("Computer");
                        break;
                    }

                    if (!Table.gameIsAlive()) {
                        System.out.println("Match is tied\n");
                        break;
                    }
                } else {
                    boolean validInput = false;
                    System.out.println("Player...");

                    while (!validInput) {
                        System.out.println("Enter position: ");
                        r = scanner.nextInt();
                        c = scanner.nextInt();

                        validInput = Table.setWarrior(r - 1, c - 1, w1);       // w1: Player
                    }

                    Table.printTable();

                    if (Table.foundWinner(w1)) {
                        gameOver("Player");
                        break;
                    }

                    if (!Table.gameIsAlive()) {
                        System.out.println("Match is tied\n");
                        break;
                    }
                }

                i++;
            }
        } else {        // Player will take the first turn

        }
    }

    private void hard(char w1, char w2) {
        System.out.println("Welcome to hard mode");
    }

    private void gameOver(String s) {
        System.out.println(s + " has own the match!");
    }
}
