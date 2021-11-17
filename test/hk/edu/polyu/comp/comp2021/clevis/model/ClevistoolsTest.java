package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClevistoolsTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Clevistools tools = new Clevistools();

    @Test
    public void welcomingDisplay(){
        String welcome = tools.welcomingDisplay();
        Assert.assertEquals("__________________________________________________________________________\n" +
                "|                                                                        |\n" +
                "|  Hi Friends! Welcome to Command LinE Vector graphIcs Software (CLEVIS) |\n" +
                "|                                                                        |\n" +
                "|_______________Follow this format to create a shape:____________________|\n" +
                "|                                                                        |\n" +
                "|    1. Line: [line][li_ne][x1][y2][x1][y2] where x1,y1,x2,y2 are int    |\n" +
                "|    2. Rectangle: [rectangle][rec][x][y][w][h] where x,y,w,h are int    |\n" +
                "|    3. Circle: [circle][cir][x][y][r] where x,y,r are int               |\n" +
                "|    4. Square: [square][s][x][y][l] where x,y,r are int                 |\n" +
                "|________________________________________________________________________|",welcome);
    }

}