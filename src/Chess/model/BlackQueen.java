package Chess.model;

import static Chess.model.ChessType.BLACK_QUEEN;

public class BlackQueen extends Queen {

    public BlackQueen(Cell cell) {
        super(cell, BLACK_QUEEN);
        place();
    }
}
