package io.github.calc_basic;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Clear implements View.OnClickListener, View.OnLongClickListener {

    TextView tv;
    TextView tv2;
    String text;

    public Clear(TextView tv){
        this.tv = tv;
        this.text = "";
    }

    public Clear(TextView tv, TextView tv2){
        this.tv = tv;
        this.tv2 = tv2;
        this.text = "";
    }


    @Override
    public void onClick(View view) {
        tv.setText(text);
    }

    @Override
    public boolean onLongClick(View v) {
        tv.setText(text);
        tv2.setText(text);
        return true;
    }

    @Override
    public boolean onLongClickUseDefaultHapticFeedback(@NonNull View v) {
        return View.OnLongClickListener.super.onLongClickUseDefaultHapticFeedback(v);
    }
}
