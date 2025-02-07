package io.github.calc_basic;

import androidx.annotation.NonNull;

public class Point {

    double x;
    double y;
    int xf;
    int yf;

    public Point(double x, int xf, double y, int yf){
        this.x = x;
        this.xf = xf;
        this.y = y;
        this.yf = yf;
    }

    @NonNull
    public String toString(){
        String s;
        try{s = "X: " + x + " Y: " + " ƒ: " + xf + " ýƒ: " + yf; return s;}
        catch (Throwable t){return "";}
    }

    public String[] toCSV(){
        return new String[]
                {String.valueOf(x),  String.valueOf(xf), String.valueOf(y), String.valueOf(yf)};
    }
}