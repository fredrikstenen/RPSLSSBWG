package com.example.game;

import com.example.game.MainActivity.PlaceholderFragment;

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
import android.widget.TextView;
import android.os.Build;

public class ResultThreeActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_three);
		Bundle extras = getIntent().getExtras();
		int i = extras.getInt("playerOneChoice");
		int j = extras.getInt("playerTwoChoice");
		int a = extras.getInt("playerThreeChoice");
		int k = extras.getInt("gameMode");
		Game game = new Game(i,j,a,k);
	    String winner = game.playThree();
	    lookForWinner(k, game);
		TextView resultView = (TextView) findViewById(R.id.result_viewX);
	    resultView.setText(winner);
	    TextView player1Result = (TextView) findViewById(R.id.player1_resultX);
	    player1Result.setText(Integer.toString(game.getP1W()));
	    TextView player2Result = (TextView) findViewById(R.id.player2_resultX);
	    player2Result.setText(Integer.toString(game.getP2W()));
	    TextView player3Result = (TextView) findViewById(R.id.player3_resultX);
	    player3Result.setText(Integer.toString(game.getP3W()));
		}
	public void startNewGame(View view){
		Intent oldIntent = getIntent();
		Intent intent = new Intent(this, PlayerOneActivity.class);
		intent.putExtra("gameMode", oldIntent.getIntExtra("gameMode", 0));
		startActivity(intent);
	}
	public void startMain(View view){
		Intent intent = new Intent(this, MainActivity.class);
		Game.resetAll();
		startActivity(intent);
	}
	public void lookForWinner(int k, Game game){
		int ingenting = 0;
		if (k <= game.getP1W()) {
			ingenting = ingenting + 1;
		}
		if (k <= game.getP2W()) {
			ingenting = ingenting + 1;
		}
		if (k <= game.getP3W()) {
			ingenting = ingenting + 1;
		}
		
		if(ingenting > 1) {
			
		} else {
		
		if(k==game.getP1W()){
			Intent intent = new Intent(this, WinnerActivity.class);
			intent.putExtra("player", "PLAYER ONE\n IS THE WINNER!");
			intent.putExtra("p1R", Integer.toString(game.getP1W()));
			intent.putExtra("p2R", Integer.toString(game.getP2W()));
			intent.putExtra("p3R", Integer.toString(game.getP3W()));
			intent.putExtra("phrase", game.playThree());
			startActivity(intent);
			ResultThreeActivity.this.finish();
	   	}
	    else if(k == game.getP2W()){
	    	Intent intent = new Intent(this, WinnerActivity.class);
	    	intent.putExtra("player", "PLAYER TWO\n IS THE WINNER!");
	    	intent.putExtra("p1R", Integer.toString(game.getP1W()));
			intent.putExtra("p2R", Integer.toString(game.getP2W()));
			intent.putExtra("p3R", Integer.toString(game.getP3W()));
			intent.putExtra("phrase", game.playThree());
			startActivity(intent);
			ResultThreeActivity.this.finish();
	    }
	    else if(k == game.getP3W()){
	    	Intent intent = new Intent(this, WinnerActivity.class);
	    	intent.putExtra("player", "PLAYER THREE\n IS THE WINNER!");
	    	intent.putExtra("p1R", Integer.toString(game.getP1W()));
			intent.putExtra("p2R", Integer.toString(game.getP2W()));
			intent.putExtra("p3R", Integer.toString(game.getP3W()));
			intent.putExtra("phrase", game.playThree());
			startActivity(intent);
			ResultThreeActivity.this.finish();
	    }
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result_three, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
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
			View rootView = inflater.inflate(R.layout.fragment_result_three,
					container, false);
			return rootView;
		}
	}

}
