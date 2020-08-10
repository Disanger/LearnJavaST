package ru.disanger.learning.learnJavaST;

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Square s = new Square(4);
        System.out.println("Area of square with sides "
                + s.l + " is " + s.area());

        Rectangle r = new Rectangle(4,6);
        System.out.println("Area of rectangle with sides "
                + r.a + " and " + r.b + " is " + r.area());
    }
}