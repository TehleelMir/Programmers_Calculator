package com.example.programmerscalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ListView;

public class ascii_activity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ascii_activity);
        listView=findViewById(R.id.list);
        listView.setAdapter(new customadapter());
        getSupportActionBar().setTitle("ASCII Table");
    }
    private class customadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.detail.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.custom_listview_for_links,null);
            TextView textView=view.findViewById(R.id.one);
            textView.setText(i+"");
            textView=view.findViewById(R.id.two);
            textView.setText(data.detail[i]);
            return view;
        }
    }
}
