package com.assignment.bhumit.bhumitassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class BhumitThird extends AppCompatActivity implements View.OnClickListener {

    Button nextButton;
    TextView question;
    CheckBox a1, a2, a3, a4;
    public static ArrayList<Questions> arrQList = new ArrayList<Questions>();
    public ArrayList<Integer> givenAnswers = new ArrayList<Integer>();
    public ArrayList<Integer> correctAnswers = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhumit_third);
        nextButton = (Button) findViewById(R.id.nextButton);
        question = (TextView) findViewById(R.id.third_q);
        a1 = (CheckBox) findViewById(R.id.third_first);
        a2 = (CheckBox) findViewById(R.id.third_second);
        a3 = (CheckBox) findViewById(R.id.third_third);
        a4 = (CheckBox) findViewById(R.id.third_fourth);
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
        correctAnswers.set(2, Integer.valueOf(arrQList.get(2).getCop()));

        loadQuestion();
    }
    public void loadQuestion()
    {
        question.setText(MainActivity.arrQList.get(2).getQue_text());
        a1.setText(MainActivity.arrQList.get(2).getOp1());
        a2.setText(MainActivity.arrQList.get(2).getOp2());
        a3.setText(MainActivity.arrQList.get(2).getOp3());
        a4.setText(MainActivity.arrQList.get(2).getOp4());
    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.third_first:
                givenAnswers.set(2, 0);
                a2.setChecked(false);
                a3.setChecked(false);
                a4.setChecked(false);
                break;
            case R.id.third_second:
                givenAnswers.set(2, 1);
                a1.setChecked(false);
                a3.setChecked(false);
                a4.setChecked(false);
                break;
            case R.id.third_third:
                givenAnswers.set(2, 2);
                a2.setChecked(false);
                a1.setChecked(false);
                a4.setChecked(false);
                break;
            case R.id.third_fourth:
                givenAnswers.set(2, 3);
                a2.setChecked(false);
                a3.setChecked(false);
                a1.setChecked(false);
                break;
            case R.id.nextButton:
                Intent i = new Intent(this, BhumitFourth.class);
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
