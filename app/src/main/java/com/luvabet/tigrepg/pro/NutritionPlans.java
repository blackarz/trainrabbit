package com.luvabet.tigrepg.pro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.luvabet.tigrepg.tigrepg.R;

public class NutritionPlans extends AppCompatActivity {

    ImageView BackBtn,MenuBtn,BegennerBtn,TextWorkout, IntermediateBtn,TextIntermediate,AdvancedBtn,TextAdvanced,FatlossBtn,TextFatloss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_plans);



        BackBtn = findViewById(R.id.BackBtn);
        MenuBtn = findViewById(R.id.MenuBtn);

        BegennerBtn = findViewById(R.id.BegennerBtn);
        TextWorkout = findViewById(R.id.TextWorkout);

        IntermediateBtn = findViewById(R.id.IntermediateBtn);
        TextIntermediate = findViewById(R.id.TextIntermediate);

        AdvancedBtn = findViewById(R.id.AdvancedBtn);
        TextAdvanced = findViewById(R.id.TextAdvanced);

        FatlossBtn = findViewById(R.id.FatlossBtn);
        TextFatloss = findViewById(R.id.TextFatloss);


        MenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NutritionPlans.this, MainActivity.class);
                startActivity(intent);
            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        BegennerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextWorkout.setVisibility(View.VISIBLE);
            }
        });


        IntermediateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextIntermediate.setVisibility(View.VISIBLE);
            }
        });


        AdvancedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextAdvanced.setVisibility(View.VISIBLE);
            }
        });


        FatlossBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextFatloss.setVisibility(View.VISIBLE);
            }
        });




    }
}