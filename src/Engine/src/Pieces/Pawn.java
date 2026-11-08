package Pieces;

import Board.Board;
import Board.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstChessman {

    public Pawn(Position position, PieceColor color) {
        super(position, color);
        this.points_value = 1;
    }

    @Override
    public List<Position> getValidPositions(Board board_obj) {
        List<Position> valid_positions = new ArrayList<>(4);
        final int WHITE_START_ROW = 1;
        final int BLACK_START_ROW = 6;
        int current_row = this.getRow();
        int current_column = this.getColumn();
        List<List<Piece>> board = board_obj.getBoard();
        PieceColor one_step_target_position_color = board.get(calculateDirectionPerColor(current_row, 1, color)).get(current_column).getColor();

        if ((color.equals(PieceColor.WHITE) && current_row == WHITE_START_ROW) || (color.equals(PieceColor.BLACK) && current_row == BLACK_START_ROW)) {
            PieceColor two_stepds_target_position_color = board.get(calculateDirectionPerColor(current_row, 2, color)).get(current_column).getColor();
            if (one_step_target_position_color == null && two_stepds_target_position_color == null)
                valid_positions.add(new Position(calculateDirectionPerColor(current_row, 2, color), current_column));
        }
        if (one_step_target_position_color == null)
            valid_positions.add(new Position(calculateDirectionPerColor(current_row, 1, color), current_column));
        if (current_column != 7) {
            if (canTake(board, 1))
                valid_positions.add(new Position(calculateDirectionPerColor(current_row, 1, color), current_column + 1));
        }
        if (current_column != 0) {
            if (canTake(board, -1))
                valid_positions.add(new Position(calculateDirectionPerColor(current_row, 1, color), current_column - 1));
        }
        this.valid_positions.clear();
        this.valid_positions.addAll(valid_positions);
        return valid_positions;
    }

    private int calculateDirectionPerColor (int current_position, int steps, PieceColor color) {
        int result;
        if (color.equals(PieceColor.WHITE))
            result = current_position + steps;
        else
            result = current_position - steps;
        return result;
    }

    private boolean canTake(List<List<Piece>> board, int direction) {
        PieceColor target_position_color = board.get(calculateDirectionPerColor(this.getRow(), 1, color)).get(this.getColumn() + direction).getColor();
        return (target_position_color != null && !target_position_color.equals(color));
    }

    //TODO - duplicate code is baaaad
    @Override
    public boolean move(Board board_obj, Position target) {
        boolean valid_move = false;
        List<List<Piece>> board = board_obj.getBoard();

        for (Position valid_position : this.valid_positions) {
            if (valid_position.equals(target)) {
                valid_move = true;
                Piece piece_at_target = board.get(target.getRow()).get(target.getColumn());
                if (piece_at_target != null && !piece_at_target.isTaken() && target.getColumn() != this.getColumn()) {
                    piece_at_target.setAsTaken();
                    List<Piece> row = board.get(target.getRow());
                    row.set(target.getColumn(), this);
                    List<Piece> current_row = board.get(this.getRow());
                    current_row.set(this.getColumn(), null);
                }
                this.position.updatePosition(target);
                break;
            }
        }
        return valid_move;
    }


    @Override
    public String toString() {
        return (this.color.equals(PieceColor.WHITE)? "♟" : "♙");
    }
}
