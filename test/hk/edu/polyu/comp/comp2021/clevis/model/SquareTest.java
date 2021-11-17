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
    private final int SquidzOrder =  3;
    private final double Squidx = 3;
    private final double Squidy = 3;
    private final double Squidl = 3;
    private Square Squid = new Square("Squid",SquidzOrder,Squidx,Squidy,Squidl);
    private final int Squidline1zorder =  2;
    private final double Squidline1x = 3;
    private final double Squidline1y = 3;
    private final double Squidline1x2 = 6;
    private final double Squidline1y2 = 3;
    private Line SquidLine1 = new Line("SquidLine1", Squidline1zorder, Squidline1x,Squidline1y,Squidline1x2,Squidline1y2);
    private final int Squidline2zorder =  2;
    private final double Squidline2x = 3;
    private final double Squidline2y = 3;
    private final double Squidline2x2 = 3;
    private final double Squidline2y2 = 6;
    private Line SquidLine2 = new Line("SquidLine2", Squidline2zorder, Squidline2x,Squidline2y,Squidline2x2,Squidline2y2);
    private final int Squidline3zorder =  2;
    private final double Squidline3x = 3;
    private final double Squidline3y = 6;
    private final double Squidline3x2 = 6;
    private final double Squidline3y2 = 6;
    private Line SquidLine3 = new Line("SquidLine3", Squidline3zorder, Squidline3x,Squidline3y,Squidline3x2,Squidline3y2);
    private final int Squidline4zorder =  2;
    private final double Squidline4x = 6;
    private final double Squidline4y = 3;
    private final double Squidline4x2 = 6;
    private final double Squidline4y2 = 6;
    private Line SquidLine4 = new Line("SquidLine4", Squidline4zorder, Squidline4x,Squidline4y,Squidline4x2,Squidline4y2);
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
        final double dx = 2;
        final double dy = 2;
        Squid.move(dx,dy);
        assertEquals(5, Squid.getX());
        assertEquals(7,Squid.getY());
        final double dx2 = -20;
        final double dy2 = -20;
        Squid.move(dx2,dy2);
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
        assertEquals(6,Squid.max_coordinate_x());
    }
    /**
     * Test getter of the maximum coordinate y of the square
     */
    @Test
    void max_coordinate_y() {
        assertEquals(6,Squid.max_coordinate_y());
    }
    /**
     * Test getter of the minimum coordinate x of the square
     */
    @Test
    void min_coordinate_x() {
        assertEquals(3, Squid.min_coordinate_x());

    }
    /**
     * Test getter of the minimum coordinate y of the square
     */
    @Test
    void min_coordinate_y() {
        assertEquals(3, Squid.min_coordinate_y());
    }
    /**
     * Test the distance between point chosen and the square
     */
    @Test
    void distancePoint() {
        final double pointx = 5;
        final double pointy = 5;
        assertTrue(Squid.distancePoint(pointx,pointy));
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