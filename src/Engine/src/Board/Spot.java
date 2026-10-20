package Board;

public class Spot {
    public Spot(int i_row, int i_column) {
        int row = i_row;
        int column = i_column;
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
            int row = Character.getNumericValue(letter);
            int column = Character.getNumericValue(digit);
        }
    }
}
