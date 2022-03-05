package Chess.model.dynamicStructure;

import Chess.model.Piece;

/**
 * Clase de nodo que contiene la informacion de la pieza y la siguiente pieza en la lista
 * @author Pau Bigorra
 */
public class Node {

        private Piece info;
        private Node next;

    /**
     * Constructor de la clase
     * @param piece Pieza la cual se almacenara en la lista
     */
        public Node(Piece piece){
            this.info=piece;
            this.next=null;
        }

    /**
     * Metodo para optener la informacion de la pieza del nodo
     * @return Devuelve la pieza lamacenada
     */
        public Piece getInfo() {
            return info;
        }

    /**
     * Metodo encadado de optener el siguiente nodo
     * @return Devuelve el nodo al que hace referencia
     */
        public Node getNext() {
            return next;
        }

    /**
     * Metodo encargado de insertar el nodo al que va ha hacer referancia
     * @param next El nodo al que hara referencia este nodo en la lista
     */
        public void setNext(Node next) {
            this.next = next;
        }

    /**
     * Metodo para mostrar la informacion del nodo
     * @return Devuelve la informacion que contien el nodo
     */
        public String toString(){
            return info.toString() ;
        }
}
