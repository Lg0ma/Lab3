// LUIS GOMEZ
// chessboard class
public class chessboard {
    // method to check if coordinates are within range of the chessboard
    public static boolean withinChessboard(chess_piece_columns enum_column, int row) {
        // initialise int variables
        int CONSTANT_MAX_ROW_COL = 8;
        int MIN_ROW_COL = 1;
        // convert enum to an int
        int column = enum_column.ordinal() + 1;
        // if the inputs are within range of the chessboard
        if (column <= CONSTANT_MAX_ROW_COL && column >= MIN_ROW_COL) {
            if (row <= CONSTANT_MAX_ROW_COL && row >= MIN_ROW_COL) {
                // return true
                return true;
            }
        }
        // otherwise return false
        return false;
    }
}
