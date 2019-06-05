package _Play_Ground.Tic_Tac_Toe.data;

public class Table {
    private static char[][] table;

    static {
        table = new char[3][3];
    }

    public static void clearTable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = ' ';
            }
        }
    }

    public static void setWarrior(int i, int j, char w) {
        table[i][j] = w;
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
}
