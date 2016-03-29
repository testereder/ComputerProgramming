package src.dev.entities;

import java.awt.Graphics;
import java.util.Random;
import src.dev.game.Game;
import src.dev.graphics.Assets;


public class Bus extends Entity{
	
	private static Random r = new Random();
	private int bus;

	public Bus(Game game,int pos) {
		super(game,0,315+34*pos,Entity.truck_width,Entity.truck_height);
		if(y==417||y==451){
			speed = game.getDefaultSpeed()+0.15f;
			x=-Entity.truck_width;
			bus = r.nextInt(2)+2;
		}
		else{
			speed = -(game.getDefaultSpeed()+0.15f);
			x=game.getWidht()+Entity.truck_width;
			bus = r.nextInt(2);
		}
	}

	@Override
	public void tick() {
		x+=speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.bus[bus],(int)x,(int)y,Entity.truck_width,Entity.truck_height,null);
	}	
}