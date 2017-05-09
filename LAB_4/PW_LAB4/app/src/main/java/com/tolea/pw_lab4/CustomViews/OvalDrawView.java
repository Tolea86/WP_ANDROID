package com.tolea.pw_lab4.CustomViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class OvalDrawView extends View {
    Paint paint = new Paint();

    public OvalDrawView(Context context) {
        super(context);
        paint.setColor(Color.YELLOW);
    }

    public OvalDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.YELLOW);
    }

    public OvalDrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint.setColor(Color.YELLOW);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawOval(25, 25, 250, 150, paint);
    }

}
