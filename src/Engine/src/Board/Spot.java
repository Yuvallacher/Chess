package Board;

public class Spot {
    private int row;
    private int column;

    public Spot(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Spot(String position) {
        if (position.length() != 2) {
            throw new IllegalArgumentException("String position must have 2 characters!");
        } else {
            char letter = position.charAt(0);
            char digit = position.charAt(1);
            if (!Character.isLetter(letter) || !Character.isDigit(digit)) {
                throw new IllegalArgumentException("String position must be of format <Letter><Digit>, for example D4");
            }
            this.row = Character.getNumericValue(letter);
            this.column = Character.getNumericValue(digit);
        }
    }

    public int getRow() { return this.row; }
    public int getColumn() { return this.column; }

    public void updateSpot(Spot new_spot) {
        this.row = new_spot.getRow();
        this.column = new_spot.getColumn();
    }
}
