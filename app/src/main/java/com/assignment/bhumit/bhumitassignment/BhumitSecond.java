package com.assignment.bhumit.bhumitassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class BhumitSecond extends AppCompatActivity implements View.OnClickListener {

    Button nextButton;
    TextView question;
    Button a1, a2, a3, a4;
    public static ArrayList<Questions> arrQList = new ArrayList<Questions>();
    public ArrayList<Integer> givenAnswers = new ArrayList<Integer>();
    public ArrayList<Integer> correctAnswers = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhumit_second);
        nextButton = (Button) findViewById(R.id.nextButton);
        question = (TextView) findViewById(R.id.second_q);
        a1 = (Button) findViewById(R.id.second_first);
        a2 = (Button) findViewById(R.id.second_second);
        a3 = (Button) findViewById(R.id.second_third);
        a4 = (Button) findViewById(R.id.second_fourth);
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
        correctAnswers.set(1, Integer.valueOf(arrQList.get(1).getCop()));

        loadQuestion();
    }
    public void loadQuestion()
    {
        question.setText(MainActivity.arrQList.get(1).getQue_text());
        a1.setText(MainActivity.arrQList.get(1).getOp1());
        a2.setText(MainActivity.arrQList.get(1).getOp2());
        a3.setText(MainActivity.arrQList.get(1).getOp3());
        a4.setText(MainActivity.arrQList.get(1).getOp4());
    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.second_first:
                givenAnswers.set(1, 0);
                a1.setEnabled(false);
                a2.setEnabled(true);
                a3.setEnabled(true);
                a4.setEnabled(true);
                break;
            case R.id.second_second:
                givenAnswers.set(1, 1);
                a1.setEnabled(true);
                a2.setEnabled(false);
                a3.setEnabled(true);
                a4.setEnabled(true);
                break;
            case R.id.second_third:
                givenAnswers.set(1, 2);
                a1.setEnabled(true);
                a2.setEnabled(true);
                a3.setEnabled(false);
                a4.setEnabled(true);
                break;
            case R.id.second_fourth:
                givenAnswers.set(1, 3);
                a1.setEnabled(true);
                a2.setEnabled(true);
                a3.setEnabled(true);
                a4.setEnabled(false);
                break;
            case R.id.nextButton:
                Intent i = new Intent(this, BhumitThird.class);
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
