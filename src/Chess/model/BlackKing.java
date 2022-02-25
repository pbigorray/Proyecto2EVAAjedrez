package Chess.model;

import static Chess.model.ChessType.BLACK_KING;

public class BlackKing extends King {
    public BlackKing (Cell cell){
        super(cell,BLACK_KING);
        place();
    }
}
