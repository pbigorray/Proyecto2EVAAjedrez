package Chess.model.dynamicStructure;

import Chess.model.ChessType;
import Chess.model.IDeletePieceManager;
import Chess.model.Piece;

/**
 * Lista simplemante enlazada creada para las piezas
 * @author Pau Bigorra
 */
public class MyList implements IDeletePieceManager {
    private Node head;
    private int size;

    /**
     * Metodo para añadir una pieza
     * @param piece Pieza a añadir
     */
    @Override
    public void add(Piece piece) {
        Node aux = new Node(piece);
        if (head == null)
            head = aux;
        else {
            aux.setNext(head);
            head = aux;
        }
        size++;
    }

//    @Override
//    public Piece getFirst() {
//        return null;
//    }

    /**
     * Metodo encargado de devolver la primera
     * @return
     */
    @Override
    public Piece getFirst() {
        if (head==null)
            return null;
        else {
            Piece p = head.getInfo();
            head= head.getNext();
            return p;
        }
    }

    /**
     * Metodo encargado de eliminar una pieza
     * @param piece elimina la pieza que se le pasa
     */
    @Override
    public void remove(Piece piece) {
        if (head == null)
            return;
        if (head.getInfo().equals(piece)) {
            head = head.getNext();
            size--;
        } else {
            Node aux2 = head, aux1 = head.getNext();
            while (aux1 != null && aux2.getInfo() != piece) {
                aux2 = aux1;
                aux1 = aux1.getNext();
            }
        }
    }

    /**
     * Metodo para contar piezas segun su ChessType
     * @param chessType El tipo de pieza que deseas contar
     * @return devuelve la cantidad de piezas de ese chessType
     */
    @Override
    public int count(ChessType chessType) {

        int cout = 0;
        Node aux = head;

        while (aux != null) {
            if (aux.getInfo().getChessType().equals(chessType)) {
                cout++;
            }

            aux = aux.getNext();
        }


        return cout;
    }
}
