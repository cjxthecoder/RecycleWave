
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The Audio class is for implementing sound in-game. An audio has a {@link Clip}
 * that can be reset, set to a certain frame, be started, or be stopped.
 * 
 * @author Ali Haryanawalla
 *
 * @since 1.0
 */

public class Audio {
	
	private Clip clip;
	
	public Audio(File source) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(source);
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		
		// DO NOT CHANGE THE FOLLOWING FOR YOUR OWN SAFETY
		FloatControl gain = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		gain.setValue(-20.0f);
	}
    
	public void reset() {
        clip.stop();
        clip.setFramePosition(0);
    }
	
	public void setOffset(double seconds) {
        clip.setFramePosition((int)(48000 * seconds));
    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }
}
