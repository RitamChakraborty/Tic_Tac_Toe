package _Play_Ground.Tic_Tac_Toe.com.ritam.src.data;

public class Table {
    private static char[][] table;

    static {
        table = new char[3][3];
    }

    public static boolean isEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] != ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean positionAllocatedBy(int r, int c, char w) {
        return table[r][c] == w;
    }

    public static boolean emptyPosition(int r, int c) {
        return table[r][c] == ' ';
    }

    public static void clearTable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = ' ';
            }
        }
    }

    public static boolean setWarrior(int i, int j, char w) {
        if (i >= 0 && j >= 0 && i < 3 && j < 3) {
            if (table[i][j] == ' ') {
                table[i][j] = w;
                return true;
            } else {
                System.out.println("PLACE IS ALREADY TAKEN!");
                return false;
            }
        } else {
            System.out.println("UNKNOWN INPUT!");
            return false;
        }
    }

    public static void printTable() {
        System.out.println("\t    1   2   3");
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.println("\t   --- --- ---");
            }

            System.out.println("\t" + (i + 1) + " | " + table[i][0] + " | " + table[i][1] + " | " + table[i][2] + " |");
            System.out.println("\t   --- --- ---");
        }

        System.out.println();
    }

    public static boolean gameIsAlive() {
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
               if (table[i][j] == ' ') {
                   return true;
               }
           }
       }

       return false;
    }

    private static boolean checkRow(int i, char w) {
        for (int j = 0; j < 3; j++) {
            if (table[i][j] != w) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkColumn(int j, char w) {
        for (int i = 0; i < 3; i++) {
            if (table[i][j] != w) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkLeftDiagonal(char w) {
        for (int i = 0; i < 3; i++) {
            if (table[i][i] != w) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkRightDiagonal(char w) {
        int j = 2;
        for (int i = 0; i < 3; i++) {
            if (table[i][j] != w) {
                return false;
            }

            j--;
        }

        return true;
    }

    public static boolean foundWinner(char w) {
        for (int i = 0; i < 3; i++) {
            if (checkRow(i, w)) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (checkColumn(j, w)) {
                return true;
            }
        }

        if (checkLeftDiagonal(w)) {
            return true;
        }

        return checkRightDiagonal(w);
    }
}
