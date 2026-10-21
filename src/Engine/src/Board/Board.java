package Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Board {
    private final List<List<PieceColor>> board;
    private static final int NUM_OF_ROWS = 8;

    public Board() {
        this.board = new ArrayList<>(NUM_OF_ROWS);
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            this.board.add(new ArrayList<>(8));
            if (i <= 1)
                this.board.get(i).addAll(Collections.nCopies(8, PieceColor.WHITE));
            else if (i > 1 && i <= 5)
                this.board.get(i).addAll(Collections.nCopies(8, PieceColor.EMPTY));
            else
                this.board.get(i).addAll(Collections.nCopies(8, PieceColor.BLACK));
        }
    }

    public void print_board() {
        this.print_letters();
        System.out.println("\n");
        for (int i = NUM_OF_ROWS-1 ; i >= 0 ; i--) {
            System.out.print(i + 1 + "\t");
            for (int j = NUM_OF_ROWS-1 ; j >= 0 ; j--) {
                System.out.print(this.board.get(i).get(j) + "\t");
            }
            System.out.print(i + 1);
            System.out.println("\n");
        }
        this.print_letters();
    }

    private void print_letters() {
        System.out.print("\t");
        for (int i = 0 ; i < NUM_OF_ROWS ; i++)
            System.out.print(String.valueOf("  " + (char)('A'+i)) + "    \t");
    }
}
