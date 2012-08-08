package com.example.freestore;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ListView list;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.appList);
        list.setAdapter(new StoreListAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    class StoreListAdapter extends ArrayAdapter {
    	StoreListAdapter() {
    		super(MainActivity.this, R.layout.list_item);
    	}
    	public View getView(int position, View convertView,
    			ViewGroup parent) {
    		LayoutInflater inflater = getLayoutInflater();
    		View row = inflater.inflate(R.layout.list_item, parent, false);
    		
    		TextView label = (TextView) row.findViewById(R.id.listItemText);
    		label.setText(R.string.list_item_string);
    		
    		return row;
    	}
    }
}
