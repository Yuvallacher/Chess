package Pieces;

import Board.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstPiece {

    public Pawn(Position position, PieceColor color) {
        super(position, color);
    }

    @Override
    public List<Position> getValidPositions(List<List<Piece>> board) {
        List<Position> valid_positions = new ArrayList<>(4);
        final int WHITE_START_ROW = 1;
        final int BLACK_START_ROW = 6;
        PieceColor target_position_color = board.get(calculateDirectionPerColor(position.getRow(), 1, color)).get(position.getColumn()).getColor();

        if ((color.equals(PieceColor.WHITE) && position.getRow() == WHITE_START_ROW) || (color.equals(PieceColor.BLACK) && position.getRow() == BLACK_START_ROW)) {
            PieceColor second_target_position_color = board.get(calculateDirectionPerColor(position.getRow(), 2, color)).get(position.getColumn()).getColor();
            if (target_position_color == null && second_target_position_color == null)
                valid_positions.add(new Position(calculateDirectionPerColor(position.getRow(), 2, color), position.getColumn()));
        }
        if (target_position_color == null)
            valid_positions.add(new Position(calculateDirectionPerColor(position.getRow(), 1, color), position.getColumn()));
        if (position.getColumn() != 7) {
            if (canTake(board, 1))
                valid_positions.add(new Position(calculateDirectionPerColor(position.getRow(), 1, color), position.getColumn() + 1));
        }
        if (position.getColumn() != 0) {
            if (canTake(board, -1))
                valid_positions.add(new Position(calculateDirectionPerColor(position.getRow(), 1, color), position.getColumn() - 1));
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
        PieceColor target_position_color = board.get(calculateDirectionPerColor(position.getRow(), 1, color)).get(position.getColumn() + direction).getColor();
        return (target_position_color != null && !target_position_color.equals(color));
    }

    @Override
    public boolean[] move(List<List<Piece>> board, Position target) {
        boolean valid_move = false;
        boolean took_piece = false;
        for (Position valid_position : this.valid_positions) {
            if (valid_position.equals(target)) {
                valid_move = true;
                Piece piece_at_target = board.get(target.getRow()).get(target.getColumn());
                if (piece_at_target != null) {
                    piece_at_target.setAsTaken();
                    took_piece = true;
                }
                this.position.updatePosition(target);
                break;
            }
        }
        return new boolean[] {valid_move, took_piece};
    }


    @Override
    public String toString() {
        return super.toString() + " Pawn";
    }
}
