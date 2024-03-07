package com.son.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
public class LevelSelect extends Activity {
    AlertDialog.Builder adb;
    RadioButton radio1,radio2,radio3;
    Intent intent,lvl1,lvl2,lvl3;
    String name;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        tv=(TextView) findViewById(R.id.greetings);
        radio1=(RadioButton) findViewById(R.id.radio1);
        radio2=(RadioButton) findViewById(R.id.radio2);
        radio3=(RadioButton) findViewById(R.id.radio3);
        adb = new AlertDialog.Builder(this);
        intent=getIntent();
        name=intent.getStringExtra("name");
        tv.setText("Welcome "+name);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

public void beginner(View v)
    {
        Toast.makeText(LevelSelect.this,radio1.getText().toString()+" level", Toast.LENGTH_SHORT).show();
        lvl1=new Intent("com.correctword.beginner");
        lvl1.putExtra("name",name);
        lvl1.putExtra("level","Beginner");
        startActivity(lvl1);
    }


    public void intermediate(View v)
    {
        Toast.makeText(LevelSelect.this,radio2.getText().toString()+" level", Toast.LENGTH_SHORT).show();
        lvl2=new Intent("com.correctword.intermediate");
        lvl2.putExtra("name",name);
        lvl2.putExtra("level","Intermediate");
        startActivity(lvl2);
    }


    public void expert(View v)
    {
        Toast.makeText(LevelSelect.this,radio3.getText().toString()+" level", Toast.LENGTH_SHORT).show();
        lvl3=new Intent("com.correctword.expert");
        lvl3.putExtra("name",name);
        lvl3.putExtra("level","Expert");
        startActivity(lvl3);
    }
    public void back(View v)
    {
        adb.setTitle("Go Back?");
        adb.setMessage("Are you sure you want to go back?");
        adb.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        adb.setPositiveButton("No", null);
        adb.show();
    }
}