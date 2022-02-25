package Chess.model;

import com.diogonunes.jcolor.Attribute;

import java.io.Serializable;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece implements Serializable {

    private ChessType chessType;
    protected Cell cell;

    public Piece(Cell cell, ChessType chessType) {
        this.cell = cell;
        this.chessType = chessType;
    }

    public void place() {
        cell.setPiece(this);
    }

    public PieceColor getColor() {
        return chessType.getColor();
    }

    public String toString() {
        Attribute background = cell.getColor().getAttribute();
        Attribute textColor = chessType.getColor().getAttribute();
        Attribute[] myFormat = new Attribute[]{background, textColor};

        return colorize(" " + chessType.getShape() + " ", myFormat);

    }

    public ChessType getChessType() {
        return chessType;
    }


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

    protected boolean canMoveTo(Coordinate coordinate) {
        Board board = cell.getBoard();

        return (board.containsCellAt(coordinate) && !board.containsPieceAt(coordinate)) ||
                (board.containsCellAt(coordinate) &&
                        board.containsPieceAt(coordinate) &&
                        board.getCellAt(coordinate).getPiece().getColor() != getColor());
    }

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

    public Cell getCell() {
        return cell;
    }

    public abstract List<Coordinate> getNextMovements();
}
