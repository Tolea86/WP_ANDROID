package com.tolea.pw_lab1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mainView;

    TextView textCenter;

    Button button1;
    Button button2;

    TextView text1;
    TextView text2;

    String middleText = "Done with Pride and Prejudice by Iuzvac Anatolie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainView = (RelativeLayout) findViewById(R.id.activityMainView);

        createMiddleText();

        createTwoButtons();

        createTwoTextViews();
    }

    private void createMiddleText(){
        textCenter = new TextView(this);

        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams
                ((int)RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.TEXT_ALIGNMENT_GRAVITY, RelativeLayout.TEXT_ALIGNMENT_CENTER);

        textCenter.setText(middleText);
        textCenter.setTextSize((float) 14);
        textCenter.setLayoutParams(params);

        mainView.addView(textCenter);
    }

    private void createTwoButtons(){
        button1 = new Button(this);

        button1.setText("BUTTON1");

        mainView.addView(button1);

        button2 = new Button(this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                (dpToPx(this, 150), dpToPx(this, 75));

        params.topMargin = dpToPx(this, 50);

        button2.setBackgroundColor(0xff42f48c);
        button2.setTextColor(0xfff44141);
        button2.setTextSize(20);
        button2.setLayoutParams(params);
        button2.setText("BUTTON2");

        mainView.addView(button2);

    }

    private void createTwoTextViews(){
        text1 = new TextView(this);

        text1.setText("TEXT1");

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                (int)RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);

        params.leftMargin = dpToPx(this, 250);
        params.topMargin = dpToPx(this, 12);

        text1.setLayoutParams(params);

        mainView.addView(text1);

        text2 = new TextView(this);

        text2.setText("TEXT2");

        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
                (int)RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);

        params2.leftMargin = dpToPx(this, 250);
        params2.topMargin = dpToPx(this, 75);

        text2.setTextSize(18);
        text2.setTextColor(0xffffffff);
        text2.setBackgroundColor(0xff000000);
        text2.setLayoutParams(params2);

        mainView.addView(text2);

    }

    public static int dpToPx(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics));
    }

}
