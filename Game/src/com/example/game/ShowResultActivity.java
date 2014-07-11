package com.example.game;

import com.example.game.ResultThreeActivity.PlaceholderFragment;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class ShowResultActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		setContentView(R.layout.fragment_show_result);
		Bundle extras = getIntent().getExtras();
		int i = extras.getInt("playerOneChoice");
		int j = extras.getInt("playerTwoChoice");
		int k = extras.getInt("gameMode");
		Game game = new Game(i,j,k);
	    String winner = game.play();
	    lookForWinner(k, game);
		TextView resultView = (TextView) findViewById(R.id.result_view);
	    resultView.setText(winner);
	    TextView player1Result = (TextView) findViewById(R.id.player1_result);
	    player1Result.setText(Integer.toString(game.getP1W()));
	    TextView drawsResult = (TextView) findViewById(R.id.draws_result);
	    drawsResult.setText(Integer.toString(game.getDraws()));
	    TextView player2Result = (TextView) findViewById(R.id.player2_result);
	    player2Result.setText(Integer.toString(game.getP2W()));
	}
	public void startNewGame(View view){
		Sound.buttonClick(this);
		Intent oldIntent = getIntent();
		Intent intent = new Intent(this, PlayerOneActivity.class);
		intent.putExtra("gameMode", oldIntent.getIntExtra("gameMode", 0));
		startActivity(intent);
	}
	public void startMain(View view){
		Sound.buttonClick(this);
		Intent intent = new Intent(this, MainActivity.class);
		Game.resetAll();
		startActivity(intent);
	}
	public void lookForWinner(int k, Game game){
		if(k==game.getP1W()){
			Intent intent = new Intent(this, WinnerActivity.class);
			intent.putExtra("player", "PLAYER ONE\n IS THE WINNER!");
			intent.putExtra("p1R", Integer.toString(game.getP1W()));
			intent.putExtra("draws", Integer.toString(game.getDraws()));
			intent.putExtra("p2R", Integer.toString(game.getP2W()));
			intent.putExtra("phrase", game.play());
			startActivity(intent);
			ShowResultActivity.this.finish();
	   	}
	    else if(k == game.getP2W()){
	    	Intent intent = new Intent(this, WinnerActivity.class);
	    	intent.putExtra("player", "PLAYER TWO\n IS THE WINNER!");
			intent.putExtra("p1R", Integer.toString(game.getP1W()));
			intent.putExtra("draws", Integer.toString(game.getDraws()));
			intent.putExtra("p2R", Integer.toString(game.getP2W()));
			intent.putExtra("phrase", game.play());
			startActivity(intent);
			ShowResultActivity.this.finish();
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_result, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_show_result,
					container, false);
			return rootView;
		}
	}

}
