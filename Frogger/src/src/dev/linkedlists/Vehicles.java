package src.dev.linkedlists;

import java.awt.Graphics;
import java.util.LinkedList;
import src.dev.entities.*;
import src.dev.game.Game;

public class Vehicles {
	
	private LinkedList<Car> car = new LinkedList<Car>();
	private LinkedList<Truck> truck = new LinkedList<Truck>();
	private LinkedList<Bus> bus = new LinkedList<Bus>();
	private LinkedList<Taxi> taxi = new LinkedList<Taxi>();
	
	Game game;
	
	public Vehicles(Game game){
		this.game=game;
	}
	
	public void tick(){
		for(int i=0 ; i<car.size() ; i++ ){
			if(	car.get(i).getX()>game.getWidht()+Entity.car_width+1 || car.get(i).getX()<-(Entity.car_width+1) )
				removeCar(car.get(i));
			else
				car.get(i).tick();
		}
		
		for(int i=0 ; i<truck.size() ; i++ ){
			if(truck.get(i).getX()>game.getWidht()+Entity.truck_width+1||truck.get(i).getX()<-(Entity.truck_width+1))
				removeTruck(truck.get(i));
			else
				truck.get(i).tick();
		}
		
		for(int i=0 ; i<bus.size() ; i++ ){
			if(bus.get(i).getX()>game.getWidht()+Entity.truck_width+1||bus.get(i).getX()<-(Entity.truck_width+1))
				removeBus(bus.get(i));
			else
				bus.get(i).tick();
		}
		
		for(int i=0; i<taxi.size() ; i++){
			if(taxi.get(i).getX()>game.getWidht()+Entity.car_width+1||taxi.get(i).getX()<-(Entity.car_width+1))
				removeTaxi(taxi.get(i));
			else
				taxi.get(i).tick();
		}
	}
	
	public void render(Graphics g){
		for(int i=0 ; i<car.size() ; i++ )
			car.get(i).render(g);
		
		for(int i=0 ; i<truck.size() ; i++ )
			truck.get(i).render(g);
		
		for(int i=0 ; i<bus.size() ; i++ )
			bus.get(i).render(g);
		
		for(int i=0 ; i<taxi.size() ; i++ )
			taxi.get(i).render(g);
	}
	
	public void addCar(Car car){
		this.car.add(car);
	}
	
	public void addTruck(Truck truck){
		this.truck.add(truck);
	}
	
	public void addBus(Bus bus){
		this.bus.add(bus);
	}
	
	public void addTaxi(Taxi taxi){
		this.taxi.add(taxi);
	}
	
	public void removeCar(Car car){
		this.car.remove(car);
	}
	
	public void removeTruck(Truck truck){
		this.truck.remove(truck);
	}
	
	public void removeBus(Bus bus){
		this.bus.remove(bus);
	}
	
	public void removeTaxi(Taxi taxi){
		this.taxi.remove(taxi);
	}
}