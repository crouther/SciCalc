package io.github.calc_basic;

import android.view.View;
import android.widget.TextView;

public class Delete implements View.OnClickListener {
    TextView request;
    public Delete(TextView tv){ this.request = tv;}
    @Override
    public void onClick(View view) {
        if(request.getText().toString().length() <= 1) {request.setText("");}
        else{
            String s = request.getText().toString();
            request.setText(s.substring(0, s.length() - 1));
        }
    }
}