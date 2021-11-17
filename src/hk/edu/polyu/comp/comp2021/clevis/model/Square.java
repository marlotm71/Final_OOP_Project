package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Figure_geo {
    public Square(String name, int zOrder, double x, double y, double l) {
        super(name, zOrder, x, y);
        this.l = l;
    }
    public double getL() {
        return l;
    }



    @Override
    public void move(double dx, double dy) {
        try{
            if ((getX() + dx > 0 && getY() + dy > 0)) {
                setX(getX() + dx);
                setY(getY() + dy);
                System.out.println("The new square coordinates are : (" + this.getX() + "," + this.getY() + ")");
            } else throw new FigureNotInGridError();
        }
        catch (Square.FigureNotInGridError f){
            System.out.println("The new coordinates are not in the grid");
        }}



    @Override
    public void listFigure() {
        System.out.print("Square Name : " + this.getName() + " | ");
        System.out.print("Height : " + this.getL() + " | ");
        System.out.println("Coordinates : (" + this.getX() + "," + this.getY() + ") | ");}
    @Override
    public double max_coordinate_x() {
        return (getX() + l);}
    @Override
    public double max_coordinate_y() {
        return (getY() + l) ;}
    @Override
    public double min_coordinate_x() {return getX();}
    @Override
    public double min_coordinate_y() {return (getY());}
    @Override
    public boolean distancePoint(double x, double y) {
        if ((x > (this.getX() - error) && x < (this.getX() + this.getL() + error)) && (y > (this.getY() - error) && y < (this.getY() + this.getL() + error)))
            return true;
        else return false;}
    @Override
    void draw(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        Rectangle2D rect = new Rectangle2D.Double(getX(), getY(), getL(), getL());
        g.draw(rect);}
    public Line transformSquareInLine1(){
        String line1 = "";
        Line li1 = new Line(line1, 0, this.getX(), this.getY(), this.getX()+ this.getL(), this.getY());
        return li1;}
    public Line transformSquareInLine2(){
        String line2 = "";
        Line li2 = new Line(line2, 0, this.getX(), this.getY(), this.getX(), this.getY()+ this.getL());
        return li2;}
    public Line transformSquareInLine3(){
        String line3 = "";
        Line li3 = new Line(line3, 0, this.getX(), this.getY()+this.getL(), this.getX()+ this.getL(), this.getY()+ this.getL());
        return li3;
    }
    public Line transformSquareInLine4(){
        String line4 = "";
        Line li4 = new Line(line4, 0, this.getX()+this.getL(), this.getY(),this.getX()+ this.getL(), this.getY()+ this.getL());
        return li4;
    }



    private final double error = 0.05;


    private double l;
    public class FigureNotInGridError extends Throwable { }


}
