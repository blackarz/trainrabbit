package com.fitness.train.rabbit.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fitness.train.train.R;


public class QuizResultNutrition extends AppCompatActivity {

    ImageView MenuBtn,BackBtn;

    private TextView tvScore;
    private TextView btnRetry;
    private ImageView btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_resultnutrition);

        BackBtn = findViewById(R.id.BackBtn);
        MenuBtn = findViewById(R.id.MenuBtn);


        tvScore = findViewById(R.id.tv_score);
        btnRetry = findViewById(R.id.btn_retry);
        btnMenu = findViewById(R.id.btn_menu);


        MenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizResultNutrition.this, MainActivity.class);
                startActivity(intent);
            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Get the score and total number of questions
        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 0);

        // Display the score
        tvScore.setText("Correct Answers: " + score + "/" + total);

        // Retry button to start the quiz again
        btnRetry.setOnClickListener(v -> {
            Intent intent = new Intent(QuizResultNutrition.this, NutritionQuiz.class);
            startActivity(intent);
            finish();
        });

        // Menu button to go back to the main menu
        btnMenu.setOnClickListener(v -> {
            Intent intent = new Intent(QuizResultNutrition.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
