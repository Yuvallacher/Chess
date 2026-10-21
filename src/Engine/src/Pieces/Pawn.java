package Pieces;

import Board.Spot;
import Board.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {
    private final Spot position;
    private final PieceColor color;

    public Pawn(Spot i_position, PieceColor i_color) {
        position = i_position;
        color = i_color;
    }

    @Override
    public List<Spot> getValidSpots(List<List<PieceColor>> board) {
        List<Spot> valid_spots = new ArrayList<>(4);
        final int WHITE_START_ROW = 1;
        final int BLACK_START_ROW = 6;
        PieceColor target_spot_color = board.get(calculateDirectionPerColor(position.getRow(), 1, color)).get(position.getColumn());

        if ((color.equals(PieceColor.WHITE) && position.getRow() == WHITE_START_ROW) || (color.equals(PieceColor.BLACK) && position.getRow() == BLACK_START_ROW)) {
            PieceColor second_target_spot_color = board.get(calculateDirectionPerColor(position.getRow(), 2, color)).get(position.getColumn());
            if (target_spot_color == null && second_target_spot_color == null)
                valid_spots.add(new Spot(calculateDirectionPerColor(position.getRow(), 2, color), position.getColumn()));
        }
        if (target_spot_color == null)
            valid_spots.add(new Spot(calculateDirectionPerColor(position.getRow(), 1, color), position.getColumn()));
        if (position.getColumn() != 7) {
            if (canTake(board, 1))
                valid_spots.add(new Spot(calculateDirectionPerColor(position.getRow(), 1, color), position.getColumn() + 1));
        }
        if (position.getColumn() != 0) {
            if (canTake(board, -1))
                valid_spots.add(new Spot(calculateDirectionPerColor(position.getRow(), 1, color), position.getColumn() - 1));
        }
        return valid_spots;
    }

    private int calculateDirectionPerColor (int current_position, int steps, PieceColor color) {
        int result;
        if (color.equals(PieceColor.WHITE))
            result = current_position + steps;
        else
            result = current_position - steps;
        return result;
    }

    private boolean canTake(List<List<PieceColor>> board, int direction) {
        PieceColor target_spot_color = board.get(calculateDirectionPerColor(position.getRow(), 1, color)).get(position.getColumn() + direction);
        return (target_spot_color != null && !target_spot_color.equals(color));
    }

    @Override
    public void move(Spot target) {

    }
}
