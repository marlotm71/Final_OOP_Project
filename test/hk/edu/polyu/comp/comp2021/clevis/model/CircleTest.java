package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
//hello
class CircleTest {
    private double xcircly = 3.0;
    private double ycircly = 3.0;
    private double rcircly = 3.0;
    private double xcirs = 4.0;
    private double ycirs = 4.0;
    private double rcirs = 4.0;
    private double xJoseph = 9.0;
    private double yJoseph = 9.0;
    private double rJoseph = 9.0;
    private double xCleofe = 10.0;
    private double yCleofe = 10.0;
    private double rCleofe = 10.0;
    private int zVillanueva = 12;
    private double xVillanueva = 43.0;
    private double yVillanueva = 74.0;
    private double rVillanueva = 34.0;
    private double xJojo = 7.0;
    private double yJojo = 9.0;
    private double rJojo = 5.0;
    private double circlyr = 3.0;
    private double movecircly = -20.0;
    private double movecircly2 = -20.0;
    private double maxcycircle = 27.0;
    private double maxcycirclex = 2.0;
    private double maxcycircley = 13.0;
    private double maxcycircler = 14.0;
    private double mincxx = -3.0;
    private double mincxy = -5.0;
    private double mincxr = 2.0;
    private double mincye = -20;
    private double mincyx = -3.0;
    private double mincyy = -15.0;
    private double mincyr = 5.0;
    private int    Lennyo = 13;
    private double Lennyx = 13.0;
    private double Cleofedx = 9.0;
    private double LennyE = 6.0;
    private double LennyY = 14.0;
    private double LennyR = 8.0;
    private double Hansdx = 3.0;
    private double Hansdy = 6.0;
    private double Cleofedxx = 4.0;
    //private double mincxy = -5.0;
    //private double mincxr = 2.0;
    //private double mincye = -20;
    //private double mincxx = -3.0;
    //private double mincxy = -5.0;
    //private double mincxr = 2.0;
    //private double mincye = -20;


    private Circle circly = new Circle("cir",3,xcircly,ycircly ,rcircly);
    private Circle cirs = new Circle("cirs",4,xcirs,ycirs,rcirs);
    private Circle Hans = new Circle("Hans",1,1.0f,1.0f,1.0f);
    private Circle Joseph = new Circle("Joseph",9,xJoseph,yJoseph,rJoseph);
    private Circle Cleofe = new Circle("Cleofe",10,xCleofe,yCleofe,rCleofe);
    private Circle Villanueva = new Circle("Villanueva", zVillanueva, xVillanueva,yVillanueva,rVillanueva);
    private Circle Jojo = new Circle("Jojo",5,xJojo,yJojo,rJojo);
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void getR() {
        assertNotNull(circly.getR());  // make sure r is not null
        assertNotEquals(" ", circly.getR()); // make sure r is not empty
        assertTrue(circly.getR() > 0); // to make sure the radius not zero or negative
        assertFalse(circly.getR() <= 0); // to make sure the radius is not a zero or negative value
        assertEquals(circlyr,circly.getR());
    }

    @Test
    public void move() {
        circly.move(2,4);
        assertEquals(5, circly.getX());
        assertEquals(7,circly.getY());
        assertEquals(3,circly.getR());
        circly.move(movecircly,movecircly2);
        Assert.assertEquals("The new Circle coordinates are : (5.0,7.0)\nThe new coordinates are not in the grid",outputStreamCaptor.toString().trim());
    }

    @Test
    public void listFigure() {
        Hans.listFigure();
        Assert.assertEquals("Circle Name : Hans | Radius : 1.0 | Coordinates : (1.0,1.0) |",outputStreamCaptor.toString().trim());
    }

    @Test
    void max_coordinate_x() {
        //radius cannot be negative and zero
        //but the max coordinate can still be negative or zero, as the y-coordinate could be origin(0) or a negative number
        assertTrue( cirs.getR() > 0); // here we need to make sure radius cannot be zero or negative number
        assertFalse( cirs.getR() < 0);
        assertEquals(2,new Circle("Den",1,1.0f,1.0f,1.0f).max_coordinate_x());

        //max_coordinate_x() return getX() + r $
    }

    @Test
    void max_coordinate_y() {
        //radius cannot be 0 or negative
        //but the max coordinate can still be zero or negative, as Y coordinate has a chance of being negative.
        assertTrue(Hans.getR() > 0); //to make sure that the max_coordinate_y is above 0, while the radius must be bigger than zero, it cannot be 0 or a negative number
        assertFalse(Hans.getR() < 0);
        assertEquals(maxcycircle, new Circle("Fred",3,maxcycirclex , maxcycircley,maxcycircler).max_coordinate_y());
        //to make sure the max coordinate of y is above 0, while the radius must be a number bigger than 0 and must not be negative $
    }

    @Test
    public void min_coordinate_x() {
        //radius cannot 0 or negative numbers
        //min_coordinate_x can still be 0 or a negative number due to subtraction and having the chance of X coordinate being 0 or negative
        assertTrue(Joseph.getR() > 0 );
        assertFalse( cirs.getR() < 0);
        assertEquals(-5,new Circle("Joseph",1,mincxx,mincxy,mincxr).min_coordinate_x());

    }

    @Test
    void min_coordinate_y() {
        //radius cannot be 0
        //but the minimum coordinates can be 0 or negative, due to subtraction and the chance of y being negative
        assertTrue(Cleofe.getR() > 0 );
        assertFalse( Cleofe.getR() < 0);
        assertEquals(mincye,new Circle("Danny",1,mincyx,mincyy,mincyr).min_coordinate_y());
        assertEquals(LennyE,new Circle("Lenny", Lennyo, Lennyx, LennyY, LennyR).min_coordinate_y());

    }
    @Test
    void distancePoint() {
        assertFalse(Hans.distancePoint(Hansdx,Hansdy));
        assertTrue(Cleofe.distancePoint(Cleofedxx,Cleofedx));
    }

    @Test
    void intersect() {
        assertTrue(cirs.intersect(circly));
        assertFalse(Hans.intersect(Cleofe));
        assertFalse(Villanueva.intersect(Jojo));
        assertTrue(Cleofe.intersect(circly));
    }
}