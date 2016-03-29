package src.dev.entities;

import java.awt.Graphics;
import src.dev.game.Game;
import src.dev.graphics.Assets;


public class Alligator extends Entity{

	private int alligator;
	private int counter;
	private int anim;
	
	public Alligator(Game game,int pos) {
		super(game,0,100+34*pos,Entity.alli_width,Entity.alli_height);
		
		if(y==202||y==134){
			x=-width;
			alligator=1;
			speed = game.getDefaultSpeed();
		}else{
			x=game.getWidht()+width;
			alligator=0;
			speed=-game.getDefaultSpeed();
		}
	}

	@Override
	public void tick() {
		x+=speed;
		counter++;
		if(counter==60)
			anim=1;
		if(counter==90){
			anim=0;
			counter=0;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.alligator[alligator][anim],(int)x,(int)y,width,height,null);
	}
}