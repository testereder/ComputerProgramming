package src.dev.states;

import java.awt.Font;
import java.awt.Graphics;

import src.dev.game.*;

public abstract class State {
	
	protected int counter;
	protected Font font = new Font("SansSerif",Font.BOLD,20);
	private static State currentState = null;
	private static boolean changeState = true;

	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
	public static State getState(State state){
		return state;
	}
	
	public static boolean changeState() {
		return changeState;
	}

	public static void setChangeState(boolean b) {
		changeState = b;
	}
	
	//CLASS
	
	protected Game game;
	
	public State(Game game){
		this.game = game;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}