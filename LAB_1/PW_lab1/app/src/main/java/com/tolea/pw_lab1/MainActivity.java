package com.tolea.pw_lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mainView;

    TextView textCenter;

    String middleText = "Done with Pride and Prejudice by Iuzvac Anatolie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainView = (RelativeLayout) findViewById(R.id.activityMainView);

        createMiddleText();
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
}
