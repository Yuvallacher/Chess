package Pieces;

import Board.Position;
import Board.Board;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstPiece {
    public Rook(Position position, PieceColor color) {
        super(position, color);
        this.points_value = 5;
    }


    @Override
    public List<Position> getValidPositions(Board board_obj) {
        List<Position> valid_positions = new ArrayList<>();
        int current_row = this.getRow();
        int current_column = this.getColumn();
        List<List<Piece>> board = board_obj.getBoard();
        final int num_of_rows = board_obj.getNumOfRows();

        //TODO - duplicate code is baaaad
        for (int row = current_row + 1; row < num_of_rows; row++) {
            boolean added_position = addValidPosition(board, row, current_column, valid_positions);
            if (!added_position)
                break;
        }

        //TODO - duplicate code is baaaad
        for (int row = current_row - 1; row >= 0; row--) {
            boolean added_position = addValidPosition(board, row, current_column, valid_positions);
            if (!added_position)
                break;
        }

        //TODO - duplicate code is baaaad
        for (int column = current_column + 1; column < num_of_rows; column++) {
            boolean added_position = addValidPosition(board, current_row, column, valid_positions);
            if (!added_position)
                break;
        }

        //TODO - duplicate code is baaaad
        for (int column = current_column - 1; column >= 0; column--) {
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
