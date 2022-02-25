package Chess.model;

import Chess.model.dynamicStructure.MyStore;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Board implements Serializable {
    private Map<Coordinate,Cell> cells;
    private IDeletePieceManager store;
    private List<Piece> whitePiece;
    private List<Piece> blackPiece;

    public Board(){
        cells = new HashMap<>();
        store= new MyStore();
        whitePiece=new LinkedList<>();
        blackPiece=new LinkedList<>();

Coordinate coordinate;
Cell cell;

        for (int row=1;row<=8;row++){
            for (int col=0;col<8;col++){
                coordinate=new Coordinate((char) ('A'+col),row);
                cell = new Cell(this,coordinate);
                cells.put(coordinate,cell);
            }
        }

        placePieces();

    }

    private void placePieces() {
        //cambiar a coordinates
        for(int i=0;i<8;i++){
            blackPiece.add(new BlackPawn(getCellAt(new Coordinate((char)('A'+i),2))));
            whitePiece.add(new WhitePawn(getCellAt(new Coordinate((char)('A'+i),7))));

        }
        //White
        whitePiece.add(new WhiteRook(getCellAt(new Coordinate('H',8))));
        whitePiece.add(new WhiteRook(getCellAt(new Coordinate('A',8))));

        whitePiece.add(new WhiteKnight(getCellAt(new Coordinate('G',8))));
        whitePiece.add(new WhiteKnight(getCellAt(new Coordinate('B',8))));

        whitePiece.add(new WhiteBishop(getCellAt(new Coordinate('F',8))));
        whitePiece.add(new WhiteBishop(getCellAt(new Coordinate('C',8))));

        whitePiece.add(new WhiteKing(getCellAt(new Coordinate('E',8))));
        whitePiece.add(new WhiteQueen(getCellAt(new Coordinate('D',8))));

        //Black
        blackPiece.add(new BlackRook(getCellAt(new Coordinate('H',1))));
        blackPiece.add(new BlackRook(getCellAt(new Coordinate('A',1))));

        blackPiece.add(new BlackKnight(getCellAt(new Coordinate('G',1))));
        blackPiece.add(new BlackKnight(getCellAt(new Coordinate('B',1))));

        blackPiece.add(new BlackBishop(getCellAt(new Coordinate('F',1))));
        blackPiece.add(new BlackBishop(getCellAt(new Coordinate('C',1))));

        blackPiece.add(new BlackKing(getCellAt(new Coordinate('D',1))));
        blackPiece.add(new BlackQueen(getCellAt(new Coordinate('E',1))));

        //pruebas



    }

    public List<Piece> getWhitePiece(){
        List<Piece>pieces= new ArrayList<>();
        for (Cell cell:cells.values())
            if (cell.getPiece()!=null &&cell.getPiece().getColor()==PieceColor.BLACK){
                pieces.add(cell.getPiece());
            }
        return pieces;

    }

    public List<Piece> getBlackPiece() {
        List<Piece>pieces= new ArrayList<>();
        for (Cell cell:cells.values())
            if (cell.getPiece()!=null &&cell.getPiece().getColor()==PieceColor.BLACK){
                pieces.add(cell.getPiece());
            }
        return pieces;
//        return blackPiece;
    }

    public Map<Coordinate, Cell> getCells() {
        return cells;
    }

    public IDeletePieceManager getStore() {
        return store;
    }

    public boolean isJaque(PieceColor turn){
        List<Piece> enemys;
        Set<Coordinate> movimentsEnemys = new HashSet<>();

        if(turn==PieceColor.WHITE){
            enemys =getBlackPiece();
        }else {
            enemys=getWhitePiece();
        }
        for (Piece piece:enemys){
            movimentsEnemys.addAll(piece.getNextMovements());
        }
        if (movimentsEnemys.contains(kingCordinate(turn)))
            return true;
        return false;
    }

    private Coordinate kingCordinate(PieceColor turn) {

        /**
         * stream
         */
        PieceColor auxC;
        if (turn ==PieceColor.WHITE){
            auxC=PieceColor.WHITE;
        } else{
            auxC=PieceColor.BLACK;
        }
        //List<Coordinate> moveKing=


        List<Piece> pices;
        List<Piece> ki;
        Coordinate king = null;
        if (turn==PieceColor.WHITE){
            pices=getWhitePiece();
            for (Piece piece:pices){
                if (piece.getChessType()==ChessType.WHITE_KING){
                    king=piece.getCell().getCoordinate();
                }
            }
        }else {
            pices=getBlackPiece();
            for (Piece piece:pices){
                if (piece.getChessType()==ChessType.BLACK_KING){
                    king=piece.getCell().getCoordinate();
                }
            }
        }
        return king;
    }

    public boolean containsCellAt(Coordinate coordinate){
//        if(coordinate.getLetter()<'A'|| coordinate.getLetter()>'H')
//            return false;
//        if(coordinate.getNumber()<1 || coordinate.getNumber()>8)
//            return false;

//        Cell c =cells.get(coordinate);
//
//        return c!=null;

        return cells.containsKey(coordinate);
    }
    public boolean containsPieceAt(Coordinate coordinate){
        Cell cell = getCellAt(coordinate);
        if(cell == null) return false;
        return (cell.getPiece()!=null);
    }

    public Cell getCellAt(Coordinate coordinate){
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

    public long count( ChessType chessType){
        return this.cells.values().stream()
                .filter(cell -> cell.getPiece()!=null && cell.getPiece().getChessType()==chessType)
                .count();
    }

    public void moviments(){
        Set<Coordinate> moviments=cells.values().stream()
                .filter(cell -> cell.getPiece()!=null)
                .map(cell -> cell.getPiece())
                .filter(piece -> piece.getColor()==PieceColor.WHITE)
                .flatMap(piece -> piece.getNextMovements().stream())
                .collect(Collectors.toSet());

        System.out.println(moviments);
    }

    public void hightLight(List<Coordinate> coordinates){
        for(Coordinate coordinate : coordinates)
            getCellAt(coordinate).hightLight();
    }
    public void resetColors(){

            for(Cell cell : cells.values())
                cell.resetColor();
    }

}
