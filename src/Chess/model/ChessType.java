package Chess.model;

/**
 * Enumerador encargado de poner el icono correcto al tipo de pieza correspondiente
 * @author Pau Bigorra
 * @version 1.0
 */
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

    /**
     * Constructor del ChessType
     * @param shape
     * @param color
     */
    ChessType(String shape,PieceColor color){
        this.shape = shape;
        this.color = color;
    }

    /**
     * Getter de la forma de la pieza
     * @return Devuelve el icono correspondiente
     */
    public String getShape(){
        return shape;
    }

    /**
     * Getter del color de la pieza
     * @return Devuelve el color correspondiente
     */
    public PieceColor getColor() {
        return color;
    }

}
