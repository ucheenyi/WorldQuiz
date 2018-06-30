package com.example.android.worldquiz;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Correct answer for Question 1
    RadioButton question1_option2;
    // Correct answer for Question 2
    EditText question2_answer;
    // Correct answer for Question 3
    CheckBox question3_option1;
    CheckBox question2_option2;
    CheckBox question3_option3;
    CheckBox question3_option4;
    // Correct answer for Question 4
    EditText question4_answer;
    // Correct answer for Question 5
    RadioButton question5_option1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }


    public void submitAnswers(View view) {
        CharSequence displayResult;
        Log.e(LOG_TAG, " " + this.findViewById(R.id.question3_option3));
      //Scores for answers
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int total_score;

        //Correct answer for Question 1 is USA
        Boolean answer1;

        question1_option2 = (RadioButton) this.findViewById(R.id.question1_option2);
        answer1 = question1_option2.isChecked();
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }

        //Correct answer for Question 2 is Russia
        String answer2;
        question2_answer = (EditText) this.findViewById(R.id.question2_answer);
        answer2 = question2_answer.getText().toString().toLowerCase();
        if (answer2.equals("russia")) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }

        //Correct answers for Question 3 are Nigeria and Senegal
        Boolean answer3_option1;
        Boolean answer3_option2;
        Boolean answer3_option3;
        Boolean answer3_option4;
        question3_option1 = (CheckBox) this.findViewById(R.id.question3_option1);
        question2_option2 = (CheckBox) this.findViewById(R.id.question3_option2);
        question3_option3 = (CheckBox) this.findViewById(R.id.question3_option3);
        question3_option4 = (CheckBox) this.findViewById(R.id.question3_option4);
        answer3_option1 = question3_option1.isChecked();
        answer3_option2 = question2_option2.isChecked();
        answer3_option3 = question3_option3.isChecked();
        answer3_option4 = question3_option4.isChecked();
        if (!answer3_option1 && answer3_option2 && !answer3_option3 && answer3_option4) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }

        //Correct answer for Question 4 is Nigeria
        String answer4;
        question4_answer = (EditText) this.findViewById(R.id.question4_answer);
        answer4 = question4_answer.getText().toString().toLowerCase();
        if (answer4.equals("nigeria")) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }

        //Correct answer for Question 5 is Yes
        Boolean answer5;
        question5_option1 = (RadioButton) this.findViewById(R.id.question5_option1);
        answer5 = question5_option1.isChecked();
        if (answer5) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }
        // Total Score
        total_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score;

        if (total_score == 5) {
            displayResult = "Perfect! You answered all the questions correctly";
        } else {
            displayResult = "Try again. You scored " + total_score + " out of 5";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, displayResult, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}

