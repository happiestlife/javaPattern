package FactoryMethodPattern;

import java.awt.*;

public class Rectangle extends Shape {
    public Rectangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea(){
        int width = points[1].x - points[0].x;
        int height = points[0].y - points[1].y;

        return width*height;
    }
}
