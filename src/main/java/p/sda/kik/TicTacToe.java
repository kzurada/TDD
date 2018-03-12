package p.sda.kik;

import java.util.Optional;

public class TicTacToe {
    private char[][] playboard = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    private char currentPlayerSymbol = 'X';

    public void play(int x, int y) {
        validareBoundaries(x);
        validareBoundaries(y);
        validateDuplicateMove(x, y);
        playboard[x - 1][y - 1] = getCurrentPlayer();
        changeCurrentPlayer();
    }

    private void changeCurrentPlayer() {
        currentPlayerSymbol = currentPlayerSymbol == 'X' ? 'O' : 'X';
    }

    private void validateDuplicateMove(int x, int y) {
        if (playboard[x - 1][y - 1] != 0) {
            throw new RuntimeException("Duplicated move");
        }
    }

    private void validareBoundaries(int dimension) {
        if (dimension <= 0 || dimension >= 4) {
            throw new RuntimeException(("Invalid move"));
        }
    }

    public char getCurrentPlayer() {
        return currentPlayerSymbol;
    }


    public Optional<Character> getWinner() {
        for (int y = 0; y < 3; y++) {
            char[] currentRow = {playboard[0][y], playboard[1][y], playboard[2][y]};
            if (doCellBelongToOnePlayer(currentRow)) {
                return Optional.of(currentRow[0]);
            }
        }

        for (int x = 0; x < 3; x++) {
            char[] currentColumn = playboard[x];
            if (doCellBelongToOnePlayer(currentColumn)) {
                return Optional.of(currentColumn[0]);
            }
        }

        char[] currentDiagonalCell1 = {
                playboard[0][0],
                playboard[1][1],
                playboard[2][2],
        };
        if (doCellBelongToOnePlayer(currentDiagonalCell1)) {
            return Optional.of(currentDiagonalCell1[0]);
        }

        return Optional.empty();
    }

    private boolean doCellBelongToOnePlayer(char[] potentialWin) {
        char cell1 = potentialWin[0];
        char cell2 = potentialWin[1];
        char cell3 = potentialWin[2];
        return cell1 == cell2 && cell2 == cell3 && cell1 != 0;
    }
}
