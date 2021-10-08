package FactoryMethodPattern;
import java.awt.Point;

public abstract class Shape{
    Point[] points;
    String type;

    public Shape(String type, Point[] points){
        this.type = type;
        this.points = points;
    }

    @Override
    public String toString(){
        String str = type+"\n";
        int i = 0;
        for(Point p : points)
            str += "P" + i++ + ": java.awt.Point[x=" + p.getX() + ",y=" + p.getY() + "]\n";
        str += calcArea() + "\n";
        return str;
    }

    public abstract double calcArea();
}
