package Pieces;
import Board.Spot;

import java.util.List;

public interface Piece {
    public List<Spot> getValidSpots(List<List<PieceColor>> board);
    public void move(Spot target);
    public PieceColor getColor();
}
