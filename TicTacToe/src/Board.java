public class Board {
    private Tile[][] tiles;

    public Board() {
        tiles = new Tile[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tiles[i][j] = new Tile();
            }
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (tiles[row][col].isEmpty()) {
            tiles[row][col].setSymbol(symbol);
            return true;
        }
        return false;
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public boolean checkWin(char player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private boolean isRowWin(char player) {
        for (int row = 0; row < 3; row++) {
            if (tiles[row][0].getSymbol() == player && tiles[row][1].getSymbol() == player && tiles[row][2].getSymbol() == player) {
                return true;
            }
        }
        return false;
    }

    private boolean isColWin(char player) {
        for (int col = 0; col < 3; col++) {
            if (tiles[0][col].getSymbol() == player && tiles[1][col].getSymbol() == player && tiles[2][col].getSymbol() == player) {
                return true;
            }
        }
        return false;
    }

    private boolean isDiagonalWin(char player) {
        return (tiles[0][0].getSymbol() == player && tiles[1][1].getSymbol() == player && tiles[2][2].getSymbol() == player) ||
                (tiles[0][2].getSymbol() == player && tiles[1][1].getSymbol() == player && tiles[2][0].getSymbol() == player);
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}