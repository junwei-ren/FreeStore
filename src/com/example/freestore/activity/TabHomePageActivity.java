package com.example.freestore.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.freestore.R;
import com.example.freestore.adapter.*;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.ListView;
import android.widget.TabHost;

public class TabHomePageActivity extends TabActivity {
	ListView listVew;
	PackageManager pkgManager;
	List<PackageInfo> pkgInfoList;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_homepage);
		TabHost tabHost= (TabHost)getTabHost();
		ArrayList<PackageInfo> items = new ArrayList<PackageInfo>();
		listVew = (ListView)findViewById(R.id.appList);
		pkgManager = getPackageManager();
		pkgInfoList = pkgManager.getInstalledPackages(0);
		
		for(int i=0;i<pkgInfoList.size();i++) {
			PackageInfo pkgInfo = pkgInfoList.get(i);
			if ((pkgInfo.applicationInfo.flags & pkgInfo.applicationInfo.FLAG_SYSTEM) <= 0) {
				items.add(pkgInfo);
			}
		}

		listVew.setAdapter(new StoreListAdapter(this, R.layout.list_item, items));	
		
		listVew = (ListView)findViewById(R.id.appList2);
		listVew.setAdapter(new StoreListAdapter(this, R.layout.list_item, items));	
		tabHost.addTab(tabHost.newTabSpec("Recommand").setIndicator("Recommand").setContent(R.id.appList)); 
		tabHost.addTab(tabHost.newTabSpec("Latest Update").setIndicator("Latest Update").setContent(R.id.appList2));

	}
}