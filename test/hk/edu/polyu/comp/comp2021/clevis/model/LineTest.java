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
    private double liny1;

    {
        liny1 = 2.0;
    }

    private double linx2;

    {
        linx2 = 8.0;
    }

    private double liny2;

    {
        liny2 = 7.0;
    }

    private double gautx1;

    {
        gautx1 = 2.0;
    }

    private double gauty1;

    {
        gauty1 = 7.0;
    }

    private double gautx2;

    {
        gautx2 = 5.0;
    }

    private double gauty2;

    {
        gauty2 = 10.0;
    }

    private double marionx1;

    {
        marionx1 = 8.0;
    }

    private double mariony1;

    {
        mariony1 = 2.0;
    }

    private double marionx2;

    {
        marionx2 = 13.0;
    }

    private double mariony2;

    {
        mariony2 = 2.0;
    }

    private double x1lin;

    {
        x1lin = 4;
    }

    private double gaut1X1;
    {
        gaut1X1 = 3.0;
    }

    private double gaut1Y1;
    {
        gaut1Y1 = 2.0;
    }

    private double gaut1X2;
    {
        gaut1X2 = 7.0;
    }

    private double gaut1Y2;
    {
        gaut1Y2 = 7.0;
    }

    private double marion1X1;
    {
        marion1X1 = 3.0;
    }

    private double marion1y1;
    {
        marion1y1 = 4.0;
    }

    private double marion1x2;
    {
        marion1x2 = 7.0;
    }

    private double marion1y2;
    {
        marion1y2 = 4.0;
    }

    private double romainX1;
    {
        romainX1 = 10.0;
    }

    private double romainY1;
    {
        romainY1 = 4.0;
    }

    private double romainX2;
    {
        romainX2 = 10.0;
    }

    private double romainY2;
    {
        romainY2 = 8.0;
    }

    private double qqX1;
    {
        qqX1 = 5.0;
    }

    private double qqY1;
    {
        qqY1 = 7.8;
    }

    private double qqX2;
    {
        qqX2 = 12.0;
    }

    private double qqY2;
    {
        qqY2 = 13.0;
    }

    private double vincentX1;
    {
        vincentX1 = 4.0;
    }

    private double vincentY1;
    {
        vincentY1 = 8.0;
    }

    private double vincentX2;
    {
        vincentX2 = 9.0;
    }

    private double vincentY2;
    {
        vincentY2 = 4.0;
    }

    private double jeanX1;
    {
        jeanX1 = 4.0;
    }

    private double jeanY1;
    {
        jeanY1 = 6.0;
    }

    private double jeanX2;
    {
        jeanX2 = 4.0;
    }

    private double jeanY2;
    {
        jeanY2 = 12.0;
    }

    private double Theresey2;
    {
        Theresey2 = 12.0;
    }

    private double flavieY1;
    {
        flavieY1 = 11.0;
    }

    private double flavieY2;
    {
        flavieY2 = 15.0;
    }

    private double JacqueY1;
    {
        JacqueY1 = 16.0;
    }

    private double JacqueY2;
    {
        JacqueY2 = 19.0;
    }

    private double ddY1;
    {
        ddY1 = 14.0;
    }

    private double ddY2;
    {
        ddY2 = 16.0;
    }

    private double circle3Y;
    {
        circle3Y = 17.0;
    }

    private double SaraAE;
    {
        SaraAE = 13.0;
    }

    private double SaraX1;
    {
        SaraX1 = 12.0;
    }

    private double SaraY1;
    {
        SaraY1 = 32.0;
    }

    private double SaraX2;
    {
        SaraX2 = 13.0;
    }

    private double SaraY2;
    {
        SaraY2 = 26.0;
    }

    private double HenryE;
    {
        HenryE = 34.0;
    }

    private double HenryX1;
    {
        HenryX1 = 33.0;
    }

    private double HenryY1;
    {
        HenryY1 = 12.0;
    }

    private double HenryX2;
    {
        HenryX2 = 54.0;
    }

    private double HenryY2;
    {
        HenryY2 = 34.0;
    }

    private double LemX1;
    {
        LemX1 = 32.0;
    }

    private double LemY1;
    {
        LemY1 = 32.0;
    }

    private double LemX2;
    {
        LemX2 = 32.0;
    }

    private double LemY2;
    {
        LemY2 = 32.0;
    }

    private double LemmyX1;
    {
        LemmyX1 = 15.0;
    }
    private double LemmyY1;
    {
        LemmyY1 = 20.0;
    }

    private double LemmyX2;
    {
        LemmyX2 = 25.0;
    }

    private double LemmyY2;
    {
        LemmyY2 = 30.0;
    }

    private double KarenX1;
    {
        KarenX1 = 15.0;
    }

    private double KarenY1;
    {
        KarenY1 = 20.0;
    }

    private double KarenX2;
    {
        KarenX2 = 35.0;
    }

    private double KarenY2;
    {
        KarenY2 = 40.0;
    }

    private double KerryAE;
    {
        KerryAE = 28.0;
    }

    private double KerryX1;
    {
        KerryX1 = 15.0;
    }

    private double KerryY1;
    {
        KerryY1 = 25.0;
    }

    private double KerryX2;
    {
        KerryX2 = 40.0;
    }

    private double KerryY2;
    {
        KerryY2 = 20.0;
    }

    private double linAEX2;
    {
        linAEX2 = 12.0;
    }

    private double linAEY2;
    {
        linAEY2 = 12.0;
    }

    private double boratX1;
    {
        boratX1 = 3.0;
    }

    private double boratY1;
    {
        boratY1 = 12.0;
    }

    private double boratX2;
    {
        boratX2 = 9.0;
    }

    private double boratY2;
    {
        boratY2 = 34.0;
    }

    private double KhanAE;
    {
        KhanAE = 12.0;
    }

    private double KhanX1;
    {
        KhanX1 = 12.0;
    }

    private double KhanY1;
    {
        KhanY1 = 5.0;
    }

    private double JacqueY2;
    {
        JacqueY2 = 19.0;
    }

    private double JacqueY2;
    {
        JacqueY2 = 19.0;
    }

    private double JacqueY2;
    {
        JacqueY2 = 19.0;
    }

    private double JacqueY2;
    {
        JacqueY2 = 19.0;
    }

    private double JacqueY2;
    {
        JacqueY2 = 19.0;
    }

    private double JacqueY2;
    {
        JacqueY2 = 19.0;
    }


    private Line lin = new Line("Kim", 2, x1lin,liny1,linx2,liny2);
    private Line gaut= new Line("Gaut", 2, gautx1,gauty1,gautx2,gauty2);
    private Line marion= new Line("Marion", 2, marionx1,mariony1,marionx2,mariony2);
    private Line gaut1= new Line("Gaut1", 2, gaut1X1,gaut1Y1,gaut1X2,gaut1Y2);
    private Line marion1= new Line("Marion1", 2, marion1X1,marion1y1,marion1x2,marion1y2);
    private Line romain= new Line("Romain", 2, romainX1,romainY1,romainX2,romainY2);
    private Line qq = new Line("Yanny",3, qqX1, qqY1, qqX2, qqY2);
    private Line vincent = new Line("Vincent",3, vincentX1, vincentY1, vincentX2, vincentY2);
    private Line jean = new Line("Jean",3, jeanX1, jeanY1, jeanX2, jeanY2);
    private Line paul = new Line("Paul",3, 3, 10, 6, 10);
    private Line therese = new Line("Therese",3, 2, 6, 2, Theresey2);
    private Line pierre = new Line("Pierre",3, 4, 5, 9, 5);
    private Line flavie = new Line("Flavie",3, 4, flavieY1, 4, flavieY2);
    private Line claude = new Line("Claude",3, 1, 4, 5, 4);
    private Line bernard = new Line("Bernard",3, 4, 8, 4, 10);
    private Line Jacque = new Line("Jacque",3, 4, JacqueY1, 4, JacqueY2);
    private Line dd = new Line("DD",3, 3, ddY1, 1, ddY2);
    private Circle circle = new Circle("Circle", 2, 5, 4, 2);
    private Circle circle2 = new Circle("Circle2", 2, 4, 9, 2);
    private Circle circle3 = new Circle("Circle3", 2, 4, circle3Y, 3);
    private Rectangle rectangle = new Rectangle("Rectangle", 4,4, 3, 3, 4);
    private Rectangle rectangle2 = new Rectangle("Rectangle2",1, 2, 9 ,6,3);
    private Square square = new Square("Square", 2,2, 3, 3);
    private Shape[] listShapeGroup = new Shape[]{rectangle2,bernard,paul,circle2,square};
    private Group group1 = new Group("group1",2,5,listShapeGroup);
    private Shape[] listShapeGroup2 = new Shape[]{claude,marion1};
    private Group group2 = new Group("group2",2,2,listShapeGroup2);
    private Shape[] listShapeGroup3 = new Shape[]{group1,group2};
    private Group group3 = new Group("group3",2,2,listShapeGroup3);

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
        //x2 cannot be empty or null
        assertNotNull(lin.getX2());  // make sure r is not null
        assertNotEquals(" ", qq.getX2()); // make sure r is not empty
        assertEquals(SaraAE, new Line("Sara",4,SaraX1,SaraY1,SaraX2,SaraY2).getX2());

    }
    /**
     * Test getter second coordinate y
     */
    @Test
    void getY2() {
        //Y2 cannot be empty or null
        assertNotNull(lin.getY2());
        assertNotEquals(" ", qq.getY2());
        assertEquals(HenryE, new Line("Henry", 1, HenryX1,HenryY1,HenryX2,HenryY2).getY2());
    }

    /**
     * Test leading coefficient of the line
     */
    @Test
    void leadCoef() {
        assertEquals(1,new Line("Lem",1,LemX1,LemY1,LemX2,LemY2).leadCoef());
        assertEquals(1,new Line("Lemmy",4,LemmyX1,LemmyY1,LemmyX2,LemmyY2).leadCoef());


    }
    /**
     * Test Ordinate at the origin of this line
     */
    @Test
    void b() {
        assertEquals(5,new Line("Karen",3,KarenX1,KarenY1,KarenX2,KarenY2).b());
        assertEquals(KerryAE,new Line("Kerry",4,KerryX1,KerryY1,KerryX2,KerryY2).b());
    }

    /**
     * Test move the line
     */
    @Test
    void move() {
        //max_coordinate_x can be negative, positive and 0
        lin.move(4,5);
        assertEquals(8,lin.getX());
        assertEquals(linAEX2,lin.getX2());
        assertEquals(7,lin.getY());
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
        //max_coordinate_x can be negative, positive and 0
        assertEquals(9, new Line("borat",7,boratX1,boratY1,boratX2,boratY2).max_coordinate_x());
        assertEquals(KhanAE, new Line("Khan",8,KhanX1,5.0f,12.0f,8.0f).max_coordinate_x());
    }
    /**
     * Test getter max coordinate y of the line
     */
    @Test
    void max_coordinate_y() {
        assertEquals(16, new Line("Peter",8,12.0f,15.0f,17.0f,16.0f).max_coordinate_y());
        assertEquals(23, new Line("Parker",6,15.0f,23.0f,15.0f,17.0f).max_coordinate_y());
    }
    /**
     * Test getter min coordinate x of the line
     */
    @Test
    void min_coordinate_x() {
        assertEquals(13, new Line("Dennis",9, 13.0f, 24.0f,17.0f, 19.0f).min_coordinate_x());
        assertEquals(13, new Line("Dennis",9, 27.0f, 23.0f,13.0f, 12.0f).min_coordinate_x());
    }
    /**
     * Test getter min coordinate y of the line
     */
    @Test
    void min_coordinate_y() {
        assertEquals(32, new Line("Jenny",9, 45.0f, 32.0f,54.0f, 73.0f).min_coordinate_y());
        assertEquals(21, new Line("Dennis",9, 45.0f, 21.0f,42.0f, 32.0f).min_coordinate_y());
    }
    /**
     * Test getter min coordinate x of the line
     */
    @Test
    void distancePoint() {
        assertFalse(lin.distancePoint(3.0f,6.0f));
        assertTrue(gaut.distancePoint(3.0f,7.96f));
        assertFalse(gaut.distancePoint(16,2));
        assertTrue(marion.distancePoint(10.0f,2.0f));
        assertFalse(marion.distancePoint(33,1));
        assertTrue(romain.distancePoint(10.0f,6.0f));
        assertFalse(romain.distancePoint(1,1));


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