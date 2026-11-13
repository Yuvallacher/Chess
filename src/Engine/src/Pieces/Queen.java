package Pieces;

import Board.Board;
import Board.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends AbstPiece {
    private final Rook dummy_rook;
    private final Bishop dummy_bishop;

    public Queen(Position position, PieceColor color) {
        super(position, color);
        this.dummy_rook = new Rook(position, color);
        this.dummy_bishop = new Bishop(position, color);
        this.points_value = 9;
    }

    @Override
    public List<Position> getValidPositions(Board board_obj) {
        List<Position> valid_positions = new ArrayList<>();

        this.dummy_rook.setPosition(this.position);
        this.dummy_bishop.setPosition(this.position);

        valid_positions.addAll(this.dummy_rook.getValidPositions(board_obj));
        valid_positions.addAll(this.dummy_bishop.getValidPositions(board_obj));

        this.valid_positions.clear();
        this.valid_positions.addAll(valid_positions);
        return valid_positions;
    }
}
