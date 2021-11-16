package hk.edu.polyu.comp.comp2021.clevis.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Clevis {

    public Clevis() {
        boolean bool = false;
        Nbshapecreate nbCreate = new Nbshapecreate();
        Path file = Path.of("//Users//gauthiermarre//Project.txt");
        Path vile = Path.of("//Users//gauthiermarre//Project.html");


        System.out.println("__________________________________________________________________________");
        System.out.println("|                                                                        |");
        System.out.println("|  Hi Friends! Welcome to Command LinE Vector graphIcs Software (CLEVIS) |");
        System.out.println("|                                                                        |");
        System.out.println("|_______________Follow this format to create a shape:____________________|");
        System.out.println("|                                                                        |");
        System.out.println("|    1. Line: [line][li_ne][x1][y2][x1][y2] where x1,y1,x2,y2 are int    |");
        System.out.println("|    2. Rectangle: [rectangle][rec][x][y][w][h] where x,y,w,h are int    |");
        System.out.println("|    3. Circle: [circle][cir][x][y][r] where x,y,r are int               |");
        System.out.println("|    4. Square: [square][s][x][y][l] where x,y,r are int                 |");
        System.out.println("|________________________________________________________________________|");
        GUI gui = new GUI();


        while (!bool)
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader bfr = new BufferedReader(isr);
                System.out.println("What do you want to create ?");
                String commandUser = bfr.readLine();
                Files.writeString(file, "||" + commandUser + System.lineSeparator() + "\r\n" , StandardOpenOption.APPEND);
                Files.writeString(vile, "||" + commandUser + System.lineSeparator() + "\r\n" , StandardOpenOption.APPEND);
                System.out.println("Your command is : " + commandUser);
                Command_process command = new Command_process(commandUser,listShapeAll,listGroup, nbCreate);
                gui.drawFinal(listShapeAll);
            }
            catch (IOException e) {
               // e.printStackTrace();
                System.out.println("Please, try again");
            }
            catch (Fig_not_recognized f){
                System.out.println("Figure not recognized, please do it again");
            }
            catch (Name_already_used n){
                System.out.println("Name already been used, please do it again");
            }
            catch(FigureNotInGridError g){
                System.out.println("Your shape could not be drawn on the grid");
            }
            catch(Pick_and_move_Error pm){
                System.out.println("Pick and move impossible, no shape found in these coordinates");
            }
            catch (Exception e) {
                System.out.println("You've done a mistake writing your command");;
            }
    }

    private List<Shape> listShapeAll=new ArrayList<>();

    private List<Group> listGroup =new ArrayList<>();



    static class Fig_not_recognized extends Error{}

    static class Name_already_used extends Error{}

    static class FigureNotInGridError extends Error{}

    static class Pick_and_move_Error extends Error{}

}
