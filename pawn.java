// package 
package Lab_3; // UPDATE
// import
import Lab_3.Lab_3_Chess_Pieces_with_Hierarchy_and_Polymorphism.chess_piece_type;
import Lab_3.Lab_3_Chess_Pieces_with_Hierarchy_and_Polymorphism.chess_piece_color;
import Lab_3.Lab_3_Chess_Pieces_with_Hierarchy_and_Polymorphism.chess_piece_columns;

// ANDRE MELENDEZ
// pawn class
class pawn extends chessPiece {

    // initialize a private chess_piece_type for the name
    private chess_piece_type piece_name;
    // initialize a private chess_piece_type for the color
    private chess_piece_color color;
    // initialize a private chess_piece_type for the x-coord
    private chess_piece_columns column;
    // initialize a private int for the y-coord
    private int row;

    // empty constructor
    public pawn() {
        // default values
        this.piece_name = chess_piece_type.BISHOP;
        this.color = chess_piece_color.WHITE;
        this.column = chess_piece_columns.A; 
        this.row = 0;
    }

    // constructor with parameters for each class field
    public pawn(chess_piece_type name, chess_piece_color color, chess_piece_columns x_coord, int y_coord) {
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

        // initialize a boolean
        boolean valid = true;
        // turn the enum into an int
        int new_column = column.ordinal() + 1;
        int old_column = getColumn().ordinal() + 1;
        // if statement to check if the user input is within the chessboard range
        if (!chessboard.withinChessboard(column, row)) {
            // print statement and return
            System.out.println("Input is out of range ... ");
            valid = false;
        }
        // if the team of the pawn is white
        if (getColor().ordinal() == 1) {
            // check if the x-coordinate or y-coordinate doesn't match the expected move
            if ((old_column != new_column) || ((getRow() + 1) != row)) {
                // set valid to false if the move is not valid'
                valid = false;
            }
        }
        // if the team of the pawn is black
        if (getColor().ordinal() == 0) {
            // check if the x-coordinate or y-coordinate doesn't match the expected move
            if (old_column != new_column || (getRow() - 1) != row) {
                // set valid to false if the move is not valid
                valid = false;
            }
        }
        // if valid is true up to this point
        if (valid == true) {
            // set the valid new coordinates to the object
            setColumn(column);
            setRow(row);
        }
        // return the validity of the move
        return valid;
    }
}