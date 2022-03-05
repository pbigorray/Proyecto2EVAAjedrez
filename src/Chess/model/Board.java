package Chess.model;

import Chess.model.dynamicStructure.MyStore;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase Board encargada de la creacion del tablero asi como su modificacion y representacion
 * @author Pau Bigorra
 */
public class Board implements Serializable {
    private Map<Coordinate, Cell> cells;
    private IDeletePieceManager store;
    private List<Piece> whitePiece;
    private List<Piece> blackPiece;

    /**
     * Metodo constructor del tablero
     */
    public Board() {
        cells = new HashMap<>();
        store = new MyStore();
        whitePiece = new LinkedList<>();
        blackPiece = new LinkedList<>();

        Coordinate coordinate;
        Cell cell;

        for (int row = 1; row <= 8; row++) {
            for (int col = 0; col < 8; col++) {
                coordinate = new Coordinate((char) ('A' + col), row);
                cell = new Cell(this, coordinate);
                cells.put(coordinate, cell);
            }
        }

        placePieces();

    }

    /**
     * Metodo encargado de colocar las piezas al inicio de la partida
     */
    private void placePieces() {
        //cambiar a coordinates
        for (int i = 0; i < 8; i++) {
            blackPiece.add(new BlackPawn(getCellAt(new Coordinate((char) ('A' + i), 2))));
            whitePiece.add(new WhitePawn(getCellAt(new Coordinate((char) ('A' + i), 7))));

        }
        //White
        whitePiece.add(new WhiteRook(getCellAt(new Coordinate('H', 8))));
        whitePiece.add(new WhiteRook(getCellAt(new Coordinate('A', 8))));

        whitePiece.add(new WhiteKnight(getCellAt(new Coordinate('G', 8))));
        whitePiece.add(new WhiteKnight(getCellAt(new Coordinate('B', 8))));

        whitePiece.add(new WhiteBishop(getCellAt(new Coordinate('F', 8))));
        whitePiece.add(new WhiteBishop(getCellAt(new Coordinate('C', 8))));

        whitePiece.add(new WhiteKing(getCellAt(new Coordinate('E', 8))));
        whitePiece.add(new WhiteQueen(getCellAt(new Coordinate('D', 8))));

        //Black
        blackPiece.add(new BlackRook(getCellAt(new Coordinate('H', 1))));
        blackPiece.add(new BlackRook(getCellAt(new Coordinate('A', 1))));

        blackPiece.add(new BlackKnight(getCellAt(new Coordinate('G', 1))));
        blackPiece.add(new BlackKnight(getCellAt(new Coordinate('B', 1))));

        blackPiece.add(new BlackBishop(getCellAt(new Coordinate('F', 1))));
        blackPiece.add(new BlackBishop(getCellAt(new Coordinate('C', 1))));

        blackPiece.add(new BlackKing(getCellAt(new Coordinate('D', 1))));
        blackPiece.add(new BlackQueen(getCellAt(new Coordinate('E', 1))));


    }

    /**
     * Metodo encargado de hacer una lista con la piezas blancas
     *
     * @return Devuelve una lista con las piezas blancas
     */
    public List<Piece> getWhitePiece() {
        List<Piece> pieces = new ArrayList<>();
        for (Cell cell : cells.values())
            if (cell.getPiece() != null && cell.getPiece().getColor() == PieceColor.BLACK) {
                pieces.add(cell.getPiece());
            }
        return pieces;

    }

    /**
     * Metodo encargado de hacer una lista con la piezas negras
     *
     * @return Devuelve una lista con las piezas negras
     */
    public List<Piece> getBlackPiece() {
        List<Piece> pieces = new ArrayList<>();
        for (Cell cell : cells.values())
            if (cell.getPiece() != null && cell.getPiece().getColor() == PieceColor.BLACK) {
                pieces.add(cell.getPiece());
            }
        return pieces;
    }

    /**
     * Geter de las celdas del tablero
     *
     * @return Devuelve las celdas del tablero
     */
    public Map<Coordinate, Cell> getCells() {
        return cells;
    }

    /**
     * Geter para optener el almacen de piezas
     *
     * @return Devuelve el elmacen de piezas
     */
    public IDeletePieceManager getStore() {
        return store;
    }

    /**
     * Metodo encargado de comprobar si hay jaque
     *
     * @param turn Turno en el que se comprueba el jaque
     * @return Devuelve verdadero si hay jaque
     */
    public boolean isJaque(PieceColor turn) {
        List<Piece> enemys;
        Set<Coordinate> movimentsEnemys = new HashSet<>();

        if (turn == PieceColor.WHITE) {
            enemys = getBlackPiece();
        } else {
            enemys = getWhitePiece();
        }
        for (Piece piece : enemys) {
            movimentsEnemys.addAll(piece.getNextMovements());
        }
        if (movimentsEnemys.contains(kingCorrdinate(turn)))
            return true;
        return false;
    }

    /**
     * Metodo encargado que optener las cordenadas del rey en ese turno
     *
     * @param turn Turno en el que se comprueba el jaque
     * @return Devuelve las cordenadas en las que se encuentra el rey
     */
    private Coordinate kingCorrdinate(PieceColor turn) {
        List<Piece> pices;
        Coordinate king = null;
        if (turn == PieceColor.WHITE) {
            pices = getWhitePiece();
            for (Piece piece : pices) {
                if (piece.getChessType() == ChessType.WHITE_KING) {
                    king = piece.getCell().getCoordinate();
                }
            }
        } else {
            pices = getBlackPiece();
            for (Piece piece : pices) {
                if (piece.getChessType() == ChessType.BLACK_KING) {
                    king = piece.getCell().getCoordinate();
                }
            }
        }
        return king;
    }

    /**
     * Metodo encardo de comprobar si las cordenadas son de una celda
     *
     * @param coordinate Cordenadas a comprobar
     * @return Devuelve verdadero si las celdas contienen esa cordenada
     */
    public boolean containsCellAt(Coordinate coordinate) {
//        if(coordinate.getLetter()<'A'|| coordinate.getLetter()>'H')
//            return false;
//        if(coordinate.getNumber()<1 || coordinate.getNumber()>8)
//            return false;

//        Cell c =cells.get(coordinate);
//
//        return c!=null;

        return cells.containsKey(coordinate);
    }

    /**
     * Metodo encargado de comprobar si la cordenada contiene una pieza
     *
     * @param coordinate Cordenadas a comprobar
     * @return Devuelve verdadero si las celdas contienen una pieza
     */
    public boolean containsPieceAt(Coordinate coordinate) {
        Cell cell = getCellAt(coordinate);
        if (cell == null) return false;
        return (cell.getPiece() != null);
    }

    /**
     * Geter de la cellda de una cordenada
     *
     * @param coordinate Cordenadas a comprobar
     * @return Devuelve una celda
     */
    public Cell getCellAt(Coordinate coordinate) {
        return cells.get(coordinate);
    }
//    public String toString(){
//        String salida="";
//        for (int row=0;row<8;row++){
//            for (int col=0;col<8;col++){
//                salida+=cells[row][col].toString();
//            }
//            salida+="\n";
//        }
//        return salida;
//    }

    /**
     * Metodo para contar piezas del tablero por un ChessType
     *
     * @param chessType ChessType que quieres contar
     * @return Devuelve el numero de piezas de ese tipo
     */
    public long count(ChessType chessType) {
        return this.cells.values().stream()
                .filter(cell -> cell.getPiece() != null && cell.getPiece().getChessType() == chessType)
                .count();
    }

    /**
     * Metodo para ver los movimientos de las piezas blancas??
     */
    public void moviments() {
        Set<Coordinate> moviments = cells.values().stream()
                .filter(cell -> cell.getPiece() != null)
                .map(cell -> cell.getPiece())
                .filter(piece -> piece.getColor() == PieceColor.WHITE)
                .flatMap(piece -> piece.getNextMovements().stream())
                .collect(Collectors.toSet());

        System.out.println(moviments);
    }

    /**
     * Metodo para resaltar las celdas a las que te puedes mover
     *
     * @param coordinates Lista de cordenadas a resaltar
     */
    public void hightLight(List<Coordinate> coordinates) {
        for (Coordinate coordinate : coordinates)
            getCellAt(coordinate).hightLight();
    }

    /**
     * Metodo para resetear los colores de las celdas
     */
    public void resetColors() {

        for (Cell cell : cells.values())
            cell.resetColor();
    }

}
