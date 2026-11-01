package Pieces;
import Board.Position;

import java.util.List;

public interface Piece {
    public List<Position> getValidPositions(List<List<Piece>> board);
    public boolean[] move(List<List<Piece>> board, Position target);
    public PieceColor getColor();
    public void setAsTaken();
    public boolean isTaken();
    public Integer getPoints_value();
}
