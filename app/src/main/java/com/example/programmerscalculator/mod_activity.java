package com.example.programmerscalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class mod_activity extends AppCompatActivity {
    private TextView textView;
    private EditText editText,editText2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_activity);
        textView=findViewById(R.id.mod_result);
        editText=findViewById(R.id.input1);
        editText2=findViewById(R.id.input2);
        button=findViewById(R.id.mod_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=editText.getText().toString(),s2=editText2.getText().toString();
                if(!s1.equals("") && !s2.equals("")) {
                    int temp1 = Integer.parseInt(s1);
                    int temp2 = Integer.parseInt(s2);
                    textView.setText((temp1 % temp2) + "");
                }
            }
        });
        getSupportActionBar().setTitle("Modulus(Mod)");
    }
}
