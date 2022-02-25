package Chess.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Rook extends Piece{

    public Rook(Cell cell, ChessType chessType) {
        super(cell, chessType);
    }


    public static List<Coordinate> getNextMovementsAsRook(Piece piece){
        List<Coordinate> nextMovements =new ArrayList<>();
        Board board = piece.cell.getBoard();
        Coordinate position=piece.cell.getCoordinate();
        Coordinate aux;
        boolean continiu = true;

        //Up
        aux = position;
        do {
            aux=aux.up();
            if (canMoveTo(aux,piece)){
                nextMovements.add(aux);
            }
            if(board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor()!=piece.getColor()){
                continiu=false;
            }
        }while (canMoveTo(aux,piece)&&continiu==true);

        //Down
        aux= position;
        continiu = true;
        do {
            aux=aux.down();
            if (canMoveTo(aux,piece)){
                nextMovements.add(aux);

            }
            if(board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor()!=piece.getColor()){
                continiu=false;
            }
        }while (canMoveTo(aux,piece)&&continiu==true);


        //Left
        aux= position;
        continiu = true;
        do {
            aux=aux.left();
            if (canMoveTo(aux,piece)){
                nextMovements.add(aux);

            }
            if(board.containsCellAt(aux) && board.containsPieceAt(aux) && board.getCellAt(aux).getPiece().getColor()!=piece.getColor()){
                continiu=false;
            }
        }while (canMoveTo(aux,piece)&&continiu==true);

        //Right
        aux= position;
        continiu = true;
        do {
            aux=aux.right();
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
        return getNextMovementsAsRook(this);
    }

    private static boolean canMoveTo(Coordinate coordinate,Piece piece){
        Board board = piece.cell.getBoard();

        return (board.containsCellAt(coordinate) && !board.containsPieceAt(coordinate) )||
                (board.containsCellAt(coordinate) &&
                        board.containsPieceAt(coordinate) &&
                        board.getCellAt(coordinate).getPiece().getColor()!=piece.getColor());
    }
}
