package com.fitness.train.rabbit.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fitness.train.train.R;


public class WorkoutQuiz extends AppCompatActivity {

    ImageView MenuBtn, BackBtn;

    private TextView tvQuestion;
    private Button btnOption1, btnOption2, btnOption3, btnNext;
    private int currentQuestionIndex = 0;
    private int score = 0;

    // Multiple questions, options, and correct answers
    private String[] questions = {
            "Which muscle \n group does the \n bench press \n primarily target?",
            "What is the main \n benefit of performing\n deadlifts?",
            "Which exercise is\n most effective for \ntargeting the biceps?",
            "How many major muscle\n groups are there\n in the human body?",
            "What is the recommended \n rest time between \nsets for muscle hypertrophy?",
            "Which exercise is\n best for strengthening\n the core?",
            "What does \"HIIT\" stand \n for in fitness?",
            "Which piece of equipment\n is typically used for\n cardiovascular workouts?",
            "Which of these exercises\n primarily targets\n the quadriceps?",
            "What is the ideal body\n fat percentage range\n for male athletes?"
    };

    private String[][] options = {
            {"Legs", "Chest", "Back"},
            {"Strengthening the lower back and legs", "Improving arm size", "Enhancing flexibility"},
            {"Squats", "Pull-Ups", "Bicep Curls"},
            {"5", "11", "Bicep 13"},
            {"10–30 seconds", "30–90 seconds", "2–5 minutes"},
            {"Plank", "Leg Press", "Bench Press"},
            {"High Intensity Interval Training", "High Impact Internal Training", "High Intensity Isometric Training"},
            {"Dumbbell", "Treadmill", "Barbell"},
            {"Deadlift", "Leg Extension", "Shoulder Press"},
            {"15-20%", "6-13%", "25-30%"}
    };

    // Indexes of correct answers
    private final int[] correctAnswers = {1, 0, 2, 1, 1, 0, 0, 1, 1, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_quiz);

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
                Intent intent = new Intent(WorkoutQuiz.this, MainActivity.class);
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
                Intent intent = new Intent(WorkoutQuiz.this, QuizResult.class);
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
