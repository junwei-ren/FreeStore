package com.example.freestore;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends Activity {
	ListView list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		list = (ListView) findViewById(R.id.appList);
//		list.setAdapter(new StoreListAdapter());
//		FrameLayout.LayoutParams listLayoutParams = (FrameLayout.LayoutParams) list.getLayoutParams();
		TabHost tabHost= (TabHost)findViewById(R.id.tabhost);
		tabHost.setup();
		TabWidget tabWidgetBottom = tabHost.getTabWidget();
//		RelativeLayout.LayoutParams tabLayoutParams = (RelativeLayout.LayoutParams) tabWidgetBottom.getLayoutParams();
//		listLayoutParams.height -= tabLayoutParams.height;
//		list.setLayoutParams(listLayoutParams);
		
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

	class StoreListAdapter extends ArrayAdapter {
		StoreListAdapter() {
			super(MainActivity.this, R.layout.list_item, new String[24]);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = getLayoutInflater();
			View row = inflater.inflate(R.layout.list_item, parent, false);

			TextView label = (TextView) row.findViewById(R.id.listItemText);
			label.setText(R.string.list_item_string);

			return row;
		}
	}
}
