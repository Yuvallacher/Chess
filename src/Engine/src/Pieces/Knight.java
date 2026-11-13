package Pieces;

import Board.Board;
import Board.Position;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstPiece {
    public Knight(Position position, PieceColor color) {
        super(position, color);
        this.points_value = 3;
    }

    @Override
    public List<Position> getValidPositions(Board board_obj) {
        List<Position> valid_positions = new ArrayList<>();
        int current_row = this.getRow();
        int current_column = this.getColumn();
        final int NUM_OF_ROWS = board_obj.getNumOfRows();
        List<List<Piece>> board = board_obj.getBoard();
        int[][] directions = {
                {2, 1}, {1, 2},
                {2, -1}, {-1, 2},
                {-2, 1}, {1, -2},
                {-2, -1}, {-1, -2}
        };

        for (int[] direction : directions) {
            int target_row = current_row + direction[0];
            int target_column = current_column + direction[1];
            if (target_row < NUM_OF_ROWS && target_row >= 0 && target_column < NUM_OF_ROWS && target_column >= 0)
                this.addValidPosition(board, target_row, target_column, valid_positions);
        }

        this.valid_positions.clear();
        this.valid_positions.addAll(valid_positions);
        return valid_positions;
    }


    @Override
    public String toString() {
        return (this.color.equals(PieceColor.WHITE)? "♞" : "♘");
    }
}
