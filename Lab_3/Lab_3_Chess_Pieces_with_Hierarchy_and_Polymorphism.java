// import java.util.Arrays;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// main class
public class Lab_3_Chess_Pieces_with_Hierarchy_and_Polymorphism{
private static Scanner scnr = new Scanner(System.in);
//hello

    // everyone used this
    public static void main(String[] args) {
        chess_piece_type [] pieceTypes = prompt(); //Array used to store only user piece types
        chessPiece [] chessPieces; // Array taht will be used to hold ches pieces as objects
        chessPieces = secondPrompt(pieceTypes); //Updating array with user pieces now as objects
        move(chessPieces); //
    }

    // Ivan Armenta
    public static chess_piece_type [] prompt() {
        chess_piece_type [] type = new chess_piece_type[6]; //enum array used to hold user input
        String typeInput = "";
        int i = 0; //counter for array 
        for(i = 0; !typeInput.equalsIgnoreCase("stop") && i < 6; i++){ //Loop to populate type array
            try{
                System.out.println("Select a chess piece: PAWN, ROOK, BISHOP, KNIGHT, QUEEN, KING \n\"Stop\" to continue to chess piece attributes");
                typeInput = scnr.nextLine().toUpperCase(); 

                type[i] = chess_piece_type.valueOf(typeInput); //Putting user input into enum array

                //Loop to check for duplicates
                for(int count = 0; count < i; count++) {
                    if(type[count] == type[i]){
                        System.out.println("Duplicate");
                        i--;
                    }
                    else{
                        type[i] = chess_piece_type.valueOf(typeInput);
                    }
                }
            //Exception if user inputs something wrong
            }
            catch(Exception e){
                System.out.println("Wrong input try again");
                i--;
            }
        }
        return type;
    }

    

    // Luis Gomez
    // takes array of type that user input and asks for more info to create the piece
    // checks that initial position is within bounds
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
    // traverses the array and asks for new position to try to move piece into
    public static void move(chessPiece [] chessPieces){
        int i = 0;
        String [] user_input;
        String newMove;
        while(i < chessPieces.length){
            try{
            System.out.println("Input new position to Move " + chessPieces[i].getType() + " at " + chessPieces[i].getColumn() + "," + chessPieces[i].getRow() + " to. EX: A, 3");
            newMove = scnr.nextLine();
            user_input = newMove.split(",\\s*");
            chess_piece_columns col = chess_piece_columns.valueOf(user_input[0].toUpperCase());
            int row = Integer.parseInt(user_input[1]);
            if(chessPieces[i].verifyTarget(col, row) == true){
                System.out.println("Piece " + chessPieces[i].getType() + " was successfuly moved to "+ col +" " + row );
                i++;
            }else{
                System.out.println("Piece "  + " was not able to move to " + col + " "+ row);
                i++;
            }
            }catch(Exception e){
                System.out.println("Invalid input try again");
            }
        }
    }

    
    
}
