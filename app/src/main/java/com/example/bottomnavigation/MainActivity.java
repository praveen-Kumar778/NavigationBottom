package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView =findViewById(R.id.bottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();
                if(id==R.id.navHome){
                   loadFrag(new AFragment(),false);
                }else if(id==R.id.search){
                    loadFrag(new BFragment(),false);
                }else if(id==R.id.utilities){
                    loadFrag(new CFragment(),false);
                }else if(id==R.id.navContact){
                    loadFrag(new DFragment(),false);
                }else{
                    loadFrag(new EFragment(),true);
                }
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.profile);
    }

    public void loadFrag(Fragment fragment,boolean flag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(flag){
            fragmentTransaction.add(R.id.frame,fragment);
        }else{
            fragmentTransaction.replace(R.id.frame,fragment);
        }
        fragmentTransaction.commit();
    }
}