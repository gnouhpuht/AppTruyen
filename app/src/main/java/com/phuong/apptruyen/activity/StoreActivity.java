package com.phuong.apptruyen.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.phuong.apptruyen.adapter.AdapterStore;
import com.phuong.apptruyen.sql.ManagerSql;
import com.phuong.apptruyen.R;
import com.phuong.apptruyen.item.Store;
import com.phuong.apptruyen.inter.IStore;


import java.util.List;

public class StoreActivity extends AppCompatActivity implements IStore {
    private ManagerSql managerSql;
    private List<Store> stores;
    private RecyclerView rcStore;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        managerSql=new ManagerSql(this);
        int id=getIntent().getIntExtra("ID",0);
        String nameToptic=getIntent().getStringExtra("TOPICNAME");
        stores=managerSql.getAllStore(id);
        rcStore=findViewById(R.id.rc_store);
        rcStore.setLayoutManager(new LinearLayoutManager(this));
        rcStore.setAdapter(new AdapterStore(this));
    }

    @Override
    public int getSize() {
        return stores.size();
    }

    @Override
    public Store getStore(int position) {
        return stores.get(position);
    }

    @Override
    public void onClick(int position) {
        Intent intent=new Intent();
        intent.setClass(this,ContentActivity.class);
        intent.putExtra("IDStory",stores.get(position).getIdStore());
        makeAnimation(R.anim.alpha_animation);
        startActivity(intent);
    }

    private void makeAnimation(int anId) {
        //tai animation tu xml len
        Animation animation = AnimationUtils.loadAnimation(this, anId);
        //cai dat animation cho view
        rcStore.setAnimation(animation);
        rcStore.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("MainActivity", "onAnimationStart....");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("MainActivity", "onAnimationEnd....");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("MainActivity", "onAnimationRepeat....");

            }
        });
    }
}
