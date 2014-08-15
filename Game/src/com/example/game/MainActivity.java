package com.example.game;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	public static int nrOfPlayers = 0;
	public static String player1Name;
	public static String player2Name;
	public static String player3Name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	public void enterName(View view){
		Sound.buttonClick(this);
		findViewById(R.id.play_1_button).setVisibility(View.VISIBLE);
		findViewById(R.id.play_3_button).setVisibility(View.VISIBLE);
		findViewById(R.id.play_5_button).setVisibility(View.VISIBLE);
		findViewById(R.id.play_10_button).setVisibility(View.VISIBLE);
		findViewById(R.id.menu_button).setVisibility(View.VISIBLE);
		EditText player1 = (EditText)findViewById(R.id.editPlayer1);
		player1Name = player1.getText().toString();
		EditText player2 = (EditText)findViewById(R.id.editPlayer2);
		player2Name = player2.getText().toString();
		EditText player3 = (EditText)findViewById(R.id.editPlayer3);
		player3Name = player3.getText().toString();
		if (player1Name.equals("")){
			player1Name = "Player 1";
		}
		if (player2Name.equals("")){
			player2Name = "Player 2";
		}
		if (player3Name.equals("")){
			player3Name = "Player 3";
		}
		findViewById(R.id.editPlayer1).setVisibility(View.GONE);
		findViewById(R.id.editPlayer2).setVisibility(View.GONE);
		findViewById(R.id.editPlayer3).setVisibility(View.GONE);
		findViewById(R.id.continue_button).setVisibility(View.GONE);
	}
	public void chooseMode(View view){
		Sound.buttonClick(this);
		switch (view.getId()) {
        case (R.id.play_button):
        	nrOfPlayers = 2;
        	choseName();
        	break;
        case (R.id.play3_button):
        	nrOfPlayers = 3;
        	choseName();
        	break;
		}	
	}
	public void choseName(){
		if (nrOfPlayers == 2){
        	findViewById(R.id.editPlayer1).setVisibility(View.VISIBLE);
        	findViewById(R.id.editPlayer2).setVisibility(View.VISIBLE);
        	findViewById(R.id.continue_button).setVisibility(View.VISIBLE);
        	findViewById(R.id.editPlayer3).setVisibility(View.GONE);
		}
		else if (nrOfPlayers == 3){
			findViewById(R.id.editPlayer1).setVisibility(View.VISIBLE);
        	findViewById(R.id.editPlayer2).setVisibility(View.VISIBLE);
        	findViewById(R.id.editPlayer3).setVisibility(View.VISIBLE);
        	findViewById(R.id.continue_button).setVisibility(View.VISIBLE);
		}
	}
	public void startNewGame(View view){
		Sound.buttonClick(this);
		Intent intent = new Intent(this, PlayerOneActivity.class);
		switch (view.getId()) {
        case (R.id.play_1_button):
        	intent.putExtra("gameMode", 1);
        break;
        case (R.id.play_3_button):
        	intent.putExtra("gameMode", 3);
        break;
        case (R.id.play_5_button):
        	intent.putExtra("gameMode", 5);
        break;
        case (R.id.play_10_button):
        	intent.putExtra("gameMode", 10);
        break;
		}
		startActivity(intent);
	}
	public void returnMain(View view){
		Sound.buttonClick(this);
		findViewById(R.id.play_1_button).setVisibility(View.GONE);
		findViewById(R.id.play_3_button).setVisibility(View.GONE);
		findViewById(R.id.play_5_button).setVisibility(View.GONE);
		findViewById(R.id.play_10_button).setVisibility(View.GONE);
		findViewById(R.id.menu_button).setVisibility(View.GONE);
		findViewById(R.id.play_button).setVisibility(View.VISIBLE);
		findViewById(R.id.play3_button).setVisibility(View.VISIBLE);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.mute_settings) {
			boolean b = Sound.mute();
			if(b){
				item.setTitle("Unmute");
			}
			else{
				item.setTitle("Mute");
			}
			return true;
		}
		if (id == R.id.about){
			Intent intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}
