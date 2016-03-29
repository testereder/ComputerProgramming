package src.dev.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import src.dev.game.Game;


public abstract class Entity {
	
	public static final int player_width = 28;
	public static final int player_height= 28;
	public static final int car_width = 40;
	public static final int car_height = 28;
	public static final int truck_width = 74;
	public static final int truck_height = 28;
	public static final int log_height = 20;
	public static final int turtle_width = 25;
	public static final int turtle_height = 20;
	public static final int alli_width = 80;
	public static final int alli_height = 35;
	public static final int alliBank_width = 23;
	public static final int alliBank_height = 19;
	
	protected float x,y;
	protected int width,height;
	protected float speed;
	protected Rectangle bounds;
	protected Game game;
	
	public Entity(Game game,float x,float y,int width,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.game=game;
		bounds = new Rectangle(0,0,width,height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle getBounds() {
		return bounds;
	}
}