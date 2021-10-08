package FactoryMethodPattern;

import java.awt.*;

public class RightTriangle extends Shape {
    public RightTriangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea(){
        int width = points[2].x - points[1].x;
        int height = points[0].y - points[2].y;

        return width * height / 2;
    }
}
