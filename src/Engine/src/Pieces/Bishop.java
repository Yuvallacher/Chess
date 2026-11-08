package Pieces;

import Board.Position;
import Board.Board;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstPiece {

    public Bishop(Position position, PieceColor color) {
        super(position, color);
    }

    @Override
    public List<Position> getValidPositions(Board board_obj) {
        List<Position> valid_positions = new ArrayList<>();
        boolean row_up = true;
        boolean column_up = true;

        this.calculateValidPositions(row_up, column_up, board_obj);
        this.calculateValidPositions(row_up, !column_up, board_obj);
        this.calculateValidPositions(!row_up, column_up, board_obj);
        this.calculateValidPositions(!row_up, !column_up, board_obj);

        return valid_positions;
    }

    private void calculateValidPositions(boolean row_up, boolean column_up, Board board_obj) {
        List<List<Piece>> board = board_obj.getBoard();
        final int num_of_rows = board_obj.getNumOfRows();
        int row = row_up ? this.getRow() + 1 : this.getRow() - 1;
        int column = column_up ? this.getColumn() + 1 : this.getColumn() - 1;
        boolean break_loop = false;
        while (!break_loop) {
            boolean added_position = addValidPosition(board, row, column, valid_positions);
            row = row_up ? row + 1 : row - 1;
            column = column_up ? column + 1 : column - 1;
            if ((!added_position) || row < 0 || row >= num_of_rows || column < 0 || column >= num_of_rows)
                break_loop = true;
        }
    }

    @Override
    public String toString() {
        return (this.color.equals(PieceColor.WHITE)? "♝" : "♗");
    }
}
