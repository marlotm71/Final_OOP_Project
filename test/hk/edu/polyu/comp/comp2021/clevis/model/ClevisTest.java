package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClevisTest {

    String commandRect = "rectangle rec 4 9 4 3";
    String commandCir = "circle cir 5 4 2";
    String line = "line lin 4 8 9 4";
    String square = "square squ 2 3 3";
    String group = "group n rec cir";
    String ungroup = "ungroup n";
    String pick_and_move = "pick-and-move 3 4 5 5";
    String move = "move lin 4 4";
    String delete = "delete squ";
    String boundingbox = "boundingbox cir";
    String intersect = "intersect squ cir";
    String list = "list rect";
    String listAll = "listAll";
    private Line vincent = new Line("Vincent",3, 4.0f, 8f, 9f, 4f);
    private Circle circle = new Circle("Circle", 2, 5, 4, 2);
    private Square squa = new Square("Square", 2,2, 3, 3);
    private Rectangle rectangle = new Rectangle("Rectangle", 4,4, 9, 4, 3);


    @Test
    public void command_Process(){
        ;

    }

}