package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Figure_geoTest {
    private double Dianax = 24.0;
    private Circle Diana = new Circle("Diana", 3, Dianax,23.0f,12.0f);
    private Line liny = new Line("liny",2,14.0f,15.0f,24.0f,34.0f);

    @Test
    void getX() {
        //x can be 0 or negative number but must be a float
        //x cannot be null and empty
        assertNotNull(Diana.getX());
        assertNotEquals(" ", Diana.getX());
        assertEquals(12, new Circle("Pete",4,12.0f,34.0f,15.0f).getX());
        assertEquals(-12, new Circle("Peter",4,-12.0f,34.0f,15.0f).getX());
        assertEquals(0, new Circle("Petey",4,0.0f,34.0f,15.0f).getX());
        assertEquals(12, new Rectangle("Pete",4,12.0f,34.0f,15.0f,12.0f).getX());

    }

    @Test
    void getY() {
        //y can be 0 or negative number
        //y cannot be null or empty
        assertNotNull(liny.getY());
        assertNotEquals(" ", liny.getY());
        assertEquals(12, new Square("Helen",1,43.0f,12.0f,51.0f).getY());
        assertEquals(45, new Rectangle("Amy", 3, 12.0f, 45.0f, 15.0f,45.0f).getY());
        assertEquals(32, new Circle("Jan", 2, 67.0f,32.0f,23.0f).getY());
    }

    @Test
    void setX() {
        //y can be 0 or negative number
        //y cannot be null or empty
        Diana.setX(18);
        assertEquals(18,Diana.getX());
    }

    @Test
    void setY() {
        //y can be 0 or negative number
        //y cannot be null or empty
        Diana.setY(23);
        assertEquals(23,Diana.getY());
    }
}