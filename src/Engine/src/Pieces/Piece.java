package Pieces;
import Board.Spot;

public interface Piece {
    public Spot[] get_valid_spots();
    public void move(Spot target);
    public void take();
}
