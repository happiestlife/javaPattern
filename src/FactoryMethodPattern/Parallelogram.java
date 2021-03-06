package FactoryMethodPattern;

import java.awt.*;

public class Parallelogram extends Shape {
    public Parallelogram(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea(){
        int width = points[3].x - points[0].x;
        int height = points[0].y - points[2].y;

        return width * height;
    }
}
