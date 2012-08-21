package com.example.freestore;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.app.TabActivity;
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

public class TabHomePageActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_homepage);
		TabHost tabHost= (TabHost)findViewById(R.id.home_tabhost);
		tabHost.setup(new LocalActivityManager(this, false));
	}
}