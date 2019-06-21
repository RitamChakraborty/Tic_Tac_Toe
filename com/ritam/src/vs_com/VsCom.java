package com.ritam.src.vs_com;

import com.ritam.src.Game;
import com.ritam.src.data.Table;
import com.ritam.src.logic.Logic;

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

        boolean validInput = false;
        String choice;

        while (!validInput) {
            System.out.println("Choose who will take the first turn...");
            System.out.println("\t1. Player");
            System.out.println("\t2. Computer");
            System.out.println("Enter you choice: ");
            choice = scanner.next();

            if (choice.equals("2")) {
                validInput = true;
                comFirst = true;
            } else if (!choice.equals("1")) {
                System.out.println("UNKNOWN INPUT!");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Choose your warrior (O/X): ");
            choice = scanner.next();

            switch (choice) {
                case "X":
                case "x":
                    validInput = true;
                    System.out.println("Computer will play with 'O'");
                    startGame('X', 'O');
                    break;
                case "O":
                case "o":
                    validInput = true;
                    System.out.println("Computer will play with 'X'");
                    startGame('O', 'X');
                    break;
                case "0":
                    System.exit(3);
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
                "\n\tnumber separated by a space(' ') " +
                "\n\tfor you want to place your warrior\n");

        int choice;
        boolean validInput = false;

        System.out.println("This mode have 3 levels...");

        while (!validInput) {
            System.out.println("\t1. Easy");
            System.out.println("\t2. Medium");
            System.out.println("\t3. Hard");
            System.out.println("Enter your choice: ");
            String input = scanner.next();

            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        validInput = true;
                        easy(w1, w2);
                        break;
                    case 2:
                        validInput = true;
                        medium(w1, w2);
                        break;
                    case 3:
                        validInput = true;
                        hard(w1, w2);
                        break;
                    case 0:
                        System.exit(1);
                    default:
                        System.out.println("UNKNOWN INPUT!");

                }

                validInput = true;
            } else {
                System.out.println("UNKNOWN INPUT!");
            }
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

    private void takeUserInput(char w) {
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

    private void takeComputerInput(char w) {
        int[] pos = setWarrior();
        Table.setWarrior(pos[0], pos[1], w);
    }

    private boolean carryOnGame(char w, String winner) {
        Table.printTable();

        if (Table.foundWinner(w)) {
            gameOver(winner);
            return false;
        }

        if (!Table.gameIsAlive()) {
            System.out.println("Match is tied\n");
            System.out.println("-----------------------------------------------------------------------------------\n");
            return false;
        }

        return true;
    }

    private void easy(char w1, char w2) {
        if (comFirst) {     // Computer will take the first turn
            int i = 0;
            boolean continueGame = true;

            while (continueGame) {
                if (i % 2 == 0) {
                    System.out.println("Computer...");

                    takeComputerInput(w2);
                    continueGame = carryOnGame(w2, "Computer");
                } else {
                    System.out.println("Player...");

                    takeUserInput(w1);
                    continueGame = carryOnGame(w1, "Player");
                }

                i++;
            }
        } else {        // Player will take the first turn
            int i = 0;
            boolean continueGame = true;

            while (continueGame) {
                if (i % 2 == 0) {
                    System.out.println("Player...");

                    takeUserInput(w1);
                    continueGame = carryOnGame(w1, "Player");
                } else {
                    System.out.println("Computer...");

                    takeComputerInput(w2);
                    continueGame = carryOnGame(w2, "Computer");
                }

                i++;
            }
        }
    }

    private void medium(char w1, char w2) {
        if (comFirst) {     // Computer will take the first turn
            int i = 0;
            boolean continueGame = true;

            while (continueGame) {
                if (i % 2 == 0) {
                    System.out.println("Computer...");

                    if (Table.isEmpty()) {
                        takeComputerInput(w2);
                    } else {
                        boolean defaultCase = Logic.winningLogic(w2);

                        if (defaultCase) {
                            takeComputerInput(w2);
                        }
                    }

                    continueGame = carryOnGame(w2, "Computer");
                } else {
                    System.out.println("Player...");

                    takeUserInput(w1);
                    continueGame = carryOnGame(w1, "Player");
                }

                i++;
            }
        } else {        // Player will take the first turn
            int i = 0;
            boolean continueGame = true;

            while (continueGame) {
                if (i % 2 == 0) {
                    System.out.println("Player...");

                    takeUserInput(w1);
                    continueGame = carryOnGame(w1, "Player");
                } else {
                    System.out.println("Computer...");

                    boolean defaultCase = Logic.winningLogic(w2);

                    if (defaultCase) {
                        takeComputerInput(w2);
                    }

                    continueGame = carryOnGame(w2, "Computer");
                }

                i++;
            }
        }
    }

    private void hard(char w1, char w2) {
        if (comFirst) {     // Computer will take the first turn
            int i = 0;
            boolean continueGame = true;

            while (continueGame) {
                if (i % 2 == 0) {
                    System.out.println("Computer...");

                    if (Table.isEmpty()) {
                        takeComputerInput(w2);
                    } else {
                        boolean defaultCase = Logic.winningLogic(w2);

                        if (defaultCase) {
                            defaultCase = Logic.survivalLogic(w2);
                        }

                        if (defaultCase) {
                            takeComputerInput(w2);
                        }
                    }

                    continueGame = carryOnGame(w2, "Computer");
                } else {
                    System.out.println("Player...");

                    takeUserInput(w1);
                    continueGame = carryOnGame(w1, "Player");
                }

                i++;
            }
        } else {        // Player will take the first turn
            int i = 0;
            boolean continueGame = true;

            while (continueGame) {
                if (i % 2 == 0) {
                    System.out.println("Player...");

                    takeUserInput(w1);
                    continueGame = carryOnGame(w1, "Player");
                } else {
                    System.out.println("Computer...");

                    if (i == 1) {
                        if (Table.emptyPosition(1, 1)) {
                            Table.setWarrior(1, 1, w2);
                        } else {
                            takeComputerInput(w2);
                        }
                    } else {
                        boolean defaultCase = Logic.winningLogic(w2);

                        if (defaultCase) {
                            defaultCase = Logic.survivalLogic(w2);
                        }

                        if (defaultCase) {
                            takeComputerInput(w2);
                        }
                    }

                    continueGame = carryOnGame(w2, "Computer");
                }

                i++;
            }
        }
    }

    private void gameOver(String s) {
        System.out.println(s + " has own the match!\n");
        System.out.println("-----------------------------------------------------------------------------------\n");

    }
}
