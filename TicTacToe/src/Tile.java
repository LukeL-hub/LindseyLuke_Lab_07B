public class Tile {
    private char symbol; // 'X', 'O', or ' '

    public Tile() {
        this.symbol = ' ';
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        if (this.symbol == ' ') {
            this.symbol = symbol;
        }
    }

    public boolean isEmpty() {
        return symbol == ' ';
    }
}
