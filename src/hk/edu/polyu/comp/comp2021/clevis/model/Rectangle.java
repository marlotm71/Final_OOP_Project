package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Class Rectangle is a child of figure_geo, we just add a width and a height
 */
public class Rectangle extends Figure_geo {

    /**
     * Rectangle Constructor
     * @param name : name of the rectangle
     * @param zOrder : Z order of the rectangle
     * @param x : x coordinate of the rectangle
     * @param y : y coordinate of the rectangle
     * @param w : width of the rectangle
     * @param h ; height of the rectangle
     */
    public Rectangle(String name, int zOrder, double x, double y, double w, double h){
        super(name, zOrder, x, y);
        this.w=w;
        this.h=h;
    }

    /**
     * getter of the height of the rectangle
     * @return height of the rectangle
     */
    public double getH() {
        return h;
    }

    /**
     * getter of the width of the rectangle
     * @return width of the rectangle
     */
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
                throw new Rectangle.FigureNotInGridError();
            }
        }
        catch (Rectangle.FigureNotInGridError f){
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
    /**
     * One side of the rectangle is transformed in line
     * @return Line issued from side 1 of the rectangle
     */
    public Line transformRecInLine1(){
        String line1 = "";
        Line li1 = new Line(line1, 0, this.getX(), this.getY(), this.getX()+ this.getW(), this.getY());
        return li1;
    }

    /**
     * One side of the rectangle is transformed in line
     * @return Line issued from side 2 of the rectangle
     */
    public Line transformRecInLine2(){
        String line2 = "";
        Line li2 = new Line(line2, 0, this.getX(), this.getY(), this.getX(), this.getY()+ this.getH());
        return li2;
    }

    /**
     * One side of the rectangle is transformed in line
     * @return Line issued from side 3 of the rectangle
     */
    public Line transformRecInLine3(){
        String line3 = "";
        Line li3 = new Line(line3, 0, this.getX(), this.getY()+this.getH(), this.getX()+ this.getW(), this.getY()+ this.getH());
        return li3;
    }

    /**
     * One side of the rectangle is transformed in line
     * @return Line issued from side 4 of the rectangle
     */
    public Line transformRecInLine4(){
        String line4 = "";
        Line li4 = new Line(line4, 0, this.getX()+this.getW(), this.getY(),this.getX()+ this.getW(), this.getY()+ this.getH());
        return li4;
    }

    private final double error = 0.05;

    /**
     * Return an error if the rectangle is not in the grid
     */
    public class FigureNotInGridError extends Throwable {
    }
}
