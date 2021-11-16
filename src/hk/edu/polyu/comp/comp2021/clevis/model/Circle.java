package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Figure_geo {
    public Circle(String name, int zOrder, double x, double y, double r){
        super(name,zOrder , x, y);
        this.r = r;
    }

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
            else{
                throw new FigureNotInGridError();
            }
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
        double error = 0.05;
        if(Math.sqrt((Math.pow((this.getX()-x),2) + Math.pow((this.getY()-y),2))) < (this.getR() + error)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    void draw(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        Ellipse2D circle = new Ellipse2D.Double(getX() - getR(), getY() - getR(), getR() * 2.0, getR() * 2.0);
        g.draw(circle);
    }


    public boolean intersect(Circle other) {
        boolean intersect =false;
        double d=Math.sqrt(Math.pow(this.getX()-other.getX(),2)+Math.pow(this.getY()-other.getY(),2));
        if(d<=(this.getR()+ other.getR()) && d>=Math.abs(this.getR()- other.getR()) && (d!=0 || this.getR()!=other.getR() )){
            intersect=true;
        }
        return intersect;
    }

    static class FigureNotInGridError extends Error{}
}
