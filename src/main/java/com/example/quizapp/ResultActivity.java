package com.example.quizapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);
        finishButton = findViewById(R.id.finishButton);

        int score = getIntent().getIntExtra("score", 0);
        resultTextView.setText("Your Score: " + score);

        finishButton.setOnClickListener(v -> finish());
    }
}
