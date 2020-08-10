package ru.disanger.learning.learnJavaST;

import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistanceFirstCloserToZero() {
        Point p1 = new Point(1,2);
        Point p2 = new Point(7,4);
        assert p1.distanceTo(p2) == 6.324555320336759;
    }

    @Test
    public void testDistanceSecondCloserToZero() {
        Point p1 = new Point(10,12);
        Point p2 = new Point(2,3);
        assert p1.distanceTo(p2) == 12.041594578792296;
    }

    @Test
    public void testDistancePointsLowerZero() {
        Point p1 = new Point(-1,-2);
        Point p2 = new Point(-7,-4);
        assert p1.distanceTo(p2) == 6.324555320336759;
    }
}