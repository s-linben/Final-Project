package elements;

public class ShorthandEntities {
	private int xcoord, ycoord, entityID;
	
	public ShorthandEntities() {
		this.xcoord = 0;
		this.ycoord = 0;
		this.entityID = 0;
	}
	
	public ShorthandEntities(int xcoord,int ycoord,int entityID) {
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		this.entityID = entityID;
	}
	
	public int getXcoord() {
		return xcoord;
	}
	
	public int getYcoord() {
		return ycoord;
	}
	
	public int getEntityID() {
		return entityID;
	}
	
	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}
	
	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}
	
	public void setEntityID(int entityID) {
		this.entityID = entityID;
	}
	
}
