package Chess.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Queen extends Piece{
    public Queen(Cell cell, ChessType chessType) {
        super(cell, chessType);
        place();
    }

    @Override
    public List<Coordinate> getNextMovements() {

        List<Coordinate> rook=Rook.getNextMovementsAsRook(this);
        List<Coordinate> bishop=Bishop.getNextMovementsAsBishop(this);

        List<Coordinate> queen= new ArrayList<>();
        int aux =0;
        if (rook.size()<0)
        for (int i=0;i<rook.size();i++){
            queen.add(rook.get(i));
            aux++;
        }
        if (bishop.size()<0)
        for (int i=0;i<bishop.size();i++){
            queen.add(bishop.get(i));
            aux++;
        }
        return queen;
    }
}
