package com.example.android.animationapp;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LinearGradientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_gradient);
        RelativeLayout ll = (RelativeLayout) findViewById(R.id.activity_linear_gradient);
        LinearGradientView linearGradientView = new LinearGradientView(this);
        ll.addView(linearGradientView);
        ShimmerTextView shimmerTextView=new ShimmerTextView(this);
        shimmerTextView.setText("闪光字效果倒萨倒萨打算大撒大撒的任务全额完全通过v");
        ll.addView(shimmerTextView);
    }

    class LinearGradientView extends View {
        private Paint mPaint;

        public LinearGradientView(Context context) {
            super(context);
            init();
        }

        public LinearGradientView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public LinearGradientView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init();
        }

        private void init() {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
            mPaint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
//            mPaint.setShader(new LinearGradient(0,getHeight()/2,getWidth(),getHeight()/2,0xffff0000,0xff00ff00, Shader.TileMode.CLAMP));
//            canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);

            int[] colors = {0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00, 0xff00ffff};
            float[] pos = {0f, 0.2f, 0.4f, 0.6f, 1.0f};
//            LinearGradient multiGradient = new LinearGradient(0, getHeight() / 2, getWidth(), getHeight() / 2, colors, pos, Shader.TileMode.CLAMP);
            LinearGradient multiGradient = new LinearGradient(0,0,getWidth()/2,getHeight()/2,colors,pos, Shader.TileMode.CLAMP);
            mPaint.setShader(multiGradient);
//            canvas.drawRect(0, 0, getWidth()/2, getHeight()/2, mPaint);

            mPaint.setTextSize(50);
            canvas.drawText("欢迎关注Cassidy的blog",0,100,mPaint);

        }
    }
    class ShimmerTextView extends TextView {
        private Paint mPaint;
        private int mDx;
        private LinearGradient mLinearGradient;
        public ShimmerTextView(Context context) {
            super(context);
            init();
        }

        public ShimmerTextView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public ShimmerTextView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init();
        }

        private void init(){
            mPaint =getPaint();
        }

        @Override
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);

            ValueAnimator animator = ValueAnimator.ofInt(0,2*getMeasuredWidth());
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mDx = (Integer) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            animator.setRepeatMode(ValueAnimator.RESTART);
            animator.setRepeatCount(ValueAnimator.INFINITE);
            animator.setDuration(2000);
            animator.start();

            mLinearGradient = new LinearGradient(- getMeasuredWidth(),0,0,0,
                    new int[]{getCurrentTextColor(),0xff00ff00,getCurrentTextColor()},
                    new float[]{0, 0.5f, 1},
                    Shader.TileMode.CLAMP
            );
        }

        @Override
        protected void onDraw(Canvas canvas) {

            Matrix matrix = new Matrix();
            matrix.setTranslate(mDx,0);
            mLinearGradient.setLocalMatrix(matrix);
            mPaint.setShader(mLinearGradient);

            super.onDraw(canvas);
        }
    }
}
