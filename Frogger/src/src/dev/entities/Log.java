package src.dev.entities;

import java.awt.Graphics;
import src.dev.game.Game;
import src.dev.graphics.Assets;

public class Log extends Entity{

	public Log(Game game,int pos,int width) {
		super(game,0,115+34*pos,width,Entity.log_height);
		if(y==217||y==149){
			x=-width;
			speed=game.getDefaultSpeed();
		}
		else{
			x=game.getWidht()+width;
			speed=-game.getDefaultSpeed();
		}
	}

	@Override
	public void tick() {
		x+=speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.log,(int)x,(int)y,width,height,null);
	}
}