package Board;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Position(String position) {
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

    public void updatePosition(Position new_position) {
        this.row = new_position.getRow();
        this.column = new_position.getColumn();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Position other_as_position))
            return false;
        return this.row == other_as_position.row && this.column == other_as_position.column;
    }
}
