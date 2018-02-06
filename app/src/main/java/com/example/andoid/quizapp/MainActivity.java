package com.example.andoid.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;

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
    // Question 1
    EditText question1_answer;
    // Question 2
    RadioButton question2_choice1;
    // Question 3
    CheckBox question3_choice1;
    CheckBox question2_choice2;
    CheckBox question3_choice3;
    CheckBox question3_choice4;
    // Question 4
    RadioButton question4_choice1;
    // Question 5
    CheckBox question5_choice1;
    CheckBox question5_choice2;
    CheckBox question5_choice3;
    // Question 6
    RadioButton question6_choice2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }


    public void submitAnswers(View view) {
        CharSequence resultsDisplay;
        int answer1_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int answer6_score;
        int final_score;

        //
        // Question 1 - Correct Answer is Mozzarella
        //
        String answer1;
        question1_answer = (EditText) this.findViewById(R.id.question1_answer);
        answer1 = question1_answer.getText().toString().toLowerCase();
        if (answer1.equals("mozzarella")) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }

        //
        // Question 2 - Correct Answer is "Almonds"
        //
        Boolean answer2;
        question2_choice1 = (RadioButton) this.findViewById(R.id.question2_choice1);
        answer2 = question2_choice1.isChecked();
        if (answer2) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }

        //
        // Question 3  - Correct Answers are #1 (Harp Lager) and #3 (Guiness)
        //
        Boolean answer3_choice1;
        Boolean answer3_choice2;
        Boolean answer3_choice3;
        Boolean answer3_choice4;
        question3_choice1 = (CheckBox) this.findViewById(R.id.question3_choice1);
        question2_choice2 = (CheckBox) this.findViewById(R.id.question3_choice2);
        question3_choice3 = (CheckBox) this.findViewById(R.id.question3_choice3);
        question3_choice4 = (CheckBox) this.findViewById(R.id.question3_choice4);
        answer3_choice1 = question3_choice1.isChecked();
        answer3_choice2 = question2_choice2.isChecked();
        answer3_choice3 = question3_choice3.isChecked();
        answer3_choice4 = question3_choice4.isChecked();
        if (answer3_choice1 && !answer3_choice2 && answer3_choice3 && !answer3_choice4) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }

        //
        // Question 4  - Correct Answer is #1 "Cuba"
        //
        Boolean answer4;
        question4_choice1 = (RadioButton) this.findViewById(R.id.question4_choice1);
        answer4 = question4_choice1.isChecked();
        if (answer4) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }

        //
        // Question 5  - Correct Answers are #1 (Swiss) and #3 (Switzerland)
        //
        Boolean answer5_choice1;
        Boolean answer5_choice2;
        Boolean answer5_choice3;
        question5_choice1 = (CheckBox) this.findViewById(R.id.question5_choice1);
        question5_choice2 = (CheckBox) this.findViewById(R.id.question5_choice2);
        question5_choice3 = (CheckBox) this.findViewById(R.id.question5_choice3);
        answer5_choice1 = question5_choice1.isChecked();
        answer5_choice2 = question5_choice2.isChecked();
        answer5_choice3 = question5_choice3.isChecked();
        if (answer5_choice1 && !answer5_choice2 && answer5_choice3) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }

        //
        // Question 6  - Correct Answers is #2 "Rice"
        //
        Boolean answer6;
        question6_choice2 = (RadioButton) this.findViewById(R.id.question6_choice2);
        answer6 = question6_choice2.isChecked();
        if (answer6) {
            answer6_score = 1;
        } else {
            answer6_score = 0;
        }

        //
        // Total Score
        //
        final_score = answer1_score + answer2_score + answer3_score + answer4_score +
                answer5_score + answer6_score;

        if (final_score == 6) {
            resultsDisplay = "Great! You scored 6 out of 6";
        } else {
            resultsDisplay = "Try again. You scored " + final_score + " out of 6";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}

