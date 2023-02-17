package com.isetR.devinette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper Mydb;
    ArrayList<String> player_id,devinette_title,score;
    public EditText saisir;
    public TextView nbr;
    public TextView tv_r;
    public TextView nbclicks;
    public TextView nbr2;
    public Button demarrer;
    public ImageButton verifier;
    public ImageButton suivant;
    public int a;

    public int number_of_clicks;
    private static final long START_TIME_IN_MILLIS=20000;
    public    CountDownTimer mCountDownTimer;
    public    Boolean mTimerRunning;
    public long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    public  int int1;
    public   int sc ;
    public static int sc1;
    public  String sc2;

    CustomAdapter CustomAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        nbr=(TextView) findViewById(R.id.nbr);
        tv_r=(TextView) findViewById(R.id.res);
        nbclicks=(TextView) findViewById(R.id.nbclicks);
        nbr2=(TextView) findViewById(R.id.nbr2);
        saisir=(EditText) findViewById(R.id.saisir);
        demarrer=(Button) findViewById(R.id.demarrer);
        verifier=(ImageButton) findViewById(R.id.verifier);
        suivant=(ImageButton) findViewById(R.id.suivant);
        Bundle extras=getIntent().getExtras();
        String p =extras.getString("Nom");





        demarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, p, Toast.LENGTH_SHORT).show();

                sc=0;
                int1=0;
                mTimeLeftInMillis=20000;
                nbr2.setText("");
                nbr.setText("");
                nbclicks.setText("");

           new CountDownTimer(100000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        updateCount();
                        mTimeLeftInMillis=100-(millisUntilFinished/1000) ;
                        String m =Long.toString(mTimeLeftInMillis);
                    int int1 = Integer.parseInt(m)-number_of_clicks;
                    sc=100-(int1);

                    nbclicks.setText("" + (100-mTimeLeftInMillis)+"s");




                    }
               public void updateCount() {



               }

                    public void onFinish() {

                        nbr.setText("Vous Avez Perdu");
                        nbr.setTextColor(Color.RED);
                    }
                }.start();

                SecureRandom r =new SecureRandom();
                int rs = r.nextInt(100);

                a = rs;
                Toast.makeText(MainActivity.this, ""+a, Toast.LENGTH_SHORT).show();
                number_of_clicks=0;

            }
        });
        verifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_of_clicks++;

                String b =  saisir.getText().toString();
                int number = Integer.parseInt(b);
                if(number<a){
                    nbr.setText("Plus QUE "+number);
                    nbr.setTextColor(Color.BLACK);

                }else if(number>a){
                    nbr.setText("Moins QUE "+ number);
                    nbr.setTextColor(Color.BLACK);
                    }


               else{
                    sc1=sc;
                    sc2=String.valueOf(sc1);

                    // tv_r.setText(sc1);
                    nbr2.setText("score : "+sc1);


                    nbr.setText("Vous Avez Gagné");
                    nbr.setTextColor(Color.GREEN);



                }


                }
        });
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.addScore(p.trim(),

                       sc2.trim());
                Intent intent = new Intent(MainActivity.this,recyclerv.class);
                startActivity(intent);


            }

        });

    }

    void storeDataInArrays(){
        Cursor cursor = Mydb.readAllData();
        if(cursor.getCount() == 0){

        }else{
            while (cursor.moveToNext()){

                devinette_title.add(cursor.getString(1));
                score.add(cursor.getString(2));

            }

        }
    }

    private void startTimer(){

    }
    private void pauseTimer(){
        mCountDownTimer.cancel();
    }
    private void resetTimer(){};


}
