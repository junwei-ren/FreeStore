package com.example.freestore.activity;

import java.util.ArrayList;

import com.example.freestore.R;
import com.example.freestore.adapter.*;

import android.os.Bundle;
import android.app.TabActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

public class TabHomePageActivity extends TabActivity {
	ListView list;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_homepage);
		TabHost tabHost= (TabHost)getTabHost();
		ArrayList<String> items = new ArrayList<String>();
		list = (ListView)findViewById(R.id.appList);

		for(int i=0;i<30;i++) {
			items.add(getString(R.string.list_item_string));
		}

		list.setAdapter(new StoreListAdapter(this, R.layout.list_item, items));	
		
		list = (ListView)findViewById(R.id.appList2);
		list.setAdapter(new StoreListAdapter(this, R.layout.list_item, items));	
		tabHost.addTab(tabHost.newTabSpec("Recommand").setIndicator("Recommand").setContent(R.id.appList)); 
		tabHost.addTab(tabHost.newTabSpec("Latest Update").setIndicator("Latest Update").setContent(R.id.appList2));

	}
}