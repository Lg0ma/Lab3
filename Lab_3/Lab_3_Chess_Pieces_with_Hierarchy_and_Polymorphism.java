import java.util.Scanner;

// main class
public class Lab_3_Chess_Pieces_with_Hierarchy_and_Polymorphism{
private static Scanner scnr = new Scanner(System.in);
//hello

    // everyone used this
    public static void main(String[] args) {

        // create a pawn object
        chessPiece myPawn = new pawn(chess_piece_type.PAWN, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // create a knight object
        chessPiece myKnight = new knight(chess_piece_type.KNIGHT, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // create a rook object
        chessPiece myRook= new rook(chess_piece_type.ROOK, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // create a bishop object
        chessPiece myBishop = new bishop(chess_piece_type.BISHOP, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // create a queen object
        chessPiece myQueen = new queen(chess_piece_type.QUEEN, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        System.out.println(myQueen.verifyTarget(chess_piece_columns.E, 3)); // WORKS

        // create a king object
        chessPiece myKing = new king(chess_piece_type.KING, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        System.out.println(myKing.verifyTarget(chess_piece_columns.A, 5)); // WORKS

        System.out.println("Testing create chess piece method");
        chessPiece test = chessPiece.create_chess_piece(chess_piece_type.PAWN, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        System.out.println(test.verifyTarget(chess_piece_columns.A, 6));
        System.out.println("");

        // testing how to convert a string into an enum variable type // WORKS
        String input = "pawn";
        input = input.toUpperCase();
        chess_piece_type type = chess_piece_type.valueOf(input); // only works with upper case, so will need to always upper case type input
        System.out.println(type);


    }

    // NAME
    // 
    public static void prompt() {
        System.out.println("Please input what piece you want to create: PAWN, ROOK, BISHOP, KNIGHT, QUEEN, KING");
        String typeInput = scnr.nextLine();
        chess_piece_type type = chess_piece_type.valueOf(typeInput);
        


    }


    // NAME
    // 
}
