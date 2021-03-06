package com.example.game;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class WinnerActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winner);
		Intent oldIntent = getIntent();
		if (MainActivity.nrOfPlayers == 2){
			Sound.applause(this);
			TextView player1Headline = (TextView) findViewById(R.id.player1_headline);
		    player1Headline.setText(MainActivity.player1Name);
		    TextView player2Headline = (TextView) findViewById(R.id.player2_headline);
		    player2Headline.setText(MainActivity.player2Name);
			TextView phraseView = (TextView) findViewById(R.id.result_view);
		    phraseView.setText(oldIntent.getStringExtra("phrase"));
		    TextView player1Result = (TextView) findViewById(R.id.player1_result);
		    player1Result.setText(oldIntent.getStringExtra("p1R"));
		    TextView drawsResult = (TextView) findViewById(R.id.draws_result);
		    drawsResult.setText(oldIntent.getStringExtra("draws"));
		    TextView player2Result = (TextView) findViewById(R.id.player2_result);
		    player2Result.setText(oldIntent.getStringExtra("p2R"));
			TextView winnerView = (TextView) findViewById(R.id.winner_view);
			winnerView.setText(oldIntent.getStringExtra("player"));
		}
		else if (MainActivity.nrOfPlayers == 3) {
			TextView phraseView = (TextView) findViewById(R.id.result_view);
		    phraseView.setText(oldIntent.getStringExtra("phrase"));
		    TextView player1Headline = (TextView) findViewById(R.id.player1_headline);
		    player1Headline.setText(MainActivity.player1Name);
		    TextView player1Result = (TextView) findViewById(R.id.player1_result);
		    player1Result.setText(oldIntent.getStringExtra("p1R"));
		    TextView player2Result = (TextView) findViewById(R.id.draws_result);
		    player2Result.setText(oldIntent.getStringExtra("p2R"));
		    player2Result.setTextColor(android.graphics.Color.RED);
		    TextView player2Headline = (TextView) findViewById(R.id.draws_headline);
		    player2Headline.setText(MainActivity.player2Name);
		    player2Headline.setTextColor(android.graphics.Color.RED);
		    TextView player3Result = (TextView) findViewById(R.id.player2_result);
		    player3Result.setTextColor(android.graphics.Color.GREEN);
		    player3Result.setText(oldIntent.getStringExtra("p3R"));
		    TextView player3Headline = (TextView) findViewById(R.id.player2_headline);
		    player3Headline.setText(MainActivity.player3Name);
		    player3Headline.setTextColor(android.graphics.Color.GREEN);
			TextView winnerView = (TextView) findViewById(R.id.winner_view);
			winnerView.setText(oldIntent.getStringExtra("player"));
			if (1 == oldIntent.getIntExtra("showButton", 0)){
				Sound.draw_sound(this);
				findViewById(R.id.new_game_button).setVisibility(View.VISIBLE);
				MainActivity.nrOfPlayers = 2;
				Game.resetAll();
			}
			else if (2 == oldIntent.getIntExtra("showButton", 0)){
				Sound.draw_sound(this);
				findViewById(R.id.new_game_button).setVisibility(View.VISIBLE);
				Game.resetAll();
			}
			else {
				Sound.applause(this);
			}
		}
		
	}
	public void startMain(View view){
		Sound.buttonClick(this);
		Intent intent = new Intent(this, MainActivity.class);
		Game.resetAll();
		MainActivity.player1Name = null;
		MainActivity.player2Name = null;
		MainActivity.player3Name = null;
		startActivity(intent);
	}
	public void startNewGame(View view){
		Sound.buttonClick(this);
		Intent oldIntent = getIntent();
		Intent intent = new Intent(this, PlayerOneActivity.class);
		intent.putExtra("gameMode", oldIntent.getIntExtra("gameMode", 0));
		startActivity(intent);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.winner, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_winner,
					container, false);
			return rootView;
		}
	}

}
