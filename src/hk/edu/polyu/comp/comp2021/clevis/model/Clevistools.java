package hk.edu.polyu.comp.comp2021.clevis.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Clevistools{
    public String welcomingDisplay(){

        String welcomingmessage= "";
        welcomingmessage = "__________________________________________________________________________\n" +
                "|                                                                        |\n" +
                "|  Hi Friends! Welcome to Command LinE Vector graphIcs Software (CLEVIS) |\n" +
                "|                                                                        |\n" +
                "|_______________Follow this format to create a shape:____________________|\n" +
                "|                                                                        |\n" +
                "|    1. Line: [line][li_ne][x1][y2][x1][y2] where x1,y1,x2,y2 are int    |\n" +
                "|    2. Rectangle: [rectangle][rec][x][y][w][h] where x,y,w,h are int    |\n" +
                "|    3. Circle: [circle][cir][x][y][r] where x,y,r are int               |\n" +
                "|    4. Square: [square][s][x][y][l] where x,y,r are int                 |\n" +
                "|________________________________________________________________________|";

        return welcomingmessage;
    }

    public String CommandUser(){
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What do you want to create ?");
        String commandUser = "";
        try {
            commandUser = bfr.readLine();
        } catch (IOException e) {
            System.out.println("Please, try again");
        }
        System.out.println("Your command is : " + commandUser);
        return commandUser;
    }

    public Path RetrieveTxt(String linepath){
        Path file = Path.of(linepath);
        return file;
    }

    public Path RetrieveHtml(String linepath){
        Path vile = Path.of(linepath);
        return vile;
    }

    public void WriteTxt(String command,Path file){
        try {
            Files.writeString(file, "||" + command + System.lineSeparator() + "\r\n" , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteHtml(String command,Path vile){
        try {
            Files.writeString(vile, "||" + command + System.lineSeparator() + "\r\n" , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
