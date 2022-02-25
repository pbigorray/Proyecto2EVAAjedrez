package Chess.model;

import java.util.ArrayList;
import java.util.List;

public class BlackPawn extends Pawn{
    public BlackPawn(Cell cell) {
        super(cell, ChessType.BLACK_PAWN);
        place();
    }

    @Override
    public List<Coordinate> getNextMovements() {
        List<Coordinate> nextMovements =new ArrayList<>();
        Board board =new Board();
        Coordinate position = cell.getCoordinate();
        Coordinate aux;

        //move
        aux=position.down();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
            if (position.getNumber()==2&&canMoveTo(aux.down())){
                nextMovements.add(aux.down());
            }
        }

        //kill
        aux=position.diagonalDownLeft();
        if (board.containsCellAt(aux)&&board.containsPieceAt(aux)&&board.getCellAt(aux).getPiece().getColor()!=getColor())
            nextMovements.add(aux);

        aux=position.diagonalDownRight();
        if (board.containsCellAt(aux)&&board.containsPieceAt(aux)&&board.getCellAt(aux).getPiece().getColor()!=getColor())
            nextMovements.add(aux);

        return nextMovements;


    }
}
