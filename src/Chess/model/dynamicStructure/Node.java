package Chess.model.dynamicStructure;

import Chess.model.Piece;

public class Node {

        private Piece info;
        private Node next;

        public Node(Piece piece){
            this.info=piece;
            this.next=null;
        }

        public Piece getInfo() {
            return info;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString(){
            return info.toString() ;
        }
}
