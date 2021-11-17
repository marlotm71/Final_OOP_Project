package hk.edu.polyu.comp.comp2021.clevis.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
/**
 * Class Clevistools : Tools used in Clevis
 */
public class Clevistools{
    /**
     * Welcoming message display at the beginning
     * @return String which is the message
     */
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

    /**
     * Command created by the user
     * @return String command like : Rectangle rect 6 5 4 3
     */
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

    /**
     * Retrieve the .txt file
     * @param linepath of the file
     * @return Path which is the Path of our txt to be used after
     */
    public Path RetrieveTxt(String linepath){
        Path file = Path.of(linepath);
        return file;
    }

    /**
     * Retrieve the .html file
     * @param linepath of the file
     * @return Path which is the Path of our txt to be used after
     */
    public Path RetrieveHtml(String linepath){
        Path vile = Path.of(linepath);
        return vile;
    }

    /**
     * To Write in the txt file
     * @param command,Path we give one command and a file and we write the command on the file
     * @param file we return the file modified
     */
    public void WriteTxt(String command,Path file){
        try {
            Files.writeString(file, "||" + command + System.lineSeparator() + "\r\n" , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * To Write in the html file
     * @param command,Path we give one command and a file and we write the command on the file
     * @param vile we return the file modified
     */
    public void WriteHtml(String command,Path vile){
        try {
            Files.writeString(vile, "||" + command + System.lineSeparator() + "<br>" , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
