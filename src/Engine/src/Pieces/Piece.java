package Pieces;
import Board.Board;
import Board.Position;

import java.util.List;

public interface Piece {
    public List<Position> getValidPositions(Board board_obj);
    public boolean move(Board board_obj, Position target);
    public PieceColor getColor();
    public void setAsTaken();
    public boolean isTaken();
    public Integer getPoints_value();
}
