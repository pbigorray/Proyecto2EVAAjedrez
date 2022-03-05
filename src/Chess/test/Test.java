package Chess.test;

import Chess.model.*;
import Chess.view.Input;
import Chess.view.Screen;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Board board = new Board();



        //Tool.show(board.getCellAt(new Coordinate('B',8)).getPiece().getNextMovements());
        Screen.show(board);

        List<Coordinate> coordinates= board.getCellAt(new Coordinate('A',7)).getPiece().getNextMovements();

        board.hightLight(coordinates);
        Screen.show(board);
        board.resetColors();
        board.getCellAt(new Coordinate('A',7)).getPiece().moveTo(new Coordinate('B',6));
        Screen.show(board);


        coordinates= board.getCellAt(new Coordinate('B',6)).getPiece().getNextMovements();
        board.hightLight(coordinates);
        Screen.show(board);
        board.resetColors();
        board.getCellAt(new Coordinate('B',6)).getPiece().moveTo(Input.getCoordinate("Dame la letra de la cordenada a la que te quieres mover"));
        Screen.show(board);

//        Piece piece= board.getCellAt(new Coordinate('G',8)).getPiece();
//        piece.moveTo(new Coordinate('F',6));
//        Screen.show(board);
        Screen.show(board.getStore());
        Board b = new Board();

//        //busca y devuelve la fichas blancas
//        List<Piece>whitePiece= board.getCells().values().stream()
//                .filter(c->c.getPiece()!=null)
//                .map(c->c.getPiece())
//                .filter(piece -> piece.getColor()==PieceColor.WHITE)
//                .collect(Collectors.toList());
//        //busca y devuelve la fichas negras
//        List<Piece>blackPiece= board.getCells().values().stream()
//                .filter(c->c.getPiece()!=null)
//                .map(c->c.getPiece())
//                .filter(piece -> piece.getColor()==PieceColor.BLACK)
//                .collect(Collectors.toList());
//        //busca y devuelve la ficha rey negro
//        Optional<Piece> blackKing=board.getCells().values().stream()
//                .filter(c-> c.getPiece()!=null && c.getPiece().getChessType()==ChessType.BLACK_KING)
//                .map(c-> c.getPiece())
//                .findAny();
//
//        if (blackKing.isEmpty())
//            System.out.println("No esta");
//        else
//            System.out.println(blackKing.get());
//
//
//        //busca y devuelve la ficha rey blanco
//        Optional<Piece> whiteKing=board.getCells().values().stream()
//                .filter(c-> c.getPiece()!=null && c.getPiece().getChessType()==ChessType.WHITE_KING)
//                .map(c-> c.getPiece())
//                .findAny();
//
//        if (whiteKing.isEmpty())
//            System.out.println("No esta");
//        else
//            System.out.println(blackKing.get());
//
//        //busca y devuelve la ficha peon blanco con un limite
//        List<Piece> blackPawn=board.getCells().values().stream()
//                .filter(c-> c.getPiece()!=null && c.getPiece().getChessType()==ChessType.WHITE_KING)
//                .map(c-> c.getPiece())
//                .limit(4)
//                .collect(Collectors.toList());
//
//        if (blackPawn.isEmpty())
//            System.out.println("No esta");
//        else
//            System.out.println(blackKing.get());
//
//
//        //busca y ordena las fichas segun las condenadas en la que se encuentren
//        List<Piece> black4Pawn=board.getCells().values().stream()
//                .filter(c-> c.getPiece()!=null)
//                .map(c-> c.getPiece())
//
//                .sorted(new Comparator<Piece>() {
//                    @Override
//                    public int compare(Piece o1, Piece o2) {
//                        return o1.getCell().getCoordinate().getLetter()-o2.getCell().getCoordinate().getLetter();
//                    }
//                })
//                .collect(Collectors.toList());
//
//        if (black4Pawn.isEmpty())
//            System.out.println("No esta");
//        else
//            System.out.println(black4Pawn);


    }
}
