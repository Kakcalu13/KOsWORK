package mediaplayer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio{
	public static void main(String[] args){
		String bip= "voice.mp3";
		Media hit = new Media(bip);
		MediaPlayer mediaPlayer=new MediaPlayer(hit);
		mediaPlayer.play();
	}
}