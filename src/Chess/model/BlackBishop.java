package Chess.model;

import static Chess.model.ChessType.BLACK_BISHOP;

public class BlackBishop extends Bishop {

    public BlackBishop(Cell cell) {
        super(cell, BLACK_BISHOP);
        place();
    }
}
