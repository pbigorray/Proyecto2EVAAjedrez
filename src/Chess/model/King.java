package Chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta King encargada de la logica de las pizas King
 * @author Pau Bigorra @version 1.0
 * @version 1.0
 */
public abstract class King extends Piece {
    /**
     * Constructor del rey
     * @param cell Celda a la que se le asigna al momento de crearse
     * @param chessType Tipo de la pieza
     */
    public King(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    /**
     * Metodo para optener los siguientes movimientos del King
     * @return Devuelve una lista de cordenadas con los movimientos
     */
    @Override
    public List<Coordinate> getNextMovements() {
        List<Coordinate> nextMovements = new ArrayList<>();
        Coordinate position = cell.getCoordinate();
        Coordinate aux;

        //Up
        aux = position.up();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }

        //Down
        aux = position.down();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }

        //Left
        aux = position.left();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }

        //Right
        aux = position.right();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }

        //DiagonalUpLeft
        aux = position.diagonalUpLeft();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }

        //DiagonalUpRight
        aux = position.diagonalUpRight();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }

        //DiagonalDownLeft
        aux = position.diagonalDownLeft();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }

        //DiagonalDownRight
        aux = position.diagonalDownRight();
        if (canMoveTo(aux)) {
            nextMovements.add(aux);
        }

        return nextMovements;

    }

}
