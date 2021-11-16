package hk.edu.polyu.comp.comp2021.clevis.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Command_processTest {
    String commandRect = "rectangle rec 4 9 4 3";
    String commandCir = "circle cir 5 4 2";
    String commandLine = "line lin 4 8 9 4";
    String commandSquare = "square squ 2 3 3";
    String commandGroup = "group n rec cir";
    String commandUngroup = "ungroup n";
    String commandPick_and_move = "pick-and-move 3 4 5 5";
    String commandMove = "move lin 4 4";
    String commandDelete = "delete squ";
    String commandBoundingbox = "boundingbox cir";
    String commandIntersect = "intersect squ cir";
    String commandList = "list rect";
    String commandListAll = "listAll";
    private Line vincent = new Line("lin",3, 4.0f, 8f, 9f, 4f);
    private Circle circle = new Circle("cir", 2, 5, 4, 2);
    private Circle circle2 = new Circle("cir2", 2, 3, 3, 3);
    private Square squa = new Square("squ", 2,2, 3, 3);
    private Rectangle rectangle = new Rectangle("rec", 4,4, 9, 4, 3);

    private List<Shape> listShapeAll = new ArrayList<>();
    private List<Group> listGroup = new ArrayList<>();
    private Shape[] listShapeGroup = new Shape[]{rectangle,circle};
    private Group groupy = new Group("n",2,2,listShapeGroup);

    @Test
    public void command_Process(){
        Command_process command = new Command_process(commandRect,listShapeAll,listGroup);
        Rectangle rect = (Rectangle) listShapeAll.get(0);
        assertEquals(rectangle.getX(),rect.getX());
        assertEquals(rectangle.getY(),rect.getY());
        assertEquals(rectangle.getH(),rect.getH());
        assertEquals(rectangle.getW(),rect.getW());
        assertEquals(rectangle.getName(),rect.getName());
        Command_process command2 = new Command_process(commandCir,listShapeAll,listGroup);
        Circle cir = (Circle) listShapeAll.get(1);
        assertEquals(circle.getX(), cir.getX());
        assertEquals(circle.getY(), cir.getY());
        assertEquals(circle.getR(), cir.getR());
        assertEquals(circle.getName(), cir.getName());
        Command_process command3 = new Command_process(commandLine,listShapeAll,listGroup);
        Line line = (Line) listShapeAll.get(2);
        assertEquals(vincent.getX(), line.getX());
        assertEquals(vincent.getY(), line.getY());
        assertEquals(vincent.getX2(), line.getX2());
        assertEquals(vincent.getY2(), line.getY2());
        assertEquals(vincent.getName(), line.getName());
        Command_process command4 = new Command_process(commandSquare,listShapeAll,listGroup);
        Square square = (Square) listShapeAll.get(3);
        assertEquals(squa.getX(), square.getX());
        assertEquals(squa.getY(), square.getY());
        assertEquals(squa.getL(), square.getL());
        assertEquals(squa.getName(), square.getName());
        Command_process command5 = new Command_process(commandGroup,listShapeAll,listGroup);
        Group group = (Group) listShapeAll.get(2); // Second Position because we've removed the rectangle and the circle of ListShapeAll
        Rectangle recgroupinit = (Rectangle) groupy.getListShape()[0];
        Rectangle recgroupfin = (Rectangle) group.getListShape()[0];
        assertEquals(recgroupinit.getX(), recgroupfin.getX());
        assertEquals(recgroupinit.getY(), recgroupfin.getY());
        assertEquals(recgroupinit.getH(), recgroupfin.getH());
        assertEquals(recgroupinit.getW(), recgroupfin.getW());
        assertEquals(recgroupinit.getName(), recgroupfin.getName());
        Command_process command6 = new Command_process(commandUngroup,listShapeAll,listGroup);
        Square squareafterungroup = (Square) listShapeAll.get(1);
        assertEquals(squa.getX(), squareafterungroup.getX());
        assertEquals(squa.getY(), squareafterungroup.getY());
        assertEquals(squa.getL(), squareafterungroup.getL());
        assertEquals(squa.getName(), squareafterungroup.getName());
        Line lineafterungroup = (Line) listShapeAll.get(0);
        assertEquals(vincent.getX(), lineafterungroup.getX());
        assertEquals(vincent.getY(), lineafterungroup.getY());
        assertEquals(vincent.getX2(), lineafterungroup.getX2());
        assertEquals(vincent.getY2(), lineafterungroup.getY2());
        assertEquals(vincent.getName(), lineafterungroup.getName());
        Rectangle rectafterungroup = (Rectangle) listShapeAll.get(2);
        assertEquals(rectangle.getX(), rectafterungroup.getX());
        assertEquals(rectangle.getY(), rectafterungroup.getY());
        assertEquals(rectangle.getH(), rectafterungroup.getH());
        assertEquals(rectangle.getW(), rectafterungroup.getW());
        assertEquals(rectangle.getName(), rectafterungroup.getName());
        Command_process command7 = new Command_process(commandPick_and_move,listShapeAll,listGroup);
    }

    @Test
    void generalIntersect() {
    }

    @Test
    void checkNameAvailability() {
    }

    @Test
    void checkPositive() {
    }
}