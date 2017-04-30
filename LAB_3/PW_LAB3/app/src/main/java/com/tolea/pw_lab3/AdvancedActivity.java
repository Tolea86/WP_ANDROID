package com.tolea.pw_lab3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tolea.pw_lab3.CustomViews.DrawingView;

public class AdvancedActivity extends AppCompatActivity {

    Button brushButton;
    Button eraserButton;
    Button fiveSizeButton;
    Button tenSizeButton;
    Button fifthteenSizeButton;

    DrawingView drawingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

        brushButton = (Button) findViewById(R.id.brushButton);
        eraserButton = (Button) findViewById(R.id.eraserButton);
        fiveSizeButton = (Button) findViewById(R.id.fiveSizeButton);
        tenSizeButton = (Button) findViewById(R.id.tenSizeButton);
        fifthteenSizeButton = (Button) findViewById(R.id.fifthteenSizeButton);

        drawingView = (DrawingView) findViewById(R.id.drawingView);

        brushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.getPaint().setColor(0xff1cffba);
            }
        });

        eraserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.getPaint().setColor(Color.WHITE);
            }
        });

        fiveSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.setBrushSize(5);
            }
        });

        tenSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.setBrushSize(10);
            }
        });

        fifthteenSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawingView.setBrushSize(15);
            }
        });
    }
}
