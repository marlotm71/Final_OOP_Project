package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    private double circlyx = 3.0;
    private double circlyy = 3.0;
    private double circlyr = 3.0;
    private double cirsx = 4.0;
    private double cirsy = 4.0;
    private double cirsw = 4.0;
    private double cirsh = 13.0;
    private double groupmaxyE = 17.0;



    private int circlyZ = 3;
    private Circle circly = new Circle("cir",circlyZ,circlyx,circlyy ,circlyr);
    private Rectangle cirs = new Rectangle("cirs",4,cirsx,cirsy,cirsw,cirsh);
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
    public void move() {
        groupy.move(2,4);
        Circle circleOfGroupby = (Circle) groupy.getListShape()[0];
        assertEquals(5, circleOfGroupby.getX());
        assertEquals(7, circleOfGroupby.getY());
    }

    @Test
    void max_coordinate_x() {
        double groupmaxx = groupy.max_coordinate_x();
        assertEquals(8, groupmaxx);
    }

    @Test
    void max_coordinate_y() {
        double groupmaxy = groupy.max_coordinate_y();
        assertEquals(groupmaxyE,groupmaxy);
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
        final double point1x = 6;
        final double point1y =5;
        final double point2x = 13;
        final double point2y = 3;
        assertTrue(groupy.distancePoint(point1x,point1y));
        assertFalse(groupy.distancePoint(point2x,point2y));
    }




}