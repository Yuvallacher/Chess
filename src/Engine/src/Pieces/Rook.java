package Pieces;

import Board.Position;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstPiece {
    public Rook(Position position, PieceColor color) {
        super(position, color);
        this.points_value = 5;
    }


    @Override
    public List<Position> getValidPositions(List<List<Piece>> board) {
        List<Position> valid_positions = new ArrayList<>();
        int current_row = this.getRow();
        int current_column = this.getColumn();
        final int NUM_OF_ROWS = 8; //TODO - there must be a better way to reach this number through the board

        for (int row = current_row ; row < NUM_OF_ROWS; row++) {
            boolean added_position = addValidPosition(board, row, current_column, valid_positions);
            if (!added_position)
                break;
        }

        for (int row = current_row ; row >= 0; row--) {
            boolean added_position = addValidPosition(board, row, current_column, valid_positions);
            if (!added_position)
                break;
        }

        for (int column = current_column ; column < NUM_OF_ROWS; column++) {
            boolean added_position = addValidPosition(board, current_row, column, valid_positions);
            if (!added_position)
                break;
        }

        for (int column = current_column ; column >= 0; column--) {
            boolean added_position = addValidPosition(board, current_row, column, valid_positions);
            if (!added_position)
                break;
        }

        return valid_positions;
    }


    @Override
    public String toString() {
        return (this.color.equals(PieceColor.WHITE)? "♜" : "♖");
    }
}
