package com.tolea.pw_lab3;

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
        path.moveTo(, y1);

        path.cubicTo(x1, y1, x2, y2, x3, y3);
        canvas.drawPath(path, paint);
    }

}
