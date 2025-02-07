package io.github.calc_basic;

import android.view.View;
import android.widget.TextView;

public class Buttons implements View.OnClickListener,  View.OnLongClickListener {

    TextView tv;
    String text;

    public Buttons(TextView tv, String input){
        this.tv = tv;
        this.text = input;
    }

    public Buttons(TextView tv){
        this.tv = tv;
        this.text = "";
    }


    @Override
    public void onClick(View view) {

        if (tv.getText().toString().equals("Request")){
            tv.setText(text);
        }
        else {
            String response = tv.getText().toString() + text;
            tv.setText(response);
        }

    } // End of onClick Method

    @Override
    public boolean onLongClick(View v) {
        if (tv.getText().toString().equals("Request")){
            tv.setText(text);
        }
        else {
            String response = tv.getText().toString() + text;
            tv.setText(response);
        }
        return true;
    }
} // End of Button Class



