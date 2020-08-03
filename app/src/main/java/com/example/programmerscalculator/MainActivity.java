package com.example.programmerscalculator;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    ListView listView;
    String titles[];
    boolean doublePressToExit=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawerlayout);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.onListOpen,R.string.onListClose);
        drawerLayout.setDrawerListener(drawerToggle);
        listView=findViewById(R.id.drawerlist);
        titles=getResources().getStringArray(R.array.list_titles);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,titles));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startFragment(i);
                drawerLayout.closeDrawer(listView);
            }
        });
        startFragment(0);
        
    }
    private void startFragment(int position){
        Fragment fragment;
        if(position==0){
            fragment=new HomeFragment();
            getSupportActionBar().setTitle(titles[position]);
        }
        else{
            getSupportActionBar().setTitle(titles[position]);
            fragment=new AboutFragment();
        }
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,fragment);
        ///////ft.addToBackStack(null);
        ft.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    //code for double press to exit!
    public void onBackPressed(){
        if(doublePressToExit){
            super.onBackPressed();
            return;
        }
        doublePressToExit=true;
        Toast.makeText(this,"Please click BACK again to exit",Toast.LENGTH_LONG).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doublePressToExit=false;
            }
        },2000);
    }

    //these methods are for opening and closing of drawer list
    public boolean onOptionsItemSelected(MenuItem item){
        if(drawerToggle.onOptionsItemSelected(item))
            return true;
        return false;
    }
    public void onPostCreate(Bundle b){
        super.onPostCreate(b);
        drawerToggle.syncState();
    }
}
