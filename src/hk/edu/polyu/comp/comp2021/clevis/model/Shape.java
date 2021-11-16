package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;

abstract public class Shape {
    public Shape(String name, int zOrder) {
        //ecrire dans les fichiers txt et html
        // creer une figure generale avec les parmètres generaux
        this.name=name;
        this.zOrder = zOrder;
    }

    abstract public void move(double dx, double dy);

    private String name;

    private int zOrder = 0;

    public int getzOrder() {
        return zOrder;
    }

    public String getName() {
        return name;
    }

    abstract void listFigure();


    abstract public double max_coordinate_x();
    abstract public double max_coordinate_y();
    abstract public double min_coordinate_x();
    abstract public double min_coordinate_y();

    abstract public boolean distancePoint(double x, double y);

    abstract void draw(Graphics g1);



}
