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
import android.widget.TextView;

public class ResultThreeActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_three);
		setNames();
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
		MainActivity.player1Name = null;
		MainActivity.player2Name = null;
		MainActivity.player3Name = null;
		startActivity(intent);
	}
	public void lookForWinner(int k, Game game){
		int winCheck = 0;
		if (k <= game.getP1W()) {
			winCheck = winCheck + 1;
		}
		if (k <= game.getP2W()) {
			winCheck = winCheck + 1;
		}
		if (k <= game.getP3W()) {
			winCheck = winCheck + 1;
		}
		if(winCheck == 1) {
			Intent intent = new Intent(this, WinnerActivity.class);
			intent.putExtra("p1R", Integer.toString(game.getP1W()));
			intent.putExtra("p2R", Integer.toString(game.getP2W()));
			intent.putExtra("p3R", Integer.toString(game.getP3W()));
			
			if(k <= game.getP1W()){
				intent.putExtra("player", MainActivity.player1Name + "\n IS THE WINNER!");
		   	}
		    else if(k <= game.getP2W()){
		    	intent.putExtra("player", MainActivity.player2Name + "\n IS THE WINNER!");
		    }
		    else if(k <= game.getP3W()){
		    	intent.putExtra("player", MainActivity.player3Name + "\n IS THE WINNER!");
		    }
			intent.putExtra("phrase", game.playThree());
			startActivity(intent);
			ResultThreeActivity.this.finish();
		}
		else if (winCheck == 2) {
			Intent intent = new Intent(this, WinnerActivity.class);
			intent.putExtra("p1R", Integer.toString(game.getP1W()));
			intent.putExtra("p2R", Integer.toString(game.getP2W()));
			intent.putExtra("p3R", Integer.toString(game.getP3W()));
			
			if((k+1) == game.getP1W()){
				intent.putExtra("player", MainActivity.player1Name + "\n IS THE WINNER!");
		   	}
		    else if((k+1) == game.getP2W()){
		    	intent.putExtra("player", MainActivity.player2Name + "\n IS THE WINNER!");
		    }
		    else if((k+1) == game.getP3W()){
		    	intent.putExtra("player", MainActivity.player3Name + "\n IS THE WINNER!");
		    }
		    else {
		    	if (k == game.getP1W() && k == game.getP2W()){
		    		intent.putExtra("player", "DRAW BETWHEEN " + MainActivity.player1Name + " AND " + MainActivity.player2Name);
		    		intent.putExtra("showButton", 1);
		    	}
		    	if (k == game.getP1W() && k == game.getP3W()){
		    		intent.putExtra("player", "DRAW BETWHEEN " + MainActivity.player1Name + " AND " + MainActivity.player3Name);
		    		intent.putExtra("showButton", 1);
		    	}
		    	if (k == game.getP2W() && k == game.getP3W()){
		    		intent.putExtra("player", "DRAW BETWHEEN " + MainActivity.player2Name + " AND " + MainActivity.player3Name);
		    		intent.putExtra("showButton", 1);
		    	}
		    }
			intent.putExtra("phrase", game.playThree());
			intent.putExtra("gameMode", 1);
			startActivity(intent);
			ResultThreeActivity.this.finish();
		}
		else if (winCheck == 3){
			Intent intent = new Intent(this, WinnerActivity.class);
			intent.putExtra("p1R", Integer.toString(game.getP1W()));
			intent.putExtra("p2R", Integer.toString(game.getP2W()));
			intent.putExtra("p3R", Integer.toString(game.getP3W()));
			if (k == game.getP1W() && k == game.getP2W() && k == game.getP3W()){
	    		intent.putExtra("player", "DRAW BETWHEEN ALL PLAYERS");
	    		intent.putExtra("showButton", 2);
	    	}
			intent.putExtra("phrase", game.playThree());
			intent.putExtra("gameMode", 1);
			startActivity(intent);
			ResultThreeActivity.this.finish();
		}
	}
	public void setNames(){
		TextView player1View = (TextView) findViewById(R.id.player1_headlineX);
		player1View.setText(MainActivity.player1Name);
		TextView player2View = (TextView) findViewById(R.id.player2_headlineX);
		player2View.setText(MainActivity.player2Name);
		TextView player3View = (TextView) findViewById(R.id.player3_headlineX);
		player3View.setText(MainActivity.player3Name);
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
			View rootView = inflater.inflate(R.layout.fragment_result_three,
					container, false);
			return rootView;
		}
	}

}
