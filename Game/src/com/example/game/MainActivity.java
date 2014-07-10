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
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	
	public static int nrOfPlayers = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	public void chooseMode(View view){
		findViewById(R.id.play_1_button).setVisibility(View.VISIBLE);
		findViewById(R.id.play_3_button).setVisibility(View.VISIBLE);
		findViewById(R.id.play_5_button).setVisibility(View.VISIBLE);
		findViewById(R.id.play_10_button).setVisibility(View.VISIBLE);
		findViewById(R.id.menu_button).setVisibility(View.VISIBLE);
		findViewById(R.id.play_button).setVisibility(View.GONE);
		findViewById(R.id.play3_button).setVisibility(View.GONE);
		findViewById(R.id.play_multi_button).setVisibility(View.GONE);
		switch (view.getId()) {
        case (R.id.play_button):
        	nrOfPlayers = 2;
        break;
        case (R.id.play3_button):
        	nrOfPlayers = 3;
        break;
		}
	}
	public void startNewGame(View view){
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
		findViewById(R.id.play_1_button).setVisibility(View.GONE);
		findViewById(R.id.play_3_button).setVisibility(View.GONE);
		findViewById(R.id.play_5_button).setVisibility(View.GONE);
		findViewById(R.id.play_10_button).setVisibility(View.GONE);
		findViewById(R.id.menu_button).setVisibility(View.GONE);
		findViewById(R.id.play_button).setVisibility(View.VISIBLE);
		findViewById(R.id.play3_button).setVisibility(View.VISIBLE);
		findViewById(R.id.play_multi_button).setVisibility(View.VISIBLE);
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
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
