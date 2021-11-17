package hk.edu.polyu.comp.comp2021.clevis.model;

/**
 * Class Figure_geo is a child of Shape, it has everything from shape more coordinate x and y
 */
abstract public class Figure_geo extends Shape {
    /**
     * Constructor of Figure_geo
     * @param name : name of the figure_geo
     * @param zOrder : Zorder
     * @param x : coordinate x
     * @param y : coordinate y
     */
    public Figure_geo(String name, int zOrder, double x, double y) {
        //ecrire dans les fichiers txt et html
        // creer une figure generale avec les parmètres generaux
        super(name,zOrder);
        this.x = x;
        this.y = y;
    }

    /**
     * getter coordinate x
     * @return double coordinate x
     */
    public double getX() {
        return x;
    }

    /**
     * getter coordinate y
     * @return Double coordinate y
     */
    public double getY() {
        return y;
    }

    /**
     * setter coordinate x
     * @param x : coordinate x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * setter coordinate y
     * @param y : coordinate y
     */
    public void setY(double y) {
        this.y = y;
    }

    private double x;
    private double y;

    @Override
    abstract public void move(double dx, double dy);

    @Override
    abstract public void listFigure();



}
