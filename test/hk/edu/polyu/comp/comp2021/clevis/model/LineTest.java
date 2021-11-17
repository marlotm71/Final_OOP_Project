package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class Line Test
 */
class LineTest {
    private final int zorder =1;
    private final double liny1 = 2.0;
    private final double linx2 = 8.0;
    private final double liny2 = 7.0;
    private final double gautx1 = 2.0;
    private final double gauty1 = 7.0;
    private final double gautx2 = 5.0;
    private final double gauty2 = 10.0;
    private final double marionx1 = 8.0;
    private final double mariony1 = 2.0;
    private final double marionx2 = 13.0;
    private final double mariony2 = 2.0;
    private final double  x1lin = 4;
    private final double gaut1X1 = 3.0;
    private final double gaut1Y1 = 2.0;
    private final double gaut1X2 = 7.0;
    private final double  gaut1Y2 = 7.0;
    private final double marion1X1 = 3.0;
    private final double marion1y1 = 4.0;
    private final double  marion1x2 = 7.0;
    private final double marion1y2 = 4.0;
    private final double romainX1 = 10.0;
    private final double romainY1 = 4.0;
    private final double romainX2 = 10.0;
    private final double romainY2 = 8.0;
    private final double vincentX1 = 4.0;
    private final double vincentY1 = 8.0;
    private final double vincentX2 = 9.0;
    private final double vincentY2 = 4.0;
    private final double jeanX1 = 4.0;
    private final double jeanY1 = 6.0;
    private final double jeanX2 = 4.0;
    private final double jeanY2 = 12.0;
    private final int LemmyZ = 4;
    private final double LemmyX1 = 15.0;
    private final double LemmyY1 = 20.0;
    private final double LemmyX2 = 25.0;
    private final double LemmyY2 = 30.0;
    private final int KerryZ = 6;
    private final double KerryAE = 28.0;
    private final double KerryX1 = 15.0;
    private final double KerryY1 = 25.0;
    private final double KerryX2 = 40.0;
    private final double KerryY2 = 20.0;
    private final double linAEX2 = 12.0;
    private final double linAEY2 = 12.0;
    private final double paulX1 = 3.0;
    private final double paulY1 = 10;
    private final double paulX2 = 6;
    private final double paulY2 = 10;
    private final double thereseX1 = 2;
    private final double thereseY1 = 6;
    private final double thereseX2 = 2;
    private final double thereseY2 = 12.0;
    private final double pierreX1 = 4;
    private final double pierreY1 = 5;
    private final double pierreX2 = 9;
    private final double pierreY2 = 5;
    private final double flavieX1 = 4;
    private final double flavieX2 = 4;
    private final double flavieY1 = 11.0;
    private final double flavieY2 = 15.0;
    private final double claudeX1 = 1;
    private final double claudeY1 = 4;
    private final double claudeX2 = 5;
    private final double claudeY2 = 4;
    private final double bernardX1 = 4;
    private final double bernardY1 = 8;
    private final double bernardX2 = 4;
    private final double bernardY2 = 10;
    private final double JacqueX1 = 4;
    private final double JacqueX2 = 4;
    private final double JacqueY1 = 16.0;
    private final double JacqueY2 = 19.0;
    private final double ddX1 = 3;
    private final double ddX2 = 1;
    private final double ddY1 = 14.0;
    private final double ddY2 = 16.0;
    private final double circleX = 5;
    private final double circleY = 4;
    private final double circleR = 2;
    private final double circle2X = 4;
    private final double circle2Y = 9;
    private final double circle2R = 2;
    private final double  circle3X = 4;
    private final double  circle3Y = 17.0;
    private final double  circle3R = 3;
    private final double  rectangleX = 4;
    private final double  rectangleY = 3;
    private final double  rectangleW = 3;
    private final double  rectangleH = 4;
    private final double  rectangle2X = 2;
    private final double  rectangle2Y = 9;
    private final double  rectangle2W = 6;
    private final double  rectangle2H = 3;
    private final double  squareX = 2;
    private final double  squareY = 9;
    private final double  squareL = 6;


    private Line lin = new Line("Kim", zorder, x1lin,liny1,linx2,liny2);
    private Line gaut= new Line("Gaut", zorder, gautx1,gauty1,gautx2,gauty2);
    private Line marion= new Line("Marion", zorder, marionx1,mariony1,marionx2,mariony2);
    private Line gaut1= new Line("Gaut1", zorder, gaut1X1,gaut1Y1,gaut1X2,gaut1Y2);
    private Line marion1= new Line("Marion1", zorder, marion1X1,marion1y1,marion1x2,marion1y2);
    private Line romain= new Line("Romain", zorder, romainX1,romainY1,romainX2,romainY2);
    private Line vincent = new Line("Vincent",zorder, vincentX1, vincentY1, vincentX2, vincentY2);
    private Line jean = new Line("Jean",zorder, jeanX1, jeanY1, jeanX2, jeanY2);
    private Line paul = new Line("Paul",zorder, paulX1, paulY1, paulX2, paulY2);
    private Line therese = new Line("Therese",zorder, thereseX1, thereseY1, thereseX2, thereseY2);
    private Line pierre = new Line("Pierre",zorder, pierreX1, pierreY1, pierreX2, pierreY2);
    private Line flavie = new Line("Flavie",zorder, flavieX1, flavieY1, flavieX2, flavieY2);
    private Line claude = new Line("Claude",zorder, claudeX1, claudeY1, claudeX2, claudeY2);
    private Line bernard = new Line("Bernard",zorder, bernardX1, bernardY1, bernardX2, bernardY2);
    private Line Jacque = new Line("Jacque",zorder, JacqueX1, JacqueY1, JacqueX2, JacqueY2);
    private Line dd = new Line("DD",zorder, ddX1, ddY1, ddX2, ddY2);
    private Circle circle = new Circle("Circle", zorder, circleX, circleY, circleR);
    private Circle circle2 = new Circle("Circle2", zorder, circle2X, circle2Y, circle2R);
    private Circle circle3 = new Circle("Circle3", zorder, circle3X, circle3Y, circle3R);
    private Rectangle rectangle = new Rectangle("Rectangle", zorder,rectangleX, rectangleY, rectangleW, rectangleH);
    private Rectangle rectangle2 = new Rectangle("Rectangle2",zorder, rectangle2X, rectangle2Y ,rectangle2W,rectangle2H);
    private Square square = new Square("Square", zorder,squareX, squareY, squareL);
    private Shape[] listShapeGroup = new Shape[]{rectangle2,bernard,paul,circle2,square};
    private final int nbshape2= 2;
    private final int nbshape5= 5;
    private Group group1 = new Group("group1",zorder,nbshape5,listShapeGroup);
    private Shape[] listShapeGroup2 = new Shape[]{claude,marion1};
    private Group group2 = new Group("group2",zorder,nbshape2,listShapeGroup2);
    private Shape[] listShapeGroup3 = new Shape[]{group1,group2};
    private Group group3 = new Group("group3",zorder,nbshape2,listShapeGroup3);

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
     * Test getter second coordinate X
     */
    @Test
    void getX2() {
        assertEquals(gautx2, gaut.getX2());

    }
    /**
     * Test getter second coordinate y
     */
    @Test
    void getY2() {
        assertEquals(gauty2, gaut.getY2());
    }

    /**
     * Test leading coefficient of the line
     */
    @Test
    void leadCoef() {
        assertEquals(1,new Line("Lemmy",LemmyZ,LemmyX1,LemmyY1,LemmyX2,LemmyY2).leadCoef());


    }
    /**
     * Test Ordinate at the origin of this line
     */
    @Test
    void b() {
        assertEquals(KerryAE,new Line("Kerry",KerryZ,KerryX1,KerryY1,KerryX2,KerryY2).b());
    }

    /**
     * Test move the line
     */
    @Test
    void move() {
        final double dx = 4;
        final double dy = 5;
        lin.move(dx,dy);
        final double xpected = 8;
        final double xpected2 = 7;
        assertEquals(xpected,lin.getX());
        assertEquals(linAEX2,lin.getX2());
        assertEquals(xpected2,lin.getY());
        assertEquals(linAEY2,lin.getY2());

    }
    /**
     * Test list characteristics of the line
     */
    @Test
    public void listFigure() {
        lin.listFigure();
        Assert.assertEquals("Line Name : Kim | Coordinates : (4.0,2.0) to (8.0,7.0)",outputStreamCaptor.toString().trim());
    }

    /**
     * Test getter max coordinate x of the line
     */
    @Test
    void max_coordinate_x() {
        final double xpectedmaxx = 5;
        assertEquals(xpectedmaxx, gaut.max_coordinate_x());
    }
    /**
     * Test getter max coordinate y of the line
     */
    @Test
    void max_coordinate_y() {
        final double xpectedmaxy = 10;
        assertEquals(xpectedmaxy, gaut.max_coordinate_y());
    }
    /**
     * Test getter min coordinate x of the line
     */
    @Test
    void min_coordinate_x() {
        final double xpectedminx = 2;
        assertEquals(xpectedminx, gaut.min_coordinate_x());

    }
    /**
     * Test getter min coordinate y of the line
     */
    @Test
    void min_coordinate_y() {
        final double xpectedminy = 7;
        assertEquals(xpectedminy,gaut.min_coordinate_y());
    }
    /**
     * Test getter min coordinate x of the line
     */
    @Test
    void distancePoint() {
        final double Point1x = 3;
        final double Point1y = 6;
        final double Point2x = 3;
        final double Point2y = 7.96;
        final double Point3x = 16;
        final double Point3y = 2;
        final double Point4x = 10;
        final double Point4y = 2;
        final double Point5x = 33;
        final double Point5y = 1;
        final double Point6x = 10;
        final double Point6y = 6;
        final double Point7x = 1;
        final double Point7y = 1;
        assertFalse(lin.distancePoint(Point1x,Point1y));
        assertTrue(gaut.distancePoint(Point2x,Point2y));
        assertFalse(gaut.distancePoint(Point3x,Point3y));
        assertTrue(marion.distancePoint(Point4x,Point4y));
        assertFalse(marion.distancePoint(Point5x,Point5y));
        assertTrue(romain.distancePoint(Point6x,Point6y));
        assertFalse(romain.distancePoint(Point7x,Point7y));


    }
    //Several Intersects
    /**
     * Test intersection in several cases
     */
    @Test
    void intersect() {

        // Line & Line : Different cases
        assertTrue(gaut1.intersect(marion1));
        assertFalse(gaut1.intersect(lin));
        assertTrue(vincent.intersect(gaut1));
        assertTrue(vincent.intersect(jean));
        assertTrue(jean.intersect(paul));
        assertFalse(jean.intersect(marion1));
        assertTrue(claude.intersect(marion1));
        assertFalse(marion1.intersect(pierre));
        assertTrue(jean.intersect(flavie));
        assertFalse(jean.intersect(therese));
        assertTrue(bernard.intersect(jean));
        assertFalse(Jacque.intersect(bernard));

        // Line & Circle : Different cases
        assertTrue(marion1.intersect(circle));
        assertTrue(pierre.intersect(circle));
        assertTrue(gaut1.intersect(circle));
        assertFalse(Jacque.intersect(circle));
        assertFalse(paul.intersect(circle));
        assertTrue(therese.intersect(circle2));
        assertTrue(paul.intersect(circle2));
        assertTrue(jean.intersect(circle2));
        assertTrue(dd.intersect(circle3));

        // Line & Rectangle
        assertTrue(marion1.intersect(rectangle));
        assertTrue(pierre.intersect(rectangle));
        assertTrue(vincent.intersect(rectangle));
        assertFalse(Jacque.intersect(rectangle));

        // Line & Square
        assertTrue(claude.intersect(square));
        assertFalse(paul.intersect(square));

        // Line & Group
        assertTrue(vincent.intersect(group1));
        assertFalse(Jacque.intersect(group1));
        assertFalse(Jacque.intersect(group3));

    }
}