import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame {
    private TTTTileButton[][] buttons = new TTTTileButton[3][3];
    private GameController controller;
    private Board board;
    private JLabel statusLabel;

    public TicTacToeFrame(GameController controller, Board board) {
        super("Tic Tac Toe");
        this.controller = controller;
        this.board = board;
        setupUI();
    }

    private void setupUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new TTTTileButton(row, col);
                buttons[row][col].setText(" ");
                buttons[row][col].addActionListener(e -> handleButtonClick((TTTTileButton) e.getSource()));
                boardPanel.add(buttons[row][col]);
            }
        }
        statusLabel = new JLabel("Player X's Turn");
        add(boardPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
        pack();
    }

    private void handleButtonClick(TTTTileButton button) {
        int row = button.getRow();
        int col = button.getCol();
        if (controller.makeMove(row, col)) {
            button.setText(String.valueOf(controller.getCurrentPlayer()));
            if (controller.checkWin()) {
                showEndMessage("Player " + controller.getCurrentPlayer() + " wins! Play again?");
            } else if (controller.checkTie()) {
                showEndMessage("It's a tie! Play again?");
            } else {
                controller.switchPlayer();
                statusLabel.setText("Player " + controller.getCurrentPlayer() + "'s Turn");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid move! Try again.");
        }
    }

    private void showEndMessage(String message) {
        int choice = JOptionPane.showConfirmDialog(this, message, "Game Over", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            dispose();
            Game.main(null);
        } else {
            System.exit(0);
        }
    }
}

