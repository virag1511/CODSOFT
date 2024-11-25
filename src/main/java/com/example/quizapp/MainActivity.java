package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView quizListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizListView = findViewById(R.id.quizListView);
        Button startQuizButton = findViewById(R.id.startQuizButton);


        ArrayList<String> quizzes = new ArrayList<>();
        quizzes.add("General Knowledge");
        quizzes.add("Science");
        quizzes.add("History");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, quizzes);
        quizListView.setAdapter(adapter);

        startQuizButton.setOnClickListener(v -> startQuiz(new String[]{"Sample Question?", "Option 1", "Option 2", "Option 3", "Option 4"}, "Option 1"));

        quizListView.setOnItemClickListener((parent, view, position, id) -> {
            String[] questions = {"Sample Question?", "Option 1", "Option 2", "Option 3", "Option 4"};
            String correctAnswer = "Option 1";
            startQuiz(questions, correctAnswer);
        });
    }

    private void startQuiz(String[] questions, String correctAnswer) {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        intent.putExtra("questions", questions);
        intent.putExtra("correctAnswer", correctAnswer);
        startActivity(intent);
    }
}
