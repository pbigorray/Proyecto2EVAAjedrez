package Chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta Queen encargada de utilizar la logica de las clases Rook y Bishop para su propia logica
 * @author Pau Bigorra
 * @version 1.0
 */
public abstract class Queen extends Piece {
    /**
     * Constructor de la Queen
     *
     * @param cell      Celda que contiene la pieza
     * @param chessType Tipo de la pieza
     */
    public Queen(Cell cell, ChessType chessType) {
        super(cell, chessType);
        place();
    }

    /**
     * Metodo para optener los movimientos de la Queen
     *
     * @return Devuelve una lista de cordenadas con los movimientos
     */
    @Override
    public List<Coordinate> getNextMovements() {

        List<Coordinate> rook = Rook.getNextMovementsAsRook(this);
        List<Coordinate> bishop = Bishop.getNextMovementsAsBishop(this);

        List<Coordinate> queen = new ArrayList<>();
        int aux = 0;
        if (rook.size() < 0)
            for (int i = 0; i < rook.size(); i++) {
                queen.add(rook.get(i));
                aux++;
            }
        if (bishop.size() < 0)
            for (int i = 0; i < bishop.size(); i++) {
                queen.add(bishop.get(i));
                aux++;
            }
        return queen;
    }
}
