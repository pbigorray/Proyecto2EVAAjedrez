package Chess.model;

import static Chess.model.ChessType.BLACK_KNIGHT;
/**
 * Clase BlackKnight encargada de la logica de la pieza BlackKnight
 * @author Pau Bigorra
 * @version 1.0
 */
public class BlackKnight extends Knight{
    /**
     * Constructor del BlackKnight
     *
     * @param cell Celda que contiene la pieza
     */
    public BlackKnight(Cell cell) {
        super(cell, BLACK_KNIGHT);
        place();
    }

}
