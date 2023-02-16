package com.example.icycmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {


    ImageView imgQuestions;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    int[] questionsPics = {R.drawable.saddog, R.drawable.maddog, R.drawable.happydog, R.drawable.terrifieddog, R.drawable.exciteddog};

    String questions[] = {
            "This Dog is Sad!",
            "This Dog is Mad!",
            "This Dog is Happy!",
            "This Dog is Terrified",
            "This Dog is Excited",
    };
    String answers[] = {"Sad", "Mad", "Happy", "Terrified", "Excited"};
    String opt[] = {
            "Sad", "Tired", "Happy", "Angry",
            "Happy", "Surprised", "Mad", "Joyful",
            "Happy", "Angry", "Envious", "Weeping",
            "Crying", "Angry", "Excited", "Terrified",
            "Tired", "Angry", "Excited", "Sad",
    };
    int flag = 0;
    public static int marks = 0, correct = 0, wrong = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        final TextView score = (TextView) findViewById(R.id.textView4);
        Intent intent = getIntent();

        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);

        radio_g = (RadioGroup) findViewById(R.id.answersgrp);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
        imgQuestions = (ImageView) findViewById(R.id.imgQuestions);

        imgQuestions.setImageResource(questionsPics[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if (ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText("" + correct);

                if (flag < questions.length) {
                    imgQuestions.setImageResource(questionsPics[flag]);
                    rb1.setText(opt[flag * 4]);
                    rb2.setText(opt[flag * 4 + 1]);
                    rb3.setText(opt[flag * 4 + 2]);
                    rb4.setText(opt[flag * 4 + 3]);
                } else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), Result.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Result.class);
                startActivity(intent);
            }
        });

    }
}
