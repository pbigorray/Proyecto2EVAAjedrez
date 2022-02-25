package Chess.controler;

import Chess.model.*;
import Chess.view.Input;
import Chess.view.Screen;

import java.io.*;
import java.util.List;

public class Game implements Serializable {

    private Player player1;
    private Player player2;
    private Board board;
    private PieceColor turn;


    public Game() {
        this.player1 = null;
        this.player2 = null;
        board = new Board();
        turn = PieceColor.WHITE;
    }

    /**
     * Metodo encargado de crear el juego
     */
    public void start() {
        boolean fin = false;
        int num = 0, load;

        load = Input.getInteger("Que quieres hacer??\n" +
                "1-Nueva Partida\n" +
                "2-Cargar partida");
        if (load == 2) {


            loadGame();
        }
        player1=new Player(Input.getString("Nombre del jugador uno"),PieceColor.WHITE);
        player2=new Player(Input.getString("Nombre del jugador dos"),PieceColor.BLACK);

        do {
            num++;
            //
            Screen.showTurno(player1, player2, turn);
            Screen.show(board, turn);
            if (board.isJaque(turn)){
                System.out.println("Hay jaque");
            }
            Piece p;
            Coordinate c;
            //

            do {
                c = Input.getCoordinate("Dame una letra", "Dame un numero");
                if (c.getLetter() == 'P' && c.getNumber() == 0) {
                    saveGame();
                    System.out.println("Se ha guardado corectamente");
                }
            } while (!board.containsCellAt(c) || !board.containsPieceAt(c) || board.getCellAt(c).getPiece().getColor() != turn);
            p = board.getCellAt(c).getPiece();
            List<Coordinate> nextMovements = p.getNextMovements();
            Screen.clear();
            board.hightLight(nextMovements);
            Screen.show(board, turn);

            //
            boolean comprueba = false;
            Coordinate move;

            do {
                move = Input.getCoordinate("Dame la letra de la cordenada a la que te quieres mover", "Dame el numero");
                if (board.getCellAt(c).getPiece().moveTo(move)){
                    comprueba=true;
                }else {
                    System.out.println("No puedes mover la pieza a esa casilla");
                    comprueba=false;
                }
            } while (!comprueba);
            Screen.clear();
            board.resetColors();

            Screen.show(board, turn);

            if (turn == PieceColor.WHITE) {
                turn = PieceColor.BLACK;
            } else
                turn = PieceColor.WHITE;

            if (board.getStore().count(ChessType.WHITE_KING) == 1 || board.getStore().count(ChessType.BLACK_KING) == 1)
                fin = true;


        } while (!fin /*&& num < 3*/);
        if (board.getStore().count(ChessType.WHITE_KING) == 1)
            System.out.println("black");
        else
            System.out.println("white");




    }

    public void saveGame(){
        try(ObjectOutputStream oos =new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/Chess/SaveGame/gameFile")))) {
            oos.writeObject(this);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadGame(){
        try(ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/Chess/SaveGame/gameFile")))) {
            Game game = (Game) ois.readObject();
            this.board= game.board;
            this.player1=game.player1;
            this.player2=game.player2;
            this.turn=game.turn;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
