package hk.edu.polyu.comp.comp2021.clevis.model;

import java.awt.*;
import java.awt.geom.Line2D;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Line extends Figure_geo {
    public Line(String name, int zOrder, double x1, double y1, double x2, double y2){
        //html & txt process
        // creating figure
        super(name,zOrder , x1, y1);
        this.x2=x2;
        this.y2=y2;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    private double x2;
    private double y2;

    public double leadCoef(){
        double coef=1;
        if (getX()!=getX2()) coef = (getY2() - getY()) / (getX2() - getX());
        return coef;
    }
    public double b(){
        return (getY()-this.leadCoef()*getX());
    }
    @Override
    public void move(double dx, double dy) {
        x2 += dx;
        y2 += dy;
        setX(getX()+dx);
        setY(getY()+dy);
        System.out.println("The new line coordinates are : (" + this.getX() + "," + this.getY() + ") to (" + this.getX2() + "," + this.getY2()+")");
    }

    @Override
    public void listFigure() {
        System.out.print("Line Name : " + this.getName() + " | ");
        System.out.println("Coordinates : (" + this.getX() + "," + this.getY() + ") to (" + this.getX2() + "," + this.getY2()+")");
    }
    @Override
    public double max_coordinate_x() {
        return max(getX(),x2);
    }

    @Override
    public double max_coordinate_y() {return max(getY(),y2);}

    @Override
    public double min_coordinate_x() {
        return min(getX(),x2);
    }

    @Override
    public double min_coordinate_y() {
        return min(getY(),y2);
    }

    @Override
    public boolean distancePoint(double x, double y) {
        if (getX() == getX2()){
            if ((x>(getX()-error) && x < (getX()+error)) && (y>min_coordinate_y()-error && y< (max_coordinate_y()+error) )){
                return true;
            }
            else{
                return false;
            }
        }
        else if (getY() == getY2()){
            System.out.println(min_coordinate_x() + " , " + max_coordinate_x() + " , " +  min_coordinate_y() + " , " + max_coordinate_y() + ", " + getY());
            if (y>(getY()-error) && y<(getY()+error)){
                if (x>(min_coordinate_x()-error) && x < (max_coordinate_x()+error)){
                    return true;
                }
                else {
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            if ( (x > (min_coordinate_x() - error) && x < (max_coordinate_x()+error) ) && ((y > (leadCoef()*x + b()) - error) && (y < (leadCoef()*x + b()) + error) )){
                return true;
            }
            else{
                return false;
            }
        }
    }
    @Override
    void draw(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.draw(new Line2D.Double(getX(), getY(), getX2(), getY2()));
    }
    public boolean intersect(Line other) {
        boolean bool=false;
        if (getX()==getX2()){
            if (other.getX()==other.getX2() && getX()==other.getX()){
                if (min(getY(),getY2())>min(other.getY(), other.getY2())){
                    if(max(other.getY(),other.getY2())< min(getY(),getY2())){
                      bool=false;
                    }
                    else{
                        bool=true;
                    }
                }
                else{
                    if(max(this.getY(),this.getY2())>= min(other.getY(),other.getY2())){
                       bool=true;
                    }
                }
            }
            else if(other.getX()==other.getX2() && getX()!=other.getX()){
                bool=false;
            }
            else{
                double coeffDir2= other.leadCoef();
                double b2=other.b();
                double Ya= coeffDir2*getX()+b2;
                if((Ya < max( min(this.getY(),this.getY2()), min(other.getY(),other.getY2()) )) ||
                        (Ya > min( max(this.getY(),this.getY2()), max(other.getY(), other.getY2()) )) ){
                    bool=false;
                }
                else{
                    bool=true;
                }
            }
        }
        else if (other.getX()==other.getX2()){
            double coeffDir1= this.leadCoef();
            double b1= this.b();
            double Ya= coeffDir1*getX()+b1;
            if((Ya < max( min(this.getY(),this.getY2()), min(other.getY(),other.getY2()) )) ||
                    (Ya > min( max(this.getY(),this.getY2()), max(other.getY(), other.getY2()) )) ){
                bool=false;
            }
            else{
                bool=true;
            }
        }
        else{
            double coeffDir1= this.leadCoef();
            double coeffDir2= other.leadCoef();
            double b1= this.b();
            double b2=other.b();

            if(coeffDir1==coeffDir2 && b1==b2){
                if (min(other.getX(),other.getX2())<min(this.getX(),this.getX2())){
                    if(min(this.getX(),this.getX2())<max(other.getX(),other.getX2()) && min(this.getX(),this.getX2())>min(other.getX(),other.getX2()) ){
                        bool=true;
                    }
                }
                else{
                    if(min(other.getX(),other.getX2())<max(this.getX(),this.getX2()) && min(other.getX(),other.getX2())>min(this.getX(),this.getX2()) ){
                        bool=true;
                    }
                }
            }
            else if(coeffDir1==coeffDir2 && b1!=b2){
                bool=false;
            }
            else{
                double Xa=0;
                Xa= (b2-b1)/(coeffDir1-coeffDir2);
                if((Xa < max( min(this.getX(),this.getX2()), min(other.getX(),other.getX2()) )) ||
                        (Xa > min( max(this.getX(),this.getX2()), max(other.getX(), other.getX2()) )) ){
                    bool=false;
                }
                else{
                    bool=true;
                }
            }
        }
        return bool;
    }
    public boolean intersect(Circle other) {
        boolean bool=false;
        if (getX()==getX2()){
            double a= 1;
            double b=-2*other.getY();
            double c=Math.pow(other.getY(),2)-Math.pow(other.getR(),2)+Math.pow(getX()-other.getX(),2);
            double delta= Math.pow(b,2)-4*a*c;
            if(delta>0){
                double soly1= (-b-Math.sqrt(delta))/(2*a);
                double soly2= (-b+Math.sqrt(delta))/(2*a);
                if ((soly1<=max(getY(),getY2()) && soly1>=min(getY(),getY2())) || soly2<=max(getY(),getY2()) && soly2>=min(getY(),getY2())  ){
                    bool=true;
                }
                else{
                    bool=false;
                }
            }
            if(delta==0){
                double soly =-b/2*a;
                if ((soly<=max(getY(),getY2()) && soly>=min(getY(),getY2()))){
                    bool=true;
                }
            }
        }
        else {
            double a=this.leadCoef();
            double b= this.b();
            double first=  (1+Math.pow(a,2));
            double second= 2*(a*b-a*other.getY()- other.getX());
            double last= Math.pow(b,2)+Math.pow(other.getX(), 2)-2*b* other.getY()+Math.pow(other.getY(), 2)-Math.pow(other.getR(), 2);
            double det=Math.pow(second,2)-4*first*last;
            if(det>0){
                double solx1= (-second-Math.sqrt(det))/(2*first);
                double solx2= (-second+Math.sqrt(det))/(2*first);
                double soly1=a*solx1+b;
                double soly2=a*solx2+b;
                if ((soly1<=max(getY(),getY2()) && soly1>=min(getY(),getY2())) &&(solx1<=max(getX(),getX2()) && solx1>=min(getX(),getX2()))){
                    bool=true;
                }
                if ((soly2<=max(getY(),getY2()) && soly2>=min(getY(),getY2())) &&(solx2<=max(getX(),getX2()) && solx2>=min(getX(),getX2()))){
                    bool=true;
                }
            }
            else if(det==0){
                double solx =-second/2*first;
                double soly= a*solx+b;
                if ((soly<=max(getY(),getY2()) && soly>=min(getY(),getY2())) &&(solx<=max(getX(),getX2()) && solx>=min(getX(),getX2()))){
                    bool=true;
                }
            }
        }
        return bool;
    }
    public boolean intersect(Rectangle other) {
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4 = "";
        boolean bool= false;
        Line li1 = new Line(line1, 0, other.getX(), other.getY(), other.getX()+ other.getW(), other.getY());
        Line li2 = new Line(line2, 0, other.getX(), other.getY(), other.getX(), other.getY()+ other.getH());
        Line li3 = new Line(line3, 0, other.getX(), other.getY()+other.getH(), other.getX()+ other.getW(), other.getY()+ other.getH());
        Line li4 = new Line(line4, 0, other.getX()+other.getW(), other.getY(),other.getX()+ other.getW(), other.getY()+ other.getH());
        if(this.intersect(li1)|| this.intersect(li2)||this.intersect(li3)||this.intersect(li4)) bool = true;
        return bool;
    }
    public boolean intersect(Square other) {
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4 = "";
        boolean bool= false;
        Line li1 = new Line(line1, 0, other.getX(), other.getY(), other.getX()+ other.getL(), other.getY());
        Line li2 = new Line(line2, 0, other.getX(), other.getY(), other.getX(), other.getY()+ other.getL());
        Line li3 = new Line(line3, 0, other.getX(), other.getY()+other.getL(), other.getX()+ other.getL(), other.getY()+ other.getL());
        Line li4 = new Line(line4, 0, other.getX()+other.getL(), other.getY(),other.getX()+ other.getL(), other.getY()+ other.getL());
        if(this.intersect(li1)|| this.intersect(li2)||this.intersect(li3)||this.intersect(li4)){
            bool=true;
        }
        return bool;
    }
    public boolean intersect(Group other) {
        boolean intersect=false;
        for (Shape shape: other.getListShape()){
            String classElmt = shape.getClass().getName();
            switch (classElmt) {
                case ("hk.edu.polyu.comp.comp2021.clevis.model.Rectangle"):
                    intersect=this.intersect((Rectangle) shape);
                    if (intersect){
                        return true;
                    }
                    break;
                case ("hk.edu.polyu.comp.comp2021.clevis.model.Circle"):
                    intersect=this.intersect((Circle) shape);
                    if (intersect){
                        return true;
                    }
                    break;
                case("hk.edu.polyu.comp.comp2021.clevis.model.Square"):
                    intersect=this.intersect((Square) shape);
                    if (intersect){
                        return true;
                    }
                    break;
                case("hk.edu.polyu.comp.comp2021.clevis.model.Line"):
                    intersect=this.intersect((Line) shape);
                    if (intersect){
                        return true;
                    }
                    break;
                case("hk.edu.polyu.comp.comp2021.clevis.model.Group"):
                    intersect=this.intersect((Group) shape);
                    break;
            }
        }
        return false;

    }
    private final double error = 0.05;

}
