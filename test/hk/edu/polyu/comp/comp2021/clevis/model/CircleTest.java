package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    private Circle circly = new Circle("cir",3,3.0f,3.0f ,3.0f);
    private Circle cirs = new Circle("cirs",4,4.0f,4.0f,4.0f);
    private Circle Hans = new Circle("Hans",1,1.0f,1.0f,1.0f);
    private Circle Joseph = new Circle("Joseph",9,9.0f,9.0f,9.0f);
    private Circle Cleofe = new Circle("Cleofe",10,10.0f,10.0f,10.0f);
    private Circle Villanueva = new Circle("Villanueva", 12, 43.0f,74.0f,34.0f);
    private Circle Jojo = new Circle("Jojo",5,7.0f,45.0f,5.0f);
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
        assertEquals(3.0,circly.getR());
    }

    @Test
    public void move() {
        circly.move(2,4);
        assertEquals(5, circly.getX());
        assertEquals(7,circly.getY());
        assertEquals(3,circly.getR());
        circly.move(-20,-20);
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
        assertEquals(27, new Circle("Fred",3,2.0f, 13.0f,14.0f).max_coordinate_y());
        //to make sure the max coordinate of y is above 0, while the radius must be a number bigger than 0 and must not be negative $
    }

    @Test
    public void min_coordinate_x() {
        //radius cannot 0 or negative numbers
        //min_coordinate_x can still be 0 or a negative number due to subtraction and having the chance of X coordinate being 0 or negative
        assertTrue(Joseph.getR() > 0 );
        assertFalse( cirs.getR() < 0);
        assertEquals(-5,new Circle("Joseph",1,-3.0f,-5.0f,2.0f).min_coordinate_x());

    }

    @Test
    void min_coordinate_y() {
        //radius cannot be 0
        //but the minimum coordinates can be 0 or negative, due to subtraction and the chance of y being negative
        assertTrue(Cleofe.getR() > 0 );
        assertFalse( Cleofe.getR() < 0);
        assertEquals(-20,new Circle("Danny",1,-3.0f,-15.0f,5.0f).min_coordinate_y());
        assertEquals(10,new Circle("Lenny",13,13.0f,23.0f,13.0f).min_coordinate_y());

    }
    @Test
    void distancePoint() {
        assertFalse(Hans.distancePoint(3.0f,6.0f));
        assertTrue(Cleofe.distancePoint(4.0f,9.0f));
    }

    @Test
    void intersect() {
        assertTrue(cirs.intersect(circly));
        assertFalse(Hans.intersect(Cleofe));
        assertFalse(Villanueva.intersect(Jojo));
        assertTrue(Cleofe.intersect(circly));
    }
}