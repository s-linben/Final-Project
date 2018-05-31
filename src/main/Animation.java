package main;

import javafx.scene.image.Image;

/**
 * This class is intended to process and update the animation for each entity based on the time.
 * 
 * @author s-linben
 *
 */
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
