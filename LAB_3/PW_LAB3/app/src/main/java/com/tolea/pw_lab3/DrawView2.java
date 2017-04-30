package com.tolea.pw_lab3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawView2 extends View {
    Paint paint = new Paint();

    public DrawView2(Context context) {
        super(context);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
    }

    public DrawView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
    }

    public DrawView2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(0, 200, 200, 0, paint);
    }

}
