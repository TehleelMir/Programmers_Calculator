package com.example.programmerscalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class compilerActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compiler);
        textView=findViewById(R.id.java);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView=findViewById(R.id.c);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView=findViewById(R.id.cpp);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView=findViewById(R.id.python);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView=findViewById(R.id.javascript);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        getSupportActionBar().setTitle("Compiler's");
    }
}
