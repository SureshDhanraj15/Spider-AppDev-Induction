package com.example.android.mylist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String ItemName = "com.example.android.mylist.MESSAGE";

    Context context = this;
    private ArrayList<String> itemArray;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list = (ListView) findViewById(R.id.item_list);

        String[] items ={};

        itemArray = new ArrayList<>(Arrays.asList(items));
        listAdapter = new ArrayAdapter<String>(context,R.layout.single_item,R.id.item_text,itemArray);
        list.setAdapter(listAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, secondActivity.class);
                intent.putExtra(ItemName,list.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }

    public void addItem (View v){

        LayoutInflater li = this.getLayoutInflater();
        View addView = li.inflate(R.layout.add_dialogbox,null);

        AlertDialog.Builder addDialogBuilder = new AlertDialog.Builder(this);
        addDialogBuilder.setView(addView);

        final EditText userInput = (EditText) addView.findViewById(R.id.add_editBox);

        addDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String newItem = userInput.getText().toString();

                        if(!newItem.isEmpty()){
                            itemArray.add(newItem);
                            listAdapter.notifyDataSetChanged();
                        }
                        else {
                            Toast.makeText(context, "Data not entered", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog addDialog = addDialogBuilder.create();
        addDialog.show();
    }

    public void removeItem(View v){

        LayoutInflater li2 = this.getLayoutInflater();
        View removeView = li2.inflate(R.layout.remove_dialogbox,null);

        AlertDialog.Builder removeDialogBuilder = new AlertDialog.Builder(this);
        removeDialogBuilder.setView(removeView);

        final EditText itemPosition = (EditText) removeView.findViewById(R.id.remove_editBox);

        removeDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String s = itemPosition.getText().toString();

                        if(!s.isEmpty()){
                            int pos = Integer.parseInt(s);
                            int n = itemArray.size();
                            if(pos<=n){
                                itemArray.remove(pos-1);
                                listAdapter.notifyDataSetChanged();
                            }
                            else
                                Toast.makeText(context,"No item at specified position",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(context, "Data not entered", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog removeDialog = removeDialogBuilder.create();
        removeDialog.show();
    }


}
