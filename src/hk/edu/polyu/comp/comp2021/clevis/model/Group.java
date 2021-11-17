package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;

import static java.lang.Float.MAX_VALUE;

/**
 * Class Group when several shape are grouped together it's a child of shape
 */
public class Group extends Shape {
    private Shape[] listShape;
    //private List<Shape> listShapeGr=new ArrayList<>();
    private int size;

    /**
     * Constructor of the group
     * @param name : name of the group
     * @param zOrder : group Zorder
     * @param nbShape : Number of Shape in group
     * @param listShapeGroup : List of all the shapes in the group
     */
    public Group(String name,int zOrder, int nbShape, Shape[] listShapeGroup) {
        super(name,zOrder);
        this.listShape=listShapeGroup;
        this.size=nbShape;
    }

    /**
     * getter of the list of shapes
     * @return the list of shapes in the group
     */
    public Shape[] getListShape() {
        return listShape;
    }

    /**
     * getter of the size of the group
     * @return the size of the group
     */
    public int getSize() {
        return size;
    }


    @Override
    public void move(double dx, double dy) {
        for (Shape elt: listShape){
            elt.move(dx,dy);
        }
    }

    @Override
    void listFigure() {
        System.out.println("Group Name = "+ getName() + " composed by : ");
        String spaces = String.format("%"+getSize()+"s","");
        for (Shape elt: listShape){
            System.out.format(spaces);
            elt.listFigure();

        }
    }

    @Override
    public double max_coordinate_x() {
        double max_x_shape = 0;
        for (Shape elt: listShape){
            if (elt.max_coordinate_x() > max_x_shape){
                max_x_shape = elt.max_coordinate_x();
            }
        }
        return max_x_shape;
    }

    @Override
    public double max_coordinate_y() {
        double max_y_shape = 0;
        for (Shape elt: listShape){
            if (elt.max_coordinate_y() > max_y_shape){
                max_y_shape = elt.max_coordinate_y();
            }
        }
        return max_y_shape;
    }

    @Override
    public double min_coordinate_x() {
        double min_x_shape = MAX_VALUE;
        for (Shape elt: listShape){
            if (elt.min_coordinate_x() < min_x_shape){
                min_x_shape = elt.min_coordinate_x();
            }
        }
        return min_x_shape;
    }

    @Override
    public double min_coordinate_y() {
        double min_y_shape = MAX_VALUE;
        for (Shape elt: listShape){
            if (elt.min_coordinate_y() < min_y_shape){
                min_y_shape = elt.min_coordinate_y();
            }
        }
        return min_y_shape;
    }

    @Override
    public boolean distancePoint(double x, double y) {
        for (Shape elt : this.listShape ){
            if (elt.distancePoint(x,y)){
                return true;
            }
        }
        return false;
    }

    @Override
    void draw(Graphics g1) {
        for (Shape elt : this.listShape ){
            elt.draw(g1);
        }
    }


}
