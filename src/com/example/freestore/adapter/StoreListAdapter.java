package com.example.freestore.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.freestore.R;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreListAdapter extends ArrayAdapter<PackageInfo> {
	ArrayList<PackageInfo> pkgList;
	PackageManager pkgManager;
	public StoreListAdapter(Context context, int resource, ArrayList<PackageInfo> items) {
		super(context, resource, items);
		pkgList = items;
		pkgManager = context.getPackageManager();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		PackageInfo pkgInfo;
		LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.list_item, parent, false);
		
		TextView label = (TextView) row.findViewById(R.id.listItemText);
		ImageView iconView = (ImageView) row.findViewById(R.id.listItemImage);
		Button btn = (Button) row.findViewById(R.id.listItemBtn);
		pkgInfo = pkgList.get(position);
		label.setText(pkgInfo.applicationInfo.loadLabel(pkgManager).toString());
		iconView.setImageDrawable(pkgInfo.applicationInfo.loadIcon(pkgManager)) ;
		btn.setText(R.string.list_button_str);
		return row;
	}
}