package com.example.freestore.activity;

import java.util.ArrayList;

import com.example.freestore.R;
import com.example.freestore.adapter.*;

import android.os.Bundle;
import android.app.TabActivity;
import android.widget.ListView;
import android.widget.TabHost;

public class TabHomePageActivity extends TabActivity {
	ListView list;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_homepage);
		TabHost tabHost= (TabHost)getTabHost();
//		tabHost.setup(new LocalActivityManager(this, false));
		tabHost.addTab(tabHost.newTabSpec("Recommand").setIndicator("Recommand").setContent(R.id.appList)); 
		tabHost.addTab(tabHost.newTabSpec("Latest Update").setIndicator("Latest Update").setContent(R.id.appList)); 
		try {
		list.setAdapter(new StoreListAdapter(this, R.layout.list_item, R.id.listItemText, new ArrayList<String>(24)));
		}
		catch (java.lang.NullPointerException e) {
			e.printStackTrace();
		}
	}
}