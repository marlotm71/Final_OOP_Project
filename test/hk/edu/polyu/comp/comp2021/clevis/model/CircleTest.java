package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Circle Test
 */
class CircleTest {
    private final double xcircly = 3.0;
    private final double ycircly = 3.0;
    private final double rcircly = 3.0;
    private final double xcirs = 4.0;
    private final double ycirs = 4.0;
    private final double rcirs = 4.0;
    private final double xJoseph = 9.0;
    private final double yJoseph = 9.0;
    private final double rJoseph = 9.0;
    private final double xCleofe = 10.0;
    private final double yCleofe = 10.0;
    private final double rCleofe = 10.0;
    private final int zVillanueva = 12;
    private final double xVillanueva = 43.0;
    private final double yVillanueva = 74.0;
    private final double rVillanueva = 34.0;
    private final double xJojo = 7.0;
    private final double yJojo = 9.0;
    private final double rJojo = 5.0;
    private final double circlyr = 3.0;
    private final double movecircly = -20.0;
    private final double movecircly2 = -20.0;
    private final double maxcycircle = 27.0;
    private final double maxcycirclex = 2.0;
    private final double maxcycircley = 13.0;
    private final double maxcycircler = 14.0;
    private final double mincxx = -3.0;
    private final double mincxy = -5.0;
    private final double mincxr = 2.0;
    private final double mincye = -20;
    private final double mincyx = -3.0;
    private final double mincyy = -15.0;
    private final double mincyr = 5.0;
    private final int    Lennyo = 13;
    private final double Lennyx = 13.0;
    private final double Cleofedx = 9.0;
    private final double LennyE = 6.0;
    private final double LennyY = 14.0;
    private final double LennyR = 8.0;
    private final double Hansdx = 3.0;
    private final double Hansdy = 6.0;
    private final double Cleofedxx = 4.0;


    private Circle circly = new Circle("cir",3,xcircly,ycircly ,rcircly);
    private Circle cirs = new Circle("cirs",4,xcirs,ycirs,rcirs);
    private Circle Hans = new Circle("Hans",1,1.0f,1.0f,1.0f);
    private Circle Joseph = new Circle("Joseph",9,xJoseph,yJoseph,rJoseph);
    private Circle Cleofe = new Circle("Cleofe",10,xCleofe,yCleofe,rCleofe);
    private Circle Villanueva = new Circle("Villanueva", zVillanueva, xVillanueva,yVillanueva,rVillanueva);
    private Circle Jojo = new Circle("Jojo",5,xJojo,yJojo,rJojo);
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /**
     * Method to retrieve outline
     */
    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Test getter radius circle
     */
    @Test
    public void getR() {
        assertNotNull(circly.getR());  // make sure r is not null
        assertNotEquals(" ", circly.getR()); // make sure r is not empty
        assertTrue(circly.getR() > 0); // to make sure the radius not zero or negative
        assertFalse(circly.getR() <= 0); // to make sure the radius is not a zero or negative value
        assertEquals(circlyr,circly.getR());
    }

    /**
     * Test move circle
     */
    @Test
    public void move() {
        circly.move(2,4);
        Assert.assertEquals("The new Circle coordinates are : (5.0,7.0)",outputStreamCaptor.toString().trim());
        assertEquals(5, circly.getX());
        assertEquals(7,circly.getY());
        assertEquals(3,circly.getR());
        circly.move(movecircly,movecircly2);
        }

    /**
     * Test ListFigure circle
     */
    @Test
    public void listFigure() {
        Hans.listFigure();
        Assert.assertEquals("Circle Name : Hans | Radius : 1.0 | Coordinates : (1.0,1.0) |",outputStreamCaptor.toString().trim());
    }

    /**
     * Test max coordinate x of the circle
     */
    @Test
    void max_coordinate_x() {
        //radius cannot be negative and zero
        //but the max coordinate can still be negative or zero, as the y-coordinate could be origin(0) or a negative number
        assertTrue( cirs.getR() > 0); // here we need to make sure radius cannot be zero or negative number
        assertFalse( cirs.getR() < 0);
        assertEquals(2,new Circle("Den",1,1.0f,1.0f,1.0f).max_coordinate_x());

        //max_coordinate_x() return getX() + r $
    }

    /**
     * Test max coordinate y of the circle
     */
    @Test
    void max_coordinate_y() {
        //radius cannot be 0 or negative
        //but the max coordinate can still be zero or negative, as Y coordinate has a chance of being negative.
        assertTrue(Hans.getR() > 0); //to make sure that the max_coordinate_y is above 0, while the radius must be bigger than zero, it cannot be 0 or a negative number
        assertFalse(Hans.getR() < 0);
        assertEquals(maxcycircle, new Circle("Fred",3,maxcycirclex , maxcycircley,maxcycircler).max_coordinate_y());
        //to make sure the max coordinate of y is above 0, while the radius must be a number bigger than 0 and must not be negative $
    }

    /**
     * Test min coordinate x of the circle
     */
    @Test
    public void min_coordinate_x() {
        //radius cannot 0 or negative numbers
        //min_coordinate_x can still be 0 or a negative number due to subtraction and having the chance of X coordinate being 0 or negative
        assertTrue(Joseph.getR() > 0 );
        assertFalse( cirs.getR() < 0);
        assertEquals(-5,new Circle("Joseph",1,mincxx,mincxy,mincxr).min_coordinate_x());

    }

    /**
     * Test min coordinate y of the circle
     */
    @Test
    void min_coordinate_y() {
        //radius cannot be 0
        //but the minimum coordinates can be 0 or negative, due to subtraction and the chance of y being negative
        assertTrue(Cleofe.getR() > 0 );
        assertFalse( Cleofe.getR() < 0);
        assertEquals(mincye,new Circle("Danny",1,mincyx,mincyy,mincyr).min_coordinate_y());
        assertEquals(LennyE,new Circle("Lenny", Lennyo, Lennyx, LennyY, LennyR).min_coordinate_y());

    }

    /**
     * Test distance point of the circle
     */
    @Test
    void distancePoint() {
        assertFalse(Hans.distancePoint(Hansdx,Hansdy));
        assertTrue(Cleofe.distancePoint(Cleofedxx,Cleofedx));
    }

    /**
     * Test intersect with the circle
     */
    @Test
    void intersect() {
        assertTrue(cirs.intersect(circly));
        assertFalse(Hans.intersect(Cleofe));
        assertFalse(Villanueva.intersect(Jojo));
        assertTrue(Cleofe.intersect(circly));
    }
}