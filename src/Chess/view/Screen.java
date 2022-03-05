package Chess.view;

import Chess.model.*;
import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

/**
 * Clase encargada de todo el apartado de mostrar por pantalla
 * @author Pau Bigorra
 * @version 1.0
 */
public class Screen {
    /**
     * Metodo encargado de mostrar la piezas muertas
     * @param store Almacen de pezas muertas a mostrar
     */
    public static void show(IDeletePieceManager store){
        String output="        ";

        for (ChessType chessType : ChessType.values()){
            output +=colorize(" "+chessType.getShape()+" ",Cell.CellColor.BLACK_CELL.getAttribute(),chessType.getColor().getAttribute());
        }
        output+="\n        ";
        for (ChessType chessType : ChessType.values()){
            output +=colorize(" "+store.count(chessType)+" ",Cell.CellColor.WHITE_CELL.getAttribute(), Attribute.TEXT_COLOR(0,0,0));
        }


        System.out.println(output);
    }
//    public static void showRemaining(Board board){
//        for (int i =0; i<ChessType.values().length;i++){
//            board.count(board,ChessType.values())
//        }
//    }
//    public static void show(Board board, PieceColor color){
//        //mostrar el tablero desde la viata del color blanco
//    }
//
//    public static void show(Board board,PieceColor color){
//        if (color==PieceColor.WHITE){
//            showWhiteView(board);
//        }else {
//            showBlackView(board);
//        }
//    }
//
//    private static void showBlackView(Board board) {
//        StringBuilder salida=new StringBuilder();
//        salida.append(getLettersBlackView());
//    }
//
//    private static void showWhiteView(Board board) {
//        StringBuilder salida=new StringBuilder();
//        salida.append(getLettersWhiteView());
//
//        for (int fila=1;fila <=8;fila++){
//            salida.append(getMiddlePartWhiteView(board,fila));
//        }
//        salida.append(getLettersWhiteView());
//        System.out.println(salida);
//    }

    /**
     * Metodo encargado de mostrar el tablero
     * @param board Tablaro que desea mostrar
     */
    public static void show(Board board){
        String salida="";
        Coordinate c;
        salida+="   A  B  C  D  E  F  G  H \n";
        for (int row=0;row<8;row++){
            salida+=(row + 1 )+" ";
            for (int col=0;col<8;col++){
                c = new Coordinate((char)('A'+col),row+1);
                salida+=board.getCellAt(c).toString();
            }
            salida+="\n";
        }
        System.out.println(salida);
    }

    /**
     * Metodo encargado de la limpieza del terminal
     */
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Metodo encargado de mostar el tablero dependiendo del color del turno
     * @param board Tablero que dese mostrar
     * @param color Color del turno a mostrar
     */
    public static void show(Board board, PieceColor color) {
        if(color==PieceColor.WHITE)
            showWhiteView(board);
        else
            showBlackView(board);



        System.out.println("                     PIECES ALIVE");
        piecesAlive(board);
        System.out.println("\n");
        System.out.println("                     PIECES DEATH");
        show(board.getStore());



    }

    /**
     * Metodo encargado de mostrar la cantidad de piezas que hay en el tablero
     * @param board Tablero del que se quieren ver las piezas
     */
    private static void piecesAlive(Board board) {
        String output="        ";

        for (ChessType chessType : ChessType.values()){
            output +=colorize(" "+chessType.getShape()+" ",Cell.CellColor.BLACK_CELL.getAttribute(),chessType.getColor().getAttribute());
        }
        output+="\n        ";
        for (ChessType chessType : ChessType.values()){
            output +=colorize(" "+board.count(chessType)+" ",Cell.CellColor.WHITE_CELL.getAttribute(), Attribute.TEXT_COLOR(0,0,0));
        }


        System.out.println(output);
    }

    /**
     * Metodo encargado de mostrar el tablero desde la vista del turno blanco
     * @param board Tablero a mostrar
     */
    private static void showWhiteView(Board board) {

        StringBuilder salida = new StringBuilder();

        salida.append(getLettersWhiteView());

        for (int fila = 1; fila <= 8; fila++) {
            salida.append(getMiddlePartWhiteView(board, fila));

        }
        salida.append(getLettersWhiteView());

        System.out.print(salida);
    }
    /**
     * Metodo encargado de mostrar el tablero desde la vista del turno negro
     * @param board Tablero a mostrar
     */
    private static void showBlackView(Board board) {

        StringBuilder salida = new StringBuilder();

        salida.append(getLettersBlackView());

        for (int fila = 8; fila >= 1; fila--) {
            salida.append(getMiddlePartBlackView(board, fila));

        }
        salida.append(getLettersBlackView());

        System.out.print(salida);
    }

    /**
     * Metodo encargado de mostrar las letras del turno blanco
     * @return Devuelve las letras correspondientes
     */
    private static String getLettersWhiteView() {
        return "               A  B  C  D  E  F  G  H\n";
    }
    /**
     * Metodo encargado de mostrar las letras del turno negro
     * @return Devuelve las letras correspondientes
     */
    private static String getLettersBlackView() {
        return "               H  G  F  E  D  C  B  A\n";
    }

    /**
     * Metodo para mostrar el tablero del turno blanco
     * @param board Tablero a mostrar
     * @param fila Fila del tablero que tiene que mostrar
     * @return Devuelve una fila de celdas listar para mostrarse
     */
    private static String getMiddlePartWhiteView(Board board, int fila) {

        StringBuilder salida = new StringBuilder("            " + fila + " ");

        for (int col = 0; col < 8; col++) {
            salida.append(board.getCellAt(new Coordinate((char) ('A' + col), fila)));
        }

        return salida.append(" ").append(fila).append("\n").toString();
    }
    /**
     * Metodo para mostrar el tablero del turno negro
     * @param board Tablero a mostrar
     * @param fila Fila del tablero que tiene que mostrar
     * @return Devuelve una fila de celdas listar para mostrarse
     */
    private static String getMiddlePartBlackView(Board board, int fila) {

        StringBuilder salida = new StringBuilder("            " + fila + " ");

        for (int col = 7; col >= 0; col--) {
            salida.append(board.getCellAt(new Coordinate((char) ('A' + col), fila)));
        }

        return salida.append(" ").append(fila).append("\n").toString();
    }

    /**
     * Metodo encargado de mostrar el nombre del jugador del turno correspondiente
     * @param player1 Jugador 1
     * @param player2 Jugador 2
     * @param turn Color del turno que se quiere mostrar
     */
    public static void showTurno(Player player1, Player player2, PieceColor turn) {
        if (player1.getTurn()==turn){
            System.out.println("Es el turno de "+player1.getNombre());
        }else {
            System.out.println("Es el turno de "+player2.getNombre());
        }
    }
}
