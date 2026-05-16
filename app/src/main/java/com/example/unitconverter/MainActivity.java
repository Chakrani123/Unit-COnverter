package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputValue;
    Spinner conversionType;
    Button convertButton;
    TextView resultText;

    String[] conversions = {
            "Centimeters to Meters",
            "Meters to Centimeters",
            "Grams to Kilograms",
            "Kilograms to Grams"
    };

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        conversionType = findViewById(R.id.conversionType);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                conversions
        );

        conversionType.setAdapter(adapter);

        convertButton.setOnClickListener(view -> {

            double value = Double.parseDouble(
                    inputValue.getText().toString());

            String selected =
                    conversionType.getSelectedItem().toString();

            double result = 0;

            switch (selected) {
                case "Centimeters to Meters":
                    result = value / 100;
                    break;
                case "Meters to Centimeters":
                    result = value * 100;
                    break;
                case "Grams to Kilograms":
                    result = value / 1000;
                    break;
                case "Kilograms to Grams":
                    result = value * 1000;
                    break;
            }

            resultText.setText("Result: " + result);
        });
    }
}