package Board;

public class Board {
    public Board() {
        final int NUM_OF_ROWS = 8;
        PieceColor[][] board = new PieceColor[NUM_OF_ROWS][NUM_OF_ROWS];

    }


    enum PieceColor {
        WHITE,  // White piece
        BLACK,  // Black piece
        EMPTY   // No piece
    }
}
