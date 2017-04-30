package com.tolea.pw_lab3.CustomViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class BezierDrawView1 extends View {
    Paint paint = new Paint() {
        {
            setStyle(Paint.Style.STROKE);
            setStrokeCap(Paint.Cap.ROUND);
            setStrokeWidth(3.0f);
            setAntiAlias(true);
        }
    };

    final Path path = new Path();

    public BezierDrawView1(Context context) {
        super(context);
        paint.setColor(Color.CYAN);
        paint.setStrokeWidth(10);
    }

    public BezierDrawView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.CYAN);
        paint.setStrokeWidth(10);
    }

    public BezierDrawView1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint.setColor(Color.CYAN);
        paint.setStrokeWidth(10);
    }

    @Override
    public void onDraw(Canvas canvas) {
        path.moveTo(0, 0);

        path.cubicTo(100, 100, 300, 0, 200, 200);
        canvas.drawPath(path, paint);
    }

}
