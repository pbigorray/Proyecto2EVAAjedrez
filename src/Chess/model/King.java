package Chess.model;

import java.util.ArrayList;
import java.util.List;

public abstract class King extends Piece{
    public King(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    @Override
    public List<Coordinate> getNextMovements() {
        List<Coordinate> nextMovements =new ArrayList<>();
        Coordinate position = cell.getCoordinate();
        Coordinate aux;

        //Up
        aux = position.up();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }

        //Down
        aux=position.down();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }

        //Left
        aux=position.left();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }

        //Right
        aux=position.right();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }

        //DiagonalUpLeft
        aux=position.diagonalUpLeft();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }

        //DiagonalUpRight
        aux=position.diagonalUpRight();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }

        //DiagonalDownLeft
        aux=position.diagonalDownLeft();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }

        //DiagonalDownRight
        aux=position.diagonalDownRight();
        if (canMoveTo(aux)){
            nextMovements.add(aux);
        }

        return nextMovements;

    }

}
