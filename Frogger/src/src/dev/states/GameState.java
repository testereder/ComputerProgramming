package src.dev.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import src.dev.entities.*;
import src.dev.game.Game;
import src.dev.linkedlists.*;

public class GameState extends State{
	
	private Random r = new Random();
	
	private Font font = new Font("SanSerif",Font.BOLD,20);
	
	private Game game;
	private Player player;
	private Vehicles vehicles;
	private RiverItems riverItems;
	private AlligatorBank alligator;
	
	private int counter;
	private int gen;
	private int vehiclePos;
	private boolean[] posPerm = new boolean[11];
	private int[] pos = new int[11];

	public GameState(Game game) {
		super(game);
		this.game=game;
		player = new Player(game);
		vehicles = new Vehicles(game);
		riverItems = new RiverItems(game);
		alligator = new AlligatorBank(game);
		game.setDefaultSpeed(1.5f);
		
		for(int i=0 ; i<pos.length ; i++){
			pos[i]=111+i*34;
			posPerm[i]=true;
		}
	}

	@Override
	public void tick() {
		
		counter++;
		if(counter==30){
			counter=0;
			gen = r.nextInt(4);
			
			vehiclePos++;
			if(vehiclePos==5)
				vehiclePos=0;
			
			if(gen==0 || gen==1)
				riverItems.addLog(new Log(game,vehiclePos,r.nextInt(81)+50));
			else if(gen==2)
				riverItems.addTurtle(new Turtle(game,vehiclePos,r.nextInt(2)+2));
			else
				riverItems.addAlligator(new Alligator(game,vehiclePos));
			
			if(gen==0)
				vehicles.addCar(new Car(game,vehiclePos));
			else if(gen==1)
				vehicles.addTruck(new Truck(game,vehiclePos));
			else if(gen==2)
				vehicles.addBus(new Bus(game,vehiclePos));
			else
				vehicles.addTaxi(new Taxi(game,vehiclePos));
		}
		
		for(int i=0 ; i<pos.length ; i++){
			if(player.getY()==pos[i] && posPerm[i]==true){
				player.setScore(player.getScore()+20);
				posPerm[i]=false;
			}
		}
		
		player.tick();
		alligator.tick();
		vehicles.tick();
		riverItems.tick();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(font);
		g.drawString("Score: "+player.getScore(),10,game.getHeight()-20);
		riverItems.render(g);
		alligator.render(g);
		player.render(g);
		vehicles.render(g);
	}
}