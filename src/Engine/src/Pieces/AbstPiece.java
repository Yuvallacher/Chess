package Pieces;

import Board.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstPiece implements Piece{
    protected final PieceColor color;
    protected Position position;
    protected boolean is_taken;
    protected Boolean is_pinned;
    protected Integer points_value;
    protected List<Position> valid_positions;

    public AbstPiece(Position position, PieceColor color) {
        this.color = color;
        this.position = position;
        this. is_taken = false;
        this.is_pinned = false;
        this.valid_positions = new ArrayList<>();
    }

    public PieceColor getColor() { return color; }

    @Override
    public String toString() {
        return this.color.toString().toLowerCase();
    }

    @Override
    public void setAsTaken() {
        this.is_taken = true;
    }

    @Override
    public boolean isTaken() {
        return this.is_taken;
    }

    @Override
    public boolean[] move(List<List<Piece>> board, Position target) {
        boolean valid_move = false;
        boolean took_piece = false;
        for (Position valid_position : this.valid_positions) {
            if (valid_position.equals(target)) {
                valid_move = true;
                Piece piece_at_target = board.get(target.getRow()).get(target.getColumn());
                if (piece_at_target != null && !piece_at_target.isTaken()) {
                    piece_at_target.setAsTaken();
                    took_piece = true;
                }
                this.position.updatePosition(target);
                break;
            }
        }
        return new boolean[] {valid_move, took_piece};
    }

    public boolean getIs_taken() { return is_taken; }

    public void setIs_taken() { this.is_taken = true; }

    public boolean getIs_pinned() { return is_pinned; }

    public void setIs_pinned(boolean is_pinned) { this.is_pinned = is_pinned; }

    public Position getPosition() { return position; }

    public void setPosition(Position position) { this.position = position; }

    public int getRow() { return this.position.getRow(); }

    public int getColumn() { return this.position.getColumn(); }

    public List<Position> getValid_positions() { return this.valid_positions; }

    @Override
    public Integer getPoints_value() { return points_value; }
}
