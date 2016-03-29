package src.dev.entities;

import java.awt.Graphics;
import java.util.Random;
import src.dev.game.Game;
import src.dev.graphics.Assets;


public class Car extends Entity{
	
	private static Random r = new Random();
	private int car;

	public Car(Game game,int pos) {
		super(game,0,315+34*pos,Entity.car_width,Entity.car_height);
		if(y==417||y==451){
			speed = game.getDefaultSpeed()+0.2f;
			x=-Entity.car_width;
			car = r.nextInt(4)+4;
		}
		else{
			speed = -(game.getDefaultSpeed()+0.2f);
			x=game.getWidht()+Entity.car_width;
			car = r.nextInt(4);
		}
	}

	@Override
	public void tick() {
		x+=speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.car[car],(int)x,(int)y,Entity.car_width,Entity.car_height,null);
	}
}