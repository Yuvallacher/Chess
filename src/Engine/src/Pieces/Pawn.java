package Pieces;

import Board.Spot;

public class Pawn implements Piece {
    public Pawn() {
        Spot position;
    }

    @Override
    public Spot[] get_valid_spots() {
        return new Spot[0];
    }

    @Override
    public void move(Spot target) {

    }

    @Override
    public void take() {

    }
}
