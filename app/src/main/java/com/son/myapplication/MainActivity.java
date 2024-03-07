package com.son.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText et;
    String string;
    Intent intent;
    Button quit;
    private MediaPlayer theme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quit = findViewById(R.id.quit);
        et= findViewById(R.id.editText1);
        theme = MediaPlayer.create(this, R.raw.birdfish);
        theme.start();
        // Đặt thời gian chờ là 8 giây
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Dừng phát nhạc sau 8 giây
                theme.stop();
            }
        }, 8000); // thời gian chờ là 8 giây (8000 mili giây)
    }

    public void moveToNextActivity(View v){
        intent=new Intent("com.correctword.levelselect");
        string=et.getText().toString();
        if(string.equals(""))
        {
            Toast.makeText(MainActivity.this,"Please enter your Name", Toast.LENGTH_LONG).show();
            et.setText("");
        }
        else{
            intent.putExtra("name",et.getText().toString());
            startActivity(intent);
        }
    }
    public void quit(View view)
    {

        this.onBackPressed();
    }

}