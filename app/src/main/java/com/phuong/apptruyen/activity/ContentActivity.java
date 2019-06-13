package com.phuong.apptruyen.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.phuong.apptruyen.item.ContentApp;
import com.phuong.apptruyen.sql.ManagerSql;
import com.phuong.apptruyen.R;

public class ContentActivity extends AppCompatActivity {
    private ManagerSql managerSql;
    private ContentApp content;
    private String name;
    private String conten;
    private TextView tvName;
    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        managerSql = new ManagerSql(this);
        int id = getIntent().getIntExtra("IDStory", 0);
        content = managerSql.getContent(id);
        tvName = findViewById(R.id.tv_name_story);
        tvContent = findViewById(R.id.tv_content);

        inits();
    }

    private void inits() {
        name = content.getName();
        conten = content.getContentApp();
        tvName.setText(name);
        tvContent.setText(android.text.Html.fromHtml(conten));

    }
}
