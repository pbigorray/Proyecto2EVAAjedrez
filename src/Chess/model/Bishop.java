package Chess.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Bishop extends Piece {

    public Bishop(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }
    public static List<Coordinate> getNextMovementsAsBishop(Piece piece){
        List<Coordinate> nextMovements =new ArrayList<>();
        Board board = piece.cell.getBoard();
        Coordinate position=piece.cell.getCoordinate();
        Coordinate aux;
        boolean continiu = true;

        //diagonalUpLeft
        aux = position;
        do {
            aux=aux.diagonalUpLeft();
            if (canMoveTo(aux,piece)){
                nextMovements.add(aux);
            }
            if(board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor()!=piece.getColor()){
                continiu=false;
            }
        }while (canMoveTo(aux,piece)&&continiu==true);


        //diagonalUpRight
        aux= position;
        continiu = true;
        do {
            aux=aux.diagonalUpRight();
            if (canMoveTo(aux,piece)){
                nextMovements.add(aux);
            }
            if(board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor()!=piece.getColor()){
                continiu=false;
            }
        }while (canMoveTo(aux,piece)&&continiu==true);
        //diagonalDownLeft
        aux= position;
        continiu = true;
        do {
            aux=aux.diagonalDownLeft();
            if (canMoveTo(aux,piece)){
                nextMovements.add(aux);
            }
            if(board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor()!=piece.getColor()){
                continiu=false;
            }
        }while (canMoveTo(aux,piece)&&continiu==true);

        //diagonalDownRight
        aux= position;
        continiu = true;
        do {
            aux=aux.diagonalDownRight();
            if (canMoveTo(aux,piece)){
                nextMovements.add(aux);
            }
            if(board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor()!=piece.getColor()){
                continiu=false;
            }
        }while (canMoveTo(aux,piece)&&continiu==true);

        return nextMovements;
    }
    @Override
    public List<Coordinate> getNextMovements(){
        return getNextMovementsAsBishop(this);
    }

    private static boolean canMoveTo(Coordinate coordinate,Piece piece){
        Board board = piece.cell.getBoard();

        return (board.containsCellAt(coordinate) && !board.containsPieceAt(coordinate) )||
                (board.containsCellAt(coordinate) &&
                        board.containsPieceAt(coordinate) &&
                        board.getCellAt(coordinate).getPiece().getColor()!=piece.getColor());
    }
}
