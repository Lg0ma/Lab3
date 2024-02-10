// an abstract class, base for all other chess piece object classes
public abstract class chessPiece {
    // initialize private attributes
    private chess_piece_type piece_name;
    private chess_piece_color color;
    private chess_piece_columns column;
    private int row;

    // constructor with no attributes
    public chessPiece() {
        // default attributes
        this.piece_name = chess_piece_type.PAWN;
        this.color = chess_piece_color.WHITE;
        this.column = chess_piece_columns.A;
        this.row = 0;
    }
    
    // constructor with attributes
    public chessPiece(chess_piece_type name, chess_piece_color color, chess_piece_columns column, int row) {
        // set attributes
        this.piece_name = name;
        this.color = color;
        this.column = column;
        this.row = row;
    }

    public chess_piece_type getType(){
        return piece_name;
    }
    
    // method to get color of object
    public chess_piece_color getColor() {
        return color;
    }

    // method to get column of object
    public chess_piece_columns getColumn() {
        return column;
    }

    // method to get row of object
    public int getRow() {
        return row;
    }

    // method to create a chess piece
    public static chessPiece create_chess_piece(chess_piece_type type, chess_piece_color color, chess_piece_columns column, int row) {
        // switch case block to create a specific chess piece
        switch (type) {
            // type bishop
            case BISHOP:
                return new bishop(type, color, column, row);
            // type king
            case KING:
                return new king(type, color, column, row);
            // type knight
            case KNIGHT:
                return new knight(type, color, column, row);
            // type pawn
            case PAWN:
                return new pawn(type, color, column, row);
            // type queen
            case QUEEN:
                return new queen(type, color, column, row);
            // type rook
            case ROOK:
                return new rook(type, color, column, row);
            // otherwise the type is invalid
            default:
                throw new IllegalArgumentException("Invalid chess piece type");
        }
    }

    // abstract method to verify its piece movement
    public abstract Boolean verifyTarget(chess_piece_columns column, int row);
    
}
