package com.example.android.animationapp.blog;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

import com.example.android.animationapp.R;

/**
 * PathDashPathEffect动画效果view
 * 注意在main.xml中打开对应的xml
 * Created by qijian on 16/3/24.
 */
public class PathDashPathView extends View {
    public PathDashPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    int dx = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawPathDashPathEffect(canvas);
        dx++;
        invalidate();
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    private void drawPathDashPathEffect(Canvas canvas) {
        Paint paint = getPaint();
        canvas.drawColor(Color.BLACK);
        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(400, 100);
        path.lineTo(400, 300);
        path.lineTo(100, 300);
        path.close();
        /**
         * 利用以另一个路径为单位,延着路径盖章.相当于PS的印章工具
         */
        paint.setPathEffect(new PathDashPathEffect(getStampPath(0), 40, dx, PathDashPathEffect.Style.ROTATE));
        canvas.drawPath(path, paint);

        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.common_ic_googleplayservices) ,440,140,paint);
        canvas.translate(350, 0);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(1), 40, dx, PathDashPathEffect.Style.ROTATE));
        canvas.drawPath(path, paint);
        canvas.translate(0, 400);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(2), 40, dx, PathDashPathEffect.Style.ROTATE));
        canvas.drawPath(path, paint);
        canvas.translate(-350, 0);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(3), 40, dx, PathDashPathEffect.Style.ROTATE));
        canvas.drawPath(path, paint);
        canvas.translate(0, 400);
        paint.setPathEffect(new PathDashPathEffect(getStampPath(4), 40, dx, PathDashPathEffect.Style.ROTATE));
        canvas.drawPath(path, paint);
    }


    private Path getStampPath(int type) {
        Path path = new Path();
        switch (type) {
            case 0:
                //1三角形
                path.moveTo(0, 40);
                path.lineTo(20, 0);
                path.lineTo(40, 40);
                break;
            case 1:       //2三角形
                path.moveTo(20, 20);
                path.lineTo(0, 20);
                path.lineTo(10, 0);
                path.lineTo(30, 40);
                path.lineTo(40, 20);
                break;
            case 2:        //2正方形
                path.moveTo(20, 20);
                path.lineTo(0, 20);
                path.lineTo(0, 0);
                path.lineTo(20, 0);
                path.lineTo(20, 40);
                path.lineTo(40, 40);
                path.lineTo(40, 20);
                break;
            case 3:        //
                path.moveTo(20, 20);
                path.lineTo(10, 20);
                path.lineTo(0, 0);
                path.lineTo(20, 10);
                path.lineTo(20, 30);
                path.lineTo(40, 40);
                path.lineTo(30, 20);
                break;
            case 4:
                //
                path.moveTo(20, 20);
                path.lineTo(10, 20);
                path.lineTo(0, 0);
                path.lineTo(20, 10);
                path.lineTo(20, 40);
                path.lineTo(40, 40);
                path.lineTo(40, 20);
                break;
        }


        path.close();

//        path.addCircle(10, 30, 5, Path.Direction.CW);

        return path;
    }
}
