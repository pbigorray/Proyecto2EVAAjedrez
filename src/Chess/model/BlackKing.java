package Chess.model;

import static Chess.model.ChessType.BLACK_KING;
/**
 * Clase BlackKing encargada de la logica de la pieza BlackKing
 * @author Pau Bigorra
 * @version 1.0
 */
public class BlackKing extends King {
    /**
     * Constructor del BlackKing
     *
     * @param cell Celda que contiene la pieza
     */
    public BlackKing (Cell cell){
        super(cell,BLACK_KING);
        place();
    }
}
