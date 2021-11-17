package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class Sqauare Test
 */
class SquareTest {
    private Square Squid = new Square("Squid",3,3.0f,3.0f,3.0f);
    private Line SquidLine1 = new Line("SquidLine1", 2, 3,3,6,3);
    private Line SquidLine2 = new Line("SquidLine2", 2, 3,3,3,6);
    private Line SquidLine3 = new Line("SquidLine3", 2, 3,6,6,6);
    private Line SquidLine4 = new Line("SquidLine4", 2, 6,3,6,6);
    private Square Ken = new Square("Ken",7,7.0f,7.0f,7.0f);
    private Square Bobby = new Square("Bobby",2,2.0f,2.0f,2.0f);
    private Square Charlemagne = new Square("Charlemagne",1,1.0f,1.0f,1.0f);
    private Square Stan = new Square("Stan",4,4.0f,4.0f,4.0f);
    private Square Eli = new Square("Eli", 9,9.0f,9.0f,9.0f);
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
     * Test getter length square
     */
    @Test
    void getL() {
        assertNotNull(Squid.getL());  // make sure r is not null
        assertNotEquals(" ", Squid.getL()); // make sure r is not empty
        assertTrue(Squid.getL() > 0); // to make sure the length not zero or negative
        assertFalse(Squid.getL() <= 0); // to make sure the length is not a zero or negative value
    }
    /**
     * Test move square
     */
    @Test
    public void move() {
        Squid.move(2,4);
        assertEquals(5, Squid.getX());
        assertEquals(7,Squid.getY());
        Squid.move(-20,-20);
        Assert.assertEquals("The new square coordinates are : (5.0,7.0)\nThe new coordinates are not in the grid",outputStreamCaptor.toString().trim());
    }
    /**
     * Test list characteristics of the square
     */
    @Test
    public void listFigure() {
        Squid.listFigure();
        Assert.assertEquals("Square Name : Squid | Height : 3.0 | Coordinates : (3.0,3.0) |",outputStreamCaptor.toString().trim());
    }
    /**
     * Test getter of the maximum coordinate x of the square
     */
    @Test
    void max_coordinate_x() {
        //max_coordinate_x() return getX() + l
        //length cannot be zero, negative, empty of null
        //max_coordinate_x can be zero or negative as x can be zero or negative
        assertTrue(Ken.getL() > 0);
        assertFalse(Ken.getL() <= 0);
        assertEquals(13,new Square("Him",5,3.0f,12.0f,10.0f).max_coordinate_x());
        assertEquals(16, new Square("Her", 6,13.0f,7.0f,3.0f).max_coordinate_x());
        //assertEquals(3, new Rectangle("Fed",6,21.0f,32.0f,12.0f,29.0f).min_coordinate_y());
    }
    /**
     * Test getter of the maximum coordinate y of the square
     */
    @Test
    void max_coordinate_y() {
        //max_coordinate_y() return getY()
        //max_coordinate_y can be a negative number or 0, as Y has a chance of being 0 or a negative number
        assertNotNull(Bobby.getY()); // Y coordinate can be negative, but must be given, not be Null or empty
        assertNotEquals(" ",Bobby.getY());
        assertEquals(164, new Square("Wally", 8, 6.0f, 74.0f,90.0f).max_coordinate_y());
        assertEquals(72, new Square("Sally", 6, 12.0f,12.0f, 60.0f).max_coordinate_y());
    }
    /**
     * Test getter of the minimum coordinate x of the square
     */
    @Test
    void min_coordinate_x() {
        //min_coordinate_x() return getX()
        assertNotNull(Charlemagne.getX());// in this test x can be a negative number, but it must not be NULL or empty
        assertNotEquals(" ",Charlemagne.getX());
        assertEquals(54, new Square("Garry",7,54.0f,32.0f,43.0f).min_coordinate_x());
        assertEquals(88, new Square("Dominic", 4, 88.0f, 50.1f, 45.5f).min_coordinate_x());

    }
    /**
     * Test getter of the minimum coordinate y of the square
     */
    @Test
    void min_coordinate_y() {
        assertTrue(Eli.getL() > 0); // make sure Length is bigger than 0 and negative numbers
        assertFalse(Eli.getL() <= 0); // make sure length is bigger than 0 and negative numbers
        assertEquals(34, new Square("Eunice",3,90.0f,34.0f,2.0f).min_coordinate_y());
        assertEquals(2, new Square("Kelly", 1, 56.0f,2.0f,5.0f).min_coordinate_y());
    }
    /**
     * Test the distance between point chosen and the square
     */
    @Test
    void distancePoint() {
        assertTrue(Eli.distancePoint(10.0f,10.0f));
        assertFalse(Stan.distancePoint(15.0f,16.0f));

    }
    /**
     * Test the transformation of the side 1 of the square in line
     */
    @Test
    void transformSquareInLine1() {
        assertEquals(SquidLine1.getX(), Squid.transformSquareInLine1().getX());
        assertEquals(SquidLine1.getY(), Squid.transformSquareInLine1().getY());
        assertEquals(SquidLine1.getX2(), Squid.transformSquareInLine1().getX2());
        assertEquals(SquidLine1.getY2(), Squid.transformSquareInLine1().getY2());
    }
    /**
     * Test the transformation of the side 2 of the square in line
     */
    @Test
    void transformSquareInLine2() {
        assertEquals(SquidLine2.getX(), Squid.transformSquareInLine2().getX());
        assertEquals(SquidLine2.getY(), Squid.transformSquareInLine2().getY());
        assertEquals(SquidLine2.getX2(), Squid.transformSquareInLine2().getX2());
        assertEquals(SquidLine2.getY2(), Squid.transformSquareInLine2().getY2());
    }
    /**
     * Test the transformation of the side 3 of the square in line
     */
    @Test
    void transformSquareInLine3() {
        assertEquals(SquidLine3.getX(), Squid.transformSquareInLine3().getX());
        assertEquals(SquidLine3.getY(), Squid.transformSquareInLine3().getY());
        assertEquals(SquidLine3.getX2(), Squid.transformSquareInLine3().getX2());
        assertEquals(SquidLine3.getY2(), Squid.transformSquareInLine3().getY2());
    }
    /**
     * Test the transformation of the side 4 of the square in line
     */
    @Test
    void transformSquareInLine4() {
        assertEquals(SquidLine4.getX(), Squid.transformSquareInLine4().getX());
        assertEquals(SquidLine4.getY(), Squid.transformSquareInLine4().getY());
        assertEquals(SquidLine4.getX2(), Squid.transformSquareInLine4().getX2());
        assertEquals(SquidLine4.getY2(), Squid.transformSquareInLine4().getY2());
    }

}