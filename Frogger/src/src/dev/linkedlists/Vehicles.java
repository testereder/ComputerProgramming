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
	
	Car tempCar;
	Truck tempTruck;
	Bus tempBus;
	Taxi tempTaxi;
	Game game;
	
	public Vehicles(Game game){
		this.game=game;
	}
	
	public void tick(){
		for(int i=0 ; i<car.size() ; i++ ){
			tempCar = car.get(i);
			if(tempCar.getX()>game.getWidht()+Entity.car_width+1||tempCar.getX()<-(Entity.car_width+1))
				removeCar(tempCar);
			tempCar.tick();
		}
		
		for(int i=0 ; i<truck.size() ; i++ ){
			tempTruck = truck.get(i);
			if(tempTruck.getX()>game.getWidht()+Entity.truck_width+1||tempTruck.getX()<-(Entity.truck_width+1))
				removeTruck(tempTruck);
			tempTruck.tick();
		}
		
		for(int i=0 ; i<bus.size() ; i++ ){
			tempBus = bus.get(i);
			if(tempBus.getX()>game.getWidht()+Entity.truck_width+1||tempBus.getX()<-(Entity.truck_width+1))
				removeBus(tempBus);
			tempBus.tick();
		}
		
		for(int i=0; i<taxi.size() ; i++){
			tempTaxi = taxi.get(i);
			if(tempTaxi.getX()>game.getWidht()+Entity.car_width+1||tempTaxi.getX()<-(Entity.car_width+1))
				removeTaxi(tempTaxi);
			tempTaxi.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i=0 ; i<car.size() ; i++ ){
			tempCar = car.get(i);
			tempCar.render(g);
		}
		
		for(int i=0 ; i<truck.size() ; i++ ){
			tempTruck = truck.get(i);
			tempTruck.render(g);
		}
		
		for(int i=0 ; i<bus.size() ; i++ ){
			tempBus = bus.get(i);
			tempBus.render(g);
		}
		
		for(int i=0 ; i<taxi.size() ; i++ ){
			tempTaxi = taxi.get(i);
			tempTaxi.render(g);
		}
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