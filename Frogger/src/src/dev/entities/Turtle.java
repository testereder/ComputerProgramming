package src.dev.entities;

import java.awt.Graphics;
import src.dev.game.Game;
import src.dev.graphics.Assets;

public class Turtle extends Entity{
	
	private int counter;
	private int amountTurtle;
	private int turtle;
	private int anim;
	
	public Turtle(Game game,int pos,int amountTurtle) {
		super(game,0,115+34*pos,Entity.turtle_width,Entity.turtle_height);
		
		this.amountTurtle=amountTurtle;
		width*=amountTurtle;
		
		if(y==217||y==149){
			x=-width;
			turtle=1;
			speed = game.getDefaultSpeed();
		}else{
			x=game.getWidht()+width;
			turtle=0;
			speed=-game.getDefaultSpeed();
		}
	}

	@Override
	public void tick() {
		x+=speed;
		counter++;
		if(counter==20){
			counter=0;
			if(anim==0)
				anim=1;
			else
				anim=0;
		}
	}

	@Override
	public void render(Graphics g) {
		if(speed<0){
			for(int i=0 ; i<amountTurtle ; i++ )
				g.drawImage(Assets.turtle[turtle][anim],(int)(x-i*Entity.turtle_width),(int)y,Entity.turtle_width,height,null);
		}else{
			for(int i=0 ; i<amountTurtle ; i++ )
				g.drawImage(Assets.turtle[turtle][anim],(int)(x+i*Entity.turtle_width),(int)y,Entity.turtle_width,height,null);
		}
	}
}