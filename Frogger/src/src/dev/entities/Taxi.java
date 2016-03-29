package src.dev.entities;

import java.awt.Graphics;
import src.dev.game.Game;
import src.dev.graphics.Assets;


public class Taxi extends Entity{
	
	private int taxi;

	public Taxi(Game game,int pos) {
		super(game,0,315+34*pos,Entity.car_width,Entity.car_height);
		if(y==417||y==451){
			speed = game.getDefaultSpeed()+0.3f;
			x=-Entity.car_width;
			taxi = 1;
		}
		else{
			speed = -(game.getDefaultSpeed()+0.3f);
			x=game.getWidht()+Entity.car_width;
			taxi = 0;
		}
	}

	@Override
	public void tick() {
		x+=speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.taxi[taxi],(int)x,(int)y,Entity.car_width,Entity.car_height,null);
	}	
}