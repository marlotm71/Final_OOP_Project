package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    private Rectangle James = new Rectangle("James",2,2.0f,2.0f,2.0f,2.0f);
    private Rectangle John = new Rectangle("John",6,6.0f,6.0f,6.0f,6.0f);
    private Rectangle Tim = new Rectangle("Tim",5,5.0f,5.0f,5.0f,5.0f);
    private Rectangle Lam = new Rectangle("Lam",4,4.0f,4.0f,4.0f,4.0f);
    private Rectangle Marion = new Rectangle("Marion",4,4.0f,5.0f,10.0f,4.0f);
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void getH() {
        assertNotNull(James.getH()); // to make the height is not null
        assertNotEquals(" ", James.getH()); // make sure height is not empty
        assertTrue(James.getH() > 0); // to make sure the height not zero or negative
        assertFalse(James.getH() <= 0); // to make sure the radius is not a zero or negative value
        assertEquals(56, new Rectangle("Fan",1, 12.0f,23.0f,43.0f,56.0f).getH());

    }

    @Test
    void getW() {
        assertNotNull(James.getW()); // to make sure the width is not null
        assertNotEquals(" ", James.getW()); // make sure width is not empty
        assertTrue(James.getW() > 0); // to make sure the width not zero or negative
        assertFalse(James.getW() <= 0); // to make sure the width is not a zero or negative value
        assertEquals(45, new Rectangle("Grace",2, 12.0f,34.0f,45.0f, 12.0f).getW());
    }

    @Test
    public void move() {
        James.move(2,4);
        assertEquals(4, James.getX());
        assertEquals(6,James.getY());
        James.move(-20,-20);
        Assert.assertEquals("The new Rectangle coordinates are : (4.0,6.0)\nThe new coordinates are not in the grid",outputStreamCaptor.toString().trim());
    }

    @Test
    public void listFigure() {
        James.listFigure();
        Assert.assertEquals("Rectangle Name : James | Height : 2.0 | Width : 2.0 | Coordinate Top Left Corner : (2.0,2.0) |",outputStreamCaptor.toString().trim());
    }

    @Test
    void max_coordinate_x() {
        //the height must be a positive number and is bigger than 0
        //but the max_coordinate_x does not need to be positive or bigger than 0, due to the chance of X coordinate being negative
        assertTrue(  John.getW() > 0);
        assertFalse( John.getW() < 0);
        assertEquals(14,new Rectangle("Cody",7,7.0f,7.0f,7.0f,7.0f).max_coordinate_x());
        assertEquals(12,new Rectangle("Dobry",7,5.0f,7.0f,7.0f,5.0f).max_coordinate_x());

    }
    @Test
    void max_coordinate_y() {
        //Max_coordinate_y -> return getY()
        //the max_coordinate_y can be 0 and negative value, as there is a chance of y being a negative number
        assertEquals(27,new Rectangle("Kami",3,5.0f,18.0f,7.0f,9.0f).max_coordinate_y());
        assertEquals(14,new Rectangle("Game",4,5.0f,12.0f,9.0f,2.0f).max_coordinate_y());
    }

    @Test
    void min_coordinate_x() {
        //X coordinate has a chance of being negative and 0
        //so the min_coordinate_x can be negative and 0
        //min_coordinate_x -> return getX()
        assertEquals(10, new Rectangle("Jerome",7,10.0f,8.0f,4.0f,11.0f).min_coordinate_x());
        assertEquals(90,new Rectangle("Bob",5,90.0f,6.9f,12.0f,3.9f).min_coordinate_x());

    }

    @Test
    void min_coordinate_y() {
        //min_coordinate_y -> return getY()-h
        // the height must be a positive number and is bigger than 0
        // but the min_coordinate of can negative or 0, due to chance of Y being negative or zero and subtraction is done.
        assertTrue(Tim.getH() > 0); // height cannot be negative, but the min coordinates can be negative
        assertFalse(Tim.getH() <= 0); // height cannot be negative
        assertEquals(32, new Rectangle("Fed",6,21.0f,32.0f,12.0f,29.0f).min_coordinate_y());
        assertEquals(28, new Rectangle("Kam",9,8.0f,28.0f,11.0f,31.0f).min_coordinate_y());

    }

    @Test
    void distancePoint() {
        assertTrue(Lam.distancePoint(7.0f,7.0f));
        assertFalse(Lam.distancePoint(10.0f,10.0f));
        assertTrue(Marion.distancePoint(13.04f,5.0f));
    }
}