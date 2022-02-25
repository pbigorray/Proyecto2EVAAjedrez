package Chess.model;

import static Chess.model.ChessType.BLACK_KNIGHT;

public class BlackKnight extends Knight{
    public BlackKnight(Cell cell) {
        super(cell, BLACK_KNIGHT);
        place();
    }

}
