package com.example.freestore.adapter;

import java.util.List;

import com.example.freestore.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class StoreListAdapter extends ArrayAdapter<String> {
	StoreListAdapter(Context context, int resource, List<String> items) {
		super(context, resource, items);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.list_item, parent, false);
		
		
		TextView label = (TextView) row.findViewById(R.id.listItemText);
		label.setText(R.string.list_item_string);

		return row;
	}
}