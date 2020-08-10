package ru.disanger.learning.learnJavaST;

class Homework2 {
    public static void main(String[] args) {
    Point p1 = new Point(1,1);
    Point p2 = new Point(5,5);

        System.out.println("Distance between first point (" + p1.x + "," + p1.y +
                ") and second point (" + p2.x + "," + p2.y + ") is " + p1.distanceTo(p2));
    }
}