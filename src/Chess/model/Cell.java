package Chess.model;

import com.diogonunes.jcolor.Attribute;

import java.io.Serializable;

import static Chess.model.Cell.CellColor.*;
import static com.diogonunes.jcolor.Ansi.colorize;

/**
 * Clase Cell encargada de la creacion, utilizacion y representacion de cada celda
 * @author Pau Bigorra
 */
public class Cell implements Serializable {
    private Coordinate coordinate;
    private CellColor color;
    private CellColor originalColor;
    private Piece piece;
    private Board board;

    /**
     * Metodo constructor de las celdas
     *
     * @param board      Tablero el que pertenece
     * @param coordinate Cordenada a la que corresponde
     */
    public Cell(Board board, Coordinate coordinate) {
        this.board = board;
        this.coordinate = coordinate;
        if (((coordinate.getLetter() - 'A') + coordinate.getNumber()) % 2 == 0)
            originalColor = CellColor.BLACK_CELL;
        else
            originalColor = CellColor.WHITE_CELL;

        color = originalColor;
    }

    /**
     * ToString encargado de definir como se mostrara la celda
     * @return Devuelve la celda como se tiene que mostrar
     */
    public String toString() {
        Attribute[] myFormat = new Attribute[]{color.getAttribute()};
        if (piece != null)
            return piece.toString();
        else
            return colorize("   ", myFormat);
    }

    /**
     * Getter del tablero
     * @return Devuelve el tablero
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Getter del cordenada
     * @return Devuelve la cordenada a la que corresponde
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Getter de la pieza que contiene
     * @return Devuelve la pieza que contiene
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Setter para colocar la pieza en la celda
     * @param piece Pieza a colocar
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Getter para optener el color de la celda
     * @return Devuelve el color de la celda
     */
    public CellColor getColor() {
        return color;
    }

    /**
     * Metodo encargado de pintar las celdas a las que te puedes mover de distinto color
     */
    public void hightLight() {
        //otro if
        if (piece != null)
            color = (originalColor == WHITE_CELL) ? HIGHTLIGHT_KILL_WHITE : HIGHTLIGHT_KILL_BLACK;
        else
            color = (originalColor == WHITE_CELL) ? HIGHTLIGHT_WHITE : HIGHTLIGHT_BLACK;
    }

    /**
     * Metodo encargado de poner los colores al los iniciales
     */
    public void resetColor() {
        color = originalColor;
    }

    /**
     * Enumerador de los colores de las celdas
     */
    public enum CellColor {
// cambiar los colores
        WHITE_CELL(Attribute.BACK_COLOR(180, 180, 180)),
        BLACK_CELL(Attribute.BACK_COLOR(100, 100, 100)),
        HIGHTLIGHT_KILL_WHITE(Attribute.BACK_COLOR(180, 0, 0)),
        HIGHTLIGHT_KILL_BLACK(Attribute.BACK_COLOR(130, 0, 0)),
        HIGHTLIGHT_WHITE(Attribute.BACK_COLOR(180, 180, 0)),
        HIGHTLIGHT_BLACK(Attribute.BACK_COLOR(130, 130, 0));

        private Attribute color;

        /**
         * Constructor del color de la celda
         * @param color Color por defecto
         */
        CellColor(Attribute color) {
            this.color = color;
        }

        /**
         * Getter del color
         * @return Devuelve el color
         */
        public Attribute getAttribute() {
            return color;
        }
    }
}
