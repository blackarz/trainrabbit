package com.fitness.train.rabbit.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.fitness.train.train.R;


public class MainActivity extends AppCompatActivity {

    ImageView WorkoutBtn,NutritionBtn,QuizBtn,ExtBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WorkoutBtn = findViewById(R.id.WorkoutBtn);
        NutritionBtn = findViewById(R.id.NutritionBtn);
        QuizBtn = findViewById(R.id.QuizBtn);
        ExtBtn = findViewById(R.id.ExtBtn);


        WorkoutBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WorkoutPlans.class);
            startActivity(intent);
        });

        NutritionBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NutritionPlans.class);
            startActivity(intent);
        });

        QuizBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Quizs.class);
            startActivity(intent);
        });

        ExtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);

                intent.addCategory(Intent.CATEGORY_HOME);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
            }
        });



    }
}