package com.learzhu.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 这种启动模式比较特殊，因为它会启用一个新的栈结构，将Acitvity放置于这个新的栈结构中，并保证不再有其他Activity实例进入。
 */
public class SingleInstanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
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
                //将SingleTaskActivity之上的Activity实例统统出栈，将SingleTaskActivity变为栈顶对象，显示到幕前。
                Intent intent = new Intent(SingleInstanceActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });
    }
}
