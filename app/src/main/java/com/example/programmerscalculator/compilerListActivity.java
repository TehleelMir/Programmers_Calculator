package com.example.programmerscalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ListActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class compilerListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new customAdapter());
    }
    class customAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.complierNames.length;
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
           // view=getLayoutInflater().inflate(R.layout.custom_listview_for_links,null);
            //TextView textView=view.findViewById(R.id.testing);
           // textView.setText(data.complierNames[i]);
            //textView.setMovementMethod(LinkMovementMethod.getInstance());
            return view;
        }
    }
}
