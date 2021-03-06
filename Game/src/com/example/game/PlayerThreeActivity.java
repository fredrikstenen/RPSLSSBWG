package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class PlayerThreeActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_three);
		setTitle(MainActivity.player3Name);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	public void goToResult(View view){
		Sound.buttonClick(this);
		Intent oldIntent = getIntent();
		Intent intent = new Intent(this, ResultThreeActivity.class);
		intent.putExtra("gameMode", oldIntent.getIntExtra("gameMode", 0));
		intent.putExtra("playerOneChoice", oldIntent.getIntExtra("playerOneChoice", 0));
		intent.putExtra("playerTwoChoice", oldIntent.getIntExtra("playerTwoChoice", 0));
		switch (view.getId()){
		case (R.id.rock_button):
			intent.putExtra("playerThreeChoice", Game.ROCKLIST);
        break;
        case (R.id.paper_button):
        	intent.putExtra("playerThreeChoice", Game.PAPERLIST);
        break;
        case (R.id.scissors_button):
        	intent.putExtra("playerThreeChoice", Game.SCISSORSLIST);
        break;
        case (R.id.lizard_button):
        	intent.putExtra("playerThreeChoice", Game.LIZARDLIST);
        break;
        case (R.id.spock_button):
        	intent.putExtra("playerThreeChoice", Game.SPOCKLIST);
        break;
        case (R.id.spiderman_button):
        	intent.putExtra("playerThreeChoice", Game.SPIDERMANLIST);
        break;
        case (R.id.batman_button):
        	intent.putExtra("playerThreeChoice", Game.BATMANLIST);
        break;
        case (R.id.wizard_button):
        	intent.putExtra("playerThreeChoice", Game.WIZARDLIST);
        break;
        case (R.id.glock_button):
        	intent.putExtra("playerThreeChoice", Game.GLOCKLIST);
        break;
		}
		startActivity(intent);
		PlayerThreeActivity.this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player_three, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_player_three,
					container, false);
			return rootView;
		}
	}

}
