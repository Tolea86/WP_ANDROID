package com.tolea.pw_lab4;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.tolea.pw_lab4.CustomViews.CircleDrawView;
import com.tolea.pw_lab4.CustomViews.OvalDrawView;
import com.tolea.pw_lab4.CustomViews.RectangleDrawView;
import com.tolea.pw_lab4.CustomViews.SquareDrawView;

import java.util.Random;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button startAnimation;

    CircleDrawView circle;
    CircleDrawView circle2;
    OvalDrawView oval;
    RectangleDrawView rectangle;
    SquareDrawView square;

    int width;
    int height;

    boolean clicked = false;

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

        startAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();

                startAnimation.setVisibility(View.GONE);
            }
        });

//        startAnimation();
    }

    private void startAnimation(){
        getSize();
        final Random r = new Random();

        new java.util.Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    int i1 = r.nextInt(width - 300);
                    int i2 = r.nextInt(height - 300);

                    switch(i){
                        case 0:

                            circle.animate().x(i1).setDuration(200);
                            circle.animate().y(i2).setDuration(200);

                            break;
                        case 1:

                            circle2.animate().x(i1).setDuration(200);
                            circle2.animate().y(i2).setDuration(200);

                            break;
                        case 2:

                            oval.animate().x(i1).setDuration(200);
                            oval.animate().y(i2).setDuration(200);

                            break;
                        case 3:

                            rectangle.animate().x(i1).setDuration(200);
                            rectangle.animate().y(i2).setDuration(200);

                            break;
                        case 4:

                            square.animate().x(i1).setDuration(200);
                            square.animate().y(i2).setDuration(200);

                            break;
                    }
                }
            }
        }, 0, 350);


//        }
    }

    private void getSize(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
    }
}
