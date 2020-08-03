package com.example.programmerscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class converter_activity extends AppCompatActivity {
    private Spinner spinnerOne, spinnerTwo;
    private Button button;
    private TextView textView;
    private EditText editText;
    private String str, secondSpinnerData[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_activity);
        spinnerOne = findViewById(R.id.spinnerOne);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // adapter.addAll(data.spinnerALLValues);
        spinnerOne.setAdapter(new customAdapter(data.spinnerALLValues));
        spinnerTwo = findViewById(R.id.spinnerTwo);
        button = findViewById(R.id.converter_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convert();
            }
        });
        setTheSecondSpinner(0);
        spinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setTheSecondSpinner(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        getSupportActionBar().setTitle("Converter");
    }

    private void setTheSecondSpinner(int position) {
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        switch (position) {
            case 0:
                secondSpinnerData = data.text;
                // adapter.addAll(data.text);
                break;
            case 1:
                secondSpinnerData = data.binary;
                //adapter.addAll(data.binary);
                break;
            case 2:
                secondSpinnerData = data.decimal;
                //adapter.addAll(data.decimal);
                break;
            case 3:
                secondSpinnerData = data.hexadecimal;
                //adapter.addAll(data.hexadecimal);
                break;
            case 4:
                secondSpinnerData = data.octal;
                //adapter.addAll(data.octal);
                break;
            case 5:
                secondSpinnerData = data.kb;
                //adapter.addAll(data.kb);
                break;
            case 6:
                secondSpinnerData = data.mb;
                //adapter.addAll(data.mb);
                break;
            case 7:
                secondSpinnerData = data.gb;
                //adapter.addAll(data.gb);
                break;
            case 8:
                secondSpinnerData = data.tb;
                //adapter.addAll(data.tb);
                break;
        }
        spinnerTwo.setAdapter(new customAdapter(secondSpinnerData));
    }

    private void convert() {
        int postionOfSecondSpinner = spinnerTwo.getSelectedItemPosition();
//        String sTwo =spinnerTwo.getSelectedItem().toString();
        int position = spinnerOne.getSelectedItemPosition();
        textView = findViewById(R.id.converter_result);
        editText = findViewById(R.id.converter_input);
        String holdTheResult = "";
        str = editText.getText().toString();
        str = str.trim();
        switch (position) {
            case 0:
                char[] messChar = str.toCharArray();

                for (int i = 0; i < messChar.length; i++) {
                    String temp = Integer.toBinaryString(messChar[i]) + " ";
                    while (temp.length() <= 8)
                        temp = "0" + temp;
                    holdTheResult += temp;
                }
                break;
            case 1:
                holdTheResult = binary(postionOfSecondSpinner);
                break;
            case 2:
                holdTheResult = decimal(postionOfSecondSpinner);
                break;
            case 3:
                holdTheResult = hex(postionOfSecondSpinner);
                break;
            case 4:
                holdTheResult = octal(postionOfSecondSpinner);
                break;
            case 5:
                holdTheResult = kb(postionOfSecondSpinner);
                break;
            case 6:
                holdTheResult = mb(postionOfSecondSpinner);
                break;
            case 7:
                holdTheResult = gb(postionOfSecondSpinner);
                break;
            case 8:
                holdTheResult = tb(postionOfSecondSpinner);
                break;
        }
        textView.setText(holdTheResult);
    }

    private String binary(int s) {
        String temp = "";
        int decimal = 0;
        if (s != 2) {
            try {
                decimal = Integer.parseInt(str, 2);
            } catch (Exception e) {
                toast("Wrong Input");
                return "";
            }
        }
        switch (s) {
            case 0:
                temp += decimal;
                break;
            case 1:
                temp = Integer.toString(decimal, 16);
                break;
            case 2:
                String s2 = " ";
                try {
                    for (int index = 0; index < str.length(); index += 9) {
                        String temp2 = str.substring(index, index + 8);
                        int num2 = Integer.parseInt(temp2, 2);
                        char letter = (char) num2;
                        s2 = s2 + letter;
                    }
                } catch (Exception e) {
                    toast("Wrong Input");
                    return "";
                }
                temp = s2;
                break;
            case 3:
                temp = Integer.toString(decimal, 8);
                break;
        }
        return temp;
    }

    private String decimal(int s) {
        String temp = "";
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (Exception e) {
            toast("Wrong Input");
            return "";
        }
        switch (s) {
            case 0:
                temp = Integer.toBinaryString(num);
                break;
            case 1:
                temp = Integer.toHexString(num);
                break;
            case 2:
                temp = Integer.toOctalString(num);
                break;
        }
        return temp + "";
    }

    private String hex(int s) {
        String temp = "";
        int num;
        try {
            num = Integer.parseInt(str, 16);
        } catch (Exception e) {
            toast("Wrong Input");
            return "";
        }
        switch (s) {
            case 0:
                temp = Integer.toBinaryString(num);
                break;
            case 1:
                temp += num;
                break;
            case 2:
                temp = Integer.toOctalString(num);
                break;
        }
        return temp + "";
    }

    private String octal(int s) {
        String temp = "";
        int num;
        try {
            num = Integer.parseInt(str, 8);
        } catch (Exception e) {
            toast("Wrong Input");
            return "";
        }
        switch (s) {
            case 0:
                temp = Integer.toBinaryString(num);
                break;
            case 1:
                temp += num;
                break;
            case 2:
                temp = Integer.toHexString(num);
                break;
        }
        return temp + "";
    }

    private String kb(int s) {
        String temp = "";
        double num;
        try {
            num = Double.parseDouble(str);
        } catch (Exception e) {
            toast("Wrong Input");
            return "";
        }
        switch (s) {
            case 0:
                temp += num / 1000;
                break;
            case 1:
                temp += num / 1e+6;
                break;
            case 2:
                temp += num / 1e+9;
                break;
        }
        return temp + "";
    }

    private String mb(int s) {
        String temp = "";
        double num;
        try {
            num = Double.parseDouble(str);
        } catch (Exception e) {
            toast("Wrong Input");
            return "";
        }
        switch (s) {
            case 0:
                temp += num * 1000;
                break;
            case 1:
                temp += num / 1000;
                break;
            case 2:
                temp += num / 1e+6;
                break;
        }
        return temp + "";
    }

    private String gb(int s) {
        String temp = "";
        double num;
        try {
            num = Double.parseDouble(str);
        } catch (Exception e) {
            toast("Wrong Input");
            return "";
        }
        switch (s) {
            case 0:
                temp += num * 1e+6;
                break;
            case 1:
                temp += num * 1000;
                break;
            case 2:
                temp += num / 1000;
                break;
        }
        return temp + "";
    }

    private String tb(int s) {
        String temp = "";
        double num;
        try {
            num = Double.parseDouble(str);
        } catch (Exception e) {
            toast("Wrong Input");
            return "";
        }
        switch (s) {
            case 0:
                temp += num * 1e+9;
                break;
            case 1:
                temp += num * 1e+6;
                break;
            case 2:
                temp += num / 1000;
                break;
        }
        return temp + "";
    }

    public void copy(View view) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData data = ClipData.newPlainText("Copied", textView.getText().toString());
            clipboardManager.setPrimaryClip(data);
        } catch (Exception e) {
        }
        toast("Copied");
    }

    private void toast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    private class customAdapter extends BaseAdapter {
        String temp[];

        public customAdapter(String temp[]) {
            this.temp = temp;
        }

        @Override
        public int getCount() {
            return temp.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_layout_for_spinner, null);
            TextView textView = view.findViewById(R.id.text1);
            textView.setText(temp[i]);
            return view;
        }
    }
}
