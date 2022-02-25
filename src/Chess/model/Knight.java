package Chess.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Knight extends Piece {
    public Knight(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

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
