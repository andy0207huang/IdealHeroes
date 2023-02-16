package com.example.icycmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Result extends AppCompatActivity {
    TextView tv, tv2, tv3, question;
    Button btnRestart;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);
        question = (TextView) findViewById(R.id.qTextView);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append("Correct answers: " + Questions.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + Questions.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + Questions.correct + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);
        getQuestion();

        Questions.correct=0;
        Questions.wrong=0;

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }

    public void getQuestion(){
        String[] questionArray= new String[10];
        questionArray[0] = "How does empathy help us to be more inclusive?" ;
        questionArray[1] = "How did you show someone you understood what they were feeling?";
        questionArray[2] = "Can you think of a time when someone you know was showing emotion and you showed empathy towards them?";
        questionArray[3] = "How did you know the dog was feeling based on the situation?";
        questionArray[4] = "How do you help someone be less upset?";
        questionArray[5] = "What did you learn about teamwork from this game?";
        questionArray[6] = "After understanding someone's emotions, what else can you do?" ;


        int randNum = rand.nextInt(7);

        question.setText(questionArray[randNum]);

    }
}
