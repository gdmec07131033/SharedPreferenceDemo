package cn.edu.gdmec.s07131033.sharedpreferencedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText edName, edAge, edHeight;
	public final static String PREFERENCES_NAME = "personal";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edName = (EditText) findViewById(R.id.editText1);
		edAge = (EditText) findViewById(R.id.editText2);
		edHeight = (EditText) findViewById(R.id.editText3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void READ(View v) {
		SharedPreferences myPre = getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_WORLD_READABLE + Context.MODE_WORLD_READABLE);
		String name = myPre.getString("Name", "Ma");
		int age = myPre.getInt("Age", 18);
		float height = myPre.getFloat("Height", 1.7f);
		edName.setText(name);
		edAge.setText(String.valueOf(age));
		edHeight.setText(String.valueOf(height));
	}

	public void WRITE(View v) {
		SharedPreferences myPre = getSharedPreferences(PREFERENCES_NAME,
				Context.MODE_WORLD_READABLE + Context.MODE_WORLD_READABLE);
		SharedPreferences.Editor myEditor = myPre.edit();
		myEditor.putString("Name", edName.getText().toString());
		myEditor.putInt("Age", Integer.parseInt(edAge.getText().toString()));
		myEditor.putFloat("Height",
				Float.parseFloat(edHeight.getText().toString()));
		myEditor.commit();
		myEditor.clear();
	}

}
