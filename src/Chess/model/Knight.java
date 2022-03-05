package Chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase asbtracta Knight encargada de la logica de los tipos de Knight
 * @author Pau Bigorra
 * @version 1.0
 */
public abstract class Knight extends Piece {
    /**
     * Constructor del Knight
     * @param cell Celda a la que se le asigna al momento de crearse
     * @param chessType Tipo de la pieza
     */
    public Knight(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    /**
     * Metodo para optener los siguientes movimientos del Knight
     * @return Devuelve una lista de cordenadas con los movimientos
     */
    @Override
    public List<Coordinate> getNextMovements() {

        List<Coordinate> nextMovements =new ArrayList<>();
        Coordinate position = cell.getCoordinate();
        Coordinate aux;
        //Up
        aux = position.up().up().left();
        if(canMoveTo(aux))
            nextMovements.add(aux);

        aux = position.up().up().right();
        if(canMoveTo(aux))
            nextMovements.add(aux);

        //Down
        aux = position.down().down().left();
        if(canMoveTo(aux))
            nextMovements.add(aux);

        aux = position.down().down().right();
        if(canMoveTo(aux))
            nextMovements.add(aux);

        //Left
        aux = position.left().left().down();
        if(canMoveTo(aux))
            nextMovements.add(aux);

        aux = position.left().left().up();
        if(canMoveTo(aux))
            nextMovements.add(aux);

        //Right
        aux = position.right().right().down();
        if(canMoveTo(aux))
            nextMovements.add(aux);

        aux = position.right().right().up();
        if(canMoveTo(aux))
            nextMovements.add(aux);


        return nextMovements;
    }

}
