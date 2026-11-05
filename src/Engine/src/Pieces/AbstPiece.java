package Pieces;

import Board.Position;

import java.util.List;

public abstract class AbstPiece extends AbstChessman {
    public AbstPiece(Position position, PieceColor color) {
        super(position, color);
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
