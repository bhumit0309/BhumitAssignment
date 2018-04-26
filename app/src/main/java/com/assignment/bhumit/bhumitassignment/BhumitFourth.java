package com.assignment.bhumit.bhumitassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class BhumitFourth extends AppCompatActivity implements View.OnClickListener {

    Button nextButton;
    TextView question;
    RadioButton a1, a2, a3, a4;
    public static ArrayList<Questions> arrQList = new ArrayList<Questions>();
    public ArrayList<Integer> givenAnswers = new ArrayList<Integer>();
    public ArrayList<Integer> correctAnswers = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhumit_fourth);
        nextButton = (Button) findViewById(R.id.nextButton);
        question = (TextView) findViewById(R.id.fourth_q);
        a1 = (RadioButton) findViewById(R.id.fourth_first);
        a2 = (RadioButton) findViewById(R.id.fourth_second);
        a3 = (RadioButton) findViewById(R.id.fourth_third);
        a4 = (RadioButton) findViewById(R.id.fourth_fourth);
        nextButton.setOnClickListener(this);
        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        Intent intent = getIntent();
        intent.getExtras();
        Bundle bundle = intent.getExtras();
        arrQList = (ArrayList<Questions>) bundle.getSerializable("arrQList");
        givenAnswers = (ArrayList<Integer>) bundle.getSerializable("givenAnswers");
        correctAnswers = (ArrayList<Integer>) bundle.getSerializable("correctAnswers");
        correctAnswers.set(3, Integer.valueOf(arrQList.get(3).getCop()));

        loadQuestion();
    }
    public void loadQuestion()
    {
        question.setText(MainActivity.arrQList.get(3).getQue_text());
        a1.setText(MainActivity.arrQList.get(3).getOp1());
        a2.setText(MainActivity.arrQList.get(3).getOp2());
        a3.setText(MainActivity.arrQList.get(3).getOp3());
        a4.setText(MainActivity.arrQList.get(3).getOp4());
    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.fourth_first:
                givenAnswers.set(3, 0);
                break;
            case R.id.fourth_second:
                givenAnswers.set(3, 1);
                break;
            case R.id.fourth_third:
                givenAnswers.set(3, 2);
                break;
            case R.id.fourth_fourth:
                givenAnswers.set(3, 3);
                break;
            case R.id.nextButton:
                Intent i = new Intent(this, BhumitFifth.class);
                Bundle b = new Bundle();
                b.putSerializable("arrQList", arrQList);
                b.putSerializable("givenAnswers", givenAnswers);
                b.putSerializable("correctAnswers", correctAnswers);
                i.putExtras(b);

                this.startActivity(i);
                break;
        }
    }
}
