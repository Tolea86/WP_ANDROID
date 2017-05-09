package com.tolea.pw_lab4;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.tolea.pw_lab4.CustomViews.CircleDrawView;
import com.tolea.pw_lab4.CustomViews.OvalDrawView;
import com.tolea.pw_lab4.CustomViews.RectangleDrawView;
import com.tolea.pw_lab4.CustomViews.SquareDrawView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button startAnimation;

    RelativeLayout clickableArea;

    CircleDrawView circle;
    CircleDrawView circle2;
    OvalDrawView oval;
    RectangleDrawView rectangle;
    SquareDrawView square;

    int width;
    int height;

    boolean clicked = false;

    int duration = 200;

    Timer t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circle = (CircleDrawView) findViewById(R.id.circle);
        circle2 = (CircleDrawView) findViewById(R.id.circle2);
        oval = (OvalDrawView) findViewById(R.id.oval);
        rectangle = (RectangleDrawView) findViewById(R.id.rectangle);
        square = (SquareDrawView) findViewById(R.id.square);

        startAnimation = (Button) findViewById(R.id.startButton);

        clickableArea = (RelativeLayout) findViewById(R.id.clickableArea);

        startAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();

                startAnimation.setVisibility(View.GONE);
                clickableArea.setVisibility(View.VISIBLE);
            }
        });

        clickableArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                duration += 100;
                t.cancel();
                t = new java.util.Timer();

                startAnimation();
            }
        });

        t = new java.util.Timer();

//        startAnimation();
    }

    private void startAnimation(){
        getSize();
        final Random r = new Random();

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0; i < 5; i++){
                            int i1 = r.nextInt(width - 300);
                            int i2 = r.nextInt(height - 300);

                            switch(i){
                                case 0:

                                    circle.animate().x(i1).setDuration(duration);
                                    circle.animate().y(i2).setDuration(duration);

                                    break;
                                case 1:

                                    circle2.animate().x(i1).setDuration(duration);
                                    circle2.animate().y(i2).setDuration(duration);

                                    break;
                                case 2:

                                    oval.animate().x(i1).setDuration(duration);
                                    oval.animate().y(i2).setDuration(duration);

                                    break;
                                case 3:

                                    rectangle.animate().x(i1).setDuration(duration);
                                    rectangle.animate().y(i2).setDuration(duration);

                                    break;
                                case 4:

                                    square.animate().x(i1).setDuration(duration);
                                    square.animate().y(i2).setDuration(duration);

                                    break;
                            }
                        }
                    }
                });

            }
        }, 0, duration + 50);


//        }
    }

    private void getSize(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
    }

    @Override
    public void onBackPressed() {
        t.cancel();

        startAnimation.setVisibility(View.VISIBLE);
    }
}
