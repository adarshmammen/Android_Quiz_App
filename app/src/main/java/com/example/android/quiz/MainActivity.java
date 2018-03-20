package com.example.android.quiz;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean evaluate() {

        boolean answer = false;
        int ans1 = Integer.parseInt(((TextView) findViewById(R.id.ans1)).getText().toString());

        RadioGroup RdGrp = (RadioGroup) findViewById(R.id.ans2);
        int ans2 = RdGrp.getCheckedRadioButtonId();

        // for ans3
        boolean ck1 = ((CheckBox) findViewById(R.id.ans3_op1)).isChecked();
        boolean ck2 = ((CheckBox) findViewById(R.id.ans3_op2)).isChecked();
        boolean ck3 = ((CheckBox) findViewById(R.id.ans3_op3)).isChecked();
        boolean ck4 = ((CheckBox) findViewById(R.id.ans3_op4)).isChecked();

        RadioGroup RdGrp2 = (RadioGroup) findViewById(R.id.ans4);
        int ans4 = RdGrp2.getCheckedRadioButtonId();

        //easy evaluation
        if ((ans1 == 11) && (ans2 == 1) && (!ck1 && ck2 && ck3 && !ck4) && (ans4 == 8)) {
            answer = true;
        }
        return answer;

    }

    public void clicked(View v) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Results");
        if (evaluate()) {
            alertDialog.setMessage("Perfect!");

        } else {
            alertDialog.setMessage("Sorry, Try again!");
        }
        alertDialog.show();
    }
}
