package com.example.eventdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnClick;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnClick = findViewById(R.id.btnClick);
        textView = findViewById(R.id.textView);

        // onClick Event
        btnClick.setOnClickListener(v ->
                textView.setText("Button Clicked!")
        );

        // onLongClick Event
        btnClick.setOnLongClickListener(v -> {
            textView.setText("Button Long-Pressed!");
            return true; // return true to indicate event handled
        });

        // onTextChanged Event
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText("Typing: " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
