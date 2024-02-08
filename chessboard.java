// package
package Lab_3;
// import
import Lab_3.Lab_3_Chess_Pieces_with_Hierarchy_and_Polymorphism.chess_piece_columns;

public class chessboard {
    // VARS?
    // MANDATORY METHOD
    public static boolean withinChessboard(chess_piece_columns enum_column, int row) {
        int CONSTANT_MAX_ROW_COL = 8;
        int MIN_ROW_COL = 1;
        // convert enum to an int
        int column = enum_column.ordinal() + 1;
        if (column <= CONSTANT_MAX_ROW_COL && column >= MIN_ROW_COL) {
            if (row <= CONSTANT_MAX_ROW_COL && row >= MIN_ROW_COL) {
                return true;
            }
        }
        return false;
    }
}
