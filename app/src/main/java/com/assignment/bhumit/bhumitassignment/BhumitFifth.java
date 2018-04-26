package com.assignment.bhumit.bhumitassignment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.exit;

public class BhumitFifth extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    Button nextButton;
    ListView listView;
    TextView question;
    public static ArrayList<Questions> arrQList = new ArrayList<Questions>();
    public ArrayList<Integer> givenAnswers = new ArrayList<Integer>();
    public ArrayList<Integer> correctAnswers = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhumit_fifth);
        nextButton = (Button) findViewById(R.id.nextButton);
        listView = (ListView) findViewById(R.id.list);
        nextButton.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        question = (TextView) findViewById(R.id.fifth_q);
        nextButton.setOnClickListener(this);
        Intent intent = getIntent();
        intent.getExtras();
        Bundle bundle = intent.getExtras();
        arrQList = (ArrayList<Questions>) bundle.getSerializable("arrQList");
        givenAnswers = (ArrayList<Integer>) bundle.getSerializable("givenAnswers");
        correctAnswers = (ArrayList<Integer>) bundle.getSerializable("correctAnswers");
        correctAnswers.set(4, Integer.valueOf(arrQList.get(4).getCop()));

        loadQuestion();
    }
    public void loadQuestion()
    {
        question.setText(MainActivity.arrQList.get(4).getQue_text());
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("answer", MainActivity.arrQList.get(4).getOp1());
        data.add(map);
        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("answer", MainActivity.arrQList.get(4).getOp2());
        data.add(map1);
        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("answer", MainActivity.arrQList.get(4).getOp3());
        data.add(map2);
        HashMap<String, String> map3 = new HashMap<String, String>();
        map3.put("answer", MainActivity.arrQList.get(4).getOp4());
        data.add(map3);

        int resource = R.layout.activity_bhumit_fifth_details;
        String[] from = {"answer"};
        int[] to = {R.id.nameTextView};

        // create and set the adapter
        SimpleAdapter adapter =
                new SimpleAdapter(this, data, resource, from, to);
        listView.setAdapter(adapter);

    }


    @Override
    public void onClick(View v) {
        int score = 0;
        for(int count = 0; count < 5; count++)
        {
            if(givenAnswers.get(count) == correctAnswers.get(count))
            {
                score++;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        //Setting message manually and performing action on button click

        AlertDialog alertDialog = new AlertDialog.Builder(BhumitFifth.this).create(); //Read Update
        alertDialog.setTitle("Result");
        switch (score){
            case 3:
                alertDialog.setMessage("Good Job!");
                break;
            case 4:
                alertDialog.setMessage("Excellent Job");
                break;
            case 5:
                alertDialog.setMessage("You are a genius!");
                break;
            default:
                alertDialog.setMessage("Please try again!");
                break;
        }
        alertDialog.setButton("Exit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        alertDialog.show();  //<-- See This!
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch(position)
        {
            case 1:
                givenAnswers.set(4, 0);
                break;
            case 2:
                givenAnswers.set(4, 1);
                break;
            case 3:
                givenAnswers.set(4, 2);
                break;
            case 4:
                givenAnswers.set(4, 3);
                break;
        }
    }
}
