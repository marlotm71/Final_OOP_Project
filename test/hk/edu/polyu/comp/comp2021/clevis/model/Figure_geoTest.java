package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class Figure_geo Test
 */
class Figure_geoTest {
    private final double Dianax;

    {
        Dianax = 24.0;
    }

    private final double Dianay;

    {
        Dianay = 23.0;
    }

    private final double Dianar;

    {
        Dianar = 12.0;
    }

    private final double linyx1;

    {
        linyx1 = 23.0;
    }

    private final double linyy1;

    {
        linyy1 = 15.0;
    }

    private final double linyx2;

    {
        linyx2 = 24.0;
    }

    private final double linyy2;

    {
        linyy2 = 34.0;
    }

    private final double PeteE;

    {
        PeteE = 12.0;
    }

    private final double PeteX;

    {
        PeteX = 12.0;
    }

    private final double PeteY;

    {
        PeteY = 34.0;
    }

    private final double PeteR;

    {
        PeteR = 15.0;
    }


    private final double PeterE;

    {
        PeterE = -12.0;
    }

    private final double PeterX;

    {
        PeterX = -12.0;
    }

    private final double PeterY;

    {
        PeterY = 34.0;
    }

    private final double PeterR;

    {
        PeterR = 15.0;
    }

    private final double PeteyY;

    {
        PeteyY = 34.0;
    }

    private final double PeteyR;

    {
        PeteyR = 15.0;
    }

    private final double Pete2E;

    {
        Pete2E = 12.0;
    }

    private final double Pete2X;

    {
        Pete2X = 12.0;
    }

    private final double Pete2Y;

    {
        Pete2Y = 34.0;
    }

    private final double Pete2W;

    {
        Pete2W = 15.0;
    }

    private final double Pete2H;

    {
        Pete2H = 12.0;
    }

    private final double HelenE;

    {
        HelenE = 12.0;
    }

    private final double HelenX;

    {
        HelenX = 43.0;
    }

    private final double HelenY;

    {
        HelenY = 12.0;
    }

    private final double HelenL;

    {
        HelenL = 51.0;
    }

    private final double AmyE;

    {
        AmyE = 45.0;
    }

    private final double AmyX;

    {
        AmyX = 12.0;
    }

    private final double AmyY;

    {
        AmyY = 45.0;
    }

    private final double AmyW;

    {
        AmyW = 15.0;
    }

    private final double AmyH;

    {
        AmyH = 45.0;
    }

    private final double JanE;

    {
        JanE = 32.0;
    }

    private final double JanX;

    {
        JanX = 67.0;
    }

    private final double JanY;

    {
        JanY = 32.0;
    }

    private final double JanR;

    {
        JanR = 23.0;
    }

    private final double DianaSX;

    {
        DianaSX = 18.0;
    }

    private final double DianaAE;

    {
        DianaAE = 18.0;
    }

    private final double DianaSY;

    {
        DianaSY = 23.0;
    }

    private final double DianaAEY;
    {
        DianaAEY = 23.0;
    }

    private final double Dianay;
    {
        Dianay = 23.0;
    }

    private Circle Diana = new Circle("Diana", 3, Dianax,Dianay,Dianar);
    private Line liny = new Line("liny",2,linyx1,linyy1,linyx2,linyy2);

    /**
     * test getter coordinate x
     */
    @Test
    void getX() {
        //x can be 0 or negative number but must be a float
        //x cannot be null and empty
        assertNotNull(Diana.getX());
        assertNotEquals(" ", Diana.getX());
        assertEquals(PeteE, new Circle("Pete",4,PeteX,PeteY,PeteR).getX());
        assertEquals(PeterE, new Circle("Peter",4,PeterX,PeterY,PeterR).getX());
        assertEquals(0, new Circle("Petey",4,0.0f,PeteyY,PeteyR).getX());
        assertEquals(Pete2E, new Rectangle("Pete",4,Pete2X,Pete2Y,Pete2W,Pete2H).getX());

    }

    /**
     * Test getter coordinate y
     */
    @Test
    void getY() {
        //y can be 0 or negative number
        //y cannot be null or empty
        assertNotNull(liny.getY());
        assertNotEquals(" ", liny.getY());
        assertEquals(HelenE, new Square("Helen",1,HelenX,HelenY,HelenL).getY());
        assertEquals(AmyE, new Rectangle("Amy", 3, AmyX, AmyY, AmyW,AmyH).getY());
        assertEquals(JanE, new Circle("Jan", 2, JanX,JanY,JanR).getY());
    }

    /**
     * Test setter coordinate x
     */
    @Test
    void setX() {
        //y can be 0 or negative number
        //y cannot be null or empty
        Diana.setX(DianaSX);
        assertEquals(DianaAE,Diana.getX());
    }

    /**
     * Test setter coordinate y
     */
    @Test
    void setY() {
        //y can be 0 or negative number
        //y cannot be null or empty
        Diana.setY(DianaSY);
        assertEquals(DianaAEY,Diana.getY());
    }
}