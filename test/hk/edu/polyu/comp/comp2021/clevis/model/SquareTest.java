package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    private Square Squid = new Square("Squid",3,3.0f,3.0f,3.0f);
    private Square Ken = new Square("Ken",7,7.0f,7.0f,7.0f);
    private Square Bobby = new Square("Bobby",2,2.0f,2.0f,2.0f);
    private Square Charlemagne = new Square("Charlemagne",1,1.0f,1.0f,1.0f);
    private Square Stan = new Square("Stan",4,4.0f,4.0f,4.0f);
    private Square Eli = new Square("Eli", 9,9.0f,9.0f,9.0f);
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void getL() {
        assertNotNull(Squid.getL());  // make sure r is not null
        assertNotEquals(" ", Squid.getL()); // make sure r is not empty
        assertTrue(Squid.getL() > 0); // to make sure the length not zero or negative
        assertFalse(Squid.getL() <= 0); // to make sure the length is not a zero or negative value
    }

    @Test
    public void listFigure() {
        Squid.listFigure();
        Assert.assertEquals("Square Name : Squid | Height : 3.0 | Coordinates : (3.0,3.0) |",outputStreamCaptor.toString().trim());
    }

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
    @Test
    void max_coordinate_y() {
        //max_coordinate_y() return getY()
        //max_coordinate_y can be a negative number or 0, as Y has a chance of being 0 or a negative number
        assertNotNull(Bobby.getY()); // Y coordinate can be negative, but must be given, not be Null or empty
        assertNotEquals(" ",Bobby.getY());
        assertEquals(164, new Square("Wally", 8, 6.0f, 74.0f,90.0f).max_coordinate_y());
        assertEquals(72, new Square("Sally", 6, 12.0f,12.0f, 60.0f).max_coordinate_y());
    }

    @Test
    void min_coordinate_x() {
        //min_coordinate_x() return getX()
        assertNotNull(Charlemagne.getX());// in this test x can be a negative number, but it must not be NULL or empty
        assertNotEquals(" ",Charlemagne.getX());
        assertEquals(54, new Square("Garry",7,54.0f,32.0f,43.0f).min_coordinate_x());
        assertEquals(88, new Square("Dominic", 4, 88.0f, 50.1f, 45.5f).min_coordinate_x());

    }

    @Test
    void min_coordinate_y() {
        //min_coordinate_y() return getY() - l
        //length cannot be negative and zero
        //min_coordinate_y() can be negative and 0, due to subtracting and Y having a chance of being 0 or negative
        // l cannot be 0 or negative
        //but the y-coordinate can be a negative number, since a subtraction is done, so there is a chance of y-coordinate being negative or even 0(origin)

        assertTrue(Eli.getL() > 0); // make sure Length is bigger than 0 and negative numbers
        assertFalse(Eli.getL() <= 0); // make sure length is bigger than 0 and negative numbers
        assertEquals(34, new Square("Eunice",3,90.0f,34.0f,2.0f).min_coordinate_y());
        assertEquals(2, new Square("Kelly", 1, 56.0f,2.0f,5.0f).min_coordinate_y());


    }
    @Test
    void distancePoint() {
        assertTrue(Eli.distancePoint(10.0f,10.0f));
        assertFalse(Stan.distancePoint(15.0f,16.0f));

    }

}