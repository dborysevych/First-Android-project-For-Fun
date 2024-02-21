package com.calculatorofthemedium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.lang.Double;


public class MainActivity extends AppCompatActivity {

    List<Double> list;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Double>();
        editText = (EditText) findViewById(R.id.EditTextNum);
        textView = (TextView) findViewById(R.id.TextViewMedium);
    }


    //add num to the list and calculate the medium
    public void sendMessage(View view) {

        //change text on the button
        Button but = (Button) findViewById(R.id.ButtonCalculate);
        but.setText(R.string.button_AddNum);

        // Get num and add to the list
        Double num = Double.parseDouble(editText.getText().toString());
        list.add(num);


        //count the medium
        Double medium = 0.0;

        for(Double d : list) {
            medium += d;
        }

        medium /= list.size();

        //set medium to the textViewMedium
        String str = medium.toString();
        textView.setText(str);
    }

    //reset the list
    public void resetList(View view) {
        list.clear();
    }

    //show the list
    public void showList(View view) {

        TextView txt = (TextView) findViewById(R.id.textViewList);

        //get the list
         StringBuilder str = new StringBuilder();
         str.append("Your nums: ");

         for (Double d : list) {
             str.append(d);
             str.append("; ");
         }

         txt.setText(str);
    }




}