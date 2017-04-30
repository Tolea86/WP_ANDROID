package com.tolea.pw_lab3.CustomViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.util.AttributeSet;
import android.view.View;

import com.tolea.pw_lab3.NormalActivity;

public class RectangleDrawViewNormalLevel extends View {
    Paint paint = new Paint();

    public RectangleDrawViewNormalLevel(Context context) {
        super(context);
        paint.setColor(Color.BLUE);
    }

    public RectangleDrawViewNormalLevel(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLUE);
    }

    public RectangleDrawViewNormalLevel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint.setColor(Color.BLUE);
    }

    @Override
    public void onDraw(Canvas canvas) {
        RadialGradient gradient = NormalActivity.gradient2;
        if(gradient != null)
            paint.setShader(gradient);
        canvas.drawRect(0, 0, 400, 400, paint);
    }

}
