package com.assignment.bhumit.bhumitassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends Activity implements View.OnClickListener {

    Button launchButton;
    ArrayList<Questions> arrQ = new ArrayList<Questions>();
    public static ArrayList<Questions> arrQList = new ArrayList<Questions>();
    public ArrayList<Integer> givenAnswers = new ArrayList<Integer>();
    public ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
    String[] que ;
    String[] op1 ;
    String[] op2  ;
    String[] op3  ;
    String[] op4 ;
    String[] cop ;
    static int[] nos = new int[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchButton = (Button) findViewById(R.id.startButton);
        launchButton.setOnClickListener(this);
        que = getResources().getStringArray(R.array.que);
        op1 = getResources().getStringArray(R.array.op1);
        op2 = getResources().getStringArray(R.array.op2);
        op3 = getResources().getStringArray(R.array.op3);
        op4 = getResources().getStringArray(R.array.op4);
        cop = getResources().getStringArray(R.array.cop);
        for(int i = 0;i < 10 ;i++){
            arrQ.add(new Questions(que[i],op1[i],op2[i],op3[i],op4[i],cop[i]));
        }

        nos[0] = randInt(0, 9);
        nos[1] = nos[0] + 1;
        nos[2] = nos[0] + 2;
        nos[3] = nos[0] + 3;
        nos[4] = nos[0] + 4;
        for(int ii = 1;ii < 5;ii++){
            if(nos[ii]>9){
                nos[ii] = nos [ii] - 10;
            }
        }
        for(int i = 0 ; i < 5 ; i++){
            arrQList.add(arrQ.get(nos[i])) ;
            givenAnswers.add(4);
            correctAnswers.add(4);
        }
    }

    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }



    @Override
    public void onClick(View v) {

        Intent i = new Intent(this, BhumitFirst.class);
        Bundle b = new Bundle();
        b.putSerializable("arrQList", arrQList);
        b.putSerializable("givenAnswers", givenAnswers);
        b.putSerializable("correctAnswers", correctAnswers);
        i.putExtras(b);
        this.startActivity(i);
    }


}
