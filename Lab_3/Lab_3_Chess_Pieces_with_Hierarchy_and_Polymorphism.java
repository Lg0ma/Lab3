import java.util.Arrays;
import java.util.Scanner;

// main class
public class Lab_3_Chess_Pieces_with_Hierarchy_and_Polymorphism{
private static Scanner scnr = new Scanner(System.in);
//hello

    // everyone used this
    public static void main(String[] args) {
        chess_piece_type [] pieceTypes = prompt();
        chessPiece [] chessPieces;
        chessPieces = secondPrompt(pieceTypes);
        move(chessPieces);


        // // create a pawn object
        // chessPiece myPawn = new pawn(chess_piece_type.PAWN, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // // create a knight object
        // chessPiece myKnight = new knight(chess_piece_type.KNIGHT, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // // create a rook object
        // chessPiece myRook= new rook(chess_piece_type.ROOK, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // // create a bishop object
        // chessPiece myBishop = new bishop(chess_piece_type.BISHOP, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // // create a queen object
        // chessPiece myQueen = new queen(chess_piece_type.QUEEN, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // System.out.println(myQueen.verifyTarget(chess_piece_columns.E, 3)); // WORKS

        // // create a king object
        // chessPiece myKing = new king(chess_piece_type.KING, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // System.out.println(myKing.verifyTarget(chess_piece_columns.A, 5)); // WORKS

        // System.out.println("Testing create chess piece method");
        // chessPiece test = chessPiece.create_chess_piece(chess_piece_type.PAWN, chess_piece_color.BLACK, chess_piece_columns.A, 7);

        // System.out.println(test.verifyTarget(chess_piece_columns.A, 6));
        // System.out.println("");

        // // testing how to convert a string into an enum variable type // WORKS
        // String input = "pawn";
        // input = input.toUpperCase();
        // chess_piece_type type = chess_piece_type.valueOf(input); // only works with upper case, so will need to always upper case type input
        // System.out.println(type);



    }

    // Ivan Armenta
    //The user can provide the chess pieces in any order.   
    //The user should be allowed to select a piece and set its initial position
    // Works as intender, only problem is when stop is typed, the exception is called
    //Assumption – you may assume that your user does not repeat a chess piece type.
    //Only 6 chess pieces, so one per type
    public static chess_piece_type [] prompt() {
        chess_piece_type [] type = new chess_piece_type[6];
        String typeInput = "";
        int i = 0; //counter for array 
        while(!typeInput.equalsIgnoreCase("stop") && i < 6){ //Loop to get input into an array (empty object)
            try{
                System.out.println("Select a chess piece: PAWN, ROOK, BISHOP, KNIGHT, QUEEN, KING \n\"Stop\" to continue to chess piece attributes");
                //Changed the prompt from what I understood on the instructions
                //Please input what piece you want to create: PAWN, ROOK, BISHOP, KNIGHT, QUEEN, KING
                typeInput = scnr.nextLine();
                type[i] = chess_piece_type.valueOf(typeInput.toUpperCase());
                i++;
            }
            catch(Exception e){
                if(!e.equals("stop")){
                    System.out.println("Wrong input try again");
                }

            }
        }
        
        return type;
    }


    // Luis Gomez
    // 
    public static chessPiece[] secondPrompt(chess_piece_type [] piece_type){
        chessPiece [] newChesspieces = new chessPiece[piece_type.length];
        String [] user_input;
        String piece_info;
        int i = 0;
        while (i < piece_type.length){
            try{
            System.out.println("Please input "+ piece_type[i] + "'s Color, Coloumn, and row EX: BLACK, A, 3");
            piece_info = scnr.nextLine();
            user_input = piece_info.split(",\\s*");
            int row = Integer.parseInt(user_input[2]);
            if(chessboard.withinChessboard((chess_piece_columns.valueOf(user_input[1].toUpperCase())), row) == true){
                System.out.println("Move is valid ");
            newChesspieces[i] = chessPiece.create_chess_piece(piece_type[i],(chess_piece_color.valueOf(user_input[0].toUpperCase())),(chess_piece_columns.valueOf(user_input[1].toUpperCase())),row);
            i++;
            }
        }catch(Exception e){
            System.out.println("Invalid input try again");
        }
        }
        return newChesspieces;
    }

    //Luis Gomez
    public static void move(chessPiece [] chessPieces){
        int i = 0;
        String [] user_input;
        String newMove;
        while(i < chessPieces.length){
            try{
            System.out.println("Input new position to Move " + chessPieces[i].getClass() + " to EX: A, 3");
            newMove = scnr.nextLine();
            user_input = newMove.split(",\\s*");
            chess_piece_columns col = chess_piece_columns.valueOf(user_input[0].toUpperCase());
            int row = Integer.parseInt(user_input[2]);
            if(chessPieces[i].verifyTarget(col, row) == true){
                System.out.println("Piece " + chessPieces[i].getClass() + " was successfuly moved to "+ col + row );
                i++;
            }else{
                System.out.println("Move is invalid ");
                i++;
            }

            }catch(Exception e){
                i++;
            }
        }
    }
    
}
