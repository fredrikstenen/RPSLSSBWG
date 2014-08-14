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
import android.widget.TextView;
import android.os.Build;

public class WinnerActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_winner);
		Intent oldIntent = getIntent();
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

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	public void startMain(View view){
		Intent intent = new Intent(this, MainActivity.class);
		Game.resetAll();
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
			View rootView = inflater.inflate(R.layout.fragment_winner,
					container, false);
			return rootView;
		}
	}

}
