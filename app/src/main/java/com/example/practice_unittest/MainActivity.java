package com.example.practice_unittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Spinner spinner;
    private TextView res;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        res = findViewById(R.id.res);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(
                this, R.array.operations, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        double number1 = Double.parseDouble(num1.getText().toString());
        double number2 = Double.parseDouble(num2.getText().toString());

        String selectedOperation = spinner.getSelectedItem().toString();
        double result = 0.0;

        switch (selectedOperation) {
            case "Suma":
                result = number1 + number2;
                break;
            case "Resta":
                result = number1 - number2;
                break;
            case "Multiplicación":
                result = number1 * number2;
                break;
            case "División":
                result = number1 / number2;
                break;
        }

        res.setText("Resultado: " + result);
    }
}
