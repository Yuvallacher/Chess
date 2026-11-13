package Board;

import Pieces.*;

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

    public int getNumOfRows() { return NUM_OF_ROWS; }

    public void initiateBoard() {
        for (int i = 0; i < NUM_OF_ROWS; i++) {
            this.board.add(new ArrayList<>(NUM_OF_ROWS));
            if (i == 0) {
                this.initiatePiecesRow(i, 0, "rook", PieceColor.WHITE);
                this.initiatePiecesRow(i, 1, "knight", PieceColor.WHITE);
                this.initiatePiecesRow(i, 2, "bishop", PieceColor.WHITE);
                this.initiatePiecesRow(i, 3, "queen", PieceColor.WHITE);
                this.initiatePiecesRow(i, 4, "king", PieceColor.WHITE);
                this.initiatePiecesRow(i, 5, "bishop", PieceColor.WHITE);
                this.initiatePiecesRow(i, 6, "knight", PieceColor.WHITE);
                this.initiatePiecesRow(i, 7, "rook", PieceColor.WHITE);
            } else if (i == 1)
                for (int j = 0; j < NUM_OF_ROWS; j++)
                    this.initiatePiecesRow(i, j, "pawn", PieceColor.WHITE);
            else if (i <= 5)
                this.board.get(i).addAll(Collections.nCopies(NUM_OF_ROWS, null));
            else if (i == 6) {
                for (int j = 0; j < NUM_OF_ROWS; j++)
                    this.initiatePiecesRow(i, j, "pawn", PieceColor.BLACK);
            } else {
                this.initiatePiecesRow(i, 0, "rook", PieceColor.BLACK);
                this.initiatePiecesRow(i, 1, "knight", PieceColor.BLACK);
                this.initiatePiecesRow(i, 2, "bishop", PieceColor.BLACK);
                this.initiatePiecesRow(i, 3, "queen", PieceColor.BLACK);
                this.initiatePiecesRow(i, 4, "king", PieceColor.BLACK);
                this.initiatePiecesRow(i, 5, "bishop", PieceColor.BLACK);
                this.initiatePiecesRow(i, 6, "knight", PieceColor.BLACK);
                this.initiatePiecesRow(i, 7, "rook", PieceColor.BLACK);
            }
        }
    }

    private void initiatePiecesRow(int row, int column, String piece_name, PieceColor color) {
        Piece piece;
        Position position = new Position(row, column);

        piece = switch (piece_name) {
            case "pawn" -> new Pawn(position, color);
            case "rook" -> new Rook(position, color);
            case "knight" -> new Knight(position, color);
            case "bishop" -> new Bishop(position, color);
            case "queen" -> new Queen(position, color);
            //case "king" -> new King(position, color);
            default -> null; //TODO - after King implemented make this default raise error
        };
        this.board.get(row).add(piece);
    }

    //TODO - fix this shit
    public void print_board() {
        this.print_letters();
        System.out.println("\n");
        for (int i = NUM_OF_ROWS - 1; i >= 0; i--) {
            System.out.print(i + 1 + "\t");
            for (int j = NUM_OF_ROWS - 1; j >= 0; j--) {
                Piece piece = this.board.get(i).get(j);
                if (piece != null && !piece.isTaken())
                    System.out.printf("  " + "%-3s", piece);
                else
                    System.out.print("     ");
            }
            System.out.print("\t" + (i + 1));
            System.out.println("\n");
        }
        this.print_letters();
    }

    private void print_letters() {
        System.out.print("\t");
        for (int i = 0; i < NUM_OF_ROWS; i++)
            System.out.printf("  " + "%-3s", (char) ('A' + i));
    }

    public List<List<Piece>> getBoard() { return this.board; }
}
