package com.learzhu.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.learzhu.launchmode.service.BootService;

public class StandardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        TextView textView = (TextView) findViewById(R.id.show_task_id);
        textView.setText(this.toString());
        TextView textView1 = (TextView) findViewById(R.id.show_current_task_id);
        textView1.setText("current task id: " + this.getTaskId());
        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //first
//                Intent intent = new Intent(StandardActivity.this, StandardActivity.class);
//                startActivity(intent);
                //Standard2SingleTop
//                Intent intent = new Intent(StandardActivity.this, SingleTopActivity.class);
//                startActivity(intent);
                //Standard2SingleTask
                Intent intent = new Intent(StandardActivity.this, SingleTaskActivity.class);
                startActivity(intent);
//                Intent intent = new Intent(StandardActivity.this, SingleInstanceActivity.class);
//                startActivity(intent);
            }
        });
    }

    public void service(View view) {
        Intent intent = new Intent(StandardActivity.this, BootService.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startService(intent);
    }
}
