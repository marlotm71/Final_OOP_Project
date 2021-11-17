package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Figure_geoTest {
    private double Dianax = 24.0;
    private double Dianay = 23.0;
    private double Dianar = 12.0;
    private double linyx1 = 14.0;
    private double linyy1 = 15.0f;
    private double linyx2 = 24.0;
    private double linyy2 = 34.0;
    private double PeteE = 12.0;
    private double Petex = 12.0;
    private double Petey = 34.0;
    private double Peter = 15.0;
    private double PeterE = -12.0;
    private double PeterX = -12.0;
    private double PeterY = 34.0;
    private double PeterR = 15.0;
    private double PeteyY = 34.0;
    private double PeteyR = 15.0;
    private double PeteE2 = 12.0;
    private double PeteX2 = 12.0;
    private double PeteY2 = 34.0;
    private double PeteW2 = 15.0;
    private double PeteH2 = 12.0;
    private double HelenE = 12.0;
    private double HelenX = 43.0;
    private double HelenY = 12.0;
    private double HelenL = 51.0;
    private double AmyE = 45.0;
    private double AmyX = 12.0;
    private double AmyY = 45.0;
    private double AmyW = 15.0;
    private double AmyH = 45.0;
    private double JanH = 32.0;
    private double JanX = 67.0;
    private double JanY = 32.0;
    private double JanR = 23.0;
    private double DianaS = 18.0;
    private double DianaE = 18.0;
    private double Diana2S = 23.0;
    private double Diana2E = 23.0;


    private Circle Diana = new Circle("Diana", 3, Dianax,Dianay,Dianar);
    private Line liny = new Line("liny",2,linyx1,linyy1,linyx2,linyy2);

    @Test
    void getX() {
        //x can be 0 or negative number but must be a float
        //x cannot be null and empty
        assertNotNull(Diana.getX());
        assertNotEquals(" ", Diana.getX());
        assertEquals(PeteE, new Circle("Pete",4,Petex,Petey,Peter).getX());
        assertEquals(PeterE, new Circle("Peter",4,PeterX,PeterY,PeterR).getX());
        assertEquals(0, new Circle("Petey",4,0.0f,PeteyY,PeteyR).getX());
        assertEquals(PeteE2, new Rectangle("Pete",4,PeteX2,PeteY2,PeteW2,PeteH2).getX());

    }

    @Test
    void getY() {
        //y can be 0 or negative number
        //y cannot be null or empty
        assertNotNull(liny.getY());
        assertNotEquals(" ", liny.getY());
        assertEquals(HelenE, new Square("Helen",1,HelenX,HelenY,HelenL).getY());
        assertEquals(AmyE, new Rectangle("Amy", 3, AmyX, AmyY, AmyW,AmyH).getY());
        assertEquals(JanH, new Circle("Jan", 2, JanX,JanY,JanR).getY());
    }

    @Test
    void setX() {
        //y can be 0 or negative number
        //y cannot be null or empty
        Diana.setX(DianaS);
        assertEquals(DianaE,Diana.getX());
    }

    @Test
    void setY() {
        //y can be 0 or negative number
        //y cannot be null or empty
        Diana.setY(Diana2S);
        assertEquals(Diana2E,Diana.getY());
    }
}