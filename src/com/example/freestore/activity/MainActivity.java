package com.example.freestore.activity;

import com.example.freestore.R;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
	ListView list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost= (TabHost)getTabHost();
		tabHost.addTab(tabHost.newTabSpec("Home").setIndicator("HomePage").setContent(new Intent(this, TabHomePageActivity.class))); 
		tabHost.addTab(tabHost.newTabSpec("Rank").setIndicator("Rank").setContent(new Intent(this, TabHomePageActivity.class))); 
		tabHost.addTab(tabHost.newTabSpec("Category").setIndicator("Category").setContent(new Intent(this, TabHomePageActivity.class))); 
		tabHost.addTab(tabHost.newTabSpec("Search").setIndicator("Search").setContent(new Intent(this, TabHomePageActivity.class))); 
		tabHost.addTab(tabHost.newTabSpec("Manage").setIndicator("Manage").setContent(new Intent(this, TabHomePageActivity.class)));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
