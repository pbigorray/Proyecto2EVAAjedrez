package Chess.model;

import static Chess.model.ChessType.WHITE_KNIGHT;

public class WhiteKnight extends Knight{
    public WhiteKnight(Cell cell) {
        super(cell, WHITE_KNIGHT);
        place();
    }
}
