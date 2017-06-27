package com.example.android.counter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i=0;
    TextView countText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countText  = (TextView) findViewById(R.id.count);

    }

    public void increment (View v){
        i++;
        countText.setText(i+"");
    }

    public void decrement (View v){
        i--;
        countText.setText(i+"");
    }

    public void reset (View v){
        i=0;
        countText.setText(i+"");
    }
}
