package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsGroup;
    private Button submitAnswerButton;

    private String[] questions;
    private String correctAnswer;
    private int score = 0;
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = findViewById(R.id.questionTextView);
        optionsGroup = findViewById(R.id.optionsGroup);
        submitAnswerButton = findViewById(R.id.submitAnswerButton);

        Intent intent = getIntent();
        questions = intent.getStringArrayExtra("questions");
        correctAnswer = intent.getStringExtra("correctAnswer");

        displayQuestion();

        submitAnswerButton.setOnClickListener(v -> submitAnswer());
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionTextView.setText(questions[currentQuestionIndex]);
            optionsGroup.removeAllViews();

            String[] options = {"Option 1", "Option 2", "Option 3", "Option 4"};
            for (String option : options) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText(option);
                optionsGroup.addView(radioButton);
            }
        } else {
            showResult();
        }
    }

    private void submitAnswer() {
        int selectedId = optionsGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedOption = findViewById(selectedId);
            if (selectedOption.getText().toString().equals(correctAnswer)) {
                score++;
            }
            currentQuestionIndex++;
            displayQuestion();
        }
    }

    private void showResult() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }
}
