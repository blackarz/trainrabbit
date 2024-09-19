package com.fitness.train.rabbit.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fitness.train.train.R;


public class NutritionQuiz extends AppCompatActivity {

    ImageView MenuBtn, BackBtn;

    private TextView tvQuestion;
    private Button btnOption1, btnOption2, btnOption3, btnNext;
    private int currentQuestionIndex = 0;
    private int score = 0;

    // Multiple questions, options, and correct answers
    private final String[] questions = {
            "Which macronutrient \n is primarily responsible\n for muscle repair and growth?",
            "What is the main\n purpose of a \npre-workout meal?",
            "Which vitamin is crucial \nfor calcium absorption \nand bone health?",
            "What is the recommended\n protein intake \nfor muscle building?",
            "Which of the following\n foods is a good\n source of healthy fats?",
            "What type of diet focuses\n on high fat, moderate protein,\n and low carbohydrate intake?",
            "Which supplement is commonly\n used to enhance endurance \nand reduce muscle fatigue?",
            "What is the primary function\n of carbohydrates in\n an athlete's diet?",
            "Which mineral is lost \nthrough sweat and\n should be replenished\n during intense workouts?",
            "What is the ideal timing\n for post-workout nutrition\n to maximize muscle recovery?"
    };

    private final String[][] options = {
            {"Carbohydrates", "Protein", "Fats"},
            {"Promote muscle recovery", "Provide energy for the workout", "Burn more calories"},
            {"Vitamin C", "Vitamin D", "Vitamin A"},
            {"0.5 grams per kilogram of body weight", "1.6–2.2 grams per kilogram of body weight", "3.0 grams per kilogram of body weight"},
            {" White bread", "Avocado", "Chicken breast"},
            {"Paleo Diet", "Ketogenic Diet", "Mediterranean Diet"},
            {"Protein powder", "BCAAs", "Multivitamins"},
            {"Provide energy", "Build muscle", "Promote"},
            {"Sodium", "Iron", "Zinc"},
            {"2–3 hours after the workout", "Within 30 minutes after the workout", "Only before bedtime"},

    };

    // Indexes of correct answers
    private final int[] correctAnswers = {1, 1, 1, 1, 1, 1, 1, 0, 0, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_quiz);

        BackBtn = findViewById(R.id.BackBtn);
        MenuBtn = findViewById(R.id.MenuBtn);

        tvQuestion = findViewById(R.id.tv_question);
        btnOption1 = findViewById(R.id.btn_option1);
        btnOption2 = findViewById(R.id.btn_option2);
        btnOption3 = findViewById(R.id.btn_option3);
        btnNext = findViewById(R.id.btn_next);

        MenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutritionQuiz.this, MainActivity.class);
                startActivity(intent);
            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        loadQuestion();

        btnOption1.setOnClickListener(v -> checkAnswer(btnOption1, 0));
        btnOption2.setOnClickListener(v -> checkAnswer(btnOption2, 1));
        btnOption3.setOnClickListener(v -> checkAnswer(btnOption3, 2));

        btnNext.setOnClickListener(v -> {
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                resetButtonBackgrounds();
                loadQuestion();
            } else {
                // When all questions are answered, navigate to the ResultActivity
                Intent intent = new Intent(NutritionQuiz.this, QuizResultNutrition.class);
                intent.putExtra("score", score);
                intent.putExtra("total", questions.length);
                startActivity(intent);
                finish();
            }
        });
    }

    // Function to load a question
    private void loadQuestion() {
        // Set the question text and options
        tvQuestion.setText(questions[currentQuestionIndex]);
        btnOption1.setText(options[currentQuestionIndex][0]);
        btnOption2.setText(options[currentQuestionIndex][1]);
        btnOption3.setText(options[currentQuestionIndex][2]);

        // Disable next button until an answer is selected
        btnNext.setEnabled(false);
    }

    // Function to check the answer selected by the user
    private void checkAnswer(Button selectedButton, int selectedOptionIndex) {
        // Enable next button once an answer is selected
        btnNext.setEnabled(true);

        // Check if the selected option matches the correct answer
        if (selectedOptionIndex == correctAnswers[currentQuestionIndex]) {
            score++;
            selectedButton.setBackgroundResource(R.drawable.button_correct); // Set to green
        } else {
            selectedButton.setBackgroundResource(R.drawable.button_incorrect); // Set to red
        }

        // Disable other buttons to prevent changing the answer after selection
        disableButtons();
    }

    // Function to disable all option buttons after selection
    private void disableButtons() {
        btnOption1.setEnabled(false);
        btnOption2.setEnabled(false);
        btnOption3.setEnabled(false);
    }

    // Function to reset buttons for the next question
    private void resetButtonBackgrounds() {
        btnOption1.setBackgroundResource(R.drawable.button_background); // Default background
        btnOption2.setBackgroundResource(R.drawable.button_background);
        btnOption3.setBackgroundResource(R.drawable.button_background);

        // Re-enable buttons
        btnOption1.setEnabled(true);
        btnOption2.setEnabled(true);
        btnOption3.setEnabled(true);
    }
}
