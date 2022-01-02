package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textviewid);
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String value = bundle.getString("key");
            textView.setText(value);
        }
    }
}