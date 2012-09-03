package com.example.freestore.activity;

import java.util.List;

import android.app.ListActivity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class StoreListActivity extends ListActivity {
	PackageManager pkgManager;
	List<PackageInfo> pkgInfoList;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pkgManager = getPackageManager();
		pkgInfoList = pkgManager.getInstalledPackages(0);
		
	}
	public List<PackageInfo> getList() {
		return pkgInfoList;
	}
}