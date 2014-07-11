package com.example.game;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class PlayerTwoActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_two);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	public void goToNext(View view){
		Sound.buttonClick(this);
		Intent oldIntent = getIntent();
		Intent intent = new Intent(this, ShowResultActivity.class);
		if (MainActivity.nrOfPlayers == 3){
			intent = new Intent(this, PlayerThreeActivity.class);
		}
		intent.putExtra("gameMode", oldIntent.getIntExtra("gameMode", 0));
		intent.putExtra("playerOneChoice", oldIntent.getIntExtra("playerOneChoice", 0));
		switch (view.getId()){
		case (R.id.rock_button):
			intent.putExtra("playerTwoChoice", (int)1);
        break;
        case (R.id.paper_button):
        	intent.putExtra("playerTwoChoice", (int)2);
        break;
        case (R.id.scissors_button):
        	intent.putExtra("playerTwoChoice", (int)3);
        break;
        case (R.id.lizard_button):
        	intent.putExtra("playerTwoChoice", (int)4);
        break;
        case (R.id.spock_button):
        	intent.putExtra("playerTwoChoice", (int)5);
        break;
        case (R.id.spiderman_button):
        	intent.putExtra("playerTwoChoice", (int)6);
        break;
        case (R.id.batman_button):
        	intent.putExtra("playerTwoChoice", (int)7);
        break;
        case (R.id.wizard_button):
        	intent.putExtra("playerTwoChoice", (int)8);
        break;
        case (R.id.glock_button):
        	intent.putExtra("playerTwoChoice", (int)9);
        break;
		}
		startActivity(intent);
		PlayerTwoActivity.this.finish();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player_two, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_player_two,
					container, false);
			return rootView;
		}
	}

}
