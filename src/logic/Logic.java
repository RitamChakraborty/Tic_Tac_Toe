package src.logic;

import src.data.Table;

public class Logic {
    public static boolean winningLogic(char w) {
        // Row 0
        if (Table.positionAllocatedBy(0, 0, w)
                && Table.positionAllocatedBy(0, 1, w)
                && Table.emptyPosition(0, 2)) {
            Table.setWarrior(0, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 0, w)
                && Table.positionAllocatedBy(0, 2, w)
                && Table.emptyPosition(0, 1)) {
            Table.setWarrior(0, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 1, w)
                && Table.positionAllocatedBy(0, 2, w)
                && Table.emptyPosition(0, 0)) {
            Table.setWarrior(0, 0, w);

            return false;
        }
        // Row 1
        if (Table.positionAllocatedBy(1, 0, w)
                && Table.positionAllocatedBy(1, 1, w)
                && Table.emptyPosition(1, 2)) {
            Table.setWarrior(1, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 0, w)
                && Table.positionAllocatedBy(1, 2, w)
                && Table.emptyPosition(1, 1)) {
            Table.setWarrior(1, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 1, w)
                && Table.positionAllocatedBy(1, 2, w)
                && Table.emptyPosition(1, 0)) {
            Table.setWarrior(1, 0, w);

            return false;
        }
        // Row 2
        if (Table.positionAllocatedBy(2, 0, w)
                && Table.positionAllocatedBy(2, 1, w)
                && Table.emptyPosition(2, 2)) {
            Table.setWarrior(2, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(2, 0, w)
                && Table.positionAllocatedBy(2, 2, w)
                && Table.emptyPosition(2, 1)) {
            Table.setWarrior(2, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(2, 1, w)
                && Table.positionAllocatedBy(2, 2, w)
                && Table.emptyPosition(2, 0)) {
            Table.setWarrior(2, 0, w);

            return false;
        }

        // Column 0
        if (Table.positionAllocatedBy(0, 0, w)
                && Table.positionAllocatedBy(1, 0, w)
                && Table.emptyPosition(2, 0)) {
            Table.setWarrior(2, 0, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 0, w)
                && Table.positionAllocatedBy(2, 0, w)
                && Table.emptyPosition(1, 0)) {
            Table.setWarrior(1, 0, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 0, w)
                && Table.positionAllocatedBy(2, 0, w)
                && Table.emptyPosition(0, 0)) {
            Table.setWarrior(0, 0, w);

            return false;
        }
        // Column 1
        if (Table.positionAllocatedBy(0, 1, w)
                && Table.positionAllocatedBy(1, 1, w)
                && Table.emptyPosition(2, 1)) {
            Table.setWarrior(2, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 1, w)
                && Table.positionAllocatedBy(2, 1, w)
                && Table.emptyPosition(1, 1)) {
            Table.setWarrior(1, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 1, w)
                && Table.positionAllocatedBy(2, 1, w)
                && Table.emptyPosition(0, 1)) {
            Table.setWarrior(0, 1, w);

            return false;
        }
        // Column 2
        if (Table.positionAllocatedBy(0, 2, w)
                && Table.positionAllocatedBy(1, 2, w)
                && Table.emptyPosition(2, 2)) {
            Table.setWarrior(2, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 2, w)
                && Table.positionAllocatedBy(2, 2, w)
                && Table.emptyPosition(1, 2)) {
            Table.setWarrior(1, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 2, w)
                && Table.positionAllocatedBy(2, 2, w)
                && Table.emptyPosition(0, 2)) {
            Table.setWarrior(0, 2, w);

            return false;
        }

        // Left Diagonal
        if (Table.positionAllocatedBy(0, 0, w)
                && Table.positionAllocatedBy(1, 1, w)
                && Table.emptyPosition(2, 2)) {
            Table.setWarrior(2, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 0, w)
                && Table.positionAllocatedBy(2, 2, w)
                && Table.emptyPosition(1, 1)) {
            Table.setWarrior(1, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 1, w)
                && Table.positionAllocatedBy(2, 2, w)
                && Table.emptyPosition(0, 0)) {
            Table.setWarrior(0, 0, w);

            return false;
        }
        // Right Diagonal
        if (Table.positionAllocatedBy(0, 2, w)
                && Table.positionAllocatedBy(1, 1, w)
                && Table.emptyPosition(2, 0)) {
            Table.setWarrior(2, 0, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 2, w)
                && Table.positionAllocatedBy(2, 0, w)
                && Table.emptyPosition(1, 1)) {
            Table.setWarrior(1, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 1, w)
                && Table.positionAllocatedBy(2, 0, w)
                && Table.emptyPosition(0, 2)) {
            Table.setWarrior(0, 2, w);

            return false;
        }

        return true;
    }

    public static boolean survivalLogic(char w) {
        char o = w == 'X' ? 'O' : 'X';

        // Row 0
        if (Table.positionAllocatedBy(0, 0, o)
                && Table.positionAllocatedBy(0, 1, o)
                && Table.emptyPosition(0, 2)) {
            Table.setWarrior(0, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 0, o)
                && Table.positionAllocatedBy(0, 2, o)
                && Table.emptyPosition(0, 1)) {
            Table.setWarrior(0, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 1, o)
                && Table.positionAllocatedBy(0, 2, o)
                && Table.emptyPosition(0, 0)) {
            Table.setWarrior(0, 0, w);

            return false;
        }
        // Row 1
        if (Table.positionAllocatedBy(1, 0, o)
                && Table.positionAllocatedBy(1, 1, o)
                && Table.emptyPosition(1, 2)) {
            Table.setWarrior(1, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 0, o)
                && Table.positionAllocatedBy(1, 2, o)
                && Table.emptyPosition(1, 1)) {
            Table.setWarrior(1, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 1, o)
                && Table.positionAllocatedBy(1, 2, o)
                && Table.emptyPosition(1, 0)) {
            Table.setWarrior(1, 0, w);

            return false;
        }
        // Row 2
        if (Table.positionAllocatedBy(2, 0, o)
                && Table.positionAllocatedBy(2, 1, o)
                && Table.emptyPosition(2, 2)) {
            Table.setWarrior(2, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(2, 0, o)
                && Table.positionAllocatedBy(2, 2, o)
                && Table.emptyPosition(2, 1)) {
            Table.setWarrior(2, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(2, 1, o)
                && Table.positionAllocatedBy(2, 2, o)
                && Table.emptyPosition(2, 0)) {
            Table.setWarrior(2, 0, w);

            return false;
        }

        // Column 0
        if (Table.positionAllocatedBy(0, 0, o)
                && Table.positionAllocatedBy(1, 0, o)
                && Table.emptyPosition(2, 0)) {
            Table.setWarrior(2, 0, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 0, o)
                && Table.positionAllocatedBy(2, 0, o)
                && Table.emptyPosition(1, 0)) {
            Table.setWarrior(1, 0, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 0, o)
                && Table.positionAllocatedBy(2, 0, o)
                && Table.emptyPosition(0, 0)) {
            Table.setWarrior(0, 0, w);

            return false;
        }
        // Column 1
        if (Table.positionAllocatedBy(0, 1, o)
                && Table.positionAllocatedBy(1, 1, o)
                && Table.emptyPosition(2, 1)) {
            Table.setWarrior(2, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 1, o)
                && Table.positionAllocatedBy(2, 1, o)
                && Table.emptyPosition(1, 1)) {
            Table.setWarrior(1, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 1, o)
                && Table.positionAllocatedBy(2, 1, o)
                && Table.emptyPosition(0, 1)) {
            Table.setWarrior(0, 1, w);

            return false;
        }
        // Column 2
        if (Table.positionAllocatedBy(0, 2, o)
                && Table.positionAllocatedBy(1, 2, o)
                && Table.emptyPosition(2, 2)) {
            Table.setWarrior(2, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 2, o)
                && Table.positionAllocatedBy(2, 2, o)
                && Table.emptyPosition(1, 2)) {
            Table.setWarrior(1, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 2, o)
                && Table.positionAllocatedBy(2, 2, o)
                && Table.emptyPosition(0, 2)) {
            Table.setWarrior(0, 2, w);

            return false;
        }

        // Left Diagonal
        if (Table.positionAllocatedBy(0, 0, o)
                && Table.positionAllocatedBy(1, 1, o)
                && Table.emptyPosition(2, 2)) {
            Table.setWarrior(2, 2, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 0, o)
                && Table.positionAllocatedBy(2, 2, o)
                && Table.emptyPosition(1, 1)) {
            Table.setWarrior(1, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 1, o)
                && Table.positionAllocatedBy(2, 2, o)
                && Table.emptyPosition(0, 0)) {
            Table.setWarrior(0, 0, w);

            return false;
        }
        // Right Diagonal
        if (Table.positionAllocatedBy(0, 2, o)
                && Table.positionAllocatedBy(1, 1, o)
                && Table.emptyPosition(2, 0)) {
            Table.setWarrior(2, 0, w);

            return false;
        }
        if (Table.positionAllocatedBy(0, 2, o)
                && Table.positionAllocatedBy(2, 0, o)
                && Table.emptyPosition(1, 1)) {
            Table.setWarrior(1, 1, w);

            return false;
        }
        if (Table.positionAllocatedBy(1, 1, o)
                && Table.positionAllocatedBy(2, 0, o)
                && Table.emptyPosition(0, 2)) {
            Table.setWarrior(0, 2, w);

            return false;
        }

        return true;
    }
}
