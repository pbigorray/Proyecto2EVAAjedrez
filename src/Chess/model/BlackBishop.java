package Chess.model;

import static Chess.model.ChessType.BLACK_BISHOP;

/**
 * Clase BlackBishop encargada de la logica de la pieza BlackBishop
 * @author Pau Bigorra
 * @version 1.0
 */
public class BlackBishop extends Bishop {
    /**
     * Constructor del BlackBishop
     *
     * @param cell Celda que contiene la pieza
     */
    public BlackBishop(Cell cell) {
        super(cell, BLACK_BISHOP);
        place();
    }
}
