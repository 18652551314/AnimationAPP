package com.example.android.animationapp;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.animationapp.blog.MyActivity;

public class LayoutChangesActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout layoutTransitionGroup,layoutTransitionGroup2;

    private int i = 0,j=0;
    LayoutTransition transitioner = new LayoutTransition();
    LayoutTransition transitioner2 = new LayoutTransition();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_changes);
        layoutTransitionGroup = (LinearLayout) findViewById(R.id.layoutTransitionGroup);
        layoutTransitionGroup2= (LinearLayout) findViewById(R.id.layoutTransitionGroup2);
        findViewById(R.id.add_btn).setOnClickListener(this);
        findViewById(R.id.remove_btn).setOnClickListener(this);

        findViewById(R.id.next).setOnClickListener(this);

        findViewById(R.id.add_btn2).setOnClickListener(this);
        findViewById(R.id.remove_btn2).setOnClickListener(this);

        transitioner = new LayoutTransition();
        //入场动画:view在这个容器中消失时触发的动画
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, "rotationY", 0f, 360f, 0f);
        transitioner.setAnimator(LayoutTransition.APPEARING, animIn);
        //出场动画:view显示时的动画
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        transitioner.setAnimator(LayoutTransition.DISAPPEARING, animOut);
        layoutTransitionGroup.setLayoutTransition(transitioner);




        transitioner2.setAnimator(LayoutTransition.APPEARING, animIn);
        transitioner2.setAnimator(LayoutTransition.DISAPPEARING, animOut);
        PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left",0,100,0);
        PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top",1,1);
        PropertyValuesHolder pvhScaleX = PropertyValuesHolder.ofFloat("ScaleX",1f,9f,1f);
        Animator changeAppearAnimator = ObjectAnimator.ofPropertyValuesHolder(layoutTransitionGroup2, pvhLeft,pvhTop,pvhScaleX);
        transitioner2.setAnimator(LayoutTransition.CHANGE_APPEARING,changeAppearAnimator);
        /**
         * LayoutTransition.CHANGE_DISAPPEARING动画
         */
        PropertyValuesHolder outLeft = PropertyValuesHolder.ofInt("left",0,0);
        PropertyValuesHolder outTop = PropertyValuesHolder.ofInt("top",0,0);

        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
        Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
        Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
        Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
        Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
        Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
        Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
        Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
        Keyframe frame10 = Keyframe.ofFloat(1, 0);
        PropertyValuesHolder mPropertyValuesHolder = PropertyValuesHolder.ofKeyframe("rotation",frame0,frame1,frame2,frame3,frame4,frame5,frame6,frame7,frame8,frame9,frame10);
        ObjectAnimator mObjectAnimatorChangeDisAppearing = ObjectAnimator.ofPropertyValuesHolder(this, outLeft,outTop,mPropertyValuesHolder);
        transitioner2.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, mObjectAnimatorChangeDisAppearing);
        //设置单个item间的动画间隔
        transitioner2.setStagger(LayoutTransition.CHANGE_APPEARING, 30);
        layoutTransitionGroup2.setLayoutTransition(transitioner2);

    }

    private void addButtonView() {
        i++;
        Button button = new Button(this);
        button.setText("button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        layoutTransitionGroup.addView(button, 0);
    }

    private void removeButtonView() {
        if (i > 0) {
            layoutTransitionGroup.removeViewAt(0);
        }
        i--;
    }
    private void addButtonView2() {
        j++;
        Button button = new Button(this);
        button.setText("button" + i);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        layoutTransitionGroup2.addView(button, 0);
    }

    private void removeButtonView2() {
        if (j > 0) {
            layoutTransitionGroup2.removeViewAt(0);
        }
        j--;
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.add_btn) {
            addButtonView();
        }
        if (v.getId() == R.id.remove_btn) {
            removeButtonView();
        }
        if (v.getId() == R.id.next) {
            startActivity(new Intent(LayoutChangesActivity.this, MyActivity.class));
        }
        if (v.getId() == R.id.add_btn2) {
            addButtonView2();
        }
        if (v.getId() == R.id.remove_btn2) {
            removeButtonView2();
        }

    }
}
