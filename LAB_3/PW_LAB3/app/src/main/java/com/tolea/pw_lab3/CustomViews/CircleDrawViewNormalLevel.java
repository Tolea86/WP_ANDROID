package com.tolea.pw_lab3.CustomViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.tolea.pw_lab3.NormalActivity;

public class CircleDrawViewNormalLevel extends View {
    Paint paint = new Paint();
    public RadialGradient gradient = NormalActivity.gradient;

    public CircleDrawViewNormalLevel(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
        if(gradient != null)
        paint.setShader(gradient);
        paint.setStrokeWidth(10);
    }

    public CircleDrawViewNormalLevel(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.BLACK);
        if(gradient != null)
            paint.setShader(gradient);
        paint.setStrokeWidth(10);
    }

    public CircleDrawViewNormalLevel(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint.setColor(Color.BLACK);
        if(gradient != null)
            paint.setShader(gradient);
        paint.setStrokeWidth(10);
    }

    @Override
    public void onDraw(Canvas canvas) {

        RadialGradient gradient = NormalActivity.gradient;
        if(gradient != null)
            paint.setShader(gradient);
        canvas.drawCircle(200, 200, 100, paint);
    }

}
