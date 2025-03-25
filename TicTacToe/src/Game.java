public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        GameController controller = new GameController(board);
        TicTacToeFrame frame = new TicTacToeFrame(controller, board);
        frame.setVisible(true);
    }
}

