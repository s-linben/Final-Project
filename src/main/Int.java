package main;

public class Int {
	protected int integer;
	
	public Int() {
		integer = 0;
	}
	
	public Int(int integer) {
		this.integer = integer;
	}
	
	public int getInteger() {
		return integer;
	}
	
	public void increment() {
		integer++;
	}
	
	public void decrement() {
		integer--;
	}
	
}
