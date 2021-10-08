package FactoryMethodPattern;

import java.awt.*;

public class Trapezoid extends Shape {
    public Trapezoid(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea(){
        int upperEdgeLength = points[3].x - points[0].x;
        int lowerEdgeLength = points[1].x - points[2].x;
        int height = points[0].y - points[1].y;

        return (upperEdgeLength + lowerEdgeLength) * height / 2;
    }
}
