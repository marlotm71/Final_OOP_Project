package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    private int circlyZ = 3;
    private Circle circly = new Circle("cir",circlyZ,3.0f,3.0f ,3.0f);
    private Rectangle cirs = new Rectangle("cirs",4,4.0f,4.0f,4.0f,13.0f);
    private Circle Hans = new Circle("Hans",1,1.0f,1.0f,1.0f);
    private Shape[] listShapeGroup = new Shape[]{circly,cirs,Hans};
    private Group groupy = new Group("groupy",2,3,listShapeGroup);
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void getListShape() {
        assertEquals(listShapeGroup, groupy.getListShape());
    }

    @Test
    void getSize() {
        assertEquals(listShapeGroup.length, groupy.getSize());
    }

    @Test
    public void listFigure() {
        groupy.listFigure();
        Assert.assertEquals("Group Name = groupy composed by : \n   Circle Name : cir | Radius : 3.0 | Coordinates : (3.0,3.0) | \n   Rectangle Name : cirs | Height : 13.0 | Width : 4.0 | Coordinate Top Left Corner : (4.0,4.0) | \n   Circle Name : Hans | Radius : 1.0 | Coordinates : (1.0,1.0) |",outputStreamCaptor.toString().trim());
    }

    @Test
    void max_coordinate_x() {
        double groupmaxx = groupy.max_coordinate_x();
        assertEquals(8, groupmaxx);
    }

    @Test
    void max_coordinate_y() {
        double groupmaxy = groupy.max_coordinate_y();
        assertEquals(17,groupmaxy);
    }

    @Test
    void min_coordinate_x() {
        double groupminx = groupy.min_coordinate_x();
        assertEquals(0, groupminx);
    }

    @Test
    void min_coordinate_y() {
        double groupminy = groupy.min_coordinate_y();
        assertEquals(0, groupminy);
    }

    @Test
    void distancePoint() {
        assertTrue(groupy.distancePoint(100.0f,100.0f));
        assertFalse(groupy.distancePoint(3f,4f));
    }




}