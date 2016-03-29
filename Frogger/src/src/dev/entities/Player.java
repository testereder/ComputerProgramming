package src.dev.entities;

import java.awt.Graphics;
import src.dev.game.Game;
import src.dev.graphics.Assets;


public class Player extends Entity{
	
	private boolean move = true;
	private boolean moveUp = false;
	private boolean moveDown = false;
	private boolean moveLeft = false;
	private boolean moveRight = false;
	
	private int score;
	private float moveX = 27.40f/8;
	private float moveY = 34f/8;
	private int counter=8;
	private int anim;
	private int frog;

	public Player(Game game) {
		super(game,(game.getWidht()-Entity.player_width)/2,game.getHeight()-75,Entity.player_width,Entity.player_height);
	}

	@Override
	public void tick() {

		if(game.getKeyManager().up||game.getKeyManager().down||game.getKeyManager().left||game.getKeyManager().right){
			if(move && counter==8){
				if(game.getKeyManager().up && y>80){
					moveUp=true;
					counter=0;
					anim=0;
				}
				if(game.getKeyManager().down && y<480){
					moveDown=true;
					counter=0;
					anim=1;
				}
				if(game.getKeyManager().left && x>25){
					moveLeft=true;
					counter=0;
					anim=2;
				}
				if(game.getKeyManager().right && x<340){
					moveRight=true;
					counter=0;
					anim=3;
				}
			}
			move = false;
		}else{
			move=true;
		}
	
		if(moveUp==true && counter!=8){
			y-=moveY;
			counter++;
		}else
			moveUp=false;
		
		if(moveDown==true && counter!=8){
			y+=moveY;
			counter++;
		}else
			moveDown = false;
		
		if(moveLeft==true && counter!=8){
			x-=moveX;
			counter++;
		}else
			moveLeft = false;
		
		if(moveRight==true && counter!=8){
			x+=moveX;
			counter++;
		}else
			moveRight = false;
		
		if(counter==2)frog=1;
		if(counter==5)frog=2;
		if(counter==8)frog=0;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.frog[anim][frog],(int)x,(int)y,width,height,null);
	}
	
	public void setScore(int score){
		this.score=score;
	}
	
	public int getScore(){
		return score;
	}
}