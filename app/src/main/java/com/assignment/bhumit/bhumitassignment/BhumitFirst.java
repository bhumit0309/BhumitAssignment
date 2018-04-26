package com.assignment.bhumit.bhumitassignment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class BhumitFirst extends Activity implements View.OnClickListener {

    Button nextButton;
    TextView question;
    TextView a1, a2, a3, a4;
    public static ArrayList<Questions> arrQList = new ArrayList<Questions>();
    public ArrayList<Integer> givenAnswers = new ArrayList<Integer>();
    public ArrayList<Integer> correctAnswers = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhumit_first);
        nextButton = (Button) findViewById(R.id.nextButton);
        question = (TextView) findViewById(R.id.first_q);
        a1 = (TextView) findViewById(R.id.first_first);
        a2 = (TextView) findViewById(R.id.first_second);
        a3 = (TextView) findViewById(R.id.first_third);
        a4 = (TextView) findViewById(R.id.first_fourth);
        nextButton.setOnClickListener(this);
        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);

        Intent intent = getIntent();
        intent.getExtras();
        Bundle b = intent.getExtras();
        arrQList = (ArrayList<Questions>) b.getSerializable("arrQList");
        givenAnswers = (ArrayList<Integer>) b.getSerializable("givenAnswers");
        correctAnswers = (ArrayList<Integer>) b.getSerializable("correctAnswers");
        correctAnswers.set(0, Integer.valueOf(arrQList.get(0).getCop()));

        loadQuestion();
    }
    public void loadQuestion()
    {
        question.setText(MainActivity.arrQList.get(0).getQue_text());
        a1.setText(MainActivity.arrQList.get(0).getOp1());
        a2.setText(MainActivity.arrQList.get(0).getOp2());
        a3.setText(MainActivity.arrQList.get(0).getOp3());
        a4.setText(MainActivity.arrQList.get(0).getOp4());
    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.first_first:
                givenAnswers.set(0, 0);
                a1.setTextColor(Color.BLUE);
                a2.setTextColor(Color.BLACK);
                a3.setTextColor(Color.BLACK);
                a4.setTextColor(Color.BLACK);
                break;
            case R.id.first_second:
                givenAnswers.set(0, 1);
                a1.setTextColor(Color.BLACK);
                a2.setTextColor(Color.BLUE);
                a3.setTextColor(Color.BLACK);
                a4.setTextColor(Color.BLACK);
                break;
            case R.id.first_third:
                givenAnswers.set(0, 2);
                a1.setTextColor(Color.BLACK);
                a2.setTextColor(Color.BLACK);
                a3.setTextColor(Color.BLUE);
                a4.setTextColor(Color.BLACK);
                break;
            case R.id.first_fourth:
                givenAnswers.set(0, 3);
                a1.setTextColor(Color.BLACK);
                a2.setTextColor(Color.BLACK);
                a3.setTextColor(Color.BLACK);
                a4.setTextColor(Color.BLUE);
                break;
            case R.id.nextButton:
                Intent i = new Intent(this, BhumitSecond.class);
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
