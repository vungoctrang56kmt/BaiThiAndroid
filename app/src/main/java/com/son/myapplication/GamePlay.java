package com.son.myapplication;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GamePlay extends Activity {
    AlertDialog.Builder adb;
    SQLiteDatabase db;
    TextView name,levelText,jumbleWord,points,attemptsLeft,Star;
    EditText answerText;
    Button b;
    Intent i;
    String n,lv,s="";
    ArrayList<String> quesWord=new ArrayList<String>();
    int score=0;
    int chances=0;
    int star=0;
    Cursor c;
    private MediaPlayer gametheme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        jumbleWord=(TextView) findViewById(R.id.jumbled);
        attemptsLeft=(TextView) findViewById(R.id.attemp);
        answerText=(EditText) findViewById(R.id.ans);
        levelText=(TextView) findViewById(R.id.lvdisp);
        points=(TextView) findViewById(R.id.score);
        Star=(TextView) findViewById(R.id.star);
        name=(TextView) findViewById(R.id.name);
        b=(Button) findViewById(R.id.match);
        i=getIntent();
        n=i.getStringExtra("name");
        name.setText("Player: "+n);
        lv=i.getStringExtra("level");
        levelText.setText("Level: "+lv);
        createTable();
        insertIntoBeginner();
        insertIntoIntermediate();
        insertIntoExpert();
        fetchWords();
        adb= new AlertDialog.Builder(this);
        gametheme = MediaPlayer.create(this, R.raw.theme);
        gametheme.start();
        gametheme.setLooping(true);
    }


    public void createTable(){
        db=openOrCreateDatabase("com.correctword",MODE_PRIVATE ,null);
        try
        {
            db.execSQL("create table if not exists correctword(word varchar(7) primary key not null,level varchar(15))");
        }
        catch(Exception e){

        }
    }
    public void insertIntoBeginner()
    {
        try
        {
            db.execSQL("insert into correctword values('above','Beginner')");
            db.execSQL("insert into correctword values('alert','Beginner')");
            db.execSQL("insert into correctword values('bench','Beginner')");
            db.execSQL("insert into correctword values('blood','Beginner')");
           /* db.execSQL("insert into correctword values('chart','Beginner')");
            db.execSQL("insert into correctword values('class','Beginner')");
            db.execSQL("insert into correctword values('daily','Beginner')");
            db.execSQL("insert into correctword values('death','Beginner')");
            db.execSQL("insert into correctword values('entry','Beginner')");
            db.execSQL("insert into correctword values('extra','Beginner')");
            db.execSQL("insert into correctword values('flood','Beginner')");
            db.execSQL("insert into correctword values('force','Beginner')");
            db.execSQL("insert into correctword values('globe','Beginner')");
            db.execSQL("insert into correctword values('guard','Beginner')");
            db.execSQL("insert into correctword values('house','Beginner')");
            db.execSQL("insert into correctword values('heavy','Beginner')");
            db.execSQL("insert into correctword values('index','Beginner')");
            db.execSQL("insert into correctword values('image','Beginner')");
            db.execSQL("insert into correctword values('joint','Beginner')");
            db.execSQL("insert into correctword values('laser','Beginner')");
            db.execSQL("insert into correctword values('learn','Beginner')");
            db.execSQL("insert into correctword values('local','Beginner')");
            db.execSQL("insert into correctword values('month','Beginner')");
            db.execSQL("insert into correctword values('minor','Beginner')");
            db.execSQL("insert into correctword values('mouse','Beginner')");
            db.execSQL("insert into correctword values('never','Beginner')");
            db.execSQL("insert into correctword values('noise','Beginner')");
            db.execSQL("insert into correctword values('north','Beginner')");
            db.execSQL("insert into correctword values('offer','Beginner')");
            db.execSQL("insert into correctword values('order','Beginner')");
            db.execSQL("insert into correctword values('paint','Beginner')");
            db.execSQL("insert into correctword values('paper','Beginner')");
            db.execSQL("insert into correctword values('raise','Beginner')");
            db.execSQL("insert into correctword values('right','Beginner')");
            db.execSQL("insert into correctword values('sense','Beginner')");
            db.execSQL("insert into correctword values('sharp','Beginner')");
            db.execSQL("insert into correctword values('sleep','Beginner')");
            db.execSQL("insert into correctword values('solve','Beginner')");
            db.execSQL("insert into correctword values('table','Beginner')");
            db.execSQL("insert into correctword values('tight','Beginner')");
            db.execSQL("insert into correctword values('throw','Beginner')");
            db.execSQL("insert into correctword values('today','Beginner')");
            db.execSQL("insert into correctword values('upper','Beginner')");
            db.execSQL("insert into correctword values('upset','Beginner')");
            db.execSQL("insert into correctword values('value','Beginner')");
            db.execSQL("insert into correctword values('valid','Beginner')");
            db.execSQL("insert into correctword values('waste','Beginner')");
            db.execSQL("insert into correctword values('while','Beginner')");
            db.execSQL("insert into correctword values('youth','Beginner')");
            db.execSQL("insert into correctword values('young','Beginner')"); */
        }
        catch(Exception e){

        }
    }
    public void insertIntoIntermediate()
    {
        try
        {
            db.execSQL("insert into correctword values('big','Intermediate')");
            db.execSQL("insert into correctword values('blue','Intermediate')");
            db.execSQL("insert into correctword values('black','Intermediate')");
            db.execSQL("insert into correctword values('bone','Intermediate')");
           /* db.execSQL("insert into correctword  values('carbon','Intermediate')");
            db.execSQL("insert into correctword values('career','Intermediate')");
            db.execSQL("insert into correctword values('degree','Intermediate')");
            db.execSQL("insert into correctword values('design','Intermediate')");
            db.execSQL("insert into correctword values('effort','Intermediate')");
            db.execSQL("insert into correctword values('engine','Intermediate')");
            db.execSQL("insert into correctword values('factor','Intermediate')");
            db.execSQL("insert into correctword values('famous','Intermediate')");
            db.execSQL("insert into correctword values('future','Intermediate')");
            db.execSQL("insert into correctword values('garden','Intermediate')");
            db.execSQL("insert into correctword values('gender','Intermediate')");
            db.execSQL("insert into correctword values('global','Intermediate')");
            db.execSQL("insert into correctword values('hardly','Intermediate')");
            db.execSQL("insert into correctword values('height','Intermediate')");
            db.execSQL("insert into correctword values('holder','Intermediate')");
            db.execSQL("insert into correctword values('hidden','Intermediate')");
            db.execSQL("insert into correctword values('hockey','Intermediate')");
            db.execSQL("insert into correctword values('injury','Intermediate')");
            db.execSQL("insert into correctword values('island','Intermediate')");
            db.execSQL("insert into correctword values('junior','Intermediate')");
            db.execSQL("insert into correctword values('jungle','Intermediate')");
            db.execSQL("insert into correctword values('killer','Intermediate')");
            db.execSQL("insert into correctword values('kidney','Intermediate')");
            db.execSQL("insert into correctword values('letter','Intermediate')");
            db.execSQL("insert into correctword values('launch','Intermediate')");
            db.execSQL("insert into correctword values('lesson','Intermediate')");
            db.execSQL("insert into correctword values('liquid','Intermediate')");
            db.execSQL("insert into correctword values('little','Intermediate')");
            db.execSQL("insert into correctword values('living','Intermediate')");
            db.execSQL("insert into correctword values('manage','Intermediate')");
            db.execSQL("insert into correctword values('manner','Intermediate')");
            db.execSQL("insert into correctword values('method','Intermediate')");
            db.execSQL("insert into correctword values('native','Intermediate')");
            db.execSQL("insert into correctword values('notice','Intermediate')");
            db.execSQL("insert into correctword values('office','Intermediate')");
            db.execSQL("insert into correctword values('patent','Intermediate')");
            db.execSQL("insert into correctword values('random','Intermediate')");
            db.execSQL("insert into correctword values('rating','Intermediate')");
            db.execSQL("insert into correctword values('remove','Intermediate')");
            db.execSQL("insert into correctword values('screen','Intermediate')");
            db.execSQL("insert into correctword values('secure','Intermediate')");
            db.execSQL("insert into correctword values('theory','Intermediate')");
            db.execSQL("insert into correctword values('unique','Intermediate')");
            db.execSQL("insert into correctword values('vision','Intermediate')");
            db.execSQL("insert into correctword values('winter','Intermediate')");
            db.execSQL("insert into correctword values('yellow','Intermediate')"); */
        }
        catch(Exception e){

        }
    }
    public void insertIntoExpert(){
        try{
            db.execSQL("insert into correctword values('account','Expert')");
            db.execSQL("insert into correctword values('acquire','Expert')");
            db.execSQL("insert into correctword values('bedroom','Expert')");
            db.execSQL("insert into correctword values('benefit','Expert')");
            /*db.execSQL("insert into correctword values('century','Expert')");
            db.execSQL("insert into correctword values('captain','Expert')");
            db.execSQL("insert into correctword values('decline','Expert')");
            db.execSQL("insert into correctword values('develop','Expert')");
            db.execSQL("insert into correctword values('economy','Expert')");
            db.execSQL("insert into correctword values('example','Expert')");
            db.execSQL("insert into correctword values('faculty','Expert')");
            db.execSQL("insert into correctword values('fiction','Expert')");
            db.execSQL("insert into correctword values('gallery','Expert')");
            db.execSQL("insert into correctword values('genuine','Expert')");
            db.execSQL("insert into correctword values('healthy','Expert')");
            db.execSQL("insert into correctword values('hundred','Expert')");
            db.execSQL("insert into correctword values('imagine','Expert')");
            db.execSQL("insert into correctword values('improve','Expert')");
            db.execSQL("insert into correctword values('journal','Expert')");
            db.execSQL("insert into correctword values('justice','Expert')");
            db.execSQL("insert into correctword values('kitchen','Expert')");
            db.execSQL("insert into correctword values('kingdom','Expert')");
            db.execSQL("insert into correctword values('leisure','Expert')");
            db.execSQL("insert into correctword values('logical','Expert')");
            db.execSQL("insert into correctword values('machine','Expert')");
            db.execSQL("insert into correctword values('mineral','Expert')");
            db.execSQL("insert into correctword values('nuclear','Expert')");
            db.execSQL("insert into correctword values('nervous','Expert')");
            db.execSQL("insert into correctword values('officer','Expert')");
            db.execSQL("insert into correctword values('outside','Expert')");
            db.execSQL("insert into correctword values('partial','Expert')");
            db.execSQL("insert into correctword values('passive','Expert')");
            db.execSQL("insert into correctword values('quality','Expert')");
            db.execSQL("insert into correctword values('quarter','Expert')");
            db.execSQL("insert into correctword values('receive','Expert')");
            db.execSQL("insert into correctword values('replace','Expert')");
            db.execSQL("insert into correctword values('science','Expert')");
            db.execSQL("insert into correctword values('session','Expert')");
            db.execSQL("insert into correctword values('teacher','Expert')");
            db.execSQL("insert into correctword values('trouble','Expert')");
            db.execSQL("insert into correctword values('upgrade','Expert')");
            db.execSQL("insert into correctword values('utility','Expert')");
            db.execSQL("insert into correctword values('vehicle','Expert')");
            db.execSQL("insert into correctword values('veteran','Expert')");
            db.execSQL("insert into correctword values('welcome','Expert')");
            db.execSQL("insert into correctword values('western','Expert')");
            db.execSQL("insert into correctword values('undress','Expert')");
            db.execSQL("insert into correctword values('venture','Expert')");
            db.execSQL("insert into correctword values('visible','Expert')");
            db.execSQL("insert into correctword values('yoghurt','Expert')");*/
        }

        catch(Exception e){

        }
    }


    public static String wordJumble(String word )
    {
        Random random = new Random();
        char wordArray[] = word.toCharArray();
        for(int i=0 ; i< wordArray.length-1 ; i++ )
        {
            int j = random.nextInt(wordArray.length-1);
            char temp = wordArray[i];
            wordArray[i] = wordArray[j];
            wordArray[j] = temp;
        }
        if(wordArray.toString().equals(word)){
            wordJumble(word);
        }
        return new String(wordArray);
    }


    public void fetchWords(){
        try{
            c=db.rawQuery("select * from correctword where level='"+lv+"'",null);
            while(c.moveToNext()){
                s=c.getString(0);
                quesWord.add(s);
            }
            Collections.shuffle(quesWord);
        }
        catch(Exception e){

        }
    }

    @Override
    protected void onResume() {
        MediaPlayer win = MediaPlayer.create(this, R.raw.win);
        MediaPlayer lose = MediaPlayer.create(this, R.raw.lose);
        MediaPlayer right = MediaPlayer.create(this, R.raw.right);
        MediaPlayer wrong = MediaPlayer.create(this, R.raw.wrong);

        super.onResume();
        final String [] str=quesWord.toArray(new String[quesWord.size()]);
        attemptsLeft.setText("Wrong: "+chances);
        points.setText("Correct: "+score);
        Star.setText("Star: "+star);
        jumbleWord.setText(wordJumble(str[0]));
        b.setOnClickListener(new OnClickListener() {
            int j=0;
            int len=str.length;

            @Override
            public void onClick(View v) {
                try{
                    if(answerText.getText().toString().trim().equalsIgnoreCase(str[j])){
                        score++;
                        if(score%3==0){
                            star++;
                        }
                        if(score==len){
                            gametheme.stop();
                            win.start();
                            adb.setTitle("You Won!");
                            adb.setMessage("Star: "+star+"\n"+"Score: "+score);

                            adb.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            adb.show();
                        }
                        j++;
                        right.start();
                        points.setText("Correct: "+score);
                        Star.setText("Star: "+star);
                        jumbleWord.setText((wordJumble(str[j])));
                        answerText.setText("");
                    }
                    else{
                        chances++;
                        if(chances%3==0){
                            star--;
                        }
                        Star.setText("Star: "+star);
                        wrong.start();
                        Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();

                        if(star<0){
                            gametheme.stop();
                            lose.start();
                            adb.setTitle("You Lose!");
                            adb.setMessage("Star: "+star+"\n"+"Wrong:"+chances);
                            adb.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            adb.show();
                        }
                        attemptsLeft.setText("Wrong: "+chances);
                        answerText.setText("");

                    }
                }catch(Exception e){

                }
            }
        });
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