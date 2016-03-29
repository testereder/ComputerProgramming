package src.dev.entities;

import java.awt.Graphics;
import src.dev.game.Game;
import src.dev.graphics.Assets;

public class AlligatorBank extends Entity{
	
	private final int time = 600;

	public AlligatorBank(Game game) {
		super(game,0,82,Entity.alliBank_width,Entity.alliBank_height);
		x=25f+82.2f*r.nextInt(5);
	}

	@Override
	public void tick() {
		counter++;
		
		if(counter==time){
			counter=0;
			x=25f+82.2f*r.nextInt(5);
		}
		if(counter==0)
			anim=3;
		else if(counter==5)
			anim=0;
		else if(counter==10)
			anim=1;
		else if(counter==15)
			anim=2;
		else if(counter==time-70)
			anim=1;
		else if(counter==time-65)
			anim=0;
		else if(counter==time-60)
			anim=3;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.alligatorBank[anim],(int)x,(int)y,Entity.alliBank_width,Entity.alliBank_height,null);
	}
}