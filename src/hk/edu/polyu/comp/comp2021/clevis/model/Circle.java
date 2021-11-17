package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Creation of a circle which is a child of Figure_geo
 */
public class Circle extends Figure_geo {
    /**
     * Constructor of the Circle
     * @param name : name of the circle Exemple : cir
     * @param zOrder : Zorder of this circle
     * @param x : x coordinate of this circle
     * @param y : y coordinate of this circle
     * @param r : radius of the circle
     */
    public Circle(String name, int zOrder, double x, double y, double r){
        super(name,zOrder , x, y);
        this.r = r;
    }

    /**
     * radius getter
     * @return radius of the circle
     */
    public double getR() {
        return r;
    }

    private double r;

    @Override
    public void move(double dx, double dy) {
        try {
            if (getX()+dx > 0 && getY()+dy>0){
                setX(getX()+dx);
                setY(getY()+dy);
                System.out.println("The new Circle coordinates are : (" + this.getX() + "," + this.getY() + ")");
            }
            else throw new FigureNotInGridError();
        }
        catch (FigureNotInGridError f){
            System.out.println("The new coordinates are not in the grid");
        }
    }

    @Override
    public void listFigure() {
        System.out.print("Circle Name : " + this.getName() + " | ");
        System.out.print("Radius : " + this.getR() + " | ");
        System.out.println("Coordinates : (" + this.getX() + "," + this.getY() + ") | ");
    }

    @Override
    public double max_coordinate_x() {
        return (getX()+r);
    }

    @Override
    public double max_coordinate_y() {
        return (getY()+r);
    }

    @Override
    public double min_coordinate_x() {
        return (getX()-r);
    }

    @Override
    public double min_coordinate_y() {
        return (getY()-r);
    }

    @Override
    public boolean distancePoint(double x, double y) {
        return Math.sqrt((Math.pow((this.getX() - x), 2) + Math.pow((this.getY() - y), 2))) < (this.getR() + error);
    }

    @Override
    void draw(Graphics g1) {
        final int multiplyby2 = 2;
        Graphics2D g = (Graphics2D) g1;
        Ellipse2D circle = new Ellipse2D.Double(getX() - getR(), getY() - getR(), getR() * multiplyby2, getR() * multiplyby2);
        g.draw(circle);
    }

    /**
     * Intersection of this circle with other
     * @param other : An other circle
     * @return : Intersection True or False
     */
    public boolean intersect(Circle other) {
        double d=Math.sqrt(Math.pow(this.getX()-other.getX(),2)+Math.pow(this.getY()-other.getY(),2));
        return d <= (this.getR() + other.getR()) && d >= Math.abs(this.getR() - other.getR()) && (d != 0 || this.getR() != other.getR());
    }
    private final double error = 0.05;


    /**
     * Error if the grid is not present in the grid
     */
    static class FigureNotInGridError extends Error{}
}
