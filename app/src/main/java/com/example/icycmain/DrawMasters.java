package com.example.icycmain;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;
import java.util.regex.PatternSyntaxException;

import androidx.appcompat.app.AppCompatActivity;

public class DrawMasters extends AppCompatActivity {

    Random rand = new Random();
    private int checkInt;
    private int count = 0;
    private int count2 = 0;
    boolean bool = true;
    boolean bool2 = false;
    String inStr, corrAns;

    private EditText inAns;
    private Button button;
    private TextView text1, cdTimer, countText;

    appCanvas canvas1, canvas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_masters);

        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button) findViewById(R.id.button2);
        button.setText("Submit");

        text1 = (TextView) findViewById(R.id.myText1);
        countText = (TextView) findViewById(R.id.countText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                countText.setText(Integer.toString(count));
                if (count == 1) {
                    mCountDownTimer.cancel();
                }
                inAns = (EditText) findViewById(R.id.answerIn);
                inStr = inAns.getText().toString().toLowerCase();
                inAns.getText().clear();
                if(inStr.equals(corrAns)) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    count++;
                    bool = false;
                    if (count2 == 0) {
                        button.setText("Next");
                        cdTimer.setText("");
                        text1.setText("Click Next to continue...");


                    }
                    checkInt = count + 1;
                    if (count2 > 0){
                        bool2 = true;
                    }
                }
                else if (bool){
                    Toast.makeText(getApplicationContext(), "Try again!", Toast.LENGTH_SHORT).show();
                }
                if(!bool && count == checkInt) {
                    button.setText("Submit");
                    getTopic();
                    countText.setText(Integer.toString(count));
                    m2CountDownTimer.start();
                    bool = true;
                    count2++;
                }
                else if(bool2){

                    openSuccessScreenActivity();
                }
            }
        });

        canvas1 = new appCanvas(this, null);

        getTopic();

        cdTimer = (TextView) findViewById(R.id.timerText);



        countText.setText(Integer.toString(count));

        //Start Timer
        mCountDownTimer.start();


    }

    public void openMainActivity(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openSuccessScreenActivity(){

        Intent intent = new Intent(this, SuccessScreen.class);
        startActivity(intent);
    }

    //Gets the game drawing topic
    public void getTopic(){
        String[] topicArray= new String[10];
        topicArray[0] = "Draw a Tree" ;
        topicArray[1] = "Draw a Car" ;
        topicArray[2] = "Draw a Fish";
        topicArray[3] = "Draw a Computer";
        topicArray[4] = "Draw a flower";
        topicArray[5] = "Draw a Snowman";
        topicArray[6] = "Draw a Football";
        topicArray[7] = "Draw a Boat";
        topicArray[8] = "Draw a farmhouse";
        topicArray[9] = "Draw a Bear";

        int randNum = rand.nextInt(10);

        text1.setText(topicArray[randNum]);

        try {
            String[] splitArray = topicArray[randNum].split("\\s+");
            corrAns = splitArray[2];
        } catch (PatternSyntaxException ex) {
            //
        }

        corrAns = corrAns.toLowerCase();


    }

    CountDownTimer mCountDownTimer = new CountDownTimer(45 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            //this will be called every second.

            //real time
            long t0 = millisUntilFinished/1000;
            //time used for player 1
            long t1 = millisUntilFinished/1000 - 29;
            //time used to player 2
            long t2 =millisUntilFinished/1000 - 12;
            //t0 string
            String cdRealTime  = Long.toString(millisUntilFinished/1000);
            //t1 string
            String cdTime = Long.toString(t1);

            String cdTime2 = Long.toString(t2);
            //"cases"; for printing instructions and timer
            if (t0 > 42){
                cdTimer.setText("Player 1");
            }
            else if (t0 > 40){
                cdTimer.setText("Ready...");
            }
            else if (t0 == 40){
                cdTimer.setText("Go!");
            }
            else if (t1 > -1) {
                cdTimer.setText(cdTime);
            }
            else if( t1 == -1){
                cdTimer.setText("Player 2:");
            }
            else if (t1 == -4){
                cdTimer.setText("Ready...");
            }
            else if (t1 == -6){
                cdTimer.setText("Go!");
            }
            else if(t1 < -6 && t1 > -18){
                cdTimer.setText(cdTime2);
            }
            else if (t1 == -18){
                text1.setText("Player 3: ");
                cdTimer.setText("Guess!");
            }
            else if(t1 < -18){
                cdTimer.setText(cdRealTime);
            }


        }

        @Override
        public void onFinish() {
            //once timer completes



        }
    };

    CountDownTimer m2CountDownTimer = new CountDownTimer(33 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            //this will be called every second.

            //real time
            long t0 = millisUntilFinished/1000;
            //time used for player 1
            long t1 = millisUntilFinished/1000 - 17;
            //t0 string
            String cdRealTime  = Long.toString(millisUntilFinished/1000);
            //t1 string
            String cdTime = Long.toString(t1);
            //"cases"; for printing instructions and timer
            if (t0 > 30){
                cdTimer.setText("Player 1");
                countText.setText(Integer.toString(count));
            }
            else if (t0 > 28){
                cdTimer.setText("Ready...");
            }
            else if (t0 == 28){
                cdTimer.setText("Go!");
            }
            else if (t1 > -1) {
                cdTimer.setText(cdTime);
            }
            else if( t1 == -1){
                cdTimer.setText("Player 2:");
            }
            else if (t1 == -4){
                cdTimer.setText("Ready...");
            }
            else if (t1 == -6){
                cdTimer.setText("Go!");
            }
            else if(t1 < -6){
                cdTimer.setText(cdRealTime);
            }


        }

        @Override
        public void onFinish() {
            //once timer completes
            cdTimer.setText("Guess!");
            text1.setText("Player 3: ");



        }
    };



 /*   @Override
    public boolean anOptionItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    }*/
}
