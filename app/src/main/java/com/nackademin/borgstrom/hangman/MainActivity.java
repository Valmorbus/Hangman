package com.nackademin.borgstrom.hangman;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private int imageNo=0;
    private char[] svar ={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            InputStream imageStream = getAssets().open("Hangman-0.png");
            Drawable d = Drawable.createFromStream(imageStream, null);

            ImageView iv = (ImageView) findViewById(R.id.imageView);
            iv.setImageDrawable(d);

        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView tv = (TextView) findViewById(R.id.textView);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void wrongAnswer()    {
        if (imageNo == 6) {
            imageNo = 0;
        } else {
            imageNo++;
        }
        InputStream imageStream = null;
        try {
            imageStream = getAssets().open("Hangman-" + imageNo + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable d = Drawable.createFromStream(imageStream, null);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageDrawable(d);
    }
}
