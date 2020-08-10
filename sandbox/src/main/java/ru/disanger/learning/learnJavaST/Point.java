package ru.disanger.learning.learnJavaST;

public class Point {
    double x, y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point p2) {
        return Math.sqrt(Math.pow(p2.x - this.x, 2) + Math.pow(p2.y - this.y, 2));
    }
}
