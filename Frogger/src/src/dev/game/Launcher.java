package src.dev.game;

public class Launcher {
	public static void main(String[] args){
		Game game = new Game("FROGGER",400,560);
		game.start();
	}
}