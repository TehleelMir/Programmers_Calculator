package com.example.programmerscalculator;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends ListFragment {
    private LayoutInflater inflater;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater=inflater;
        setListAdapter(new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.main_titles)));
        return super.onCreateView(inflater,container,savedInstanceState);
    }
    public void onListItemClick(ListView l, View v, int position, long id){
        final Intent intent;
        switch (position){
            case 0:
                intent=new Intent(inflater.getContext(),ascii_activity.class);
                break;
            case 1:
                intent=new Intent(inflater.getContext(),converter_activity.class);
                break;
            case 2:
                intent=new Intent(inflater.getContext(),mod_activity.class);
                break;
            case 3:
                intent=new Intent(inflater.getContext(),compilerActivity.class);
                break;
            default:
                intent=null;
        }
        startActivity(intent);
    }
}
