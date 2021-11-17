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
    private final double JamesX = 2.0;
    private final double JamesY = 2.0;
    private final double JamesW = 2.0;
    private final double JamesH = 2.0;
    private final double JohnX = 6.0;
    private final double JohnY = 6.0;
    private final double JohnW = 6.0;
    private final double JohnH = 6.0;
    private final double TimX = 5.0;
    private final double TimY = 5.0;
    private final double TimW = 5.0;
    private final double TimH = 5.0;
    private final double LamX = 4.0;
    private final double LamY = 4.0;
    private final double LamW = 4.0;
    private final double LamH = 4.0;
    private final double MarionX = 4.0;
    private final double MarionY = 5.0;
    private final double MarionW = 10.0;
    private final double MarionH = 4.0;
    private final double FanAE = 56.0;
    private final double FanX = 12.0;
    private final double FanY = 23.0;
    private final double FanW = 43.0;
    private final double FanH = 56.0;
    private final double James1 = -20;
    private final double James2 = -20;
    private final double CodyAE = 14.0;
    private final double CodyX = 7.0;
    private final double CodyY = 7.0;
    private final double CodyW = 7.0;
    private final double CodyH = 7.0;
    private final double DobryAE = 12.0;
    private final double DobryX = 5.0;
    private final double DobryY = 7.0;
    private final double DobryW = 7.0;
    private final double DobryH = 5.0;
    private final double KamiAE = 27.0;
    private final double KamiX = 5.0;
    private final double KamiY = 18.0;
    private final double KamiW = 7.0;
    private final double KamiH = 9.0;
    private final double Kami1AE = 14.0;
    private final double GameAE = 14.0;
    private final double GameX = 5.0;
    private final double GameY = 12.0;
    private final double GameW = 9.0;
    private final double GameH = 2.0;
    private final double JeromeX = 10.0;
    private final double JeromeY = 8.0;
    private final double JeromeW = 4.0;
    private final double JeromeH = 11.0;
    private final double bobAE = 90.0;
    private final double bobX = 90.0;
    private final double bobY = 6.9;
    private final double boyW = 12.0;
    private final double bobH = 3.9;
    private final double FedAE = 32.0;
    private final double FedX = 21.0;
    private final double FedY = 32.0;
    private final double FedW = 12.0;
    private final double FedH = 29.0;
    private final double KamAE = 28.0;
    private final double KamX = 8.0;
    private final double KamY = 28.0;
    private final double KamW = 11.0;
    private final double KamH = 31.0;
    private final double Lam1 = 7.0;
    private final double Lam2 = 7.0;
    private final double Lam3 = 10.0;
    private final double Lam4 = 10.0;
    private final double Marion1 = 13.04;
    private final double Marion2 = 5.0;





    private Rectangle James = new Rectangle("James",2,JamesX,JamesY,JamesW,JamesH);
    private Line JamesLine1 = new Line("JameLine1", 2, 2,2,4,2);
    private Line JamesLine2 = new Line("JameLine2", 2, 2,2,2,4);
    private Line JamesLine3 = new Line("JameLine3", 2, 2,4,4,4);
    private Line JamesLine4 = new Line("JameLine4", 2, 4,2,4,4);
    private Rectangle John = new Rectangle("John",6,JohnX,JohnY,JohnW,JohnH);
    private Rectangle Tim = new Rectangle("Tim",5,TimX,TimY,TimW,TimH);
    private Rectangle Lam = new Rectangle("Lam",4,LamX,LamY,LamW,LamH);
    private Rectangle Marion = new Rectangle("Marion",4,MarionX,MarionY,MarionW,MarionH);
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
        assertEquals(FanAE, new Rectangle("Fan",1, FanX,FanY,FanW,FanH).getH());

    }

    /**
     * Test move rectangle
     */
    @Test
    public void move() {
        James.move(2,4);
        assertEquals(4, James.getX());
        assertEquals(6,James.getY());
        James.move(James1,James2);
        Assert.assertEquals("The new Rectangle coordinates are : (4.0,6.0)\r\nThe new coordinates are not in the grid",outputStreamCaptor.toString().trim());
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
        assertEquals(CodyAE,new Rectangle("Cody",7,CodyX,CodyY,CodyW,CodyH).max_coordinate_x());
        assertEquals(DobryAE,new Rectangle("Dobry",7,DobryX,DobryY,DobryW,DobryH).max_coordinate_x());

    }
    /**
     * Test the getter of the max coordinate y of the rectangle
     */
    @Test
    void max_coordinate_y() {
        //Max_coordinate_y -> return getY()
        //the max_coordinate_y can be 0 and negative value, as there is a chance of y being a negative number
        assertEquals(KamiAE,new Rectangle("Kami",3,KamiX,KamiY,KamiW,KamiH).max_coordinate_y());
        assertEquals(GameAE,new Rectangle("Game",4,GameX,GameY,GameW,GameH).max_coordinate_y());
    }
    /**
     * Test the getter of the min coordinate x of the rectangle
     */
    @Test
    void min_coordinate_x() {
        //X coordinate has a chance of being negative and 0
        //so the min_coordinate_x can be negative and 0
        //min_coordinate_x -> return getX()
        assertEquals(10, new Rectangle("Jerome",7,JeromeX,JeromeY,JeromeW,JeromeH).min_coordinate_x());
        assertEquals(bobAE,new Rectangle("Bob",5,bobX,bobY,boyW,bobH).min_coordinate_x());

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
        assertEquals(FedAE, new Rectangle("Fed",6,FedX,FedY,FedW,FedH).min_coordinate_y());
        assertEquals(KamAE, new Rectangle("Kam",9,KamX,KamY,KamW,KamH).min_coordinate_y());

    }
    /**
     * Test the distance between a point chosen and the rectangle
     */
    @Test
    void distancePoint() {
        assertTrue(Lam.distancePoint(Lam1,Lam2));
        assertFalse(Lam.distancePoint(Lam3,Lam4));
        assertTrue(Marion.distancePoint(Marion1,Marion2));
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