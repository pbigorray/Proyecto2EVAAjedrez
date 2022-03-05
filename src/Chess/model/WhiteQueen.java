package Chess.model;
/**
 * Clase WhiteQueen encargada de la logica de la pieza WhiteQueen
 * @author Pau Bigorra
 * @version 1.0
 */
public class WhiteQueen extends Queen{
    /**
     * Constructor del WhiteQueen
     *
     * @param cell Celda que contiene la pieza
     */
    public WhiteQueen(Cell cell) {
        super(cell, ChessType.WHITE_QUEEN);
        place();
    }
}
