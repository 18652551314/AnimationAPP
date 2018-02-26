package com.example.android.animationapp;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button Next, Alpha, Scale, Rotate, Translate, Set, Accelerate, Anticipate, AnticipateOvershoot, Bounce,
            Cycle, Decelerate, Linear, Overshoot, ValueA, ValueBounce, ValueArgbEvaluater, ValueOfObject,
            ObjectA, propertyValuesHolder,FrameA;
    Animation AlphaAnimation, ScaleAnimation, RotateAnimation, TranslateAnimation, SetAnimation, TangHuang;
    TextView tv;
    ImageView targetIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        targetIv = (ImageView) findViewById(R.id.targetIv);
        targetIv.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(this);
        //从XML文件中获取动画
        AlphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        ScaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        RotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        TranslateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
        SetAnimation = AnimationUtils.loadAnimation(this, R.anim.set);

        TangHuang = AnimationUtils.loadAnimation(this, R.anim.tanghuang);

        Next = (Button) findViewById(R.id.Next);
        Next.setOnClickListener(this);

        Alpha = (Button) findViewById(R.id.Alpha);
        Alpha.setOnClickListener(this);
        Scale = (Button) findViewById(R.id.Scale);
        Scale.setOnClickListener(this);
        Rotate = (Button) findViewById(R.id.Rotate);
        Rotate.setOnClickListener(this);
        Translate = (Button) findViewById(R.id.Translate);
        Translate.setOnClickListener(this);
        Set = (Button) findViewById(R.id.Set);
        Set.setOnClickListener(this);


        Accelerate = (Button) findViewById(R.id.Accelerate);
        Accelerate.setOnClickListener(this);
        Anticipate = (Button) findViewById(R.id.Anticipate);
        Anticipate.setOnClickListener(this);
        AnticipateOvershoot = (Button) findViewById(R.id.AnticipateOvershoot);
        AnticipateOvershoot.setOnClickListener(this);
        Bounce = (Button) findViewById(R.id.Bounce);
        Bounce.setOnClickListener(this);
        Cycle = (Button) findViewById(R.id.Cycle);
        Cycle.setOnClickListener(this);
        Decelerate = (Button) findViewById(R.id.Decelerate);
        Decelerate.setOnClickListener(this);
        Linear = (Button) findViewById(R.id.Linear);
        Linear.setOnClickListener(this);
        Overshoot = (Button) findViewById(R.id.Overshoot);
        Overshoot.setOnClickListener(this);

        ValueA = (Button) findViewById(R.id.Value);
        ValueA.setOnClickListener(this);
        ValueBounce = (Button) findViewById(R.id.ValueBounce);
        ValueBounce.setOnClickListener(this);
        ValueArgbEvaluater = (Button) findViewById(R.id.ValueArgbEvaluater);
        ValueArgbEvaluater.setOnClickListener(this);
        ValueOfObject = (Button) findViewById(R.id.ValueOfObject);
        ValueOfObject.setOnClickListener(this);
        ObjectA = (Button) findViewById(R.id.Object);
        ObjectA.setOnClickListener(this);
        propertyValuesHolder = (Button) findViewById(R.id.propertyValuesHolder);
        propertyValuesHolder.setOnClickListener(this);
        FrameA= (Button) findViewById(R.id.FrameA);
        FrameA.setOnClickListener(this);
    }

    int i = 0;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                Toast.makeText(MainActivity.this, "clicked me", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Next:
                startActivity(new Intent(MainActivity.this, LayoutActivity.class));
                break;
            case R.id.Alpha:
                android.view.animation.AlphaAnimation alphaAnim = new AlphaAnimation(1.0f, 0.1f);
                alphaAnim.setDuration(3000);
                alphaAnim.setFillBefore(true);
                tv.startAnimation(alphaAnim);
//                tv.startAnimation(AlphaAnimation);
                break;
            case R.id.Scale:
                android.view.animation.ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(700);
                tv.startAnimation(scaleAnimation);
//                tv.startAnimation(ScaleAnimation);
                break;
            case R.id.Rotate:
                android.view.animation.RotateAnimation rotateAnim = new RotateAnimation(0, -650, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnim.setDuration(3000);
                rotateAnim.setFillAfter(true);
                tv.startAnimation(rotateAnim);
//                tv.startAnimation(RotateAnimation);
                break;
            case R.id.Translate:
                android.view.animation.TranslateAnimation translateAnim = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -80, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -80);
                translateAnim.setDuration(2000);
                translateAnim.setFillBefore(true);
                tv.startAnimation(translateAnim);
//                tv.startAnimation(TranslateAnimation);
                break;
            case R.id.Set:
                android.view.animation.AlphaAnimation alphAnim = new AlphaAnimation(0.1f, 1f);
                android.view.animation.ScaleAnimation scalAnim = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                android.view.animation.RotateAnimation rotatAnim = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

                android.view.animation.AnimationSet setAnim = new AnimationSet(true);
                setAnim.addAnimation(alphAnim);
                setAnim.addAnimation(scalAnim);
                setAnim.addAnimation(rotatAnim);

                setAnim.setDuration(3000);
                setAnim.setFillAfter(true);
                tv.startAnimation(setAnim);
//                tv.startAnimation(SetAnimation);
                break;
            case R.id.Accelerate:
                SetAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                tv.startAnimation(SetAnimation);
                break;
            case R.id.Anticipate:
                SetAnimation.setInterpolator(new AnticipateOvershootInterpolator());
                tv.startAnimation(SetAnimation);
                break;
            case R.id.AnticipateOvershoot:
                SetAnimation.setInterpolator(new AnticipateOvershootInterpolator());
                tv.startAnimation(SetAnimation);
                break;
            case R.id.Bounce:
                TangHuang.setInterpolator(new BounceInterpolator());
                tv.startAnimation(TangHuang);
                break;
            case R.id.Cycle:
                SetAnimation.setInterpolator(new CycleInterpolator(1));
                tv.startAnimation(SetAnimation);
                break;
            case R.id.Decelerate:
                SetAnimation.setInterpolator(new DecelerateInterpolator());
                tv.startAnimation(SetAnimation);
                break;
            case R.id.Linear:
                SetAnimation.setInterpolator(new LinearInterpolator());
                tv.startAnimation(SetAnimation);
                break;
            case R.id.Overshoot:
                SetAnimation.setInterpolator(new OvershootInterpolator());
                tv.startAnimation(SetAnimation);
                break;
            case R.id.Value:
                ValueAnimator animator = ValueAnimator.ofInt(200, 400, 50, 300);
//                ValueAnimator animator = ValueAnimator.ofFloat(0f,400f,50f,300f);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        tv.layout(curValue, curValue, curValue + tv.getWidth(), curValue + tv.getHeight());
                    }
                });
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Log.d("qijian", "animation start");
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.d("qijian", "animation end");
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Log.d("qijian", "animation cancel");
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        Log.d("qijian", "animation repeat");
                    }
                });
                animator.setRepeatMode(ValueAnimator.REVERSE);
                animator.setRepeatCount(ValueAnimator.RESTART);
                animator.setDuration(2000);
                animator.start();
                break;
            case R.id.ValueBounce:
                ValueAnimator animato = ValueAnimator.ofInt(0, 400);

                animato.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        tv.layout(tv.getLeft(), curValue, tv.getRight(), curValue + tv.getHeight());
                    }
                });
                animato.setDuration(1000);
                animato.setInterpolator(new BounceInterpolator());
                animato.start();
                break;

            case R.id.ValueArgbEvaluater:
                ValueAnimator animat = ValueAnimator.ofInt(0xffffff00, 0xff0000ff);//即从黄色，变为蓝色
                animat.setDuration(3000);
                animat.setEvaluator(new ArgbEvaluator());
                animat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        tv.setBackgroundColor(curValue);
                    }
                });

                animat.start();
                break;
            case R.id.ValueOfObject:
                ValueAnimator animatoro = ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character('Z'));
                animatoro.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        char text = (char) animation.getAnimatedValue();
                        tv.setText(String.valueOf(text));
                    }
                });
                animatoro.setDuration(10000);
                animatoro.setInterpolator(new AccelerateInterpolator());
                animatoro.start();
                break;
            case R.id.Object:
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tv, "alpha", 1, 0, 1);
                switch (i % 9) {
                    case 0:
                        objectAnimator = ObjectAnimator.ofFloat(tv, "alpha", 1, 0, 1);
                        break;
                    case 1:
                        objectAnimator = ObjectAnimator.ofFloat(tv, "rotation", 0, 180, 0);
                        break;
                    case 2:
                        objectAnimator = ObjectAnimator.ofFloat(tv, "rotationX", 0, 270, 0);
                        break;
                    case 3:
                        objectAnimator = ObjectAnimator.ofFloat(tv, "rotationY", 0, 180, 0);
                        break;
                    case 4:
                        objectAnimator = ObjectAnimator.ofFloat(tv, "translationX", 0, 200, -200, 0);
                        break;
                    case 5:
                        objectAnimator = ObjectAnimator.ofFloat(tv, "translationY", 0, 200, -100, 0);
                        break;
                    case 6:
                        objectAnimator = ObjectAnimator.ofFloat(tv, "scaleX", 0, 3, 1);
                        break;
                    case 7:
                        objectAnimator = ObjectAnimator.ofFloat(tv, "scaleY", 0, 3, 1);
                        break;
                    case 8:
                        objectAnimator = ObjectAnimator.ofInt(tv, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
                        break;
                    default:
                        objectAnimator = ObjectAnimator.ofFloat(tv, "translationX", 0, 200, -200, 0);
                        break;
                }


                objectAnimator.setDuration(2000);
                objectAnimator.start();
                i++;
                break;
            case R.id.propertyValuesHolder:
                PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("Rotation", 60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f);
                PropertyValuesHolder colorHolder = PropertyValuesHolder.ofInt("BackgroundColor", 0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
                ObjectAnimator oanimator = ObjectAnimator.ofPropertyValuesHolder(tv, rotationHolder, colorHolder);
                oanimator.setDuration(3000);
                oanimator.setInterpolator(new AccelerateInterpolator());
                oanimator.start();
                break;
            case R.id.FrameA:
//                AnimationDrawable animationDrawable = new AnimationDrawable();
//                animationDrawable.setOneShot(false);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_0), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_1), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_2), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_3), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_4), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_5), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_6), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_7), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_8), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_9), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_10), 100);
//                animationDrawable.addFrame(getResources().getDrawable(R.drawable.common_loading3_11), 100);
//                targetIv.setImageDrawable(animationDrawable);
//                animationDrawable.start();
                AnimationDrawable animationDrawable = (AnimationDrawable) targetIv.getDrawable();
                animationDrawable.start();

                break;
        }
    }


    class CharEvaluator implements TypeEvaluator<Character> {
        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int startInt = (int) startValue;
            int endInt = (int) endValue;
            int curInt = (int) (startInt + fraction * (endInt - startInt));
            char result = (char) curInt;
            return result;
        }

    }

}
