package io.github.calc_basic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Button Rows

    Button onOff, buttonMEM, buttonMODE, delete, clear;
    Button more, button7, button8, button9, buttonDivide;
    Button buttonOpenParenthesis, button4, button5, button6, buttonMultiply;
    Button buttonCloseParenthesis,  button1, button2, button3, buttonMinus;
    Button buttonEqual, button0, buttonDecimal, buttonNegative, buttonPlus;

    TextView request, answer;

    LinearLayout altRow1, altRow2;
    LinearLayout memRow1, memRow2, memRow3;
    LinearLayout modeRow1, modeRow2;
    LinearLayout moreRow1, moreRow2;
    LinearLayout angleRow1, angleRow2;
    LinearLayout trigRow1, trigRow2;
    LinearLayout prbRow1, prbRow2;
    LinearLayout expRow1, expRow2;
    LinearLayout statRow1, statRow2;

    // MORE ROWS
    //Button ans, abc, de, fd, k;
    Button angle, trig, prb, exp, stat;

    // ANGLE ROWS
    //Button dms, rpr, rpo, prx, pry;
    //Button degree, minute, second, radian, gradian;

    // EXPONENT ROWS
    //Button tenX, ex, sqrt, xsqrt, ee;
    //Button log, ln, xPow2, pow, inverse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // INPUT / OUTPUT TEXTVIEWS
        request = findViewById(R.id.request);
        answer = findViewById(R.id.answer);

        // BLANK ROWS
        altRow1 = findViewById(R.id.altRow1);
        altRow2 = findViewById(R.id.altRow2);
        altRow2.setVisibility(View.INVISIBLE);
        altRow1.setVisibility(View.INVISIBLE);

        // ON-OFF BUTTON
        onOff = findViewById(R.id.onOff);
        onOff.setOnClickListener(v->{
            clearRows();
            altRow2.setVisibility(View.INVISIBLE);
            altRow1.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "HOLD TO CLOSE", Toast.LENGTH_SHORT).show();
        });
        onOff.setOnLongClickListener(v -> {
            Toast.makeText(this, "OFF PRESSED", Toast.LENGTH_SHORT).show();
            finish();
            System.exit(0);
            return true;
        });

        // MEM BUTTON
        memRow1 = findViewById(R.id.memRow1);
        memRow2 = findViewById(R.id.memRow2);
        memRow3 = findViewById(R.id.memRow3);

        buttonMEM = findViewById(R.id.mem);
        buttonMEM.setOnClickListener( v-> {
            if(memRow1.getVisibility() == View.GONE) {
                clearRows();
                memRow1.setVisibility(View.VISIBLE);
                memRow3.setVisibility(View.VISIBLE);
            }
            else{
                clearRows();
                altRow2.setVisibility(View.INVISIBLE);
                altRow1.setVisibility(View.INVISIBLE);
            }
        });

        // MODE BUTTON
        modeRow1 = findViewById(R.id.modeRow1);
        modeRow2 = findViewById(R.id.modeRow2);
        buttonMODE = findViewById(R.id.mode);
        buttonMODE.setOnClickListener(v->{
            if(modeRow1.getVisibility() == View.GONE) {
                clearRows();
                modeRow1.setVisibility(View.VISIBLE);
                modeRow2.setVisibility(View.VISIBLE);
            }
            else{
                clearRows();
                altRow2.setVisibility(View.INVISIBLE);
                altRow1.setVisibility(View.INVISIBLE);
            }
        });

        // DELETE BUTTON
        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new Delete(request));

        // CLEAR BUTTON
        clear = findViewById(R.id.clear);
        clear.setOnClickListener(new Clear(request));
        clear.setOnLongClickListener(new Clear(request, answer));

        // MORE BUTTON ROWS
        moreRow1 = findViewById(R.id.moreRow1);
        moreRow2 = findViewById(R.id.moreRow2);

        // MORE BUTTON
        more = findViewById(R.id.more);
        more.setOnClickListener( v-> {

            if(moreRow2.getVisibility() == View.GONE){

                altRow2.setVisibility(View.GONE);
                altRow1.setVisibility(View.GONE);

                clearRows();

                moreRow2.setVisibility(View.VISIBLE);
                moreRow1.setVisibility(View.VISIBLE);
            }

            else{
                clearRows();
                altRow2.setVisibility(View.INVISIBLE);
                altRow1.setVisibility(View.INVISIBLE);
            }
        });

        // ANGLE ROWS AND BUTTONS
        angleRow1 = findViewById(R.id.angleRow1);
        angleRow2 = findViewById(R.id.angleRow2);
        angle = findViewById(R.id.angle);
        angle.setOnClickListener( v-> {
            clearRows();
            angleRow2.setVisibility(View.VISIBLE);
            angleRow1.setVisibility(View.VISIBLE);
        });

        // TRIGONOMETRIC ROW AND BUTTONS
        trigRow2 = findViewById(R.id.trigRow2);
        trigRow1 = findViewById(R.id.trigRow1);
        trig = findViewById(R.id.trig);
        trig.setOnClickListener( v-> {
            clearRows();
            trigRow2.setVisibility(View.VISIBLE);
            trigRow1.setVisibility(View.VISIBLE);
        });

        // PROBABILITY ROW AND BUTTONS
        prbRow2 = findViewById(R.id.prbRow2);
        prbRow1 = findViewById(R.id.prbRow1);
        prb = findViewById(R.id.prb);
        prb.setOnClickListener( v-> {
            clearRows();
            prbRow2.setVisibility(View.INVISIBLE);
            prbRow1.setVisibility(View.VISIBLE);
        });

        // STATISTICS ROW AND BUTTONS
        statRow2 = findViewById(R.id.statRow2);
        statRow1 = findViewById(R.id.statRow1);
        stat = findViewById(R.id.stat);
        stat.setOnClickListener( v-> {
            clearRows();
            statRow2.setVisibility(View.VISIBLE);
            statRow1.setVisibility(View.VISIBLE);
        });


        // EXPONENT ROW and BUTTONS
        expRow1 = findViewById(R.id.expRow1);
        expRow2 = findViewById(R.id.expRow2);
        exp = findViewById(R.id.exp);
        exp.setOnClickListener( v->{
            clearRows();
            expRow2.setVisibility(View.VISIBLE);
            expRow1.setVisibility(View.VISIBLE);

        });

        // NUMBERED BUTTONS

        button1 = findViewById(R.id.one);
        button1.setOnClickListener(new Buttons(request, "1"));

        button2 = findViewById(R.id.two);
        button2.setOnClickListener(new Buttons(request, "2"));

        button3 = findViewById(R.id.three);
        button3.setOnClickListener(new Buttons(request, "3"));

        button4 = findViewById(R.id.four);
        button4.setOnClickListener(new Buttons(request, "4"));

        button5 = findViewById(R.id.five);
        button5.setOnClickListener(new Buttons(request, "5"));

        button6 = findViewById(R.id.six);
        button6.setOnClickListener(new Buttons(request, "6"));

        button7 = findViewById(R.id.seven);
        button7.setOnClickListener(new Buttons(request, "7"));

        button8 = findViewById(R.id.eight);
        button8.setOnClickListener(new Buttons(request, "8"));

        button9 = findViewById(R.id.nine);
        button9.setOnClickListener(new Buttons(request, "9"));

        button0 = findViewById(R.id.zero);
        button0.setOnClickListener(new Buttons(request, "0"));

        /// FUNDAMENTAL OPERATIONS

        buttonEqual = findViewById(R.id.equal);

        buttonPlus = findViewById(R.id.plus);
        buttonPlus.setOnClickListener(view -> {

            String currentRequest = request.getText().toString();
            boolean leaveBlank = currentRequest.equals("Request");
            boolean overwrite = false;
            String output;

            if (currentRequest.isEmpty()) leaveBlank = true;
            else if (currentRequest.length() > 1) {
                String lastChar = currentRequest.substring(currentRequest.length() - 1);
                if (lastChar.equals("+")) overwrite = true;
                if (lastChar.equals("-")) overwrite = true;
                if (lastChar.equals("/")) overwrite = true;
                if (lastChar.equals("*")) overwrite = true;
                if (lastChar.equals("÷")) overwrite = true;
                if (lastChar.equals("⁻")) overwrite = true;
            }

            if (overwrite) {
                output = currentRequest.substring(0, currentRequest.length() - 1) + "+";
            } else {
                output = request.getText().toString() + "+";
            }

            if (leaveBlank) output = "";

            request.setText(output);
        });

        buttonMinus = findViewById(R.id.minus);
        buttonMinus.setOnClickListener(view -> {

            String currentRequest = request.getText().toString();
            boolean leaveBlank = currentRequest.equals("Request");
            boolean overwrite = false;
            String output;

            if (currentRequest.isEmpty()) leaveBlank = true;
            else if (currentRequest.length() > 1) {
                String lastChar = currentRequest.substring(currentRequest.length() - 1);
                if (lastChar.equals("+")) overwrite = true;
                if (lastChar.equals("-")) overwrite = true;
                if (lastChar.equals("/")) overwrite = true;
                if (lastChar.equals("*")) overwrite = true;
                if (lastChar.equals("÷")) overwrite = true;
                if (lastChar.equals("⁻")) overwrite = true;
            }

            if (overwrite) {
                output = currentRequest.substring(0, currentRequest.length() - 1) + "-";
            } else {
                output = request.getText().toString() + "-";
            }

            if (leaveBlank) output = "";

            request.setText(output);
        });

        buttonDivide = findViewById(R.id.divide);
        buttonDivide.setOnClickListener(view -> {

            String currentRequest = request.getText().toString();
            boolean leaveBlank = currentRequest.equals("Request");
            boolean overwrite = false;
            String output;

            if (currentRequest.isEmpty()) leaveBlank = true;
            else if (currentRequest.length() > 1) {
                String lastChar = currentRequest.substring(currentRequest.length() - 1);
                if (lastChar.equals("+")) overwrite = true;
                if (lastChar.equals("-")) overwrite = true;
                if (lastChar.equals("/")) overwrite = true;
                if (lastChar.equals("*")) overwrite = true;
                if (lastChar.equals("÷")) overwrite = true;
                if (lastChar.equals("⁻")) overwrite = true;
            }

            if (overwrite) {
                output = currentRequest.substring(0, currentRequest.length() - 1) + "÷";
            } else {
                output = request.getText().toString() + "÷";
            }

            if (leaveBlank) output = "";

            request.setText(output);
        });

        buttonMultiply = findViewById(R.id.multiply);
        buttonMultiply.setOnClickListener(view -> {

            String currentRequest = request.getText().toString();
            boolean leaveBlank = currentRequest.equals("Request");
            boolean overwrite = false;
            String output;

            if (currentRequest.isEmpty()) leaveBlank = true;
            else if (currentRequest.length() > 1) {
                String lastChar = currentRequest.substring(currentRequest.length() - 1);
                if (lastChar.equals("+")) overwrite = true;
                if (lastChar.equals("-")) overwrite = true;
                if (lastChar.equals("/")) overwrite = true;
                if (lastChar.equals("*")) overwrite = true;
                if (lastChar.equals("÷")) overwrite = true;
                if (lastChar.equals("⁻")) overwrite = true;
            }

            if (overwrite) {
                output = currentRequest.substring(0, currentRequest.length() - 1) + "*";
            } else {
                output = request.getText().toString() + "*";
            }

            if (leaveBlank) output = "";

            request.setText(output);
        });

        buttonOpenParenthesis = findViewById(R.id.openParenthesis);
        buttonOpenParenthesis.setOnClickListener(new Buttons(request, "("));

        buttonCloseParenthesis = findViewById(R.id.closeParenthesis);
        buttonCloseParenthesis.setOnClickListener(view -> {

            String currentRequest = request.getText().toString();

            boolean leaveBlank = currentRequest.equals("Request");
            if (currentRequest.isEmpty()) leaveBlank = true;

            String output = currentRequest;
            if (leaveBlank) {
                output = "";
            } else {
                output = output + ")";
            }

            request.setText(output);
        });

        buttonDecimal = findViewById(R.id.decimal);
        buttonDecimal.setOnClickListener(view -> {

            String currentRequest = request.getText().toString();
            boolean isEmpty = currentRequest.equals("Request");
            boolean overwrite = false;
            String output;

            if (currentRequest.isEmpty()) isEmpty = true;
            else{
                String lastChar = currentRequest.substring(currentRequest.length() - 1);
                if (lastChar.equals(".")) overwrite = true;
            }

            if (overwrite) {
                output = currentRequest.substring(0, currentRequest.length() - 1) + ".";
            } else {
                output = request.getText().toString() + ".";
            }

            if (isEmpty) output = "0.";

            request.setText(output);
        });

        buttonNegative = findViewById(R.id.negative);
        buttonNegative.setOnClickListener(view -> {

            String currentRequest = request.getText().toString();
            boolean overwrite = false;
            String output;

            if (currentRequest.isEmpty()) {
                //noinspection UnusedAssignment
                output = "⁻";
            } else if (currentRequest.length() == 1) {
                if (currentRequest.equals("⁻")) overwrite = true;
            } else {
                String lastChar = currentRequest.substring(currentRequest.length() - 1);

                if (lastChar.equals("+")) overwrite = true;
                if (lastChar.equals("-")) overwrite = true;
                if (lastChar.equals("/")) overwrite = true;
                if (lastChar.equals("*")) overwrite = true;
                if (lastChar.equals("÷")) overwrite = true;
                if (lastChar.equals("⁻")) overwrite = true;
            }
            if (overwrite) {
                output = currentRequest.substring(0, currentRequest.length() - 1) + "⁻";
            } else {
                output = request.getText().toString() + "⁻";
            }

            request.setText(output);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void clearRows(){
        altRow2.setVisibility(View.GONE);
        altRow1.setVisibility(View.GONE);
        moreRow2.setVisibility(View.GONE);
        moreRow1.setVisibility(View.GONE);
        angleRow2.setVisibility(View.GONE);
        angleRow1.setVisibility(View.GONE);
        trigRow2.setVisibility(View.GONE);
        trigRow1.setVisibility(View.GONE);
        prbRow2.setVisibility(View.GONE);
        prbRow1.setVisibility(View.GONE);
        expRow2.setVisibility(View.GONE);
        expRow1.setVisibility(View.GONE);
        statRow2.setVisibility(View.GONE);
        statRow1.setVisibility(View.GONE);
        memRow3.setVisibility(View.GONE);
        memRow2.setVisibility(View.GONE);
        memRow1.setVisibility(View.GONE);
        modeRow2.setVisibility(View.GONE);
        modeRow1.setVisibility(View.GONE);
    }

} // End MainActivity