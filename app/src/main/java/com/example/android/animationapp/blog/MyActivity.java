package com.example.android.animationapp.blog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.animationapp.LinearGradientActivity;
import com.example.android.animationapp.R;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button Next= (Button) findViewById(R.id.Next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyActivity.this, LinearGradientActivity.class));
            }
        });
//        MyView dashView = (MyView) findViewById(R.id.myview);
        PathDashPathView dashView = (PathDashPathView) findViewById(R.id.my_dash_view);
//        MyDashView dashView = (MyDashView) findViewById(R.id.my_dash_view);
//        dashView.startAnim();
    }
}
