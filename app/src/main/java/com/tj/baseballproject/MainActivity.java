package com.tj.baseballproject;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tj.baseballproject.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    int[] computerExamArray = new int[3]; // 741 => 7,4,1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        makeExam();

    }



    void makeExam(){

        while (true){
        int randomNumber = (int) (Math.random() * 899 + 100);

        int[] tempNumber = new int[3];

        tempNumber[0] = randomNumber / 100;
        tempNumber[1] = (randomNumber / 10) % 10 ;
        tempNumber[2] = randomNumber % 10;


        boolean isDuplOk = true;
        if (tempNumber[0] == tempNumber[1] || tempNumber[1] == tempNumber[2] || tempNumber[0] == tempNumber[2]){
            isDuplOk= false;
        }

            boolean isZeroOk = true;
        if (tempNumber[0] == 0 || tempNumber[1] == 0 || tempNumber[2] == 0){
            isZeroOk= false;
        }
        if (isDuplOk && isZeroOk) {
            computerExamArray[0] = tempNumber[0];
            computerExamArray[1] = tempNumber[1];
            computerExamArray[2] = tempNumber[2];

            break;
        }

        }

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil. setContentView(this, R.layout.activity_main);

    }
}
