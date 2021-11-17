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
    private double x1lin = 4;
    private Line lin = new Line("Kim", 2, x1lin,2.0f,8.0f,7.0f);
    private Line gaut= new Line("Gaut", 2, 2.0f,7.0f,5.0f,10.0f);
    private Line marion= new Line("Marion", 2, 8.0f,2.0f,13.0f,2.0f);
    private Line gaut1= new Line("Gaut1", 2, 3.0f,2.0f,7.0f,7.0f);
    private Line marion1= new Line("Marion1", 2, 3.0f,4.0f,7.0f,4.0f);
    private Line romain= new Line("Romain", 2, 10.0f,4.0f,10.0f,8.0f);
    private Line qq = new Line("Yanny",3, 5.0f, 7.8f, 12.0f, 13.0f);
    private Line vincent = new Line("Vincent",3, 4.0f, 8f, 9f, 4f);
    private Line jean = new Line("Jean",3, 4.0f, 6f, 4f, 12f);
    private Line paul = new Line("Paul",3, 3, 10, 6, 10);
    private Line therese = new Line("Therese",3, 2, 6, 2, 12);
    private Line pierre = new Line("Pierre",3, 4, 5, 9, 5);
    private Line flavie = new Line("Flavie",3, 4, 11, 4, 15);
    private Line claude = new Line("Claude",3, 1, 4, 5, 4);
    private Line bernard = new Line("Bernard",3, 4, 8, 4, 10);
    private Line Jacque = new Line("Jacque",3, 4, 16, 4, 19);
    private Line dd = new Line("DD",3, 3, 14, 1, 16);
    private Circle circle = new Circle("Circle", 2, 5, 4, 2);
    private Circle circle2 = new Circle("Circle2", 2, 4, 9, 2);
    private Circle circle3 = new Circle("Circle3", 2, 4, 17, 3);
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
        assertEquals(13, new Line("Sara",4,12.0f,32.0f,13.0f,26.0f).getX2());

    }
    /**
     * Test getter second coordinate y
     */
    @Test
    void getY2() {
        //Y2 cannot be empty or null
        assertNotNull(lin.getY2());
        assertNotEquals(" ", qq.getY2());
        assertEquals(34, new Line("Henry", 1, 33.0f,12.0f,54.0f,34.0f).getY2());
    }

    /**
     * Test leading coefficient of the line
     */
    @Test
    void leadCoef() {
        assertEquals(1,new Line("Lem",1,32.0f,32.0f,32.0f,32.0f).leadCoef());
        assertEquals(1,new Line("Lemmy",4,15.0f,20.0f,25.0f,30.0f).leadCoef());


    }
    /**
     * Test Ordinate at the origin of this line
     */
    @Test
    void b() {
        assertEquals(5,new Line("Karen",3,15.0f,20.0f,35.0f,40.0f).b());
        assertEquals(28,new Line("Kerry",4,15.0f,25.0f,40.0f,20.0f).b());
    }

    /**
     * Test move the line
     */
    @Test
    void move() {
        //max_coordinate_x can be negative, positive and 0
        lin.move(4,5);
        assertEquals(8,lin.getX());
        assertEquals(12,lin.getX2());
        assertEquals(7,lin.getY());
        assertEquals(12,lin.getY2());

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
        assertEquals(9, new Line("borat",7,3.0f,12.0f,9.0f,34.0f).max_coordinate_x());
        assertEquals(12.0, new Line("Khan",8,12.0f,5.0f,12.0f,8.0f).max_coordinate_x());
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