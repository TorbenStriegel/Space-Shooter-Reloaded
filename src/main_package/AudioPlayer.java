package main_package;
import javax.sound.sampled.*;
import java.io.*;

public class AudioPlayer {

	Clip clip;
	
	public AudioPlayer() {

		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(Var.musik_default));
			AudioFormat af = audioInputStream.getFormat();
			int size = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
			byte[] audio = new byte[size];
			DataLine.Info info = new DataLine.Info(Clip.class, af, size);
			audioInputStream.read(audio, 0, size);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(af, audio, 0, size);
			clip.loop(100);
			clip.start();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Musik konnte nicht geladen werden. (AudioPlayer)");
		}

	}
	
	public AudioPlayer(String sound) {

		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound));
			AudioFormat af = audioInputStream.getFormat();
			int size = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
			byte[] audio = new byte[size];
			DataLine.Info info = new DataLine.Info(Clip.class, af, size);
			audioInputStream.read(audio, 0, size);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(af, audio, 0, size);
			clip.start();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Musik konnte nicht geladen werden. (AudioPlayer)");
		}

	}
	
	public void musikStoppen(){
		clip.stop();
		System.out.println("stop");
	}

}
