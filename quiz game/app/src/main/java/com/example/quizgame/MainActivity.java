package com.example.quizgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }

    private void checkQuestionOneAnswers() {
        CheckBox questionRed = (CheckBox) findViewById(R.id.checkboxRed);
        CheckBox questionVoilet = (CheckBox) findViewById(R.id.checkboxViolet);
        CheckBox questionPink = (CheckBox) findViewById(R.id.checkboxPink);
        boolean isQRedChecked = questionRed.isChecked();
        boolean isQVoiletChecked = questionVoilet.isChecked();
        boolean isQPinkChecked = questionPink.isChecked();

        if (isQRedChecked && isQVoiletChecked && !isQPinkChecked) {
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswers() {
        RadioButton radioButton765BC = (RadioButton) findViewById(R.id.radio_776BC);
        boolean isQ765BCChecked = radioButton765BC.isChecked();
        if (isQ765BCChecked) {
            correctAnswers += 1;
        }
    }

    private String getQuestionThreeUserInput() {
        EditText userInput = (EditText) findViewById(R.id.answerInputUser);
        String cricket = userInput.getText().toString();
        return cricket;
    }

    private void checkQuestionThreeAnswer() {
        String cricket = getQuestionThreeUserInput();
        if (cricket.trim().equalsIgnoreCase("cricket")) {
            correctAnswers += 1;
        }
    }

    private void checkQuestionFourAnswers() {
        RadioButton radioButtoncricket = (RadioButton) findViewById(R.id.radio_cricket);
        boolean isQChecked = radioButtoncricket.isChecked();
        if (isQChecked) {
            correctAnswers += 1;
        }
    }

    private void checkQuestionFiveAnswers() {
        CheckBox qHousefull = (CheckBox) findViewById(R.id.checkboxHousefull);
        CheckBox qSpecial = (CheckBox) findViewById(R.id.checkboxSpecial36);
        CheckBox qKesari = (CheckBox) findViewById(R.id.checkboxKesari);
        boolean isQHousefullChecked = qHousefull.isChecked();
        boolean isQSpecailChecked = qSpecial.isChecked();
        boolean isQKesariChecked = qKesari.isChecked();

        if (isQHousefullChecked && isQSpecailChecked && isQKesariChecked) {
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions() {
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswers() {
        correctAnswers = 0;
    }


    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v) {
            checkAllQuestions();
            if (correctAnswers == 0) {
                Toast.makeText(MainActivity.this, "POOR PLAYED SCORED = 0", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/5",
                        Toast.LENGTH_LONG).show();
                resetCounterCorrectAnswers();
            }
        }
    };
}
