package com.tolea.pw_lab2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mainView;

    Button centerButton;
    Button hookKeyboardInputButton;

    TextView superText;

    ProgressDialog dialog = null;

    ListView colorList;
    ListView colorList2;
    SuperAdapter adapter;

    List<ColorObject> colors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < 50; i++) {
            ColorObject tempObject = new ColorObject();
            Random rnd = new Random();
            tempObject.setColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            tempObject.setName("Color #" + i);

            colors.add(tempObject);
        }

        mainView = (RelativeLayout) findViewById(R.id.mainView);

        centerButton = (Button) findViewById(R.id.centerButton);
        hookKeyboardInputButton = (Button) findViewById(R.id.hookKeyboardInputButton);

        superText = (TextView) findViewById(R.id.superText);

        colorList = (ListView) findViewById(R.id.colorList);
        colorList2 = (ListView) findViewById(R.id.colorList2);
        adapter = new SuperAdapter(this);

        adapter.setData(colors);
        colorList.setAdapter(adapter);
        colorList2.setAdapter(adapter);

        centerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MainActivity.this);
                builder.setMessage("Hey!")
                        .setTitle("Super Dialog Box")
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

        hookKeyboardInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
            }
        });

        colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                superText.setTextColor(colors.get(i).getColor());
            }
        });

        colorList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Random rnd = new Random();
                int option = rnd.nextInt(2);
                if(option == 0){
                    hookKeyboardInputButton.setBackgroundColor(colors.get(i).getColor());
                }
                else{
                    centerButton.setBackgroundColor(colors.get(i).getColor());
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.showAMessage:

                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MainActivity.this);
                builder.setMessage("Hey!")
                        .setTitle("Super Dialog Box")
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

                break;
            case R.id.deleteCenterButton:

                centerButton.setVisibility(View.GONE);

                break;
            case R.id.changeBackgroundColor:


                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                mainView.setBackgroundColor(color);

                break;
        }
        return true;
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_S:

                dialog = ProgressDialog.show(this, "", "S PRESSED");

                new java.util.Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                            }
                        });
                    }
                }, 1000);

                break;
            case KeyEvent.KEYCODE_R:

                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MainActivity.this);
                builder.setMessage("Hey!")
                        .setTitle("Super Secret Key Pressed")
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();

                break;
        }

        return true;
    }
}
