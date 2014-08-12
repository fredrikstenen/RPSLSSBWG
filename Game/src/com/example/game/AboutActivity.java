package com.example.game;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class AboutActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	@Override
	protected void onStart() {
		super.onStart();
		setContentView(R.layout.activity_about);
		TextView textViewLink =(TextView)findViewById(R.id.textViewLink1);
		textViewLink.setClickable(true);
		textViewLink.setMovementMethod(LinkMovementMethod.getInstance());
		String text = "<a href='http://www.samkass.com/theories/RPSSL.html'> Sam Kass website </a>";
		textViewLink.setText(Html.fromHtml(text));
		TextView textViewLink2 =(TextView)findViewById(R.id.textViewLink2);
		textViewLink2.setClickable(true);
		textViewLink2.setMovementMethod(LinkMovementMethod.getInstance());
		String text2 = " <a href='http://creativecommons.org/licenses/by-nc/3.0/'> Creative Commons Attribution-NonCommercial 3.0 Unported License. </a>";
		textViewLink2.setText(Html.fromHtml(text2));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_about,
					container, false);
			return rootView;
		}
	}

}
