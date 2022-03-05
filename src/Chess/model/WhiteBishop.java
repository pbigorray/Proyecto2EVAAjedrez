package Chess.model;

import static Chess.model.ChessType.WHITE_BISHOP;
/**
 * Clase WhiteBishop encargada de la logica de la pieza WhiteBishop
 * @author Pau Bigorra
 * @version 1.0
 */
public class WhiteBishop extends Bishop{
    /**
     * Constructor del WhiteBishop
     *
     * @param cell Celda que contiene la pieza
     */
    public WhiteBishop(Cell cell) {
        super(cell, WHITE_BISHOP);
        place();
    }
}
