package Chess;

import Chess.controler.Game;
import Chess.model.PieceColor;
import Chess.model.Player;
import Chess.view.Input;

public class App {
    public static void main(String[] args) {
        Player player1,player2;
        System.out.println("Ajedrez");
        System.out.println("By Pau Bigorra Yanguas");

        Game game = new Game();
        game.start();
    }
}
