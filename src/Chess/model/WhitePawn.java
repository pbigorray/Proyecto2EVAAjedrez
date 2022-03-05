package Chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de la logica del WhitePawn
 * @author Pau Bigorra
 * @version 1.0
 */
public class WhitePawn extends Pawn {
    /**
     * Constructor del WhitePawn
     *
     * @param cell Celda que contiene la pieza
     */
    public WhitePawn(Cell cell) {
        super(cell, ChessType.WHITE_PAWN);
        place();
    }

    /**
     * Metodo para obtener los movimientos del Pawn blanco
     *
     * @return Devuelve una lista de cordenadas con los movimientos
     */
    @Override
    public List<Coordinate> getNextMovements() {
        List<Coordinate> nextMovements = new ArrayList<>();
        Board board = new Board();
        Coordinate position = cell.getCoordinate();
        Coordinate aux;

        //move
        aux = position.up();
        if (canMoveTo(aux) && !board.containsPieceAt(aux)) {
            nextMovements.add(aux);

            if (position.getNumber() == 7 && canMoveTo(aux.up())) {
                nextMovements.add(aux.up());
            }
        }

        //kill
        aux = position.diagonalUpLeft();
        if (board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor() != getColor())
            nextMovements.add(aux);

        aux = position.diagonalUpRight();
        if (board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor() != getColor())
            nextMovements.add(aux);

        return nextMovements;


    }

}
