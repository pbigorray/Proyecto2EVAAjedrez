package Chess.model.dynamicStructure;

import Chess.model.ChessType;
import Chess.model.IDeletePieceManager;
import Chess.model.Piece;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class MyStore implements IDeletePieceManager, Serializable {

    private List<Piece> pieces;

    public MyStore(){
        this.pieces=new LinkedList<>();
    }
    @Override
    public void add(Piece piece) {
        pieces.add(piece);
    }

    @Override
    public Piece getFirst() {
        return pieces.get(0);
    }

    @Override
    public void remove(Piece piece) {
        pieces.remove(piece);
    }

    @Override
    public int count(ChessType chessType) {
        return (int) pieces.stream().filter(p->p.getChessType()==chessType).count();

//        int suma =0;
//        for (Piece piece: pieces)
//            if ()

    }
}
