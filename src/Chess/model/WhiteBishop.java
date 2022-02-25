package Chess.model;

import static Chess.model.ChessType.WHITE_BISHOP;

public class WhiteBishop extends Bishop{
    public WhiteBishop(Cell cell) {
        super(cell, WHITE_BISHOP);
        place();
    }
}
