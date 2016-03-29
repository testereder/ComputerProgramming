package src.dev.linkedlists;

import java.awt.Graphics;
import java.util.LinkedList;
import src.dev.game.Game;
import src.dev.entities.*;

public class RiverItems {
	
	private LinkedList<Log> log = new LinkedList<Log>();
	private LinkedList<Turtle> turtle = new LinkedList<Turtle>();
	private LinkedList<Alligator> alligator = new LinkedList<Alligator>();
	
	Game game;
	
	public RiverItems(Game game){
		this.game = game;
	}
	
	public void tick(){
		for(int i = 0 ; i<log.size() ; i++ ){
			if(log.get(i).getX()>game.getWidht()+log.get(i).getWidth()+1 || log.get(i).getX()<-(log.get(i).getWidth()+1))
				removeLog(log.get(i));
			else
				log.get(i).tick();
		}
		
		for(int i=0 ; i<turtle.size() ; i++ ){
			if(turtle.get(i).getX()>game.getWidht()+turtle.get(i).getWidth()+1 || turtle.get(i).getX()<-(turtle.get(i).getWidth()+1))
				removeTurtle(turtle.get(i));
			else
				turtle.get(i).tick();
		}
		
		for(int i=0 ; i<alligator.size() ; i++ ){
			if(alligator.get(i).getX()>game.getWidht()+alligator.get(i).getX()+1 || alligator.get(i).getX()<-(alligator.get(i).getWidth()+1))
				removeAlligator(alligator.get(i));
			else
				alligator.get(i).tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0 ; i<log.size() ; i++ )
			log.get(i).render(g);
		
		for(int i=0 ; i<turtle.size() ; i++ )
			turtle.get(i).render(g);
		
		for(int i=0 ; i<alligator.size() ; i++)
			alligator.get(i).render(g);
	}
	
	public void addLog(Log log){
		this.log.add(log);
	}
	
	public void addTurtle(Turtle turtle){
		this.turtle.add(turtle);
	}
	
	public void addAlligator(Alligator alligator){
		this.alligator.add(alligator);
	}
	
	public void removeLog(Log log){
		this.log.remove(log);
	}
	
	public void removeTurtle(Turtle turtle){
		this.turtle.remove(turtle);
	}
	
	public void removeAlligator(Alligator alligator){
		this.alligator.remove(alligator);
	}
}