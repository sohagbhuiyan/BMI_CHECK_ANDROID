package com.example.bmicalculation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight,edtHeightFt,edtHeightIn;
        TextView txtResult;
        Button btnCal;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        txtResult = findViewById(R.id.txtResult);
        btnCal =findViewById(R.id.btnCal);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt= Integer.parseInt(edtWeight.getText().toString());
               int ft= Integer.parseInt(edtHeightFt.getText().toString());
               int in= Integer.parseInt(edtHeightIn.getText().toString());

               int totalIn=ft*12+ in;
               double totalCm= totalIn*2.53;
               double totalM=totalCm/100;
               double bmi=wt/(totalM*totalM);
               try {
                   if(bmi>25){
                       txtResult.setText("You're OverWeight.");

                   } else if (bmi<10) {
                       txtResult.setText("You're UnderWeight.");

                   }else {
                       txtResult.setText("You Are Healthy!");
                   }
               } catch (Exception e) {
                   Toast.makeText(MainActivity.this, "Please Cheque", Toast.LENGTH_SHORT).show();
               }


            }
        });

    }
}