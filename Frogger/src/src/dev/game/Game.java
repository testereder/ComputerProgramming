package src.dev.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import src.dev.display.Display;
import src.dev.graphics.Assets;
import src.dev.input.KeyManager;
import src.dev.input.MouseManager;
import src.dev.states.GameState;
import src.dev.states.State;


public class Game implements Runnable{
	
	private int width,height;
	private float defaultSpeed;
	private String title;
	
	private Display display;
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	private State gameState;
	
	public Game(String title,int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		display.close();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		init();
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		//GAME LOOP
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Tickts and Frames: "+ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	private void init(){
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();
		
		gameState = new GameState(this);
		
		State.setState(gameState);
	}
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState()!=null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0,0,width,height);
		//Draw Here!
		
		g.drawImage(Assets.bgnd,0,0,width,height,null);
		if(State.getState()!=null)
			State.getState().render(g);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	//Getters and Setters
	
	public int getWidht(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public float getDefaultSpeed(){
		return defaultSpeed;
	}
	
	public void setDefaultSpeed(float speed){
		defaultSpeed=speed;
	}
}