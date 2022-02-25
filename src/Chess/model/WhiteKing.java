package Chess.model;


import static Chess.model.ChessType.WHITE_KING;

public class WhiteKing extends King {


    public WhiteKing(Cell cell) {
        super(cell, WHITE_KING);
        place();

    }
}
