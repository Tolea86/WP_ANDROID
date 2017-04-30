package com.tolea.pw_lab3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawView5 extends View {
    Paint paint = new Paint();

    public DrawView5(Context context) {
        super(context);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(15);
    }

    public DrawView5(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(15);
    }

    public DrawView5(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(15);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(200, 0, 000, 100, paint);
    }

}
