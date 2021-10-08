package FactoryMethodPattern;

import java.awt.*;

public class Triangle extends Shape {
    public Triangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea(){
        double a = Math.sqrt((double)(Math.pow(points[0].x - points[1].x, 2) +  Math.pow(points[0].y - points[1].y, 2)));
        double b = Math.sqrt((double)(Math.pow(points[0].x - points[2].x, 2) +  Math.pow(points[0].y - points[2].y, 2)));
        double c = Math.sqrt((double)(Math.pow(points[1].x - points[2].x, 2) +  Math.pow(points[1].y - points[2].y, 2)));
        double s = (a+b+c)/2;

        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }
}
