package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rectangle extends Figure_geo {
    public Rectangle(String name, int zOrder, double x, double y, double w, double h){
        super(name, zOrder, x, y);
        this.w=w;
        this.h=h;
    }

    public double getH() {
        return h;
    }

    public double getW() {
        return w;
    }

    private double w;
    private double h;

    @Override
    public void move(double dx, double dy) {
        try{
            if ((getX()+dx > 0 && getY()+dy>0)) {
                setX(getX()+dx);
                setY(getY()+dy);
                System.out.println("The new Rectangle coordinates are : (" + this.getX() + "," + this.getY() + ")");
            }
            else{
                throw new Circle.FigureNotInGridError();
            }
        }
        catch (Circle.FigureNotInGridError f){
        System.out.println("The new coordinates are not in the grid");
        }
    }

    @Override
    public void listFigure() {
        System.out.print("Rectangle Name : " + this.getName() + " | ");
        System.out.print("Height : " + this.getH() + " | ");
        System.out.print("Width : " + this.getW() + " | ");
        System.out.println("Coordinate Top Left Corner : (" + this.getX() + "," + this.getY() + ") | ");

    }

    @Override
    public double max_coordinate_x() {
        return (getX()+w);
    }

    @Override
    public double max_coordinate_y() {
        return getY()+h;
    }

    @Override
    public double min_coordinate_x() {
        return getX();
    }

    @Override
    public double min_coordinate_y() {
        return (getY());
    }

    @Override
    public boolean distancePoint(double x, double y) {

        if ((x > (this.getX() - error) && x < (this.getX() + this.getW() + error)) && (y>(this.getY() - error) && y < (this.getY() + this.getH() + error))) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    void draw(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        Rectangle2D rect = new Rectangle2D.Double(getX(), getY(), getW(), getH());
        g.draw(rect);
    }

    public Line transformRecInLine1(){
        String line1 = "";
        Line li1 = new Line(line1, 0, this.getX(), this.getY(), this.getX()+ this.getW(), this.getY());
        return li1;
    }

    public Line transformRecInLine2(){
        String line2 = "";
        Line li2 = new Line(line2, 0, this.getX(), this.getY(), this.getX(), this.getY()+ this.getH());
        return li2;
    }

    public Line transformRecInLine3(){
        String line3 = "";
        Line li3 = new Line(line3, 0, this.getX(), this.getY()+this.getH(), this.getX()+ this.getW(), this.getY()+ this.getH());
        return li3;
    }

    public Line transformRecInLine4(){
        String line4 = "";
        Line li4 = new Line(line4, 0, this.getX()+this.getW(), this.getY(),this.getX()+ this.getW(), this.getY()+ this.getH());
        return li4;
    }

    private final double error = 0.05;



}
