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
        Clevistools tools = new Clevistools();

        Path file = tools.RetrieveTxt("//Users//gauthiermarre//Project.txt");
        Path vile = tools.RetrieveHtml("//Users//gauthiermarre//Project.html");

        String welcome = tools.welcomingDisplay();
        System.out.println(welcome);
        GUI gui = new GUI();


        while (!bool)
            try {
                String commandUser = tools.CommandUser();
                tools.WriteTxt(commandUser,file);
                tools.WriteHtml(commandUser,vile);
                Command_process command = new Command_process(commandUser,listShapeAll,listGroup, nbCreate);
                gui.drawFinal(listShapeAll);
            } catch (Fig_not_recognized f){
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
