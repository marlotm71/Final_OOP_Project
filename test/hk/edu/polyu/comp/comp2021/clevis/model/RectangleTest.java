package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class Rectangle Test
 */
class RectangleTest {
    private Rectangle James = new Rectangle("James",2,2.0f,2.0f,2.0f,2.0f);
    private Line JamesLine1 = new Line("JameLine1", 2, 2,2,4,2);
    private Line JamesLine2 = new Line("JameLine2", 2, 2,2,2,4);
    private Line JamesLine3 = new Line("JameLine3", 2, 2,4,4,4);
    private Line JamesLine4 = new Line("JameLine4", 2, 4,2,4,4);
    private Rectangle John = new Rectangle("John",6,6.0f,6.0f,6.0f,6.0f);
    private Rectangle Tim = new Rectangle("Tim",5,5.0f,5.0f,5.0f,5.0f);
    private Rectangle Lam = new Rectangle("Lam",4,4.0f,4.0f,4.0f,4.0f);
    private Rectangle Marion = new Rectangle("Marion",4,4.0f,5.0f,10.0f,4.0f);
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
     * Test getter height
     */
    @Test
    void getH() {
        assertNotNull(James.getH()); // to make the height is not null
        assertNotEquals(" ", James.getH()); // make sure height is not empty
        assertTrue(James.getH() > 0); // to make sure the height not zero or negative
        assertFalse(James.getH() <= 0); // to make sure the radius is not a zero or negative value
        assertEquals(56, new Rectangle("Fan",1, 12.0f,23.0f,43.0f,56.0f).getH());

    }

    /**
     * Test move rectangle
     */
    @Test
    public void move() {
        James.move(2,4);
        assertEquals(4, James.getX());
        assertEquals(6,James.getY());
        James.move(-20,-20);
        Assert.assertEquals("The new Rectangle coordinates are : (4.0,6.0)\nThe new coordinates are not in the grid",outputStreamCaptor.toString().trim());
    }

    /**
     * Test List characteristics of this rectangle
     */
    @Test
    public void listFigure() {
        James.listFigure();
        Assert.assertEquals("Rectangle Name : James | Height : 2.0 | Width : 2.0 | Coordinate Top Left Corner : (2.0,2.0) |",outputStreamCaptor.toString().trim());
    }

    /**
     * Test the getter of the max coordinate x of the rectangle
     */
    @Test
    void max_coordinate_x() {
        //the height must be a positive number and is bigger than 0
        //but the max_coordinate_x does not need to be positive or bigger than 0, due to the chance of X coordinate being negative
        assertTrue(  John.getL() > 0);
        assertFalse( John.getL() < 0);
        assertEquals(14,new Rectangle("Cody",7,7.0f,7.0f,7.0f,7.0f).max_coordinate_x());
        assertEquals(12,new Rectangle("Dobry",7,5.0f,7.0f,7.0f,5.0f).max_coordinate_x());

    }
    /**
     * Test the getter of the max coordinate y of the rectangle
     */
    @Test
    void max_coordinate_y() {
        //Max_coordinate_y -> return getY()
        //the max_coordinate_y can be 0 and negative value, as there is a chance of y being a negative number
        assertEquals(27,new Rectangle("Kami",3,5.0f,18.0f,7.0f,9.0f).max_coordinate_y());
        assertEquals(14,new Rectangle("Game",4,5.0f,12.0f,9.0f,2.0f).max_coordinate_y());
    }
    /**
     * Test the getter of the min coordinate x of the rectangle
     */
    @Test
    void min_coordinate_x() {
        //X coordinate has a chance of being negative and 0
        //so the min_coordinate_x can be negative and 0
        //min_coordinate_x -> return getX()
        assertEquals(10, new Rectangle("Jerome",7,10.0f,8.0f,4.0f,11.0f).min_coordinate_x());
        assertEquals(90,new Rectangle("Bob",5,90.0f,6.9f,12.0f,3.9f).min_coordinate_x());

    }
    /**
     * Test the getter of the min coordinate y of the rectangle
     */
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
    /**
     * Test the distance between a point chosen and the rectangle
     */
    @Test
    void distancePoint() {
        assertTrue(Lam.distancePoint(7.0f,7.0f));
        assertFalse(Lam.distancePoint(10.0f,10.0f));
        assertTrue(Marion.distancePoint(13.04f,5.0f));
    }
    /**
     * Test the transformation of the side 1 of the rectangle in line
     */
    @Test
    void transformRecInLine1() {
        assertEquals(JamesLine1.getX(), James.transformRecInLine1().getX());
        assertEquals(JamesLine1.getY(), James.transformRecInLine1().getY());
        assertEquals(JamesLine1.getX2(), James.transformRecInLine1().getX2());
        assertEquals(JamesLine1.getY2(), James.transformRecInLine1().getY2());
    }
    /**
     * Test the transformation of the side 2 of the rectangle in line
     */
    @Test
    void transformRecInLine2() {
        assertEquals(JamesLine2.getX(), James.transformRecInLine2().getX());
        assertEquals(JamesLine2.getY(), James.transformRecInLine2().getY());
        assertEquals(JamesLine2.getX2(), James.transformRecInLine2().getX2());
        assertEquals(JamesLine2.getY2(), James.transformRecInLine2().getY2());
    }
    /**
     * Test the transformation of the side 3 of the rectangle in line
     */
    @Test
    void transformRecInLine3() {
        assertEquals(JamesLine3.getX(), James.transformRecInLine3().getX());
        assertEquals(JamesLine3.getY(), James.transformRecInLine3().getY());
        assertEquals(JamesLine3.getX2(), James.transformRecInLine3().getX2());
        assertEquals(JamesLine3.getY2(), James.transformRecInLine3().getY2());
    }
    /**
     * Test the transformation of the side 4 of the rectangle in line
     */
    @Test
    void transformRecInLine4() {
        assertEquals(JamesLine4.getX(), James.transformRecInLine4().getX());
        assertEquals(JamesLine4.getY(), James.transformRecInLine4().getY());
        assertEquals(JamesLine4.getX2(), James.transformRecInLine4().getX2());
        assertEquals(JamesLine4.getY2(), James.transformRecInLine4().getY2());
    }

}