package Chess.model;

public enum ChessType {

    WHITE_KING("♚", PieceColor.WHITE),
    WHITE_QUEEN("♛", PieceColor.WHITE),
    WHITE_ROOK("♜", PieceColor.WHITE),
    WHITE_BISHOP("♝", PieceColor.WHITE),
    WHITE_KNIGHT("♞", PieceColor.WHITE),
    WHITE_PAWN("♟", PieceColor.WHITE),
    BLACK_KING("♚", PieceColor.BLACK),
    BLACK_QUEEN("♛", PieceColor.BLACK),
    BLACK_ROOK("♜", PieceColor.BLACK),
    BLACK_BISHOP("♝", PieceColor.BLACK),
    BLACK_KNIGHT("♞", PieceColor.BLACK),
    BLACK_PAWN("♟", PieceColor.BLACK);

    private String shape;
    private PieceColor color;

    ChessType(String shape,PieceColor color){
        this.shape = shape;
        this.color = color;
    }
    public String getShape(){
        return shape;
    }

    public PieceColor getColor() {
        return color;
    }

}
