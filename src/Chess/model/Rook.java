package Chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta de Rook encargada de la logica de los tipos de Rook
 * @author Pau Bigorra
 * @version 1.0
 */
public abstract class Rook extends Piece {
    /**
     * Constructor del Rook
     *
     * @param cell      Celda que la contiene
     * @param chessType Tipo de la pieza
     */
    public Rook(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }

    /**
     * Metodo para obtener los siguientes movimientos de la pieza indicada
     *
     * @param piece Pieza de la cual se obtienen los movimientos
     * @return Devuelve una lista de cordenadas con los movimientos
     */
    public static List<Coordinate> getNextMovementsAsRook(Piece piece) {
        List<Coordinate> nextMovements = new ArrayList<>();
        Board board = piece.cell.getBoard();
        Coordinate position = piece.cell.getCoordinate();
        Coordinate aux;
        boolean continiu = true;

        //Up
        aux = position;
        do {
            aux = aux.up();
            if (canMoveTo(aux, piece)) {
                nextMovements.add(aux);
            }
            if (board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor() != piece.getColor()) {
                continiu = false;
            }
        } while (canMoveTo(aux, piece) && continiu == true);

        //Down
        aux = position;
        continiu = true;
        do {
            aux = aux.down();
            if (canMoveTo(aux, piece)) {
                nextMovements.add(aux);

            }
            if (board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor() != piece.getColor()) {
                continiu = false;
            }
        } while (canMoveTo(aux, piece) && continiu == true);


        //Left
        aux = position;
        continiu = true;
        do {
            aux = aux.left();
            if (canMoveTo(aux, piece)) {
                nextMovements.add(aux);

            }
            if (board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor() != piece.getColor()) {
                continiu = false;
            }
        } while (canMoveTo(aux, piece) && continiu == true);

        //Right
        aux = position;
        continiu = true;
        do {
            aux = aux.right();
            if (canMoveTo(aux, piece)) {
                nextMovements.add(aux);

            }
            if (board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor() != piece.getColor()) {
                continiu = false;
            }
        } while (canMoveTo(aux, piece) && continiu == true);


        return nextMovements;
    }

    /**
     * Metodo estatico para optener los movimientos del Rook
     *
     * @return Devuelve una lista de cordenadas con los movimientos
     */
    @Override
    public List<Coordinate> getNextMovements() {
        return getNextMovementsAsRook(this);
    }

    /**
     * Metodo para comprobar si se puede mover a las cordenadas designadas
     *
     * @param coordinate Condenadas a las que desea moverse
     * @param piece      Pieza que desea mover
     * @return Devuelve verdadero si se puede mover
     */
    private static boolean canMoveTo(Coordinate coordinate, Piece piece) {
        Board board = piece.cell.getBoard();

        return (board.containsCellAt(coordinate) && !board.containsPieceAt(coordinate)) ||
                (board.containsCellAt(coordinate) &&
                        board.containsPieceAt(coordinate) &&
                        board.getCellAt(coordinate).getPiece().getColor() != piece.getColor());
    }
}
