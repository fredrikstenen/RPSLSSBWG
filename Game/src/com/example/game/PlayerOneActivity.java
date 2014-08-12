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

public class PlayerOneActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		setContentView(R.layout.activity_player_one);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	public void goToPlayerTwo(View view){
		Sound.buttonClick(this);
		Intent oldIntent = getIntent();
        Intent intent = new Intent(this, PlayerTwoActivity.class);
        intent.putExtra("gameMode", oldIntent.getIntExtra("gameMode", 0));
        switch (view.getId()) {
        case (R.id.rock_button):
        	intent.putExtra("playerOneChoice", Game.ROCKLIST);
        break;
        case (R.id.paper_button):
        	intent.putExtra("playerOneChoice", Game.PAPERLIST);
        break;
        case (R.id.scissors_button):
        	intent.putExtra("playerOneChoice", Game.SCISSORSLIST);
        break;
        case (R.id.lizard_button):
        	intent.putExtra("playerOneChoice", Game.LIZARDLIST);
        break;
        case (R.id.spock_button):
        	intent.putExtra("playerOneChoice", Game.SPOCKLIST);
        break;
        case (R.id.spiderman_button):
        	intent.putExtra("playerOneChoice", Game.SPIDERMANLIST);
        break;
        case (R.id.batman_button):
        	intent.putExtra("playerOneChoice", Game.BATMANLIST);
        break;
        case (R.id.wizard_button):
        	intent.putExtra("playerOneChoice", Game.WIZARDLIST);
        break;
        case (R.id.glock_button):
        	intent.putExtra("playerOneChoice", Game.GLOCKLIST);
        break;
        }
        startActivity(intent);
        PlayerOneActivity.this.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player_one, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_player_one,
					container, false);
			return rootView;
		}
	}

}
