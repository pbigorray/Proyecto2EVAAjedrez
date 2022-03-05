package Chess.model.dynamicStructure;

import Chess.model.ChessType;
import Chess.model.IDeletePieceManager;
import Chess.model.Piece;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase encargada del control de piezas
 * @author Pau Bigorra
 */
public class MyStore implements IDeletePieceManager, Serializable {
    private List<Piece> pieces;

    /**
     * Constructor de la clase que genera una lista
     */
    public MyStore(){
        this.pieces=new LinkedList<>();
    }

    /**
     * Metodo para añadir una pieza
     * @param piece Pieza a añadir
     */
    @Override
    public void add(Piece piece) {
        pieces.add(piece);
    }

    /**
     * Metodo encargado de devolver la primera
     * @return Devuelve la primera pieza de la lista
     */
    @Override
    public Piece getFirst() {
        return pieces.get(0);
    }

    /**
     * Metodo encargado de eliminar una pieza
     * @param piece elimina la pieza que se le pasa
     */
    @Override
    public void remove(Piece piece) {
        pieces.remove(piece);
    }

    /**
     * Metodo para contar piezas segun su ChessType
     * @param chessType El tipo de pieza que deseas contar
     * @return Devuelve la cantidad de piezas de ese chessType
     */
    @Override
    public int count(ChessType chessType) {
        return (int) pieces.stream()
                .filter(p->p.getChessType()==chessType)
                .count();

//        int suma =0;
//        for (Piece piece: pieces)
//            if ()

    }
}
