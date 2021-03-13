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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button2);

        textView = findViewById(R.id.textView);
        textView.setText("Answer from Server");
        editText = findViewById(R.id.editTextNumber);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matNr = editText.getText().toString();
                Connection t = new Connection(matNr);
                t.start();
                try{
                    t.join();
                }catch(InterruptedException ie){

                }
                textView.setText(t.getAnswer());
            }
        });

    }
}