package Chess.model;

import static Chess.model.ChessType.BLACK_ROOK;

public class BlackRook extends Rook{
    public BlackRook(Cell cell) {
        super(cell, BLACK_ROOK);
        place();
    }
}
