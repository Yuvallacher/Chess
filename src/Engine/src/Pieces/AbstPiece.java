package Pieces;

import Board.Board;
import Board.Position;

import java.util.List;

public abstract class AbstPiece extends AbstChessman {
    public AbstPiece(Position position, PieceColor color) {
        super(position, color);
    }

    protected void calculateValidPositions(int row_step, int column_step, Board board_obj, List<Position> valid_positions) {
        List<List<Piece>> board = board_obj.getBoard();
        final int num_of_rows = board_obj.getNumOfRows();
        int row = this.getRow() + row_step;
        int column = this.getColumn() + column_step;

        while (row >= 0 && row < num_of_rows && column >= 0 && column < num_of_rows) {
            boolean added_position = addValidPosition(board, row, column, valid_positions);
            if (!added_position)
                break;
            row += row_step;
            column += column_step;
        }
    }

    protected boolean addValidPosition(List<List<Piece>> board, int row, int column, List<Position> valid_positions) {
        boolean added_position = false;
        Piece piece_at_target_position = board.get(row).get(column);
        if (piece_at_target_position == null || !piece_at_target_position.getColor().equals(this.getColor())) {
            valid_positions.add(new Position(row, column));
            added_position = true;
        }
        return added_position;
    }
}
