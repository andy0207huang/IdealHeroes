package com.example.icycmain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class SuccessScreen extends AppCompatActivity {
    private Button button;
    private TextView question;

    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_screen);

        question = (TextView) findViewById(R.id.qTextView) ;
        getQuestion();
        button = (Button) findViewById(R.id.mainButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

    }

    public void openMainActivity(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void getQuestion(){
        String[] questionArray= new String[10];
        questionArray[0] = "How did player 1 and 2 different ideas make the image more interesting?" ;
        questionArray[1] = "What was the hardest part of the activity?" ;
        questionArray[2] = "How did you attempt to overcome difficulties in the game?";
        questionArray[3] = "What would you do differently?";
        questionArray[4] = "How can you use teamwork in other situations?";
        questionArray[5] = "What did you learn about teamwork from this game?";
        questionArray[6] = "How did you improve on your teamwork for the second drawing?";


        int randNum = rand.nextInt(7);

        question.setText(questionArray[randNum]);

    }

}
