package main;

import javafx.scene.image.Image;

public class Animation {
	
	private Image[] frames;
	public double duration;
	
	public Animation(Image[] frames,double duration) {
		
		this.frames = frames;
		this.duration = duration;
		
	}
	
	public Image getFrame(double time) {
		
		int index = (int) ((time * (frames.length % duration)) / duration);
		return frames[index];
		
	}
	
}
