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
        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        for (int[] direction : directions)
            this.calculateValidPositions(direction[0], direction[1], board_obj, valid_positions);

        this.valid_positions.clear();
        this.valid_positions.addAll(valid_positions);
        return valid_positions;
    }


    @Override
    public String toString() {
        return (this.color.equals(PieceColor.WHITE)? "♜" : "♖");
    }
}
