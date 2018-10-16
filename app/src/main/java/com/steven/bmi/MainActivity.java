package com.steven.bmi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edWeight;
    EditText edHeight;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        Button help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity","onClick:help");
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("The BMI is an attempt to quantify the amount of tissue mass (muscle, fat, and bone) in an individual, and then categorize that person as underweight, normal weight, overweight, or obese based on that value.")
                        .setPositiveButton("OK",null)
                        .show();
                //用onClick設定按鈕的屬性

            }
        });

    }

    public void bmi(View view){
        Log.d("MainActivity" , "bmi");
        final EditText edWeight = findViewById(R.id.ed_weight);
        final EditText edHeight = findViewById(R.id.ed_height);
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        Log.d("MainActivity" , w + "/" + h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height * height);
        Log.d("MainActivity" , bmi +"");
        Toast.makeText(this,"Your Bmi is" + bmi,
                Toast.LENGTH_LONG).show();
                //下方出現資料
        new AlertDialog.Builder(this)
                .setMessage("Your Bmi is" + bmi)
                .setTitle("Bmi")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edWeight.setText("");
                        //清除輸入的資料
                    }
                })
                .show();
                //彈出的視窗
    }
}
