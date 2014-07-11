package com.example.game;

import android.content.Context;
import android.media.MediaPlayer;



public class Sound {
	static MediaPlayer mp;
	static boolean mute = false;
	
	public static void buttonClick(Context c){
		if (mute == false){
		mp = MediaPlayer.create(c, R.raw.button_click);
		mp.start();
		}
	}
	public static void applause(Context c){
		if (mute == false){
			mp = MediaPlayer.create(c, R.raw.applause);
			mp.start();
			}
	}
	public static void draw_sound(Context c){
		if (mute == false){
			mp = MediaPlayer.create(c, R.raw.draw_sound);
			mp.start();
			}
	}
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
