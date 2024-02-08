// package 
package Lab_3; // UPDATE
// import
import Lab_3.Lab_3_Chess_Pieces_with_Hierarchy_and_Polymorphism.chess_piece_type;
import Lab_3.Lab_3_Chess_Pieces_with_Hierarchy_and_Polymorphism.chess_piece_color;
import Lab_3.Lab_3_Chess_Pieces_with_Hierarchy_and_Polymorphism.chess_piece_columns;

// ANDRE MELENDEZ
// bishop class
class bishop extends chessPiece {

    // initialize a private chess_piece_type for the name
    private chess_piece_type piece_name;
    // initialize a private chess_piece_type for the color
    private chess_piece_color color;
    // initialize a private chess_piece_type for the x-coord
    private chess_piece_columns column;
    // initialize a private int for the y-coord
    private int row;

    // empty constructor
    public bishop() {
        // default values
        this.piece_name = chess_piece_type.BISHOP;
        this.color = chess_piece_color.WHITE;
        this.column = chess_piece_columns.A;
        this.row = 0;
    }

    // constructor with parameters for each class field
    public bishop(chess_piece_type name, chess_piece_color color, chess_piece_columns x_coord, int y_coord) {
        // set values
        this.piece_name = name;
        this.color = color;
        this.column = x_coord;
        this.row = y_coord;
    }

    // getter method for color
    public chess_piece_color getColor() {
        return color;
    }

    // getter method for column
    public chess_piece_columns getColumn() {
        return column;
    }

    // getter method for row
    public int getRow() {
        return row;
    }

    // setter method for column
    public void setColumn(chess_piece_columns x_coord) {
        this.column = x_coord;
    }

    // setter method for row
    public void setRow(int y_coord) {
        this.row = y_coord;
    }

    // method to verify its piece movement
    @Override
    public Boolean verifyTarget(chess_piece_columns column, int row) {

        // turn the enum into an int
        int new_column = column.ordinal() + 1;
        int old_column = getColumn().ordinal() + 1;
        // find the current y position of the rook
        int old_row = getRow();
        // if statement to check if the user input is within the chessboard range
        if (!chessboard.withinChessboard(column, row)) {
            // print statement and return
            System.out.println("Input is out of range ... ");
            return false;
        }
        // find the absolute difference in the x and y coordinates
        int deltax = Math.abs(old_column - new_column);
        int deltay = Math.abs(old_row - row);
        // check if the move is a valid diagonal move
        if ((deltax == deltay) && (deltax > 0)) {
            // set the valid new coordinates to the object
            setColumn(column);
            setRow(row);
            // return true
            return true;
        }
        // return false
        return false;
    }
}