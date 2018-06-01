package main;

import javafx.scene.image.Image;

/**
 * This class is intended to process and update the animation for each entity based on the time.
 * 
 * @author Benjamin Lin
 *
 */
public class Animation {
	
	private Image[] frames;	// Image should all be 128 x 128 for props, but only things thar aren't this are things that aren't this size
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
