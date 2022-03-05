package Chess.model;

import com.diogonunes.jcolor.Attribute;

import java.io.Serializable;

/**
 * Enumerador de el color al cual puede pertenecer las piezas
 * @author Pau Bigorra
 * @version 1.0
 */
public enum PieceColor implements Serializable {
    WHITE(Attribute.TEXT_COLOR(255,255,255)),
    BLACK(Attribute.TEXT_COLOR(0,0,0));

    private Attribute color;

    /**
     * Constructor del color de la pieza
     * @param color Color por defecto
     */
    PieceColor(Attribute color){
        this.color = color;
    }

    /**
     * Getter del color de la pieza
     * @return Devuelve el color
     */
    public Attribute getAttribute(){
        return color;
    }

}
