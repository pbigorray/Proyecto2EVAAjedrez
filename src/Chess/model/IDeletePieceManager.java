package Chess.model;

/**
 *  Interfaz encargada del borrado de piezas
 *  @author Pau Bigorra
 *  @version 1.0
 */
public interface IDeletePieceManager {
    /**
     * Metodo para añadir una pieza
     * @param piece Pieza a añadir
     */
    void add(Piece piece);

    /**
     * Metodo encargado de devolver la primera
     * @return Devuelve una pieza
     */
    Piece getFirst();

    /**
     * Metodo encargado de eliminar una pieza
     * @param piece elimina la pieza que se le pasa
     */
    void remove(Piece piece);

    /**
     * Metodo para contar piezas segun su ChessType
     * @param chessType El tipo de pieza que deseas contar
     * @return Devuelve la cantidad de piezas de ese chessType
     */
    int count(ChessType chessType);
}
