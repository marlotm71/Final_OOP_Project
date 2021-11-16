package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {
    private Circle Pat = new Circle("Pat",2,5.0f,7.0f,10.f);
    private Rectangle Jim = new Rectangle("Kyle",4,9.0f,12.0f,23.0f,14.0f);
    private Line lin = new Line("Lin",2,43.0f,12.0f,13.0f,15.0f);
    private Square Eli = new Square("Eli", 9,9.0f,9.0f,9.0f);
    private Rectangle Tim = new Rectangle("Tim",5,5.0f,5.0f,5.0f,5.0f);
    private Circle Cleofe = new Circle("Cleofe",10,10.0f,10.0f,10.0f);
    @Test
    void getzOrder() {
        //zOrder should not be null or empty
        assertNotNull(Pat.getzOrder());
        assertNotEquals(" ", Jim.getzOrder());
        assertEquals(1,new Line("lin",1,2.0f,3.0f,4.0f,5.0f).getzOrder());
        assertEquals(2,new Circle("Kimmy",2,1.0f,4.0f,3.0f).getzOrder());
    }

    @Test
    void getName() {
        //name should not be null or empty
        assertNotNull(lin.getName());
        assertNotEquals(" ", lin.getName());
        assertEquals("lin",new Line("lin",1,2.0f,3.0f,4.0f,5.0f).getName());
        assertEquals("Doyle", new Rectangle("Doyle",4,13.0f,35.0f,14.0f,10.0f).getName());

    }

    @Test
    void max_coordinate_x() {
        assertEquals(16, new Square("Her", 6,13.0f,7.0f,3.0f).max_coordinate_x());
        assertEquals(12,new Rectangle("Dobry",7,5.0f,7.0f,7.0f,5.0f).max_coordinate_x());
        assertEquals(12.0, new Line("Khan",8,12.0f,5.0f,12.0f,8.0f).max_coordinate_x());
        assertEquals(2,new Circle("Den",1,1.0f,1.0f,1.0f).max_coordinate_x());
    }

    @Test
    void max_coordinate_y() {
        assertEquals(5,new Circle("Cam",1,1.0f,3.0f,2.0f).max_coordinate_y());
        assertEquals(23, new Line("Parker",6,15.0f,23.0f,15.0f,17.0f).max_coordinate_y());
        assertEquals(14,new Rectangle("Game",4,5.0f,12.0f,9.0f,2.0f).max_coordinate_y());
        assertEquals(72, new Square("Sally", 6, 12.0f,12.0f, 60.0f).max_coordinate_y());



    }

    @Test
    void min_coordinate_x() {
        assertEquals(1,new Circle("Joseph",1,3.0f,5.0f,2.0f).min_coordinate_x());
        assertEquals(13, new Line("Dennis",9, 13.0f, 24.0f,17.0f, 19.0f).min_coordinate_x());
        assertEquals(10,new Rectangle("Bob",5,10.0f,6.9f,12.0f,3.9f).min_coordinate_x());
        assertEquals(88, new Square("Dominic", 4, 88.0f, 50.1f, 45.5f).min_coordinate_x());


    }

    @Test
    void min_coordinate_y() {
        assertEquals(10,new Circle("Danny",1,3.0f,15.0f,5.0f).min_coordinate_y());
        assertEquals(32, new Line("Jenny",9, 45.0f, 32.0f,54.0f, 73.0f).min_coordinate_y());
        assertEquals(28, new Rectangle("Kam",9,8.0f,28.0f,11.0f,31.0f).min_coordinate_y());
        assertEquals(34, new Square("Eunice",3,90.0f,34.0f,2.0f).min_coordinate_y());

    }

    @Test
    void distancePoint() {
        assertFalse(Eli.distancePoint(10.0f,10.0f));
        assertFalse(Tim.distancePoint(5.0f,5.0f));
        assertTrue(Cleofe.distancePoint(4.0f,9.0f));

    }
}