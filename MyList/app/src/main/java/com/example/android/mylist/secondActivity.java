package com.example.android.mylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by sures on 25-06-2017.
 */

public class secondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent2 = getIntent();
        String message = intent2.getStringExtra(MainActivity.ItemName);

        TextView newText = (TextView) findViewById(R.id.new_text);
        newText.setText(message);
    }

}
