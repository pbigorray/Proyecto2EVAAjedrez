package Chess.model;

import java.io.Serializable;

public class Player implements Serializable {
    private String nombre;
    private PieceColor turn;

    public Player(String nombre,PieceColor turn) {
        this.nombre = nombre;
        this.turn=turn;
    }

    public PieceColor getTurn() {
        return turn;
    }

    public String getNombre() {
        return nombre;
    }
}
