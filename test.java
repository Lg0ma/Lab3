class bishop{
    private chess_piece_type pieceName;
    private chess_piece_color color;
    private chess_piece_columns column;

    public bishop(){
        this.pieceName = chess_piece_type.BISHOP;
        this.color = chess_piece_color.WHITE;
        this.column = chess_piece_columns.A;
    }

    public chess_piece_type getType(){
        return pieceName;
    }

    public chess_piece_color getColor(){
        return color;
    }

    public chess_piece_columns getColumn(){
        return column;
    }

}

public class test {

    public static void main(String[] args) {
        bishop new_bishop = new bishop();
        System.out.println(new_bishop.getType());
        System.out.println(new_bishop.getColor());
        System.out.println(new_bishop.getColumn());
    }
}
