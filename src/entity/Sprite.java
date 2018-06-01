package entity;

import main.Animation;

public class Sprite {
	protected int x, y, layer;
	protected int[] hitbox;
	
	public Sprite() {
		
		x = 0;
		y = 0;
		
	}
	
	public Sprite(int x,int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public int getX() {
		
		return x;
		
	}
	
	public int getY() {
		
		return y;
		
	}
	
	public void setX(int x) {
		
		this.x = x;
		
	}
	
	public void setY(int y) {
		
		this.y = y;
		
	}
	
}
