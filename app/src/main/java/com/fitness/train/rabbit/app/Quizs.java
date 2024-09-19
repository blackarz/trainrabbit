package com.fitness.train.rabbit.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.fitness.train.train.R;


public class Quizs extends AppCompatActivity {

    ImageView BackBtn,MenuBtn,WorkoutQuizBtn, NutritionQuizBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizs);


        BackBtn = findViewById(R.id.BackBtn);
        MenuBtn = findViewById(R.id.MenuBtn);

        WorkoutQuizBtn = findViewById(R.id.WorkoutQuizBtn);
        NutritionQuizBtn = findViewById(R.id.NutritionQuizBtn);



        MenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quizs.this, MainActivity.class);
                startActivity(intent);
            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        WorkoutQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quizs.this, WorkoutQuiz.class);
                startActivity(intent);
            }
        });

        NutritionQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quizs.this, NutritionQuiz.class);
                startActivity(intent);
            }
        });







    }
}