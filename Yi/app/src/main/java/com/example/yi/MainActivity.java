package com.example.yi;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import com.example.yi.yiFragment.detect_menu;
import com.example.yi.yiFragment.discuss_menu;
import com.example.yi.yiFragment.home_menu;
import com.example.yi.yiFragment.me_menu;
import com.example.yi.yiFragment.member_menu;

public class MainActivity extends FragmentActivity {
    private RadioButton home , detect, member, discuss, me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findAllViewById();

        toSetAllOnClickListener();

        home.setChecked(true);
    }

    private  void toSetAllOnClickListener(){
        toSetOnCheckedChangeListener(home);
        toSetOnCheckedChangeListener(detect);
        toSetOnCheckedChangeListener(member);
        toSetOnCheckedChangeListener(discuss);
        toSetOnCheckedChangeListener(me);
    }

    private  void findAllViewById() {
        home = (RadioButton) findViewById(R.id.home_menu);
        detect = (RadioButton) findViewById(R.id.detect_menu);
        member = (RadioButton) findViewById(R.id.member_menu);
        discuss = (RadioButton) findViewById(R.id.discuss_menu);
        me = (RadioButton) findViewById(R.id.me_menu);
    }

    private home_menu homeMenu = null;
    private detect_menu detectMenu = null;
    private member_menu memberMenu = null;
    private discuss_menu discussMenu = null;
    private me_menu meMenu = null;

    private Fragment lastFragment =  null;

    public void toSetOnCheckedChangeListener(final RadioButton radioButton) {
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();

                    if(lastFragment != null) {
                        transaction.hide(lastFragment);
                    }

                    if(radioButton.getId() == home.getId()){
                        if(homeMenu == null){
                            homeMenu = new home_menu();
                            transaction.add(R.id.fragment_container, homeMenu);
                        }
                        else {
                            transaction.show(homeMenu);
                        }

                        lastFragment = homeMenu;
                    }
                    else if(radioButton.getId() == detect.getId()) {
                        if(detectMenu == null){
                            detectMenu = new detect_menu();
                            transaction.add(R.id.fragment_container, detectMenu);
                        }
                        else {
                            transaction.show(detectMenu);
                        }

                        lastFragment = detectMenu;
                    }
                    else if(radioButton.getId() == member.getId()) {
                        if(memberMenu == null){
                            memberMenu = new member_menu();
                            transaction.add(R.id.fragment_container, memberMenu);
                        }
                        else {
                            transaction.show(memberMenu);
                        }

                        lastFragment = memberMenu;
                    }
                    else if(radioButton.getId() == discuss.getId()) {
                        if(discussMenu == null){
                            discussMenu = new discuss_menu();
                            transaction.add(R.id.fragment_container, discussMenu);
                        }
                        else {
                            transaction.show(discussMenu);
                        }
                        lastFragment = discussMenu;
                    }
                    else if (radioButton.getId() == me.getId()) {
                        if(meMenu == null){
                            meMenu = new me_menu();
                            transaction.add(R.id.fragment_container, meMenu);
                        }
                        else {
                            transaction.show(meMenu);
                        }
                        lastFragment = meMenu;
                    }
                    transaction.commit();
                }
            }
        });
    }
}