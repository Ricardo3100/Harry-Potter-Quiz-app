package com.example.ricardo.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



        Button finalscore;
        int Score = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            finalscore = (Button) findViewById(R.id.lastscore);

            finalscore.setOnClickListener(finalscoreOnClickListener);
        }

        private void question1(){
            CheckBox CheckBoxx = (CheckBox) findViewById(R.id.Hermione);
            CheckBox CheckBox1 = (CheckBox) findViewById(R.id.Harry);
            CheckBox CheckBox2 = (CheckBox) findViewById(R.id.Ron);
            boolean CheckBoxChecked = CheckBoxx.isChecked();
            boolean CheckBoxChecked2 = CheckBox1.isChecked();
            boolean CheckBoxChecked3 = CheckBox2.isChecked();

            if (CheckBoxChecked && CheckBoxChecked2 && CheckBoxChecked3){
                Score += 1;
            }else Score -= 1;
        }

        private void question2(){
            RadioButton Hagrid = (RadioButton) findViewById(R.id.hagrid);
            boolean hagrid = Hagrid.isChecked();
            if (hagrid){
                Score += 1;
            }

        }
    private void question3(){
        RadioButton radio = (RadioButton) findViewById(R.id.hero);
        boolean snapewasahero = radio.isChecked();
        if (snapewasahero){
            Score += 1;
        }

    }

        private String getQuestionfourUserInput() {
            EditText text = (EditText) findViewById(R.id.edittextanswerbutton);
            String name = text.getText().toString();
            return name;
        }

        private void question4(){
            String name = getQuestionfourUserInput();
            if (name.trim().equalsIgnoreCase("rowling")){
                Score += 1;
            }
        }

        private void reviewallquestions(){
            question1();
            question2();
            question3();
            question4();
        }

        private void resetrightanswers(){
            Score = 0;
        }

        final View.OnClickListener finalscoreOnClickListener = new View.OnClickListener() {
            public void onClick(final View v){
                reviewallquestions();
                Toast.makeText(MainActivity.this, "your total score is...: " + Score + "/4",
                        Toast.LENGTH_LONG).show();
                resetrightanswers();
            }
        };
    }