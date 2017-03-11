package com.learzhu.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 如果发现有对应的Activity实例，则使此Activity实例之上的其他Activity实例统统出栈，使此Activity实例成为栈顶对象，显示到幕前。
 */
public class SingleTaskActivity extends AppCompatActivity {
    private static final String TAG = "SingleTaskActivity";
    private TextView resultTv;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        String stringExtra = intent.getStringExtra("Service");
        if (stringExtra != null) {
            resultTv.setText(stringExtra);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String stringExtra = getIntent().getStringExtra("Service");
        Log.i(TAG, "onCreate: " + stringExtra);
        setContentView(R.layout.activity_single_task);
        resultTv = (TextView) findViewById(R.id.show_result);
        if (stringExtra != null) {
            resultTv.setText(stringExtra);
        }
        TextView textView = (TextView) findViewById(R.id.show_task_id);
        textView.setText(this.toString());
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
                Intent intent = new Intent(SingleTaskActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });
    }

}
