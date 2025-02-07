package io.github.calc_basic;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    int n = 0;
    double meanX;
    double meanY;

    // Sample standard deviation of x or y
    double Sx;
    double Sy;

    // Population standard deviation of x or y ( σx or σy )
    double sigmaX;
    double sigmaY;

    // Sum of all x or y values ( Σx or Σy )
    double sumX;
    double sumY;

    // Sum of all x^2 or y^2 values ( Σx^2 or Σy^2 )
    double sumX2;
    double sumY2;

    // Sum of ( x*y ) for all xy pairs ( Σxy )
    double sumXY;

    // Linear Regression Slope
    double a;

    // Linear Regression Y-Intercept
    double b;

    // Correlation coefficient
    double r;

    ArrayList<Point> Points;

    public Statistics(ArrayList<Point> p){

        // Acquire Coordinate Pairs (X,Y)
        this.Points = p;

        findN();

        findMeanX();
        findMeanY();

        findSumX2();
        findSumY2();

        findSumXY();

        findSigmaX();
        findSigmaY();

        findSX();
        findSY();

        findR();
        findA();
        findB();
    }

    public void findN(){
        int total = 0;
        for(int i = 0; i < Points.size(); i++){
            total += Points.get(i).xf;
        }
        this.n = total;
    }

    public void findMeanX(){
        findSumX();
        meanX = (sumX) / ((double) n);
    }

    public void findMeanY(){
        findSumY();
        meanY = (sumY) / ((double) n);
    }

    // Sum of all x values ( Σx )
    public void findSumX(){
        for(int i = 0; i< Points.size(); i++){
            sumX += (Points.get(i).x * Points.get(i).xf);
        }
    }

    // Sum of all y values ( Σy )
    public void findSumY(){
        for(int i = 0; i< Points.size(); i++){
            sumY += (Points.get(i).y * Points.get(i).yf);
        }
    }

    // Sum of all x^2 values ( Σx^2 )
    public void findSumX2(){
        for(int i = 0; i< Points.size(); i++){
            double Xi =Points.get(i).x;
            sumX2 += ( Math.pow(Xi, 2) * Points.get(i).xf);
        }
    }

    // Sum of all y^2 values ( Σy^2 )
    public void findSumY2(){
        for(int i = 0; i< Points.size(); i++){
            double Yi =Points.get(i).y;
            sumY2 += ( Math.pow(Yi, 2) * Points.get(i).yf);
        }
    }

    // Sum of ( x*y ) for all xy pairs ( Σxy )
    public void findSumXY() {
        for (int i = 0; i < Points.size(); i++) {
            double x = Points.get(i).x;
            double y = Points.get(i).y;
            sumXY += (x*y);
        }
    }

    // Find Population standard deviation of x ( σx )
    public void findSigmaX(){
        // μ = The Population Mean
        double mew = meanX;

        // N = Total number of observations / data points.
        double N = this.n;

        // ( (Σ(x-μ)^2) / N )
        double radicalInterior;

        // Σ(x-μ)^2)
        double sumXiMinusMewSquared = 0;

        // Loop to summate Σ(x-μ)^2)
        for(int i = 0; i < Points.size(); i++){

            // X = The Value in the Data Distribution
            double Xi = Points.get(i).x;

            // (x-μ)^2)
            sumXiMinusMewSquared += Math.pow((Xi - mew), 2);
        }

        // ( (Σ(x-μ)^2) / N )
        radicalInterior = sumXiMinusMewSquared / N;

        // σ = √ ( (Σ(x-μ)^2) / N )
        sigmaX = Math.sqrt(radicalInterior);
    }

    // Find Population standard deviation of y ( σy )
    public void findSigmaY(){

        // μ = The Population Mean
        double mew = meanY;

        // N = Total number of observations / data points.
        double N = this.n;

        // ( (Σ(y-μ)^2) / N )
        double radicalInterior;

        // Σ(y-μ)^2)
        double sumYiMinusMewSquared = 0;

        // Loop to summate Σ(y-μ)^2)
        for(int i = 0; i < Points.size(); i++){

            // Y = The Value in the Data Distribution
            double Yi = Points.get(i).y;

            // (x-μ)^2)
            sumYiMinusMewSquared += Math.pow((Yi - mew), 2);
        }

        // ( (Σ(y-μ)^2) / N )
        radicalInterior = sumYiMinusMewSquared / N;

        // σ = √ ( (Σ(y-μ)^2) / N )
        sigmaY = Math.sqrt(radicalInterior);
    }

    // Sample standard deviation of x
    public void findSX(){

        // x̄ = The Sample Mean
        double xBar = meanX;

        // N = Total number of observations / data points.
        double N = (double) this.n-1;

        // ( (Σ(x-x̄)^2) / N-1 )
        double radicalInterior;

        // Σ(x-x̄)^2)
        double sumXiMinusXBarSquared = 0;

        // Loop to summate Σ(x-x̄)^2)
        for(int i = 0; i < Points.size(); i++){

            // X = The Value in the Data Distribution
            double Xi = Points.get(i).x;

            // (x-x̄)^2)
            sumXiMinusXBarSquared += Math.pow((Xi - xBar), 2);
        }

        // ( (Σ(x-x̄)^2) / N-1 )
        radicalInterior = sumXiMinusXBarSquared / N;

        // σ = √ ( (Σ(x-x̄)^2) / N-1 )
        Sx = Math.sqrt(radicalInterior);
    }

    // Sample standard deviation of y
    public void findSY(){

        // ȳ = The Sample Mean
        double yBar = meanY;

        // N = Total number of observations / data points - 1.
        double N = (double) this.n -1;

        // ( (Σ(y-ȳ)^2) / N-1 )
        double radicalInterior;

        // Σ(y-ȳ)^2)
        double sumYiMinusYBarSquared = 0;

        // Loop to summate Σ(y-ȳ)^2)
        for(int i = 0; i < Points.size(); i++){

            // X = The Value in the Data Distribution
            double Yi = Points.get(i).y;

            // (y-ȳ)^2)
            sumYiMinusYBarSquared += Math.pow((Yi - yBar), 2);
        }

        // ( (Σ(y-ȳ)^2) / N-1 )
        radicalInterior = sumYiMinusYBarSquared / N;

        // σ = √ ( (Σ(y-ȳ)^2) / N-1 )
        Sy = Math.sqrt(radicalInterior);
    }

    // Finds the Slope of the Line with linear regression
    public void findA(){a = r * ( Sy / Sx);}

    // Finds the Y-Intercept and assigns the value to B given the first coordinate stored
    public void findB(){
        double y = Points.get(0).y;
        double x =Points.get(0).x;
        b = y - (a * x);
    }

    // Find the correlation coefficient
    public void findR(){

        double sumXMinusMeanX;
        double sumYMinusMeanY;

        double numerator = 0;
        double denominator;

        for(int i = 0; i < Points.size(); i++){
            sumXMinusMeanX = (Points.get(i).x - meanX);
            sumYMinusMeanY = (Points.get(i).y - meanY);
            numerator += (sumXMinusMeanX * sumYMinusMeanY);
        }

        double sumXMinusMeanXSquared = 0;
        double sumYMinusMeanYSquared  = 0;

        for(int i = 0; i < Points.size(); i++){
            sumXMinusMeanXSquared += (Math.pow((Points.get(i).x - meanX),2));
            sumYMinusMeanYSquared += (Math.pow((Points.get(i).y - meanY),2));
        }
        denominator = Math.sqrt(sumXMinusMeanXSquared * sumYMinusMeanYSquared);

        r = numerator/denominator;
    }

    // Given a y value calculate a predicted x value from a and b
    public double predictX(double y){return (  ((r*Sx)/Sy) * (y-meanY) ) + meanX;}

    // Given a x value calculate a predicted x value from a and b
    public double predictY(double x){return (  ((r*Sy)/Sx) * (x-meanX) ) + meanY;}

    // Export All Points Data to a format saved as CSV
    public List<String[]> toCSV(){
        List<String[]> data = new ArrayList<>();
        for (int i = 0; i < Points.size(); i++) {data.add(Points.get(i).toCSV());}
        return data;
    }
}