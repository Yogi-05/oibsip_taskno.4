package com.oasis.quizzapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button nextButton;

    private String[] questions = {
            "What does HTML stand for?",
            "Which programming language is often used for developing Android apps?",
            "What is the process of finding errors and fixing them in a program called?",
            "What is the binary system based on?",
            "What is the full form of CPU?",
            "What is the full form of RAM?",
            "What is the full form of ROM?",
            "What is the full form of GPU?",
            "What is the full form of LCD?",
            "What is the full form of LED?",
            "What is the full form of OLED?",

    };

    private String[] correctAnswers = {
            "a) Hyper Text Markup Language",
            "a) Java",
            "b) Debugging",
            "b) 2",
            "a) Central Processing Unit",
            "a) Random Access Memory",
            "a) Read Only Memory",
            "a) Graphics Processing Unit",
            "a) Liquid Crystal Display",
            "a) Light Emitting Diode",
            "a) Organic Light Emitting Diode",

    };

    private int currentQuestionIndex = 0;
    private int score = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionTextView = findViewById(R.id.question_text_view);
        optionsRadioGroup = findViewById(R.id.options_radio_group);
        nextButton = findViewById(R.id.next_button);

        displayQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    String[][] options = {
            {
                    "a) Hyper Text Markup Language",
                    "b) Hyperlinks and Text Markup Language",
                    "c) Home Tool Markup Language",
                    "d) Hyperlinks and Text Markup Language"
            },
            {
                    "a) Java",
                    "b) Kotlin",
                    "c) Swift",
                    "d) JavaScript"
            },
            {
                    "a) Compiling",
                    "b) Debugging",
                    "c) Running",
                    "d) Editing"
            },
            {
                    "a) 10",
                    "b) 2",
                    "c) 8",
                    "d) 16"
            },
            {
                    "a) Central Processing Unit",
                    "b) Computer Personal Unit",
                    "c) Central Process Unit",
                    "d) Central Processor Unit"
            },
            {
                    "a) Random Access Memory",
                    "b) Randomly Access Memory",
                    "c) Run Ace Memory",
                    "d) Run Access Memory"
            },
            {
                    "a) Read Only Memory",
                    "b) Random Only Memory",
                    "c) Run On Memory",
                    "d) Read On Memory"
            },
            {
                    "a) Graphics Processing Unit",
                    "b) Graphical Processing Unit",
                    "c) Graphical Performance Unit",
                    "d) Graphics Performance Unit"
            },
            {
                    "a) Liquid Crystal Display",
                    "b) Light Crystal Display",
                    "c) Liquid Cathode Display",
                    "d) Light Cathode Display"
            },
            {
                    "a) Light Emitting Diode",
                    "b) Light Emitting Display",
                    "c) Large Emitting Diode",
                    "d) Large Emitting Display"
            },
            {
                    "a) Organic Light Emitting Diode",
                    "b) Organic Light Emitting Display",
                    "c) Origin Light Emitting Diode",
                    "d) Origin Light Emitting Display"
            },
    };

    private void displayQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);


        optionsRadioGroup.removeAllViews();

        String[] optionsForThisQuestion = options[currentQuestionIndex];
        for (int i = 0; i < optionsForThisQuestion.length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(optionsForThisQuestion[i]);
            optionsRadioGroup.addView(radioButton);
        }
    }

    private void checkAnswer() {
        int selectedRadioButtonId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedAnswer = selectedRadioButton.getText().toString();
            String correctAnswer = correctAnswers[currentQuestionIndex];
            if (selectedAnswer.equals(correctAnswer)) {
                score++;
            }
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                displayQuestion();
            } else {
                Intent intent = new Intent(this, ScoreActivity.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);
                finish(); // Close the QuestionActivity
            }
        } else {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
        }
    }


}
