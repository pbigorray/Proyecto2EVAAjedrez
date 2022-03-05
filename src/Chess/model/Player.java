package Chess.model;

import java.io.Serializable;

/**
 * Clase Player encargada de creacion de los jugadores con su respectivo color
 * @author Pau Bigorra
 * @version 1.0
 */
public class Player implements Serializable {
    private String nombre;
    private PieceColor turn;

    /**
     * Constructor del jugador
     * @param nombre Nombre del jugador
     * @param turn Turno que juega
     */
    public Player(String nombre,PieceColor turn) {
        this.nombre = nombre;
        this.turn=turn;
    }

    /**
     * Getter del turno
     * @return Devuelve el color del turno con el que juega
     */
    public PieceColor getTurn() {
        return turn;
    }

    /**
     * Getter del turno
     * @return Devuelve el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }
}
