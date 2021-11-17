package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;

/**
 * Class Abstract Shape : Highest Degree/Mother
 */
abstract public class Shape {
    /**
     * Constructor of one shape
     * @param name : name of the shape
     * @param zOrder : Z order of the shape
     */
    public Shape(String name, int zOrder) {
        //ecrire dans les fichiers txt et html
        // creer une figure generale avec les parmètres generaux
        this.name=name;
        this.zOrder = zOrder;
    }

    /**
     * move the shape x coordinate of dx and the shape y coordinate of dy
     * @param dx : moving in the direction x
     * @param dy : moving in the direction y
     */
    abstract public void move(double dx, double dy);

    private String name;

    private int zOrder = 0;

    /**
     * getter of the Z order of the Shape
     * @return Shape Z Order
     */
    public int getzOrder() {
        return zOrder;
    }

    /**
     * getter of shape name
     * @return shape name
     */
    public String getName() {
        return name;
    }

    /**
     * List Characteristics of the shape
     */
    abstract void listFigure();

    /**
     * Give the max coordinate in the direction x of the shape
     * @return max coordinate x
     */
    abstract public double max_coordinate_x();
    /**
     * Give the max coordinate in the direction y of the shape
     * @return max coordinate y
     */
    abstract public double max_coordinate_y();
    /**
     * Give the min coordinate in the direction x of the shape
     * @return min coordinate x
     */
    abstract public double min_coordinate_x();
    /**
     * Give the min coordinate in the direction y of the shape
     * @return min coordinate y
     */
    abstract public double min_coordinate_y();

    /**
     * Return true or false in function if the distance with the point chosen and the shape is inferior to the Error or in the shape
     * @param x : x coordinate of the point chosen
     * @param y: y coordinate of the point chosen
     * @return Boolean : True if < error or in the shape , else False
     */
    abstract public boolean distancePoint(double x, double y);

    /**
     * Draw the shape ih the graphics
     * @param g1 Graphics where the shape will be drawn
     */
    abstract void draw(Graphics g1);



}
