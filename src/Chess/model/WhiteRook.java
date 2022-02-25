package Chess.model;

import static Chess.model.ChessType.WHITE_ROOK;

public class WhiteRook extends Rook{
    public WhiteRook(Cell cell) {
        super(cell, WHITE_ROOK);
        place();
    }
}
