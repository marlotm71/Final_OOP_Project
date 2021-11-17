package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe Shape Test
 */
class ShapeTest {
    private final int patzorder =  2;
    private final double patx = 5;
    private final double paty = 7;
    private final double patr = 10;
    private final int jimzorder =  2;
    private final double jimx = 9;
    private final double jimy = 12;
    private final double jimw = 23;
    private final double jimh = 14;
    private final int linzorder =  2;
    private final double linx = 43;
    private final double liny = 12;
    private final double linx2 = 13;
    private final double liny2 = 15;
    private final int Elizorder =  3;
    private final double Elix = 9;
    private final double Eliy = 9;
    private final double Elil = 9;
    private final int Timzorder =  5;
    private final double Timx = 5;
    private final double Timy = 5;
    private final double Timw = 5;
    private final double Timh = 5;
    private final int Cleofezorder =  10;
    private final double Cleofex = 10;
    private final double Cleofey = 10;
    private final double Cleofer = 10;
    private Circle Pat = new Circle("Pat",patzorder,patx,paty,patr);
    private Rectangle Jim = new Rectangle("Kyle",jimzorder,jimx,jimy,jimw,jimh);
    private Line lin = new Line("Lin",linzorder,linx,liny,linx2,liny2);
    private Square Eli = new Square("Eli", Elizorder,Elix,Eliy,Elil);
    private Rectangle Tim = new Rectangle("Tim",Timzorder,Timx,Timy,Timw,Timh);
    private Circle Cleofe = new Circle("Cleofe",Cleofezorder,Cleofex,Cleofey,Cleofer);

    /**
     * Test getter ZOrder of this shape
     */
    @Test
    void getzOrder() {
        //zOrder should not be null or empty
        assertNotNull(Pat.getzOrder());
        assertNotEquals(" ", Jim.getzOrder());
        final double xpectededJimz = 2;
        final double xpectededCleofz = 10;
        assertEquals(xpectededJimz,Jim.getzOrder());
        assertEquals(xpectededCleofz,Cleofe.getzOrder());
    }
    /**
     * Test getter the name of this shape
     */
    @Test
    void getName() {
        //name should not be null or empty
        assertNotNull(lin.getName());
        assertNotEquals(" ", lin.getName());
        assertEquals("Lin",lin.getName());
        assertEquals("Kyle", Jim.getName());

    }
    /**
     * Test getter max coordinate x of this shape
     */
    @Test
    void max_coordinate_x() {
        final double xpectededElimaxx = 18;
        final double xpectededCleofmaxx = 20;
        final double xpectededlinmaxx = 43;
        final double xpectededTimmaxx = 10;
        assertEquals(xpectededElimaxx, Eli.max_coordinate_x());
        assertEquals(xpectededCleofmaxx,Cleofe.max_coordinate_x());
        assertEquals(xpectededlinmaxx, lin.max_coordinate_x());
        assertEquals(xpectededTimmaxx,Tim.max_coordinate_x());
    }
    /**
     * Test getter max coordinate y of this shape
     */
    @Test
    void max_coordinate_y() {
        final double xpectededCleofmaxy = 20;
        final double xpectededJimmaxy = 26;
        final double xpectededElimaxy= 18;
        final double xpectededPatmaxy= 17;
        assertEquals(xpectededCleofmaxy,Cleofe.max_coordinate_y());
        assertEquals(xpectededJimmaxy, Jim.max_coordinate_y());
        assertEquals(xpectededElimaxy,Eli.max_coordinate_y());
        assertEquals(xpectededPatmaxy, Pat.max_coordinate_y());
    }
    /**
     * Test getter min coordinate x of this shape
     */
    @Test
    void min_coordinate_x() {
        final double xpectededCleofminx = 0;
        final double xpectededJimminx= 9;
        final double xpectededEliminx= 9;
        final double xpectededPatminx= -5;
        assertEquals(xpectededCleofminx,Cleofe.min_coordinate_x());
        assertEquals(xpectededJimminx, Jim.min_coordinate_x());
        assertEquals(xpectededEliminx,Eli.min_coordinate_x());
        assertEquals(xpectededPatminx, Pat.min_coordinate_x());
    }
    /**
     * Test getter min coordinate y of this shape
     */
    @Test
    void min_coordinate_y() {
        final double xpectededCleofminy = 0;
        final double xpectededPatminy= -3;
        final double xpectededEliminy= 9;
        final double xpectededJimminy= 12;
        assertEquals(xpectededCleofminy,Cleofe.min_coordinate_y());
        assertEquals(xpectededPatminy, Pat.min_coordinate_y());
        assertEquals(xpectededEliminy, Eli.min_coordinate_y());
        assertEquals(xpectededJimminy, Jim.min_coordinate_y());

    }
}