package hk.edu.polyu.comp.comp2021.clevis.model;

abstract public class Figure_geo extends Shape {

    public Figure_geo(String name, int zOrder, double x, double y) {
        //ecrire dans les fichiers txt et html
        // creer une figure generale avec les parmètres generaux
        super(name,zOrder);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

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
