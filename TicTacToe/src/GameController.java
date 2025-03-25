public class GameController {
    private Board board;
    private char currentPlayer;

    public GameController(Board board) {
        this.board = board;
        this.currentPlayer = 'X';
    }

    public boolean makeMove(int row, int col) {
        if (board.makeMove(row, col, currentPlayer)) {
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean checkWin() {
        return board.checkWin(currentPlayer);
    }

    public boolean checkTie() {
        return board.isFull() && !checkWin();
    }
}
