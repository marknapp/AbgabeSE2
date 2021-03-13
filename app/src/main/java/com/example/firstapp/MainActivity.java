package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button b;
    Button berechnen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button2);
        berechnen = findViewById(R.id.button);

        textView = findViewById(R.id.textView);
        textView.setText("Answer from Server");
        editText = findViewById(R.id.editTextNumber);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matNr = editText.getText().toString();
                Connection t = new Connection(matNr);
                t.start();
                try {
                    t.join();
                } catch (InterruptedException ie) {

                }
                textView.setText(t.getAnswer());
            }
        });
    }
        public void berechnen(String matNr) {
            int firstSum = 0;
            int secondSum = 0;
            int[] numbers = new int[matNr.length()];
            char[] c = matNr.toCharArray();

            for (int i = 0; i < matNr.length(); i++) {
                numbers[i] = (int) c[i]-48;
            }
            for (int i = 0; i < numbers.length; i++) {
                if (i % 2 == 0) {
                    firstSum += numbers[i];
                } else {
                    secondSum += numbers[i];
                }
            }
            int alternierendeQuersumme = firstSum-secondSum;
            if(alternierendeQuersumme%2==0){
                textView.setText("GERADE");
            }
            else{
                textView.setText("UNGERADE");
            }

        }
}