package com.wooeun18.hell;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager= getSupportFragmentManager();
        FragmentTransaction tran= fragmentManager.beginTransaction();
        tran.add(R.id.container, new home()); //container 는 Main.xml View 아이디
        tran.commit();

        bnv= findViewById(R.id.btn);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction tran= fragmentManager.beginTransaction();
                Fragment fragment= null;

                switch (item.getItemId()){
                    case R.id.home :
                        fragment= new home();
                        break;

                    case R.id.rec :
                        fragment= new receipt();
                        break;

                    case R.id.map :
                        fragment= new map();
                        break;

                    case R.id.chat :
                        fragment= new chat();
                        break;

                    case R.id.hum :
                        fragment= new myinfo();
                        break;

                }//s

                //기존 프래그먼트를 없애고 새로운 프래그먼트로 재배치 .
                tran.replace(R.id.container,fragment);
                tran.commit(); //작업 완료 .

                return true; //항상 트루로 해야함.
            }//boolean
        });//setOn
    }//onCr
}//Main