package com.tolea.pw_lab3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.tolea.pw_lab3.CustomViews.CircleDrawViewNormalLevel;
import com.tolea.pw_lab3.CustomViews.RectangleDrawViewNormalLevel;

public class NormalActivity extends AppCompatActivity {

    Button previousPartButton;
    Button nextPartButton;
    Button hookKeyboardButton;

    CircleDrawViewNormalLevel circle;
    RectangleDrawViewNormalLevel rectangle;

    public static RadialGradient gradient;
    public static RadialGradient gradient2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        previousPartButton = (Button) findViewById(R.id.previousPartButton);
        nextPartButton = (Button) findViewById(R.id.nextPartButton);
        hookKeyboardButton = (Button) findViewById(R.id.keyboardHookButton);

        circle = (CircleDrawViewNormalLevel) findViewById(R.id.circle);
        rectangle = (RectangleDrawViewNormalLevel) findViewById(R.id.rectangle);

        previousPartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(NormalActivity.this, MainActivity.class);
                startActivity(newIntent);
            }
        });

        nextPartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        hookKeyboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_C:
                gradient = new RadialGradient(0, 0, 200, Color.WHITE, Color.BLACK, Shader.TileMode.MIRROR);
                circle.invalidate();
                break;
            case KeyEvent.KEYCODE_R:
                gradient2 = new RadialGradient(0, 0, 200, 0xffff1c85, 0xff1ce4ff, Shader.TileMode.MIRROR);
                rectangle.invalidate();
                break;
        }
        return true;
    }
}
