package Board;

import Pieces.Pawn;
import Pieces.Piece;
import Pieces.PieceColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Board {
    private final List<List<Piece>> board;
    private static final int NUM_OF_ROWS = 8;

    public Board() {
        this.board = new ArrayList<>(NUM_OF_ROWS);
        this.initiateBoard();
    }

    public void initiateBoard() {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            this.board.add(new ArrayList<>(NUM_OF_ROWS));
            if (i == 0) {
                this.board.get(i).addAll(Collections.nCopies(NUM_OF_ROWS, null)); // White pieces
            } else if (i == 1)
                for (int j = 0; j < NUM_OF_ROWS; j++)
                    this.board.get(i).add(new Pawn(new Position(i, j), PieceColor.WHITE));
            else if (i <= 5)
                this.board.get(i).addAll(Collections.nCopies(NUM_OF_ROWS, null));
            else if (i == 6) {
                for (int j = 0; j < NUM_OF_ROWS; j++)
                    this.board.get(i).add(new Pawn(new Position(i, j), PieceColor.BLACK));
            } else {
                this.board.get(i).addAll(Collections.nCopies(NUM_OF_ROWS, null)); // Black pieces
            }
        }
    }

    public void print_board() {
        this.print_letters();
        System.out.println("\n");
        for (int i = NUM_OF_ROWS - 1; i >= 0; i--) {
            System.out.print(i + 1 + "\t\t");
            for (int j = NUM_OF_ROWS - 1; j >= 0; j--)
                System.out.printf("%-12s", this.board.get(i).get(j));
            System.out.print("\t" + (int) (i + 1));
            System.out.println("\n");
        }
        this.print_letters();
    }

    private void print_letters() {
        System.out.print("\t");
        for (int i = 0; i < NUM_OF_ROWS; i++)
            System.out.printf("    %-8s", (char) ('A' + i));
    }
}
