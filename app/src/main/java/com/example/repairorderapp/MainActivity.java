package com.example.repairorderapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    double subtotal = 0.0;
    double tax = 0.0;
    double total = 0.0;

    EditText orderNumberET;// create edit text

    EditText inspectionET;

    EditText partsET;

    EditText laborET;
    Button submitB;// create button

    TextView subTotalTV; //initialize text view
//create button listener
    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Random gen = new Random();

            double number = gen.nextDouble();
            String var = "$ " + number;
            subTotalTV.setText(var);


            String orderTypeV = orderNumberET.getText().toString();

            String inspectionV = inspectionET.getText().toString();

            String partsV = partsET.getText().toString();

            String laborV = laborET.getText().toString();

        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        subTotalTV = findViewById(R.id.subtotalIn);
        submitB = findViewById(R.id.buttonSumbit);
        submitB.setOnClickListener(buttonListener);
        orderNumberET = findViewById(R.id.orderBox);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}