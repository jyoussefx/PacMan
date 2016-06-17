package pac.man.engine;


import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class AudioHandler {
	
	private static Audio music;
	private static boolean loopStarted;
	private static boolean musicStarted;
	
	public static void init(){
        try {
        	music = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("res/PacMan.ogg"));
        	
	        System.out.println("Initialized music (hopefully)");
		} catch (Exception e) {
			System.out.println("RIP MUSIC");
			e.printStackTrace();
		}

	}
	
	
	public static void play(String key){
	}
	
	public static void playMusic(){
		if(!musicStarted){
			music.playAsSoundEffect(1.0f, 1.0f, false);
			musicStarted = true;
		}	
	}

}
