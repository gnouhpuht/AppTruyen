package com.phuong.apptruyen.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.phuong.apptruyen.adapter.AdapterTopic;
import com.phuong.apptruyen.sql.ManagerSql;
import com.phuong.apptruyen.R;
import com.phuong.apptruyen.item.Topic;
import com.phuong.apptruyen.inter.ITopic;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ITopic {
    private ManagerSql managerSql;
    private RecyclerView rcTopic;
    private List<Topic> topics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        managerSql=new ManagerSql(this);
        topics=managerSql.getAllTopic();
        rcTopic=findViewById(R.id.rc_topic);
        rcTopic.setLayoutManager(new LinearLayoutManager(this));
        rcTopic.setAdapter(new AdapterTopic(this));
    }

    @Override
    public int getSize() {
        return topics.size();
    }

    @Override
    public Topic getTopic(int position) {
        return topics.get(position);
    }

    @Override
    public void onClick(int position) {
        Intent intent=new Intent();
        intent.setClass(this, StoreActivity.class);
        intent.putExtra("ID",topics.get(position).getId());
        intent.putExtra("TOPICNAME",topics.get(position).getName());
        makeAnimation(R.anim.alpha_animation);
        startActivity(intent);
    }
    private void makeAnimation(int anId) {
        //tai animation tu xml len
        Animation animation = AnimationUtils.loadAnimation(this, anId);
        //cai dat animation cho view
        rcTopic.setAnimation(animation);
        rcTopic.startAnimation(animation);
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
