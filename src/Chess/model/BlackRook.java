package Chess.model;

import static Chess.model.ChessType.BLACK_ROOK;
/**
 * Clase BlackRook encargada de la logica de la pieza BlackRook
 * @author Pau Bigorra
 * @version 1.0
 */
public class BlackRook extends Rook{
    /**
     * Constructor del BlackRook
     *
     * @param cell Celda que contiene la pieza
     */
    public BlackRook(Cell cell) {
        super(cell, BLACK_ROOK);
        place();
    }
}
