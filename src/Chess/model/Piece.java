package Chess.model;

import com.diogonunes.jcolor.Attribute;

import java.io.Serializable;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

/**
 * Metodo abstracto del que heredan todos los tipos de piezas del juego
 * @author Pau Bigorra
 * @version 1.0
 */
public abstract class Piece implements Serializable {
    private ChessType chessType;
    protected Cell cell;

    /**
     * Constructor encargado de relacionar cada pieza con una celda y su ChessType
     * @param cell La celda a la que se asignanar la pieza
     * @param chessType El tipo de pieza al que pertenece
     */
    public Piece(Cell cell, ChessType chessType) {
        this.cell = cell;
        this.chessType = chessType;
    }

    /**
     * Metodo encargado de colocar esta pieza en la celda asignada
     */
    public void place() {
        cell.setPiece(this);
    }

    /**
     * Metodo encargado de optener el color de la pieza
     * @return Devuelve el color de la pieza
     */
    public PieceColor getColor() {
        return chessType.getColor();
    }

    /**
     * Metodo encargado de mostrar la pieza con el formato de color de la celda correcto
     * @return Devuelve lo que seria una casilla en el momento de representar el teblero
     */
    public String toString() {
        Attribute background = cell.getColor().getAttribute();
        Attribute textColor = chessType.getColor().getAttribute();
        Attribute[] myFormat = new Attribute[]{background, textColor};

        return colorize(" " + chessType.getShape() + " ", myFormat);

    }

    /**
     * Metodo encargado de devolver el tipo de pieza al que corresponde
     * @return Devuelve el chessType
     */
    public ChessType getChessType() {
        return chessType;
    }

    /**
     * Metodo encargado de redefinir el metodo por defecto equals
     * @param o Objeto(Pieza) con el que se va a comparar esta pieza
     * @return Devuelve true si son iguales y false si son distintas
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Piece) {
            Piece p = (Piece) o;
            if (p.cell == this.cell && p.chessType == this.chessType)
                return true;
            else
                return false;
        } else
            return false;
    }

    /**
     * Metodo encargado de comprovar si se puede mover a una cordenada
     * @param coordinate Conrdena a la que se desea saber si se puede mover
     * @return Devuelve si se puede mover a dicha cordenada o no
     */
    protected boolean canMoveTo(Coordinate coordinate) {
        Board board = cell.getBoard();

        return (board.containsCellAt(coordinate) && !board.containsPieceAt(coordinate)) ||
                (board.containsCellAt(coordinate) &&
                        board.containsPieceAt(coordinate) &&
                        board.getCellAt(coordinate).getPiece().getColor() != getColor());
    }

    /**
     * Metodo encargado de mover una pieza a una cordenada
     * @param coordinate Cordenada a la que desea moverse
     * @return Devuelve si se ha podido mover o no
     */
    public boolean moveTo(Coordinate coordinate) {


        if (cell == null || !cell.getBoard().containsCellAt(coordinate)) {
            return false;
        }

        if (getNextMovements().contains(coordinate)){
            Board board= cell.getBoard();
            if (board.containsPieceAt(coordinate)){
                //matamos
                Piece piece = board.getCellAt(coordinate).getPiece();
                piece.cell=null;
                board.getStore().add(piece);
            }
            //only move to
            cell.setPiece(null);
            cell=board.getCellAt(coordinate);
            place();
            changePawn();
            return true;
        }else
            return false;


    }

    /**
     * Metodo encargado de cambiar una pieza Pawn por Queen
     * @return Devuelve si se ha cambiado el Pawn o no
     */
    private boolean changePawn() {
        if (this.getChessType()==ChessType.BLACK_PAWN&&cell.getCoordinate().getNumber()==8){
            cell.setPiece(new BlackQueen(cell));
            return true;
        }
        if (this.getChessType()==ChessType.WHITE_PAWN&&cell.getCoordinate().getNumber()==1){
            cell.setPiece(new WhiteQueen(cell));
            return true;
        }
        return false;
    }

    /**
     * Metodo encargado de devolver la celda
     * @return Devuelve la celda
     */
    public Cell getCell() {
        return cell;
    }

    /**
     * Metodo abtracto para optener los proxioms movimientos de la pieza
     * @return Devuelve una lista con los siguientes movimientos
     */
    public abstract List<Coordinate> getNextMovements();
}
