package com.tolea.pw_lab4.CustomViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class RectangleDrawView extends View {
    Paint paint = new Paint();

    public RectangleDrawView(Context context) {
        super(context);
        paint.setColor(Color.BLUE);
    }

    public RectangleDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLUE);
    }

    public RectangleDrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint.setColor(Color.BLUE);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(50, 50, 200, 150, paint);
    }

}
