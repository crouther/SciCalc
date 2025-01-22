package io.github.calc_basic;

public class Fraction {
    Fraction(){}

    /**
     * Java method to calculate lowest common multiplier of two numbers
     *
     * @param a
     * @param b
     * @return LCM of two numbers
     */
    public static int LCM(int a, int b) {
        return (a * b) / GCF(a, b);
    }

    /**
     * Java method to calculate greatest common factor of two numbers
     *
     * @param a
     * @param b
     * @return GCF of two numbers using Euclid's algorithm
     */
    public static int GCF(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return (GCF(b, a % b));
        }
    }

    // Notes: https://javarevisited.blogspot.com/2016/07/how-to-calculate-gcf-and-lcm-of-two-numbers-in-java-example.html

    public String LeastCommonDivisor(String s){
        String ans = s;
        return ans;
    }

    public String GreatestCommonDivisor(String s){
        String ans = s;
        return ans;
    }
}
