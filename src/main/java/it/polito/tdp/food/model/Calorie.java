package it.polito.tdp.food.model;

public class Calorie implements Comparable<Calorie>{

	Food f;
	double d;
	public Calorie(Food f, double d) {
		super();
		this.f = f;
		this.d = d;
	}
	public Food getF() {
		return f;
	}
	public double getD() {
		return d;
	}
	@Override
	public int compareTo(Calorie o) {
		return -(int)(this.d-o.getD());
	}
	@Override
	public String toString() {
		return f.getDisplay_name()+" "+d;
	}
	
	
	
	
}
