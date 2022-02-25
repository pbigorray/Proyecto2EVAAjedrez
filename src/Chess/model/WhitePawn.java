package Chess.model;

import java.util.ArrayList;
import java.util.List;

public class WhitePawn extends Pawn{
    public WhitePawn(Cell cell) {
        super(cell, ChessType.WHITE_PAWN);
        place();
    }
    @Override
    public List<Coordinate> getNextMovements() {
        List<Coordinate> nextMovements =new ArrayList<>();
        Board board =new Board();
        Coordinate position = cell.getCoordinate();
        Coordinate aux;

        //move
        aux=position.up();
        if (canMoveTo(aux)&&!board.containsPieceAt(aux)){
            nextMovements.add(aux);

            if (position.getNumber()==7&&canMoveTo(aux.up())){
                nextMovements.add(aux.up());
            }
        }

        //kill
        aux=position.diagonalUpLeft();
        if (board.containsCellAt(aux)&&board.containsPieceAt(aux)&&board.getCellAt(aux).getPiece().getColor()!=getColor())
            nextMovements.add(aux);

        aux=position.diagonalUpRight();
        if (board.containsCellAt(aux)&&board.containsPieceAt(aux)&&board.getCellAt(aux).getPiece().getColor()!=getColor())
            nextMovements.add(aux);

        return nextMovements;


    }
    //transform to queen
}
