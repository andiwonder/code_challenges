package com.company;

public interface Shape {
    float getArea();
    float getPerimeter();

    String toString();
}

class Rectangle implements Shape {
    private float length, width, area, perimeter;

    public Rectangle(float length, float width){
        this.length = length;
        this.width = width;
    }

    @Override
    public float getArea() {
        this.area = this.length * this.width;
        return this.area;
    }

    @Override
    public float getPerimeter() {
        this.perimeter = 2 * (this.length + this.width);
        return this.perimeter;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}

class Square extends Rectangle {

    public Square(float side) {
        super(side, side);
    }

    @Override
    public float getArea() {
        return super.getArea();
    }

    @Override
    public float getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}






