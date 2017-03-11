package com.learzhu.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingleTopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);
        TextView textView = (TextView) findViewById(R.id.show_task_id);
        textView.setText(this.toString());
        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //first
//                Intent intent = new Intent(SingleTopActivity.this, SingleTopActivity.class);
//                startActivity(intent);
                //second singleTop2Standard
                Intent intent = new Intent(SingleTopActivity.this, StandardActivity.class);
                startActivity(intent);
            }
        });
    }
}
