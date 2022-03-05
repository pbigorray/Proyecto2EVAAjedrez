package Chess;

import Chess.controler.Game;
import Chess.model.PieceColor;
import Chess.model.Player;
import Chess.view.Input;

/**
 * Clase aplicacion principal
 * @author Pau Bigorra
 * @version 1.0
 */
public class App {
    /**
     * Metodo para inicializar la aplicacion
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Ajedrez");
        System.out.println("By Pau Bigorra Yanguas");

        Game game = new Game();
        game.start();
    }
}
