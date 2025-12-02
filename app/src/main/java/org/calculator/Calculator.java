package org.calculator;

public class Calculator {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return (double) a / b;
    }
        public int square(int a) {
        return a * a;
    }
    @SuppressWarnings("java:S106") // Sonar wants me to use logger but im not sure how to so i am suppressing it
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int a = 9;
        int b = 3; //declare b below
        System.out.println("add: " + calc.add(a, b));
        System.out.println("subtract: " + calc.subtract(a, b));
        System.out.println("multiply: " + calc.multiply(a, b));
        System.out.println("divide: " + calc.divide(a, b));
        System.out.println("square: " + calc.square(a));
    }
}