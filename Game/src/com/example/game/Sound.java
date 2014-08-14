package com.example.game;

import android.content.Context;
import android.media.MediaPlayer;

/** The Sound class contains methods that play sound when called.
 * 
 * 
 * 
 * @author Daniel
 * @author Fredrik
 */
public class Sound {
	static MediaPlayer mp;
	static boolean mute = false;
	/** Plays a button click sound when called, unless muted.
	 * 
	 * @param c Contains the context from which the method was called.
	 */
	public static void buttonClick(Context c){
		if (mute == false){
			mp = MediaPlayer.create(c, R.raw.button_click);
			mp.start();
		}
	}
	/** Plays the sound of applause when called, unless sound is muted.
	 * 
	 * @param c Contains the context from which the method was called.
	 */
	public static void applause(Context c){
		if (mute == false){
			mp = MediaPlayer.create(c, R.raw.applause);
			mp.start();
		}
	}
	/** Plays draw sound, unless sound is muted.
	 * 
	 * @param c Contains the context from which the method was called.
	 */
	public static void draw_sound(Context c){
		if (mute == false){
			mp = MediaPlayer.create(c, R.raw.draw_sound);
			mp.start();
		}
	}
	
	/** Mutes or unmutes the program depending on the current state of the mute variable.
	 * 
	 * @return returns the state of the mute variable. This is used to indicate whether or not
	 * the program is muted for the users.
	 */
	public static boolean mute(){
		if (mute){
			mute = false;
		}
		else{
			mute = true;
		}
		return mute;
	}
}